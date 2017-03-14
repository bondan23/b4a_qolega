package com.qolega.qolegapp;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class test3_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (test3) ","test3",5,test3.mostCurrent.activityBA,test3.mostCurrent,17);
if (RapidSub.canDelegate("activity_create")) return test3.remoteMe.runUserSub(false, "test3","activity_create", _firsttime);
RemoteObject _parser = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _root = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _root2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 17;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(65536);
 BA.debugLineNum = 20;BA.debugLine="Activity.AddMenuItem3(\"SearchItem\", \"SearchItem\",";
Debug.ShouldStop(524288);
test3.mostCurrent._activity.runVoidMethod ("AddMenuItem3",(Object)(BA.ObjectToString("SearchItem")),(Object)(BA.ObjectToString("SearchItem")),(Object)((test3.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(test3.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("search.png"))).getObject())),(Object)(test3.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 22;BA.debugLine="Dim parser As JSONParser";
Debug.ShouldStop(2097152);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 23;BA.debugLine="parser.Initialize(File.ReadString(File.DirAssets,";
Debug.ShouldStop(4194304);
_parser.runVoidMethod ("Initialize",(Object)(test3.mostCurrent.__c.getField(false,"File").runMethod(true,"ReadString",(Object)(test3.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("status_reference.json")))));
 BA.debugLineNum = 24;BA.debugLine="Dim root As List = parser.NextArray";
Debug.ShouldStop(8388608);
_root = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_root = _parser.runMethod(false,"NextArray");Debug.locals.put("root", _root);Debug.locals.put("root", _root);
 BA.debugLineNum = 25;BA.debugLine="Dim root2 As Map = root.Get(0)";
Debug.ShouldStop(16777216);
_root2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_root2.setObject(_root.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))));Debug.locals.put("root2", _root2);
 BA.debugLineNum = 27;BA.debugLine="Log(root2.Get(\"id\"))";
Debug.ShouldStop(67108864);
test3.mostCurrent.__c.runVoidMethod ("Log",(Object)(BA.ObjectToString(_root2.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("id")))))));
 BA.debugLineNum = 29;BA.debugLine="End Sub";
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
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (test3) ","test3",5,test3.mostCurrent.activityBA,test3.mostCurrent,39);
if (RapidSub.canDelegate("activity_pause")) return test3.remoteMe.runUserSub(false, "test3","activity_pause", _userclosed);
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 39;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(64);
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
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (test3) ","test3",5,test3.mostCurrent.activityBA,test3.mostCurrent,35);
if (RapidSub.canDelegate("activity_resume")) return test3.remoteMe.runUserSub(false, "test3","activity_resume");
 BA.debugLineNum = 35;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(4);
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
		Debug.PushSubsStack("SearchItem_Click (test3) ","test3",5,test3.mostCurrent.activityBA,test3.mostCurrent,31);
if (RapidSub.canDelegate("searchitem_click")) return test3.remoteMe.runUserSub(false, "test3","searchitem_click");
 BA.debugLineNum = 31;BA.debugLine="Sub SearchItem_Click";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 32;BA.debugLine="Msgbox(\"Search Box Clicked\",\"Search\")";
Debug.ShouldStop(-2147483648);
test3.mostCurrent.__c.runVoidMethodAndSync ("Msgbox",(Object)(BA.ObjectToString("Search Box Clicked")),(Object)(RemoteObject.createImmutable("Search")),test3.mostCurrent.activityBA);
 BA.debugLineNum = 33;BA.debugLine="End Sub";
Debug.ShouldStop(1);
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