package com.qolega.qolegapp;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class referringprogress_subs_0 {


public static RemoteObject  _activity_actionbarhomeclick() throws Exception{
try {
		Debug.PushSubsStack("Activity_ActionBarHomeClick (referringprogress) ","referringprogress",3,referringprogress.mostCurrent.activityBA,referringprogress.mostCurrent,353);
if (RapidSub.canDelegate("activity_actionbarhomeclick")) return referringprogress.remoteMe.runUserSub(false, "referringprogress","activity_actionbarhomeclick");
 BA.debugLineNum = 353;BA.debugLine="Sub Activity_ActionBarHomeClick";
Debug.ShouldStop(1);
 BA.debugLineNum = 354;BA.debugLine="Activity.Finish";
Debug.ShouldStop(2);
referringprogress.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 355;BA.debugLine="End Sub";
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
public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (referringprogress) ","referringprogress",3,referringprogress.mostCurrent.activityBA,referringprogress.mostCurrent,29);
if (RapidSub.canDelegate("activity_create")) return referringprogress.remoteMe.runUserSub(false, "referringprogress","activity_create", _firsttime);
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 29;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 31;BA.debugLine="font.Initialize";
Debug.ShouldStop(1073741824);
referringprogress.mostCurrent._font.runClassMethod (com.qolega.qolegapp.fonts.class, "_initialize",referringprogress.processBA);
 BA.debugLineNum = 32;BA.debugLine="Api.Initialize(\"referringProgress\",Me)";
Debug.ShouldStop(-2147483648);
referringprogress.mostCurrent._api.runClassMethod (com.qolega.qolegapp.api.class, "_initialize",referringprogress.processBA,(Object)(BA.ObjectToString("referringProgress")),(Object)(referringprogress.getObject()));
 BA.debugLineNum = 33;BA.debugLine="detailList.Initialize";
Debug.ShouldStop(1);
referringprogress.mostCurrent._detaillist.runVoidMethod ("Initialize");
 BA.debugLineNum = 37;BA.debugLine="Activity.Title = \"Candidate Progress\"";
Debug.ShouldStop(16);
referringprogress.mostCurrent._activity.runMethod(false,"setTitle",RemoteObject.createImmutable(("Candidate Progress")));
 BA.debugLineNum = 39;BA.debugLine="Container.Initialize(\"\")";
Debug.ShouldStop(64);
referringprogress.mostCurrent._container.runVoidMethod ("Initialize",referringprogress.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 40;BA.debugLine="Container.Color = Colors.RGB(246,246,246)";
Debug.ShouldStop(128);
referringprogress.mostCurrent._container.runVoidMethod ("setColor",referringprogress.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 246)),(Object)(BA.numberCast(int.class, 246)),(Object)(BA.numberCast(int.class, 246))));
 BA.debugLineNum = 41;BA.debugLine="Activity.AddView(Container,0,0,100%x,100%y)";
Debug.ShouldStop(256);
referringprogress.mostCurrent._activity.runVoidMethod ("AddView",(Object)((referringprogress.mostCurrent._container.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(referringprogress.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),referringprogress.mostCurrent.activityBA)),(Object)(referringprogress.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),referringprogress.mostCurrent.activityBA)));
 BA.debugLineNum = 43;BA.debugLine="bar.Initialize(\"bar\")";
Debug.ShouldStop(1024);
referringprogress.mostCurrent._bar.runVoidMethod ("Initialize",(Object)(RemoteObject.createImmutable("bar")),referringprogress.mostCurrent.activityBA);
 BA.debugLineNum = 44;BA.debugLine="bar.ShowUpIndicator = True";
Debug.ShouldStop(2048);
referringprogress.mostCurrent._bar.runVoidMethod ("setShowUpIndicator",referringprogress.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 46;BA.debugLine="ProgressDialogShow(\"Loading Data\")";
Debug.ShouldStop(8192);
referringprogress.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",referringprogress.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("Loading Data")));
 BA.debugLineNum = 47;BA.debugLine="Api.Get(\"/referrals/detail/\"&userId)";
Debug.ShouldStop(16384);
referringprogress.mostCurrent._api.runClassMethod (com.qolega.qolegapp.api.class, "_get",(Object)(RemoteObject.concat(RemoteObject.createImmutable("/referrals/detail/"),referringprogress._userid)));
 BA.debugLineNum = 48;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
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
		Debug.PushSubsStack("Activity_Pause (referringprogress) ","referringprogress",3,referringprogress.mostCurrent.activityBA,referringprogress.mostCurrent,361);
if (RapidSub.canDelegate("activity_pause")) return referringprogress.remoteMe.runUserSub(false, "referringprogress","activity_pause", _userclosed);
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 361;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(256);
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
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (referringprogress) ","referringprogress",3,referringprogress.mostCurrent.activityBA,referringprogress.mostCurrent,357);
if (RapidSub.canDelegate("activity_resume")) return referringprogress.remoteMe.runUserSub(false, "referringprogress","activity_resume");
 BA.debugLineNum = 357;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(16);
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
public static RemoteObject  _areequal(RemoteObject _b1,RemoteObject _b2) throws Exception{
try {
		Debug.PushSubsStack("AreEqual (referringprogress) ","referringprogress",3,referringprogress.mostCurrent.activityBA,referringprogress.mostCurrent,457);
if (RapidSub.canDelegate("areequal")) return referringprogress.remoteMe.runUserSub(false, "referringprogress","areequal", _b1, _b2);
Debug.locals.put("b1", _b1);
Debug.locals.put("b2", _b2);
 BA.debugLineNum = 457;BA.debugLine="Sub AreEqual(b1 As Int, b2 As Int) As Boolean";
Debug.ShouldStop(256);
 BA.debugLineNum = 458;BA.debugLine="If b1 <> b2 Then Return False";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("!",_b1,BA.numberCast(double.class, _b2))) { 
Debug.CheckDeviceExceptions();if (true) return referringprogress.mostCurrent.__c.getField(true,"False");};
 BA.debugLineNum = 459;BA.debugLine="Return True";
Debug.ShouldStop(1024);
Debug.CheckDeviceExceptions();if (true) return referringprogress.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 460;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _closeicon_click() throws Exception{
try {
		Debug.PushSubsStack("closeIcon_Click (referringprogress) ","referringprogress",3,referringprogress.mostCurrent.activityBA,referringprogress.mostCurrent,407);
if (RapidSub.canDelegate("closeicon_click")) return referringprogress.remoteMe.runUserSub(false, "referringprogress","closeicon_click");
RemoteObject _detailpanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _jobtitlepanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _journeypanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _utiltextlabel = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
 BA.debugLineNum = 407;BA.debugLine="Sub closeIcon_Click";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 408;BA.debugLine="Dim detailPanel,jobTitlePanel,journeyPanel As Pan";
Debug.ShouldStop(8388608);
_detailpanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("detailPanel", _detailpanel);
_jobtitlepanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("jobTitlePanel", _jobtitlepanel);
_journeypanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("journeyPanel", _journeypanel);
 BA.debugLineNum = 409;BA.debugLine="Dim utilTextLabel As Label";
Debug.ShouldStop(16777216);
_utiltextlabel = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("utilTextLabel", _utiltextlabel);
 BA.debugLineNum = 411;BA.debugLine="detailPanel = detailList.Get(0)";
Debug.ShouldStop(67108864);
_detailpanel.setObject(referringprogress.mostCurrent._detaillist.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))));
 BA.debugLineNum = 412;BA.debugLine="utilTextLabel = detailList.Get(1)";
Debug.ShouldStop(134217728);
_utiltextlabel.setObject(referringprogress.mostCurrent._detaillist.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))));
 BA.debugLineNum = 413;BA.debugLine="jobTitlePanel = detailList.Get(2)";
Debug.ShouldStop(268435456);
_jobtitlepanel.setObject(referringprogress.mostCurrent._detaillist.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))));
 BA.debugLineNum = 414;BA.debugLine="journeyPanel = detailList.Get(3)";
Debug.ShouldStop(536870912);
_journeypanel.setObject(referringprogress.mostCurrent._detaillist.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 3))));
 BA.debugLineNum = 416;BA.debugLine="detailPanel.Height = detailPanel.Height - 200dip";
Debug.ShouldStop(-2147483648);
_detailpanel.runMethod(true,"setHeight",RemoteObject.solve(new RemoteObject[] {_detailpanel.runMethod(true,"getHeight"),referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 200)))}, "-",1, 1));
 BA.debugLineNum = 417;BA.debugLine="utilTextLabel.Top = detailPanel.Height";
Debug.ShouldStop(1);
_utiltextlabel.runMethod(true,"setTop",_detailpanel.runMethod(true,"getHeight"));
 BA.debugLineNum = 418;BA.debugLine="utilTextLabel.Text = \"Show candidate details\"";
Debug.ShouldStop(2);
_utiltextlabel.runMethod(true,"setText",RemoteObject.createImmutable(("Show candidate details")));
 BA.debugLineNum = 419;BA.debugLine="jobTitlePanel.Top = utilTextLabel.Top + utilTextL";
Debug.ShouldStop(4);
_jobtitlepanel.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {_utiltextlabel.runMethod(true,"getTop"),_utiltextlabel.runMethod(true,"getHeight")}, "+",1, 1));
 BA.debugLineNum = 420;BA.debugLine="scrollView.Top = jobTitlePanel.Top + jobTitlePane";
Debug.ShouldStop(8);
referringprogress.mostCurrent._scrollview.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {_jobtitlepanel.runMethod(true,"getTop"),_jobtitlepanel.runMethod(true,"getHeight")}, "+",1, 1));
 BA.debugLineNum = 421;BA.debugLine="journeyPanel.Height = journeyPanel.Height - jobTi";
Debug.ShouldStop(16);
_journeypanel.runMethod(true,"setHeight",RemoteObject.solve(new RemoteObject[] {_journeypanel.runMethod(true,"getHeight"),_jobtitlepanel.runMethod(true,"getTop"),_jobtitlepanel.runMethod(true,"getHeight")}, "-+",2, 1));
 BA.debugLineNum = 426;BA.debugLine="showIcon.Visible = True";
Debug.ShouldStop(512);
referringprogress.mostCurrent._showicon.runMethod(true,"setVisible",referringprogress.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 427;BA.debugLine="closeIcon.Visible = False";
Debug.ShouldStop(1024);
referringprogress.mostCurrent._closeicon.runMethod(true,"setVisible",referringprogress.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 428;BA.debugLine="End Sub";
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
public static RemoteObject  _drawbordertop(RemoteObject _target,RemoteObject _acolor,RemoteObject _strokewidth) throws Exception{
try {
		Debug.PushSubsStack("DrawBorderTop (referringprogress) ","referringprogress",3,referringprogress.mostCurrent.activityBA,referringprogress.mostCurrent,447);
if (RapidSub.canDelegate("drawbordertop")) return referringprogress.remoteMe.runUserSub(false, "referringprogress","drawbordertop", _target, _acolor, _strokewidth);
RemoteObject _c = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper");
RemoteObject _path = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.PathWrapper");
Debug.locals.put("Target", _target);
Debug.locals.put("aColor", _acolor);
Debug.locals.put("StrokeWidth", _strokewidth);
 BA.debugLineNum = 447;BA.debugLine="Sub DrawBorderTop(Target As View,aColor As Int,Str";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 448;BA.debugLine="Dim c As Canvas";
Debug.ShouldStop(-2147483648);
_c = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper");Debug.locals.put("c", _c);
 BA.debugLineNum = 449;BA.debugLine="c.Initialize(Target)";
Debug.ShouldStop(1);
_c.runVoidMethod ("Initialize",(Object)((_target.getObject())));
 BA.debugLineNum = 450;BA.debugLine="Dim Path As Path";
Debug.ShouldStop(2);
_path = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.PathWrapper");Debug.locals.put("Path", _path);
 BA.debugLineNum = 451;BA.debugLine="Path.Initialize(0,0)";
Debug.ShouldStop(4);
_path.runVoidMethod ("Initialize",(Object)(BA.numberCast(float.class, 0)),(Object)(BA.numberCast(float.class, 0)));
 BA.debugLineNum = 452;BA.debugLine="Path.LineTo(Target.Width,0)";
Debug.ShouldStop(8);
_path.runVoidMethod ("LineTo",(Object)(BA.numberCast(float.class, _target.runMethod(true,"getWidth"))),(Object)(BA.numberCast(float.class, 0)));
 BA.debugLineNum = 453;BA.debugLine="c.DrawPath(Path,aColor,False,StrokeWidth)";
Debug.ShouldStop(16);
_c.runVoidMethod ("DrawPath",(Object)((_path.getObject())),(Object)(_acolor),(Object)(referringprogress.mostCurrent.__c.getField(true,"False")),(Object)(BA.numberCast(float.class, _strokewidth)));
 BA.debugLineNum = 454;BA.debugLine="Target.Invalidate";
Debug.ShouldStop(32);
_target.runVoidMethod ("Invalidate");
 BA.debugLineNum = 455;BA.debugLine="End Sub";
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
public static RemoteObject  _drawdashline(RemoteObject _target,RemoteObject _x1,RemoteObject _y1,RemoteObject _x2,RemoteObject _y2,RemoteObject _col,RemoteObject _stroke) throws Exception{
try {
		Debug.PushSubsStack("DrawDashLine (referringprogress) ","referringprogress",3,referringprogress.mostCurrent.activityBA,referringprogress.mostCurrent,431);
if (RapidSub.canDelegate("drawdashline")) return referringprogress.remoteMe.runUserSub(false, "referringprogress","drawdashline", _target, _x1, _y1, _x2, _y2, _col, _stroke);
RemoteObject _p = RemoteObject.declareNull("com.AB.ABExtDrawing.ABExtDrawing.ABPaint");
RemoteObject _extdrawing = RemoteObject.declareNull("com.AB.ABExtDrawing.ABExtDrawing");
RemoteObject _cvsmain = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper");
Debug.locals.put("Target", _target);
Debug.locals.put("x1", _x1);
Debug.locals.put("y1", _y1);
Debug.locals.put("x2", _x2);
Debug.locals.put("y2", _y2);
Debug.locals.put("col", _col);
Debug.locals.put("Stroke", _stroke);
 BA.debugLineNum = 431;BA.debugLine="Sub DrawDashLine(Target As View,x1 As Float, y1 As";
Debug.ShouldStop(16384);
 BA.debugLineNum = 432;BA.debugLine="Dim p As ABPaint";
Debug.ShouldStop(32768);
_p = RemoteObject.createNew ("com.AB.ABExtDrawing.ABExtDrawing.ABPaint");Debug.locals.put("p", _p);
 BA.debugLineNum = 433;BA.debugLine="Dim ExtDrawing As ABExtDrawing";
Debug.ShouldStop(65536);
_extdrawing = RemoteObject.createNew ("com.AB.ABExtDrawing.ABExtDrawing");Debug.locals.put("ExtDrawing", _extdrawing);
 BA.debugLineNum = 434;BA.debugLine="Dim cvsMain As Canvas";
Debug.ShouldStop(131072);
_cvsmain = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper");Debug.locals.put("cvsMain", _cvsmain);
 BA.debugLineNum = 436;BA.debugLine="cvsMain.Initialize(Target)";
Debug.ShouldStop(524288);
_cvsmain.runVoidMethod ("Initialize",(Object)((_target.getObject())));
 BA.debugLineNum = 438;BA.debugLine="p.Initialize";
Debug.ShouldStop(2097152);
_p.runVoidMethod ("Initialize");
 BA.debugLineNum = 439;BA.debugLine="p.SetStrokeWidth(Stroke)";
Debug.ShouldStop(4194304);
_p.runVoidMethod ("SetStrokeWidth",(Object)(_stroke));
 BA.debugLineNum = 440;BA.debugLine="p.SetStyle(p.Style_STROKE)";
Debug.ShouldStop(8388608);
_p.runVoidMethod ("SetStyle",(Object)(_p.getField(true,"Style_STROKE")));
 BA.debugLineNum = 441;BA.debugLine="p.SetColor(col)";
Debug.ShouldStop(16777216);
_p.runVoidMethod ("SetColor",(Object)(_col));
 BA.debugLineNum = 442;BA.debugLine="p.SetDashPathEffect(1, Array As Float(2dip, 2d";
Debug.ShouldStop(33554432);
_p.runVoidMethod ("SetDashPathEffect",(Object)(BA.numberCast(int.class, 1)),(Object)(RemoteObject.createNewArray("float",new int[] {2},new Object[] {BA.numberCast(float.class, referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))),BA.numberCast(float.class, referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2))))})),(Object)(BA.numberCast(float.class, 0)));
 BA.debugLineNum = 443;BA.debugLine="p.DoPathEffectSingle(1)";
Debug.ShouldStop(67108864);
_p.runVoidMethod ("DoPathEffectSingle",(Object)(BA.numberCast(int.class, 1)));
 BA.debugLineNum = 444;BA.debugLine="ExtDrawing.DrawLine(cvsMain, x1, y1, x2, y2, p";
Debug.ShouldStop(134217728);
_extdrawing.runVoidMethod ("drawLine",(Object)(_cvsmain),(Object)(_x1),(Object)(_y1),(Object)(_x2),(Object)(_y2),(Object)(_p));
 BA.debugLineNum = 445;BA.debugLine="End Sub";
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
public static RemoteObject  _drawleftborder(RemoteObject _target,RemoteObject _acolor,RemoteObject _strokewidth,RemoteObject _last,RemoteObject _single) throws Exception{
try {
		Debug.PushSubsStack("DrawLeftBorder (referringprogress) ","referringprogress",3,referringprogress.mostCurrent.activityBA,referringprogress.mostCurrent,365);
if (RapidSub.canDelegate("drawleftborder")) return referringprogress.remoteMe.runUserSub(false, "referringprogress","drawleftborder", _target, _acolor, _strokewidth, _last, _single);
RemoteObject _c = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper");
RemoteObject _path1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.PathWrapper");
Debug.locals.put("Target", _target);
Debug.locals.put("aColor", _acolor);
Debug.locals.put("StrokeWidth", _strokewidth);
Debug.locals.put("Last", _last);
Debug.locals.put("Single", _single);
 BA.debugLineNum = 365;BA.debugLine="Public Sub DrawLeftBorder(Target As View, aColor A";
Debug.ShouldStop(4096);
 BA.debugLineNum = 366;BA.debugLine="Dim c As Canvas";
Debug.ShouldStop(8192);
_c = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper");Debug.locals.put("c", _c);
 BA.debugLineNum = 367;BA.debugLine="c.Initialize(Target)";
Debug.ShouldStop(16384);
_c.runVoidMethod ("Initialize",(Object)((_target.getObject())));
 BA.debugLineNum = 368;BA.debugLine="Dim Path1 As Path";
Debug.ShouldStop(32768);
_path1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.PathWrapper");Debug.locals.put("Path1", _path1);
 BA.debugLineNum = 369;BA.debugLine="Path1.Initialize(0,0)";
Debug.ShouldStop(65536);
_path1.runVoidMethod ("Initialize",(Object)(BA.numberCast(float.class, 0)),(Object)(BA.numberCast(float.class, 0)));
 BA.debugLineNum = 371;BA.debugLine="If Last == True Then";
Debug.ShouldStop(262144);
if (RemoteObject.solveBoolean("=",_last,referringprogress.mostCurrent.__c.getField(true,"True"))) { 
 }else {
 BA.debugLineNum = 374;BA.debugLine="If Single == True Then";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean("=",_single,referringprogress.mostCurrent.__c.getField(true,"True"))) { 
 }else {
 BA.debugLineNum = 377;BA.debugLine="Path1.LineTo(0,Target.Height)";
Debug.ShouldStop(16777216);
_path1.runVoidMethod ("LineTo",(Object)(BA.numberCast(float.class, 0)),(Object)(BA.numberCast(float.class, _target.runMethod(true,"getHeight"))));
 };
 };
 BA.debugLineNum = 381;BA.debugLine="c.DrawPath(Path1, aColor, False, StrokeWidth)";
Debug.ShouldStop(268435456);
_c.runVoidMethod ("DrawPath",(Object)((_path1.getObject())),(Object)(_acolor),(Object)(referringprogress.mostCurrent.__c.getField(true,"False")),(Object)(BA.numberCast(float.class, _strokewidth)));
 BA.debugLineNum = 382;BA.debugLine="Target.Invalidate";
Debug.ShouldStop(536870912);
_target.runVoidMethod ("Invalidate");
 BA.debugLineNum = 383;BA.debugLine="End Sub";
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
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 13;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 16;BA.debugLine="Dim scrollView As ScrollView";
referringprogress.mostCurrent._scrollview = RemoteObject.createNew ("anywheresoftware.b4a.objects.ScrollViewWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Dim JSON As JSONParser";
referringprogress.mostCurrent._json = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");
 //BA.debugLineNum = 18;BA.debugLine="Dim su As StringUtils";
referringprogress.mostCurrent._su = RemoteObject.createNew ("anywheresoftware.b4a.objects.StringUtils");
 //BA.debugLineNum = 19;BA.debugLine="Dim Container As Panel";
referringprogress.mostCurrent._container = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Dim font As Fonts";
referringprogress.mostCurrent._font = RemoteObject.createNew ("com.qolega.qolegapp.fonts");
 //BA.debugLineNum = 21;BA.debugLine="Private bar As StdActionBar";
referringprogress.mostCurrent._bar = RemoteObject.createNew ("anywheresoftware.b4a.objects.StdActionBar");
 //BA.debugLineNum = 22;BA.debugLine="Dim detailList As List";
referringprogress.mostCurrent._detaillist = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 24;BA.debugLine="Type RowCol (Row As Int, Col As Int)";
;
 //BA.debugLineNum = 25;BA.debugLine="Dim showIcon,closeIcon As ImageView";
referringprogress.mostCurrent._showicon = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
referringprogress.mostCurrent._closeicon = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Dim Api As Api";
referringprogress.mostCurrent._api = RemoteObject.createNew ("com.qolega.qolegapp.api");
 //BA.debugLineNum = 27;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _jobdone(RemoteObject _job) throws Exception{
try {
		Debug.PushSubsStack("JobDone (referringprogress) ","referringprogress",3,referringprogress.mostCurrent.activityBA,referringprogress.mostCurrent,50);
if (RapidSub.canDelegate("jobdone")) return referringprogress.remoteMe.runUserSub(false, "referringprogress","jobdone", _job);
Debug.locals.put("Job", _job);
 BA.debugLineNum = 50;BA.debugLine="Sub JobDone(Job As HttpJob)";
Debug.ShouldStop(131072);
 BA.debugLineNum = 51;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(262144);
referringprogress.mostCurrent.__c.runVoidMethod ("ProgressDialogHide");
 BA.debugLineNum = 52;BA.debugLine="Log(\"JobName = \" & Job.JobName & \", Success = \"";
Debug.ShouldStop(524288);
referringprogress.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("JobName = "),_job.getField(true,"_jobname"),RemoteObject.createImmutable(", Success = "),_job.getField(true,"_success"))));
 BA.debugLineNum = 53;BA.debugLine="If Job.Success = True Then";
Debug.ShouldStop(1048576);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_success"),referringprogress.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 54;BA.debugLine="LoopPanel(Job.GetString)";
Debug.ShouldStop(2097152);
_looppanel(_job.runClassMethod (com.qolega.qolegapp.httpjob.class, "_getstring"));
 }else {
 BA.debugLineNum = 56;BA.debugLine="Log(\"Error: \" & Job.ErrorMessage)";
Debug.ShouldStop(8388608);
referringprogress.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job.getField(true,"_errormessage"))));
 BA.debugLineNum = 57;BA.debugLine="ToastMessageShow(\"Error: \" & Job.ErrorMessag";
Debug.ShouldStop(16777216);
referringprogress.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job.getField(true,"_errormessage"))),(Object)(referringprogress.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 59;BA.debugLine="Job.Release";
Debug.ShouldStop(67108864);
_job.runClassMethod (com.qolega.qolegapp.httpjob.class, "_release");
 BA.debugLineNum = 60;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _looppanel(RemoteObject _data) throws Exception{
try {
		Debug.PushSubsStack("LoopPanel (referringprogress) ","referringprogress",3,referringprogress.mostCurrent.activityBA,referringprogress.mostCurrent,62);
if (RapidSub.canDelegate("looppanel")) return referringprogress.remoteMe.runUserSub(false, "referringprogress","looppanel", _data);
RemoteObject _jobtitlepanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _detailpanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _journeypanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _referencepanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _progressbox = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _paneltop = RemoteObject.createImmutable(0);
RemoteObject _icontop = RemoteObject.createImmutable(0);
RemoteObject _panelheight = RemoteObject.createImmutable(0);
RemoteObject _referencetop = RemoteObject.createImmutable(0);
RemoteObject _referenceheight = RemoteObject.createImmutable(0);
RemoteObject _gap = RemoteObject.createImmutable(0);
RemoteObject _textheight = RemoteObject.createImmutable(0);
RemoteObject _jobtitle = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _utiltext = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _refname = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _refcompany = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _refstatus = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _reftext = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _detailbtn = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _refdetwrapper = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _usericon = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
RemoteObject _root = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _dataname = RemoteObject.createImmutable("");
RemoteObject _datacompany = RemoteObject.createImmutable("");
RemoteObject _datalatestpos = RemoteObject.createImmutable("");
RemoteObject _dataphonenum = RemoteObject.createImmutable("");
RemoteObject _dataurl = RemoteObject.createImmutable("");
RemoteObject _dataemail = RemoteObject.createImmutable("");
RemoteObject _datanote = RemoteObject.createImmutable("");
RemoteObject _datajobtitle = RemoteObject.createImmutable("");
RemoteObject _detemail = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _detphonenumber = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _detlatestcomp = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _detlastpos = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _detlinkedinurl = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _detnote = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _textlist = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _valuelist = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _toppos = RemoteObject.createImmutable(0);
int _i = 0;
RemoteObject _l = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _ll = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _lll = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _x = RemoteObject.createImmutable(0);
RemoteObject _utiltextw = RemoteObject.createImmutable(0);
RemoteObject _titleheight = RemoteObject.createImmutable(0);
RemoteObject _referencewrapper = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _journeys = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _iterator = RemoteObject.createImmutable(0);
RemoteObject _lasticontop = RemoteObject.createImmutable(0);
RemoteObject _incrementboxheight = RemoteObject.createImmutable(0);
RemoteObject _boxheight = RemoteObject.createImmutable(0);
RemoteObject _coljourneys = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _journeytext = RemoteObject.createImmutable("");
RemoteObject _rstatus = RemoteObject.createImmutable("");
RemoteObject _rstate = RemoteObject.createImmutable("");
RemoteObject _rstatedesc = RemoteObject.createImmutable("");
RemoteObject _iconname = RemoteObject.createImmutable("");
RemoteObject _statusicon = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
RemoteObject _cd = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.ColorDrawable");
RemoteObject _refstatusheight = RemoteObject.createImmutable(0);
Debug.locals.put("Data", _data);
 BA.debugLineNum = 62;BA.debugLine="Sub LoopPanel(Data As String)";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 63;BA.debugLine="Dim jobTitlePanel,detailPanel,journeyPanel,refere";
Debug.ShouldStop(1073741824);
_jobtitlepanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("jobTitlePanel", _jobtitlepanel);
_detailpanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("detailPanel", _detailpanel);
_journeypanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("journeyPanel", _journeypanel);
_referencepanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("referencePanel", _referencepanel);
_progressbox = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("progressBox", _progressbox);
 BA.debugLineNum = 64;BA.debugLine="Dim PanelTop,IconTop,PanelHeight,ReferenceTop,Ref";
Debug.ShouldStop(-2147483648);
_paneltop = RemoteObject.createImmutable(0);Debug.locals.put("PanelTop", _paneltop);
_icontop = RemoteObject.createImmutable(0);Debug.locals.put("IconTop", _icontop);
_panelheight = RemoteObject.createImmutable(0);Debug.locals.put("PanelHeight", _panelheight);
_referencetop = RemoteObject.createImmutable(0);Debug.locals.put("ReferenceTop", _referencetop);
_referenceheight = RemoteObject.createImmutable(0);Debug.locals.put("ReferenceHeight", _referenceheight);
_gap = RemoteObject.createImmutable(0);Debug.locals.put("Gap", _gap);
_textheight = RemoteObject.createImmutable(0);Debug.locals.put("TextHeight", _textheight);
 BA.debugLineNum = 65;BA.debugLine="Dim jobTitle,utilText,refName,refCompany,refStatu";
Debug.ShouldStop(1);
_jobtitle = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("jobTitle", _jobtitle);
_utiltext = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("utilText", _utiltext);
_refname = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("refName", _refname);
_refcompany = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("refCompany", _refcompany);
_refstatus = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("refStatus", _refstatus);
_reftext = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("refText", _reftext);
_detailbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("detailBtn", _detailbtn);
 BA.debugLineNum = 67;BA.debugLine="Dim refDetWrapper As Panel";
Debug.ShouldStop(4);
_refdetwrapper = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("refDetWrapper", _refdetwrapper);
 BA.debugLineNum = 69;BA.debugLine="Dim userIcon As ImageView";
Debug.ShouldStop(16);
_usericon = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");Debug.locals.put("userIcon", _usericon);
 BA.debugLineNum = 72;BA.debugLine="JSON.Initialize(Data)";
Debug.ShouldStop(128);
referringprogress.mostCurrent._json.runVoidMethod ("Initialize",(Object)(_data));
 BA.debugLineNum = 73;BA.debugLine="Dim root As Map = JSON.NextObject";
Debug.ShouldStop(256);
_root = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_root = referringprogress.mostCurrent._json.runMethod(false,"NextObject");Debug.locals.put("root", _root);Debug.locals.put("root", _root);
 BA.debugLineNum = 75;BA.debugLine="Dim dataName As String = root.Get(\"name\")";
Debug.ShouldStop(1024);
_dataname = BA.ObjectToString(_root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("name")))));Debug.locals.put("dataName", _dataname);Debug.locals.put("dataName", _dataname);
 BA.debugLineNum = 76;BA.debugLine="Dim dataCompany As String = root.Get(\"company\")";
Debug.ShouldStop(2048);
_datacompany = BA.ObjectToString(_root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("company")))));Debug.locals.put("dataCompany", _datacompany);Debug.locals.put("dataCompany", _datacompany);
 BA.debugLineNum = 77;BA.debugLine="Dim dataLatestPos As String = root.Get(\"user_job_";
Debug.ShouldStop(4096);
_datalatestpos = BA.ObjectToString(_root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("user_job_title")))));Debug.locals.put("dataLatestPos", _datalatestpos);Debug.locals.put("dataLatestPos", _datalatestpos);
 BA.debugLineNum = 78;BA.debugLine="Dim dataPhoneNum As String = root.Get(\"phone\")";
Debug.ShouldStop(8192);
_dataphonenum = BA.ObjectToString(_root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("phone")))));Debug.locals.put("dataPhoneNum", _dataphonenum);Debug.locals.put("dataPhoneNum", _dataphonenum);
 BA.debugLineNum = 79;BA.debugLine="Dim dataUrl As String = root.Get(\"linkedin\")";
Debug.ShouldStop(16384);
_dataurl = BA.ObjectToString(_root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("linkedin")))));Debug.locals.put("dataUrl", _dataurl);Debug.locals.put("dataUrl", _dataurl);
 BA.debugLineNum = 80;BA.debugLine="Dim dataEmail As String = root.Get(\"email\")";
Debug.ShouldStop(32768);
_dataemail = BA.ObjectToString(_root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("email")))));Debug.locals.put("dataEmail", _dataemail);Debug.locals.put("dataEmail", _dataemail);
 BA.debugLineNum = 81;BA.debugLine="Dim dataNote As String = root.Get(\"note\")";
Debug.ShouldStop(65536);
_datanote = BA.ObjectToString(_root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("note")))));Debug.locals.put("dataNote", _datanote);Debug.locals.put("dataNote", _datanote);
 BA.debugLineNum = 82;BA.debugLine="Dim dataJobtitle As String = \"Text\"";
Debug.ShouldStop(131072);
_datajobtitle = BA.ObjectToString("Text");Debug.locals.put("dataJobtitle", _datajobtitle);Debug.locals.put("dataJobtitle", _datajobtitle);
 BA.debugLineNum = 85;BA.debugLine="PanelTop = 10dip";
Debug.ShouldStop(1048576);
_paneltop = referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)));Debug.locals.put("PanelTop", _paneltop);
 BA.debugLineNum = 87;BA.debugLine="PanelHeight = 110dip";
Debug.ShouldStop(4194304);
_panelheight = referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 110)));Debug.locals.put("PanelHeight", _panelheight);
 BA.debugLineNum = 89;BA.debugLine="Gap = 10dip";
Debug.ShouldStop(16777216);
_gap = referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)));Debug.locals.put("Gap", _gap);
 BA.debugLineNum = 91;BA.debugLine="detailPanel.Initialize(\"\")";
Debug.ShouldStop(67108864);
_detailpanel.runVoidMethod ("Initialize",referringprogress.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 92;BA.debugLine="detailPanel.Color = Colors.White";
Debug.ShouldStop(134217728);
_detailpanel.runVoidMethod ("setColor",referringprogress.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 93;BA.debugLine="Container.AddView(detailPanel,0,10dip,100%x,70dip";
Debug.ShouldStop(268435456);
referringprogress.mostCurrent._container.runVoidMethod ("AddView",(Object)((_detailpanel.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(referringprogress.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),referringprogress.mostCurrent.activityBA)),(Object)(referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 70)))));
 BA.debugLineNum = 96;BA.debugLine="userIcon.Initialize(\"\")";
Debug.ShouldStop(-2147483648);
_usericon.runVoidMethod ("Initialize",referringprogress.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 97;BA.debugLine="userIcon.Bitmap = LoadBitmap(File.DirAssets,\"user";
Debug.ShouldStop(1);
_usericon.runMethod(false,"setBitmap",(referringprogress.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(referringprogress.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("user.png"))).getObject()));
 BA.debugLineNum = 98;BA.debugLine="userIcon.Gravity = Gravity.FILL";
Debug.ShouldStop(2);
_usericon.runMethod(true,"setGravity",referringprogress.mostCurrent.__c.getField(false,"Gravity").getField(true,"FILL"));
 BA.debugLineNum = 99;BA.debugLine="refName.Initialize(\"\")";
Debug.ShouldStop(4);
_refname.runVoidMethod ("Initialize",referringprogress.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 100;BA.debugLine="refName.Text = dataName";
Debug.ShouldStop(8);
_refname.runMethod(true,"setText",(_dataname));
 BA.debugLineNum = 101;BA.debugLine="refName.TextColor = Colors.RGB(74,74,74)";
Debug.ShouldStop(16);
_refname.runMethod(true,"setTextColor",referringprogress.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 74)),(Object)(BA.numberCast(int.class, 74)),(Object)(BA.numberCast(int.class, 74))));
 BA.debugLineNum = 103;BA.debugLine="refName.Typeface = font.proximanovaSemiBold";
Debug.ShouldStop(64);
_refname.runMethod(false,"setTypeface",(referringprogress.mostCurrent._font.runClassMethod (com.qolega.qolegapp.fonts.class, "_proximanovasemibold").getObject()));
 BA.debugLineNum = 106;BA.debugLine="detailPanel.AddView(userIcon,10dip,10dip,24dip,24";
Debug.ShouldStop(512);
_detailpanel.runVoidMethod ("AddView",(Object)((_usericon.getObject())),(Object)(referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 24)))),(Object)(referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 24)))));
 BA.debugLineNum = 107;BA.debugLine="detailPanel.AddView(refName,38dip,12dip,detailPan";
Debug.ShouldStop(1024);
_detailpanel.runVoidMethod ("AddView",(Object)((_refname.getObject())),(Object)(referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 38)))),(Object)(referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 12)))),(Object)(RemoteObject.solve(new RemoteObject[] {_detailpanel.runMethod(true,"getWidth"),(RemoteObject.solve(new RemoteObject[] {referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 38))),RemoteObject.createImmutable(2)}, "*",0, 1))}, "-",1, 1)),(Object)(referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))));
 BA.debugLineNum = 110;BA.debugLine="refCompany.Initialize(\"\")";
Debug.ShouldStop(8192);
_refcompany.runVoidMethod ("Initialize",referringprogress.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 111;BA.debugLine="refCompany.Text = dataCompany";
Debug.ShouldStop(16384);
_refcompany.runMethod(true,"setText",(_datacompany));
 BA.debugLineNum = 112;BA.debugLine="refCompany.TextColor = Colors.RGB(179,179,179)";
Debug.ShouldStop(32768);
_refcompany.runMethod(true,"setTextColor",referringprogress.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 179)),(Object)(BA.numberCast(int.class, 179)),(Object)(BA.numberCast(int.class, 179))));
 BA.debugLineNum = 114;BA.debugLine="refCompany.Typeface = font.proximanovaRegular";
Debug.ShouldStop(131072);
_refcompany.runMethod(false,"setTypeface",(referringprogress.mostCurrent._font.runClassMethod (com.qolega.qolegapp.fonts.class, "_proximanovaregular").getObject()));
 BA.debugLineNum = 115;BA.debugLine="detailPanel.AddView(refCompany,38dip,refName.Top+";
Debug.ShouldStop(262144);
_detailpanel.runVoidMethod ("AddView",(Object)((_refcompany.getObject())),(Object)(referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 38)))),(Object)(RemoteObject.solve(new RemoteObject[] {_refname.runMethod(true,"getTop"),_refname.runMethod(true,"getHeight")}, "+",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {_detailpanel.runMethod(true,"getWidth"),(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(38),RemoteObject.createImmutable(2)}, "*",0, 1))}, "-",1, 1)),(Object)(referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))));
 BA.debugLineNum = 119;BA.debugLine="refDetWrapper.Initialize(\"\")";
Debug.ShouldStop(4194304);
_refdetwrapper.runVoidMethod ("Initialize",referringprogress.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 120;BA.debugLine="detailPanel.AddView(refDetWrapper,10dip,refCompan";
Debug.ShouldStop(8388608);
_detailpanel.runVoidMethod ("AddView",(Object)((_refdetwrapper.getObject())),(Object)(referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(RemoteObject.solve(new RemoteObject[] {_refcompany.runMethod(true,"getTop"),_refcompany.runMethod(true,"getHeight"),_gap,RemoteObject.createImmutable(2)}, "++*",2, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {_detailpanel.runMethod(true,"getWidth"),referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "-",1, 1)),(Object)(referringprogress.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),referringprogress.mostCurrent.activityBA)));
 BA.debugLineNum = 121;BA.debugLine="DrawBorderTop(refDetWrapper,Colors.RGB(219,219,21";
Debug.ShouldStop(16777216);
_drawbordertop(RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), _refdetwrapper.getObject()),referringprogress.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 219)),(Object)(BA.numberCast(int.class, 219)),(Object)(BA.numberCast(int.class, 219))),referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2))));
 BA.debugLineNum = 124;BA.debugLine="Dim detEmail,detPhoneNumber,detLatestComp,detLast";
Debug.ShouldStop(134217728);
_detemail = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("detEmail", _detemail);
_detphonenumber = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("detPhoneNumber", _detphonenumber);
_detlatestcomp = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("detLatestComp", _detlatestcomp);
_detlastpos = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("detLastPos", _detlastpos);
_detlinkedinurl = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("detLinkedInUrl", _detlinkedinurl);
_detnote = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("detNote", _detnote);
 BA.debugLineNum = 130;BA.debugLine="Dim textList,valueList As List";
Debug.ShouldStop(2);
_textlist = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("textList", _textlist);
_valuelist = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("valueList", _valuelist);
 BA.debugLineNum = 131;BA.debugLine="textList.Initialize";
Debug.ShouldStop(4);
_textlist.runVoidMethod ("Initialize");
 BA.debugLineNum = 132;BA.debugLine="textList.AddAll(Array As String(\"Email\", \"Phone N";
Debug.ShouldStop(8);
_textlist.runVoidMethod ("AddAll",(Object)(referringprogress.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("String",new int[] {6},new Object[] {BA.ObjectToString("Email"),BA.ObjectToString("Phone Number"),BA.ObjectToString("Latest Company"),BA.ObjectToString("Latest Position"),BA.ObjectToString("LinkedIn URL"),RemoteObject.createImmutable("Note")})))));
 BA.debugLineNum = 133;BA.debugLine="valueList.Initialize";
Debug.ShouldStop(16);
_valuelist.runVoidMethod ("Initialize");
 BA.debugLineNum = 134;BA.debugLine="valueList.AddAll(Array As String(dataEmail,dataPh";
Debug.ShouldStop(32);
_valuelist.runVoidMethod ("AddAll",(Object)(referringprogress.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("String",new int[] {6},new Object[] {_dataemail,_dataphonenum,_datacompany,_datalatestpos,_dataurl,_datanote})))));
 BA.debugLineNum = 135;BA.debugLine="Dim topPos As Int";
Debug.ShouldStop(64);
_toppos = RemoteObject.createImmutable(0);Debug.locals.put("topPos", _toppos);
 BA.debugLineNum = 136;BA.debugLine="topPos = 20dip";
Debug.ShouldStop(128);
_toppos = referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)));Debug.locals.put("topPos", _toppos);
 BA.debugLineNum = 138;BA.debugLine="For i=0 To textList.Size -1";
Debug.ShouldStop(512);
{
final int step47 = 1;
final int limit47 = RemoteObject.solve(new RemoteObject[] {_textlist.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
for (_i = 0 ; (step47 > 0 && _i <= limit47) || (step47 < 0 && _i >= limit47); _i = ((int)(0 + _i + step47)) ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 139;BA.debugLine="Dim l,ll,lll As Label";
Debug.ShouldStop(1024);
_l = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("l", _l);
_ll = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("ll", _ll);
_lll = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lll", _lll);
 BA.debugLineNum = 140;BA.debugLine="l.Initialize(\"cell\")";
Debug.ShouldStop(2048);
_l.runVoidMethod ("Initialize",referringprogress.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("cell")));
 BA.debugLineNum = 141;BA.debugLine="l.Text = textList.Get(i)";
Debug.ShouldStop(4096);
_l.runMethod(true,"setText",_textlist.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))));
 BA.debugLineNum = 142;BA.debugLine="l.Typeface = font.proximanovaRegular";
Debug.ShouldStop(8192);
_l.runMethod(false,"setTypeface",(referringprogress.mostCurrent._font.runClassMethod (com.qolega.qolegapp.fonts.class, "_proximanovaregular").getObject()));
 BA.debugLineNum = 143;BA.debugLine="l.TextColor = Colors.RGB(179,179,179)";
Debug.ShouldStop(16384);
_l.runMethod(true,"setTextColor",referringprogress.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 179)),(Object)(BA.numberCast(int.class, 179)),(Object)(BA.numberCast(int.class, 179))));
 BA.debugLineNum = 145;BA.debugLine="refDetWrapper.AddView(l,0,topPos,120dip,20dip)";
Debug.ShouldStop(65536);
_refdetwrapper.runVoidMethod ("AddView",(Object)((_l.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(_toppos),(Object)(referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 120)))),(Object)(referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))));
 BA.debugLineNum = 147;BA.debugLine="ll.Initialize(\"cell2\")";
Debug.ShouldStop(262144);
_ll.runVoidMethod ("Initialize",referringprogress.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("cell2")));
 BA.debugLineNum = 148;BA.debugLine="ll.Text = \":\"";
Debug.ShouldStop(524288);
_ll.runMethod(true,"setText",RemoteObject.createImmutable((":")));
 BA.debugLineNum = 149;BA.debugLine="ll.Typeface = font.proximanovaRegular";
Debug.ShouldStop(1048576);
_ll.runMethod(false,"setTypeface",(referringprogress.mostCurrent._font.runClassMethod (com.qolega.qolegapp.fonts.class, "_proximanovaregular").getObject()));
 BA.debugLineNum = 150;BA.debugLine="ll.TextColor = Colors.RGB(179,179,179)";
Debug.ShouldStop(2097152);
_ll.runMethod(true,"setTextColor",referringprogress.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 179)),(Object)(BA.numberCast(int.class, 179)),(Object)(BA.numberCast(int.class, 179))));
 BA.debugLineNum = 151;BA.debugLine="refDetWrapper.AddView(ll,l.Width,topPos,10dip,20";
Debug.ShouldStop(4194304);
_refdetwrapper.runVoidMethod ("AddView",(Object)((_ll.getObject())),(Object)(_l.runMethod(true,"getWidth")),(Object)(_toppos),(Object)(referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))));
 BA.debugLineNum = 153;BA.debugLine="lll.Initialize(\"cell3\")";
Debug.ShouldStop(16777216);
_lll.runVoidMethod ("Initialize",referringprogress.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("cell3")));
 BA.debugLineNum = 155;BA.debugLine="If i > 0 Then";
Debug.ShouldStop(67108864);
if (RemoteObject.solveBoolean(">",RemoteObject.createImmutable(_i),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 156;BA.debugLine="lll.TextColor = Colors.RGB(74,74,74)";
Debug.ShouldStop(134217728);
_lll.runMethod(true,"setTextColor",referringprogress.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 74)),(Object)(BA.numberCast(int.class, 74)),(Object)(BA.numberCast(int.class, 74))));
 }else {
 BA.debugLineNum = 158;BA.debugLine="lll.TextColor = Colors.RGB(179,179,179)";
Debug.ShouldStop(536870912);
_lll.runMethod(true,"setTextColor",referringprogress.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 179)),(Object)(BA.numberCast(int.class, 179)),(Object)(BA.numberCast(int.class, 179))));
 };
 BA.debugLineNum = 161;BA.debugLine="lll.Typeface = font.proximanovaRegular";
Debug.ShouldStop(1);
_lll.runMethod(false,"setTypeface",(referringprogress.mostCurrent._font.runClassMethod (com.qolega.qolegapp.fonts.class, "_proximanovaregular").getObject()));
 BA.debugLineNum = 162;BA.debugLine="If valueList.Get(i) = \"\" Then";
Debug.ShouldStop(2);
if (RemoteObject.solveBoolean("=",_valuelist.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))),RemoteObject.createImmutable(("")))) { 
 BA.debugLineNum = 163;BA.debugLine="lll.Text = \"-\"";
Debug.ShouldStop(4);
_lll.runMethod(true,"setText",RemoteObject.createImmutable(("-")));
 }else {
 BA.debugLineNum = 165;BA.debugLine="lll.Text = valueList.Get(i)";
Debug.ShouldStop(16);
_lll.runMethod(true,"setText",_valuelist.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))));
 };
 BA.debugLineNum = 167;BA.debugLine="refDetWrapper.AddView(lll,l.Width+ll.Width+Gap,t";
Debug.ShouldStop(64);
_refdetwrapper.runVoidMethod ("AddView",(Object)((_lll.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {_l.runMethod(true,"getWidth"),_ll.runMethod(true,"getWidth"),_gap}, "++",2, 1)),(Object)(_toppos),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {referringprogress.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),referringprogress.mostCurrent.activityBA),RemoteObject.createImmutable(1.5)}, "/",0, 0))),(Object)(BA.numberCast(int.class, -(double) (0 + 2))));
 BA.debugLineNum = 168;BA.debugLine="Dim x As Int";
Debug.ShouldStop(128);
_x = RemoteObject.createImmutable(0);Debug.locals.put("x", _x);
 BA.debugLineNum = 169;BA.debugLine="x = su.MeasureMultilineTextHeight(lll,lll.Text)";
Debug.ShouldStop(256);
_x = referringprogress.mostCurrent._su.runMethod(true,"MeasureMultilineTextHeight",(Object)((_lll.getObject())),(Object)(_lll.runMethod(true,"getText")));Debug.locals.put("x", _x);
 BA.debugLineNum = 171;BA.debugLine="topPos = topPos + x + Gap";
Debug.ShouldStop(1024);
_toppos = RemoteObject.solve(new RemoteObject[] {_toppos,_x,_gap}, "++",2, 1);Debug.locals.put("topPos", _toppos);
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 176;BA.debugLine="detailList.Add(detailPanel)";
Debug.ShouldStop(32768);
referringprogress.mostCurrent._detaillist.runVoidMethod ("Add",(Object)((_detailpanel.getObject())));
 BA.debugLineNum = 179;BA.debugLine="showIcon.Initialize(\"showIcon\")";
Debug.ShouldStop(262144);
referringprogress.mostCurrent._showicon.runVoidMethod ("Initialize",referringprogress.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("showIcon")));
 BA.debugLineNum = 180;BA.debugLine="showIcon.Bitmap = LoadBitmap(File.DirAssets,\"Show";
Debug.ShouldStop(524288);
referringprogress.mostCurrent._showicon.runMethod(false,"setBitmap",(referringprogress.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(referringprogress.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("Show.png"))).getObject()));
 BA.debugLineNum = 181;BA.debugLine="showIcon.Gravity = Gravity.FILL";
Debug.ShouldStop(1048576);
referringprogress.mostCurrent._showicon.runMethod(true,"setGravity",referringprogress.mostCurrent.__c.getField(false,"Gravity").getField(true,"FILL"));
 BA.debugLineNum = 182;BA.debugLine="Container.AddView(showIcon,(detailPanel.Width/2)-";
Debug.ShouldStop(2097152);
referringprogress.mostCurrent._container.runVoidMethod ("AddView",(Object)((referringprogress.mostCurrent._showicon.getObject())),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_detailpanel.runMethod(true,"getWidth"),RemoteObject.createImmutable(2)}, "/",0, 0)),referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 15)))}, "-",1, 0))),(Object)(RemoteObject.solve(new RemoteObject[] {_detailpanel.runMethod(true,"getHeight"),referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))}, "-",1, 1)),(Object)(referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))),(Object)(referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))));
 BA.debugLineNum = 185;BA.debugLine="closeIcon.Initialize(\"closeIcon\")";
Debug.ShouldStop(16777216);
referringprogress.mostCurrent._closeicon.runVoidMethod ("Initialize",referringprogress.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("closeIcon")));
 BA.debugLineNum = 186;BA.debugLine="closeIcon.Bitmap = LoadBitmap(File.DirAssets,\"Clo";
Debug.ShouldStop(33554432);
referringprogress.mostCurrent._closeicon.runMethod(false,"setBitmap",(referringprogress.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(referringprogress.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("Close.png"))).getObject()));
 BA.debugLineNum = 187;BA.debugLine="closeIcon.Visible = False";
Debug.ShouldStop(67108864);
referringprogress.mostCurrent._closeicon.runMethod(true,"setVisible",referringprogress.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 188;BA.debugLine="closeIcon.Gravity = Gravity.FILL";
Debug.ShouldStop(134217728);
referringprogress.mostCurrent._closeicon.runMethod(true,"setGravity",referringprogress.mostCurrent.__c.getField(false,"Gravity").getField(true,"FILL"));
 BA.debugLineNum = 189;BA.debugLine="Container.AddView(closeIcon,(detailPanel.Width/2)";
Debug.ShouldStop(268435456);
referringprogress.mostCurrent._container.runVoidMethod ("AddView",(Object)((referringprogress.mostCurrent._closeicon.getObject())),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_detailpanel.runMethod(true,"getWidth"),RemoteObject.createImmutable(2)}, "/",0, 0)),referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 15)))}, "-",1, 0))),(Object)(RemoteObject.solve(new RemoteObject[] {_detailpanel.runMethod(true,"getHeight"),referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))}, "-",1, 1)),(Object)(referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))),(Object)(referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))));
 BA.debugLineNum = 191;BA.debugLine="Dim utilTextW As Int = 100dip";
Debug.ShouldStop(1073741824);
_utiltextw = referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)));Debug.locals.put("utilTextW", _utiltextw);Debug.locals.put("utilTextW", _utiltextw);
 BA.debugLineNum = 194;BA.debugLine="utilText.Initialize(\"\")";
Debug.ShouldStop(2);
_utiltext.runVoidMethod ("Initialize",referringprogress.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 195;BA.debugLine="Container.AddView(utilText,0,detailPanel.Height,1";
Debug.ShouldStop(4);
referringprogress.mostCurrent._container.runVoidMethod ("AddView",(Object)((_utiltext.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(_detailpanel.runMethod(true,"getHeight")),(Object)(referringprogress.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),referringprogress.mostCurrent.activityBA)),(Object)(referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 70)))));
 BA.debugLineNum = 196;BA.debugLine="utilText.TextColor = Colors.RGB(179,179,179)";
Debug.ShouldStop(8);
_utiltext.runMethod(true,"setTextColor",referringprogress.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 179)),(Object)(BA.numberCast(int.class, 179)),(Object)(BA.numberCast(int.class, 179))));
 BA.debugLineNum = 197;BA.debugLine="utilText.Text = \"Show candidate details\"";
Debug.ShouldStop(16);
_utiltext.runMethod(true,"setText",RemoteObject.createImmutable(("Show candidate details")));
 BA.debugLineNum = 198;BA.debugLine="utilText.Gravity = Gravity.CENTER";
Debug.ShouldStop(32);
_utiltext.runMethod(true,"setGravity",referringprogress.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 201;BA.debugLine="detailList.Add(utilText)";
Debug.ShouldStop(256);
referringprogress.mostCurrent._detaillist.runVoidMethod ("Add",(Object)((_utiltext.getObject())));
 BA.debugLineNum = 204;BA.debugLine="jobTitlePanel.Initialize(\"\")";
Debug.ShouldStop(2048);
_jobtitlepanel.runVoidMethod ("Initialize",referringprogress.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 205;BA.debugLine="Container.AddView(jobTitlePanel,0,(detailPanel.He";
Debug.ShouldStop(4096);
referringprogress.mostCurrent._container.runVoidMethod ("AddView",(Object)((_jobtitlepanel.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_detailpanel.runMethod(true,"getHeight"),_utiltext.runMethod(true,"getHeight")}, "+",1, 1)),_gap}, "-",1, 1)),(Object)(referringprogress.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),referringprogress.mostCurrent.activityBA)),(Object)(referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))));
 BA.debugLineNum = 206;BA.debugLine="jobTitlePanel.Color = Colors.White";
Debug.ShouldStop(8192);
_jobtitlepanel.runVoidMethod ("setColor",referringprogress.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 209;BA.debugLine="detailList.Add(jobTitlePanel)";
Debug.ShouldStop(65536);
referringprogress.mostCurrent._detaillist.runVoidMethod ("Add",(Object)((_jobtitlepanel.getObject())));
 BA.debugLineNum = 211;BA.debugLine="jobTitle.Initialize(\"\")";
Debug.ShouldStop(262144);
_jobtitle.runVoidMethod ("Initialize",referringprogress.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 212;BA.debugLine="jobTitle.Text = \"Referal Progress for \"&dataJobti";
Debug.ShouldStop(524288);
_jobtitle.runMethod(true,"setText",(RemoteObject.concat(RemoteObject.createImmutable("Referal Progress for "),_datajobtitle)));
 BA.debugLineNum = 214;BA.debugLine="jobTitle.TextColor = Colors.RGB(74,74,74)";
Debug.ShouldStop(2097152);
_jobtitle.runMethod(true,"setTextColor",referringprogress.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 74)),(Object)(BA.numberCast(int.class, 74)),(Object)(BA.numberCast(int.class, 74))));
 BA.debugLineNum = 215;BA.debugLine="jobTitlePanel.AddView(jobTitle,10dip,6dip,jobTitl";
Debug.ShouldStop(4194304);
_jobtitlepanel.runVoidMethod ("AddView",(Object)((_jobtitle.getObject())),(Object)(referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 6)))),(Object)(RemoteObject.solve(new RemoteObject[] {_jobtitlepanel.runMethod(true,"getWidth"),(RemoteObject.solve(new RemoteObject[] {referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10))),RemoteObject.createImmutable(2)}, "*",0, 1))}, "-",1, 1)),(Object)(_jobtitlepanel.runMethod(true,"getHeight")));
 BA.debugLineNum = 216;BA.debugLine="Dim titleHeight As Int";
Debug.ShouldStop(8388608);
_titleheight = RemoteObject.createImmutable(0);Debug.locals.put("titleHeight", _titleheight);
 BA.debugLineNum = 217;BA.debugLine="titleHeight = su.MeasureMultilineTextHeight(jobTi";
Debug.ShouldStop(16777216);
_titleheight = referringprogress.mostCurrent._su.runMethod(true,"MeasureMultilineTextHeight",(Object)((_jobtitle.getObject())),(Object)(_jobtitle.runMethod(true,"getText")));Debug.locals.put("titleHeight", _titleheight);
 BA.debugLineNum = 219;BA.debugLine="jobTitlePanel.Height = titleHeight + 20dip";
Debug.ShouldStop(67108864);
_jobtitlepanel.runMethod(true,"setHeight",RemoteObject.solve(new RemoteObject[] {_titleheight,referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "+",1, 1));
 BA.debugLineNum = 221;BA.debugLine="scrollView.Initialize(Activity.Height)";
Debug.ShouldStop(268435456);
referringprogress.mostCurrent._scrollview.runVoidMethod ("Initialize",referringprogress.mostCurrent.activityBA,(Object)(referringprogress.mostCurrent._activity.runMethod(true,"getHeight")));
 BA.debugLineNum = 222;BA.debugLine="scrollView.Color = Colors.White";
Debug.ShouldStop(536870912);
referringprogress.mostCurrent._scrollview.runVoidMethod ("setColor",referringprogress.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 223;BA.debugLine="Container.AddView(scrollView,0,(detailPanel.Heigh";
Debug.ShouldStop(1073741824);
referringprogress.mostCurrent._container.runVoidMethod ("AddView",(Object)((referringprogress.mostCurrent._scrollview.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)((RemoteObject.solve(new RemoteObject[] {_detailpanel.runMethod(true,"getHeight"),_utiltext.runMethod(true,"getHeight"),_jobtitlepanel.runMethod(true,"getHeight"),referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))}, "++-",3, 1))),(Object)(referringprogress.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),referringprogress.mostCurrent.activityBA)),(Object)(referringprogress.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),referringprogress.mostCurrent.activityBA)));
 BA.debugLineNum = 224;BA.debugLine="journeyPanel = scrollView.Panel";
Debug.ShouldStop(-2147483648);
_journeypanel = referringprogress.mostCurrent._scrollview.runMethod(false,"getPanel");Debug.locals.put("journeyPanel", _journeypanel);
 BA.debugLineNum = 227;BA.debugLine="detailList.Add(journeyPanel)";
Debug.ShouldStop(4);
referringprogress.mostCurrent._detaillist.runVoidMethod ("Add",(Object)((_journeypanel.getObject())));
 BA.debugLineNum = 229;BA.debugLine="Dim referenceWrapper As Panel";
Debug.ShouldStop(16);
_referencewrapper = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("referenceWrapper", _referencewrapper);
 BA.debugLineNum = 230;BA.debugLine="referenceWrapper.Initialize(\"\")";
Debug.ShouldStop(32);
_referencewrapper.runVoidMethod ("Initialize",referringprogress.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 232;BA.debugLine="PanelTop = 0";
Debug.ShouldStop(128);
_paneltop = BA.numberCast(int.class, 0);Debug.locals.put("PanelTop", _paneltop);
 BA.debugLineNum = 233;BA.debugLine="IconTop = 12dip";
Debug.ShouldStop(256);
_icontop = referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 12)));Debug.locals.put("IconTop", _icontop);
 BA.debugLineNum = 235;BA.debugLine="Dim journeys As List = root.Get(\"journeys\")";
Debug.ShouldStop(1024);
_journeys = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_journeys.setObject(_root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("journeys")))));Debug.locals.put("journeys", _journeys);
 BA.debugLineNum = 236;BA.debugLine="Dim iterator As Int = 1";
Debug.ShouldStop(2048);
_iterator = BA.numberCast(int.class, 1);Debug.locals.put("iterator", _iterator);Debug.locals.put("iterator", _iterator);
 BA.debugLineNum = 237;BA.debugLine="Dim LastIconTop As Int";
Debug.ShouldStop(4096);
_lasticontop = RemoteObject.createImmutable(0);Debug.locals.put("LastIconTop", _lasticontop);
 BA.debugLineNum = 238;BA.debugLine="Dim IncrementBoxHeight As Int";
Debug.ShouldStop(8192);
_incrementboxheight = RemoteObject.createImmutable(0);Debug.locals.put("IncrementBoxHeight", _incrementboxheight);
 BA.debugLineNum = 239;BA.debugLine="Dim BoxHeight As Int = 40dip";
Debug.ShouldStop(16384);
_boxheight = referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)));Debug.locals.put("BoxHeight", _boxheight);Debug.locals.put("BoxHeight", _boxheight);
 BA.debugLineNum = 241;BA.debugLine="journeyPanel.AddView(referenceWrapper,30dip,Panel";
Debug.ShouldStop(65536);
_journeypanel.runVoidMethod ("AddView",(Object)((_referencewrapper.getObject())),(Object)(referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))),(Object)(_paneltop),(Object)(RemoteObject.solve(new RemoteObject[] {referringprogress.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),referringprogress.mostCurrent.activityBA),(RemoteObject.solve(new RemoteObject[] {referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30))),RemoteObject.createImmutable(2)}, "*",0, 1))}, "-",1, 1)),(Object)(_boxheight));
 BA.debugLineNum = 243;BA.debugLine="For Each coljourneys As Map In journeys";
Debug.ShouldStop(262144);
_coljourneys = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
final RemoteObject group119 = _journeys;
final int groupLen119 = group119.runMethod(true,"getSize").<Integer>get();
for (int index119 = 0;index119 < groupLen119 ;index119++){
_coljourneys.setObject(group119.runMethod(false,"Get",index119));
Debug.locals.put("coljourneys", _coljourneys);
 BA.debugLineNum = 244;BA.debugLine="Dim journeyText As String = coljourneys.Get(\"tex";
Debug.ShouldStop(524288);
_journeytext = BA.ObjectToString(_coljourneys.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("text")))));Debug.locals.put("journeyText", _journeytext);Debug.locals.put("journeyText", _journeytext);
 BA.debugLineNum = 245;BA.debugLine="Dim rStatus As String = coljourneys.Get(\"status\"";
Debug.ShouldStop(1048576);
_rstatus = BA.ObjectToString(_coljourneys.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("status")))));Debug.locals.put("rStatus", _rstatus);Debug.locals.put("rStatus", _rstatus);
 BA.debugLineNum = 246;BA.debugLine="Dim rState As String = coljourneys.Get(\"state_st";
Debug.ShouldStop(2097152);
_rstate = BA.ObjectToString(_coljourneys.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("state_status")))));Debug.locals.put("rState", _rstate);Debug.locals.put("rState", _rstate);
 BA.debugLineNum = 247;BA.debugLine="Dim rStateDesc As String = coljourneys.Get(\"stat";
Debug.ShouldStop(4194304);
_rstatedesc = BA.ObjectToString(_coljourneys.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("state_description")))));Debug.locals.put("rStateDesc", _rstatedesc);Debug.locals.put("rStateDesc", _rstatedesc);
 BA.debugLineNum = 249;BA.debugLine="progressBox.Initialize(\"\")";
Debug.ShouldStop(16777216);
_progressbox.runVoidMethod ("Initialize",referringprogress.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 251;BA.debugLine="journeyPanel.AddView(progressBox,30dip,PanelTop,";
Debug.ShouldStop(67108864);
_journeypanel.runVoidMethod ("AddView",(Object)((_progressbox.getObject())),(Object)(referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))),(Object)(_paneltop),(Object)(RemoteObject.solve(new RemoteObject[] {referringprogress.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),referringprogress.mostCurrent.activityBA),(RemoteObject.solve(new RemoteObject[] {referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30))),RemoteObject.createImmutable(2)}, "*",0, 1))}, "-",1, 1)),(Object)(_boxheight));
 BA.debugLineNum = 253;BA.debugLine="Dim iconName As String";
Debug.ShouldStop(268435456);
_iconname = RemoteObject.createImmutable("");Debug.locals.put("iconName", _iconname);
 BA.debugLineNum = 254;BA.debugLine="If rStatus = \"null\" Then";
Debug.ShouldStop(536870912);
if (RemoteObject.solveBoolean("=",_rstatus,BA.ObjectToString("null"))) { 
 BA.debugLineNum = 255;BA.debugLine="Select rState";
Debug.ShouldStop(1073741824);
switch (BA.switchObjectToInt(_rstate,BA.ObjectToString("WAITING"),BA.ObjectToString("COMPLETE"),BA.ObjectToString("FAILED"))) {
case 0: {
 BA.debugLineNum = 257;BA.debugLine="iconName = \"Progress.png\"";
Debug.ShouldStop(1);
_iconname = BA.ObjectToString("Progress.png");Debug.locals.put("iconName", _iconname);
 break; }
case 1: {
 BA.debugLineNum = 259;BA.debugLine="iconName = \"Done.png\"";
Debug.ShouldStop(4);
_iconname = BA.ObjectToString("Done.png");Debug.locals.put("iconName", _iconname);
 break; }
case 2: {
 BA.debugLineNum = 261;BA.debugLine="iconName = \"Fail.png\"";
Debug.ShouldStop(16);
_iconname = BA.ObjectToString("Fail.png");Debug.locals.put("iconName", _iconname);
 break; }
}
;
 }else {
 BA.debugLineNum = 264;BA.debugLine="iconName = \"Done.png\"";
Debug.ShouldStop(128);
_iconname = BA.ObjectToString("Done.png");Debug.locals.put("iconName", _iconname);
 };
 BA.debugLineNum = 268;BA.debugLine="Dim statusIcon As ImageView";
Debug.ShouldStop(2048);
_statusicon = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");Debug.locals.put("statusIcon", _statusicon);
 BA.debugLineNum = 269;BA.debugLine="statusIcon.Initialize(\"\")";
Debug.ShouldStop(4096);
_statusicon.runVoidMethod ("Initialize",referringprogress.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 270;BA.debugLine="statusIcon.Bitmap = LoadBitmap(File.DirAssets,ic";
Debug.ShouldStop(8192);
_statusicon.runMethod(false,"setBitmap",(referringprogress.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(referringprogress.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(_iconname)).getObject()));
 BA.debugLineNum = 271;BA.debugLine="statusIcon.Gravity = Gravity.FILL";
Debug.ShouldStop(16384);
_statusicon.runMethod(true,"setGravity",referringprogress.mostCurrent.__c.getField(false,"Gravity").getField(true,"FILL"));
 BA.debugLineNum = 272;BA.debugLine="journeyPanel.AddView(statusIcon,30dip-7.5dip,Ico";
Debug.ShouldStop(32768);
_journeypanel.runVoidMethod ("AddView",(Object)((_statusicon.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30))),referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 7.5)))}, "-",1, 1)),(Object)(_icontop),(Object)(referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 16)))),(Object)(referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 16)))));
 BA.debugLineNum = 274;BA.debugLine="Log(rStatus)";
Debug.ShouldStop(131072);
referringprogress.mostCurrent.__c.runVoidMethod ("Log",(Object)(_rstatus));
 BA.debugLineNum = 276;BA.debugLine="If rStatus <> \"null\" Then";
Debug.ShouldStop(524288);
if (RemoteObject.solveBoolean("!",_rstatus,BA.ObjectToString("null"))) { 
 BA.debugLineNum = 277;BA.debugLine="Dim cd As ColorDrawable";
Debug.ShouldStop(1048576);
_cd = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.ColorDrawable");Debug.locals.put("cd", _cd);
 BA.debugLineNum = 278;BA.debugLine="refStatus.Initialize(\"\")";
Debug.ShouldStop(2097152);
_refstatus.runVoidMethod ("Initialize",referringprogress.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 279;BA.debugLine="Select rStatus";
Debug.ShouldStop(4194304);
switch (BA.switchObjectToInt(_rstatus,BA.ObjectToString("qualifying"),BA.ObjectToString("interview_by_consultant"),BA.ObjectToString("sent_to_client"),BA.ObjectToString("1st_interview"),BA.ObjectToString("2nd_interview"),BA.ObjectToString("3rd_interview"),BA.ObjectToString("follow_up"),BA.ObjectToString("hired"),BA.ObjectToString("1st_day"))) {
case 0: {
 BA.debugLineNum = 281;BA.debugLine="cd.Initialize(Colors.RGB(249,128,55), 2dip)";
Debug.ShouldStop(16777216);
_cd.runVoidMethod ("Initialize",(Object)(referringprogress.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 249)),(Object)(BA.numberCast(int.class, 128)),(Object)(BA.numberCast(int.class, 55)))),(Object)(referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))));
 BA.debugLineNum = 282;BA.debugLine="refStatus.Background = cd";
Debug.ShouldStop(33554432);
_refstatus.runMethod(false,"setBackground",(_cd.getObject()));
 break; }
case 1: {
 BA.debugLineNum = 284;BA.debugLine="cd.Initialize(Colors.RGB(248,190,56), 2dip)";
Debug.ShouldStop(134217728);
_cd.runVoidMethod ("Initialize",(Object)(referringprogress.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 248)),(Object)(BA.numberCast(int.class, 190)),(Object)(BA.numberCast(int.class, 56)))),(Object)(referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))));
 BA.debugLineNum = 285;BA.debugLine="refStatus.Background = cd";
Debug.ShouldStop(268435456);
_refstatus.runMethod(false,"setBackground",(_cd.getObject()));
 break; }
case 2: {
 BA.debugLineNum = 287;BA.debugLine="cd.Initialize(Colors.RGB(186,220,63), 2dip)";
Debug.ShouldStop(1073741824);
_cd.runVoidMethod ("Initialize",(Object)(referringprogress.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 186)),(Object)(BA.numberCast(int.class, 220)),(Object)(BA.numberCast(int.class, 63)))),(Object)(referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))));
 BA.debugLineNum = 288;BA.debugLine="refStatus.Background = cd";
Debug.ShouldStop(-2147483648);
_refstatus.runMethod(false,"setBackground",(_cd.getObject()));
 break; }
case 3: 
case 4: 
case 5: {
 BA.debugLineNum = 290;BA.debugLine="cd.Initialize(Colors.RGB(103,195,68), 2dip)";
Debug.ShouldStop(2);
_cd.runVoidMethod ("Initialize",(Object)(referringprogress.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 103)),(Object)(BA.numberCast(int.class, 195)),(Object)(BA.numberCast(int.class, 68)))),(Object)(referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))));
 BA.debugLineNum = 291;BA.debugLine="refStatus.Background = cd";
Debug.ShouldStop(4);
_refstatus.runMethod(false,"setBackground",(_cd.getObject()));
 break; }
case 6: {
 BA.debugLineNum = 293;BA.debugLine="cd.Initialize(Colors.RGB(62,222,176), 2dip)";
Debug.ShouldStop(16);
_cd.runVoidMethod ("Initialize",(Object)(referringprogress.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 62)),(Object)(BA.numberCast(int.class, 222)),(Object)(BA.numberCast(int.class, 176)))),(Object)(referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))));
 BA.debugLineNum = 294;BA.debugLine="refStatus.Background = cd";
Debug.ShouldStop(32);
_refstatus.runMethod(false,"setBackground",(_cd.getObject()));
 break; }
case 7: {
 BA.debugLineNum = 296;BA.debugLine="cd.Initialize(Colors.RGB(21,176,220), 2dip)";
Debug.ShouldStop(128);
_cd.runVoidMethod ("Initialize",(Object)(referringprogress.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 21)),(Object)(BA.numberCast(int.class, 176)),(Object)(BA.numberCast(int.class, 220)))),(Object)(referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))));
 BA.debugLineNum = 297;BA.debugLine="refStatus.Background = cd";
Debug.ShouldStop(256);
_refstatus.runMethod(false,"setBackground",(_cd.getObject()));
 break; }
case 8: {
 BA.debugLineNum = 299;BA.debugLine="cd.Initialize(Colors.RGB(38,143,235), 2dip)";
Debug.ShouldStop(1024);
_cd.runVoidMethod ("Initialize",(Object)(referringprogress.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 38)),(Object)(BA.numberCast(int.class, 143)),(Object)(BA.numberCast(int.class, 235)))),(Object)(referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))));
 BA.debugLineNum = 300;BA.debugLine="refStatus.Background = cd";
Debug.ShouldStop(2048);
_refstatus.runMethod(false,"setBackground",(_cd.getObject()));
 break; }
default: {
 BA.debugLineNum = 302;BA.debugLine="cd.Initialize(Colors.RGB(3,117,216), 2dip)";
Debug.ShouldStop(8192);
_cd.runVoidMethod ("Initialize",(Object)(referringprogress.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 3)),(Object)(BA.numberCast(int.class, 117)),(Object)(BA.numberCast(int.class, 216)))),(Object)(referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))));
 BA.debugLineNum = 303;BA.debugLine="refStatus.Background = cd";
Debug.ShouldStop(16384);
_refstatus.runMethod(false,"setBackground",(_cd.getObject()));
 break; }
}
;
 BA.debugLineNum = 306;BA.debugLine="refStatus.TextColor = Colors.White";
Debug.ShouldStop(131072);
_refstatus.runMethod(true,"setTextColor",referringprogress.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 308;BA.debugLine="refStatus.Text = ToMixCase(rStatus.Replace(\"_\",";
Debug.ShouldStop(524288);
_refstatus.runMethod(true,"setText",(_tomixcase(_rstatus.runMethod(true,"replace",(Object)(BA.ObjectToString("_")),(Object)(RemoteObject.createImmutable(" "))))));
 BA.debugLineNum = 309;BA.debugLine="refStatus.Typeface = font.proximanovaSemiBold";
Debug.ShouldStop(1048576);
_refstatus.runMethod(false,"setTypeface",(referringprogress.mostCurrent._font.runClassMethod (com.qolega.qolegapp.fonts.class, "_proximanovasemibold").getObject()));
 BA.debugLineNum = 310;BA.debugLine="refStatus.Gravity = Gravity.CENTER";
Debug.ShouldStop(2097152);
_refstatus.runMethod(true,"setGravity",referringprogress.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 311;BA.debugLine="progressBox.AddView(refStatus,15dip,10dip,100di";
Debug.ShouldStop(4194304);
_progressbox.runVoidMethod ("AddView",(Object)((_refstatus.getObject())),(Object)(referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 15)))),(Object)(referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))),(Object)(referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))));
 BA.debugLineNum = 312;BA.debugLine="Dim refStatusHeight As Int";
Debug.ShouldStop(8388608);
_refstatusheight = RemoteObject.createImmutable(0);Debug.locals.put("refStatusHeight", _refstatusheight);
 BA.debugLineNum = 313;BA.debugLine="refStatusHeight =  su.MeasureMultilineTextHeigh";
Debug.ShouldStop(16777216);
_refstatusheight = referringprogress.mostCurrent._su.runMethod(true,"MeasureMultilineTextHeight",(Object)((_refstatus.getObject())),(Object)(_refstatus.runMethod(true,"getText")));Debug.locals.put("refStatusHeight", _refstatusheight);
 BA.debugLineNum = 315;BA.debugLine="If refStatusHeight > refStatus.Height Then";
Debug.ShouldStop(67108864);
if (RemoteObject.solveBoolean(">",_refstatusheight,BA.numberCast(double.class, _refstatus.runMethod(true,"getHeight")))) { 
 BA.debugLineNum = 316;BA.debugLine="refStatus.Height = refStatusHeight";
Debug.ShouldStop(134217728);
_refstatus.runMethod(true,"setHeight",_refstatusheight);
 };
 };
 BA.debugLineNum = 321;BA.debugLine="refText.Initialize(\"\")";
Debug.ShouldStop(1);
_reftext.runVoidMethod ("Initialize",referringprogress.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 322;BA.debugLine="refText.Typeface = font.proximanovaRegular";
Debug.ShouldStop(2);
_reftext.runMethod(false,"setTypeface",(referringprogress.mostCurrent._font.runClassMethod (com.qolega.qolegapp.fonts.class, "_proximanovaregular").getObject()));
 BA.debugLineNum = 324;BA.debugLine="If rStatus <> \"null\" Then";
Debug.ShouldStop(8);
if (RemoteObject.solveBoolean("!",_rstatus,BA.ObjectToString("null"))) { 
 BA.debugLineNum = 325;BA.debugLine="refText.Text = journeyText";
Debug.ShouldStop(16);
_reftext.runMethod(true,"setText",(_journeytext));
 BA.debugLineNum = 326;BA.debugLine="progressBox.AddView(refText,refStatus.Left+refS";
Debug.ShouldStop(32);
_progressbox.runVoidMethod ("AddView",(Object)((_reftext.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {_refstatus.runMethod(true,"getLeft"),_refstatus.runMethod(true,"getWidth"),_gap}, "++",2, 1)),(Object)(referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_progressbox.runMethod(true,"getWidth"),RemoteObject.createImmutable(1.5)}, "/",0, 0))),(Object)(BA.numberCast(int.class, -(double) (0 + 2))));
 }else {
 BA.debugLineNum = 328;BA.debugLine="refText.Text = rStateDesc";
Debug.ShouldStop(128);
_reftext.runMethod(true,"setText",(_rstatedesc));
 BA.debugLineNum = 329;BA.debugLine="progressBox.AddView(refText,15dip,13.5dip,progr";
Debug.ShouldStop(256);
_progressbox.runVoidMethod ("AddView",(Object)((_reftext.getObject())),(Object)(referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 15)))),(Object)(referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 13.5)))),(Object)(RemoteObject.solve(new RemoteObject[] {_progressbox.runMethod(true,"getWidth"),referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))}, "-",1, 1)),(Object)(BA.numberCast(int.class, -(double) (0 + 2))));
 };
 BA.debugLineNum = 333;BA.debugLine="Dim TextHeight As Int";
Debug.ShouldStop(4096);
_textheight = RemoteObject.createImmutable(0);Debug.locals.put("TextHeight", _textheight);
 BA.debugLineNum = 334;BA.debugLine="TextHeight =  su.MeasureMultilineTextHeight(refT";
Debug.ShouldStop(8192);
_textheight = referringprogress.mostCurrent._su.runMethod(true,"MeasureMultilineTextHeight",(Object)((_reftext.getObject())),(Object)(_reftext.runMethod(true,"getText")));Debug.locals.put("TextHeight", _textheight);
 BA.debugLineNum = 336;BA.debugLine="If BoxHeight < TextHeight Then";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("<",_boxheight,BA.numberCast(double.class, _textheight))) { 
 BA.debugLineNum = 337;BA.debugLine="progressBox.Height = TextHeight + BoxHeight";
Debug.ShouldStop(65536);
_progressbox.runMethod(true,"setHeight",RemoteObject.solve(new RemoteObject[] {_textheight,_boxheight}, "+",1, 1));
 };
 BA.debugLineNum = 341;BA.debugLine="IconTop = IconTop + progressBox.Height + Gap";
Debug.ShouldStop(1048576);
_icontop = RemoteObject.solve(new RemoteObject[] {_icontop,_progressbox.runMethod(true,"getHeight"),_gap}, "++",2, 1);Debug.locals.put("IconTop", _icontop);
 BA.debugLineNum = 342;BA.debugLine="PanelTop = PanelTop + progressBox.Height + Gap";
Debug.ShouldStop(2097152);
_paneltop = RemoteObject.solve(new RemoteObject[] {_paneltop,_progressbox.runMethod(true,"getHeight"),_gap}, "++",2, 1);Debug.locals.put("PanelTop", _paneltop);
 BA.debugLineNum = 343;BA.debugLine="LastIconTop = statusIcon.Top";
Debug.ShouldStop(4194304);
_lasticontop = _statusicon.runMethod(true,"getTop");Debug.locals.put("LastIconTop", _lasticontop);
 }
Debug.locals.put("coljourneys", _coljourneys);
;
 BA.debugLineNum = 346;BA.debugLine="journeyPanel.Height = PanelTop + scrollView.Top";
Debug.ShouldStop(33554432);
_journeypanel.runMethod(true,"setHeight",RemoteObject.solve(new RemoteObject[] {_paneltop,referringprogress.mostCurrent._scrollview.runMethod(true,"getTop")}, "+",1, 1));
 BA.debugLineNum = 348;BA.debugLine="referenceWrapper.Height = LastIconTop";
Debug.ShouldStop(134217728);
_referencewrapper.runMethod(true,"setHeight",_lasticontop);
 BA.debugLineNum = 349;BA.debugLine="DrawDashLine(referenceWrapper,0,0,0,referenceWrap";
Debug.ShouldStop(268435456);
_drawdashline(RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), _referencewrapper.getObject()),BA.numberCast(float.class, 0),BA.numberCast(float.class, 0),BA.numberCast(float.class, 0),BA.numberCast(float.class, _referencewrapper.runMethod(true,"getHeight")),referringprogress.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 177)),(Object)(BA.numberCast(int.class, 177)),(Object)(BA.numberCast(int.class, 177))),BA.numberCast(float.class, referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 4)))));
 BA.debugLineNum = 351;BA.debugLine="End Sub";
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
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="Public userId As Int";
referringprogress._userid = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _showicon_click() throws Exception{
try {
		Debug.PushSubsStack("showIcon_Click (referringprogress) ","referringprogress",3,referringprogress.mostCurrent.activityBA,referringprogress.mostCurrent,385);
if (RapidSub.canDelegate("showicon_click")) return referringprogress.remoteMe.runUserSub(false, "referringprogress","showicon_click");
RemoteObject _detailpanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _jobtitlepanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _journeypanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _utiltextlabel = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
 BA.debugLineNum = 385;BA.debugLine="Sub showIcon_Click";
Debug.ShouldStop(1);
 BA.debugLineNum = 386;BA.debugLine="Dim detailPanel,jobTitlePanel,journeyPanel As Pan";
Debug.ShouldStop(2);
_detailpanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("detailPanel", _detailpanel);
_jobtitlepanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("jobTitlePanel", _jobtitlepanel);
_journeypanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("journeyPanel", _journeypanel);
 BA.debugLineNum = 387;BA.debugLine="Dim utilTextLabel As Label";
Debug.ShouldStop(4);
_utiltextlabel = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("utilTextLabel", _utiltextlabel);
 BA.debugLineNum = 389;BA.debugLine="detailPanel = detailList.Get(0)";
Debug.ShouldStop(16);
_detailpanel.setObject(referringprogress.mostCurrent._detaillist.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))));
 BA.debugLineNum = 390;BA.debugLine="utilTextLabel = detailList.Get(1)";
Debug.ShouldStop(32);
_utiltextlabel.setObject(referringprogress.mostCurrent._detaillist.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))));
 BA.debugLineNum = 391;BA.debugLine="jobTitlePanel = detailList.Get(2)";
Debug.ShouldStop(64);
_jobtitlepanel.setObject(referringprogress.mostCurrent._detaillist.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 2))));
 BA.debugLineNum = 392;BA.debugLine="journeyPanel = detailList.Get(3)";
Debug.ShouldStop(128);
_journeypanel.setObject(referringprogress.mostCurrent._detaillist.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 3))));
 BA.debugLineNum = 394;BA.debugLine="detailPanel.Height = detailPanel.Height + 200dip";
Debug.ShouldStop(512);
_detailpanel.runMethod(true,"setHeight",RemoteObject.solve(new RemoteObject[] {_detailpanel.runMethod(true,"getHeight"),referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 200)))}, "+",1, 1));
 BA.debugLineNum = 395;BA.debugLine="utilTextLabel.Top = detailPanel.Height";
Debug.ShouldStop(1024);
_utiltextlabel.runMethod(true,"setTop",_detailpanel.runMethod(true,"getHeight"));
 BA.debugLineNum = 396;BA.debugLine="utilTextLabel.Text = \"Hide candidate details\"";
Debug.ShouldStop(2048);
_utiltextlabel.runMethod(true,"setText",RemoteObject.createImmutable(("Hide candidate details")));
 BA.debugLineNum = 397;BA.debugLine="jobTitlePanel.Top = utilTextLabel.Top + utilTextL";
Debug.ShouldStop(4096);
_jobtitlepanel.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {_utiltextlabel.runMethod(true,"getTop"),_utiltextlabel.runMethod(true,"getHeight")}, "+",1, 1));
 BA.debugLineNum = 398;BA.debugLine="scrollView.Top = jobTitlePanel.Top + jobTitlePane";
Debug.ShouldStop(8192);
referringprogress.mostCurrent._scrollview.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {_jobtitlepanel.runMethod(true,"getTop"),_jobtitlepanel.runMethod(true,"getHeight")}, "+",1, 1));
 BA.debugLineNum = 399;BA.debugLine="journeyPanel.Height = journeyPanel.Height + jobTi";
Debug.ShouldStop(16384);
_journeypanel.runMethod(true,"setHeight",RemoteObject.solve(new RemoteObject[] {_journeypanel.runMethod(true,"getHeight"),_jobtitlepanel.runMethod(true,"getTop"),_jobtitlepanel.runMethod(true,"getHeight")}, "++",2, 1));
 BA.debugLineNum = 401;BA.debugLine="showIcon.Visible = False";
Debug.ShouldStop(65536);
referringprogress.mostCurrent._showicon.runMethod(true,"setVisible",referringprogress.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 403;BA.debugLine="closeIcon.Top = detailPanel.Height - 5dip";
Debug.ShouldStop(262144);
referringprogress.mostCurrent._closeicon.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {_detailpanel.runMethod(true,"getHeight"),referringprogress.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))}, "-",1, 1));
 BA.debugLineNum = 404;BA.debugLine="closeIcon.Visible = True";
Debug.ShouldStop(524288);
referringprogress.mostCurrent._closeicon.runMethod(true,"setVisible",referringprogress.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 405;BA.debugLine="End Sub";
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
public static RemoteObject  _tomixcase(RemoteObject _entry) throws Exception{
try {
		Debug.PushSubsStack("ToMixCase (referringprogress) ","referringprogress",3,referringprogress.mostCurrent.activityBA,referringprogress.mostCurrent,462);
if (RapidSub.canDelegate("tomixcase")) return referringprogress.remoteMe.runUserSub(false, "referringprogress","tomixcase", _entry);
RemoteObject _sb = RemoteObject.declareNull("anywheresoftware.b4a.keywords.StringBuilderWrapper");
RemoteObject _m = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Regex.MatcherWrapper");
RemoteObject _i = RemoteObject.createImmutable(0);
Debug.locals.put("Entry", _entry);
 BA.debugLineNum = 462;BA.debugLine="Sub ToMixCase(Entry As String) As String";
Debug.ShouldStop(8192);
 BA.debugLineNum = 464;BA.debugLine="Dim sb As StringBuilder";
Debug.ShouldStop(32768);
_sb = RemoteObject.createNew ("anywheresoftware.b4a.keywords.StringBuilderWrapper");Debug.locals.put("sb", _sb);
 BA.debugLineNum = 465;BA.debugLine="Dim m As Matcher";
Debug.ShouldStop(65536);
_m = RemoteObject.createNew ("anywheresoftware.b4a.keywords.Regex.MatcherWrapper");Debug.locals.put("m", _m);
 BA.debugLineNum = 466;BA.debugLine="Dim I As Int";
Debug.ShouldStop(131072);
_i = RemoteObject.createImmutable(0);Debug.locals.put("I", _i);
 BA.debugLineNum = 468;BA.debugLine="Entry = Entry.ToLowerCase";
Debug.ShouldStop(524288);
_entry = _entry.runMethod(true,"toLowerCase");Debug.locals.put("Entry", _entry);
 BA.debugLineNum = 470;BA.debugLine="sb.Initialize";
Debug.ShouldStop(2097152);
_sb.runVoidMethod ("Initialize");
 BA.debugLineNum = 472;BA.debugLine="m = Regex.Matcher(\"(^\\w)|(\\s\\w)\", Entry)";
Debug.ShouldStop(8388608);
_m = referringprogress.mostCurrent.__c.getField(false,"Regex").runMethod(false,"Matcher",(Object)(BA.ObjectToString("(^\\w)|(\\s\\w)")),(Object)(_entry));Debug.locals.put("m", _m);
 BA.debugLineNum = 474;BA.debugLine="Do While m.Find";
Debug.ShouldStop(33554432);
while (_m.runMethod(true,"Find").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 476;BA.debugLine="If m.Match.Length > 1 Then";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean(">",_m.runMethod(true,"getMatch").runMethod(true,"length"),BA.numberCast(double.class, 1))) { 
 BA.debugLineNum = 478;BA.debugLine="sb.Append(Entry.SubString2(I, m.GetStart";
Debug.ShouldStop(536870912);
_sb.runVoidMethod ("Append",(Object)(_entry.runMethod(true,"substring",(Object)(_i),(Object)(RemoteObject.solve(new RemoteObject[] {_m.runMethod(true,"GetStart",(Object)(BA.numberCast(int.class, 0))),RemoteObject.createImmutable(1)}, "+",1, 1)))));
 BA.debugLineNum = 479;BA.debugLine="sb.Append(m.Match.SubString(1).ToUpperCa";
Debug.ShouldStop(1073741824);
_sb.runVoidMethod ("Append",(Object)(_m.runMethod(true,"getMatch").runMethod(true,"substring",(Object)(BA.numberCast(int.class, 1))).runMethod(true,"toUpperCase")));
 }else {
 BA.debugLineNum = 483;BA.debugLine="sb.Append(Entry.SubString2(I, m.GetStart";
Debug.ShouldStop(4);
_sb.runVoidMethod ("Append",(Object)(_entry.runMethod(true,"substring",(Object)(_i),(Object)(_m.runMethod(true,"GetStart",(Object)(BA.numberCast(int.class, 0)))))));
 BA.debugLineNum = 484;BA.debugLine="sb.Append(m.Match.ToUpperCase)";
Debug.ShouldStop(8);
_sb.runVoidMethod ("Append",(Object)(_m.runMethod(true,"getMatch").runMethod(true,"toUpperCase")));
 };
 BA.debugLineNum = 488;BA.debugLine="I = m.GetEnd(0)";
Debug.ShouldStop(128);
_i = _m.runMethod(true,"GetEnd",(Object)(BA.numberCast(int.class, 0)));Debug.locals.put("I", _i);
 }
;
 BA.debugLineNum = 492;BA.debugLine="If I < Entry.Length Then";
Debug.ShouldStop(2048);
if (RemoteObject.solveBoolean("<",_i,BA.numberCast(double.class, _entry.runMethod(true,"length")))) { 
 BA.debugLineNum = 494;BA.debugLine="sb.Append(Entry.SubString(I))";
Debug.ShouldStop(8192);
_sb.runVoidMethod ("Append",(Object)(_entry.runMethod(true,"substring",(Object)(_i))));
 };
 BA.debugLineNum = 498;BA.debugLine="Return sb.ToString";
Debug.ShouldStop(131072);
Debug.CheckDeviceExceptions();if (true) return _sb.runMethod(true,"ToString");
 BA.debugLineNum = 500;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
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