package com.qolega.qolegapp;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class api extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "com.qolega.qolegapp.api");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", com.qolega.qolegapp.api.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public String _apiurl = "";
public String _result = "";
public com.qolega.qolegapp.httpjob _job = null;
public com.qolega.qolegapp.main _main = null;
public com.qolega.qolegapp.starter _starter = null;
public com.qolega.qolegapp.referringlist _referringlist = null;
public com.qolega.qolegapp.referringprogress _referringprogress = null;
public com.qolega.qolegapp.testresponsive _testresponsive = null;
public com.qolega.qolegapp.test3 _test3 = null;
public com.qolega.qolegapp.httputils2service _httputils2service = null;
public com.qolega.qolegapp.test4 _test4 = null;
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 3;BA.debugLine="Dim apiUrl = \"http://gandalf.x.testing.jobs.id\" A";
_apiurl = "http://gandalf.x.testing.jobs.id";
 //BA.debugLineNum = 4;BA.debugLine="Dim result As String";
_result = "";
 //BA.debugLineNum = 5;BA.debugLine="Dim Job As HttpJob";
_job = new com.qolega.qolegapp.httpjob();
 //BA.debugLineNum = 6;BA.debugLine="End Sub";
return "";
}
public String  _get(String _endpoint) throws Exception{
 //BA.debugLineNum = 13;BA.debugLine="Public Sub Get(Endpoint As String)";
 //BA.debugLineNum = 14;BA.debugLine="Job.Download(apiUrl&Endpoint)";
_job._download(_apiurl+_endpoint);
 //BA.debugLineNum = 15;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba,String _name,Object _this) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 9;BA.debugLine="Public Sub Initialize(name As String,this As Objec";
 //BA.debugLineNum = 10;BA.debugLine="Job.Initialize(name,this)";
_job._initialize(ba,_name,_this);
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return "";
}
public String  _post(String _endpoint) throws Exception{
 //BA.debugLineNum = 17;BA.debugLine="Public Sub Post(EndPoint As String)";
 //BA.debugLineNum = 19;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
