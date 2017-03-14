package com.qolega.qolegapp;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class starter_subs_0 {


public static RemoteObject  _application_error(RemoteObject _error,RemoteObject _stacktrace) throws Exception{
try {
		Debug.PushSubsStack("Application_Error (starter) ","starter",1,starter.processBA,starter.mostCurrent,78);
if (RapidSub.canDelegate("application_error")) return starter.remoteMe.runUserSub(false, "starter","application_error", _error, _stacktrace);
Debug.locals.put("Error", _error);
Debug.locals.put("StackTrace", _stacktrace);
 BA.debugLineNum = 78;BA.debugLine="Sub Application_Error (Error As Exception, StackTr";
Debug.ShouldStop(8192);
 BA.debugLineNum = 79;BA.debugLine="Return True";
Debug.ShouldStop(16384);
if (true) return starter.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 80;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _areequal(RemoteObject _b1,RemoteObject _b2) throws Exception{
try {
		Debug.PushSubsStack("AreEqual (starter) ","starter",1,starter.processBA,starter.mostCurrent,86);
if (RapidSub.canDelegate("areequal")) return starter.remoteMe.runUserSub(false, "starter","areequal", _b1, _b2);
Debug.locals.put("b1", _b1);
Debug.locals.put("b2", _b2);
 BA.debugLineNum = 86;BA.debugLine="Sub AreEqual(b1 As Boolean, b2 As Boolean) As Bool";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 87;BA.debugLine="If b1 <> b2 Then Return False";
Debug.ShouldStop(4194304);
if (RemoteObject.solveBoolean("!",_b1,_b2)) { 
if (true) return starter.mostCurrent.__c.getField(true,"False");};
 BA.debugLineNum = 88;BA.debugLine="Return True";
Debug.ShouldStop(8388608);
if (true) return starter.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 89;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _jobdone(RemoteObject _job) throws Exception{
try {
		Debug.PushSubsStack("JobDone (starter) ","starter",1,starter.processBA,starter.mostCurrent,35);
if (RapidSub.canDelegate("jobdone")) return starter.remoteMe.runUserSub(false, "starter","jobdone", _job);
RemoteObject _version = RemoteObject.createImmutable("");
RemoteObject _parser = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _root = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _currentversion = RemoteObject.createImmutable("");
RemoteObject _outstream = RemoteObject.declareNull("anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper");
RemoteObject _iintent = RemoteObject.declareNull("anywheresoftware.b4a.objects.IntentWrapper");
RemoteObject _k = RemoteObject.createImmutable("");
Debug.locals.put("Job", _job);
 BA.debugLineNum = 35;BA.debugLine="Sub JobDone (Job As HttpJob)";
Debug.ShouldStop(4);
 BA.debugLineNum = 36;BA.debugLine="Dim version As String = Application.VersionName";
Debug.ShouldStop(8);
_version = starter.mostCurrent.__c.getField(false,"Application").runMethod(true,"getVersionName");Debug.locals.put("version", _version);Debug.locals.put("version", _version);
 BA.debugLineNum = 37;BA.debugLine="Log(\"JobName = \" & Job.JobName & \", Success = \" &";
Debug.ShouldStop(16);
starter.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("JobName = "),_job.getField(true,"_jobname"),RemoteObject.createImmutable(", Success = "),_job.getField(true,"_success"))));
 BA.debugLineNum = 38;BA.debugLine="If  Job.Success Then";
Debug.ShouldStop(32);
if (_job.getField(true,"_success").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 39;BA.debugLine="Select Job.JobName";
Debug.ShouldStop(64);
switch (BA.switchObjectToInt(_job.getField(true,"_jobname"),BA.ObjectToString("version_check"),BA.ObjectToString("download_app"))) {
case 0: {
 BA.debugLineNum = 41;BA.debugLine="Dim parser As JSONParser";
Debug.ShouldStop(256);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 42;BA.debugLine="parser.Initialize(Job.GetString)";
Debug.ShouldStop(512);
_parser.runVoidMethod ("Initialize",(Object)(_job.runClassMethod (com.qolega.qolegapp.httpjob.class, "_getstring")));
 BA.debugLineNum = 43;BA.debugLine="Dim root As Map = parser.NextObject";
Debug.ShouldStop(1024);
_root = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_root = _parser.runMethod(false,"NextObject");Debug.locals.put("root", _root);Debug.locals.put("root", _root);
 BA.debugLineNum = 44;BA.debugLine="Dim currentversion As String = root.Get(\"versi";
Debug.ShouldStop(2048);
_currentversion = BA.ObjectToString(_root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("version")))));Debug.locals.put("currentversion", _currentversion);Debug.locals.put("currentversion", _currentversion);
 BA.debugLineNum = 46;BA.debugLine="If File.Exists(File.DirRootExternal , \"/Qolega";
Debug.ShouldStop(8192);
if (RemoteObject.solveBoolean("=",starter.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(starter.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirRootExternal")),(Object)(RemoteObject.createImmutable("/Qolega.apk"))),starter.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 47;BA.debugLine="File.Delete(File.DirRootExternal,";
Debug.ShouldStop(16384);
starter.mostCurrent.__c.getField(false,"File").runVoidMethod ("Delete",(Object)(starter.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirRootExternal")),(Object)(RemoteObject.createImmutable("/Qolega.apk")));
 BA.debugLineNum = 48;BA.debugLine="Log(\"delete file\")";
Debug.ShouldStop(32768);
starter.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("delete file")));
 };
 BA.debugLineNum = 51;BA.debugLine="If version < currentversion Then";
Debug.ShouldStop(262144);
if (RemoteObject.solveBoolean("<",BA.numberCast(double.class, _version),BA.numberCast(double.class, _currentversion))) { 
 BA.debugLineNum = 53;BA.debugLine="Log(\"Download new Version\")";
Debug.ShouldStop(1048576);
starter.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("Download new Version")));
 BA.debugLineNum = 55;BA.debugLine="CallSubDelayed(Main,\"showUpdateDialog\")";
Debug.ShouldStop(4194304);
starter.mostCurrent.__c.runVoidMethod ("CallSubDelayed",starter.processBA,(Object)((starter.mostCurrent._main.getObject())),(Object)(RemoteObject.createImmutable("showUpdateDialog")));
 };
 break; }
case 1: {
 BA.debugLineNum = 60;BA.debugLine="Dim OutStream As OutputStream";
Debug.ShouldStop(134217728);
_outstream = RemoteObject.createNew ("anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper");Debug.locals.put("OutStream", _outstream);
 BA.debugLineNum = 61;BA.debugLine="OutStream = File.OpenOutput(File.DirRootExtern";
Debug.ShouldStop(268435456);
_outstream = starter.mostCurrent.__c.getField(false,"File").runMethod(false,"OpenOutput",(Object)(starter.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirRootExternal")),(Object)(BA.ObjectToString("/Qolega.apk")),(Object)(starter.mostCurrent.__c.getField(true,"False")));Debug.locals.put("OutStream", _outstream);
 BA.debugLineNum = 62;BA.debugLine="File.Copy2(Job.GetInputStream,OutStream)";
Debug.ShouldStop(536870912);
starter.mostCurrent.__c.getField(false,"File").runVoidMethod ("Copy2",(Object)((_job.runClassMethod (com.qolega.qolegapp.httpjob.class, "_getinputstream").getObject())),(Object)((_outstream.getObject())));
 BA.debugLineNum = 63;BA.debugLine="OutStream.Close";
Debug.ShouldStop(1073741824);
_outstream.runVoidMethod ("Close");
 BA.debugLineNum = 65;BA.debugLine="ToastMessageShow(\"Download Complete, Now Insta";
Debug.ShouldStop(1);
starter.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToString("Download Complete, Now Installing.!")),(Object)(starter.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 67;BA.debugLine="Dim iIntent As Intent";
Debug.ShouldStop(4);
_iintent = RemoteObject.createNew ("anywheresoftware.b4a.objects.IntentWrapper");Debug.locals.put("iIntent", _iintent);
 BA.debugLineNum = 68;BA.debugLine="Dim k As String=\"file://\" & File.DirRoot";
Debug.ShouldStop(8);
_k = RemoteObject.concat(RemoteObject.createImmutable("file://"),starter.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirRootExternal"),RemoteObject.createImmutable("/Qolega.apk"));Debug.locals.put("k", _k);Debug.locals.put("k", _k);
 BA.debugLineNum = 69;BA.debugLine="Log(k)";
Debug.ShouldStop(16);
starter.mostCurrent.__c.runVoidMethod ("Log",(Object)(_k));
 BA.debugLineNum = 70;BA.debugLine="iIntent.Initialize(iIntent.ACTION_VIEW,k";
Debug.ShouldStop(32);
_iintent.runVoidMethod ("Initialize",(Object)(_iintent.getField(true,"ACTION_VIEW")),(Object)(_k));
 BA.debugLineNum = 71;BA.debugLine="iIntent.SetType(\"application/vnd.android";
Debug.ShouldStop(64);
_iintent.runVoidMethod ("SetType",(Object)(RemoteObject.createImmutable("application/vnd.android.package-archive")));
 BA.debugLineNum = 72;BA.debugLine="StartActivity(iIntent)";
Debug.ShouldStop(128);
starter.mostCurrent.__c.runVoidMethod ("StartActivity",starter.processBA,(Object)((_iintent.getObject())));
 break; }
}
;
 };
 BA.debugLineNum = 75;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Private gHttpVersionJob,updateApp As HttpJob";
starter._ghttpversionjob = RemoteObject.createNew ("com.qolega.qolegapp.httpjob");
starter._updateapp = RemoteObject.createNew ("com.qolega.qolegapp.httpjob");
 //BA.debugLineNum = 10;BA.debugLine="Public getVersion As String  = \"https://bondan";
starter._getversion = BA.ObjectToString("https://bondan.biz/android/version.json");
 //BA.debugLineNum = 11;BA.debugLine="Public downloadAppUrl As String  = \"https://bo";
starter._downloadappurl = BA.ObjectToString("https://bondan.biz/android/Qolega.apk");
 //BA.debugLineNum = 12;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _service_create() throws Exception{
try {
		Debug.PushSubsStack("Service_Create (starter) ","starter",1,starter.processBA,starter.mostCurrent,14);
if (RapidSub.canDelegate("service_create")) return starter.remoteMe.runUserSub(false, "starter","service_create");
RemoteObject _manager = RemoteObject.declareNull("anywheresoftware.b4a.objects.preferenceactivity.PreferenceManager");
RemoteObject _islogin = RemoteObject.createImmutable(false);
 BA.debugLineNum = 14;BA.debugLine="Sub Service_Create";
Debug.ShouldStop(8192);
 BA.debugLineNum = 15;BA.debugLine="Dim manager As PreferenceManager";
Debug.ShouldStop(16384);
_manager = RemoteObject.createNew ("anywheresoftware.b4a.objects.preferenceactivity.PreferenceManager");Debug.locals.put("manager", _manager);
 BA.debugLineNum = 18;BA.debugLine="Dim isLogin As Boolean = manager.GetBoolean(\"is_l";
Debug.ShouldStop(131072);
_islogin = _manager.runMethod(true,"GetBoolean",(Object)(RemoteObject.createImmutable("is_login")));Debug.locals.put("isLogin", _islogin);Debug.locals.put("isLogin", _islogin);
 BA.debugLineNum = 21;BA.debugLine="If AreEqual(isLogin,False) Then";
Debug.ShouldStop(1048576);
if (_areequal(_islogin,starter.mostCurrent.__c.getField(true,"False")).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 22;BA.debugLine="ToastMessageShow(\"Checking Version...\",False)";
Debug.ShouldStop(2097152);
starter.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToString("Checking Version...")),(Object)(starter.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 25;BA.debugLine="gHttpVersionJob.Initialize(\"version_check\", Me)";
Debug.ShouldStop(16777216);
starter._ghttpversionjob.runClassMethod (com.qolega.qolegapp.httpjob.class, "_initialize",starter.processBA,(Object)(BA.ObjectToString("version_check")),(Object)(starter.getObject()));
 BA.debugLineNum = 26;BA.debugLine="gHttpVersionJob.Download(getVersion)";
Debug.ShouldStop(33554432);
starter._ghttpversionjob.runClassMethod (com.qolega.qolegapp.httpjob.class, "_download",(Object)(starter._getversion));
 };
 BA.debugLineNum = 28;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _service_destroy() throws Exception{
try {
		Debug.PushSubsStack("Service_Destroy (starter) ","starter",1,starter.processBA,starter.mostCurrent,82);
if (RapidSub.canDelegate("service_destroy")) return starter.remoteMe.runUserSub(false, "starter","service_destroy");
 BA.debugLineNum = 82;BA.debugLine="Sub Service_Destroy";
Debug.ShouldStop(131072);
 BA.debugLineNum = 84;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _service_start(RemoteObject _startingintent) throws Exception{
try {
		Debug.PushSubsStack("Service_Start (starter) ","starter",1,starter.processBA,starter.mostCurrent,30);
if (RapidSub.canDelegate("service_start")) return starter.remoteMe.runUserSub(false, "starter","service_start", _startingintent);
Debug.locals.put("StartingIntent", _startingintent);
 BA.debugLineNum = 30;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 32;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
}