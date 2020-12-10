package anywheresoftware.b4a.samples.tabhost;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,36);
if (RapidSub.canDelegate("activity_create")) { return anywheresoftware.b4a.samples.tabhost.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
RemoteObject _rest1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
RemoteObject _rest2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
RemoteObject _conf1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
RemoteObject _conf2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
RemoteObject _alar1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
RemoteObject _alar2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 36;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(8);
 BA.debugLineNum = 37;BA.debugLine="Activity.LoadLayout(\"main\")";
Debug.ShouldStop(16);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("main")),main.mostCurrent.activityBA);
 BA.debugLineNum = 38;BA.debugLine="Dim rest1, rest2, conf1, conf2, alar1,alar2 As Bi";
Debug.ShouldStop(32);
_rest1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");Debug.locals.put("rest1", _rest1);
_rest2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");Debug.locals.put("rest2", _rest2);
_conf1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");Debug.locals.put("conf1", _conf1);
_conf2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");Debug.locals.put("conf2", _conf2);
_alar1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");Debug.locals.put("alar1", _alar1);
_alar2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");Debug.locals.put("alar2", _alar2);
 BA.debugLineNum = 39;BA.debugLine="rest1 = LoadBitmap(File.DirAssets, \"rest1.png\")";
Debug.ShouldStop(64);
_rest1 = main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("rest1.png")));Debug.locals.put("rest1", _rest1);
 BA.debugLineNum = 40;BA.debugLine="rest2 = LoadBitmap(File.DirAssets, \"rest2.png\")";
Debug.ShouldStop(128);
_rest2 = main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("rest2.png")));Debug.locals.put("rest2", _rest2);
 BA.debugLineNum = 41;BA.debugLine="conf1 = LoadBitmap(File.DirAssets, \"conf1.png\")";
Debug.ShouldStop(256);
_conf1 = main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("conf1.png")));Debug.locals.put("conf1", _conf1);
 BA.debugLineNum = 42;BA.debugLine="conf2 = LoadBitmap(File.DirAssets, \"conf2.png\")";
Debug.ShouldStop(512);
_conf2 = main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("conf2.png")));Debug.locals.put("conf2", _conf2);
 BA.debugLineNum = 43;BA.debugLine="alar1 = LoadBitmap(File.DirAssets, \"alar1.png\")";
Debug.ShouldStop(1024);
_alar1 = main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("alar1.png")));Debug.locals.put("alar1", _alar1);
 BA.debugLineNum = 44;BA.debugLine="alar2 = LoadBitmap(File.DirAssets, \"alar2.png\")";
Debug.ShouldStop(2048);
_alar2 = main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("alar2.png")));Debug.locals.put("alar2", _alar2);
 BA.debugLineNum = 46;BA.debugLine="TabHost1.AddTabWithIcon (\"Resticción\", rest2, res";
Debug.ShouldStop(8192);
main.mostCurrent._tabhost1.runVoidMethodAndSync ("AddTabWithIcon",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("Resticción")),(Object)((_rest2.getObject())),(Object)((_rest1.getObject())),(Object)(RemoteObject.createImmutable("page1")));
 BA.debugLineNum = 47;BA.debugLine="TabHost1.AddTabWithIcon (\"Configuración\", conf2,";
Debug.ShouldStop(16384);
main.mostCurrent._tabhost1.runVoidMethodAndSync ("AddTabWithIcon",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("Configuración")),(Object)((_conf2.getObject())),(Object)((_conf1.getObject())),(Object)(RemoteObject.createImmutable("page2")));
 BA.debugLineNum = 48;BA.debugLine="TabHost1.AddTabWithIcon (\"Alarmas\", alar2, alar1,";
Debug.ShouldStop(32768);
main.mostCurrent._tabhost1.runVoidMethodAndSync ("AddTabWithIcon",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("Alarmas")),(Object)((_alar2.getObject())),(Object)((_alar1.getObject())),(Object)(RemoteObject.createImmutable("page3")));
 BA.debugLineNum = 49;BA.debugLine="Spinner1.Add(\"0-1\")";
Debug.ShouldStop(65536);
main.mostCurrent._spinner1.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("0-1")));
 BA.debugLineNum = 50;BA.debugLine="Spinner1.Add(\"2-3\")";
Debug.ShouldStop(131072);
main.mostCurrent._spinner1.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("2-3")));
 BA.debugLineNum = 51;BA.debugLine="Spinner1.Add(\"4-5\")";
Debug.ShouldStop(262144);
main.mostCurrent._spinner1.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("4-5")));
 BA.debugLineNum = 52;BA.debugLine="Spinner1.Add(\"6-7\")";
Debug.ShouldStop(524288);
main.mostCurrent._spinner1.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("6-7")));
 BA.debugLineNum = 53;BA.debugLine="Spinner1.Add(\"8-9\")";
Debug.ShouldStop(1048576);
main.mostCurrent._spinner1.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("8-9")));
 BA.debugLineNum = 55;BA.debugLine="Spinner2.Add(\"0-1\")";
Debug.ShouldStop(4194304);
main.mostCurrent._spinner2.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("0-1")));
 BA.debugLineNum = 56;BA.debugLine="Spinner2.Add(\"2-3\")";
Debug.ShouldStop(8388608);
main.mostCurrent._spinner2.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("2-3")));
 BA.debugLineNum = 57;BA.debugLine="Spinner2.Add(\"4-5\")";
Debug.ShouldStop(16777216);
main.mostCurrent._spinner2.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("4-5")));
 BA.debugLineNum = 58;BA.debugLine="Spinner2.Add(\"6-7\")";
Debug.ShouldStop(33554432);
main.mostCurrent._spinner2.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("6-7")));
 BA.debugLineNum = 59;BA.debugLine="Spinner2.Add(\"8-9\")";
Debug.ShouldStop(67108864);
main.mostCurrent._spinner2.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("8-9")));
 BA.debugLineNum = 61;BA.debugLine="Spinner1.SelectedIndex=0";
Debug.ShouldStop(268435456);
main.mostCurrent._spinner1.runMethod(true,"setSelectedIndex",BA.numberCast(int.class, 0));
 BA.debugLineNum = 62;BA.debugLine="Button1.Left=50%x-(Button1.Width/2)";
Debug.ShouldStop(536870912);
main.mostCurrent._button1.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 50)),main.mostCurrent.activityBA),(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._button1.runMethod(true,"getWidth"),RemoteObject.createImmutable(2)}, "/",0, 0))}, "-",1, 0)));
 BA.debugLineNum = 63;BA.debugLine="Button2.Left=50%x-(Button2.Width/2)";
Debug.ShouldStop(1073741824);
main.mostCurrent._button2.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 50)),main.mostCurrent.activityBA),(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._button2.runMethod(true,"getWidth"),RemoteObject.createImmutable(2)}, "/",0, 0))}, "-",1, 0)));
 BA.debugLineNum = 64;BA.debugLine="Archivo";
Debug.ShouldStop(-2147483648);
_archivo();
 BA.debugLineNum = 65;BA.debugLine="MostrarRestriccion(DateTime.Now)";
Debug.ShouldStop(1);
_mostrarrestriccion(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"));
 BA.debugLineNum = 66;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _finishing) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,67);
if (RapidSub.canDelegate("activity_pause")) { return anywheresoftware.b4a.samples.tabhost.main.remoteMe.runUserSub(false, "main","activity_pause", _finishing);}
Debug.locals.put("Finishing", _finishing);
 BA.debugLineNum = 67;BA.debugLine="Sub Activity_Pause (Finishing As Boolean)";
Debug.ShouldStop(4);
 BA.debugLineNum = 69;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,70);
if (RapidSub.canDelegate("activity_resume")) { return anywheresoftware.b4a.samples.tabhost.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 70;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(32);
 BA.debugLineNum = 72;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _archivo() throws Exception{
try {
		Debug.PushSubsStack("Archivo (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,77);
if (RapidSub.canDelegate("archivo")) { return anywheresoftware.b4a.samples.tabhost.main.remoteMe.runUserSub(false, "main","archivo");}
RemoteObject _leer = RemoteObject.declareNull("anywheresoftware.b4a.objects.streams.File.TextReaderWrapper");
 BA.debugLineNum = 77;BA.debugLine="Sub Archivo";
Debug.ShouldStop(4096);
 BA.debugLineNum = 78;BA.debugLine="Dim leer As TextReader";
Debug.ShouldStop(8192);
_leer = RemoteObject.createNew ("anywheresoftware.b4a.objects.streams.File.TextReaderWrapper");Debug.locals.put("leer", _leer);
 BA.debugLineNum = 79;BA.debugLine="If File.Exists(File.DirInternal,\"cfgrest.txt\") Th";
Debug.ShouldStop(16384);
if (main.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("cfgrest.txt"))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 80;BA.debugLine="leer.Initialize(File.OpenInput (File.DirInternal";
Debug.ShouldStop(32768);
_leer.runVoidMethod ("Initialize",(Object)((main.mostCurrent.__c.getField(false,"File").runMethod(false,"OpenInput",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("cfgrest.txt"))).getObject())));
 BA.debugLineNum = 81;BA.debugLine="ini = leer.ReadLine";
Debug.ShouldStop(65536);
main.mostCurrent._ini = _leer.runMethod(true,"ReadLine");
 BA.debugLineNum = 82;BA.debugLine="leer.Close";
Debug.ShouldStop(131072);
_leer.runVoidMethod ("Close");
 }else {
 };
 BA.debugLineNum = 87;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnaceptar_click() throws Exception{
try {
		Debug.PushSubsStack("btnAceptar_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,90);
if (RapidSub.canDelegate("btnaceptar_click")) { return anywheresoftware.b4a.samples.tabhost.main.remoteMe.runUserSub(false, "main","btnaceptar_click");}
RemoteObject _escribir = RemoteObject.declareNull("anywheresoftware.b4a.objects.streams.File.TextWriterWrapper");
 BA.debugLineNum = 90;BA.debugLine="Sub btnAceptar_Click";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 91;BA.debugLine="Dim escribir As TextWriter";
Debug.ShouldStop(67108864);
_escribir = RemoteObject.createNew ("anywheresoftware.b4a.objects.streams.File.TextWriterWrapper");Debug.locals.put("escribir", _escribir);
 BA.debugLineNum = 93;BA.debugLine="ini=Spinner1.SelectedItem";
Debug.ShouldStop(268435456);
main.mostCurrent._ini = main.mostCurrent._spinner1.runMethod(true,"getSelectedItem");
 BA.debugLineNum = 94;BA.debugLine="escribir.Initialize(File.OpenOutput(File.DirInter";
Debug.ShouldStop(536870912);
_escribir.runVoidMethod ("Initialize",(Object)((main.mostCurrent.__c.getField(false,"File").runMethod(false,"OpenOutput",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("cfgrest.txt")),(Object)(main.mostCurrent.__c.getField(true,"False"))).getObject())));
 BA.debugLineNum = 95;BA.debugLine="escribir.Writeline(ini)";
Debug.ShouldStop(1073741824);
_escribir.runVoidMethod ("WriteLine",(Object)(main.mostCurrent._ini));
 BA.debugLineNum = 96;BA.debugLine="escribir.Close";
Debug.ShouldStop(-2147483648);
_escribir.runVoidMethod ("Close");
 BA.debugLineNum = 97;BA.debugLine="Archivo";
Debug.ShouldStop(1);
_archivo();
 BA.debugLineNum = 98;BA.debugLine="MostrarRestriccion (DateTime.Now)";
Debug.ShouldStop(2);
_mostrarrestriccion(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"));
 BA.debugLineNum = 99;BA.debugLine="Msgbox2Async(\"Configuración guardada\",\"Configurar";
Debug.ShouldStop(4);
main.mostCurrent.__c.runVoidMethod ("Msgbox2Async",(Object)(BA.ObjectToCharSequence("Configuración guardada")),(Object)(BA.ObjectToCharSequence("Configurar")),(Object)(BA.ObjectToString("Aceptar")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), main.mostCurrent.__c.getField(false,"Null")),main.processBA,(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 100;BA.debugLine="TabHost1.CurrentTab=0";
Debug.ShouldStop(8);
main.mostCurrent._tabhost1.runMethodAndSync(true,"setCurrentTab",BA.numberCast(int.class, 0));
 BA.debugLineNum = 101;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnalarma_click() throws Exception{
try {
		Debug.PushSubsStack("BtnAlarma_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,239);
if (RapidSub.canDelegate("btnalarma_click")) { return anywheresoftware.b4a.samples.tabhost.main.remoteMe.runUserSub(false, "main","btnalarma_click");}
RemoteObject _td = RemoteObject.declareNull("anywheresoftware.b4a.agraham.dialogs.InputDialog.TimeDialog");
RemoteObject _alarm = RemoteObject.createImmutable(0L);
RemoteObject _today = RemoteObject.createImmutable(0L);
RemoteObject _h = RemoteObject.createImmutable(0);
RemoteObject _m = RemoteObject.createImmutable(0);
 BA.debugLineNum = 239;BA.debugLine="Sub BtnAlarma_Click";
Debug.ShouldStop(16384);
 BA.debugLineNum = 240;BA.debugLine="Dim td As TimeDialog";
Debug.ShouldStop(32768);
_td = RemoteObject.createNew ("anywheresoftware.b4a.agraham.dialogs.InputDialog.TimeDialog");Debug.locals.put("td", _td);
 BA.debugLineNum = 241;BA.debugLine="Dim alarm As Long";
Debug.ShouldStop(65536);
_alarm = RemoteObject.createImmutable(0L);Debug.locals.put("alarm", _alarm);
 BA.debugLineNum = 242;BA.debugLine="td.Hour = alarmHours";
Debug.ShouldStop(131072);
_td.runMethod(true,"setHour",main._alarmhours);
 BA.debugLineNum = 243;BA.debugLine="td.Minute = alarmMinutes";
Debug.ShouldStop(262144);
_td.runMethod(true,"setMinute",main._alarmminutes);
 BA.debugLineNum = 244;BA.debugLine="If td.Show(\"Selecccione la hora para la alarma\",";
Debug.ShouldStop(524288);
if (RemoteObject.solveBoolean("=",_td.runMethodAndSync(true,"Show",(Object)(BA.ObjectToString("Selecccione la hora para la alarma")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("Aceptar")),(Object)(BA.ObjectToString("Cancelar")),(Object)(BA.ObjectToString("")),main.mostCurrent.activityBA,(Object)((main.mostCurrent.__c.getField(false,"Null")))),BA.numberCast(double.class, main.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
 BA.debugLineNum = 245;BA.debugLine="alarmHours = td.Hour";
Debug.ShouldStop(1048576);
main._alarmhours = _td.runMethod(true,"getHour");
 BA.debugLineNum = 246;BA.debugLine="alarmMinutes = td.Minute";
Debug.ShouldStop(2097152);
main._alarmminutes = _td.runMethod(true,"getMinute");
 BA.debugLineNum = 247;BA.debugLine="Dim today As Long";
Debug.ShouldStop(4194304);
_today = RemoteObject.createImmutable(0L);Debug.locals.put("today", _today);
 BA.debugLineNum = 248;BA.debugLine="today = DateTime.DateParse(DateTime.Date(DateTim";
Debug.ShouldStop(8388608);
_today = main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"DateParse",(Object)(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Date",(Object)(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow")))));Debug.locals.put("today", _today);
 BA.debugLineNum = 249;BA.debugLine="alarm = today + td.Hour * DateTime.TicksPerHour";
Debug.ShouldStop(16777216);
_alarm = RemoteObject.solve(new RemoteObject[] {_today,_td.runMethod(true,"getHour"),main.mostCurrent.__c.getField(false,"DateTime").getField(true,"TicksPerHour"),_td.runMethod(true,"getMinute"),main.mostCurrent.__c.getField(false,"DateTime").getField(true,"TicksPerMinute")}, "+*+*",2, 2);Debug.locals.put("alarm", _alarm);
 BA.debugLineNum = 250;BA.debugLine="If alarm < DateTime.Now Then alarm = DateTime.Ad";
Debug.ShouldStop(33554432);
if (RemoteObject.solveBoolean("<",_alarm,BA.numberCast(double.class, main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow")))) { 
_alarm = main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Add",(Object)(_alarm),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 1)));Debug.locals.put("alarm", _alarm);};
 BA.debugLineNum = 251;BA.debugLine="Log(DateTime.Date(alarm) & \" \" & DateTime.Time(a";
Debug.ShouldStop(67108864);
main.mostCurrent.__c.runVoidMethod ("LogImpl","51769484",RemoteObject.concat(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Date",(Object)(_alarm)),RemoteObject.createImmutable(" "),main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Time",(Object)(_alarm))),0);
 BA.debugLineNum = 253;BA.debugLine="Dim h, m As Int";
Debug.ShouldStop(268435456);
_h = RemoteObject.createImmutable(0);Debug.locals.put("h", _h);
_m = RemoteObject.createImmutable(0);Debug.locals.put("m", _m);
 BA.debugLineNum = 254;BA.debugLine="h = Floor((alarm - DateTime.Now) / DateTime.Tick";
Debug.ShouldStop(536870912);
_h = BA.numberCast(int.class, main.mostCurrent.__c.runMethod(true,"Floor",(Object)(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_alarm,main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow")}, "-",1, 2)),main.mostCurrent.__c.getField(false,"DateTime").getField(true,"TicksPerHour")}, "/",0, 0))));Debug.locals.put("h", _h);
 BA.debugLineNum = 255;BA.debugLine="m = ((alarm - DateTime.Now) - h * DateTime.Ticks";
Debug.ShouldStop(1073741824);
_m = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_alarm,main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow")}, "-",1, 2)),_h,main.mostCurrent.__c.getField(false,"DateTime").getField(true,"TicksPerHour")}, "-*",1, 2)),main.mostCurrent.__c.getField(false,"DateTime").getField(true,"TicksPerMinute")}, "/",0, 0));Debug.locals.put("m", _m);
 BA.debugLineNum = 257;BA.debugLine="ToastMessageShow(\"La alarma se escuchará a las:";
Debug.ShouldStop(1);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("La alarma se escuchará a las: "),main.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(BA.numberCast(double.class, _h)),(Object)(BA.numberCast(int.class, 2)),(Object)(BA.numberCast(int.class, 0))),RemoteObject.createImmutable(" hour(s) and "),main.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(BA.numberCast(double.class, _m)),(Object)(BA.numberCast(int.class, 2)),(Object)(BA.numberCast(int.class, 0))),RemoteObject.createImmutable(" minute(s)")))),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 258;BA.debugLine="StartServiceAt(Alarma, (DateTime.Now+((h*60*60*1";
Debug.ShouldStop(2);
main.mostCurrent.__c.runVoidMethod ("StartServiceAt",main.processBA,(Object)((main.mostCurrent._alarma.getObject())),(Object)((RemoteObject.solve(new RemoteObject[] {main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"),(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_h,RemoteObject.createImmutable(60),RemoteObject.createImmutable(60),RemoteObject.createImmutable(1000)}, "***",0, 1)),(RemoteObject.solve(new RemoteObject[] {_m,RemoteObject.createImmutable(60),RemoteObject.createImmutable(1000)}, "**",0, 1))}, "+",1, 1))}, "+",1, 2))),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 261;BA.debugLine="noti.Initialize";
Debug.ShouldStop(16);
main._noti.runVoidMethod ("Initialize");
 BA.debugLineNum = 262;BA.debugLine="noti.Light = False";
Debug.ShouldStop(32);
main._noti.runVoidMethod ("setLight",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 263;BA.debugLine="noti.Vibrate = True";
Debug.ShouldStop(64);
main._noti.runVoidMethod ("setVibrate",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 264;BA.debugLine="noti.OnGoingEvent = True";
Debug.ShouldStop(128);
main._noti.runVoidMethod ("setOnGoingEvent",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 265;BA.debugLine="noti.Sound = False";
Debug.ShouldStop(256);
main._noti.runVoidMethod ("setSound",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 266;BA.debugLine="noti.Icon = \"icon\"";
Debug.ShouldStop(512);
main._noti.runVoidMethod ("setIcon",BA.ObjectToString("icon"));
 BA.debugLineNum = 267;BA.debugLine="noti.SetInfo(\"Alarma\", \"Se activará a las:\" & Da";
Debug.ShouldStop(1024);
main._noti.runVoidMethod ("SetInfoNew",main.processBA,(Object)(BA.ObjectToCharSequence("Alarma")),(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Se activará a las:"),main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Time",(Object)(_alarm))))),(Object)((RemoteObject.createImmutable(""))));
 BA.debugLineNum = 268;BA.debugLine="noti.Notify(1)";
Debug.ShouldStop(2048);
main._noti.runVoidMethod ("Notify",(Object)(BA.numberCast(int.class, 1)));
 };
 BA.debugLineNum = 270;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btncancelalarm_click() throws Exception{
try {
		Debug.PushSubsStack("BtnCancelAlarm_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,272);
if (RapidSub.canDelegate("btncancelalarm_click")) { return anywheresoftware.b4a.samples.tabhost.main.remoteMe.runUserSub(false, "main","btncancelalarm_click");}
 BA.debugLineNum = 272;BA.debugLine="Sub BtnCancelAlarm_Click";
Debug.ShouldStop(32768);
 BA.debugLineNum = 274;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btncancelar_click() throws Exception{
try {
		Debug.PushSubsStack("btnCancelar_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,231);
if (RapidSub.canDelegate("btncancelar_click")) { return anywheresoftware.b4a.samples.tabhost.main.remoteMe.runUserSub(false, "main","btncancelar_click");}
 BA.debugLineNum = 231;BA.debugLine="Sub btnCancelar_Click";
Debug.ShouldStop(64);
 BA.debugLineNum = 232;BA.debugLine="TabHost1.CurrentTab=0";
Debug.ShouldStop(128);
main.mostCurrent._tabhost1.runMethodAndSync(true,"setCurrentTab",BA.numberCast(int.class, 0));
 BA.debugLineNum = 233;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _button2_click() throws Exception{
try {
		Debug.PushSubsStack("Button2_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,235);
if (RapidSub.canDelegate("button2_click")) { return anywheresoftware.b4a.samples.tabhost.main.remoteMe.runUserSub(false, "main","button2_click");}
 BA.debugLineNum = 235;BA.debugLine="Sub Button2_Click";
Debug.ShouldStop(1024);
 BA.debugLineNum = 236;BA.debugLine="ExitApplication";
Debug.ShouldStop(2048);
main.mostCurrent.__c.runVoidMethod ("ExitApplication");
 BA.debugLineNum = 237;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _diasemana(RemoteObject _i) throws Exception{
try {
		Debug.PushSubsStack("DiaSemana (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,173);
if (RapidSub.canDelegate("diasemana")) { return anywheresoftware.b4a.samples.tabhost.main.remoteMe.runUserSub(false, "main","diasemana", _i);}
Debug.locals.put("i", _i);
 BA.debugLineNum = 173;BA.debugLine="Sub DiaSemana(i As Int) As String";
Debug.ShouldStop(4096);
 BA.debugLineNum = 174;BA.debugLine="Select Case i";
Debug.ShouldStop(8192);
switch (BA.switchObjectToInt(_i,BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3),BA.numberCast(int.class, 4),BA.numberCast(int.class, 5),BA.numberCast(int.class, 6),BA.numberCast(int.class, 7))) {
case 0: {
 BA.debugLineNum = 176;BA.debugLine="Return \"Domingo\"";
Debug.ShouldStop(32768);
if (true) return BA.ObjectToString("Domingo");
 break; }
case 1: {
 BA.debugLineNum = 178;BA.debugLine="Return \"Lunes\"";
Debug.ShouldStop(131072);
if (true) return BA.ObjectToString("Lunes");
 break; }
case 2: {
 BA.debugLineNum = 180;BA.debugLine="Return \"Martes\"";
Debug.ShouldStop(524288);
if (true) return BA.ObjectToString("Martes");
 break; }
case 3: {
 BA.debugLineNum = 182;BA.debugLine="Return \"Miercoles\"";
Debug.ShouldStop(2097152);
if (true) return BA.ObjectToString("Miercoles");
 break; }
case 4: {
 BA.debugLineNum = 184;BA.debugLine="Return \"Jueves\"";
Debug.ShouldStop(8388608);
if (true) return BA.ObjectToString("Jueves");
 break; }
case 5: {
 BA.debugLineNum = 186;BA.debugLine="Return \"Viernes\"";
Debug.ShouldStop(33554432);
if (true) return BA.ObjectToString("Viernes");
 break; }
case 6: {
 BA.debugLineNum = 188;BA.debugLine="Return \"Sabado\"";
Debug.ShouldStop(134217728);
if (true) return BA.ObjectToString("Sabado");
 break; }
default: {
 BA.debugLineNum = 190;BA.debugLine="Return \" \"";
Debug.ShouldStop(536870912);
if (true) return BA.ObjectToString(" ");
 break; }
}
;
 BA.debugLineNum = 192;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _fechalarga(RemoteObject _fecha) throws Exception{
try {
		Debug.PushSubsStack("FechaLarga (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,194);
if (RapidSub.canDelegate("fechalarga")) { return anywheresoftware.b4a.samples.tabhost.main.remoteMe.runUserSub(false, "main","fechalarga", _fecha);}
RemoteObject _dia = RemoteObject.createImmutable(0);
RemoteObject _mes = RemoteObject.createImmutable(0);
RemoteObject _ano = RemoteObject.createImmutable(0);
RemoteObject _nmes = RemoteObject.createImmutable("");
RemoteObject _ndia = RemoteObject.createImmutable("");
RemoteObject _nfecha = RemoteObject.createImmutable("");
Debug.locals.put("fecha", _fecha);
 BA.debugLineNum = 194;BA.debugLine="Sub FechaLarga (fecha As Long) As String";
Debug.ShouldStop(2);
 BA.debugLineNum = 195;BA.debugLine="Dim dia, mes, ano As Int";
Debug.ShouldStop(4);
_dia = RemoteObject.createImmutable(0);Debug.locals.put("dia", _dia);
_mes = RemoteObject.createImmutable(0);Debug.locals.put("mes", _mes);
_ano = RemoteObject.createImmutable(0);Debug.locals.put("ano", _ano);
 BA.debugLineNum = 196;BA.debugLine="Dim nmes, ndia, nfecha As String";
Debug.ShouldStop(8);
_nmes = RemoteObject.createImmutable("");Debug.locals.put("nmes", _nmes);
_ndia = RemoteObject.createImmutable("");Debug.locals.put("ndia", _ndia);
_nfecha = RemoteObject.createImmutable("");Debug.locals.put("nfecha", _nfecha);
 BA.debugLineNum = 197;BA.debugLine="dia=DateTime.GetDayOfMonth(fecha)";
Debug.ShouldStop(16);
_dia = main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetDayOfMonth",(Object)(_fecha));Debug.locals.put("dia", _dia);
 BA.debugLineNum = 198;BA.debugLine="mes=DateTime.GetMonth(fecha)";
Debug.ShouldStop(32);
_mes = main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetMonth",(Object)(_fecha));Debug.locals.put("mes", _mes);
 BA.debugLineNum = 199;BA.debugLine="ano=DateTime.GetYear(fecha)";
Debug.ShouldStop(64);
_ano = main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetYear",(Object)(_fecha));Debug.locals.put("ano", _ano);
 BA.debugLineNum = 200;BA.debugLine="ndia=DiaSemana(DateTime.GetDayOfWeek(fecha))";
Debug.ShouldStop(128);
_ndia = _diasemana(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetDayOfWeek",(Object)(_fecha)));Debug.locals.put("ndia", _ndia);
 BA.debugLineNum = 201;BA.debugLine="Select Case mes";
Debug.ShouldStop(256);
switch (BA.switchObjectToInt(_mes,BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3),BA.numberCast(int.class, 4),BA.numberCast(int.class, 5),BA.numberCast(int.class, 6),BA.numberCast(int.class, 7),BA.numberCast(int.class, 8),BA.numberCast(int.class, 9),BA.numberCast(int.class, 10),BA.numberCast(int.class, 11),BA.numberCast(int.class, 12))) {
case 0: {
 BA.debugLineNum = 203;BA.debugLine="nmes=\"Enero\"";
Debug.ShouldStop(1024);
_nmes = BA.ObjectToString("Enero");Debug.locals.put("nmes", _nmes);
 break; }
case 1: {
 BA.debugLineNum = 205;BA.debugLine="nmes=\"Febrero\"";
Debug.ShouldStop(4096);
_nmes = BA.ObjectToString("Febrero");Debug.locals.put("nmes", _nmes);
 break; }
case 2: {
 BA.debugLineNum = 207;BA.debugLine="nmes=\"Marzo\"";
Debug.ShouldStop(16384);
_nmes = BA.ObjectToString("Marzo");Debug.locals.put("nmes", _nmes);
 break; }
case 3: {
 BA.debugLineNum = 209;BA.debugLine="nmes=\"Abril\"";
Debug.ShouldStop(65536);
_nmes = BA.ObjectToString("Abril");Debug.locals.put("nmes", _nmes);
 break; }
case 4: {
 BA.debugLineNum = 211;BA.debugLine="nmes=\"Mayo\"";
Debug.ShouldStop(262144);
_nmes = BA.ObjectToString("Mayo");Debug.locals.put("nmes", _nmes);
 break; }
case 5: {
 BA.debugLineNum = 213;BA.debugLine="nmes=\"Junio\"";
Debug.ShouldStop(1048576);
_nmes = BA.ObjectToString("Junio");Debug.locals.put("nmes", _nmes);
 break; }
case 6: {
 BA.debugLineNum = 215;BA.debugLine="nmes=\"Julio\"";
Debug.ShouldStop(4194304);
_nmes = BA.ObjectToString("Julio");Debug.locals.put("nmes", _nmes);
 break; }
case 7: {
 BA.debugLineNum = 217;BA.debugLine="nmes=\"Agosto\"";
Debug.ShouldStop(16777216);
_nmes = BA.ObjectToString("Agosto");Debug.locals.put("nmes", _nmes);
 break; }
case 8: {
 BA.debugLineNum = 219;BA.debugLine="nmes=\"Septiembre\"";
Debug.ShouldStop(67108864);
_nmes = BA.ObjectToString("Septiembre");Debug.locals.put("nmes", _nmes);
 break; }
case 9: {
 BA.debugLineNum = 221;BA.debugLine="nmes=\"Octubre\"";
Debug.ShouldStop(268435456);
_nmes = BA.ObjectToString("Octubre");Debug.locals.put("nmes", _nmes);
 break; }
case 10: {
 BA.debugLineNum = 223;BA.debugLine="nmes=\"Noviembre\"";
Debug.ShouldStop(1073741824);
_nmes = BA.ObjectToString("Noviembre");Debug.locals.put("nmes", _nmes);
 break; }
case 11: {
 BA.debugLineNum = 225;BA.debugLine="nmes=\"Diciembre\"";
Debug.ShouldStop(1);
_nmes = BA.ObjectToString("Diciembre");Debug.locals.put("nmes", _nmes);
 break; }
}
;
 BA.debugLineNum = 227;BA.debugLine="nfecha=ndia & \" \" & dia & \" de \" & nmes & \" de \"";
Debug.ShouldStop(4);
_nfecha = RemoteObject.concat(_ndia,RemoteObject.createImmutable(" "),_dia,RemoteObject.createImmutable(" de "),_nmes,RemoteObject.createImmutable(" de "),_ano);Debug.locals.put("nfecha", _nfecha);
 BA.debugLineNum = 228;BA.debugLine="Return nfecha";
Debug.ShouldStop(8);
if (true) return _nfecha;
 BA.debugLineNum = 229;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 16;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 17;BA.debugLine="Dim TabHost1 As TabHost";
main.mostCurrent._tabhost1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.TabHostWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Dim nd,x, nl, r As Int";
main._nd = RemoteObject.createImmutable(0);
main._x = RemoteObject.createImmutable(0);
main._nl = RemoteObject.createImmutable(0);
main._r = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 19;BA.debugLine="Dim Button1 As Button";
main.mostCurrent._button1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Dim Lbel01 As Label";
main.mostCurrent._lbel01 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Dim Label2 As Label";
main.mostCurrent._label2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Dim Label3 As Label";
main.mostCurrent._label3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Dim fa,fm As Long 'Fechas actual e inicial";
main._fa = RemoteObject.createImmutable(0L);
main._fm = RemoteObject.createImmutable(0L);
 //BA.debugLineNum = 24;BA.debugLine="Dim rest As String";
main.mostCurrent._rest = RemoteObject.createImmutable("");
 //BA.debugLineNum = 25;BA.debugLine="Dim ini As String";
main.mostCurrent._ini = RemoteObject.createImmutable("");
 //BA.debugLineNum = 26;BA.debugLine="Private btnAceptar As Button";
main.mostCurrent._btnaceptar = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Private btnCancelar As Button";
main.mostCurrent._btncancelar = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Private Button2 As Button";
main.mostCurrent._button2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Private Spinner1 As Spinner";
main.mostCurrent._spinner1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.SpinnerWrapper");
 //BA.debugLineNum = 30;BA.debugLine="Private BtnAlarma As Button";
main.mostCurrent._btnalarma = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 31;BA.debugLine="Private BtnCancelAlarm As Button";
main.mostCurrent._btncancelalarm = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 32;BA.debugLine="Private Spinner2 As Spinner";
main.mostCurrent._spinner2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.SpinnerWrapper");
 //BA.debugLineNum = 33;BA.debugLine="Private Label4 As Label";
main.mostCurrent._label4 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 34;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _mostrarrestriccion(RemoteObject _fecha) throws Exception{
try {
		Debug.PushSubsStack("MostrarRestriccion (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,103);
if (RapidSub.canDelegate("mostrarrestriccion")) { return anywheresoftware.b4a.samples.tabhost.main.remoteMe.runUserSub(false, "main","mostrarrestriccion", _fecha);}
RemoteObject _clr = RemoteObject.createImmutable(0);
RemoteObject _ltr = RemoteObject.createImmutable(0);
RemoteObject _ind = RemoteObject.createImmutable(0);
RemoteObject _i = RemoteObject.createImmutable(0);
RemoteObject _pla = null;
RemoteObject _num = null;
Debug.locals.put("fecha", _fecha);
 BA.debugLineNum = 103;BA.debugLine="Sub MostrarRestriccion (fecha As Long)";
Debug.ShouldStop(64);
 BA.debugLineNum = 104;BA.debugLine="Dim clr, ltr, ind, i  As Int";
Debug.ShouldStop(128);
_clr = RemoteObject.createImmutable(0);Debug.locals.put("clr", _clr);
_ltr = RemoteObject.createImmutable(0);Debug.locals.put("ltr", _ltr);
_ind = RemoteObject.createImmutable(0);Debug.locals.put("ind", _ind);
_i = RemoteObject.createImmutable(0);Debug.locals.put("i", _i);
 BA.debugLineNum = 105;BA.debugLine="Dim pla(5),num(5) As String";
Debug.ShouldStop(256);
_pla = RemoteObject.createNewArray ("String", new int[] {5}, new Object[]{});Debug.locals.put("pla", _pla);
_num = RemoteObject.createNewArray ("String", new int[] {5}, new Object[]{});Debug.locals.put("num", _num);
 BA.debugLineNum = 109;BA.debugLine="pla=Array As String(\"0-1\",\"2-3\",\"4-5\",\"6-7\",\"8-9\"";
Debug.ShouldStop(4096);
_pla = RemoteObject.createNewArray("String",new int[] {5},new Object[] {BA.ObjectToString("0-1"),BA.ObjectToString("2-3"),BA.ObjectToString("4-5"),BA.ObjectToString("6-7"),RemoteObject.createImmutable("8-9")});Debug.locals.put("pla", _pla);
 BA.debugLineNum = 110;BA.debugLine="For i=0 To 4";
Debug.ShouldStop(8192);
{
final int step4 = 1;
final int limit4 = 4;
_i = BA.numberCast(int.class, 0) ;
for (;(step4 > 0 && _i.<Integer>get().intValue() <= limit4) || (step4 < 0 && _i.<Integer>get().intValue() >= limit4) ;_i = RemoteObject.createImmutable((int)(0 + _i.<Integer>get().intValue() + step4))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 111;BA.debugLine="If pla(i) = ini Then";
Debug.ShouldStop(16384);
if (RemoteObject.solveBoolean("=",_pla.getArrayElement(true,_i),main.mostCurrent._ini)) { 
 BA.debugLineNum = 112;BA.debugLine="ind=i";
Debug.ShouldStop(32768);
_ind = _i;Debug.locals.put("ind", _ind);
 BA.debugLineNum = 113;BA.debugLine="Exit";
Debug.ShouldStop(65536);
if (true) break;
 };
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 116;BA.debugLine="For i=0 To 4";
Debug.ShouldStop(524288);
{
final int step10 = 1;
final int limit10 = 4;
_i = BA.numberCast(int.class, 0) ;
for (;(step10 > 0 && _i.<Integer>get().intValue() <= limit10) || (step10 < 0 && _i.<Integer>get().intValue() >= limit10) ;_i = RemoteObject.createImmutable((int)(0 + _i.<Integer>get().intValue() + step10))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 117;BA.debugLine="num(i)=pla(ind)";
Debug.ShouldStop(1048576);
_num.setArrayElement (_pla.getArrayElement(true,_ind),_i);
 BA.debugLineNum = 118;BA.debugLine="ind=ind+1";
Debug.ShouldStop(2097152);
_ind = RemoteObject.solve(new RemoteObject[] {_ind,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("ind", _ind);
 BA.debugLineNum = 119;BA.debugLine="If ind > 4 Then	ind=0";
Debug.ShouldStop(4194304);
if (RemoteObject.solveBoolean(">",_ind,BA.numberCast(double.class, 4))) { 
_ind = BA.numberCast(int.class, 0);Debug.locals.put("ind", _ind);};
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 122;BA.debugLine="fa=fecha";
Debug.ShouldStop(33554432);
main._fa = _fecha;
 BA.debugLineNum = 123;BA.debugLine="nd = DateTime.GetDayOfYear(fa)	' Numero de dia de";
Debug.ShouldStop(67108864);
main._nd = main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetDayOfYear",(Object)(main._fa));
 BA.debugLineNum = 124;BA.debugLine="nl=0";
Debug.ShouldStop(134217728);
main._nl = BA.numberCast(int.class, 0);
 BA.debugLineNum = 125;BA.debugLine="For x=1 To nd";
Debug.ShouldStop(268435456);
{
final int step18 = 1;
final int limit18 = main._nd.<Integer>get().intValue();
main._x = BA.numberCast(int.class, 1) ;
for (;(step18 > 0 && main._x.<Integer>get().intValue() <= limit18) || (step18 < 0 && main._x.<Integer>get().intValue() >= limit18) ;main._x = RemoteObject.createImmutable((int)(0 + main._x.<Integer>get().intValue() + step18))  ) {
 BA.debugLineNum = 126;BA.debugLine="fm=DateTime.Add(fa, 0,0,-x)";
Debug.ShouldStop(536870912);
main._fm = main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Add",(Object)(main._fa),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, -(double) (0 + main._x.<Integer>get().intValue()))));
 BA.debugLineNum = 127;BA.debugLine="If DateTime.GetDayOfWeek(fm) <> 1 Then  'Si es d";
Debug.ShouldStop(1073741824);
if (RemoteObject.solveBoolean("!",main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetDayOfWeek",(Object)(main._fm)),BA.numberCast(double.class, 1))) { 
 BA.debugLineNum = 128;BA.debugLine="nl=nl+1";
Debug.ShouldStop(-2147483648);
main._nl = RemoteObject.solve(new RemoteObject[] {main._nl,RemoteObject.createImmutable(1)}, "+",1, 1);
 };
 }
};
 BA.debugLineNum = 131;BA.debugLine="r=(nl Mod 5)-1";
Debug.ShouldStop(4);
main._r = RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {main._nl,RemoteObject.createImmutable(5)}, "%",0, 1)),RemoteObject.createImmutable(1)}, "-",1, 1);
 BA.debugLineNum = 132;BA.debugLine="If r < 0 Then r=4";
Debug.ShouldStop(8);
if (RemoteObject.solveBoolean("<",main._r,BA.numberCast(double.class, 0))) { 
main._r = BA.numberCast(int.class, 4);};
 BA.debugLineNum = 133;BA.debugLine="Label3.Text=\"Horario restricción [ 7:30 a.m. - 7:";
Debug.ShouldStop(16);
main.mostCurrent._label3.runMethod(true,"setText",BA.ObjectToCharSequence("Horario restricción [ 7:30 a.m. - 7:30 p.m.]"));
 BA.debugLineNum = 136;BA.debugLine="rest=num(r)";
Debug.ShouldStop(128);
main.mostCurrent._rest = _num.getArrayElement(true,main._r);
 BA.debugLineNum = 137;BA.debugLine="If (rest = \"0-1\") Then";
Debug.ShouldStop(256);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._rest,RemoteObject.createImmutable("0-1")))) { 
 BA.debugLineNum = 138;BA.debugLine="clr=Colors.green";
Debug.ShouldStop(512);
_clr = main.mostCurrent.__c.getField(false,"Colors").getField(true,"Green");Debug.locals.put("clr", _clr);
 BA.debugLineNum = 139;BA.debugLine="ltr=Colors.Black";
Debug.ShouldStop(1024);
_ltr = main.mostCurrent.__c.getField(false,"Colors").getField(true,"Black");Debug.locals.put("ltr", _ltr);
 };
 BA.debugLineNum = 141;BA.debugLine="If (rest = \"2-3\") Then";
Debug.ShouldStop(4096);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._rest,RemoteObject.createImmutable("2-3")))) { 
 BA.debugLineNum = 142;BA.debugLine="clr=Colors.White";
Debug.ShouldStop(8192);
_clr = main.mostCurrent.__c.getField(false,"Colors").getField(true,"White");Debug.locals.put("clr", _clr);
 BA.debugLineNum = 143;BA.debugLine="ltr=Colors.Black";
Debug.ShouldStop(16384);
_ltr = main.mostCurrent.__c.getField(false,"Colors").getField(true,"Black");Debug.locals.put("ltr", _ltr);
 };
 BA.debugLineNum = 145;BA.debugLine="If (rest = \"4-5\") Then";
Debug.ShouldStop(65536);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._rest,RemoteObject.createImmutable("4-5")))) { 
 BA.debugLineNum = 146;BA.debugLine="clr=Colors.Magenta";
Debug.ShouldStop(131072);
_clr = main.mostCurrent.__c.getField(false,"Colors").getField(true,"Magenta");Debug.locals.put("clr", _clr);
 BA.debugLineNum = 147;BA.debugLine="ltr=Colors.Black";
Debug.ShouldStop(262144);
_ltr = main.mostCurrent.__c.getField(false,"Colors").getField(true,"Black");Debug.locals.put("ltr", _ltr);
 };
 BA.debugLineNum = 149;BA.debugLine="If (rest = \"6-7\") Then";
Debug.ShouldStop(1048576);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._rest,RemoteObject.createImmutable("6-7")))) { 
 BA.debugLineNum = 150;BA.debugLine="clr=Colors.Yellow";
Debug.ShouldStop(2097152);
_clr = main.mostCurrent.__c.getField(false,"Colors").getField(true,"Yellow");Debug.locals.put("clr", _clr);
 BA.debugLineNum = 151;BA.debugLine="ltr=Colors.Black";
Debug.ShouldStop(4194304);
_ltr = main.mostCurrent.__c.getField(false,"Colors").getField(true,"Black");Debug.locals.put("ltr", _ltr);
 };
 BA.debugLineNum = 153;BA.debugLine="If (rest = \"8-9\") Then";
Debug.ShouldStop(16777216);
if ((RemoteObject.solveBoolean("=",main.mostCurrent._rest,RemoteObject.createImmutable("8-9")))) { 
 BA.debugLineNum = 154;BA.debugLine="clr=Colors.Blue";
Debug.ShouldStop(33554432);
_clr = main.mostCurrent.__c.getField(false,"Colors").getField(true,"Blue");Debug.locals.put("clr", _clr);
 BA.debugLineNum = 155;BA.debugLine="ltr=Colors.White";
Debug.ShouldStop(67108864);
_ltr = main.mostCurrent.__c.getField(false,"Colors").getField(true,"White");Debug.locals.put("ltr", _ltr);
 };
 BA.debugLineNum = 157;BA.debugLine="If (DateTime.GetDayOfWeek(fa)=7) Or (DateTime.Get";
Debug.ShouldStop(268435456);
if (RemoteObject.solveBoolean(".",BA.ObjectToBoolean((RemoteObject.solveBoolean("=",main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetDayOfWeek",(Object)(main._fa)),BA.numberCast(double.class, 7))))) || RemoteObject.solveBoolean(".",BA.ObjectToBoolean((RemoteObject.solveBoolean("=",main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"GetDayOfWeek",(Object)(main._fa)),BA.numberCast(double.class, 1)))))) { 
 BA.debugLineNum = 158;BA.debugLine="rest=\"No Aplica\"";
Debug.ShouldStop(536870912);
main.mostCurrent._rest = BA.ObjectToString("No Aplica");
 BA.debugLineNum = 159;BA.debugLine="clr=Colors.Gray";
Debug.ShouldStop(1073741824);
_clr = main.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray");Debug.locals.put("clr", _clr);
 };
 BA.debugLineNum = 161;BA.debugLine="Lbel01.Text=DateTime.Now";
Debug.ShouldStop(1);
main.mostCurrent._lbel01.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow")));
 BA.debugLineNum = 162;BA.debugLine="If (fecha = DateTime.Now) Then";
Debug.ShouldStop(2);
if ((RemoteObject.solveBoolean("=",_fecha,BA.numberCast(double.class, main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"))))) { 
 BA.debugLineNum = 163;BA.debugLine="Lbel01.Text=\"Restricción para hoy:\"";
Debug.ShouldStop(4);
main.mostCurrent._lbel01.runMethod(true,"setText",BA.ObjectToCharSequence("Restricción para hoy:"));
 }else {
 BA.debugLineNum = 165;BA.debugLine="Lbel01.Text=\"Restricción para:\"";
Debug.ShouldStop(16);
main.mostCurrent._lbel01.runMethod(true,"setText",BA.ObjectToCharSequence("Restricción para:"));
 };
 BA.debugLineNum = 167;BA.debugLine="Label2.Text=FechaLarga(fa)";
Debug.ShouldStop(64);
main.mostCurrent._label2.runMethod(true,"setText",BA.ObjectToCharSequence(_fechalarga(main._fa)));
 BA.debugLineNum = 168;BA.debugLine="Button1.Text=rest";
Debug.ShouldStop(128);
main.mostCurrent._button1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._rest));
 BA.debugLineNum = 169;BA.debugLine="Button1.Color=clr";
Debug.ShouldStop(256);
main.mostCurrent._button1.runVoidMethod ("setColor",_clr);
 BA.debugLineNum = 170;BA.debugLine="Button1.TextColor=ltr";
Debug.ShouldStop(512);
main.mostCurrent._button1.runMethod(true,"setTextColor",_ltr);
 BA.debugLineNum = 171;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
alarma_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("anywheresoftware.b4a.samples.tabhost.main");
alarma.myClass = BA.getDeviceClass ("anywheresoftware.b4a.samples.tabhost.alarma");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 11;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 12;BA.debugLine="Dim alarmHours, alarmMinutes As Int";
main._alarmhours = RemoteObject.createImmutable(0);
main._alarmminutes = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 13;BA.debugLine="Dim noti As Notification";
main._noti = RemoteObject.createNew ("anywheresoftware.b4a.objects.NotificationWrapper");
 //BA.debugLineNum = 14;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _tabhost1_tabchanged() throws Exception{
try {
		Debug.PushSubsStack("TabHost1_TabChanged (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,73);
if (RapidSub.canDelegate("tabhost1_tabchanged")) { return anywheresoftware.b4a.samples.tabhost.main.remoteMe.runUserSub(false, "main","tabhost1_tabchanged");}
 BA.debugLineNum = 73;BA.debugLine="Sub TabHost1_TabChanged";
Debug.ShouldStop(256);
 BA.debugLineNum = 74;BA.debugLine="Activity.Title = TabHost1.CurrentTab";
Debug.ShouldStop(512);
main.mostCurrent._activity.runMethod(false,"setTitle",BA.ObjectToCharSequence(main.mostCurrent._tabhost1.runMethod(true,"getCurrentTab")));
 BA.debugLineNum = 75;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}