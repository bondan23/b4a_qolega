package com.qolega.qolegapp;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class auth extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "com.qolega.qolegapp.auth");
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
public String  _checkloginsession() throws Exception{
boolean _islogin = false;
 //BA.debugLineNum = 78;BA.debugLine="Public Sub CheckLoginSession()";
 //BA.debugLineNum = 79;BA.debugLine="Dim isLogin As Boolean";
_islogin = false;
 //BA.debugLineNum = 80;BA.debugLine="isLogin = manager.GetBoolean(\"is_login\")";
_islogin = _manager.GetBoolean("is_login");
 //BA.debugLineNum = 82;BA.debugLine="If isLogin = True Then";
if (_islogin==__c.True) { 
 //BA.debugLineNum = 83;BA.debugLine="StartActivity(ReferringList)";
__c.StartActivity(ba,(Object)(_referringlist.getObject()));
 //BA.debugLineNum = 84;BA.debugLine="Act.Finish";
_act.Finish();
 };
 //BA.debugLineNum = 86;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 3;BA.debugLine="Dim manager As PreferenceManager";
_manager = new anywheresoftware.b4a.objects.preferenceactivity.PreferenceManager();
 //BA.debugLineNum = 4;BA.debugLine="Dim Act As Activity";
_act = new anywheresoftware.b4a.objects.ActivityWrapper();
 //BA.debugLineNum = 5;BA.debugLine="Private urlApi,clientSecret,clientId As String";
_urlapi = "";
_clientsecret = "";
_clientid = "";
 //BA.debugLineNum = 6;BA.debugLine="End Sub";
return "";
}
public String  _encodebasicauth(String _username,String _password) throws Exception{
anywheresoftware.b4a.objects.StringUtils _su = null;
String _tempstr = "";
anywheresoftware.b4a.agraham.byteconverter.ByteConverter _bc = null;
 //BA.debugLineNum = 105;BA.debugLine="Private Sub EncodeBasicAuth(username As String, pa";
 //BA.debugLineNum = 106;BA.debugLine="Dim su As StringUtils,tempstr As String,bc As";
_su = new anywheresoftware.b4a.objects.StringUtils();
_tempstr = "";
_bc = new anywheresoftware.b4a.agraham.byteconverter.ByteConverter();
 //BA.debugLineNum = 107;BA.debugLine="tempstr = username&\":\"&password";
_tempstr = _username+":"+_password;
 //BA.debugLineNum = 108;BA.debugLine="Return su.EncodeBase64(bc.StringToBytes(tempstr,\"";
if (true) return _su.EncodeBase64(_bc.StringToBytes(_tempstr,"utf-8"));
 //BA.debugLineNum = 109;BA.debugLine="End Sub";
return "";
}
public String  _getaccesstoken() throws Exception{
 //BA.debugLineNum = 97;BA.debugLine="Public Sub GetAccessToken()";
 //BA.debugLineNum = 98;BA.debugLine="Return manager.GetString(\"token\")";
if (true) return _manager.GetString("token");
 //BA.debugLineNum = 99;BA.debugLine="End Sub";
return "";
}
public String  _getstore(String _index) throws Exception{
 //BA.debugLineNum = 101;BA.debugLine="Public Sub GetStore(Index As String)";
 //BA.debugLineNum = 102;BA.debugLine="Return manager.GetString(Index)";
if (true) return _manager.GetString(_index);
 //BA.debugLineNum = 103;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ActivityWrapper _aactivity) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 9;BA.debugLine="Public Sub Initialize(aActivity As Activity)";
 //BA.debugLineNum = 10;BA.debugLine="Act = aActivity";
_act = _aactivity;
 //BA.debugLineNum = 11;BA.debugLine="urlApi = \"http://gandalf.x.testing.jobs.id/oauth/";
_urlapi = "http://gandalf.x.testing.jobs.id/oauth/token";
 //BA.debugLineNum = 12;BA.debugLine="clientSecret = \"88HWC8Pjv8UmTcWmnlruBCaTLdnkD2\"";
_clientsecret = "88HWC8Pjv8UmTcWmnlruBCaTLdnkD2";
 //BA.debugLineNum = 13;BA.debugLine="clientId = \"ZA87YCXLY5\"";
_clientid = "ZA87YCXLY5";
 //BA.debugLineNum = 14;BA.debugLine="End Sub";
return "";
}
public String  _jobdone(com.qolega.qolegapp.httpjob _job) throws Exception{
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
 //BA.debugLineNum = 45;BA.debugLine="Sub JobDone (Job As HttpJob)";
 //BA.debugLineNum = 46;BA.debugLine="Dim JSON As JSONParser";
_json = new anywheresoftware.b4a.objects.collections.JSONParser();
 //BA.debugLineNum = 47;BA.debugLine="Log(\"JobName = \" & Job.JobName & \", Success = \"";
__c.Log("JobName = "+_job._jobname+", Success = "+BA.ObjectToString(_job._success));
 //BA.debugLineNum = 48;BA.debugLine="ProgressDialogHide";
__c.ProgressDialogHide();
 //BA.debugLineNum = 49;BA.debugLine="If Job.Success = True Then";
if (_job._success==__c.True) { 
 //BA.debugLineNum = 50;BA.debugLine="Select Job.JobName";
switch (BA.switchObjectToInt(_job._jobname,"Job1")) {
case 0: {
 //BA.debugLineNum = 53;BA.debugLine="Log(Job.GetString)";
__c.Log(_job._getstring());
 //BA.debugLineNum = 54;BA.debugLine="JSON.Initialize(Job.GetString)";
_json.Initialize(_job._getstring());
 //BA.debugLineNum = 55;BA.debugLine="Dim root As Map = JSON.NextObject";
_root = new anywheresoftware.b4a.objects.collections.Map();
_root = _json.NextObject();
 //BA.debugLineNum = 56;BA.debugLine="Dim access_token As String = root.Get(\"access_t";
_access_token = BA.ObjectToString(_root.Get((Object)("access_token")));
 //BA.debugLineNum = 57;BA.debugLine="Dim refresh_token As String = root.Get(\"refresh";
_refresh_token = BA.ObjectToString(_root.Get((Object)("refresh_token")));
 //BA.debugLineNum = 58;BA.debugLine="Dim headhunter As Map = root.Get(\"headhunter\")";
_headhunter = new anywheresoftware.b4a.objects.collections.Map();
_headhunter.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_root.Get((Object)("headhunter"))));
 //BA.debugLineNum = 59;BA.debugLine="Dim name As String = headhunter.Get(\"name\")";
_name = BA.ObjectToString(_headhunter.Get((Object)("name")));
 //BA.debugLineNum = 60;BA.debugLine="Dim email As String = headhunter.Get(\"email\")";
_email = BA.ObjectToString(_headhunter.Get((Object)("email")));
 //BA.debugLineNum = 61;BA.debugLine="Dim id As Int = headhunter.Get(\"id\")";
_id = (int)(BA.ObjectToNumber(_headhunter.Get((Object)("id"))));
 //BA.debugLineNum = 62;BA.debugLine="SetLoginSession(access_token,id,name,email)";
_setloginsession(_access_token,_id,_name,_email);
 break; }
}
;
 }else {
 //BA.debugLineNum = 65;BA.debugLine="Try";
try { //BA.debugLineNum = 66;BA.debugLine="JSON.Initialize(Job.ErrorMessage)";
_json.Initialize(_job._errormessage);
 //BA.debugLineNum = 67;BA.debugLine="Dim root As Map = JSON.NextObject";
_root = new anywheresoftware.b4a.objects.collections.Map();
_root = _json.NextObject();
 //BA.debugLineNum = 68;BA.debugLine="Dim error_description As String = root.Get(\"er";
_error_description = BA.ObjectToString(_root.Get((Object)("error_description")));
 //BA.debugLineNum = 69;BA.debugLine="Dim error As String = root.Get(\"error\")";
_error = BA.ObjectToString(_root.Get((Object)("error")));
 //BA.debugLineNum = 70;BA.debugLine="ToastMessageShow(error_description,True)";
__c.ToastMessageShow(_error_description,__c.True);
 } 
       catch (Exception e26) {
			ba.setLastException(e26); //BA.debugLineNum = 72;BA.debugLine="Log(LastException)";
__c.Log(BA.ObjectToString(__c.LastException(ba)));
 };
 };
 //BA.debugLineNum = 75;BA.debugLine="Job.Release";
_job._release();
 //BA.debugLineNum = 76;BA.debugLine="End Sub";
return "";
}
public String  _login(anywheresoftware.b4a.objects.EditTextWrapper _email,anywheresoftware.b4a.objects.EditTextWrapper _password) throws Exception{
com.qolega.qolegapp.httpjob _job = null;
String _bauth = "";
String _parameter = "";
 //BA.debugLineNum = 16;BA.debugLine="Public Sub Login(email As EditText,password As Edi";
 //BA.debugLineNum = 17;BA.debugLine="Dim Job As HttpJob,bAuth,parameter As String";
_job = new com.qolega.qolegapp.httpjob();
_bauth = "";
_parameter = "";
 //BA.debugLineNum = 21;BA.debugLine="parameter = \"grant_type=password&client_id=\"&clie";
_parameter = "grant_type=password&client_id="+_clientid+"&client_secret="+_clientsecret+"&username="+_email.getText()+"&password="+_password.getText();
 //BA.debugLineNum = 24;BA.debugLine="email.Text = \"\"";
_email.setText((Object)(""));
 //BA.debugLineNum = 25;BA.debugLine="password.Text = \"\"";
_password.setText((Object)(""));
 //BA.debugLineNum = 27;BA.debugLine="ProgressDialogShow2(\"Logged In\",False)";
__c.ProgressDialogShow2(ba,"Logged In",__c.False);
 //BA.debugLineNum = 28;BA.debugLine="Job.Initialize(\"Job1\", Me)";
_job._initialize(ba,"Job1",this);
 //BA.debugLineNum = 30;BA.debugLine="Job.PostString(urlApi,parameter)";
_job._poststring(_urlapi,_parameter);
 //BA.debugLineNum = 36;BA.debugLine="End Sub";
return "";
}
public String  _logout() throws Exception{
 //BA.debugLineNum = 38;BA.debugLine="Public Sub Logout()";
 //BA.debugLineNum = 39;BA.debugLine="manager.ClearAll";
_manager.ClearAll();
 //BA.debugLineNum = 40;BA.debugLine="StartActivity(Main)";
__c.StartActivity(ba,(Object)(_main.getObject()));
 //BA.debugLineNum = 41;BA.debugLine="Act.Finish";
_act.Finish();
 //BA.debugLineNum = 42;BA.debugLine="ToastMessageShow(\"Logout berhasil\", False)";
__c.ToastMessageShow("Logout berhasil",__c.False);
 //BA.debugLineNum = 43;BA.debugLine="End Sub";
return "";
}
public String  _setloginsession(String _token,int _id,String _name,String _email) throws Exception{
 //BA.debugLineNum = 88;BA.debugLine="Public Sub SetLoginSession(Token As String,id As I";
 //BA.debugLineNum = 89;BA.debugLine="manager.SetBoolean(\"is_login\", True)";
_manager.SetBoolean("is_login",__c.True);
 //BA.debugLineNum = 90;BA.debugLine="manager.SetString(\"token\",Token)";
_manager.SetString("token",_token);
 //BA.debugLineNum = 91;BA.debugLine="manager.SetString(\"name\",name)";
_manager.SetString("name",_name);
 //BA.debugLineNum = 92;BA.debugLine="manager.SetString(\"email\",email)";
_manager.SetString("email",_email);
 //BA.debugLineNum = 93;BA.debugLine="manager.SetString(\"id\",id)";
_manager.SetString("id",BA.NumberToString(_id));
 //BA.debugLineNum = 94;BA.debugLine="StartActivity(ReferringList)";
__c.StartActivity(ba,(Object)(_referringlist.getObject()));
 //BA.debugLineNum = 95;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "JOBDONE"))
	return _jobdone((com.qolega.qolegapp.httpjob) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
