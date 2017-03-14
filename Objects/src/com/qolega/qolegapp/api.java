package com.qolega.qolegapp;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class api extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new anywheresoftware.b4a.ShellBA(_ba, this, htSubs, "com.qolega.qolegapp.api");
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

 
    public void  innerInitializeHelper(anywheresoftware.b4a.BA _ba) throws Exception{
        innerInitialize(_ba);
    }
    public Object callSub(String sub, Object sender, Object[] args) throws Exception {
        return BA.SubDelegator.SubNotFound;
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
public com.qolega.qolegapp.test4 _test4 = null;
public com.qolega.qolegapp.httputils2service _httputils2service = null;
public String  _initialize(com.qolega.qolegapp.api __ref,anywheresoftware.b4a.BA _ba,String _name,Object _this) throws Exception{
__ref = this;
innerInitialize(_ba);
RDebugUtils.currentModule="api";
if (Debug.shouldDelegate(ba, "initialize"))
	return (String) Debug.delegate(ba, "initialize", new Object[] {_ba,_name,_this});
RDebugUtils.currentLine=7798784;
 //BA.debugLineNum = 7798784;BA.debugLine="Public Sub Initialize(name As String,this As Objec";
RDebugUtils.currentLine=7798785;
 //BA.debugLineNum = 7798785;BA.debugLine="Job.Initialize(name,this)";
__ref._job._initialize(null,ba,_name,_this);
RDebugUtils.currentLine=7798786;
 //BA.debugLineNum = 7798786;BA.debugLine="End Sub";
return "";
}
public String  _get(com.qolega.qolegapp.api __ref,String _endpoint) throws Exception{
__ref = this;
RDebugUtils.currentModule="api";
if (Debug.shouldDelegate(ba, "get"))
	return (String) Debug.delegate(ba, "get", new Object[] {_endpoint});
RDebugUtils.currentLine=8060928;
 //BA.debugLineNum = 8060928;BA.debugLine="Public Sub Get(Endpoint As String)";
RDebugUtils.currentLine=8060929;
 //BA.debugLineNum = 8060929;BA.debugLine="Job.Download(apiUrl&Endpoint)";
__ref._job._download(null,__ref._apiurl+_endpoint);
RDebugUtils.currentLine=8060930;
 //BA.debugLineNum = 8060930;BA.debugLine="End Sub";
return "";
}
public String  _class_globals(com.qolega.qolegapp.api __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="api";
RDebugUtils.currentLine=7733248;
 //BA.debugLineNum = 7733248;BA.debugLine="Sub Class_Globals";
RDebugUtils.currentLine=7733249;
 //BA.debugLineNum = 7733249;BA.debugLine="Dim apiUrl = \"http://gandalf.x.testing.jobs.id\" A";
_apiurl = "http://gandalf.x.testing.jobs.id";
RDebugUtils.currentLine=7733250;
 //BA.debugLineNum = 7733250;BA.debugLine="Dim result As String";
_result = "";
RDebugUtils.currentLine=7733251;
 //BA.debugLineNum = 7733251;BA.debugLine="Dim Job As HttpJob";
_job = new com.qolega.qolegapp.httpjob();
RDebugUtils.currentLine=7733252;
 //BA.debugLineNum = 7733252;BA.debugLine="End Sub";
return "";
}
public String  _post(com.qolega.qolegapp.api __ref,String _endpoint) throws Exception{
__ref = this;
RDebugUtils.currentModule="api";
if (Debug.shouldDelegate(ba, "post"))
	return (String) Debug.delegate(ba, "post", new Object[] {_endpoint});
RDebugUtils.currentLine=8716288;
 //BA.debugLineNum = 8716288;BA.debugLine="Public Sub Post(EndPoint As String)";
RDebugUtils.currentLine=8716290;
 //BA.debugLineNum = 8716290;BA.debugLine="End Sub";
return "";
}
}