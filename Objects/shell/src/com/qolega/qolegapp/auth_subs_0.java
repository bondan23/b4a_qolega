package com.qolega.qolegapp;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class auth_subs_0 {


public static RemoteObject  _checkloginsession(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("CheckLoginSession (auth) ","auth",6,__ref.getField(false, "ba"),__ref,78);
if (RapidSub.canDelegate("checkloginsession")) return __ref.runUserSub(false, "auth","checkloginsession", __ref);
RemoteObject _islogin = RemoteObject.createImmutable(false);
 BA.debugLineNum = 78;BA.debugLine="Public Sub CheckLoginSession()";
Debug.ShouldStop(8192);
 BA.debugLineNum = 79;BA.debugLine="Dim isLogin As Boolean";
Debug.ShouldStop(16384);
_islogin = RemoteObject.createImmutable(false);Debug.locals.put("isLogin", _islogin);
 BA.debugLineNum = 80;BA.debugLine="isLogin = manager.GetBoolean(\"is_login\")";
Debug.ShouldStop(32768);
_islogin = __ref.getField(false,"_manager").runMethod(true,"GetBoolean",(Object)(RemoteObject.createImmutable("is_login")));Debug.locals.put("isLogin", _islogin);
 BA.debugLineNum = 82;BA.debugLine="If isLogin = True Then";
Debug.ShouldStop(131072);
if (RemoteObject.solveBoolean("=",_islogin,auth.__c.getField(true,"True"))) { 
 BA.debugLineNum = 83;BA.debugLine="StartActivity(ReferringList)";
Debug.ShouldStop(262144);
auth.__c.runVoidMethod ("StartActivity",__ref.getField(false, "ba"),(Object)((auth._referringlist.getObject())));
 BA.debugLineNum = 84;BA.debugLine="Act.Finish";
Debug.ShouldStop(524288);
__ref.getField(false,"_act").runVoidMethod ("Finish");
 };
 BA.debugLineNum = 86;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _class_globals(RemoteObject __ref) throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 3;BA.debugLine="Dim manager As PreferenceManager";
auth._manager = RemoteObject.createNew ("anywheresoftware.b4a.objects.preferenceactivity.PreferenceManager");__ref.setField("_manager",auth._manager);
 //BA.debugLineNum = 4;BA.debugLine="Dim Act As Activity";
auth._act = RemoteObject.createNew ("anywheresoftware.b4a.objects.ActivityWrapper");__ref.setField("_act",auth._act);
 //BA.debugLineNum = 5;BA.debugLine="Private urlApi,clientSecret,clientId As String";
auth._urlapi = RemoteObject.createImmutable("");__ref.setField("_urlapi",auth._urlapi);
auth._clientsecret = RemoteObject.createImmutable("");__ref.setField("_clientsecret",auth._clientsecret);
auth._clientid = RemoteObject.createImmutable("");__ref.setField("_clientid",auth._clientid);
 //BA.debugLineNum = 6;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _encodebasicauth(RemoteObject __ref,RemoteObject _username,RemoteObject _password) throws Exception{
try {
		Debug.PushSubsStack("EncodeBasicAuth (auth) ","auth",6,__ref.getField(false, "ba"),__ref,105);
if (RapidSub.canDelegate("encodebasicauth")) return __ref.runUserSub(false, "auth","encodebasicauth", __ref, _username, _password);
RemoteObject _su = RemoteObject.declareNull("anywheresoftware.b4a.objects.StringUtils");
RemoteObject _tempstr = RemoteObject.createImmutable("");
RemoteObject _bc = RemoteObject.declareNull("anywheresoftware.b4a.agraham.byteconverter.ByteConverter");
Debug.locals.put("username", _username);
Debug.locals.put("password", _password);
 BA.debugLineNum = 105;BA.debugLine="Private Sub EncodeBasicAuth(username As String, pa";
Debug.ShouldStop(256);
 BA.debugLineNum = 106;BA.debugLine="Dim su As StringUtils,tempstr As String,bc As";
Debug.ShouldStop(512);
_su = RemoteObject.createNew ("anywheresoftware.b4a.objects.StringUtils");Debug.locals.put("su", _su);
_tempstr = RemoteObject.createImmutable("");Debug.locals.put("tempstr", _tempstr);
_bc = RemoteObject.createNew ("anywheresoftware.b4a.agraham.byteconverter.ByteConverter");Debug.locals.put("bc", _bc);
 BA.debugLineNum = 107;BA.debugLine="tempstr = username&\":\"&password";
Debug.ShouldStop(1024);
_tempstr = RemoteObject.concat(_username,RemoteObject.createImmutable(":"),_password);Debug.locals.put("tempstr", _tempstr);
 BA.debugLineNum = 108;BA.debugLine="Return su.EncodeBase64(bc.StringToBytes(tempstr,\"";
Debug.ShouldStop(2048);
Debug.CheckDeviceExceptions();if (true) return _su.runMethod(true,"EncodeBase64",(Object)(_bc.runMethod(false,"StringToBytes",(Object)(_tempstr),(Object)(RemoteObject.createImmutable("utf-8")))));
 BA.debugLineNum = 109;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getaccesstoken(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("GetAccessToken (auth) ","auth",6,__ref.getField(false, "ba"),__ref,97);
if (RapidSub.canDelegate("getaccesstoken")) return __ref.runUserSub(false, "auth","getaccesstoken", __ref);
 BA.debugLineNum = 97;BA.debugLine="Public Sub GetAccessToken()";
Debug.ShouldStop(1);
 BA.debugLineNum = 98;BA.debugLine="Return manager.GetString(\"token\")";
Debug.ShouldStop(2);
Debug.CheckDeviceExceptions();if (true) return __ref.getField(false,"_manager").runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("token")));
 BA.debugLineNum = 99;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getstore(RemoteObject __ref,RemoteObject _index) throws Exception{
try {
		Debug.PushSubsStack("GetStore (auth) ","auth",6,__ref.getField(false, "ba"),__ref,101);
if (RapidSub.canDelegate("getstore")) return __ref.runUserSub(false, "auth","getstore", __ref, _index);
Debug.locals.put("Index", _index);
 BA.debugLineNum = 101;BA.debugLine="Public Sub GetStore(Index As String)";
Debug.ShouldStop(16);
 BA.debugLineNum = 102;BA.debugLine="Return manager.GetString(Index)";
Debug.ShouldStop(32);
Debug.CheckDeviceExceptions();if (true) return __ref.getField(false,"_manager").runMethod(true,"GetString",(Object)(_index));
 BA.debugLineNum = 103;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _initialize(RemoteObject __ref,RemoteObject _ba,RemoteObject _aactivity) throws Exception{
try {
		Debug.PushSubsStack("Initialize (auth) ","auth",6,__ref.getField(false, "ba"),__ref,9);
if (RapidSub.canDelegate("initialize")) return __ref.runUserSub(false, "auth","initialize", __ref, _ba, _aactivity);
__ref.runVoidMethodAndSync("innerInitializeHelper", _ba);
Debug.locals.put("ba", _ba);
Debug.locals.put("aActivity", _aactivity);
 BA.debugLineNum = 9;BA.debugLine="Public Sub Initialize(aActivity As Activity)";
Debug.ShouldStop(256);
 BA.debugLineNum = 10;BA.debugLine="Act = aActivity";
Debug.ShouldStop(512);
__ref.setField ("_act",_aactivity);
 BA.debugLineNum = 11;BA.debugLine="urlApi = \"http://gandalf.x.testing.jobs.id/oauth/";
Debug.ShouldStop(1024);
__ref.setField ("_urlapi",BA.ObjectToString("http://gandalf.x.testing.jobs.id/oauth/token"));
 BA.debugLineNum = 12;BA.debugLine="clientSecret = \"88HWC8Pjv8UmTcWmnlruBCaTLdnkD2\"";
Debug.ShouldStop(2048);
__ref.setField ("_clientsecret",BA.ObjectToString("88HWC8Pjv8UmTcWmnlruBCaTLdnkD2"));
 BA.debugLineNum = 13;BA.debugLine="clientId = \"ZA87YCXLY5\"";
Debug.ShouldStop(4096);
__ref.setField ("_clientid",BA.ObjectToString("ZA87YCXLY5"));
 BA.debugLineNum = 14;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _jobdone(RemoteObject __ref,RemoteObject _job) throws Exception{
try {
		Debug.PushSubsStack("JobDone (auth) ","auth",6,__ref.getField(false, "ba"),__ref,45);
if (RapidSub.canDelegate("jobdone")) return __ref.runUserSub(false, "auth","jobdone", __ref, _job);
RemoteObject _json = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _root = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _access_token = RemoteObject.createImmutable("");
RemoteObject _refresh_token = RemoteObject.createImmutable("");
RemoteObject _headhunter = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _name = RemoteObject.createImmutable("");
RemoteObject _email = RemoteObject.createImmutable("");
RemoteObject _id = RemoteObject.createImmutable(0);
RemoteObject _error_description = RemoteObject.createImmutable("");
RemoteObject _error = RemoteObject.createImmutable("");
Debug.locals.put("Job", _job);
 BA.debugLineNum = 45;BA.debugLine="Sub JobDone (Job As HttpJob)";
Debug.ShouldStop(4096);
 BA.debugLineNum = 46;BA.debugLine="Dim JSON As JSONParser";
Debug.ShouldStop(8192);
_json = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("JSON", _json);
 BA.debugLineNum = 47;BA.debugLine="Log(\"JobName = \" & Job.JobName & \", Success = \"";
Debug.ShouldStop(16384);
auth.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("JobName = "),_job.getField(true,"_jobname"),RemoteObject.createImmutable(", Success = "),_job.getField(true,"_success"))));
 BA.debugLineNum = 48;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(32768);
auth.__c.runVoidMethod ("ProgressDialogHide");
 BA.debugLineNum = 49;BA.debugLine="If Job.Success = True Then";
Debug.ShouldStop(65536);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_success"),auth.__c.getField(true,"True"))) { 
 BA.debugLineNum = 50;BA.debugLine="Select Job.JobName";
Debug.ShouldStop(131072);
switch (BA.switchObjectToInt(_job.getField(true,"_jobname"),BA.ObjectToString("Job1"))) {
case 0: {
 BA.debugLineNum = 53;BA.debugLine="Log(Job.GetString)";
Debug.ShouldStop(1048576);
auth.__c.runVoidMethod ("Log",(Object)(_job.runClassMethod (com.qolega.qolegapp.httpjob.class, "_getstring")));
 BA.debugLineNum = 54;BA.debugLine="JSON.Initialize(Job.GetString)";
Debug.ShouldStop(2097152);
_json.runVoidMethod ("Initialize",(Object)(_job.runClassMethod (com.qolega.qolegapp.httpjob.class, "_getstring")));
 BA.debugLineNum = 55;BA.debugLine="Dim root As Map = JSON.NextObject";
Debug.ShouldStop(4194304);
_root = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_root = _json.runMethod(false,"NextObject");Debug.locals.put("root", _root);Debug.locals.put("root", _root);
 BA.debugLineNum = 56;BA.debugLine="Dim access_token As String = root.Get(\"access_t";
Debug.ShouldStop(8388608);
_access_token = BA.ObjectToString(_root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("access_token")))));Debug.locals.put("access_token", _access_token);Debug.locals.put("access_token", _access_token);
 BA.debugLineNum = 57;BA.debugLine="Dim refresh_token As String = root.Get(\"refresh";
Debug.ShouldStop(16777216);
_refresh_token = BA.ObjectToString(_root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("refresh_token")))));Debug.locals.put("refresh_token", _refresh_token);Debug.locals.put("refresh_token", _refresh_token);
 BA.debugLineNum = 58;BA.debugLine="Dim headhunter As Map = root.Get(\"headhunter\")";
Debug.ShouldStop(33554432);
_headhunter = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_headhunter.setObject(_root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("headhunter")))));Debug.locals.put("headhunter", _headhunter);
 BA.debugLineNum = 59;BA.debugLine="Dim name As String = headhunter.Get(\"name\")";
Debug.ShouldStop(67108864);
_name = BA.ObjectToString(_headhunter.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("name")))));Debug.locals.put("name", _name);Debug.locals.put("name", _name);
 BA.debugLineNum = 60;BA.debugLine="Dim email As String = headhunter.Get(\"email\")";
Debug.ShouldStop(134217728);
_email = BA.ObjectToString(_headhunter.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("email")))));Debug.locals.put("email", _email);Debug.locals.put("email", _email);
 BA.debugLineNum = 61;BA.debugLine="Dim id As Int = headhunter.Get(\"id\")";
Debug.ShouldStop(268435456);
_id = BA.numberCast(int.class, _headhunter.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("id")))));Debug.locals.put("id", _id);Debug.locals.put("id", _id);
 BA.debugLineNum = 62;BA.debugLine="SetLoginSession(access_token,id,name,email)";
Debug.ShouldStop(536870912);
__ref.runClassMethod (com.qolega.qolegapp.auth.class, "_setloginsession",(Object)(_access_token),(Object)(_id),(Object)(_name),(Object)(_email));
 break; }
}
;
 }else {
 BA.debugLineNum = 65;BA.debugLine="Try";
Debug.ShouldStop(1);
try { BA.debugLineNum = 66;BA.debugLine="JSON.Initialize(Job.ErrorMessage)";
Debug.ShouldStop(2);
_json.runVoidMethod ("Initialize",(Object)(_job.getField(true,"_errormessage")));
 BA.debugLineNum = 67;BA.debugLine="Dim root As Map = JSON.NextObject";
Debug.ShouldStop(4);
_root = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_root = _json.runMethod(false,"NextObject");Debug.locals.put("root", _root);Debug.locals.put("root", _root);
 BA.debugLineNum = 68;BA.debugLine="Dim error_description As String = root.Get(\"er";
Debug.ShouldStop(8);
_error_description = BA.ObjectToString(_root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("error_description")))));Debug.locals.put("error_description", _error_description);Debug.locals.put("error_description", _error_description);
 BA.debugLineNum = 69;BA.debugLine="Dim error As String = root.Get(\"error\")";
Debug.ShouldStop(16);
_error = BA.ObjectToString(_root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("error")))));Debug.locals.put("error", _error);Debug.locals.put("error", _error);
 BA.debugLineNum = 70;BA.debugLine="ToastMessageShow(error_description,True)";
Debug.ShouldStop(32);
auth.__c.runVoidMethod ("ToastMessageShow",(Object)(_error_description),(Object)(auth.__c.getField(true,"True")));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e26) {
			BA.rdebugUtils.runVoidMethod("setLastException",__ref.getField(false, "ba"), e26.toString()); BA.debugLineNum = 72;BA.debugLine="Log(LastException)";
Debug.ShouldStop(128);
auth.__c.runVoidMethod ("Log",(Object)(BA.ObjectToString(auth.__c.runMethod(false,"LastException",__ref.getField(false, "ba")))));
 };
 };
 BA.debugLineNum = 75;BA.debugLine="Job.Release";
Debug.ShouldStop(1024);
_job.runClassMethod (com.qolega.qolegapp.httpjob.class, "_release");
 BA.debugLineNum = 76;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _login(RemoteObject __ref,RemoteObject _email,RemoteObject _password) throws Exception{
try {
		Debug.PushSubsStack("Login (auth) ","auth",6,__ref.getField(false, "ba"),__ref,16);
if (RapidSub.canDelegate("login")) return __ref.runUserSub(false, "auth","login", __ref, _email, _password);
RemoteObject _job = RemoteObject.declareNull("com.qolega.qolegapp.httpjob");
RemoteObject _bauth = RemoteObject.createImmutable("");
RemoteObject _parameter = RemoteObject.createImmutable("");
Debug.locals.put("email", _email);
Debug.locals.put("password", _password);
 BA.debugLineNum = 16;BA.debugLine="Public Sub Login(email As EditText,password As Edi";
Debug.ShouldStop(32768);
 BA.debugLineNum = 17;BA.debugLine="Dim Job As HttpJob,bAuth,parameter As String";
Debug.ShouldStop(65536);
_job = RemoteObject.createNew ("com.qolega.qolegapp.httpjob");Debug.locals.put("Job", _job);
_bauth = RemoteObject.createImmutable("");Debug.locals.put("bAuth", _bauth);
_parameter = RemoteObject.createImmutable("");Debug.locals.put("parameter", _parameter);
 BA.debugLineNum = 21;BA.debugLine="parameter = \"grant_type=password&client_id=\"&clie";
Debug.ShouldStop(1048576);
_parameter = RemoteObject.concat(RemoteObject.createImmutable("grant_type=password&client_id="),__ref.getField(true,"_clientid"),RemoteObject.createImmutable("&client_secret="),__ref.getField(true,"_clientsecret"),RemoteObject.createImmutable("&username="),_email.runMethod(true,"getText"),RemoteObject.createImmutable("&password="),_password.runMethod(true,"getText"));Debug.locals.put("parameter", _parameter);
 BA.debugLineNum = 24;BA.debugLine="email.Text = \"\"";
Debug.ShouldStop(8388608);
_email.runMethodAndSync(true,"setText",RemoteObject.createImmutable(("")));
 BA.debugLineNum = 25;BA.debugLine="password.Text = \"\"";
Debug.ShouldStop(16777216);
_password.runMethodAndSync(true,"setText",RemoteObject.createImmutable(("")));
 BA.debugLineNum = 27;BA.debugLine="ProgressDialogShow2(\"Logged In\",False)";
Debug.ShouldStop(67108864);
auth.__c.runVoidMethod ("ProgressDialogShow2",__ref.getField(false, "ba"),(Object)(BA.ObjectToString("Logged In")),(Object)(auth.__c.getField(true,"False")));
 BA.debugLineNum = 28;BA.debugLine="Job.Initialize(\"Job1\", Me)";
Debug.ShouldStop(134217728);
_job.runClassMethod (com.qolega.qolegapp.httpjob.class, "_initialize",__ref.getField(false, "ba"),(Object)(BA.ObjectToString("Job1")),(Object)(__ref));
 BA.debugLineNum = 30;BA.debugLine="Job.PostString(urlApi,parameter)";
Debug.ShouldStop(536870912);
_job.runClassMethod (com.qolega.qolegapp.httpjob.class, "_poststring",(Object)(__ref.getField(true,"_urlapi")),(Object)(_parameter));
 BA.debugLineNum = 36;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _logout(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("Logout (auth) ","auth",6,__ref.getField(false, "ba"),__ref,38);
if (RapidSub.canDelegate("logout")) return __ref.runUserSub(false, "auth","logout", __ref);
 BA.debugLineNum = 38;BA.debugLine="Public Sub Logout()";
Debug.ShouldStop(32);
 BA.debugLineNum = 39;BA.debugLine="manager.ClearAll";
Debug.ShouldStop(64);
__ref.getField(false,"_manager").runVoidMethod ("ClearAll");
 BA.debugLineNum = 40;BA.debugLine="StartActivity(Main)";
Debug.ShouldStop(128);
auth.__c.runVoidMethod ("StartActivity",__ref.getField(false, "ba"),(Object)((auth._main.getObject())));
 BA.debugLineNum = 41;BA.debugLine="Act.Finish";
Debug.ShouldStop(256);
__ref.getField(false,"_act").runVoidMethod ("Finish");
 BA.debugLineNum = 42;BA.debugLine="ToastMessageShow(\"Logout berhasil\", False)";
Debug.ShouldStop(512);
auth.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToString("Logout berhasil")),(Object)(auth.__c.getField(true,"False")));
 BA.debugLineNum = 43;BA.debugLine="End Sub";
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
public static RemoteObject  _setloginsession(RemoteObject __ref,RemoteObject _token,RemoteObject _id,RemoteObject _name,RemoteObject _email) throws Exception{
try {
		Debug.PushSubsStack("SetLoginSession (auth) ","auth",6,__ref.getField(false, "ba"),__ref,88);
if (RapidSub.canDelegate("setloginsession")) return __ref.runUserSub(false, "auth","setloginsession", __ref, _token, _id, _name, _email);
Debug.locals.put("Token", _token);
Debug.locals.put("id", _id);
Debug.locals.put("name", _name);
Debug.locals.put("email", _email);
 BA.debugLineNum = 88;BA.debugLine="Public Sub SetLoginSession(Token As String,id As I";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 89;BA.debugLine="manager.SetBoolean(\"is_login\", True)";
Debug.ShouldStop(16777216);
__ref.getField(false,"_manager").runVoidMethod ("SetBoolean",(Object)(BA.ObjectToString("is_login")),(Object)(auth.__c.getField(true,"True")));
 BA.debugLineNum = 90;BA.debugLine="manager.SetString(\"token\",Token)";
Debug.ShouldStop(33554432);
__ref.getField(false,"_manager").runVoidMethod ("SetString",(Object)(BA.ObjectToString("token")),(Object)(_token));
 BA.debugLineNum = 91;BA.debugLine="manager.SetString(\"name\",name)";
Debug.ShouldStop(67108864);
__ref.getField(false,"_manager").runVoidMethod ("SetString",(Object)(BA.ObjectToString("name")),(Object)(_name));
 BA.debugLineNum = 92;BA.debugLine="manager.SetString(\"email\",email)";
Debug.ShouldStop(134217728);
__ref.getField(false,"_manager").runVoidMethod ("SetString",(Object)(BA.ObjectToString("email")),(Object)(_email));
 BA.debugLineNum = 93;BA.debugLine="manager.SetString(\"id\",id)";
Debug.ShouldStop(268435456);
__ref.getField(false,"_manager").runVoidMethod ("SetString",(Object)(BA.ObjectToString("id")),(Object)(BA.NumberToString(_id)));
 BA.debugLineNum = 94;BA.debugLine="StartActivity(ReferringList)";
Debug.ShouldStop(536870912);
auth.__c.runVoidMethod ("StartActivity",__ref.getField(false, "ba"),(Object)((auth._referringlist.getObject())));
 BA.debugLineNum = 95;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
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