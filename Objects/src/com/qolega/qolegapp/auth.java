package com.qolega.qolegapp;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class auth extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new anywheresoftware.b4a.ShellBA(_ba, this, htSubs, "com.qolega.qolegapp.auth");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", com.qolega.qolegapp.auth.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 
    public void  innerInitializeHelper(anywheresoftware.b4a.BA _ba) throws Exception{
        innerInitialize(_ba);
    }
    public Object callSub(String sub, Object sender, Object[] args) throws Exception {
        return BA.SubDelegator.SubNotFound;
    }
public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.preferenceactivity.PreferenceManager _manager = null;
public anywheresoftware.b4a.objects.ActivityWrapper _act = null;
public String _urlapi = "";
public String _clientsecret = "";
public String _clientid = "";
public com.qolega.qolegapp.main _main = null;
public com.qolega.qolegapp.starter _starter = null;
public com.qolega.qolegapp.referringlist _referringlist = null;
public com.qolega.qolegapp.referringprogress _referringprogress = null;
public com.qolega.qolegapp.testresponsive _testresponsive = null;
public com.qolega.qolegapp.test3 _test3 = null;
public com.qolega.qolegapp.httputils2service _httputils2service = null;
public com.qolega.qolegapp.test4 _test4 = null;
public String  _initialize(com.qolega.qolegapp.auth __ref,anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ActivityWrapper _aactivity) throws Exception{
__ref = this;
innerInitialize(_ba);
RDebugUtils.currentModule="auth";
if (Debug.shouldDelegate(ba, "initialize"))
	return (String) Debug.delegate(ba, "initialize", new Object[] {_ba,_aactivity});
RDebugUtils.currentLine=3538944;
 //BA.debugLineNum = 3538944;BA.debugLine="Public Sub Initialize(aActivity As Activity)";
RDebugUtils.currentLine=3538945;
 //BA.debugLineNum = 3538945;BA.debugLine="Act = aActivity";
__ref._act = _aactivity;
RDebugUtils.currentLine=3538946;
 //BA.debugLineNum = 3538946;BA.debugLine="urlApi = \"http://gandalf.x.testing.jobs.id/oauth/";
__ref._urlapi = "http://gandalf.x.testing.jobs.id/oauth/token";
RDebugUtils.currentLine=3538947;
 //BA.debugLineNum = 3538947;BA.debugLine="clientSecret = \"88HWC8Pjv8UmTcWmnlruBCaTLdnkD2\"";
__ref._clientsecret = "88HWC8Pjv8UmTcWmnlruBCaTLdnkD2";
RDebugUtils.currentLine=3538948;
 //BA.debugLineNum = 3538948;BA.debugLine="clientId = \"ZA87YCXLY5\"";
__ref._clientid = "ZA87YCXLY5";
RDebugUtils.currentLine=3538949;
 //BA.debugLineNum = 3538949;BA.debugLine="End Sub";
return "";
}
public String  _checkloginsession(com.qolega.qolegapp.auth __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="auth";
if (Debug.shouldDelegate(ba, "checkloginsession"))
	return (String) Debug.delegate(ba, "checkloginsession", null);
boolean _islogin = false;
RDebugUtils.currentLine=3801088;
 //BA.debugLineNum = 3801088;BA.debugLine="Public Sub CheckLoginSession()";
RDebugUtils.currentLine=3801089;
 //BA.debugLineNum = 3801089;BA.debugLine="Dim isLogin As Boolean";
_islogin = false;
RDebugUtils.currentLine=3801090;
 //BA.debugLineNum = 3801090;BA.debugLine="isLogin = manager.GetBoolean(\"is_login\")";
_islogin = __ref._manager.GetBoolean("is_login");
RDebugUtils.currentLine=3801092;
 //BA.debugLineNum = 3801092;BA.debugLine="If isLogin = True Then";
if (_islogin==__c.True) { 
RDebugUtils.currentLine=3801093;
 //BA.debugLineNum = 3801093;BA.debugLine="StartActivity(ReferringList)";
__c.StartActivity(ba,(Object)(_referringlist.getObject()));
RDebugUtils.currentLine=3801094;
 //BA.debugLineNum = 3801094;BA.debugLine="Act.Finish";
__ref._act.Finish();
 };
RDebugUtils.currentLine=3801096;
 //BA.debugLineNum = 3801096;BA.debugLine="End Sub";
return "";
}
public String  _login(com.qolega.qolegapp.auth __ref,anywheresoftware.b4a.objects.EditTextWrapper _email,anywheresoftware.b4a.objects.EditTextWrapper _password) throws Exception{
__ref = this;
RDebugUtils.currentModule="auth";
if (Debug.shouldDelegate(ba, "login"))
	return (String) Debug.delegate(ba, "login", new Object[] {_email,_password});
com.qolega.qolegapp.httpjob _job = null;
String _bauth = "";
String _parameter = "";
RDebugUtils.currentLine=3604480;
 //BA.debugLineNum = 3604480;BA.debugLine="Public Sub Login(email As EditText,password As Edi";
RDebugUtils.currentLine=3604481;
 //BA.debugLineNum = 3604481;BA.debugLine="Dim Job As HttpJob,bAuth,parameter As String";
_job = new com.qolega.qolegapp.httpjob();
_bauth = "";
_parameter = "";
RDebugUtils.currentLine=3604485;
 //BA.debugLineNum = 3604485;BA.debugLine="parameter = \"grant_type=password&client_id=\"&clie";
_parameter = "grant_type=password&client_id="+__ref._clientid+"&client_secret="+__ref._clientsecret+"&username="+_email.getText()+"&password="+_password.getText();
RDebugUtils.currentLine=3604488;
 //BA.debugLineNum = 3604488;BA.debugLine="email.Text = \"\"";
_email.setText((Object)(""));
RDebugUtils.currentLine=3604489;
 //BA.debugLineNum = 3604489;BA.debugLine="password.Text = \"\"";
_password.setText((Object)(""));
RDebugUtils.currentLine=3604491;
 //BA.debugLineNum = 3604491;BA.debugLine="ProgressDialogShow2(\"Logged In\",False)";
__c.ProgressDialogShow2(ba,"Logged In",__c.False);
RDebugUtils.currentLine=3604492;
 //BA.debugLineNum = 3604492;BA.debugLine="Job.Initialize(\"Job1\", Me)";
_job._initialize(null,ba,"Job1",this);
RDebugUtils.currentLine=3604494;
 //BA.debugLineNum = 3604494;BA.debugLine="Job.PostString(urlApi,parameter)";
_job._poststring(null,__ref._urlapi,_parameter);
RDebugUtils.currentLine=3604500;
 //BA.debugLineNum = 3604500;BA.debugLine="End Sub";
return "";
}
public String  _getstore(com.qolega.qolegapp.auth __ref,String _index) throws Exception{
__ref = this;
RDebugUtils.currentModule="auth";
if (Debug.shouldDelegate(ba, "getstore"))
	return (String) Debug.delegate(ba, "getstore", new Object[] {_index});
RDebugUtils.currentLine=3997696;
 //BA.debugLineNum = 3997696;BA.debugLine="Public Sub GetStore(Index As String)";
RDebugUtils.currentLine=3997697;
 //BA.debugLineNum = 3997697;BA.debugLine="Return manager.GetString(Index)";
if (true) return __ref._manager.GetString(_index);
RDebugUtils.currentLine=3997698;
 //BA.debugLineNum = 3997698;BA.debugLine="End Sub";
return "";
}
public String  _logout(com.qolega.qolegapp.auth __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="auth";
if (Debug.shouldDelegate(ba, "logout"))
	return (String) Debug.delegate(ba, "logout", null);
RDebugUtils.currentLine=3670016;
 //BA.debugLineNum = 3670016;BA.debugLine="Public Sub Logout()";
RDebugUtils.currentLine=3670017;
 //BA.debugLineNum = 3670017;BA.debugLine="manager.ClearAll";
__ref._manager.ClearAll();
RDebugUtils.currentLine=3670018;
 //BA.debugLineNum = 3670018;BA.debugLine="StartActivity(Main)";
__c.StartActivity(ba,(Object)(_main.getObject()));
RDebugUtils.currentLine=3670019;
 //BA.debugLineNum = 3670019;BA.debugLine="Act.Finish";
__ref._act.Finish();
RDebugUtils.currentLine=3670020;
 //BA.debugLineNum = 3670020;BA.debugLine="ToastMessageShow(\"Logout berhasil\", False)";
__c.ToastMessageShow("Logout berhasil",__c.False);
RDebugUtils.currentLine=3670021;
 //BA.debugLineNum = 3670021;BA.debugLine="End Sub";
return "";
}
public String  _class_globals(com.qolega.qolegapp.auth __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="auth";
RDebugUtils.currentLine=3473408;
 //BA.debugLineNum = 3473408;BA.debugLine="Sub Class_Globals";
RDebugUtils.currentLine=3473409;
 //BA.debugLineNum = 3473409;BA.debugLine="Dim manager As PreferenceManager";
_manager = new anywheresoftware.b4a.objects.preferenceactivity.PreferenceManager();
RDebugUtils.currentLine=3473410;
 //BA.debugLineNum = 3473410;BA.debugLine="Dim Act As Activity";
_act = new anywheresoftware.b4a.objects.ActivityWrapper();
RDebugUtils.currentLine=3473411;
 //BA.debugLineNum = 3473411;BA.debugLine="Private urlApi,clientSecret,clientId As String";
_urlapi = "";
_clientsecret = "";
_clientid = "";
RDebugUtils.currentLine=3473412;
 //BA.debugLineNum = 3473412;BA.debugLine="End Sub";
return "";
}
public String  _encodebasicauth(com.qolega.qolegapp.auth __ref,String _username,String _password) throws Exception{
__ref = this;
RDebugUtils.currentModule="auth";
if (Debug.shouldDelegate(ba, "encodebasicauth"))
	return (String) Debug.delegate(ba, "encodebasicauth", new Object[] {_username,_password});
anywheresoftware.b4a.objects.StringUtils _su = null;
String _tempstr = "";
anywheresoftware.b4a.agraham.byteconverter.ByteConverter _bc = null;
RDebugUtils.currentLine=4063232;
 //BA.debugLineNum = 4063232;BA.debugLine="Private Sub EncodeBasicAuth(username As String, pa";
RDebugUtils.currentLine=4063233;
 //BA.debugLineNum = 4063233;BA.debugLine="Dim su As StringUtils,tempstr As String,bc As";
_su = new anywheresoftware.b4a.objects.StringUtils();
_tempstr = "";
_bc = new anywheresoftware.b4a.agraham.byteconverter.ByteConverter();
RDebugUtils.currentLine=4063234;
 //BA.debugLineNum = 4063234;BA.debugLine="tempstr = username&\":\"&password";
_tempstr = _username+":"+_password;
RDebugUtils.currentLine=4063235;
 //BA.debugLineNum = 4063235;BA.debugLine="Return su.EncodeBase64(bc.StringToBytes(tempstr,\"";
if (true) return _su.EncodeBase64(_bc.StringToBytes(_tempstr,"utf-8"));
RDebugUtils.currentLine=4063236;
 //BA.debugLineNum = 4063236;BA.debugLine="End Sub";
return "";
}
public String  _getaccesstoken(com.qolega.qolegapp.auth __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="auth";
if (Debug.shouldDelegate(ba, "getaccesstoken"))
	return (String) Debug.delegate(ba, "getaccesstoken", null);
RDebugUtils.currentLine=3932160;
 //BA.debugLineNum = 3932160;BA.debugLine="Public Sub GetAccessToken()";
RDebugUtils.currentLine=3932161;
 //BA.debugLineNum = 3932161;BA.debugLine="Return manager.GetString(\"token\")";
if (true) return __ref._manager.GetString("token");
RDebugUtils.currentLine=3932162;
 //BA.debugLineNum = 3932162;BA.debugLine="End Sub";
return "";
}
public String  _jobdone(com.qolega.qolegapp.auth __ref,com.qolega.qolegapp.httpjob _job) throws Exception{
__ref = this;
RDebugUtils.currentModule="auth";
if (Debug.shouldDelegate(ba, "jobdone"))
	return (String) Debug.delegate(ba, "jobdone", new Object[] {_job});
anywheresoftware.b4a.objects.collections.JSONParser _json = null;
anywheresoftware.b4a.objects.collections.Map _root = null;
String _access_token = "";
String _refresh_token = "";
anywheresoftware.b4a.objects.collections.Map _headhunter = null;
String _name = "";
String _email = "";
int _id = 0;
String _error_description = "";
String _error = "";
RDebugUtils.currentLine=3735552;
 //BA.debugLineNum = 3735552;BA.debugLine="Sub JobDone (Job As HttpJob)";
RDebugUtils.currentLine=3735553;
 //BA.debugLineNum = 3735553;BA.debugLine="Dim JSON As JSONParser";
_json = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=3735554;
 //BA.debugLineNum = 3735554;BA.debugLine="Log(\"JobName = \" & Job.JobName & \", Success = \"";
__c.Log("JobName = "+_job._jobname+", Success = "+BA.ObjectToString(_job._success));
RDebugUtils.currentLine=3735555;
 //BA.debugLineNum = 3735555;BA.debugLine="ProgressDialogHide";
__c.ProgressDialogHide();
RDebugUtils.currentLine=3735556;
 //BA.debugLineNum = 3735556;BA.debugLine="If Job.Success = True Then";
if (_job._success==__c.True) { 
RDebugUtils.currentLine=3735557;
 //BA.debugLineNum = 3735557;BA.debugLine="Select Job.JobName";
switch (BA.switchObjectToInt(_job._jobname,"Job1")) {
case 0: {
RDebugUtils.currentLine=3735560;
 //BA.debugLineNum = 3735560;BA.debugLine="Log(Job.GetString)";
__c.Log(_job._getstring(null));
RDebugUtils.currentLine=3735561;
 //BA.debugLineNum = 3735561;BA.debugLine="JSON.Initialize(Job.GetString)";
_json.Initialize(_job._getstring(null));
RDebugUtils.currentLine=3735562;
 //BA.debugLineNum = 3735562;BA.debugLine="Dim root As Map = JSON.NextObject";
_root = new anywheresoftware.b4a.objects.collections.Map();
_root = _json.NextObject();
RDebugUtils.currentLine=3735563;
 //BA.debugLineNum = 3735563;BA.debugLine="Dim access_token As String = root.Get(\"access_t";
_access_token = BA.ObjectToString(_root.Get((Object)("access_token")));
RDebugUtils.currentLine=3735564;
 //BA.debugLineNum = 3735564;BA.debugLine="Dim refresh_token As String = root.Get(\"refresh";
_refresh_token = BA.ObjectToString(_root.Get((Object)("refresh_token")));
RDebugUtils.currentLine=3735565;
 //BA.debugLineNum = 3735565;BA.debugLine="Dim headhunter As Map = root.Get(\"headhunter\")";
_headhunter = new anywheresoftware.b4a.objects.collections.Map();
_headhunter.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_root.Get((Object)("headhunter"))));
RDebugUtils.currentLine=3735566;
 //BA.debugLineNum = 3735566;BA.debugLine="Dim name As String = headhunter.Get(\"name\")";
_name = BA.ObjectToString(_headhunter.Get((Object)("name")));
RDebugUtils.currentLine=3735567;
 //BA.debugLineNum = 3735567;BA.debugLine="Dim email As String = headhunter.Get(\"email\")";
_email = BA.ObjectToString(_headhunter.Get((Object)("email")));
RDebugUtils.currentLine=3735568;
 //BA.debugLineNum = 3735568;BA.debugLine="Dim id As Int = headhunter.Get(\"id\")";
_id = (int)(BA.ObjectToNumber(_headhunter.Get((Object)("id"))));
RDebugUtils.currentLine=3735569;
 //BA.debugLineNum = 3735569;BA.debugLine="SetLoginSession(access_token,id,name,email)";
__ref._setloginsession(null,_access_token,_id,_name,_email);
 break; }
}
;
 }else {
RDebugUtils.currentLine=3735572;
 //BA.debugLineNum = 3735572;BA.debugLine="Try";
try {RDebugUtils.currentLine=3735573;
 //BA.debugLineNum = 3735573;BA.debugLine="JSON.Initialize(Job.ErrorMessage)";
_json.Initialize(_job._errormessage);
RDebugUtils.currentLine=3735574;
 //BA.debugLineNum = 3735574;BA.debugLine="Dim root As Map = JSON.NextObject";
_root = new anywheresoftware.b4a.objects.collections.Map();
_root = _json.NextObject();
RDebugUtils.currentLine=3735575;
 //BA.debugLineNum = 3735575;BA.debugLine="Dim error_description As String = root.Get(\"er";
_error_description = BA.ObjectToString(_root.Get((Object)("error_description")));
RDebugUtils.currentLine=3735576;
 //BA.debugLineNum = 3735576;BA.debugLine="Dim error As String = root.Get(\"error\")";
_error = BA.ObjectToString(_root.Get((Object)("error")));
RDebugUtils.currentLine=3735577;
 //BA.debugLineNum = 3735577;BA.debugLine="ToastMessageShow(error_description,True)";
__c.ToastMessageShow(_error_description,__c.True);
 } 
       catch (Exception e26) {
			ba.setLastException(e26);RDebugUtils.currentLine=3735579;
 //BA.debugLineNum = 3735579;BA.debugLine="Log(LastException)";
__c.Log(BA.ObjectToString(__c.LastException(ba)));
 };
 };
RDebugUtils.currentLine=3735582;
 //BA.debugLineNum = 3735582;BA.debugLine="Job.Release";
_job._release(null);
RDebugUtils.currentLine=3735583;
 //BA.debugLineNum = 3735583;BA.debugLine="End Sub";
return "";
}
public String  _setloginsession(com.qolega.qolegapp.auth __ref,String _token,int _id,String _name,String _email) throws Exception{
__ref = this;
RDebugUtils.currentModule="auth";
if (Debug.shouldDelegate(ba, "setloginsession"))
	return (String) Debug.delegate(ba, "setloginsession", new Object[] {_token,_id,_name,_email});
RDebugUtils.currentLine=3866624;
 //BA.debugLineNum = 3866624;BA.debugLine="Public Sub SetLoginSession(Token As String,id As I";
RDebugUtils.currentLine=3866625;
 //BA.debugLineNum = 3866625;BA.debugLine="manager.SetBoolean(\"is_login\", True)";
__ref._manager.SetBoolean("is_login",__c.True);
RDebugUtils.currentLine=3866626;
 //BA.debugLineNum = 3866626;BA.debugLine="manager.SetString(\"token\",Token)";
__ref._manager.SetString("token",_token);
RDebugUtils.currentLine=3866627;
 //BA.debugLineNum = 3866627;BA.debugLine="manager.SetString(\"name\",name)";
__ref._manager.SetString("name",_name);
RDebugUtils.currentLine=3866628;
 //BA.debugLineNum = 3866628;BA.debugLine="manager.SetString(\"email\",email)";
__ref._manager.SetString("email",_email);
RDebugUtils.currentLine=3866629;
 //BA.debugLineNum = 3866629;BA.debugLine="manager.SetString(\"id\",id)";
__ref._manager.SetString("id",BA.NumberToString(_id));
RDebugUtils.currentLine=3866630;
 //BA.debugLineNum = 3866630;BA.debugLine="StartActivity(ReferringList)";
__c.StartActivity(ba,(Object)(_referringlist.getObject()));
RDebugUtils.currentLine=3866631;
 //BA.debugLineNum = 3866631;BA.debugLine="End Sub";
return "";
}
}