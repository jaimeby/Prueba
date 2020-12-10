
package anywheresoftware.b4a.samples.tabhost;

import java.io.IOException;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RDebug;
import anywheresoftware.b4a.pc.RemoteObject;
import anywheresoftware.b4a.pc.RDebug.IRemote;
import anywheresoftware.b4a.pc.Debug;
import anywheresoftware.b4a.pc.B4XTypes.B4XClass;
import anywheresoftware.b4a.pc.B4XTypes.DeviceClass;

public class main implements IRemote{
	public static main mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public main() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
	public static void main (String[] args) throws Exception {
		new RDebug(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]), args[3]);
		RDebug.INSTANCE.waitForTask();

	}
    static {
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("main"), "anywheresoftware.b4a.samples.tabhost.main");
	}

public boolean isSingleton() {
		return true;
	}
     public static RemoteObject getObject() {
		return myClass;
	 }

	public RemoteObject activityBA;
	public RemoteObject _activity;
    private PCBA pcBA;

	public PCBA create(Object[] args) throws ClassNotFoundException{
		processBA = (RemoteObject) args[1];
		activityBA = (RemoteObject) args[2];
		_activity = (RemoteObject) args[3];
        anywheresoftware.b4a.keywords.Common.Density = (Float)args[4];
        remoteMe = (RemoteObject) args[5];
		pcBA = new PCBA(this, main.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _alarmhours = RemoteObject.createImmutable(0);
public static RemoteObject _alarmminutes = RemoteObject.createImmutable(0);
public static RemoteObject _noti = RemoteObject.declareNull("anywheresoftware.b4a.objects.NotificationWrapper");
public static RemoteObject _tabhost1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.TabHostWrapper");
public static RemoteObject _nd = RemoteObject.createImmutable(0);
public static RemoteObject _x = RemoteObject.createImmutable(0);
public static RemoteObject _nl = RemoteObject.createImmutable(0);
public static RemoteObject _r = RemoteObject.createImmutable(0);
public static RemoteObject _button1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _lbel01 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _label2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _label3 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _fa = RemoteObject.createImmutable(0L);
public static RemoteObject _fm = RemoteObject.createImmutable(0L);
public static RemoteObject _rest = RemoteObject.createImmutable("");
public static RemoteObject _ini = RemoteObject.createImmutable("");
public static RemoteObject _btnaceptar = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btncancelar = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _button2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _spinner1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.SpinnerWrapper");
public static RemoteObject _btnalarma = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btncancelalarm = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _spinner2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.SpinnerWrapper");
public static RemoteObject _label4 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static anywheresoftware.b4a.samples.tabhost.alarma _alarma = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",main.mostCurrent._activity,"Alarma",Debug.moduleToString(anywheresoftware.b4a.samples.tabhost.alarma.class),"alarmHours",main._alarmhours,"alarmMinutes",main._alarmminutes,"btnAceptar",main.mostCurrent._btnaceptar,"BtnAlarma",main.mostCurrent._btnalarma,"BtnCancelAlarm",main.mostCurrent._btncancelalarm,"btnCancelar",main.mostCurrent._btncancelar,"Button1",main.mostCurrent._button1,"Button2",main.mostCurrent._button2,"fa",main._fa,"fm",main._fm,"ini",main.mostCurrent._ini,"Label2",main.mostCurrent._label2,"Label3",main.mostCurrent._label3,"Label4",main.mostCurrent._label4,"Lbel01",main.mostCurrent._lbel01,"nd",main._nd,"nl",main._nl,"noti",main._noti,"r",main._r,"rest",main.mostCurrent._rest,"Spinner1",main.mostCurrent._spinner1,"Spinner2",main.mostCurrent._spinner2,"TabHost1",main.mostCurrent._tabhost1,"x",main._x};
}
}