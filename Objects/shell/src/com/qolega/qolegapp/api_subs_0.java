package com.qolega.qolegapp;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class api_subs_0 {


public static RemoteObject  _class_globals(RemoteObject __ref) throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 3;BA.debugLine="Dim apiUrl = \"http://gandalf.x.testing.jobs.id\" A";
api._apiurl = BA.ObjectToString("http://gandalf.x.testing.jobs.id");__ref.setField("_apiurl",api._apiurl);
 //BA.debugLineNum = 4;BA.debugLine="Dim result As String";
api._result = RemoteObject.createImmutable("");__ref.setField("_result",api._result);
 //BA.debugLineNum = 5;BA.debugLine="Dim Job As HttpJob";
api._job = RemoteObject.createNew ("com.qolega.qolegapp.httpjob");__ref.setField("_job",api._job);
 //BA.debugLineNum = 6;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _get(RemoteObject __ref,RemoteObject _endpoint) throws Exception{
try {
		Debug.PushSubsStack("Get (api) ","api",11,__ref.getField(false, "ba"),__ref,13);
if (RapidSub.canDelegate("get")) return __ref.runUserSub(false, "api","get", __ref, _endpoint);
Debug.locals.put("Endpoint", _endpoint);
 BA.debugLineNum = 13;BA.debugLine="Public Sub Get(Endpoint As String)";
Debug.ShouldStop(4096);
 BA.debugLineNum = 14;BA.debugLine="Job.Download(apiUrl&Endpoint)";
Debug.ShouldStop(8192);
__ref.getField(false,"_job").runClassMethod (com.qolega.qolegapp.httpjob.class, "_download",(Object)(RemoteObject.concat(__ref.getField(true,"_apiurl"),_endpoint)));
 BA.debugLineNum = 15;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _initialize(RemoteObject __ref,RemoteObject _ba,RemoteObject _name,RemoteObject _this) throws Exception{
try {
		Debug.PushSubsStack("Initialize (api) ","api",11,__ref.getField(false, "ba"),__ref,9);
if (RapidSub.canDelegate("initialize")) return __ref.runUserSub(false, "api","initialize", __ref, _ba, _name, _this);
__ref.runVoidMethodAndSync("innerInitializeHelper", _ba);
Debug.locals.put("ba", _ba);
Debug.locals.put("name", _name);
Debug.locals.put("this", _this);
 BA.debugLineNum = 9;BA.debugLine="Public Sub Initialize(name As String,this As Objec";
Debug.ShouldStop(256);
 BA.debugLineNum = 10;BA.debugLine="Job.Initialize(name,this)";
Debug.ShouldStop(512);
__ref.getField(false,"_job").runClassMethod (com.qolega.qolegapp.httpjob.class, "_initialize",__ref.getField(false, "ba"),(Object)(_name),(Object)(_this));
 BA.debugLineNum = 11;BA.debugLine="End Sub";
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
public static RemoteObject  _post(RemoteObject __ref,RemoteObject _endpoint) throws Exception{
try {
		Debug.PushSubsStack("Post (api) ","api",11,__ref.getField(false, "ba"),__ref,17);
if (RapidSub.canDelegate("post")) return __ref.runUserSub(false, "api","post", __ref, _endpoint);
Debug.locals.put("EndPoint", _endpoint);
 BA.debugLineNum = 17;BA.debugLine="Public Sub Post(EndPoint As String)";
Debug.ShouldStop(65536);
 BA.debugLineNum = 19;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
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