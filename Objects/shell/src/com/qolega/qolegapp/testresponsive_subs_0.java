package com.qolega.qolegapp;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class testresponsive_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (testresponsive) ","testresponsive",4,testresponsive.mostCurrent.activityBA,testresponsive.mostCurrent,16);
if (RapidSub.canDelegate("activity_create")) return testresponsive.remoteMe.runUserSub(false, "testresponsive","activity_create", _firsttime);
RemoteObject _pnl = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
int _i = 0;
RemoteObject _chk = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
RemoteObject _lbl1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 16;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(32768);
 BA.debugLineNum = 17;BA.debugLine="ScrollView1.Initialize(0)";
Debug.ShouldStop(65536);
testresponsive.mostCurrent._scrollview1.runVoidMethod ("Initialize",testresponsive.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, 0)));
 BA.debugLineNum = 18;BA.debugLine="Dim pnl As Panel";
Debug.ShouldStop(131072);
_pnl = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("pnl", _pnl);
 BA.debugLineNum = 19;BA.debugLine="pnl = ScrollView1.Panel";
Debug.ShouldStop(262144);
_pnl = testresponsive.mostCurrent._scrollview1.runMethod(false,"getPanel");Debug.locals.put("pnl", _pnl);
 BA.debugLineNum = 20;BA.debugLine="Activity.AddView(ScrollView1, 0, 0, 100%x, 100";
Debug.ShouldStop(524288);
testresponsive.mostCurrent._activity.runVoidMethod ("AddView",(Object)((testresponsive.mostCurrent._scrollview1.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(testresponsive.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),testresponsive.mostCurrent.activityBA)),(Object)(testresponsive.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),testresponsive.mostCurrent.activityBA)));
 BA.debugLineNum = 21;BA.debugLine="lstChecks.Initialize";
Debug.ShouldStop(1048576);
testresponsive.mostCurrent._lstchecks.runVoidMethod ("Initialize");
 BA.debugLineNum = 23;BA.debugLine="For i = 1 To 100";
Debug.ShouldStop(4194304);
{
final int step6 = 1;
final int limit6 = 100;
for (_i = 1 ; (step6 > 0 && _i <= limit6) || (step6 < 0 && _i >= limit6); _i = ((int)(0 + _i + step6)) ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 24;BA.debugLine="Dim chk As CheckBox";
Debug.ShouldStop(8388608);
_chk = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");Debug.locals.put("chk", _chk);
 BA.debugLineNum = 25;BA.debugLine="chk.Initialize(\"mnuChecked\")";
Debug.ShouldStop(16777216);
_chk.runVoidMethod ("Initialize",testresponsive.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("mnuChecked")));
 BA.debugLineNum = 26;BA.debugLine="chk.Text = \"Item #\" & i";
Debug.ShouldStop(33554432);
_chk.runMethod(true,"setText",(RemoteObject.concat(RemoteObject.createImmutable("Item #"),RemoteObject.createImmutable(_i))));
 BA.debugLineNum = 27;BA.debugLine="lstChecks.Add(chk)";
Debug.ShouldStop(67108864);
testresponsive.mostCurrent._lstchecks.runVoidMethod ("Add",(Object)((_chk.getObject())));
 BA.debugLineNum = 28;BA.debugLine="Dim lbl1 As Label";
Debug.ShouldStop(134217728);
_lbl1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lbl1", _lbl1);
 BA.debugLineNum = 29;BA.debugLine="lbl1.Initialize(\"\")";
Debug.ShouldStop(268435456);
_lbl1.runVoidMethod ("Initialize",testresponsive.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 30;BA.debugLine="lbl1.Text = \"Value #\" & i";
Debug.ShouldStop(536870912);
_lbl1.runMethod(true,"setText",(RemoteObject.concat(RemoteObject.createImmutable("Value #"),RemoteObject.createImmutable(_i))));
 BA.debugLineNum = 31;BA.debugLine="lbl1.Gravity = Gravity.CENTER_VERTICAL";
Debug.ShouldStop(1073741824);
_lbl1.runMethod(true,"setGravity",testresponsive.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_VERTICAL"));
 BA.debugLineNum = 32;BA.debugLine="pnl.AddView(chk, 0, height * (i - 1), 120d";
Debug.ShouldStop(-2147483648);
_pnl.runVoidMethod ("AddView",(Object)((_chk.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {testresponsive._height,(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),RemoteObject.createImmutable(1)}, "-",1, 1))}, "*",0, 1)),(Object)(testresponsive.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 120)))),(Object)(testresponsive._height));
 BA.debugLineNum = 33;BA.debugLine="pnl.AddView(lbl1, 125dip, height * (i - 1)";
Debug.ShouldStop(1);
_pnl.runVoidMethod ("AddView",(Object)((_lbl1.getObject())),(Object)(testresponsive.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 125)))),(Object)(RemoteObject.solve(new RemoteObject[] {testresponsive._height,(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),RemoteObject.createImmutable(1)}, "-",1, 1))}, "*",0, 1)),(Object)(testresponsive.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 120)))),(Object)(testresponsive._height));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 35;BA.debugLine="pnl.Height = lstChecks.Size * height";
Debug.ShouldStop(4);
_pnl.runMethod(true,"setHeight",RemoteObject.solve(new RemoteObject[] {testresponsive.mostCurrent._lstchecks.runMethod(true,"getSize"),testresponsive._height}, "*",0, 1));
 BA.debugLineNum = 36;BA.debugLine="Activity.AddMenuItem(\"Display checked\", \"mnuCh";
Debug.ShouldStop(8);
testresponsive.mostCurrent._activity.runVoidMethod ("AddMenuItem",(Object)(BA.ObjectToString("Display checked")),(Object)(RemoteObject.createImmutable("mnuChecked")));
 BA.debugLineNum = 37;BA.debugLine="End Sub";
Debug.ShouldStop(16);
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
 //BA.debugLineNum = 10;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 11;BA.debugLine="Dim ScrollView1 As ScrollView";
testresponsive.mostCurrent._scrollview1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ScrollViewWrapper");
 //BA.debugLineNum = 12;BA.debugLine="Dim lstChecks As List";
testresponsive.mostCurrent._lstchecks = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 13;BA.debugLine="Dim height As Int";
testresponsive._height = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 14;BA.debugLine="height = 50dip";
testresponsive._height = testresponsive.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)));
 //BA.debugLineNum = 15;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _mnuchecked_click() throws Exception{
try {
		Debug.PushSubsStack("mnuChecked_Click (testresponsive) ","testresponsive",4,testresponsive.mostCurrent.activityBA,testresponsive.mostCurrent,39);
if (RapidSub.canDelegate("mnuchecked_click")) return testresponsive.remoteMe.runUserSub(false, "testresponsive","mnuchecked_click");
RemoteObject _sb = RemoteObject.declareNull("anywheresoftware.b4a.keywords.StringBuilderWrapper");
int _i = 0;
RemoteObject _chk = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
 BA.debugLineNum = 39;BA.debugLine="Sub mnuChecked_Click";
Debug.ShouldStop(64);
 BA.debugLineNum = 40;BA.debugLine="Dim sb As StringBuilder";
Debug.ShouldStop(128);
_sb = RemoteObject.createNew ("anywheresoftware.b4a.keywords.StringBuilderWrapper");Debug.locals.put("sb", _sb);
 BA.debugLineNum = 41;BA.debugLine="sb.Initialize";
Debug.ShouldStop(256);
_sb.runVoidMethod ("Initialize");
 BA.debugLineNum = 42;BA.debugLine="For i = 0 To lstChecks.Size - 1";
Debug.ShouldStop(512);
{
final int step3 = 1;
final int limit3 = RemoteObject.solve(new RemoteObject[] {testresponsive.mostCurrent._lstchecks.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
for (_i = 0 ; (step3 > 0 && _i <= limit3) || (step3 < 0 && _i >= limit3); _i = ((int)(0 + _i + step3)) ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 43;BA.debugLine="Dim chk As CheckBox";
Debug.ShouldStop(1024);
_chk = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");Debug.locals.put("chk", _chk);
 BA.debugLineNum = 44;BA.debugLine="chk = lstChecks.Get(i)";
Debug.ShouldStop(2048);
_chk.setObject(testresponsive.mostCurrent._lstchecks.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))));
 BA.debugLineNum = 45;BA.debugLine="If chk.Checked Then";
Debug.ShouldStop(4096);
if (_chk.runMethod(true,"getChecked").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 46;BA.debugLine="sb.Append(i).Append(CRLF)";
Debug.ShouldStop(8192);
_sb.runMethod(false,"Append",(Object)(BA.NumberToString(_i))).runVoidMethod ("Append",(Object)(testresponsive.mostCurrent.__c.getField(true,"CRLF")));
 };
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 49;BA.debugLine="Log(sb)";
Debug.ShouldStop(65536);
testresponsive.mostCurrent.__c.runVoidMethod ("Log",(Object)(BA.ObjectToString(_sb)));
 BA.debugLineNum = 50;BA.debugLine="Msgbox(sb.ToString, \"Checked indices\")";
Debug.ShouldStop(131072);
testresponsive.mostCurrent.__c.runVoidMethodAndSync ("Msgbox",(Object)(_sb.runMethod(true,"ToString")),(Object)(RemoteObject.createImmutable("Checked indices")),testresponsive.mostCurrent.activityBA);
 BA.debugLineNum = 51;BA.debugLine="End Sub";
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
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 8;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}