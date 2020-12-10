package anywheresoftware.b4a.samples.tabhost;


import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class main extends Activity implements B4AActivity{
	public static main mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = true;
    public static WeakReference<Activity> previousOne;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        mostCurrent = this;
		if (processBA == null) {
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "anywheresoftware.b4a.samples.tabhost", "anywheresoftware.b4a.samples.tabhost.main");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (main).");
				p.finish();
			}
		}
        processBA.setActivityPaused(true);
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
        WaitForLayout wl = new WaitForLayout();
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(this, processBA, wl, true))
		    BA.handler.postDelayed(wl, 5);

	}
	static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "anywheresoftware.b4a.samples.tabhost", "anywheresoftware.b4a.samples.tabhost.main");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "anywheresoftware.b4a.samples.tabhost.main", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (main) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (main) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEventFromUI(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return main.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeydown", this, new Object[] {keyCode, event}))
            return true;
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeyup", this, new Object[] {keyCode, event}))
            return true;
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null)
            return;
        if (this != mostCurrent)
			return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        BA.LogInfo("** Activity (main) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        if (mostCurrent != null)
            processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        processBA.setActivityPaused(true);
        mostCurrent = null;
        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
            main mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (main) Resume **");
            if (mc != mostCurrent)
                return;
		    processBA.raiseEvent(mc._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}
    public void onRequestPermissionsResult(int requestCode,
        String permissions[], int[] grantResults) {
        for (int i = 0;i < permissions.length;i++) {
            Object[] o = new Object[] {permissions[i], grantResults[i] == 0};
            processBA.raiseEventFromDifferentThread(null,null, 0, "activity_permissionresult", true, o);
        }
            
    }



public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}
public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
return vis;}

private static BA killProgramHelper(BA ba) {
    if (ba == null)
        return null;
    anywheresoftware.b4a.BA.SharedProcessBA sharedProcessBA = ba.sharedProcessBA;
    if (sharedProcessBA == null || sharedProcessBA.activityBA == null)
        return null;
    return sharedProcessBA.activityBA.get();
}
public static void killProgram() {
     {
            Activity __a = null;
            if (main.previousOne != null) {
				__a = main.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(main.mostCurrent == null ? null : main.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

BA.applicationContext.stopService(new android.content.Intent(BA.applicationContext, alarma.class));
}
public anywheresoftware.b4a.keywords.Common __c = null;
public static int _alarmhours = 0;
public static int _alarmminutes = 0;
public static anywheresoftware.b4a.objects.NotificationWrapper _noti = null;
public anywheresoftware.b4a.objects.TabHostWrapper _tabhost1 = null;
public static int _nd = 0;
public static int _x = 0;
public static int _nl = 0;
public static int _r = 0;
public anywheresoftware.b4a.objects.ButtonWrapper _button1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbel01 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label3 = null;
public static long _fa = 0L;
public static long _fm = 0L;
public static String _rest = "";
public static String _ini = "";
public anywheresoftware.b4a.objects.ButtonWrapper _btnaceptar = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btncancelar = null;
public anywheresoftware.b4a.objects.ButtonWrapper _button2 = null;
public anywheresoftware.b4a.objects.SpinnerWrapper _spinner1 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnalarma = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btncancelalarm = null;
public anywheresoftware.b4a.objects.SpinnerWrapper _spinner2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label4 = null;
public anywheresoftware.b4a.samples.tabhost.alarma _alarma = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _rest1 = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _rest2 = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _conf1 = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _conf2 = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _alar1 = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _alar2 = null;
RDebugUtils.currentLine=131072;
 //BA.debugLineNum = 131072;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=131073;
 //BA.debugLineNum = 131073;BA.debugLine="Activity.LoadLayout(\"main\")";
mostCurrent._activity.LoadLayout("main",mostCurrent.activityBA);
RDebugUtils.currentLine=131074;
 //BA.debugLineNum = 131074;BA.debugLine="Dim rest1, rest2, conf1, conf2, alar1,alar2 As Bi";
_rest1 = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
_rest2 = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
_conf1 = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
_conf2 = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
_alar1 = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
_alar2 = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
RDebugUtils.currentLine=131075;
 //BA.debugLineNum = 131075;BA.debugLine="rest1 = LoadBitmap(File.DirAssets, \"rest1.png\")";
_rest1 = anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"rest1.png");
RDebugUtils.currentLine=131076;
 //BA.debugLineNum = 131076;BA.debugLine="rest2 = LoadBitmap(File.DirAssets, \"rest2.png\")";
_rest2 = anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"rest2.png");
RDebugUtils.currentLine=131077;
 //BA.debugLineNum = 131077;BA.debugLine="conf1 = LoadBitmap(File.DirAssets, \"conf1.png\")";
_conf1 = anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"conf1.png");
RDebugUtils.currentLine=131078;
 //BA.debugLineNum = 131078;BA.debugLine="conf2 = LoadBitmap(File.DirAssets, \"conf2.png\")";
_conf2 = anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"conf2.png");
RDebugUtils.currentLine=131079;
 //BA.debugLineNum = 131079;BA.debugLine="alar1 = LoadBitmap(File.DirAssets, \"alar1.png\")";
_alar1 = anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"alar1.png");
RDebugUtils.currentLine=131080;
 //BA.debugLineNum = 131080;BA.debugLine="alar2 = LoadBitmap(File.DirAssets, \"alar2.png\")";
_alar2 = anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"alar2.png");
RDebugUtils.currentLine=131082;
 //BA.debugLineNum = 131082;BA.debugLine="TabHost1.AddTabWithIcon (\"Resticción\", rest2, res";
mostCurrent._tabhost1.AddTabWithIcon(mostCurrent.activityBA,"Resticción",(android.graphics.Bitmap)(_rest2.getObject()),(android.graphics.Bitmap)(_rest1.getObject()),"page1");
RDebugUtils.currentLine=131083;
 //BA.debugLineNum = 131083;BA.debugLine="TabHost1.AddTabWithIcon (\"Configuración\", conf2,";
mostCurrent._tabhost1.AddTabWithIcon(mostCurrent.activityBA,"Configuración",(android.graphics.Bitmap)(_conf2.getObject()),(android.graphics.Bitmap)(_conf1.getObject()),"page2");
RDebugUtils.currentLine=131084;
 //BA.debugLineNum = 131084;BA.debugLine="TabHost1.AddTabWithIcon (\"Alarmas\", alar2, alar1,";
mostCurrent._tabhost1.AddTabWithIcon(mostCurrent.activityBA,"Alarmas",(android.graphics.Bitmap)(_alar2.getObject()),(android.graphics.Bitmap)(_alar1.getObject()),"page3");
RDebugUtils.currentLine=131085;
 //BA.debugLineNum = 131085;BA.debugLine="Spinner1.Add(\"0-1\")";
mostCurrent._spinner1.Add("0-1");
RDebugUtils.currentLine=131086;
 //BA.debugLineNum = 131086;BA.debugLine="Spinner1.Add(\"2-3\")";
mostCurrent._spinner1.Add("2-3");
RDebugUtils.currentLine=131087;
 //BA.debugLineNum = 131087;BA.debugLine="Spinner1.Add(\"4-5\")";
mostCurrent._spinner1.Add("4-5");
RDebugUtils.currentLine=131088;
 //BA.debugLineNum = 131088;BA.debugLine="Spinner1.Add(\"6-7\")";
mostCurrent._spinner1.Add("6-7");
RDebugUtils.currentLine=131089;
 //BA.debugLineNum = 131089;BA.debugLine="Spinner1.Add(\"8-9\")";
mostCurrent._spinner1.Add("8-9");
RDebugUtils.currentLine=131091;
 //BA.debugLineNum = 131091;BA.debugLine="Spinner2.Add(\"0-1\")";
mostCurrent._spinner2.Add("0-1");
RDebugUtils.currentLine=131092;
 //BA.debugLineNum = 131092;BA.debugLine="Spinner2.Add(\"2-3\")";
mostCurrent._spinner2.Add("2-3");
RDebugUtils.currentLine=131093;
 //BA.debugLineNum = 131093;BA.debugLine="Spinner2.Add(\"4-5\")";
mostCurrent._spinner2.Add("4-5");
RDebugUtils.currentLine=131094;
 //BA.debugLineNum = 131094;BA.debugLine="Spinner2.Add(\"6-7\")";
mostCurrent._spinner2.Add("6-7");
RDebugUtils.currentLine=131095;
 //BA.debugLineNum = 131095;BA.debugLine="Spinner2.Add(\"8-9\")";
mostCurrent._spinner2.Add("8-9");
RDebugUtils.currentLine=131097;
 //BA.debugLineNum = 131097;BA.debugLine="Spinner1.SelectedIndex=0";
mostCurrent._spinner1.setSelectedIndex((int) (0));
RDebugUtils.currentLine=131098;
 //BA.debugLineNum = 131098;BA.debugLine="Button1.Left=50%x-(Button1.Width/2)";
mostCurrent._button1.setLeft((int) (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (50),mostCurrent.activityBA)-(mostCurrent._button1.getWidth()/(double)2)));
RDebugUtils.currentLine=131099;
 //BA.debugLineNum = 131099;BA.debugLine="Button2.Left=50%x-(Button2.Width/2)";
mostCurrent._button2.setLeft((int) (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (50),mostCurrent.activityBA)-(mostCurrent._button2.getWidth()/(double)2)));
RDebugUtils.currentLine=131100;
 //BA.debugLineNum = 131100;BA.debugLine="Archivo";
_archivo();
RDebugUtils.currentLine=131101;
 //BA.debugLineNum = 131101;BA.debugLine="MostrarRestriccion(DateTime.Now)";
_mostrarrestriccion(anywheresoftware.b4a.keywords.Common.DateTime.getNow());
RDebugUtils.currentLine=131102;
 //BA.debugLineNum = 131102;BA.debugLine="End Sub";
return "";
}
public static String  _archivo() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "archivo", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "archivo", null));}
anywheresoftware.b4a.objects.streams.File.TextReaderWrapper _leer = null;
RDebugUtils.currentLine=393216;
 //BA.debugLineNum = 393216;BA.debugLine="Sub Archivo";
RDebugUtils.currentLine=393217;
 //BA.debugLineNum = 393217;BA.debugLine="Dim leer As TextReader";
_leer = new anywheresoftware.b4a.objects.streams.File.TextReaderWrapper();
RDebugUtils.currentLine=393218;
 //BA.debugLineNum = 393218;BA.debugLine="If File.Exists(File.DirInternal,\"cfgrest.txt\") Th";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"cfgrest.txt")) { 
RDebugUtils.currentLine=393219;
 //BA.debugLineNum = 393219;BA.debugLine="leer.Initialize(File.OpenInput (File.DirInternal";
_leer.Initialize((java.io.InputStream)(anywheresoftware.b4a.keywords.Common.File.OpenInput(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"cfgrest.txt").getObject()));
RDebugUtils.currentLine=393220;
 //BA.debugLineNum = 393220;BA.debugLine="ini = leer.ReadLine";
mostCurrent._ini = _leer.ReadLine();
RDebugUtils.currentLine=393221;
 //BA.debugLineNum = 393221;BA.debugLine="leer.Close";
_leer.Close();
 }else {
 };
RDebugUtils.currentLine=393226;
 //BA.debugLineNum = 393226;BA.debugLine="End Sub";
return "";
}
public static String  _mostrarrestriccion(long _fecha) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "mostrarrestriccion", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "mostrarrestriccion", new Object[] {_fecha}));}
int _clr = 0;
int _ltr = 0;
int _ind = 0;
int _i = 0;
String[] _pla = null;
String[] _num = null;
RDebugUtils.currentLine=524288;
 //BA.debugLineNum = 524288;BA.debugLine="Sub MostrarRestriccion (fecha As Long)";
RDebugUtils.currentLine=524289;
 //BA.debugLineNum = 524289;BA.debugLine="Dim clr, ltr, ind, i  As Int";
_clr = 0;
_ltr = 0;
_ind = 0;
_i = 0;
RDebugUtils.currentLine=524290;
 //BA.debugLineNum = 524290;BA.debugLine="Dim pla(5),num(5) As String";
_pla = new String[(int) (5)];
java.util.Arrays.fill(_pla,"");
_num = new String[(int) (5)];
java.util.Arrays.fill(_num,"");
RDebugUtils.currentLine=524294;
 //BA.debugLineNum = 524294;BA.debugLine="pla=Array As String(\"0-1\",\"2-3\",\"4-5\",\"6-7\",\"8-9\"";
_pla = new String[]{"0-1","2-3","4-5","6-7","8-9"};
RDebugUtils.currentLine=524295;
 //BA.debugLineNum = 524295;BA.debugLine="For i=0 To 4";
{
final int step4 = 1;
final int limit4 = (int) (4);
_i = (int) (0) ;
for (;_i <= limit4 ;_i = _i + step4 ) {
RDebugUtils.currentLine=524296;
 //BA.debugLineNum = 524296;BA.debugLine="If pla(i) = ini Then";
if ((_pla[_i]).equals(mostCurrent._ini)) { 
RDebugUtils.currentLine=524297;
 //BA.debugLineNum = 524297;BA.debugLine="ind=i";
_ind = _i;
RDebugUtils.currentLine=524298;
 //BA.debugLineNum = 524298;BA.debugLine="Exit";
if (true) break;
 };
 }
};
RDebugUtils.currentLine=524301;
 //BA.debugLineNum = 524301;BA.debugLine="For i=0 To 4";
{
final int step10 = 1;
final int limit10 = (int) (4);
_i = (int) (0) ;
for (;_i <= limit10 ;_i = _i + step10 ) {
RDebugUtils.currentLine=524302;
 //BA.debugLineNum = 524302;BA.debugLine="num(i)=pla(ind)";
_num[_i] = _pla[_ind];
RDebugUtils.currentLine=524303;
 //BA.debugLineNum = 524303;BA.debugLine="ind=ind+1";
_ind = (int) (_ind+1);
RDebugUtils.currentLine=524304;
 //BA.debugLineNum = 524304;BA.debugLine="If ind > 4 Then	ind=0";
if (_ind>4) { 
_ind = (int) (0);};
 }
};
RDebugUtils.currentLine=524307;
 //BA.debugLineNum = 524307;BA.debugLine="fa=fecha";
_fa = _fecha;
RDebugUtils.currentLine=524308;
 //BA.debugLineNum = 524308;BA.debugLine="nd = DateTime.GetDayOfYear(fa)	' Numero de dia de";
_nd = anywheresoftware.b4a.keywords.Common.DateTime.GetDayOfYear(_fa);
RDebugUtils.currentLine=524309;
 //BA.debugLineNum = 524309;BA.debugLine="nl=0";
_nl = (int) (0);
RDebugUtils.currentLine=524310;
 //BA.debugLineNum = 524310;BA.debugLine="For x=1 To nd";
{
final int step18 = 1;
final int limit18 = _nd;
_x = (int) (1) ;
for (;_x <= limit18 ;_x = _x + step18 ) {
RDebugUtils.currentLine=524311;
 //BA.debugLineNum = 524311;BA.debugLine="fm=DateTime.Add(fa, 0,0,-x)";
_fm = anywheresoftware.b4a.keywords.Common.DateTime.Add(_fa,(int) (0),(int) (0),(int) (-_x));
RDebugUtils.currentLine=524312;
 //BA.debugLineNum = 524312;BA.debugLine="If DateTime.GetDayOfWeek(fm) <> 1 Then  'Si es d";
if (anywheresoftware.b4a.keywords.Common.DateTime.GetDayOfWeek(_fm)!=1) { 
RDebugUtils.currentLine=524313;
 //BA.debugLineNum = 524313;BA.debugLine="nl=nl+1";
_nl = (int) (_nl+1);
 };
 }
};
RDebugUtils.currentLine=524316;
 //BA.debugLineNum = 524316;BA.debugLine="r=(nl Mod 5)-1";
_r = (int) ((_nl%5)-1);
RDebugUtils.currentLine=524317;
 //BA.debugLineNum = 524317;BA.debugLine="If r < 0 Then r=4";
if (_r<0) { 
_r = (int) (4);};
RDebugUtils.currentLine=524318;
 //BA.debugLineNum = 524318;BA.debugLine="Label3.Text=\"Horario restricción [ 7:30 a.m. - 7:";
mostCurrent._label3.setText(BA.ObjectToCharSequence("Horario restricción [ 7:30 a.m. - 7:30 p.m.]"));
RDebugUtils.currentLine=524321;
 //BA.debugLineNum = 524321;BA.debugLine="rest=num(r)";
mostCurrent._rest = _num[_r];
RDebugUtils.currentLine=524322;
 //BA.debugLineNum = 524322;BA.debugLine="If (rest = \"0-1\") Then";
if (((mostCurrent._rest).equals("0-1"))) { 
RDebugUtils.currentLine=524323;
 //BA.debugLineNum = 524323;BA.debugLine="clr=Colors.green";
_clr = anywheresoftware.b4a.keywords.Common.Colors.Green;
RDebugUtils.currentLine=524324;
 //BA.debugLineNum = 524324;BA.debugLine="ltr=Colors.Black";
_ltr = anywheresoftware.b4a.keywords.Common.Colors.Black;
 };
RDebugUtils.currentLine=524326;
 //BA.debugLineNum = 524326;BA.debugLine="If (rest = \"2-3\") Then";
if (((mostCurrent._rest).equals("2-3"))) { 
RDebugUtils.currentLine=524327;
 //BA.debugLineNum = 524327;BA.debugLine="clr=Colors.White";
_clr = anywheresoftware.b4a.keywords.Common.Colors.White;
RDebugUtils.currentLine=524328;
 //BA.debugLineNum = 524328;BA.debugLine="ltr=Colors.Black";
_ltr = anywheresoftware.b4a.keywords.Common.Colors.Black;
 };
RDebugUtils.currentLine=524330;
 //BA.debugLineNum = 524330;BA.debugLine="If (rest = \"4-5\") Then";
if (((mostCurrent._rest).equals("4-5"))) { 
RDebugUtils.currentLine=524331;
 //BA.debugLineNum = 524331;BA.debugLine="clr=Colors.Magenta";
_clr = anywheresoftware.b4a.keywords.Common.Colors.Magenta;
RDebugUtils.currentLine=524332;
 //BA.debugLineNum = 524332;BA.debugLine="ltr=Colors.Black";
_ltr = anywheresoftware.b4a.keywords.Common.Colors.Black;
 };
RDebugUtils.currentLine=524334;
 //BA.debugLineNum = 524334;BA.debugLine="If (rest = \"6-7\") Then";
if (((mostCurrent._rest).equals("6-7"))) { 
RDebugUtils.currentLine=524335;
 //BA.debugLineNum = 524335;BA.debugLine="clr=Colors.Yellow";
_clr = anywheresoftware.b4a.keywords.Common.Colors.Yellow;
RDebugUtils.currentLine=524336;
 //BA.debugLineNum = 524336;BA.debugLine="ltr=Colors.Black";
_ltr = anywheresoftware.b4a.keywords.Common.Colors.Black;
 };
RDebugUtils.currentLine=524338;
 //BA.debugLineNum = 524338;BA.debugLine="If (rest = \"8-9\") Then";
if (((mostCurrent._rest).equals("8-9"))) { 
RDebugUtils.currentLine=524339;
 //BA.debugLineNum = 524339;BA.debugLine="clr=Colors.Blue";
_clr = anywheresoftware.b4a.keywords.Common.Colors.Blue;
RDebugUtils.currentLine=524340;
 //BA.debugLineNum = 524340;BA.debugLine="ltr=Colors.White";
_ltr = anywheresoftware.b4a.keywords.Common.Colors.White;
 };
RDebugUtils.currentLine=524342;
 //BA.debugLineNum = 524342;BA.debugLine="If (DateTime.GetDayOfWeek(fa)=7) Or (DateTime.Get";
if ((anywheresoftware.b4a.keywords.Common.DateTime.GetDayOfWeek(_fa)==7) || (anywheresoftware.b4a.keywords.Common.DateTime.GetDayOfWeek(_fa)==1)) { 
RDebugUtils.currentLine=524343;
 //BA.debugLineNum = 524343;BA.debugLine="rest=\"No Aplica\"";
mostCurrent._rest = "No Aplica";
RDebugUtils.currentLine=524344;
 //BA.debugLineNum = 524344;BA.debugLine="clr=Colors.Gray";
_clr = anywheresoftware.b4a.keywords.Common.Colors.Gray;
 };
RDebugUtils.currentLine=524346;
 //BA.debugLineNum = 524346;BA.debugLine="Lbel01.Text=DateTime.Now";
mostCurrent._lbel01.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.DateTime.getNow()));
RDebugUtils.currentLine=524347;
 //BA.debugLineNum = 524347;BA.debugLine="If (fecha = DateTime.Now) Then";
if ((_fecha==anywheresoftware.b4a.keywords.Common.DateTime.getNow())) { 
RDebugUtils.currentLine=524348;
 //BA.debugLineNum = 524348;BA.debugLine="Lbel01.Text=\"Restricción para hoy:\"";
mostCurrent._lbel01.setText(BA.ObjectToCharSequence("Restricción para hoy:"));
 }else {
RDebugUtils.currentLine=524350;
 //BA.debugLineNum = 524350;BA.debugLine="Lbel01.Text=\"Restricción para:\"";
mostCurrent._lbel01.setText(BA.ObjectToCharSequence("Restricción para:"));
 };
RDebugUtils.currentLine=524352;
 //BA.debugLineNum = 524352;BA.debugLine="Label2.Text=FechaLarga(fa)";
mostCurrent._label2.setText(BA.ObjectToCharSequence(_fechalarga(_fa)));
RDebugUtils.currentLine=524353;
 //BA.debugLineNum = 524353;BA.debugLine="Button1.Text=rest";
mostCurrent._button1.setText(BA.ObjectToCharSequence(mostCurrent._rest));
RDebugUtils.currentLine=524354;
 //BA.debugLineNum = 524354;BA.debugLine="Button1.Color=clr";
mostCurrent._button1.setColor(_clr);
RDebugUtils.currentLine=524355;
 //BA.debugLineNum = 524355;BA.debugLine="Button1.TextColor=ltr";
mostCurrent._button1.setTextColor(_ltr);
RDebugUtils.currentLine=524356;
 //BA.debugLineNum = 524356;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _finishing) throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=196608;
 //BA.debugLineNum = 196608;BA.debugLine="Sub Activity_Pause (Finishing As Boolean)";
RDebugUtils.currentLine=196610;
 //BA.debugLineNum = 196610;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=262144;
 //BA.debugLineNum = 262144;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=262146;
 //BA.debugLineNum = 262146;BA.debugLine="End Sub";
return "";
}
public static String  _btnaceptar_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnaceptar_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnaceptar_click", null));}
anywheresoftware.b4a.objects.streams.File.TextWriterWrapper _escribir = null;
RDebugUtils.currentLine=458752;
 //BA.debugLineNum = 458752;BA.debugLine="Sub btnAceptar_Click";
RDebugUtils.currentLine=458753;
 //BA.debugLineNum = 458753;BA.debugLine="Dim escribir As TextWriter";
_escribir = new anywheresoftware.b4a.objects.streams.File.TextWriterWrapper();
RDebugUtils.currentLine=458755;
 //BA.debugLineNum = 458755;BA.debugLine="ini=Spinner1.SelectedItem";
mostCurrent._ini = mostCurrent._spinner1.getSelectedItem();
RDebugUtils.currentLine=458756;
 //BA.debugLineNum = 458756;BA.debugLine="escribir.Initialize(File.OpenOutput(File.DirInter";
_escribir.Initialize((java.io.OutputStream)(anywheresoftware.b4a.keywords.Common.File.OpenOutput(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"cfgrest.txt",anywheresoftware.b4a.keywords.Common.False).getObject()));
RDebugUtils.currentLine=458757;
 //BA.debugLineNum = 458757;BA.debugLine="escribir.Writeline(ini)";
_escribir.WriteLine(mostCurrent._ini);
RDebugUtils.currentLine=458758;
 //BA.debugLineNum = 458758;BA.debugLine="escribir.Close";
_escribir.Close();
RDebugUtils.currentLine=458759;
 //BA.debugLineNum = 458759;BA.debugLine="Archivo";
_archivo();
RDebugUtils.currentLine=458760;
 //BA.debugLineNum = 458760;BA.debugLine="MostrarRestriccion (DateTime.Now)";
_mostrarrestriccion(anywheresoftware.b4a.keywords.Common.DateTime.getNow());
RDebugUtils.currentLine=458761;
 //BA.debugLineNum = 458761;BA.debugLine="Msgbox2Async(\"Configuración guardada\",\"Configurar";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("Configuración guardada"),BA.ObjectToCharSequence("Configurar"),"Aceptar","","",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=458762;
 //BA.debugLineNum = 458762;BA.debugLine="TabHost1.CurrentTab=0";
mostCurrent._tabhost1.setCurrentTab((int) (0));
RDebugUtils.currentLine=458763;
 //BA.debugLineNum = 458763;BA.debugLine="End Sub";
return "";
}
public static String  _btnalarma_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnalarma_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnalarma_click", null));}
anywheresoftware.b4a.agraham.dialogs.InputDialog.TimeDialog _td = null;
long _alarm = 0L;
long _today = 0L;
int _h = 0;
int _m = 0;
RDebugUtils.currentLine=1769472;
 //BA.debugLineNum = 1769472;BA.debugLine="Sub BtnAlarma_Click";
RDebugUtils.currentLine=1769473;
 //BA.debugLineNum = 1769473;BA.debugLine="Dim td As TimeDialog";
_td = new anywheresoftware.b4a.agraham.dialogs.InputDialog.TimeDialog();
RDebugUtils.currentLine=1769474;
 //BA.debugLineNum = 1769474;BA.debugLine="Dim alarm As Long";
_alarm = 0L;
RDebugUtils.currentLine=1769475;
 //BA.debugLineNum = 1769475;BA.debugLine="td.Hour = alarmHours";
_td.setHour(_alarmhours);
RDebugUtils.currentLine=1769476;
 //BA.debugLineNum = 1769476;BA.debugLine="td.Minute = alarmMinutes";
_td.setMinute(_alarmminutes);
RDebugUtils.currentLine=1769477;
 //BA.debugLineNum = 1769477;BA.debugLine="If td.Show(\"Selecccione la hora para la alarma\",";
if (_td.Show("Selecccione la hora para la alarma","","Aceptar","Cancelar","",mostCurrent.activityBA,(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null))==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
RDebugUtils.currentLine=1769478;
 //BA.debugLineNum = 1769478;BA.debugLine="alarmHours = td.Hour";
_alarmhours = _td.getHour();
RDebugUtils.currentLine=1769479;
 //BA.debugLineNum = 1769479;BA.debugLine="alarmMinutes = td.Minute";
_alarmminutes = _td.getMinute();
RDebugUtils.currentLine=1769480;
 //BA.debugLineNum = 1769480;BA.debugLine="Dim today As Long";
_today = 0L;
RDebugUtils.currentLine=1769481;
 //BA.debugLineNum = 1769481;BA.debugLine="today = DateTime.DateParse(DateTime.Date(DateTim";
_today = anywheresoftware.b4a.keywords.Common.DateTime.DateParse(anywheresoftware.b4a.keywords.Common.DateTime.Date(anywheresoftware.b4a.keywords.Common.DateTime.getNow()));
RDebugUtils.currentLine=1769482;
 //BA.debugLineNum = 1769482;BA.debugLine="alarm = today + td.Hour * DateTime.TicksPerHour";
_alarm = (long) (_today+_td.getHour()*anywheresoftware.b4a.keywords.Common.DateTime.TicksPerHour+_td.getMinute()*anywheresoftware.b4a.keywords.Common.DateTime.TicksPerMinute);
RDebugUtils.currentLine=1769483;
 //BA.debugLineNum = 1769483;BA.debugLine="If alarm < DateTime.Now Then alarm = DateTime.Ad";
if (_alarm<anywheresoftware.b4a.keywords.Common.DateTime.getNow()) { 
_alarm = anywheresoftware.b4a.keywords.Common.DateTime.Add(_alarm,(int) (0),(int) (0),(int) (1));};
RDebugUtils.currentLine=1769484;
 //BA.debugLineNum = 1769484;BA.debugLine="Log(DateTime.Date(alarm) & \" \" & DateTime.Time(a";
anywheresoftware.b4a.keywords.Common.LogImpl("51769484",anywheresoftware.b4a.keywords.Common.DateTime.Date(_alarm)+" "+anywheresoftware.b4a.keywords.Common.DateTime.Time(_alarm),0);
RDebugUtils.currentLine=1769486;
 //BA.debugLineNum = 1769486;BA.debugLine="Dim h, m As Int";
_h = 0;
_m = 0;
RDebugUtils.currentLine=1769487;
 //BA.debugLineNum = 1769487;BA.debugLine="h = Floor((alarm - DateTime.Now) / DateTime.Tick";
_h = (int) (anywheresoftware.b4a.keywords.Common.Floor((_alarm-anywheresoftware.b4a.keywords.Common.DateTime.getNow())/(double)anywheresoftware.b4a.keywords.Common.DateTime.TicksPerHour));
RDebugUtils.currentLine=1769488;
 //BA.debugLineNum = 1769488;BA.debugLine="m = ((alarm - DateTime.Now) - h * DateTime.Ticks";
_m = (int) (((_alarm-anywheresoftware.b4a.keywords.Common.DateTime.getNow())-_h*anywheresoftware.b4a.keywords.Common.DateTime.TicksPerHour)/(double)anywheresoftware.b4a.keywords.Common.DateTime.TicksPerMinute);
RDebugUtils.currentLine=1769490;
 //BA.debugLineNum = 1769490;BA.debugLine="ToastMessageShow(\"La alarma se escuchará a las:";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("La alarma se escuchará a las: "+anywheresoftware.b4a.keywords.Common.NumberFormat(_h,(int) (2),(int) (0))+" hour(s) and "+anywheresoftware.b4a.keywords.Common.NumberFormat(_m,(int) (2),(int) (0))+" minute(s)"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1769491;
 //BA.debugLineNum = 1769491;BA.debugLine="StartServiceAt(Alarma, (DateTime.Now+((h*60*60*1";
anywheresoftware.b4a.keywords.Common.StartServiceAt(processBA,(Object)(mostCurrent._alarma.getObject()),(long) ((anywheresoftware.b4a.keywords.Common.DateTime.getNow()+((_h*60*60*1000)+(_m*60*1000)))),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1769494;
 //BA.debugLineNum = 1769494;BA.debugLine="noti.Initialize";
_noti.Initialize();
RDebugUtils.currentLine=1769495;
 //BA.debugLineNum = 1769495;BA.debugLine="noti.Light = False";
_noti.setLight(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1769496;
 //BA.debugLineNum = 1769496;BA.debugLine="noti.Vibrate = True";
_noti.setVibrate(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1769497;
 //BA.debugLineNum = 1769497;BA.debugLine="noti.OnGoingEvent = True";
_noti.setOnGoingEvent(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1769498;
 //BA.debugLineNum = 1769498;BA.debugLine="noti.Sound = False";
_noti.setSound(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1769499;
 //BA.debugLineNum = 1769499;BA.debugLine="noti.Icon = \"icon\"";
_noti.setIcon("icon");
RDebugUtils.currentLine=1769500;
 //BA.debugLineNum = 1769500;BA.debugLine="noti.SetInfo(\"Alarma\", \"Se activará a las:\" & Da";
_noti.SetInfoNew(processBA,BA.ObjectToCharSequence("Alarma"),BA.ObjectToCharSequence("Se activará a las:"+anywheresoftware.b4a.keywords.Common.DateTime.Time(_alarm)),(Object)(""));
RDebugUtils.currentLine=1769501;
 //BA.debugLineNum = 1769501;BA.debugLine="noti.Notify(1)";
_noti.Notify((int) (1));
 };
RDebugUtils.currentLine=1769503;
 //BA.debugLineNum = 1769503;BA.debugLine="End Sub";
return "";
}
public static String  _btncancelalarm_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btncancelalarm_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btncancelalarm_click", null));}
RDebugUtils.currentLine=1835008;
 //BA.debugLineNum = 1835008;BA.debugLine="Sub BtnCancelAlarm_Click";
RDebugUtils.currentLine=1835010;
 //BA.debugLineNum = 1835010;BA.debugLine="End Sub";
return "";
}
public static String  _btncancelar_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btncancelar_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btncancelar_click", null));}
RDebugUtils.currentLine=720896;
 //BA.debugLineNum = 720896;BA.debugLine="Sub btnCancelar_Click";
RDebugUtils.currentLine=720897;
 //BA.debugLineNum = 720897;BA.debugLine="TabHost1.CurrentTab=0";
mostCurrent._tabhost1.setCurrentTab((int) (0));
RDebugUtils.currentLine=720898;
 //BA.debugLineNum = 720898;BA.debugLine="End Sub";
return "";
}
public static String  _button2_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "button2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "button2_click", null));}
RDebugUtils.currentLine=786432;
 //BA.debugLineNum = 786432;BA.debugLine="Sub Button2_Click";
RDebugUtils.currentLine=786433;
 //BA.debugLineNum = 786433;BA.debugLine="ExitApplication";
anywheresoftware.b4a.keywords.Common.ExitApplication();
RDebugUtils.currentLine=786434;
 //BA.debugLineNum = 786434;BA.debugLine="End Sub";
return "";
}
public static String  _diasemana(int _i) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "diasemana", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "diasemana", new Object[] {_i}));}
RDebugUtils.currentLine=589824;
 //BA.debugLineNum = 589824;BA.debugLine="Sub DiaSemana(i As Int) As String";
RDebugUtils.currentLine=589825;
 //BA.debugLineNum = 589825;BA.debugLine="Select Case i";
switch (_i) {
case 1: {
RDebugUtils.currentLine=589827;
 //BA.debugLineNum = 589827;BA.debugLine="Return \"Domingo\"";
if (true) return "Domingo";
 break; }
case 2: {
RDebugUtils.currentLine=589829;
 //BA.debugLineNum = 589829;BA.debugLine="Return \"Lunes\"";
if (true) return "Lunes";
 break; }
case 3: {
RDebugUtils.currentLine=589831;
 //BA.debugLineNum = 589831;BA.debugLine="Return \"Martes\"";
if (true) return "Martes";
 break; }
case 4: {
RDebugUtils.currentLine=589833;
 //BA.debugLineNum = 589833;BA.debugLine="Return \"Miercoles\"";
if (true) return "Miercoles";
 break; }
case 5: {
RDebugUtils.currentLine=589835;
 //BA.debugLineNum = 589835;BA.debugLine="Return \"Jueves\"";
if (true) return "Jueves";
 break; }
case 6: {
RDebugUtils.currentLine=589837;
 //BA.debugLineNum = 589837;BA.debugLine="Return \"Viernes\"";
if (true) return "Viernes";
 break; }
case 7: {
RDebugUtils.currentLine=589839;
 //BA.debugLineNum = 589839;BA.debugLine="Return \"Sabado\"";
if (true) return "Sabado";
 break; }
default: {
RDebugUtils.currentLine=589841;
 //BA.debugLineNum = 589841;BA.debugLine="Return \" \"";
if (true) return " ";
 break; }
}
;
RDebugUtils.currentLine=589843;
 //BA.debugLineNum = 589843;BA.debugLine="End Sub";
return "";
}
public static String  _fechalarga(long _fecha) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "fechalarga", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "fechalarga", new Object[] {_fecha}));}
int _dia = 0;
int _mes = 0;
int _ano = 0;
String _nmes = "";
String _ndia = "";
String _nfecha = "";
RDebugUtils.currentLine=655360;
 //BA.debugLineNum = 655360;BA.debugLine="Sub FechaLarga (fecha As Long) As String";
RDebugUtils.currentLine=655361;
 //BA.debugLineNum = 655361;BA.debugLine="Dim dia, mes, ano As Int";
_dia = 0;
_mes = 0;
_ano = 0;
RDebugUtils.currentLine=655362;
 //BA.debugLineNum = 655362;BA.debugLine="Dim nmes, ndia, nfecha As String";
_nmes = "";
_ndia = "";
_nfecha = "";
RDebugUtils.currentLine=655363;
 //BA.debugLineNum = 655363;BA.debugLine="dia=DateTime.GetDayOfMonth(fecha)";
_dia = anywheresoftware.b4a.keywords.Common.DateTime.GetDayOfMonth(_fecha);
RDebugUtils.currentLine=655364;
 //BA.debugLineNum = 655364;BA.debugLine="mes=DateTime.GetMonth(fecha)";
_mes = anywheresoftware.b4a.keywords.Common.DateTime.GetMonth(_fecha);
RDebugUtils.currentLine=655365;
 //BA.debugLineNum = 655365;BA.debugLine="ano=DateTime.GetYear(fecha)";
_ano = anywheresoftware.b4a.keywords.Common.DateTime.GetYear(_fecha);
RDebugUtils.currentLine=655366;
 //BA.debugLineNum = 655366;BA.debugLine="ndia=DiaSemana(DateTime.GetDayOfWeek(fecha))";
_ndia = _diasemana(anywheresoftware.b4a.keywords.Common.DateTime.GetDayOfWeek(_fecha));
RDebugUtils.currentLine=655367;
 //BA.debugLineNum = 655367;BA.debugLine="Select Case mes";
switch (_mes) {
case 1: {
RDebugUtils.currentLine=655369;
 //BA.debugLineNum = 655369;BA.debugLine="nmes=\"Enero\"";
_nmes = "Enero";
 break; }
case 2: {
RDebugUtils.currentLine=655371;
 //BA.debugLineNum = 655371;BA.debugLine="nmes=\"Febrero\"";
_nmes = "Febrero";
 break; }
case 3: {
RDebugUtils.currentLine=655373;
 //BA.debugLineNum = 655373;BA.debugLine="nmes=\"Marzo\"";
_nmes = "Marzo";
 break; }
case 4: {
RDebugUtils.currentLine=655375;
 //BA.debugLineNum = 655375;BA.debugLine="nmes=\"Abril\"";
_nmes = "Abril";
 break; }
case 5: {
RDebugUtils.currentLine=655377;
 //BA.debugLineNum = 655377;BA.debugLine="nmes=\"Mayo\"";
_nmes = "Mayo";
 break; }
case 6: {
RDebugUtils.currentLine=655379;
 //BA.debugLineNum = 655379;BA.debugLine="nmes=\"Junio\"";
_nmes = "Junio";
 break; }
case 7: {
RDebugUtils.currentLine=655381;
 //BA.debugLineNum = 655381;BA.debugLine="nmes=\"Julio\"";
_nmes = "Julio";
 break; }
case 8: {
RDebugUtils.currentLine=655383;
 //BA.debugLineNum = 655383;BA.debugLine="nmes=\"Agosto\"";
_nmes = "Agosto";
 break; }
case 9: {
RDebugUtils.currentLine=655385;
 //BA.debugLineNum = 655385;BA.debugLine="nmes=\"Septiembre\"";
_nmes = "Septiembre";
 break; }
case 10: {
RDebugUtils.currentLine=655387;
 //BA.debugLineNum = 655387;BA.debugLine="nmes=\"Octubre\"";
_nmes = "Octubre";
 break; }
case 11: {
RDebugUtils.currentLine=655389;
 //BA.debugLineNum = 655389;BA.debugLine="nmes=\"Noviembre\"";
_nmes = "Noviembre";
 break; }
case 12: {
RDebugUtils.currentLine=655391;
 //BA.debugLineNum = 655391;BA.debugLine="nmes=\"Diciembre\"";
_nmes = "Diciembre";
 break; }
}
;
RDebugUtils.currentLine=655393;
 //BA.debugLineNum = 655393;BA.debugLine="nfecha=ndia & \" \" & dia & \" de \" & nmes & \" de \"";
_nfecha = _ndia+" "+BA.NumberToString(_dia)+" de "+_nmes+" de "+BA.NumberToString(_ano);
RDebugUtils.currentLine=655394;
 //BA.debugLineNum = 655394;BA.debugLine="Return nfecha";
if (true) return _nfecha;
RDebugUtils.currentLine=655395;
 //BA.debugLineNum = 655395;BA.debugLine="End Sub";
return "";
}
public static String  _tabhost1_tabchanged() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "tabhost1_tabchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "tabhost1_tabchanged", null));}
RDebugUtils.currentLine=327680;
 //BA.debugLineNum = 327680;BA.debugLine="Sub TabHost1_TabChanged";
RDebugUtils.currentLine=327681;
 //BA.debugLineNum = 327681;BA.debugLine="Activity.Title = TabHost1.CurrentTab";
mostCurrent._activity.setTitle(BA.ObjectToCharSequence(mostCurrent._tabhost1.getCurrentTab()));
RDebugUtils.currentLine=327682;
 //BA.debugLineNum = 327682;BA.debugLine="End Sub";
return "";
}
}