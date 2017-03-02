package b4a.qolega;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class referringlist_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (referringlist) ","referringlist",2,referringlist.mostCurrent.activityBA,referringlist.mostCurrent,17);
if (RapidSub.canDelegate("activity_create")) return referringlist.remoteMe.runUserSub(false, "referringlist","activity_create", _firsttime);
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 17;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(65536);
 BA.debugLineNum = 20;BA.debugLine="Activity.AddMenuItem3(\"SearchItem\", \"SearchItem\",";
Debug.ShouldStop(524288);
referringlist.mostCurrent._activity.runVoidMethod ("AddMenuItem3",(Object)(BA.ObjectToString("SearchItem")),(Object)(BA.ObjectToString("SearchItem")),(Object)((referringlist.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(referringlist.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("search.png"))).getObject())),(Object)(referringlist.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 22;BA.debugLine="Activity.LoadLayout(\"referringLayout\")";
Debug.ShouldStop(2097152);
referringlist.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("referringLayout")),referringlist.mostCurrent.activityBA);
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
		Debug.PushSubsStack("Activity_Pause (referringlist) ","referringlist",2,referringlist.mostCurrent.activityBA,referringlist.mostCurrent,34);
if (RapidSub.canDelegate("activity_pause")) return referringlist.remoteMe.runUserSub(false, "referringlist","activity_pause", _userclosed);
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
		Debug.PushSubsStack("Activity_Resume (referringlist) ","referringlist",2,referringlist.mostCurrent.activityBA,referringlist.mostCurrent,30);
if (RapidSub.canDelegate("activity_resume")) return referringlist.remoteMe.runUserSub(false, "referringlist","activity_resume");
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
		Debug.PushSubsStack("SearchItem_Click (referringlist) ","referringlist",2,referringlist.mostCurrent.activityBA,referringlist.mostCurrent,26);
if (RapidSub.canDelegate("searchitem_click")) return referringlist.remoteMe.runUserSub(false, "referringlist","searchitem_click");
 BA.debugLineNum = 26;BA.debugLine="Sub SearchItem_Click";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 27;BA.debugLine="Msgbox(\"Search Box Clicked\",\"Search\")";
Debug.ShouldStop(67108864);
referringlist.mostCurrent.__c.runVoidMethodAndSync ("Msgbox",(Object)(BA.ObjectToString("Search Box Clicked")),(Object)(RemoteObject.createImmutable("Search")),referringlist.mostCurrent.activityBA);
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