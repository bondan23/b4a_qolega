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
public anywheresoftware.b4a.samples.httputils2.httputils2service _httputils2service = null;
public com.qolega.qolegapp.main _main = null;
public com.qolega.qolegapp.starter _starter = null;
public com.qolega.qolegapp.referringlist _referringlist = null;
public com.qolega.qolegapp.testresponsive _testresponsive = null;
public com.qolega.qolegapp.test3 _test3 = null;
public com.qolega.qolegapp.test4 _test4 = null;
public com.qolega.qolegapp.referringprogress _referringprogress = null;
public String  _checkloginsession() throws Exception{
boolean _islogin = false;
 //BA.debugLineNum = 60;BA.debugLine="Public Sub CheckLoginSession()";
 //BA.debugLineNum = 61;BA.debugLine="Dim isLogin As Boolean";
_islogin = false;
 //BA.debugLineNum = 62;BA.debugLine="isLogin = manager.GetBoolean(\"is_login\")";
_islogin = _manager.GetBoolean("is_login");
 //BA.debugLineNum = 64;BA.debugLine="If isLogin Then";
if (_islogin) { 
 //BA.debugLineNum = 65;BA.debugLine="StartActivity(ReferringList)";
__c.StartActivity(ba,(Object)(_referringlist.getObject()));
 //BA.debugLineNum = 66;BA.debugLine="Act.Finish";
_act.Finish();
 };
 //BA.debugLineNum = 68;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 3;BA.debugLine="Dim manager As PreferenceManager";
_manager = new anywheresoftware.b4a.objects.preferenceactivity.PreferenceManager();
 //BA.debugLineNum = 4;BA.debugLine="Dim Act As Activity";
_act = new anywheresoftware.b4a.objects.ActivityWrapper();
 //BA.debugLineNum = 5;BA.debugLine="End Sub";
return "";
}
public String  _encodebasicauth(String _username,String _password) throws Exception{
anywheresoftware.b4a.objects.StringUtils _su = null;
String _tempstr = "";
anywheresoftware.b4a.agraham.byteconverter.ByteConverter _bc = null;
 //BA.debugLineNum = 81;BA.debugLine="Private Sub EncodeBasicAuth(username As String, pa";
 //BA.debugLineNum = 82;BA.debugLine="Dim su As StringUtils,tempstr As String,bc As";
_su = new anywheresoftware.b4a.objects.StringUtils();
_tempstr = "";
_bc = new anywheresoftware.b4a.agraham.byteconverter.ByteConverter();
 //BA.debugLineNum = 83;BA.debugLine="tempstr = username&\":\"&password";
_tempstr = _username+":"+_password;
 //BA.debugLineNum = 84;BA.debugLine="Return su.EncodeBase64(bc.StringToBytes(tempstr,\"";
if (true) return _su.EncodeBase64(_bc.StringToBytes(_tempstr,"utf-8"));
 //BA.debugLineNum = 85;BA.debugLine="End Sub";
return "";
}
public String  _getaccesstoken() throws Exception{
 //BA.debugLineNum = 77;BA.debugLine="Public Sub GetAccessToken()";
 //BA.debugLineNum = 78;BA.debugLine="Return manager.GetString(\"token\")";
if (true) return _manager.GetString("token");
 //BA.debugLineNum = 79;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ActivityWrapper _aactivity) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 8;BA.debugLine="Public Sub Initialize(aActivity As Activity)";
 //BA.debugLineNum = 9;BA.debugLine="Act = aActivity";
_act = _aactivity;
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return "";
}
public String  _jobdone(anywheresoftware.b4a.samples.httputils2.httpjob _job) throws Exception{
anywheresoftware.b4a.objects.collections.JSONParser _json = null;
anywheresoftware.b4a.objects.collections.Map _root = null;
anywheresoftware.b4a.objects.collections.Map _data = null;
String _token = "";
 //BA.debugLineNum = 38;BA.debugLine="Sub JobDone (Job As HttpJob)";
 //BA.debugLineNum = 39;BA.debugLine="Dim JSON As JSONParser";
_json = new anywheresoftware.b4a.objects.collections.JSONParser();
 //BA.debugLineNum = 40;BA.debugLine="Log(\"JobName = \" & Job.JobName & \", Success = \"";
__c.Log("JobName = "+_job._jobname+", Success = "+BA.ObjectToString(_job._success));
 //BA.debugLineNum = 42;BA.debugLine="If Job.Success = True Then";
if (_job._success==__c.True) { 
 //BA.debugLineNum = 43;BA.debugLine="Select Job.JobName";
switch (BA.switchObjectToInt(_job._jobname,"Job1")) {
case 0: {
 //BA.debugLineNum = 46;BA.debugLine="JSON.Initialize(Job.GetString)";
_json.Initialize(_job._getstring());
 //BA.debugLineNum = 47;BA.debugLine="Dim root As Map = JSON.NextObject";
_root = new anywheresoftware.b4a.objects.collections.Map();
_root = _json.NextObject();
 //BA.debugLineNum = 48;BA.debugLine="Dim data As Map = root.Get(\"data\")";
_data = new anywheresoftware.b4a.objects.collections.Map();
_data.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_root.Get((Object)("data"))));
 //BA.debugLineNum = 49;BA.debugLine="Dim token As String = data.Get(\"token\")";
_token = BA.ObjectToString(_data.Get((Object)("token")));
 //BA.debugLineNum = 50;BA.debugLine="SetLoginSession(token)";
_setloginsession(_token);
 //BA.debugLineNum = 51;BA.debugLine="Log(token)";
__c.Log(_token);
 break; }
}
;
 }else {
 //BA.debugLineNum = 54;BA.debugLine="Log(\"Error: \" & Job.ErrorMessage)";
__c.Log("Error: "+_job._errormessage);
 //BA.debugLineNum = 55;BA.debugLine="ToastMessageShow(\"Error: \" & Job.ErrorMessag";
__c.ToastMessageShow("Error: "+_job._errormessage,__c.True);
 };
 //BA.debugLineNum = 57;BA.debugLine="Job.Release";
_job._release();
 //BA.debugLineNum = 58;BA.debugLine="End Sub";
return "";
}
public String  _login(anywheresoftware.b4a.objects.EditTextWrapper _email,anywheresoftware.b4a.objects.EditTextWrapper _password) throws Exception{
anywheresoftware.b4a.samples.httputils2.httpjob _job = null;
String _bauth = "";
 //BA.debugLineNum = 12;BA.debugLine="Public Sub Login(email As EditText,password As Edi";
 //BA.debugLineNum = 13;BA.debugLine="Dim Job As HttpJob,bAuth As String";
_job = new anywheresoftware.b4a.samples.httputils2.httpjob();
_bauth = "";
 //BA.debugLineNum = 15;BA.debugLine="bAuth = EncodeBasicAuth(email.Text,password.Text)";
_bauth = _encodebasicauth(_email.getText(),_password.getText());
 //BA.debugLineNum = 18;BA.debugLine="email.Text = \"\"";
_email.setText((Object)(""));
 //BA.debugLineNum = 19;BA.debugLine="password.Text = \"\"";
_password.setText((Object)(""));
 //BA.debugLineNum = 21;BA.debugLine="Job.Initialize(\"Job1\", Me)";
_job._initialize(ba,"Job1",this);
 //BA.debugLineNum = 23;BA.debugLine="Job.PostString(\"http://phalcon.puma.mylits.com";
_job._poststring("http://phalcon.puma.mylits.com/users/authenticate",BA.ObjectToString(__c.Null));
 //BA.debugLineNum = 24;BA.debugLine="Job.Username = email.Text";
_job._username = _email.getText();
 //BA.debugLineNum = 25;BA.debugLine="Job.Password = password.Text";
_job._password = _password.getText();
 //BA.debugLineNum = 26;BA.debugLine="Job.GetRequest.SetContentType(\"application/json;";
_job._getrequest().SetContentType("application/json; charset=UTF-8");
 //BA.debugLineNum = 27;BA.debugLine="Job.GetRequest.SetHeader(\"Authorization\", \"Basic";
_job._getrequest().SetHeader("Authorization","Basic "+_bauth);
 //BA.debugLineNum = 28;BA.debugLine="End Sub";
return "";
}
public String  _logout() throws Exception{
 //BA.debugLineNum = 30;BA.debugLine="Public Sub Logout()";
 //BA.debugLineNum = 31;BA.debugLine="manager.SetBoolean(\"is_login\", False)";
_manager.SetBoolean("is_login",__c.False);
 //BA.debugLineNum = 32;BA.debugLine="StartActivity(Main)";
__c.StartActivity(ba,(Object)(_main.getObject()));
 //BA.debugLineNum = 33;BA.debugLine="Act.Finish";
_act.Finish();
 //BA.debugLineNum = 34;BA.debugLine="ToastMessageShow(\"Logout berhasil\", False)";
__c.ToastMessageShow("Logout berhasil",__c.False);
 //BA.debugLineNum = 35;BA.debugLine="End Sub";
return "";
}
public String  _setloginsession(String _token) throws Exception{
 //BA.debugLineNum = 70;BA.debugLine="Public Sub SetLoginSession(Token As String)";
 //BA.debugLineNum = 71;BA.debugLine="manager.SetBoolean(\"is_login\", True)";
_manager.SetBoolean("is_login",__c.True);
 //BA.debugLineNum = 72;BA.debugLine="manager.SetString(\"token\",Token)";
_manager.SetString("token",_token);
 //BA.debugLineNum = 73;BA.debugLine="StartActivity(ReferringList)";
__c.StartActivity(ba,(Object)(_referringlist.getObject()));
 //BA.debugLineNum = 74;BA.debugLine="Act.Finish";
_act.Finish();
 //BA.debugLineNum = 75;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
