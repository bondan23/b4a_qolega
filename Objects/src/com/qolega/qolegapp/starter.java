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
		    processBA = new anywheresoftware.b4a.ShellBA(this, null, null, "com.qolega.qolegapp", "com.qolega.qolegapp.starter");
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
public static com.qolega.qolegapp.httpjob _ghttpversionjob = null;
public static com.qolega.qolegapp.httpjob _updateapp = null;
public static String _getversion = "";
public static String _downloadappurl = "";
public com.qolega.qolegapp.main _main = null;
public com.qolega.qolegapp.referringlist _referringlist = null;
public com.qolega.qolegapp.referringprogress _referringprogress = null;
public com.qolega.qolegapp.testresponsive _testresponsive = null;
public com.qolega.qolegapp.test3 _test3 = null;
public com.qolega.qolegapp.httputils2service _httputils2service = null;
public com.qolega.qolegapp.test4 _test4 = null;
public static boolean  _application_error(anywheresoftware.b4a.objects.B4AException _error,String _stacktrace) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "application_error"))
	return (Boolean) Debug.delegate(processBA, "application_error", new Object[] {_error,_stacktrace});
RDebugUtils.currentLine=589824;
 //BA.debugLineNum = 589824;BA.debugLine="Sub Application_Error (Error As Exception, StackTr";
RDebugUtils.currentLine=589825;
 //BA.debugLineNum = 589825;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=589826;
 //BA.debugLineNum = 589826;BA.debugLine="End Sub";
return false;
}
public static boolean  _areequal(boolean _b1,boolean _b2) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "areequal"))
	return (Boolean) Debug.delegate(processBA, "areequal", new Object[] {_b1,_b2});
RDebugUtils.currentLine=720896;
 //BA.debugLineNum = 720896;BA.debugLine="Sub AreEqual(b1 As Boolean, b2 As Boolean) As Bool";
RDebugUtils.currentLine=720897;
 //BA.debugLineNum = 720897;BA.debugLine="If b1 <> b2 Then Return False";
if (_b1!=_b2) { 
if (true) return anywheresoftware.b4a.keywords.Common.False;};
RDebugUtils.currentLine=720898;
 //BA.debugLineNum = 720898;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=720899;
 //BA.debugLineNum = 720899;BA.debugLine="End Sub";
return false;
}
public static String  _jobdone(com.qolega.qolegapp.httpjob _job) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "jobdone"))
	return (String) Debug.delegate(processBA, "jobdone", new Object[] {_job});
String _version = "";
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.Map _root = null;
String _currentversion = "";
anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper _outstream = null;
anywheresoftware.b4a.objects.IntentWrapper _iintent = null;
String _k = "";
RDebugUtils.currentLine=524288;
 //BA.debugLineNum = 524288;BA.debugLine="Sub JobDone (Job As HttpJob)";
RDebugUtils.currentLine=524289;
 //BA.debugLineNum = 524289;BA.debugLine="Dim version As String = Application.VersionName";
_version = anywheresoftware.b4a.keywords.Common.Application.getVersionName();
RDebugUtils.currentLine=524290;
 //BA.debugLineNum = 524290;BA.debugLine="Log(\"JobName = \" & Job.JobName & \", Success = \" &";
anywheresoftware.b4a.keywords.Common.Log("JobName = "+_job._jobname+", Success = "+BA.ObjectToString(_job._success));
RDebugUtils.currentLine=524291;
 //BA.debugLineNum = 524291;BA.debugLine="If  Job.Success Then";
if (_job._success) { 
RDebugUtils.currentLine=524292;
 //BA.debugLineNum = 524292;BA.debugLine="Select Job.JobName";
switch (BA.switchObjectToInt(_job._jobname,"version_check","download_app")) {
case 0: {
RDebugUtils.currentLine=524294;
 //BA.debugLineNum = 524294;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=524295;
 //BA.debugLineNum = 524295;BA.debugLine="parser.Initialize(Job.GetString)";
_parser.Initialize(_job._getstring(null));
RDebugUtils.currentLine=524296;
 //BA.debugLineNum = 524296;BA.debugLine="Dim root As Map = parser.NextObject";
_root = new anywheresoftware.b4a.objects.collections.Map();
_root = _parser.NextObject();
RDebugUtils.currentLine=524297;
 //BA.debugLineNum = 524297;BA.debugLine="Dim currentversion As String = root.Get(\"versi";
_currentversion = BA.ObjectToString(_root.Get((Object)("version")));
RDebugUtils.currentLine=524299;
 //BA.debugLineNum = 524299;BA.debugLine="If File.Exists(File.DirRootExternal , \"/Qolega";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirRootExternal(),"/Qolega.apk")==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=524300;
 //BA.debugLineNum = 524300;BA.debugLine="File.Delete(File.DirRootExternal,";
anywheresoftware.b4a.keywords.Common.File.Delete(anywheresoftware.b4a.keywords.Common.File.getDirRootExternal(),"/Qolega.apk");
RDebugUtils.currentLine=524301;
 //BA.debugLineNum = 524301;BA.debugLine="Log(\"delete file\")";
anywheresoftware.b4a.keywords.Common.Log("delete file");
 };
RDebugUtils.currentLine=524304;
 //BA.debugLineNum = 524304;BA.debugLine="If version < currentversion Then";
if ((double)(Double.parseDouble(_version))<(double)(Double.parseDouble(_currentversion))) { 
RDebugUtils.currentLine=524306;
 //BA.debugLineNum = 524306;BA.debugLine="Log(\"Download new Version\")";
anywheresoftware.b4a.keywords.Common.Log("Download new Version");
RDebugUtils.currentLine=524308;
 //BA.debugLineNum = 524308;BA.debugLine="CallSubDelayed(Main,\"showUpdateDialog\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(processBA,(Object)(mostCurrent._main.getObject()),"showUpdateDialog");
 };
 break; }
case 1: {
RDebugUtils.currentLine=524313;
 //BA.debugLineNum = 524313;BA.debugLine="Dim OutStream As OutputStream";
_outstream = new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper();
RDebugUtils.currentLine=524314;
 //BA.debugLineNum = 524314;BA.debugLine="OutStream = File.OpenOutput(File.DirRootExtern";
_outstream = anywheresoftware.b4a.keywords.Common.File.OpenOutput(anywheresoftware.b4a.keywords.Common.File.getDirRootExternal(),"/Qolega.apk",anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=524315;
 //BA.debugLineNum = 524315;BA.debugLine="File.Copy2(Job.GetInputStream,OutStream)";
anywheresoftware.b4a.keywords.Common.File.Copy2((java.io.InputStream)(_job._getinputstream(null).getObject()),(java.io.OutputStream)(_outstream.getObject()));
RDebugUtils.currentLine=524316;
 //BA.debugLineNum = 524316;BA.debugLine="OutStream.Close";
_outstream.Close();
RDebugUtils.currentLine=524318;
 //BA.debugLineNum = 524318;BA.debugLine="ToastMessageShow(\"Download Complete, Now Insta";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("Download Complete, Now Installing.!",anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=524320;
 //BA.debugLineNum = 524320;BA.debugLine="Dim iIntent As Intent";
_iintent = new anywheresoftware.b4a.objects.IntentWrapper();
RDebugUtils.currentLine=524321;
 //BA.debugLineNum = 524321;BA.debugLine="Dim k As String=\"file://\" & File.DirRoot";
_k = "file://"+anywheresoftware.b4a.keywords.Common.File.getDirRootExternal()+"/Qolega.apk";
RDebugUtils.currentLine=524322;
 //BA.debugLineNum = 524322;BA.debugLine="Log(k)";
anywheresoftware.b4a.keywords.Common.Log(_k);
RDebugUtils.currentLine=524323;
 //BA.debugLineNum = 524323;BA.debugLine="iIntent.Initialize(iIntent.ACTION_VIEW,k";
_iintent.Initialize(_iintent.ACTION_VIEW,_k);
RDebugUtils.currentLine=524324;
 //BA.debugLineNum = 524324;BA.debugLine="iIntent.SetType(\"application/vnd.android";
_iintent.SetType("application/vnd.android.package-archive");
RDebugUtils.currentLine=524325;
 //BA.debugLineNum = 524325;BA.debugLine="StartActivity(iIntent)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_iintent.getObject()));
 break; }
}
;
 };
RDebugUtils.currentLine=524328;
 //BA.debugLineNum = 524328;BA.debugLine="End Sub";
return "";
}
public static String  _service_create() throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "service_create"))
	return (String) Debug.delegate(processBA, "service_create", null);
anywheresoftware.b4a.objects.preferenceactivity.PreferenceManager _manager = null;
boolean _islogin = false;
RDebugUtils.currentLine=393216;
 //BA.debugLineNum = 393216;BA.debugLine="Sub Service_Create";
RDebugUtils.currentLine=393217;
 //BA.debugLineNum = 393217;BA.debugLine="Dim manager As PreferenceManager";
_manager = new anywheresoftware.b4a.objects.preferenceactivity.PreferenceManager();
RDebugUtils.currentLine=393220;
 //BA.debugLineNum = 393220;BA.debugLine="Dim isLogin As Boolean = manager.GetBoolean(\"is_l";
_islogin = _manager.GetBoolean("is_login");
RDebugUtils.currentLine=393223;
 //BA.debugLineNum = 393223;BA.debugLine="If AreEqual(isLogin,False) Then";
if (_areequal(_islogin,anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=393224;
 //BA.debugLineNum = 393224;BA.debugLine="ToastMessageShow(\"Checking Version...\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("Checking Version...",anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=393227;
 //BA.debugLineNum = 393227;BA.debugLine="gHttpVersionJob.Initialize(\"version_check\", Me)";
_ghttpversionjob._initialize(null,processBA,"version_check",starter.getObject());
RDebugUtils.currentLine=393228;
 //BA.debugLineNum = 393228;BA.debugLine="gHttpVersionJob.Download(getVersion)";
_ghttpversionjob._download(null,_getversion);
 };
RDebugUtils.currentLine=393230;
 //BA.debugLineNum = 393230;BA.debugLine="End Sub";
return "";
}
public static String  _service_destroy() throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "service_destroy"))
	return (String) Debug.delegate(processBA, "service_destroy", null);
RDebugUtils.currentLine=655360;
 //BA.debugLineNum = 655360;BA.debugLine="Sub Service_Destroy";
RDebugUtils.currentLine=655362;
 //BA.debugLineNum = 655362;BA.debugLine="End Sub";
return "";
}
public static String  _service_start(anywheresoftware.b4a.objects.IntentWrapper _startingintent) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "service_start"))
	return (String) Debug.delegate(processBA, "service_start", new Object[] {_startingintent});
RDebugUtils.currentLine=458752;
 //BA.debugLineNum = 458752;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
RDebugUtils.currentLine=458754;
 //BA.debugLineNum = 458754;BA.debugLine="End Sub";
return "";
}
}