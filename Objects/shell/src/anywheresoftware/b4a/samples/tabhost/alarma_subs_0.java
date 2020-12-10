package anywheresoftware.b4a.samples.tabhost;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class alarma_subs_0 {


public static RemoteObject  _playalarm() throws Exception{
try {
		Debug.PushSubsStack("PlayAlarm (alarma) ","alarma",1,alarma.processBA,alarma.mostCurrent,26);
if (RapidSub.canDelegate("playalarm")) { return anywheresoftware.b4a.samples.tabhost.alarma.remoteMe.runUserSub(false, "alarma","playalarm");}
 BA.debugLineNum = 26;BA.debugLine="Sub PlayAlarm";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 27;BA.debugLine="mp.Load(File.DirAssets, \"alarma.mp3\")";
Debug.ShouldStop(67108864);
alarma._mp.runVoidMethod ("Load",(Object)(alarma.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("alarma.mp3")));
 BA.debugLineNum = 28;BA.debugLine="mp.Play";
Debug.ShouldStop(134217728);
alarma._mp.runVoidMethod ("Play");
 BA.debugLineNum = 29;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Dim mp As MediaPlayer";
alarma._mp = RemoteObject.createNew ("anywheresoftware.b4a.objects.MediaPlayerWrapper");
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _service_create() throws Exception{
try {
		Debug.PushSubsStack("Service_Create (alarma) ","alarma",1,alarma.processBA,alarma.mostCurrent,12);
if (RapidSub.canDelegate("service_create")) { return anywheresoftware.b4a.samples.tabhost.alarma.remoteMe.runUserSub(false, "alarma","service_create");}
 BA.debugLineNum = 12;BA.debugLine="Sub Service_Create";
Debug.ShouldStop(2048);
 BA.debugLineNum = 14;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _service_destroy() throws Exception{
try {
		Debug.PushSubsStack("Service_Destroy (alarma) ","alarma",1,alarma.processBA,alarma.mostCurrent,22);
if (RapidSub.canDelegate("service_destroy")) { return anywheresoftware.b4a.samples.tabhost.alarma.remoteMe.runUserSub(false, "alarma","service_destroy");}
 BA.debugLineNum = 22;BA.debugLine="Sub Service_Destroy";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 23;BA.debugLine="StopService(\"\")";
Debug.ShouldStop(4194304);
alarma.mostCurrent.__c.runVoidMethod ("StopService",alarma.processBA,(Object)((RemoteObject.createImmutable(""))));
 BA.debugLineNum = 24;BA.debugLine="CancelScheduledService(\"\")";
Debug.ShouldStop(8388608);
alarma.mostCurrent.__c.runVoidMethod ("CancelScheduledService",alarma.processBA,(Object)((RemoteObject.createImmutable(""))));
 BA.debugLineNum = 25;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _service_start(RemoteObject _startingintent) throws Exception{
try {
		Debug.PushSubsStack("Service_Start (alarma) ","alarma",1,alarma.processBA,alarma.mostCurrent,16);
if (RapidSub.canDelegate("service_start")) { return anywheresoftware.b4a.samples.tabhost.alarma.remoteMe.runUserSub(false, "alarma","service_start", _startingintent);}
Debug.locals.put("StartingIntent", _startingintent);
 BA.debugLineNum = 16;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
Debug.ShouldStop(32768);
 BA.debugLineNum = 17;BA.debugLine="mp.Initialize()";
Debug.ShouldStop(65536);
alarma._mp.runVoidMethod ("Initialize");
 BA.debugLineNum = 18;BA.debugLine="PlayAlarm";
Debug.ShouldStop(131072);
_playalarm();
 BA.debugLineNum = 19;BA.debugLine="ToastMessageShow(\"Tienes Restricción vehicular\",T";
Debug.ShouldStop(262144);
alarma.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Tienes Restricción vehicular")),(Object)(alarma.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 20;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}