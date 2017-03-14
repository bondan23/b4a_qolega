package com.qolega.qolegapp;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class test4_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (test4) ","test4",8,test4.mostCurrent.activityBA,test4.mostCurrent,17);
if (RapidSub.canDelegate("activity_create")) return test4.remoteMe.runUserSub(false, "test4","activity_create", _firsttime);
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 17;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(65536);
 BA.debugLineNum = 20;BA.debugLine="Activity.AddMenuItem3(\"SearchItem\", \"SearchItem\",";
Debug.ShouldStop(524288);
test4.mostCurrent._activity.runVoidMethod ("AddMenuItem3",(Object)(BA.ObjectToString("SearchItem")),(Object)(BA.ObjectToString("SearchItem")),(Object)((test4.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(test4.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("search.png"))).getObject())),(Object)(test4.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 22;BA.debugLine="Activity.LoadLayout(\"referringLayout\")";
Debug.ShouldStop(2097152);
test4.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("referringLayout")),test4.mostCurrent.activityBA);
 BA.debugLineNum = 24;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
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
		Debug.PushSubsStack("Activity_Pause (test4) ","test4",8,test4.mostCurrent.activityBA,test4.mostCurrent,34);
if (RapidSub.canDelegate("activity_pause")) return test4.remoteMe.runUserSub(false, "test4","activity_pause", _userclosed);
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 34;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(2);
 BA.debugLineNum = 36;BA.debugLine="End Sub";
Debug.ShouldStop(8);
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
		Debug.PushSubsStack("Activity_Resume (test4) ","test4",8,test4.mostCurrent.activityBA,test4.mostCurrent,30);
if (RapidSub.canDelegate("activity_resume")) return test4.remoteMe.runUserSub(false, "test4","activity_resume");
 BA.debugLineNum = 30;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 32;BA.debugLine="End Sub";
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
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 15;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _searchitem_click() throws Exception{
try {
		Debug.PushSubsStack("SearchItem_Click (test4) ","test4",8,test4.mostCurrent.activityBA,test4.mostCurrent,26);
if (RapidSub.canDelegate("searchitem_click")) return test4.remoteMe.runUserSub(false, "test4","searchitem_click");
 BA.debugLineNum = 26;BA.debugLine="Sub SearchItem_Click";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 27;BA.debugLine="Msgbox(\"Search Box Clicked\",\"Search\")";
Debug.ShouldStop(67108864);
test4.mostCurrent.__c.runVoidMethodAndSync ("Msgbox",(Object)(BA.ObjectToString("Search Box Clicked")),(Object)(RemoteObject.createImmutable("Search")),test4.mostCurrent.activityBA);
 BA.debugLineNum = 28;BA.debugLine="End Sub";
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
}