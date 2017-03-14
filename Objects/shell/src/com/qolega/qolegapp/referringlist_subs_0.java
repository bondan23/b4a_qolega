package com.qolega.qolegapp;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class referringlist_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (referringlist) ","referringlist",2,referringlist.mostCurrent.activityBA,referringlist.mostCurrent,27);
if (RapidSub.canDelegate("activity_create")) return referringlist.remoteMe.runUserSub(false, "referringlist","activity_create", _firsttime);
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 27;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 29;BA.debugLine="qAuth.Initialize(Activity)";
Debug.ShouldStop(268435456);
referringlist.mostCurrent._qauth.runClassMethod (com.qolega.qolegapp.auth.class, "_initialize",referringlist.mostCurrent.activityBA,(Object)(referringlist.mostCurrent._activity));
 BA.debugLineNum = 30;BA.debugLine="font.Initialize";
Debug.ShouldStop(536870912);
referringlist.mostCurrent._font.runClassMethod (com.qolega.qolegapp.fonts.class, "_initialize",referringlist.processBA);
 BA.debugLineNum = 31;BA.debugLine="Api.Initialize(\"refferingList\",Me)";
Debug.ShouldStop(1073741824);
referringlist.mostCurrent._api.runClassMethod (com.qolega.qolegapp.api.class, "_initialize",referringlist.processBA,(Object)(BA.ObjectToString("refferingList")),(Object)(referringlist.getObject()));
 BA.debugLineNum = 35;BA.debugLine="Activity.AddMenuItem3(\"SearchItem\", \"SearchItem\",";
Debug.ShouldStop(4);
referringlist.mostCurrent._activity.runVoidMethod ("AddMenuItem3",(Object)(BA.ObjectToString("SearchItem")),(Object)(BA.ObjectToString("SearchItem")),(Object)((referringlist.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(referringlist.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("Logout.png"))).getObject())),(Object)(referringlist.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 36;BA.debugLine="scrollView.Initialize(Activity.Height)";
Debug.ShouldStop(8);
referringlist.mostCurrent._scrollview.runVoidMethod ("Initialize",referringlist.mostCurrent.activityBA,(Object)(referringlist.mostCurrent._activity.runMethod(true,"getHeight")));
 BA.debugLineNum = 37;BA.debugLine="scrollView.Color = Colors.RGB(246,246,246)";
Debug.ShouldStop(16);
referringlist.mostCurrent._scrollview.runVoidMethod ("setColor",referringlist.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 246)),(Object)(BA.numberCast(int.class, 246)),(Object)(BA.numberCast(int.class, 246))));
 BA.debugLineNum = 38;BA.debugLine="Activity.AddView(scrollView,0,0,100%x,100%y)";
Debug.ShouldStop(32);
referringlist.mostCurrent._activity.runVoidMethod ("AddView",(Object)((referringlist.mostCurrent._scrollview.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(referringlist.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),referringlist.mostCurrent.activityBA)),(Object)(referringlist.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),referringlist.mostCurrent.activityBA)));
 BA.debugLineNum = 39;BA.debugLine="detailList.Initialize";
Debug.ShouldStop(64);
referringlist.mostCurrent._detaillist.runVoidMethod ("Initialize");
 BA.debugLineNum = 40;BA.debugLine="resultList.Initialize";
Debug.ShouldStop(128);
referringlist.mostCurrent._resultlist.runVoidMethod ("Initialize");
 BA.debugLineNum = 45;BA.debugLine="Api.Get(\"/referrals/list/\"&qAuth.GetStore(\"id\"))";
Debug.ShouldStop(4096);
referringlist.mostCurrent._api.runClassMethod (com.qolega.qolegapp.api.class, "_get",(Object)(RemoteObject.concat(RemoteObject.createImmutable("/referrals/list/"),referringlist.mostCurrent._qauth.runClassMethod (com.qolega.qolegapp.auth.class, "_getstore",(Object)(RemoteObject.createImmutable("id"))))));
 BA.debugLineNum = 46;BA.debugLine="ProgressDialogShow2(\"Loading Data\",False)";
Debug.ShouldStop(8192);
referringlist.mostCurrent.__c.runVoidMethod ("ProgressDialogShow2",referringlist.mostCurrent.activityBA,(Object)(BA.ObjectToString("Loading Data")),(Object)(referringlist.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 47;BA.debugLine="End Sub";
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
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (referringlist) ","referringlist",2,referringlist.mostCurrent.activityBA,referringlist.mostCurrent,369);
if (RapidSub.canDelegate("activity_pause")) return referringlist.remoteMe.runUserSub(false, "referringlist","activity_pause", _userclosed);
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 369;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(65536);
 BA.debugLineNum = 371;BA.debugLine="End Sub";
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
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (referringlist) ","referringlist",2,referringlist.mostCurrent.activityBA,referringlist.mostCurrent,365);
if (RapidSub.canDelegate("activity_resume")) return referringlist.remoteMe.runUserSub(false, "referringlist","activity_resume");
 BA.debugLineNum = 365;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(4096);
 BA.debugLineNum = 367;BA.debugLine="End Sub";
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
public static RemoteObject  _detailbtn_click() throws Exception{
try {
		Debug.PushSubsStack("detailBtn_Click (referringlist) ","referringlist",2,referringlist.mostCurrent.activityBA,referringlist.mostCurrent,392);
if (RapidSub.canDelegate("detailbtn_click")) return referringlist.remoteMe.runUserSub(false, "referringlist","detailbtn_click");
int _i = 0;
RemoteObject _detailbtn = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
 BA.debugLineNum = 392;BA.debugLine="Sub detailBtn_Click";
Debug.ShouldStop(128);
 BA.debugLineNum = 393;BA.debugLine="For i = 0 To detailList.Size - 1";
Debug.ShouldStop(256);
{
final int step1 = 1;
final int limit1 = RemoteObject.solve(new RemoteObject[] {referringlist.mostCurrent._detaillist.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
for (_i = 0 ; (step1 > 0 && _i <= limit1) || (step1 < 0 && _i >= limit1); _i = ((int)(0 + _i + step1)) ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 394;BA.debugLine="Dim detailBtn As Button";
Debug.ShouldStop(512);
_detailbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");Debug.locals.put("detailBtn", _detailbtn);
 BA.debugLineNum = 395;BA.debugLine="detailBtn = detailList.Get(i)";
Debug.ShouldStop(1024);
_detailbtn.setObject(referringlist.mostCurrent._detaillist.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))));
 BA.debugLineNum = 396;BA.debugLine="detailBtn = Sender";
Debug.ShouldStop(2048);
_detailbtn.setObject(referringlist.mostCurrent.__c.runMethod(false,"Sender",referringlist.mostCurrent.activityBA));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 400;BA.debugLine="ReferringProgress.userId = detailBtn.Tag";
Debug.ShouldStop(32768);
referringlist.mostCurrent._referringprogress._userid = BA.numberCast(int.class, _detailbtn.runMethod(false,"getTag"));
 BA.debugLineNum = 401;BA.debugLine="StartActivity(ReferringProgress)";
Debug.ShouldStop(65536);
referringlist.mostCurrent.__c.runVoidMethod ("StartActivity",referringlist.mostCurrent.activityBA,(Object)((referringlist.mostCurrent._referringprogress.getObject())));
 BA.debugLineNum = 403;BA.debugLine="End Sub";
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
public static RemoteObject  _detailbtn_down() throws Exception{
try {
		Debug.PushSubsStack("detailBtn_Down (referringlist) ","referringlist",2,referringlist.mostCurrent.activityBA,referringlist.mostCurrent,405);
if (RapidSub.canDelegate("detailbtn_down")) return referringlist.remoteMe.runUserSub(false, "referringlist","detailbtn_down");
int _i = 0;
RemoteObject _detailbtn = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
 BA.debugLineNum = 405;BA.debugLine="Sub detailBtn_Down";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 406;BA.debugLine="For i = 0 To detailList.Size - 1";
Debug.ShouldStop(2097152);
{
final int step1 = 1;
final int limit1 = RemoteObject.solve(new RemoteObject[] {referringlist.mostCurrent._detaillist.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
for (_i = 0 ; (step1 > 0 && _i <= limit1) || (step1 < 0 && _i >= limit1); _i = ((int)(0 + _i + step1)) ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 407;BA.debugLine="Dim detailBtn As Button";
Debug.ShouldStop(4194304);
_detailbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");Debug.locals.put("detailBtn", _detailbtn);
 BA.debugLineNum = 408;BA.debugLine="detailBtn = detailList.Get(i)";
Debug.ShouldStop(8388608);
_detailbtn.setObject(referringlist.mostCurrent._detaillist.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))));
 BA.debugLineNum = 409;BA.debugLine="detailBtn = Sender";
Debug.ShouldStop(16777216);
_detailbtn.setObject(referringlist.mostCurrent.__c.runMethod(false,"Sender",referringlist.mostCurrent.activityBA));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 412;BA.debugLine="detailBtn.TextColor = Colors.RGB(105, 203, 231)";
Debug.ShouldStop(134217728);
_detailbtn.runMethod(true,"setTextColor",referringlist.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 105)),(Object)(BA.numberCast(int.class, 203)),(Object)(BA.numberCast(int.class, 231))));
 BA.debugLineNum = 413;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _detailbtn_up() throws Exception{
try {
		Debug.PushSubsStack("detailBtn_Up (referringlist) ","referringlist",2,referringlist.mostCurrent.activityBA,referringlist.mostCurrent,415);
if (RapidSub.canDelegate("detailbtn_up")) return referringlist.remoteMe.runUserSub(false, "referringlist","detailbtn_up");
int _i = 0;
RemoteObject _detailbtn = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
 BA.debugLineNum = 415;BA.debugLine="Sub detailBtn_Up";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 416;BA.debugLine="For i = 0 To detailList.Size - 1";
Debug.ShouldStop(-2147483648);
{
final int step1 = 1;
final int limit1 = RemoteObject.solve(new RemoteObject[] {referringlist.mostCurrent._detaillist.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
for (_i = 0 ; (step1 > 0 && _i <= limit1) || (step1 < 0 && _i >= limit1); _i = ((int)(0 + _i + step1)) ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 417;BA.debugLine="Dim detailBtn As Button";
Debug.ShouldStop(1);
_detailbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");Debug.locals.put("detailBtn", _detailbtn);
 BA.debugLineNum = 418;BA.debugLine="detailBtn = detailList.Get(i)";
Debug.ShouldStop(2);
_detailbtn.setObject(referringlist.mostCurrent._detaillist.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))));
 BA.debugLineNum = 419;BA.debugLine="detailBtn = Sender";
Debug.ShouldStop(4);
_detailbtn.setObject(referringlist.mostCurrent.__c.runMethod(false,"Sender",referringlist.mostCurrent.activityBA));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 422;BA.debugLine="detailBtn.TextColor = Colors.RGB(22,176,221)";
Debug.ShouldStop(32);
_detailbtn.runMethod(true,"setTextColor",referringlist.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 22)),(Object)(BA.numberCast(int.class, 176)),(Object)(BA.numberCast(int.class, 221))));
 BA.debugLineNum = 423;BA.debugLine="End Sub";
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
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 11;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 14;BA.debugLine="Dim scrollView As ScrollView";
referringlist.mostCurrent._scrollview = RemoteObject.createNew ("anywheresoftware.b4a.objects.ScrollViewWrapper");
 //BA.debugLineNum = 15;BA.debugLine="Dim JSON As JSONParser";
referringlist.mostCurrent._json = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");
 //BA.debugLineNum = 16;BA.debugLine="Dim su As StringUtils";
referringlist.mostCurrent._su = RemoteObject.createNew ("anywheresoftware.b4a.objects.StringUtils");
 //BA.debugLineNum = 17;BA.debugLine="Dim detailList As List";
referringlist.mostCurrent._detaillist = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 18;BA.debugLine="Dim resultList As List";
referringlist.mostCurrent._resultlist = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 19;BA.debugLine="Dim qAuth As Auth";
referringlist.mostCurrent._qauth = RemoteObject.createNew ("com.qolega.qolegapp.auth");
 //BA.debugLineNum = 20;BA.debugLine="Dim font As Fonts";
referringlist.mostCurrent._font = RemoteObject.createNew ("com.qolega.qolegapp.fonts");
 //BA.debugLineNum = 21;BA.debugLine="Dim loadMore As Button";
referringlist.mostCurrent._loadmore = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Dim Api As Api";
referringlist.mostCurrent._api = RemoteObject.createNew ("com.qolega.qolegapp.api");
 //BA.debugLineNum = 24;BA.debugLine="Dim loadMoreTop = 10dip As Int";
referringlist._loadmoretop = referringlist.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)));
 //BA.debugLineNum = 25;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _jobdone(RemoteObject _job) throws Exception{
try {
		Debug.PushSubsStack("JobDone (referringlist) ","referringlist",2,referringlist.mostCurrent.activityBA,referringlist.mostCurrent,49);
if (RapidSub.canDelegate("jobdone")) return referringlist.remoteMe.runUserSub(false, "referringlist","jobdone", _job);
Debug.locals.put("Job", _job);
 BA.debugLineNum = 49;BA.debugLine="Sub JobDone(Job As HttpJob)";
Debug.ShouldStop(65536);
 BA.debugLineNum = 50;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(131072);
referringlist.mostCurrent.__c.runVoidMethod ("ProgressDialogHide");
 BA.debugLineNum = 51;BA.debugLine="Log(\"JobName = \" & Job.JobName & \", Success = \"";
Debug.ShouldStop(262144);
referringlist.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("JobName = "),_job.getField(true,"_jobname"),RemoteObject.createImmutable(", Success = "),_job.getField(true,"_success"))));
 BA.debugLineNum = 52;BA.debugLine="If Job.Success = True Then";
Debug.ShouldStop(524288);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_success"),referringlist.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 53;BA.debugLine="LoopPanel(loadMoreTop,Job.GetString)";
Debug.ShouldStop(1048576);
_looppanel(referringlist._loadmoretop,_job.runClassMethod (com.qolega.qolegapp.httpjob.class, "_getstring"));
 }else {
 BA.debugLineNum = 55;BA.debugLine="Log(\"Error: \" & Job.ErrorMessage)";
Debug.ShouldStop(4194304);
referringlist.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job.getField(true,"_errormessage"))));
 BA.debugLineNum = 56;BA.debugLine="ToastMessageShow(\"Error: \" & Job.ErrorMessag";
Debug.ShouldStop(8388608);
referringlist.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job.getField(true,"_errormessage"))),(Object)(referringlist.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 58;BA.debugLine="Job.Release";
Debug.ShouldStop(33554432);
_job.runClassMethod (com.qolega.qolegapp.httpjob.class, "_release");
 BA.debugLineNum = 59;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _loadmore_click() throws Exception{
try {
		Debug.PushSubsStack("loadMore_Click (referringlist) ","referringlist",2,referringlist.mostCurrent.activityBA,referringlist.mostCurrent,373);
if (RapidSub.canDelegate("loadmore_click")) return referringlist.remoteMe.runUserSub(false, "referringlist","loadmore_click");
 BA.debugLineNum = 373;BA.debugLine="Sub loadMore_Click";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 374;BA.debugLine="loadMore = Sender";
Debug.ShouldStop(2097152);
referringlist.mostCurrent._loadmore.setObject(referringlist.mostCurrent.__c.runMethod(false,"Sender",referringlist.mostCurrent.activityBA));
 BA.debugLineNum = 375;BA.debugLine="loadMore.Text = \"Loading...\"";
Debug.ShouldStop(4194304);
referringlist.mostCurrent._loadmore.runMethod(true,"setText",RemoteObject.createImmutable(("Loading...")));
 BA.debugLineNum = 376;BA.debugLine="loadMore.Color = Colors.Gray";
Debug.ShouldStop(8388608);
referringlist.mostCurrent._loadmore.runVoidMethod ("setColor",referringlist.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray"));
 BA.debugLineNum = 377;BA.debugLine="Sleep(1200)";
Debug.ShouldStop(16777216);
_sleep(BA.numberCast(long.class, 1200));
 BA.debugLineNum = 378;BA.debugLine="loadMore.Visible = False";
Debug.ShouldStop(33554432);
referringlist.mostCurrent._loadmore.runMethod(true,"setVisible",referringlist.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 379;BA.debugLine="loadMoreTop = loadMore.Tag";
Debug.ShouldStop(67108864);
referringlist._loadmoretop = BA.numberCast(int.class, referringlist.mostCurrent._loadmore.runMethod(false,"getTag"));
 BA.debugLineNum = 380;BA.debugLine="Api.Get(\"/referrals/list\")";
Debug.ShouldStop(134217728);
referringlist.mostCurrent._api.runClassMethod (com.qolega.qolegapp.api.class, "_get",(Object)(RemoteObject.createImmutable("/referrals/list")));
 BA.debugLineNum = 381;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _looppanel(RemoteObject _starttop,RemoteObject _data) throws Exception{
try {
		Debug.PushSubsStack("LoopPanel (referringlist) ","referringlist",2,referringlist.mostCurrent.activityBA,referringlist.mostCurrent,62);
if (RapidSub.canDelegate("looppanel")) return referringlist.remoteMe.runUserSub(false, "referringlist","looppanel", _starttop, _data);
RemoteObject _bitmap1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
RemoteObject _container = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _joblistpanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _referencepanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _paneltop = RemoteObject.createImmutable(0);
RemoteObject _defaultpanelheight = RemoteObject.createImmutable(0);
RemoteObject _panelheight = RemoteObject.createImmutable(0);
RemoteObject _referencetop = RemoteObject.createImmutable(0);
RemoteObject _referenceheight = RemoteObject.createImmutable(0);
RemoteObject _gap = RemoteObject.createImmutable(0);
RemoteObject _textheight = RemoteObject.createImmutable(0);
RemoteObject _jobtitle = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _location = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _jobdesc = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _currency = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _commision = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _locationicon = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
RemoteObject _industryicon = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
RemoteObject _moneyicon = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
RemoteObject _root = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _colroot = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _reference = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _job_title = RemoteObject.createImmutable("");
RemoteObject _job_location = RemoteObject.createImmutable("");
RemoteObject _job_desc = RemoteObject.createImmutable("");
RemoteObject _job_commision = RemoteObject.createImmutable(0);
RemoteObject _canv = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper");
RemoteObject _newcurrencywidth = RemoteObject.createImmutable(0);
RemoteObject _sizeofref = RemoteObject.createImmutable(0);
RemoteObject _colreference = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _refname = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _refcompany = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _refstatus = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _detailbtn = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _refday = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _detailbutton = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
RemoteObject _statusref = RemoteObject.createImmutable("");
RemoteObject _rheight = RemoteObject.createImmutable(0);
RemoteObject _statusrefcolor = RemoteObject.createImmutable(0);
RemoteObject _usericon = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
RemoteObject _rname = RemoteObject.createImmutable("");
RemoteObject _rcompany = RemoteObject.createImmutable("");
RemoteObject _rstatus = RemoteObject.createImmutable("");
RemoteObject _userid = RemoteObject.createImmutable(0);
RemoteObject _daysago = RemoteObject.createImmutable("");
RemoteObject _cd = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.ColorDrawable");
RemoteObject _refstatusheight = RemoteObject.createImmutable(0);
RemoteObject _sld = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.StateListDrawable");
RemoteObject _pressed = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.ColorDrawable");
RemoteObject _enabled = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.ColorDrawable");
Debug.locals.put("StartTop", _starttop);
Debug.locals.put("Data", _data);
 BA.debugLineNum = 62;BA.debugLine="Sub LoopPanel(StartTop As Int,Data As String)";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 63;BA.debugLine="Dim Bitmap1 As Bitmap";
Debug.ShouldStop(1073741824);
_bitmap1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");Debug.locals.put("Bitmap1", _bitmap1);
 BA.debugLineNum = 64;BA.debugLine="Dim Container As Panel";
Debug.ShouldStop(-2147483648);
_container = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("Container", _container);
 BA.debugLineNum = 65;BA.debugLine="Dim JoblistPanel,ReferencePanel As Panel";
Debug.ShouldStop(1);
_joblistpanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("JoblistPanel", _joblistpanel);
_referencepanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("ReferencePanel", _referencepanel);
 BA.debugLineNum = 66;BA.debugLine="Dim PanelTop,defaultPanelHeight,PanelHeight,Refer";
Debug.ShouldStop(2);
_paneltop = RemoteObject.createImmutable(0);Debug.locals.put("PanelTop", _paneltop);
_defaultpanelheight = RemoteObject.createImmutable(0);Debug.locals.put("defaultPanelHeight", _defaultpanelheight);
_panelheight = RemoteObject.createImmutable(0);Debug.locals.put("PanelHeight", _panelheight);
_referencetop = RemoteObject.createImmutable(0);Debug.locals.put("ReferenceTop", _referencetop);
_referenceheight = RemoteObject.createImmutable(0);Debug.locals.put("ReferenceHeight", _referenceheight);
_gap = RemoteObject.createImmutable(0);Debug.locals.put("Gap", _gap);
_textheight = RemoteObject.createImmutable(0);Debug.locals.put("TextHeight", _textheight);
 BA.debugLineNum = 67;BA.debugLine="Dim JobTitle,Location,JobDesc,Currency,Commision";
Debug.ShouldStop(4);
_jobtitle = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("JobTitle", _jobtitle);
_location = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("Location", _location);
_jobdesc = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("JobDesc", _jobdesc);
_currency = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("Currency", _currency);
_commision = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("Commision", _commision);
 BA.debugLineNum = 68;BA.debugLine="Dim locationIcon,industryIcon,moneyIcon As ImageV";
Debug.ShouldStop(8);
_locationicon = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");Debug.locals.put("locationIcon", _locationicon);
_industryicon = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");Debug.locals.put("industryIcon", _industryicon);
_moneyicon = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");Debug.locals.put("moneyIcon", _moneyicon);
 BA.debugLineNum = 71;BA.debugLine="PanelTop = StartTop";
Debug.ShouldStop(64);
_paneltop = _starttop;Debug.locals.put("PanelTop", _paneltop);
 BA.debugLineNum = 74;BA.debugLine="PanelHeight = 110dip";
Debug.ShouldStop(512);
_panelheight = referringlist.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 110)));Debug.locals.put("PanelHeight", _panelheight);
 BA.debugLineNum = 75;BA.debugLine="defaultPanelHeight = PanelHeight";
Debug.ShouldStop(1024);
_defaultpanelheight = _panelheight;Debug.locals.put("defaultPanelHeight", _defaultpanelheight);
 BA.debugLineNum = 77;BA.debugLine="Gap = 10dip";
Debug.ShouldStop(4096);
_gap = referringlist.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)));Debug.locals.put("Gap", _gap);
 BA.debugLineNum = 80;BA.debugLine="Container = scrollView.Panel";
Debug.ShouldStop(32768);
_container = referringlist.mostCurrent._scrollview.runMethod(false,"getPanel");Debug.locals.put("Container", _container);
 BA.debugLineNum = 81;BA.debugLine="Container.Color = Colors.RGB(219,219,219)";
Debug.ShouldStop(65536);
_container.runVoidMethod ("setColor",referringlist.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 219)),(Object)(BA.numberCast(int.class, 219)),(Object)(BA.numberCast(int.class, 219))));
 BA.debugLineNum = 84;BA.debugLine="JSON.Initialize(Data)";
Debug.ShouldStop(524288);
referringlist.mostCurrent._json.runVoidMethod ("Initialize",(Object)(_data));
 BA.debugLineNum = 85;BA.debugLine="Dim root As List = JSON.NextArray";
Debug.ShouldStop(1048576);
_root = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_root = referringlist.mostCurrent._json.runMethod(false,"NextArray");Debug.locals.put("root", _root);Debug.locals.put("root", _root);
 BA.debugLineNum = 87;BA.debugLine="For Each colroot As Map In root";
Debug.ShouldStop(4194304);
_colroot = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
final RemoteObject group15 = _root;
final int groupLen15 = group15.runMethod(true,"getSize").<Integer>get();
for (int index15 = 0;index15 < groupLen15 ;index15++){
_colroot.setObject(group15.runMethod(false,"Get",index15));
Debug.locals.put("colroot", _colroot);
 BA.debugLineNum = 89;BA.debugLine="Dim reference As List = colroot.Get(\"reference\")";
Debug.ShouldStop(16777216);
_reference = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_reference.setObject(_colroot.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("reference")))));Debug.locals.put("reference", _reference);
 BA.debugLineNum = 90;BA.debugLine="Dim job_title As String = colroot.Get(\"job_title";
Debug.ShouldStop(33554432);
_job_title = BA.ObjectToString(_colroot.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("job_title")))));Debug.locals.put("job_title", _job_title);Debug.locals.put("job_title", _job_title);
 BA.debugLineNum = 91;BA.debugLine="Dim job_location As String = colroot.Get(\"locati";
Debug.ShouldStop(67108864);
_job_location = BA.ObjectToString(_colroot.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("location")))));Debug.locals.put("job_location", _job_location);Debug.locals.put("job_location", _job_location);
 BA.debugLineNum = 92;BA.debugLine="Dim job_desc As String = colroot.Get(\"industry\")";
Debug.ShouldStop(134217728);
_job_desc = BA.ObjectToString(_colroot.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("industry")))));Debug.locals.put("job_desc", _job_desc);Debug.locals.put("job_desc", _job_desc);
 BA.debugLineNum = 93;BA.debugLine="Dim job_commision As Double = colroot.Get(\"commi";
Debug.ShouldStop(268435456);
_job_commision = BA.numberCast(double.class, _colroot.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("commision")))));Debug.locals.put("job_commision", _job_commision);Debug.locals.put("job_commision", _job_commision);
 BA.debugLineNum = 96;BA.debugLine="JoblistPanel.Initialize(\"\")";
Debug.ShouldStop(-2147483648);
_joblistpanel.runVoidMethod ("Initialize",referringlist.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 97;BA.debugLine="JobTitle.Initialize(\"JobTitle\")";
Debug.ShouldStop(1);
_jobtitle.runVoidMethod ("Initialize",referringlist.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("JobTitle")));
 BA.debugLineNum = 98;BA.debugLine="Location.Initialize(\"Location\")";
Debug.ShouldStop(2);
_location.runVoidMethod ("Initialize",referringlist.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("Location")));
 BA.debugLineNum = 99;BA.debugLine="JobDesc.Initialize(\"JobDesc\")";
Debug.ShouldStop(4);
_jobdesc.runVoidMethod ("Initialize",referringlist.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("JobDesc")));
 BA.debugLineNum = 100;BA.debugLine="Currency.Initialize(\"Currency\")";
Debug.ShouldStop(8);
_currency.runVoidMethod ("Initialize",referringlist.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("Currency")));
 BA.debugLineNum = 101;BA.debugLine="Commision.Initialize(\"Commision\")";
Debug.ShouldStop(16);
_commision.runVoidMethod ("Initialize",referringlist.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("Commision")));
 BA.debugLineNum = 104;BA.debugLine="locationIcon.Initialize(\"\")";
Debug.ShouldStop(128);
_locationicon.runVoidMethod ("Initialize",referringlist.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 105;BA.debugLine="industryIcon.Initialize(\"\")";
Debug.ShouldStop(256);
_industryicon.runVoidMethod ("Initialize",referringlist.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 106;BA.debugLine="moneyIcon.Initialize(\"\")";
Debug.ShouldStop(512);
_moneyicon.runVoidMethod ("Initialize",referringlist.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 109;BA.debugLine="locationIcon.Bitmap = LoadBitmap(File.DirAssets,";
Debug.ShouldStop(4096);
_locationicon.runMethod(false,"setBitmap",(referringlist.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(referringlist.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("location.png"))).getObject()));
 BA.debugLineNum = 110;BA.debugLine="industryIcon.Bitmap = LoadBitmap(File.DirAssets,";
Debug.ShouldStop(8192);
_industryicon.runMethod(false,"setBitmap",(referringlist.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(referringlist.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("industry.png"))).getObject()));
 BA.debugLineNum = 111;BA.debugLine="moneyIcon.Bitmap = LoadBitmap(File.DirAssets,\"mo";
Debug.ShouldStop(16384);
_moneyicon.runMethod(false,"setBitmap",(referringlist.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(referringlist.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("money.png"))).getObject()));
 BA.debugLineNum = 113;BA.debugLine="locationIcon.Gravity = Gravity.FILL";
Debug.ShouldStop(65536);
_locationicon.runMethod(true,"setGravity",referringlist.mostCurrent.__c.getField(false,"Gravity").getField(true,"FILL"));
 BA.debugLineNum = 114;BA.debugLine="moneyIcon.Gravity = Gravity.FILL";
Debug.ShouldStop(131072);
_moneyicon.runMethod(true,"setGravity",referringlist.mostCurrent.__c.getField(false,"Gravity").getField(true,"FILL"));
 BA.debugLineNum = 115;BA.debugLine="industryIcon.Gravity = Gravity.FILL";
Debug.ShouldStop(262144);
_industryicon.runMethod(true,"setGravity",referringlist.mostCurrent.__c.getField(false,"Gravity").getField(true,"FILL"));
 BA.debugLineNum = 119;BA.debugLine="JobTitle.Typeface = font.proximanovaSemiBold";
Debug.ShouldStop(4194304);
_jobtitle.runMethod(false,"setTypeface",(referringlist.mostCurrent._font.runClassMethod (com.qolega.qolegapp.fonts.class, "_proximanovasemibold").getObject()));
 BA.debugLineNum = 120;BA.debugLine="JobTitle.Text = job_title";
Debug.ShouldStop(8388608);
_jobtitle.runMethod(true,"setText",(_job_title));
 BA.debugLineNum = 122;BA.debugLine="JobTitle.TextColor = Colors.RGB(74,74,74)";
Debug.ShouldStop(33554432);
_jobtitle.runMethod(true,"setTextColor",referringlist.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 74)),(Object)(BA.numberCast(int.class, 74)),(Object)(BA.numberCast(int.class, 74))));
 BA.debugLineNum = 125;BA.debugLine="Location.Typeface = font.proximanovaRegular";
Debug.ShouldStop(268435456);
_location.runMethod(false,"setTypeface",(referringlist.mostCurrent._font.runClassMethod (com.qolega.qolegapp.fonts.class, "_proximanovaregular").getObject()));
 BA.debugLineNum = 126;BA.debugLine="Location.Text = job_location";
Debug.ShouldStop(536870912);
_location.runMethod(true,"setText",(_job_location));
 BA.debugLineNum = 127;BA.debugLine="Location.TextColor = Colors.RGB(179,179,179)";
Debug.ShouldStop(1073741824);
_location.runMethod(true,"setTextColor",referringlist.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 179)),(Object)(BA.numberCast(int.class, 179)),(Object)(BA.numberCast(int.class, 179))));
 BA.debugLineNum = 128;BA.debugLine="Location.TextSize = JobTitle.TextSize / 1.25";
Debug.ShouldStop(-2147483648);
_location.runMethod(true,"setTextSize",BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_jobtitle.runMethod(true,"getTextSize"),RemoteObject.createImmutable(1.25)}, "/",0, 0)));
 BA.debugLineNum = 130;BA.debugLine="JobDesc.Typeface = font.proximanovaRegular";
Debug.ShouldStop(2);
_jobdesc.runMethod(false,"setTypeface",(referringlist.mostCurrent._font.runClassMethod (com.qolega.qolegapp.fonts.class, "_proximanovaregular").getObject()));
 BA.debugLineNum = 131;BA.debugLine="JobDesc.Text = job_desc";
Debug.ShouldStop(4);
_jobdesc.runMethod(true,"setText",(_job_desc));
 BA.debugLineNum = 132;BA.debugLine="JobDesc.TextColor = Colors.RGB(179,179,179)";
Debug.ShouldStop(8);
_jobdesc.runMethod(true,"setTextColor",referringlist.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 179)),(Object)(BA.numberCast(int.class, 179)),(Object)(BA.numberCast(int.class, 179))));
 BA.debugLineNum = 133;BA.debugLine="JobDesc.TextSize = JobTitle.TextSize / 1.25";
Debug.ShouldStop(16);
_jobdesc.runMethod(true,"setTextSize",BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_jobtitle.runMethod(true,"getTextSize"),RemoteObject.createImmutable(1.25)}, "/",0, 0)));
 BA.debugLineNum = 135;BA.debugLine="Currency.Typeface = font.proximanovaSemiBold";
Debug.ShouldStop(64);
_currency.runMethod(false,"setTypeface",(referringlist.mostCurrent._font.runClassMethod (com.qolega.qolegapp.fonts.class, "_proximanovasemibold").getObject()));
 BA.debugLineNum = 136;BA.debugLine="Currency.Text = \"IDR \"&NumberFormat(job_commisio";
Debug.ShouldStop(128);
_currency.runMethod(true,"setText",(RemoteObject.concat(RemoteObject.createImmutable("IDR "),referringlist.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(_job_commision),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 2))))));
 BA.debugLineNum = 137;BA.debugLine="Currency.TextColor = Colors.RGB(74,74,74)";
Debug.ShouldStop(256);
_currency.runMethod(true,"setTextColor",referringlist.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 74)),(Object)(BA.numberCast(int.class, 74)),(Object)(BA.numberCast(int.class, 74))));
 BA.debugLineNum = 139;BA.debugLine="Commision.Typeface = font.proximanovaRegular";
Debug.ShouldStop(1024);
_commision.runMethod(false,"setTypeface",(referringlist.mostCurrent._font.runClassMethod (com.qolega.qolegapp.fonts.class, "_proximanovaregular").getObject()));
 BA.debugLineNum = 140;BA.debugLine="Commision.Text = \"Commision\"";
Debug.ShouldStop(2048);
_commision.runMethod(true,"setText",RemoteObject.createImmutable(("Commision")));
 BA.debugLineNum = 141;BA.debugLine="Commision.TextColor = Colors.RGB(179,179,179)";
Debug.ShouldStop(4096);
_commision.runMethod(true,"setTextColor",referringlist.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 179)),(Object)(BA.numberCast(int.class, 179)),(Object)(BA.numberCast(int.class, 179))));
 BA.debugLineNum = 142;BA.debugLine="Commision.TextSize = JobTitle.TextSize / 1.25";
Debug.ShouldStop(8192);
_commision.runMethod(true,"setTextSize",BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_jobtitle.runMethod(true,"getTextSize"),RemoteObject.createImmutable(1.25)}, "/",0, 0)));
 BA.debugLineNum = 145;BA.debugLine="JoblistPanel.AddView(JobTitle,10dip,10dip,100%x-";
Debug.ShouldStop(65536);
_joblistpanel.runVoidMethod ("AddView",(Object)((_jobtitle.getObject())),(Object)(referringlist.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(referringlist.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(RemoteObject.solve(new RemoteObject[] {referringlist.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),referringlist.mostCurrent.activityBA),(RemoteObject.solve(new RemoteObject[] {referringlist.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10))),RemoteObject.createImmutable(2)}, "*",0, 1))}, "-",1, 1)),(Object)(referringlist.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))));
 BA.debugLineNum = 146;BA.debugLine="TextHeight = su.MeasureMultilineTextHeight(JobTi";
Debug.ShouldStop(131072);
_textheight = referringlist.mostCurrent._su.runMethod(true,"MeasureMultilineTextHeight",(Object)((_jobtitle.getObject())),(Object)(_jobtitle.runMethod(true,"getText")));Debug.locals.put("TextHeight", _textheight);
 BA.debugLineNum = 149;BA.debugLine="JoblistPanel.AddView(locationIcon,12dip,TextHeig";
Debug.ShouldStop(1048576);
_joblistpanel.runVoidMethod ("AddView",(Object)((_locationicon.getObject())),(Object)(referringlist.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 12)))),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_textheight,_gap,RemoteObject.createImmutable(1.5)}, "+*",1, 0))),(Object)(referringlist.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 9.6)))),(Object)(referringlist.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 12)))));
 BA.debugLineNum = 152;BA.debugLine="JoblistPanel.AddView(Location,30dip,TextHeight+G";
Debug.ShouldStop(8388608);
_joblistpanel.runVoidMethod ("AddView",(Object)((_location.getObject())),(Object)(referringlist.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_textheight,_gap,RemoteObject.createImmutable(1.5)}, "+*",1, 0))),(Object)(referringlist.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),referringlist.mostCurrent.activityBA)),(Object)(referringlist.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))));
 BA.debugLineNum = 153;BA.debugLine="TextHeight = TextHeight + su.MeasureMultilineTex";
Debug.ShouldStop(16777216);
_textheight = RemoteObject.solve(new RemoteObject[] {_textheight,referringlist.mostCurrent._su.runMethod(true,"MeasureMultilineTextHeight",(Object)((_location.getObject())),(Object)(_location.runMethod(true,"getText")))}, "+",1, 1);Debug.locals.put("TextHeight", _textheight);
 BA.debugLineNum = 156;BA.debugLine="JoblistPanel.AddView(industryIcon,11dip,TextHeig";
Debug.ShouldStop(134217728);
_joblistpanel.runVoidMethod ("AddView",(Object)((_industryicon.getObject())),(Object)(referringlist.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 11)))),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_textheight,_gap,RemoteObject.createImmutable(1.8)}, "+*",1, 0))),(Object)(referringlist.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 12)))),(Object)(referringlist.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 12)))));
 BA.debugLineNum = 158;BA.debugLine="JoblistPanel.AddView(JobDesc,30dip,TextHeight+Ga";
Debug.ShouldStop(536870912);
_joblistpanel.runVoidMethod ("AddView",(Object)((_jobdesc.getObject())),(Object)(referringlist.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_textheight,_gap,RemoteObject.createImmutable(1.8)}, "+*",1, 0))),(Object)(referringlist.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),referringlist.mostCurrent.activityBA)),(Object)(referringlist.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))));
 BA.debugLineNum = 159;BA.debugLine="TextHeight = TextHeight + su.MeasureMultilineTex";
Debug.ShouldStop(1073741824);
_textheight = RemoteObject.solve(new RemoteObject[] {_textheight,referringlist.mostCurrent._su.runMethod(true,"MeasureMultilineTextHeight",(Object)((_jobdesc.getObject())),(Object)(_jobdesc.runMethod(true,"getText")))}, "+",1, 1);Debug.locals.put("TextHeight", _textheight);
 BA.debugLineNum = 162;BA.debugLine="JoblistPanel.AddView(moneyIcon,10dip,TextHeight+";
Debug.ShouldStop(2);
_joblistpanel.runVoidMethod ("AddView",(Object)((_moneyicon.getObject())),(Object)(referringlist.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_textheight,_gap,RemoteObject.createImmutable(2.2)}, "+*",1, 0))),(Object)(referringlist.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 14)))),(Object)(referringlist.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 11.2)))));
 BA.debugLineNum = 164;BA.debugLine="JoblistPanel.AddView(Currency,30.9dip,TextHeight";
Debug.ShouldStop(8);
_joblistpanel.runVoidMethod ("AddView",(Object)((_currency.getObject())),(Object)(referringlist.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30.9)))),(Object)(RemoteObject.solve(new RemoteObject[] {_textheight,_gap,RemoteObject.createImmutable(2)}, "+*",1, 1)),(Object)(referringlist.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 105)))),(Object)(referringlist.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))));
 BA.debugLineNum = 166;BA.debugLine="Dim Canv As Canvas";
Debug.ShouldStop(32);
_canv = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper");Debug.locals.put("Canv", _canv);
 BA.debugLineNum = 167;BA.debugLine="Canv.Initialize(Currency)";
Debug.ShouldStop(64);
_canv.runVoidMethod ("Initialize",(Object)((_currency.getObject())));
 BA.debugLineNum = 168;BA.debugLine="Dim newCurrencyWidth = Canv.MeasureStringWidth(C";
Debug.ShouldStop(128);
_newcurrencywidth = BA.numberCast(int.class, _canv.runMethod(true,"MeasureStringWidth",(Object)(_currency.runMethod(true,"getText")),(Object)((referringlist.mostCurrent._font.runClassMethod (com.qolega.qolegapp.fonts.class, "_proximanovaregular").getObject())),(Object)(_currency.runMethod(true,"getTextSize"))));Debug.locals.put("newCurrencyWidth", _newcurrencywidth);Debug.locals.put("newCurrencyWidth", _newcurrencywidth);
 BA.debugLineNum = 169;BA.debugLine="Currency.Width = newCurrencyWidth+Gap/2";
Debug.ShouldStop(256);
_currency.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_newcurrencywidth,_gap,RemoteObject.createImmutable(2)}, "+/",1, 0)));
 BA.debugLineNum = 171;BA.debugLine="JoblistPanel.AddView(Commision,Currency.Width+Cu";
Debug.ShouldStop(1024);
_joblistpanel.runVoidMethod ("AddView",(Object)((_commision.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {_currency.runMethod(true,"getWidth"),_currency.runMethod(true,"getLeft")}, "+",1, 1)),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_textheight,_gap,RemoteObject.createImmutable(2.2)}, "+*",1, 0))),(Object)(referringlist.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),referringlist.mostCurrent.activityBA)),(Object)(referringlist.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))));
 BA.debugLineNum = 172;BA.debugLine="TextHeight = TextHeight + su.MeasureMultilineTex";
Debug.ShouldStop(2048);
_textheight = RemoteObject.solve(new RemoteObject[] {_textheight,referringlist.mostCurrent._su.runMethod(true,"MeasureMultilineTextHeight",(Object)((_currency.getObject())),(Object)(_currency.runMethod(true,"getText")))}, "+",1, 1);Debug.locals.put("TextHeight", _textheight);
 BA.debugLineNum = 174;BA.debugLine="JoblistPanel.Color=Colors.RGB(255,255,255)";
Debug.ShouldStop(8192);
_joblistpanel.runVoidMethod ("setColor",referringlist.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 255))));
 BA.debugLineNum = 177;BA.debugLine="ReferenceTop = TextHeight+Gap*3";
Debug.ShouldStop(65536);
_referencetop = RemoteObject.solve(new RemoteObject[] {_textheight,_gap,RemoteObject.createImmutable(3)}, "+*",1, 1);Debug.locals.put("ReferenceTop", _referencetop);
 BA.debugLineNum = 179;BA.debugLine="ReferenceHeight = 92dip";
Debug.ShouldStop(262144);
_referenceheight = referringlist.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 92)));Debug.locals.put("ReferenceHeight", _referenceheight);
 BA.debugLineNum = 182;BA.debugLine="Dim SizeOfRef As Int = reference.Size";
Debug.ShouldStop(2097152);
_sizeofref = _reference.runMethod(true,"getSize");Debug.locals.put("SizeOfRef", _sizeofref);Debug.locals.put("SizeOfRef", _sizeofref);
 BA.debugLineNum = 186;BA.debugLine="PanelHeight = PanelHeight+(ReferenceHeight*SizeO";
Debug.ShouldStop(33554432);
_panelheight = RemoteObject.solve(new RemoteObject[] {_panelheight,(RemoteObject.solve(new RemoteObject[] {_referenceheight,_sizeofref}, "*",0, 1)),(RemoteObject.solve(new RemoteObject[] {_gap,_sizeofref}, "*",0, 1))}, "++",2, 1);Debug.locals.put("PanelHeight", _panelheight);
 BA.debugLineNum = 188;BA.debugLine="For Each colreference As Map In reference";
Debug.ShouldStop(134217728);
_colreference = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
final RemoteObject group75 = _reference;
final int groupLen75 = group75.runMethod(true,"getSize").<Integer>get();
for (int index75 = 0;index75 < groupLen75 ;index75++){
_colreference.setObject(group75.runMethod(false,"Get",index75));
Debug.locals.put("colreference", _colreference);
 BA.debugLineNum = 189;BA.debugLine="Dim refName,refCompany,refStatus,detailBtn,refD";
Debug.ShouldStop(268435456);
_refname = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("refName", _refname);
_refcompany = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("refCompany", _refcompany);
_refstatus = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("refStatus", _refstatus);
_detailbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("detailBtn", _detailbtn);
_refday = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("refDay", _refday);
 BA.debugLineNum = 190;BA.debugLine="Dim detailButton As Button";
Debug.ShouldStop(536870912);
_detailbutton = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");Debug.locals.put("detailButton", _detailbutton);
 BA.debugLineNum = 191;BA.debugLine="Dim statusRef As String";
Debug.ShouldStop(1073741824);
_statusref = RemoteObject.createImmutable("");Debug.locals.put("statusRef", _statusref);
 BA.debugLineNum = 192;BA.debugLine="Dim rHeight,statusRefColor As Int";
Debug.ShouldStop(-2147483648);
_rheight = RemoteObject.createImmutable(0);Debug.locals.put("rHeight", _rheight);
_statusrefcolor = RemoteObject.createImmutable(0);Debug.locals.put("statusRefColor", _statusrefcolor);
 BA.debugLineNum = 193;BA.debugLine="Dim userIcon As ImageView";
Debug.ShouldStop(1);
_usericon = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");Debug.locals.put("userIcon", _usericon);
 BA.debugLineNum = 196;BA.debugLine="Dim rName As String = colreference.Get(\"name\")";
Debug.ShouldStop(8);
_rname = BA.ObjectToString(_colreference.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("name")))));Debug.locals.put("rName", _rname);Debug.locals.put("rName", _rname);
 BA.debugLineNum = 197;BA.debugLine="Dim rCompany As String = colreference.Get(\"comp";
Debug.ShouldStop(16);
_rcompany = BA.ObjectToString(_colreference.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("company")))));Debug.locals.put("rCompany", _rcompany);Debug.locals.put("rCompany", _rcompany);
 BA.debugLineNum = 198;BA.debugLine="Dim rStatus As String = colreference.Get(\"statu";
Debug.ShouldStop(32);
_rstatus = BA.ObjectToString(_colreference.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("status")))));Debug.locals.put("rStatus", _rstatus);Debug.locals.put("rStatus", _rstatus);
 BA.debugLineNum = 200;BA.debugLine="Dim userId As Int = colreference.Get(\"user_id\")";
Debug.ShouldStop(128);
_userid = BA.numberCast(int.class, _colreference.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("user_id")))));Debug.locals.put("userId", _userid);Debug.locals.put("userId", _userid);
 BA.debugLineNum = 201;BA.debugLine="Dim daysAgo As String = colreference.Get(\"days_";
Debug.ShouldStop(256);
_daysago = BA.ObjectToString(_colreference.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("days_ago")))));Debug.locals.put("daysAgo", _daysago);Debug.locals.put("daysAgo", _daysago);
 BA.debugLineNum = 204;BA.debugLine="userIcon.Initialize(\"\")";
Debug.ShouldStop(2048);
_usericon.runVoidMethod ("Initialize",referringlist.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 205;BA.debugLine="userIcon.Bitmap = LoadBitmap(File.DirAssets,\"us";
Debug.ShouldStop(4096);
_usericon.runMethod(false,"setBitmap",(referringlist.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(referringlist.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("user.png"))).getObject()));
 BA.debugLineNum = 206;BA.debugLine="userIcon.Gravity = Gravity.FILL";
Debug.ShouldStop(8192);
_usericon.runMethod(true,"setGravity",referringlist.mostCurrent.__c.getField(false,"Gravity").getField(true,"FILL"));
 BA.debugLineNum = 207;BA.debugLine="ReferencePanel.Initialize(\"\")";
Debug.ShouldStop(16384);
_referencepanel.runVoidMethod ("Initialize",referringlist.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 209;BA.debugLine="JoblistPanel.AddView(ReferencePanel,25dip,Refer";
Debug.ShouldStop(65536);
_joblistpanel.runVoidMethod ("AddView",(Object)((_referencepanel.getObject())),(Object)(referringlist.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 25)))),(Object)(_referencetop),(Object)(RemoteObject.solve(new RemoteObject[] {referringlist.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),referringlist.mostCurrent.activityBA),(RemoteObject.solve(new RemoteObject[] {referringlist.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 25))),RemoteObject.createImmutable(2)}, "*",0, 1))}, "-",1, 1)),(Object)(_referenceheight));
 BA.debugLineNum = 211;BA.debugLine="Dim cd As ColorDrawable";
Debug.ShouldStop(262144);
_cd = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.ColorDrawable");Debug.locals.put("cd", _cd);
 BA.debugLineNum = 213;BA.debugLine="cd.Initialize2(Colors.White, 3dip, 1.9dip, Colo";
Debug.ShouldStop(1048576);
_cd.runVoidMethod ("Initialize2",(Object)(referringlist.mostCurrent.__c.getField(false,"Colors").getField(true,"White")),(Object)(referringlist.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 3)))),(Object)(referringlist.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1.9)))),(Object)(referringlist.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 218)),(Object)(BA.numberCast(int.class, 218)),(Object)(BA.numberCast(int.class, 218)))));
 BA.debugLineNum = 214;BA.debugLine="ReferencePanel.Background = cd";
Debug.ShouldStop(2097152);
_referencepanel.runMethod(false,"setBackground",(_cd.getObject()));
 BA.debugLineNum = 219;BA.debugLine="ReferencePanel.AddView(userIcon,10dip,10dip,24d";
Debug.ShouldStop(67108864);
_referencepanel.runVoidMethod ("AddView",(Object)((_usericon.getObject())),(Object)(referringlist.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(referringlist.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(referringlist.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 24)))),(Object)(referringlist.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 24)))));
 BA.debugLineNum = 220;BA.debugLine="refName.Initialize(\"\")";
Debug.ShouldStop(134217728);
_refname.runVoidMethod ("Initialize",referringlist.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 221;BA.debugLine="refName.Text = rName";
Debug.ShouldStop(268435456);
_refname.runMethod(true,"setText",(_rname));
 BA.debugLineNum = 222;BA.debugLine="refName.TextColor = Colors.RGB(74,74,74)";
Debug.ShouldStop(536870912);
_refname.runMethod(true,"setTextColor",referringlist.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 74)),(Object)(BA.numberCast(int.class, 74)),(Object)(BA.numberCast(int.class, 74))));
 BA.debugLineNum = 224;BA.debugLine="refName.Typeface = font.proximanovaSemiBold";
Debug.ShouldStop(-2147483648);
_refname.runMethod(false,"setTypeface",(referringlist.mostCurrent._font.runClassMethod (com.qolega.qolegapp.fonts.class, "_proximanovasemibold").getObject()));
 BA.debugLineNum = 225;BA.debugLine="refName.Gravity = Gravity.CENTER_VERTICAL";
Debug.ShouldStop(1);
_refname.runMethod(true,"setGravity",referringlist.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_VERTICAL"));
 BA.debugLineNum = 226;BA.debugLine="ReferencePanel.AddView(refName,38dip,12dip,Refe";
Debug.ShouldStop(2);
_referencepanel.runVoidMethod ("AddView",(Object)((_refname.getObject())),(Object)(referringlist.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 38)))),(Object)(referringlist.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 12)))),(Object)(RemoteObject.solve(new RemoteObject[] {_referencepanel.runMethod(true,"getWidth"),referringlist.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 38))),RemoteObject.createImmutable(2)}, "-*",1, 1)),(Object)(referringlist.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))));
 BA.debugLineNum = 229;BA.debugLine="refDay.Initialize(\"\")";
Debug.ShouldStop(16);
_refday.runVoidMethod ("Initialize",referringlist.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 230;BA.debugLine="refDay.Text = daysAgo&\"d\"";
Debug.ShouldStop(32);
_refday.runMethod(true,"setText",(RemoteObject.concat(_daysago,RemoteObject.createImmutable("d"))));
 BA.debugLineNum = 231;BA.debugLine="refDay.Typeface = font.proximanovaRegular";
Debug.ShouldStop(64);
_refday.runMethod(false,"setTypeface",(referringlist.mostCurrent._font.runClassMethod (com.qolega.qolegapp.fonts.class, "_proximanovaregular").getObject()));
 BA.debugLineNum = 232;BA.debugLine="refDay.TextColor = Colors.RGB(179,179,179)";
Debug.ShouldStop(128);
_refday.runMethod(true,"setTextColor",referringlist.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 179)),(Object)(BA.numberCast(int.class, 179)),(Object)(BA.numberCast(int.class, 179))));
 BA.debugLineNum = 233;BA.debugLine="refDay.Gravity = Gravity.CENTER";
Debug.ShouldStop(256);
_refday.runMethod(true,"setGravity",referringlist.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 234;BA.debugLine="refDay.TextSize = refName.TextSize / 1.25";
Debug.ShouldStop(512);
_refday.runMethod(true,"setTextSize",BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_refname.runMethod(true,"getTextSize"),RemoteObject.createImmutable(1.25)}, "/",0, 0)));
 BA.debugLineNum = 235;BA.debugLine="ReferencePanel.AddView(refDay,ReferencePanel.Wi";
Debug.ShouldStop(1024);
_referencepanel.runVoidMethod ("AddView",(Object)((_refday.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {_referencepanel.runMethod(true,"getWidth"),referringlist.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20))),_gap}, "--",2, 1)),(Object)(_refname.runMethod(true,"getTop")),(Object)(referringlist.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))),(Object)(_refname.runMethod(true,"getHeight")));
 BA.debugLineNum = 239;BA.debugLine="refCompany.Initialize(\"\")";
Debug.ShouldStop(16384);
_refcompany.runVoidMethod ("Initialize",referringlist.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 240;BA.debugLine="refCompany.Text = rCompany";
Debug.ShouldStop(32768);
_refcompany.runMethod(true,"setText",(_rcompany));
 BA.debugLineNum = 241;BA.debugLine="refCompany.TextColor = Colors.RGB(179,179,179)";
Debug.ShouldStop(65536);
_refcompany.runMethod(true,"setTextColor",referringlist.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 179)),(Object)(BA.numberCast(int.class, 179)),(Object)(BA.numberCast(int.class, 179))));
 BA.debugLineNum = 242;BA.debugLine="refCompany.TextSize = JobTitle.TextSize / 1.25";
Debug.ShouldStop(131072);
_refcompany.runMethod(true,"setTextSize",BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_jobtitle.runMethod(true,"getTextSize"),RemoteObject.createImmutable(1.25)}, "/",0, 0)));
 BA.debugLineNum = 243;BA.debugLine="refCompany.Gravity = Gravity.CENTER_VERTICAL";
Debug.ShouldStop(262144);
_refcompany.runMethod(true,"setGravity",referringlist.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_VERTICAL"));
 BA.debugLineNum = 244;BA.debugLine="ReferencePanel.AddView(refCompany,38dip,refName";
Debug.ShouldStop(524288);
_referencepanel.runVoidMethod ("AddView",(Object)((_refcompany.getObject())),(Object)(referringlist.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 38)))),(Object)(RemoteObject.solve(new RemoteObject[] {_refname.runMethod(true,"getHeight"),_refname.runMethod(true,"getTop")}, "+",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {_referencepanel.runMethod(true,"getWidth"),referringlist.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 38))),RemoteObject.createImmutable(2)}, "-*",1, 1)),(Object)(referringlist.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))));
 BA.debugLineNum = 247;BA.debugLine="refStatus.Initialize(\"\")";
Debug.ShouldStop(4194304);
_refstatus.runVoidMethod ("Initialize",referringlist.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 248;BA.debugLine="Select rStatus";
Debug.ShouldStop(8388608);
switch (BA.switchObjectToInt(_rstatus,BA.ObjectToString("qualifying"),BA.ObjectToString("interview_by_consultant"),BA.ObjectToString("sent_to_client"),BA.ObjectToString("1st_interview"),BA.ObjectToString("2nd_interview"),BA.ObjectToString("3rd_interview"),BA.ObjectToString("follow_up"),BA.ObjectToString("hired"),BA.ObjectToString("1st_day"))) {
case 0: {
 BA.debugLineNum = 250;BA.debugLine="cd.Initialize(Colors.RGB(249,128,55), 2dip)";
Debug.ShouldStop(33554432);
_cd.runVoidMethod ("Initialize",(Object)(referringlist.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 249)),(Object)(BA.numberCast(int.class, 128)),(Object)(BA.numberCast(int.class, 55)))),(Object)(referringlist.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))));
 BA.debugLineNum = 251;BA.debugLine="refStatus.Background = cd";
Debug.ShouldStop(67108864);
_refstatus.runMethod(false,"setBackground",(_cd.getObject()));
 break; }
case 1: {
 BA.debugLineNum = 253;BA.debugLine="cd.Initialize(Colors.RGB(248,190,56), 2dip)";
Debug.ShouldStop(268435456);
_cd.runVoidMethod ("Initialize",(Object)(referringlist.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 248)),(Object)(BA.numberCast(int.class, 190)),(Object)(BA.numberCast(int.class, 56)))),(Object)(referringlist.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))));
 BA.debugLineNum = 254;BA.debugLine="refStatus.Background = cd";
Debug.ShouldStop(536870912);
_refstatus.runMethod(false,"setBackground",(_cd.getObject()));
 break; }
case 2: {
 BA.debugLineNum = 256;BA.debugLine="cd.Initialize(Colors.RGB(186,220,63), 2dip)";
Debug.ShouldStop(-2147483648);
_cd.runVoidMethod ("Initialize",(Object)(referringlist.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 186)),(Object)(BA.numberCast(int.class, 220)),(Object)(BA.numberCast(int.class, 63)))),(Object)(referringlist.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))));
 BA.debugLineNum = 257;BA.debugLine="refStatus.Background = cd";
Debug.ShouldStop(1);
_refstatus.runMethod(false,"setBackground",(_cd.getObject()));
 break; }
case 3: 
case 4: 
case 5: {
 BA.debugLineNum = 259;BA.debugLine="cd.Initialize(Colors.RGB(103,195,68), 2dip)";
Debug.ShouldStop(4);
_cd.runVoidMethod ("Initialize",(Object)(referringlist.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 103)),(Object)(BA.numberCast(int.class, 195)),(Object)(BA.numberCast(int.class, 68)))),(Object)(referringlist.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))));
 BA.debugLineNum = 260;BA.debugLine="refStatus.Background = cd";
Debug.ShouldStop(8);
_refstatus.runMethod(false,"setBackground",(_cd.getObject()));
 break; }
case 6: {
 BA.debugLineNum = 262;BA.debugLine="cd.Initialize(Colors.RGB(62,222,176), 2dip)";
Debug.ShouldStop(32);
_cd.runVoidMethod ("Initialize",(Object)(referringlist.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 62)),(Object)(BA.numberCast(int.class, 222)),(Object)(BA.numberCast(int.class, 176)))),(Object)(referringlist.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))));
 BA.debugLineNum = 263;BA.debugLine="refStatus.Background = cd";
Debug.ShouldStop(64);
_refstatus.runMethod(false,"setBackground",(_cd.getObject()));
 break; }
case 7: {
 BA.debugLineNum = 265;BA.debugLine="cd.Initialize(Colors.RGB(21,176,220), 2dip)";
Debug.ShouldStop(256);
_cd.runVoidMethod ("Initialize",(Object)(referringlist.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 21)),(Object)(BA.numberCast(int.class, 176)),(Object)(BA.numberCast(int.class, 220)))),(Object)(referringlist.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))));
 BA.debugLineNum = 266;BA.debugLine="refStatus.Background = cd";
Debug.ShouldStop(512);
_refstatus.runMethod(false,"setBackground",(_cd.getObject()));
 break; }
case 8: {
 BA.debugLineNum = 268;BA.debugLine="cd.Initialize(Colors.RGB(38,143,235), 2dip)";
Debug.ShouldStop(2048);
_cd.runVoidMethod ("Initialize",(Object)(referringlist.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 38)),(Object)(BA.numberCast(int.class, 143)),(Object)(BA.numberCast(int.class, 235)))),(Object)(referringlist.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))));
 BA.debugLineNum = 269;BA.debugLine="refStatus.Background = cd";
Debug.ShouldStop(4096);
_refstatus.runMethod(false,"setBackground",(_cd.getObject()));
 break; }
default: {
 BA.debugLineNum = 271;BA.debugLine="cd.Initialize(Colors.RGB(3,117,216), 2dip)";
Debug.ShouldStop(16384);
_cd.runVoidMethod ("Initialize",(Object)(referringlist.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 3)),(Object)(BA.numberCast(int.class, 117)),(Object)(BA.numberCast(int.class, 216)))),(Object)(referringlist.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))));
 BA.debugLineNum = 272;BA.debugLine="refStatus.Background = cd";
Debug.ShouldStop(32768);
_refstatus.runMethod(false,"setBackground",(_cd.getObject()));
 break; }
}
;
 BA.debugLineNum = 275;BA.debugLine="refStatus.Text = ToMixCase(rStatus.Replace(\"_\",";
Debug.ShouldStop(262144);
_refstatus.runMethod(true,"setText",(_tomixcase(_rstatus.runMethod(true,"replace",(Object)(BA.ObjectToString("_")),(Object)(RemoteObject.createImmutable(" "))))));
 BA.debugLineNum = 276;BA.debugLine="refStatus.TextColor = Colors.White";
Debug.ShouldStop(524288);
_refstatus.runMethod(true,"setTextColor",referringlist.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 279;BA.debugLine="refStatus.Gravity = Gravity.CENTER";
Debug.ShouldStop(4194304);
_refstatus.runMethod(true,"setGravity",referringlist.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 281;BA.debugLine="ReferencePanel.AddView(refStatus,38dip,refCompa";
Debug.ShouldStop(16777216);
_referencepanel.runVoidMethod ("AddView",(Object)((_refstatus.getObject())),(Object)(referringlist.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 38)))),(Object)(RemoteObject.solve(new RemoteObject[] {_refcompany.runMethod(true,"getTop"),_refcompany.runMethod(true,"getHeight"),_gap}, "++",2, 1)),(Object)(referringlist.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))),(Object)(referringlist.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))));
 BA.debugLineNum = 282;BA.debugLine="Dim refStatusHeight As Int";
Debug.ShouldStop(33554432);
_refstatusheight = RemoteObject.createImmutable(0);Debug.locals.put("refStatusHeight", _refstatusheight);
 BA.debugLineNum = 283;BA.debugLine="refStatusHeight =  su.MeasureMultilineTextHeigh";
Debug.ShouldStop(67108864);
_refstatusheight = referringlist.mostCurrent._su.runMethod(true,"MeasureMultilineTextHeight",(Object)((_refstatus.getObject())),(Object)(_refstatus.runMethod(true,"getText")));Debug.locals.put("refStatusHeight", _refstatusheight);
 BA.debugLineNum = 285;BA.debugLine="If refStatusHeight > refStatus.Height Then";
Debug.ShouldStop(268435456);
if (RemoteObject.solveBoolean(">",_refstatusheight,BA.numberCast(double.class, _refstatus.runMethod(true,"getHeight")))) { 
 BA.debugLineNum = 286;BA.debugLine="refStatus.Height = refStatusHeight";
Debug.ShouldStop(536870912);
_refstatus.runMethod(true,"setHeight",_refstatusheight);
 BA.debugLineNum = 287;BA.debugLine="ReferencePanel.Height = ReferenceHeight + Gap";
Debug.ShouldStop(1073741824);
_referencepanel.runMethod(true,"setHeight",RemoteObject.solve(new RemoteObject[] {_referenceheight,_gap}, "+",1, 1));
 };
 BA.debugLineNum = 301;BA.debugLine="Dim sld As StateListDrawable";
Debug.ShouldStop(4096);
_sld = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.StateListDrawable");Debug.locals.put("sld", _sld);
 BA.debugLineNum = 302;BA.debugLine="Dim pressed As ColorDrawable";
Debug.ShouldStop(8192);
_pressed = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.ColorDrawable");Debug.locals.put("pressed", _pressed);
 BA.debugLineNum = 303;BA.debugLine="pressed.Initialize(Colors.RGB(255, 255, 255)";
Debug.ShouldStop(16384);
_pressed.runVoidMethod ("Initialize",(Object)(referringlist.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 255)))),(Object)(referringlist.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))));
 BA.debugLineNum = 305;BA.debugLine="sld.Initialize";
Debug.ShouldStop(65536);
_sld.runVoidMethod ("Initialize");
 BA.debugLineNum = 306;BA.debugLine="sld.AddState(sld.State_Pressed,pressed)";
Debug.ShouldStop(131072);
_sld.runVoidMethod ("AddState",(Object)(_sld.getField(true,"State_Pressed")),(Object)((_pressed.getObject())));
 BA.debugLineNum = 309;BA.debugLine="detailButton.Initialize(\"detailBtn\")";
Debug.ShouldStop(1048576);
_detailbutton.runVoidMethod ("Initialize",referringlist.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("detailBtn")));
 BA.debugLineNum = 310;BA.debugLine="detailButton.Typeface = font.awesome.FontAwesom";
Debug.ShouldStop(2097152);
_detailbutton.runMethod(false,"setTypeface",(referringlist.mostCurrent._font.runClassMethod (com.qolega.qolegapp.fonts.class, "_awesome").runMethod(false,"_fontawesometypeface").getObject()));
 BA.debugLineNum = 311;BA.debugLine="detailButton.Tag = userId";
Debug.ShouldStop(4194304);
_detailbutton.runMethod(false,"setTag",(_userid));
 BA.debugLineNum = 312;BA.debugLine="detailButton.Text = \"Detail Progress \"&font.awe";
Debug.ShouldStop(8388608);
_detailbutton.runMethod(true,"setText",(RemoteObject.concat(RemoteObject.createImmutable("Detail Progress "),referringlist.mostCurrent._font.runClassMethod (com.qolega.qolegapp.fonts.class, "_awesome").runMethod(true,"_getfontawesomeiconbyname",(Object)(RemoteObject.createImmutable("fa-arrow-right"))))));
 BA.debugLineNum = 313;BA.debugLine="detailButton.TextSize = JobTitle.TextSize / 1.4";
Debug.ShouldStop(16777216);
_detailbutton.runMethod(true,"setTextSize",BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_jobtitle.runMethod(true,"getTextSize"),RemoteObject.createImmutable(1.4)}, "/",0, 0)));
 BA.debugLineNum = 314;BA.debugLine="detailButton.TextColor = Colors.RGB(22,176,221)";
Debug.ShouldStop(33554432);
_detailbutton.runMethod(true,"setTextColor",referringlist.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 22)),(Object)(BA.numberCast(int.class, 176)),(Object)(BA.numberCast(int.class, 221))));
 BA.debugLineNum = 315;BA.debugLine="detailButton.Gravity = Gravity.CENTER";
Debug.ShouldStop(67108864);
_detailbutton.runMethod(true,"setGravity",referringlist.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 316;BA.debugLine="detailButton.Background = sld";
Debug.ShouldStop(134217728);
_detailbutton.runMethod(false,"setBackground",(_sld.getObject()));
 BA.debugLineNum = 327;BA.debugLine="detailList.Add(detailButton)";
Debug.ShouldStop(64);
referringlist.mostCurrent._detaillist.runVoidMethod ("Add",(Object)((_detailbutton.getObject())));
 BA.debugLineNum = 330;BA.debugLine="ReferencePanel.AddView(detailButton,(ReferenceP";
Debug.ShouldStop(512);
_referencepanel.runVoidMethod ("AddView",(Object)((_detailbutton.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_referencepanel.runMethod(true,"getWidth"),referringlist.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 125)))}, "-",1, 1)),_gap}, "-",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {_refcompany.runMethod(true,"getTop"),_refcompany.runMethod(true,"getHeight"),referringlist.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))}, "++",2, 1)),(Object)(referringlist.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 125)))),(Object)(referringlist.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 35)))));
 BA.debugLineNum = 332;BA.debugLine="ReferenceTop = ReferenceTop+ReferenceHeight+Gap";
Debug.ShouldStop(2048);
_referencetop = RemoteObject.solve(new RemoteObject[] {_referencetop,_referenceheight,_gap}, "++",2, 1);Debug.locals.put("ReferenceTop", _referencetop);
 }
Debug.locals.put("colreference", _colreference);
;
 BA.debugLineNum = 335;BA.debugLine="Container.AddView(JoblistPanel,0,PanelTop,Contai";
Debug.ShouldStop(16384);
_container.runVoidMethod ("AddView",(Object)((_joblistpanel.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(_paneltop),(Object)(_container.runMethod(true,"getWidth")),(Object)(_panelheight));
 BA.debugLineNum = 336;BA.debugLine="PanelTop = PanelTop+PanelHeight+Gap";
Debug.ShouldStop(32768);
_paneltop = RemoteObject.solve(new RemoteObject[] {_paneltop,_panelheight,_gap}, "++",2, 1);Debug.locals.put("PanelTop", _paneltop);
 BA.debugLineNum = 337;BA.debugLine="PanelHeight = defaultPanelHeight";
Debug.ShouldStop(65536);
_panelheight = _defaultpanelheight;Debug.locals.put("PanelHeight", _panelheight);
 }
Debug.locals.put("colroot", _colroot);
;
 BA.debugLineNum = 341;BA.debugLine="Dim sld As StateListDrawable";
Debug.ShouldStop(1048576);
_sld = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.StateListDrawable");Debug.locals.put("sld", _sld);
 BA.debugLineNum = 342;BA.debugLine="Dim pressed,enabled As ColorDrawable";
Debug.ShouldStop(2097152);
_pressed = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.ColorDrawable");Debug.locals.put("pressed", _pressed);
_enabled = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.ColorDrawable");Debug.locals.put("enabled", _enabled);
 BA.debugLineNum = 343;BA.debugLine="pressed.Initialize(Colors.RGB(105, 203, 231), 2di";
Debug.ShouldStop(4194304);
_pressed.runVoidMethod ("Initialize",(Object)(referringlist.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 105)),(Object)(BA.numberCast(int.class, 203)),(Object)(BA.numberCast(int.class, 231)))),(Object)(referringlist.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))));
 BA.debugLineNum = 344;BA.debugLine="enabled.Initialize(Colors.RGB(22,176,221), 2dip)";
Debug.ShouldStop(8388608);
_enabled.runVoidMethod ("Initialize",(Object)(referringlist.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 22)),(Object)(BA.numberCast(int.class, 176)),(Object)(BA.numberCast(int.class, 221)))),(Object)(referringlist.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))));
 BA.debugLineNum = 346;BA.debugLine="sld.Initialize";
Debug.ShouldStop(33554432);
_sld.runVoidMethod ("Initialize");
 BA.debugLineNum = 347;BA.debugLine="sld.AddState(sld.State_Pressed,pressed)";
Debug.ShouldStop(67108864);
_sld.runVoidMethod ("AddState",(Object)(_sld.getField(true,"State_Pressed")),(Object)((_pressed.getObject())));
 BA.debugLineNum = 348;BA.debugLine="sld.AddState(sld.State_Enabled,enabled)";
Debug.ShouldStop(134217728);
_sld.runVoidMethod ("AddState",(Object)(_sld.getField(true,"State_Enabled")),(Object)((_enabled.getObject())));
 BA.debugLineNum = 350;BA.debugLine="loadMore.Initialize(\"loadMore\")";
Debug.ShouldStop(536870912);
referringlist.mostCurrent._loadmore.runVoidMethod ("Initialize",referringlist.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("loadMore")));
 BA.debugLineNum = 351;BA.debugLine="loadMore.Text = \"Load More\"";
Debug.ShouldStop(1073741824);
referringlist.mostCurrent._loadmore.runMethod(true,"setText",RemoteObject.createImmutable(("Load More")));
 BA.debugLineNum = 352;BA.debugLine="loadMore.Background = sld";
Debug.ShouldStop(-2147483648);
referringlist.mostCurrent._loadmore.runMethod(false,"setBackground",(_sld.getObject()));
 BA.debugLineNum = 353;BA.debugLine="loadMore.TextColor = Colors.White";
Debug.ShouldStop(1);
referringlist.mostCurrent._loadmore.runMethod(true,"setTextColor",referringlist.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 354;BA.debugLine="loadMore.Gravity = Gravity.CENTER";
Debug.ShouldStop(2);
referringlist.mostCurrent._loadmore.runMethod(true,"setGravity",referringlist.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 355;BA.debugLine="loadMore.Tag = PanelTop";
Debug.ShouldStop(4);
referringlist.mostCurrent._loadmore.runMethod(false,"setTag",(_paneltop));
 BA.debugLineNum = 358;BA.debugLine="Container.Height = PanelTop' + 50dip";
Debug.ShouldStop(32);
_container.runMethod(true,"setHeight",_paneltop);
 BA.debugLineNum = 359;BA.debugLine="End Sub";
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
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _searchitem_click() throws Exception{
try {
		Debug.PushSubsStack("SearchItem_Click (referringlist) ","referringlist",2,referringlist.mostCurrent.activityBA,referringlist.mostCurrent,361);
if (RapidSub.canDelegate("searchitem_click")) return referringlist.remoteMe.runUserSub(false, "referringlist","searchitem_click");
 BA.debugLineNum = 361;BA.debugLine="Sub SearchItem_Click";
Debug.ShouldStop(256);
 BA.debugLineNum = 362;BA.debugLine="qAuth.Logout";
Debug.ShouldStop(512);
referringlist.mostCurrent._qauth.runClassMethod (com.qolega.qolegapp.auth.class, "_logout");
 BA.debugLineNum = 363;BA.debugLine="End Sub";
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
public static RemoteObject  _sleep(RemoteObject _ms) throws Exception{
try {
		Debug.PushSubsStack("Sleep (referringlist) ","referringlist",2,referringlist.mostCurrent.activityBA,referringlist.mostCurrent,383);
if (RapidSub.canDelegate("sleep")) return referringlist.remoteMe.runUserSub(false, "referringlist","sleep", _ms);
RemoteObject _now = RemoteObject.createImmutable(0L);
Debug.locals.put("ms", _ms);
 BA.debugLineNum = 383;BA.debugLine="Sub Sleep(ms As Long)";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 384;BA.debugLine="Dim now As Long";
Debug.ShouldStop(-2147483648);
_now = RemoteObject.createImmutable(0L);Debug.locals.put("now", _now);
 BA.debugLineNum = 385;BA.debugLine="If ms > 1000 Then ms =1000   'avoid application";
Debug.ShouldStop(1);
if (RemoteObject.solveBoolean(">",_ms,BA.numberCast(double.class, 1000))) { 
_ms = BA.numberCast(long.class, 1000);Debug.locals.put("ms", _ms);};
 BA.debugLineNum = 386;BA.debugLine="now=DateTime.Now";
Debug.ShouldStop(2);
_now = referringlist.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow");Debug.locals.put("now", _now);
 BA.debugLineNum = 387;BA.debugLine="Do Until (DateTime.Now>now+ms)";
Debug.ShouldStop(4);
while (!((RemoteObject.solveBoolean(">",referringlist.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"),BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {_now,_ms}, "+",1, 2)))))) {
 BA.debugLineNum = 388;BA.debugLine="DoEvents";
Debug.ShouldStop(8);
referringlist.mostCurrent.__c.runVoidMethodAndSync ("DoEvents");
 }
;
 BA.debugLineNum = 390;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _tomixcase(RemoteObject _entry) throws Exception{
try {
		Debug.PushSubsStack("ToMixCase (referringlist) ","referringlist",2,referringlist.mostCurrent.activityBA,referringlist.mostCurrent,425);
if (RapidSub.canDelegate("tomixcase")) return referringlist.remoteMe.runUserSub(false, "referringlist","tomixcase", _entry);
RemoteObject _sb = RemoteObject.declareNull("anywheresoftware.b4a.keywords.StringBuilderWrapper");
RemoteObject _m = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Regex.MatcherWrapper");
RemoteObject _i = RemoteObject.createImmutable(0);
Debug.locals.put("Entry", _entry);
 BA.debugLineNum = 425;BA.debugLine="Sub ToMixCase(Entry As String) As String";
Debug.ShouldStop(256);
 BA.debugLineNum = 427;BA.debugLine="Dim sb As StringBuilder";
Debug.ShouldStop(1024);
_sb = RemoteObject.createNew ("anywheresoftware.b4a.keywords.StringBuilderWrapper");Debug.locals.put("sb", _sb);
 BA.debugLineNum = 428;BA.debugLine="Dim m As Matcher";
Debug.ShouldStop(2048);
_m = RemoteObject.createNew ("anywheresoftware.b4a.keywords.Regex.MatcherWrapper");Debug.locals.put("m", _m);
 BA.debugLineNum = 429;BA.debugLine="Dim I As Int";
Debug.ShouldStop(4096);
_i = RemoteObject.createImmutable(0);Debug.locals.put("I", _i);
 BA.debugLineNum = 431;BA.debugLine="Entry = Entry.ToLowerCase";
Debug.ShouldStop(16384);
_entry = _entry.runMethod(true,"toLowerCase");Debug.locals.put("Entry", _entry);
 BA.debugLineNum = 433;BA.debugLine="sb.Initialize";
Debug.ShouldStop(65536);
_sb.runVoidMethod ("Initialize");
 BA.debugLineNum = 435;BA.debugLine="m = Regex.Matcher(\"(^\\w)|(\\s\\w)\", Entry)";
Debug.ShouldStop(262144);
_m = referringlist.mostCurrent.__c.getField(false,"Regex").runMethod(false,"Matcher",(Object)(BA.ObjectToString("(^\\w)|(\\s\\w)")),(Object)(_entry));Debug.locals.put("m", _m);
 BA.debugLineNum = 437;BA.debugLine="Do While m.Find";
Debug.ShouldStop(1048576);
while (_m.runMethod(true,"Find").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 439;BA.debugLine="If m.Match.Length > 1 Then";
Debug.ShouldStop(4194304);
if (RemoteObject.solveBoolean(">",_m.runMethod(true,"getMatch").runMethod(true,"length"),BA.numberCast(double.class, 1))) { 
 BA.debugLineNum = 441;BA.debugLine="sb.Append(Entry.SubString2(I, m.GetStart";
Debug.ShouldStop(16777216);
_sb.runVoidMethod ("Append",(Object)(_entry.runMethod(true,"substring",(Object)(_i),(Object)(RemoteObject.solve(new RemoteObject[] {_m.runMethod(true,"GetStart",(Object)(BA.numberCast(int.class, 0))),RemoteObject.createImmutable(1)}, "+",1, 1)))));
 BA.debugLineNum = 442;BA.debugLine="sb.Append(m.Match.SubString(1).ToUpperCa";
Debug.ShouldStop(33554432);
_sb.runVoidMethod ("Append",(Object)(_m.runMethod(true,"getMatch").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 1))).runMethod(true,"toUpperCase")));
 }else {
 BA.debugLineNum = 446;BA.debugLine="sb.Append(Entry.SubString2(I, m.GetStart";
Debug.ShouldStop(536870912);
_sb.runVoidMethod ("Append",(Object)(_entry.runMethod(true,"substring",(Object)(_i),(Object)(_m.runMethod(true,"GetStart",(Object)(BA.numberCast(int.class, 0)))))));
 BA.debugLineNum = 447;BA.debugLine="sb.Append(m.Match.ToUpperCase)";
Debug.ShouldStop(1073741824);
_sb.runVoidMethod ("Append",(Object)(_m.runMethod(true,"getMatch").runMethod(true,"toUpperCase")));
 };
 BA.debugLineNum = 451;BA.debugLine="I = m.GetEnd(0)";
Debug.ShouldStop(4);
_i = _m.runMethod(true,"GetEnd",(Object)(BA.numberCast(int.class, 0)));Debug.locals.put("I", _i);
 }
;
 BA.debugLineNum = 455;BA.debugLine="If I < Entry.Length Then";
Debug.ShouldStop(64);
if (RemoteObject.solveBoolean("<",_i,BA.numberCast(double.class, _entry.runMethod(true,"length")))) { 
 BA.debugLineNum = 457;BA.debugLine="sb.Append(Entry.SubString(I))";
Debug.ShouldStop(256);
_sb.runVoidMethod ("Append",(Object)(_entry.runMethod(true,"substring",(Object)(_i))));
 };
 BA.debugLineNum = 461;BA.debugLine="Return sb.ToString";
Debug.ShouldStop(4096);
if (true) return _sb.runMethod(true,"ToString");
 BA.debugLineNum = 463;BA.debugLine="End Sub";
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
}