package com.qolega.qolegapp;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class httputils2service_subs_0 {


public static RemoteObject  _completejob(RemoteObject _taskid,RemoteObject _success,RemoteObject _errormessage) throws Exception{
try {
		Debug.PushSubsStack("CompleteJob (httputils2service) ","httputils2service",9,httputils2service.processBA,httputils2service.mostCurrent,66);
if (RapidSub.canDelegate("completejob")) return httputils2service.remoteMe.runUserSub(false, "httputils2service","completejob", _taskid, _success, _errormessage);
RemoteObject _job = RemoteObject.declareNull("com.qolega.qolegapp.httpjob");
Debug.locals.put("TaskId", _taskid);
Debug.locals.put("success", _success);
Debug.locals.put("errorMessage", _errormessage);
 BA.debugLineNum = 66;BA.debugLine="Sub CompleteJob(TaskId As Int, success As Boolean,";
Debug.ShouldStop(2);
 BA.debugLineNum = 67;BA.debugLine="Dim job As HttpJob = TaskIdToJob.Get(TaskId)";
Debug.ShouldStop(4);
_job = (httputils2service._taskidtojob.runMethod(false,"Get",(Object)((_taskid))));Debug.locals.put("job", _job);Debug.locals.put("job", _job);
 BA.debugLineNum = 68;BA.debugLine="TaskIdToJob.Remove(TaskId)";
Debug.ShouldStop(8);
httputils2service._taskidtojob.runVoidMethod ("Remove",(Object)((_taskid)));
 BA.debugLineNum = 69;BA.debugLine="job.success = success";
Debug.ShouldStop(16);
_job.setField ("_success",_success);
 BA.debugLineNum = 70;BA.debugLine="job.errorMessage = errorMessage";
Debug.ShouldStop(32);
_job.setField ("_errormessage",_errormessage);
 BA.debugLineNum = 71;BA.debugLine="job.Complete(TaskId)";
Debug.ShouldStop(64);
_job.runClassMethod (com.qolega.qolegapp.httpjob.class, "_complete",(Object)(_taskid));
 BA.debugLineNum = 72;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _hc_responseerror(RemoteObject _response,RemoteObject _reason,RemoteObject _statuscode,RemoteObject _taskid) throws Exception{
try {
		Debug.PushSubsStack("hc_ResponseError (httputils2service) ","httputils2service",9,httputils2service.processBA,httputils2service.mostCurrent,52);
if (RapidSub.canDelegate("hc_responseerror")) return httputils2service.remoteMe.runUserSub(false, "httputils2service","hc_responseerror", _response, _reason, _statuscode, _taskid);
RemoteObject _errortext = RemoteObject.createImmutable("");
Debug.locals.put("Response", _response);
Debug.locals.put("Reason", _reason);
Debug.locals.put("StatusCode", _statuscode);
Debug.locals.put("TaskId", _taskid);
 BA.debugLineNum = 52;BA.debugLine="Sub hc_ResponseError (Response As OkHttpResponse,";
Debug.ShouldStop(524288);
 BA.debugLineNum = 53;BA.debugLine="Dim errorText As String";
Debug.ShouldStop(1048576);
_errortext = RemoteObject.createImmutable("");Debug.locals.put("errorText", _errortext);
 BA.debugLineNum = 54;BA.debugLine="If Response <> Null Then";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean("N",_response)) { 
 BA.debugLineNum = 56;BA.debugLine="If Response.ErrorResponse <> \"\" Then";
Debug.ShouldStop(8388608);
if (RemoteObject.solveBoolean("!",_response.runMethod(true,"getErrorResponse"),BA.ObjectToString(""))) { 
 BA.debugLineNum = 57;BA.debugLine="errorText = Response.ErrorResponse";
Debug.ShouldStop(16777216);
_errortext = _response.runMethod(true,"getErrorResponse");Debug.locals.put("errorText", _errortext);
 }else {
 BA.debugLineNum = 59;BA.debugLine="errorText = Reason";
Debug.ShouldStop(67108864);
_errortext = _reason;Debug.locals.put("errorText", _errortext);
 };
 BA.debugLineNum = 61;BA.debugLine="Response.Release";
Debug.ShouldStop(268435456);
_response.runVoidMethod ("Release");
 };
 BA.debugLineNum = 63;BA.debugLine="CompleteJob(TaskId, False, errorText)";
Debug.ShouldStop(1073741824);
_completejob(_taskid,httputils2service.mostCurrent.__c.getField(true,"False"),_errortext);
 BA.debugLineNum = 64;BA.debugLine="End Sub";
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
public static RemoteObject  _hc_responsesuccess(RemoteObject _response,RemoteObject _taskid) throws Exception{
try {
		Debug.PushSubsStack("hc_ResponseSuccess (httputils2service) ","httputils2service",9,httputils2service.processBA,httputils2service.mostCurrent,38);
if (RapidSub.canDelegate("hc_responsesuccess")) return httputils2service.remoteMe.runUserSub(false, "httputils2service","hc_responsesuccess", _response, _taskid);
Debug.locals.put("Response", _response);
Debug.locals.put("TaskId", _taskid);
 BA.debugLineNum = 38;BA.debugLine="Sub hc_ResponseSuccess (Response As OkHttpResponse";
Debug.ShouldStop(32);
 BA.debugLineNum = 39;BA.debugLine="Response.GetAsynchronously(\"response\", File.OpenO";
Debug.ShouldStop(64);
_response.runVoidMethod ("GetAsynchronously",httputils2service.processBA,(Object)(BA.ObjectToString("response")),(Object)((httputils2service.mostCurrent.__c.getField(false,"File").runMethod(false,"OpenOutput",(Object)(httputils2service._tempfolder),(Object)(BA.NumberToString(_taskid)),(Object)(httputils2service.mostCurrent.__c.getField(true,"False"))).getObject())),(Object)(httputils2service.mostCurrent.__c.getField(true,"True")),(Object)(_taskid));
 BA.debugLineNum = 41;BA.debugLine="End Sub";
Debug.ShouldStop(256);
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
 //BA.debugLineNum = 7;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 8;BA.debugLine="Private hc As OkHttpClient";
httputils2service._hc = RemoteObject.createNew ("anywheresoftware.b4h.okhttp.OkHttpClientWrapper");
 //BA.debugLineNum = 9;BA.debugLine="Private TaskIdToJob As Map";
httputils2service._taskidtojob = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
 //BA.debugLineNum = 10;BA.debugLine="Public TempFolder As String";
httputils2service._tempfolder = RemoteObject.createImmutable("");
 //BA.debugLineNum = 11;BA.debugLine="Private taskCounter As Int";
httputils2service._taskcounter = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 12;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _response_streamfinish(RemoteObject _success,RemoteObject _taskid) throws Exception{
try {
		Debug.PushSubsStack("Response_StreamFinish (httputils2service) ","httputils2service",9,httputils2service.processBA,httputils2service.mostCurrent,43);
if (RapidSub.canDelegate("response_streamfinish")) return httputils2service.remoteMe.runUserSub(false, "httputils2service","response_streamfinish", _success, _taskid);
Debug.locals.put("Success", _success);
Debug.locals.put("TaskId", _taskid);
 BA.debugLineNum = 43;BA.debugLine="Sub Response_StreamFinish (Success As Boolean, Tas";
Debug.ShouldStop(1024);
 BA.debugLineNum = 44;BA.debugLine="If Success Then";
Debug.ShouldStop(2048);
if (_success.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 45;BA.debugLine="CompleteJob(TaskId, Success, \"\")";
Debug.ShouldStop(4096);
_completejob(_taskid,_success,RemoteObject.createImmutable(""));
 }else {
 BA.debugLineNum = 47;BA.debugLine="CompleteJob(TaskId, Success, LastException.Messa";
Debug.ShouldStop(16384);
_completejob(_taskid,_success,httputils2service.mostCurrent.__c.runMethod(false,"LastException",httputils2service.processBA).runMethod(true,"getMessage"));
 };
 BA.debugLineNum = 50;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _service_create() throws Exception{
try {
		Debug.PushSubsStack("Service_Create (httputils2service) ","httputils2service",9,httputils2service.processBA,httputils2service.mostCurrent,14);
if (RapidSub.canDelegate("service_create")) return httputils2service.remoteMe.runUserSub(false, "httputils2service","service_create");
 BA.debugLineNum = 14;BA.debugLine="Sub Service_Create";
Debug.ShouldStop(8192);
 BA.debugLineNum = 15;BA.debugLine="TempFolder = File.DirInternalCache";
Debug.ShouldStop(16384);
httputils2service._tempfolder = httputils2service.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternalCache");
 BA.debugLineNum = 16;BA.debugLine="hc.Initialize(\"hc\")";
Debug.ShouldStop(32768);
httputils2service._hc.runVoidMethod ("Initialize",(Object)(RemoteObject.createImmutable("hc")));
 BA.debugLineNum = 17;BA.debugLine="TaskIdToJob.Initialize";
Debug.ShouldStop(65536);
httputils2service._taskidtojob.runVoidMethod ("Initialize");
 BA.debugLineNum = 18;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
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
		Debug.PushSubsStack("Service_Destroy (httputils2service) ","httputils2service",9,httputils2service.processBA,httputils2service.mostCurrent,23);
if (RapidSub.canDelegate("service_destroy")) return httputils2service.remoteMe.runUserSub(false, "httputils2service","service_destroy");
 BA.debugLineNum = 23;BA.debugLine="Sub Service_Destroy";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 25;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
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
		Debug.PushSubsStack("Service_Start (httputils2service) ","httputils2service",9,httputils2service.processBA,httputils2service.mostCurrent,20);
if (RapidSub.canDelegate("service_start")) return httputils2service.remoteMe.runUserSub(false, "httputils2service","service_start", _startingintent);
Debug.locals.put("StartingIntent", _startingintent);
 BA.debugLineNum = 20;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
Debug.ShouldStop(524288);
 BA.debugLineNum = 21;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _submitjob(RemoteObject _job) throws Exception{
try {
		Debug.PushSubsStack("SubmitJob (httputils2service) ","httputils2service",9,httputils2service.processBA,httputils2service.mostCurrent,27);
if (RapidSub.canDelegate("submitjob")) return httputils2service.remoteMe.runUserSub(false, "httputils2service","submitjob", _job);
Debug.locals.put("job", _job);
 BA.debugLineNum = 27;BA.debugLine="Public Sub SubmitJob(job As HttpJob) As Int";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 28;BA.debugLine="taskCounter = taskCounter + 1";
Debug.ShouldStop(134217728);
httputils2service._taskcounter = RemoteObject.solve(new RemoteObject[] {httputils2service._taskcounter,RemoteObject.createImmutable(1)}, "+",1, 1);
 BA.debugLineNum = 29;BA.debugLine="TaskIdToJob.Put(taskCounter, job)";
Debug.ShouldStop(268435456);
httputils2service._taskidtojob.runVoidMethod ("Put",(Object)((httputils2service._taskcounter)),(Object)((_job)));
 BA.debugLineNum = 30;BA.debugLine="If job.Username <> \"\" And job.Password <> \"\" Then";
Debug.ShouldStop(536870912);
if (RemoteObject.solveBoolean("!",_job.getField(true,"_username"),BA.ObjectToString("")) && RemoteObject.solveBoolean("!",_job.getField(true,"_password"),BA.ObjectToString(""))) { 
 BA.debugLineNum = 31;BA.debugLine="hc.ExecuteCredentials(job.GetRequest, taskCounte";
Debug.ShouldStop(1073741824);
httputils2service._hc.runVoidMethod ("ExecuteCredentials",httputils2service.processBA,(Object)(_job.runClassMethod (com.qolega.qolegapp.httpjob.class, "_getrequest")),(Object)(httputils2service._taskcounter),(Object)(_job.getField(true,"_username")),(Object)(_job.getField(true,"_password")));
 }else {
 BA.debugLineNum = 33;BA.debugLine="hc.Execute(job.GetRequest, taskCounter)";
Debug.ShouldStop(1);
httputils2service._hc.runVoidMethod ("Execute",httputils2service.processBA,(Object)(_job.runClassMethod (com.qolega.qolegapp.httpjob.class, "_getrequest")),(Object)(httputils2service._taskcounter));
 };
 BA.debugLineNum = 35;BA.debugLine="Return taskCounter";
Debug.ShouldStop(4);
if (true) return httputils2service._taskcounter;
 BA.debugLineNum = 36;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
}