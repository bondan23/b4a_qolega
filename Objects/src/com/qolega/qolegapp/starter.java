package com.qolega.qolegapp;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.objects.ServiceHelper;
import anywheresoftware.b4a.debug.*;

public class starter extends android.app.Service {
	public static class starter_BR extends android.content.BroadcastReceiver {

		@Override
		public void onReceive(android.content.Context context, android.content.Intent intent) {
			android.content.Intent in = new android.content.Intent(context, starter.class);
			if (intent != null)
				in.putExtra("b4a_internal_intent", intent);
			context.startService(in);
		}

	}
    static starter mostCurrent;
	public static BA processBA;
    private ServiceHelper _service;
    public static Class<?> getObject() {
		return starter.class;
	}
	@Override
	public void onCreate() {
        mostCurrent = this;
        if (processBA == null) {
		    processBA = new BA(this, null, null, "com.qolega.qolegapp", "com.qolega.qolegapp.starter");
            if (BA.isShellModeRuntimeCheck(processBA)) {
                processBA.raiseEvent2(null, true, "SHELL", false);
		    }
            try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            processBA.loadHtSubs(this.getClass());
            ServiceHelper.init();
        }
        _service = new ServiceHelper(this);
        processBA.service = this;
        processBA.setActivityPaused(false);
        if (BA.isShellModeRuntimeCheck(processBA)) {
			processBA.raiseEvent2(null, true, "CREATE", true, "com.qolega.qolegapp.starter", processBA, _service, anywheresoftware.b4a.keywords.Common.Density);
		}
        if (!true && ServiceHelper.StarterHelper.startFromServiceCreate(processBA, false) == false) {
				
		}
		else {
            BA.LogInfo("** Service (starter) Create **");
            processBA.raiseEvent(null, "service_create");
        }
        processBA.runHook("oncreate", this, null);
        if (true) {
			if (ServiceHelper.StarterHelper.waitForLayout != null)
				BA.handler.post(ServiceHelper.StarterHelper.waitForLayout);
		}
    }
		@Override
	public void onStart(android.content.Intent intent, int startId) {
		onStartCommand(intent, 0, 0);
    }
    @Override
    public int onStartCommand(final android.content.Intent intent, int flags, int startId) {
    	if (ServiceHelper.StarterHelper.onStartCommand(processBA))
			handleStart(intent);
		else {
			ServiceHelper.StarterHelper.waitForLayout = new Runnable() {
				public void run() {
                    BA.LogInfo("** Service (starter) Create **");
                    processBA.raiseEvent(null, "service_create");
					handleStart(intent);
				}
			};
		}
        processBA.runHook("onstartcommand", this, new Object[] {intent, flags, startId});
		return android.app.Service.START_NOT_STICKY;
    }
    private void handleStart(android.content.Intent intent) {
    	BA.LogInfo("** Service (starter) Start **");
    	java.lang.reflect.Method startEvent = processBA.htSubs.get("service_start");
    	if (startEvent != null) {
    		if (startEvent.getParameterTypes().length > 0) {
    			anywheresoftware.b4a.objects.IntentWrapper iw = new anywheresoftware.b4a.objects.IntentWrapper();
    			if (intent != null) {
    				if (intent.hasExtra("b4a_internal_intent"))
    					iw.setObject((android.content.Intent) intent.getParcelableExtra("b4a_internal_intent"));
    				else
    					iw.setObject(intent);
    			}
    			processBA.raiseEvent(null, "service_start", iw);
    		}
    		else {
    			processBA.raiseEvent(null, "service_start");
    		}
    	}
    }
	@Override
	public android.os.IBinder onBind(android.content.Intent intent) {
		return null;
	}
	@Override
	public void onDestroy() {
        BA.LogInfo("** Service (starter) Destroy **");
		processBA.raiseEvent(null, "service_destroy");
        processBA.service = null;
		mostCurrent = null;
		processBA.setActivityPaused(true);
        processBA.runHook("ondestroy", this, null);
	}
public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.samples.httputils2.httpjob _ghttpversionjob = null;
public static anywheresoftware.b4a.samples.httputils2.httpjob _updateapp = null;
public static String _getversion = "";
public static String _downloadappurl = "";
public anywheresoftware.b4a.samples.httputils2.httputils2service _httputils2service = null;
public com.qolega.qolegapp.main _main = null;
public com.qolega.qolegapp.referringlist _referringlist = null;
public com.qolega.qolegapp.referringprogress _referringprogress = null;
public com.qolega.qolegapp.testresponsive _testresponsive = null;
public com.qolega.qolegapp.test3 _test3 = null;
public com.qolega.qolegapp.test4 _test4 = null;
public static boolean  _application_error(anywheresoftware.b4a.objects.B4AException _error,String _stacktrace) throws Exception{
 //BA.debugLineNum = 78;BA.debugLine="Sub Application_Error (Error As Exception, StackTr";
 //BA.debugLineNum = 79;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 80;BA.debugLine="End Sub";
return false;
}
public static boolean  _areequal(boolean _b1,boolean _b2) throws Exception{
 //BA.debugLineNum = 86;BA.debugLine="Sub AreEqual(b1 As Boolean, b2 As Boolean) As Bool";
 //BA.debugLineNum = 87;BA.debugLine="If b1 <> b2 Then Return False";
if (_b1!=_b2) { 
if (true) return anywheresoftware.b4a.keywords.Common.False;};
 //BA.debugLineNum = 88;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 89;BA.debugLine="End Sub";
return false;
}
public static String  _jobdone(anywheresoftware.b4a.samples.httputils2.httpjob _job) throws Exception{
String _version = "";
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.Map _root = null;
String _currentversion = "";
anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper _outstream = null;
anywheresoftware.b4a.objects.IntentWrapper _iintent = null;
String _k = "";
 //BA.debugLineNum = 35;BA.debugLine="Sub JobDone (Job As HttpJob)";
 //BA.debugLineNum = 36;BA.debugLine="Dim version As String = Application.VersionName";
_version = anywheresoftware.b4a.keywords.Common.Application.getVersionName();
 //BA.debugLineNum = 37;BA.debugLine="Log(\"JobName = \" & Job.JobName & \", Success = \" &";
anywheresoftware.b4a.keywords.Common.Log("JobName = "+_job._jobname+", Success = "+BA.ObjectToString(_job._success));
 //BA.debugLineNum = 38;BA.debugLine="If  Job.Success Then";
if (_job._success) { 
 //BA.debugLineNum = 39;BA.debugLine="Select Job.JobName";
switch (BA.switchObjectToInt(_job._jobname,"version_check","download_app")) {
case 0: {
 //BA.debugLineNum = 41;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
 //BA.debugLineNum = 42;BA.debugLine="parser.Initialize(Job.GetString)";
_parser.Initialize(_job._getstring());
 //BA.debugLineNum = 43;BA.debugLine="Dim root As Map = parser.NextObject";
_root = new anywheresoftware.b4a.objects.collections.Map();
_root = _parser.NextObject();
 //BA.debugLineNum = 44;BA.debugLine="Dim currentversion As String = root.Get(\"versi";
_currentversion = BA.ObjectToString(_root.Get((Object)("version")));
 //BA.debugLineNum = 46;BA.debugLine="If File.Exists(File.DirRootExternal , \"/Qolega";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirRootExternal(),"/Qolega.apk")==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 47;BA.debugLine="File.Delete(File.DirRootExternal,";
anywheresoftware.b4a.keywords.Common.File.Delete(anywheresoftware.b4a.keywords.Common.File.getDirRootExternal(),"/Qolega.apk");
 //BA.debugLineNum = 48;BA.debugLine="Log(\"delete file\")";
anywheresoftware.b4a.keywords.Common.Log("delete file");
 };
 //BA.debugLineNum = 51;BA.debugLine="If version < currentversion Then";
if ((double)(Double.parseDouble(_version))<(double)(Double.parseDouble(_currentversion))) { 
 //BA.debugLineNum = 53;BA.debugLine="Log(\"Download new Version\")";
anywheresoftware.b4a.keywords.Common.Log("Download new Version");
 //BA.debugLineNum = 55;BA.debugLine="CallSubDelayed(Main,\"showUpdateDialog\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(processBA,(Object)(mostCurrent._main.getObject()),"showUpdateDialog");
 };
 break; }
case 1: {
 //BA.debugLineNum = 60;BA.debugLine="Dim OutStream As OutputStream";
_outstream = new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper();
 //BA.debugLineNum = 61;BA.debugLine="OutStream = File.OpenOutput(File.DirRootExtern";
_outstream = anywheresoftware.b4a.keywords.Common.File.OpenOutput(anywheresoftware.b4a.keywords.Common.File.getDirRootExternal(),"/Qolega.apk",anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 62;BA.debugLine="File.Copy2(Job.GetInputStream,OutStream)";
anywheresoftware.b4a.keywords.Common.File.Copy2((java.io.InputStream)(_job._getinputstream().getObject()),(java.io.OutputStream)(_outstream.getObject()));
 //BA.debugLineNum = 63;BA.debugLine="OutStream.Close";
_outstream.Close();
 //BA.debugLineNum = 65;BA.debugLine="ToastMessageShow(\"Download Complete, Now Insta";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("Download Complete, Now Installing.!",anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 67;BA.debugLine="Dim iIntent As Intent";
_iintent = new anywheresoftware.b4a.objects.IntentWrapper();
 //BA.debugLineNum = 68;BA.debugLine="Dim k As String=\"file://\" & File.DirRoot";
_k = "file://"+anywheresoftware.b4a.keywords.Common.File.getDirRootExternal()+"/Qolega.apk";
 //BA.debugLineNum = 69;BA.debugLine="Log(k)";
anywheresoftware.b4a.keywords.Common.Log(_k);
 //BA.debugLineNum = 70;BA.debugLine="iIntent.Initialize(iIntent.ACTION_VIEW,k";
_iintent.Initialize(_iintent.ACTION_VIEW,_k);
 //BA.debugLineNum = 71;BA.debugLine="iIntent.SetType(\"application/vnd.android";
_iintent.SetType("application/vnd.android.package-archive");
 //BA.debugLineNum = 72;BA.debugLine="StartActivity(iIntent)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_iintent.getObject()));
 break; }
}
;
 };
 //BA.debugLineNum = 75;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Private gHttpVersionJob,updateApp As HttpJob";
_ghttpversionjob = new anywheresoftware.b4a.samples.httputils2.httpjob();
_updateapp = new anywheresoftware.b4a.samples.httputils2.httpjob();
 //BA.debugLineNum = 10;BA.debugLine="Public getVersion As String  = \"https://bondan";
_getversion = "https://bondan.biz/android/version.json";
 //BA.debugLineNum = 11;BA.debugLine="Public downloadAppUrl As String  = \"https://bo";
_downloadappurl = "https://bondan.biz/android/Qolega.apk";
 //BA.debugLineNum = 12;BA.debugLine="End Sub";
return "";
}
public static String  _service_create() throws Exception{
anywheresoftware.b4a.objects.preferenceactivity.PreferenceManager _manager = null;
boolean _islogin = false;
 //BA.debugLineNum = 14;BA.debugLine="Sub Service_Create";
 //BA.debugLineNum = 15;BA.debugLine="Dim manager As PreferenceManager";
_manager = new anywheresoftware.b4a.objects.preferenceactivity.PreferenceManager();
 //BA.debugLineNum = 18;BA.debugLine="Dim isLogin As Boolean = manager.GetBoolean(\"is_l";
_islogin = _manager.GetBoolean("is_login");
 //BA.debugLineNum = 21;BA.debugLine="If AreEqual(isLogin,False) Then";
if (_areequal(_islogin,anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 22;BA.debugLine="ToastMessageShow(\"Checking Version...\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("Checking Version...",anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 25;BA.debugLine="gHttpVersionJob.Initialize(\"version_check\", Me)";
_ghttpversionjob._initialize(processBA,"version_check",starter.getObject());
 //BA.debugLineNum = 26;BA.debugLine="gHttpVersionJob.Download(getVersion)";
_ghttpversionjob._download(_getversion);
 };
 //BA.debugLineNum = 28;BA.debugLine="End Sub";
return "";
}
public static String  _service_destroy() throws Exception{
 //BA.debugLineNum = 82;BA.debugLine="Sub Service_Destroy";
 //BA.debugLineNum = 84;BA.debugLine="End Sub";
return "";
}
public static String  _service_start(anywheresoftware.b4a.objects.IntentWrapper _startingintent) throws Exception{
 //BA.debugLineNum = 30;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
 //BA.debugLineNum = 32;BA.debugLine="End Sub";
return "";
}
}
