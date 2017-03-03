package b4a.qolega;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class testresponsive_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (testresponsive) ","testresponsive",4,testresponsive.mostCurrent.activityBA,testresponsive.mostCurrent,22);
if (RapidSub.canDelegate("activity_create")) return testresponsive.remoteMe.runUserSub(false, "testresponsive","activity_create", _firsttime);
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 22;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 25;BA.debugLine="Activity.AddMenuItem3(\"SearchItem\", \"SearchItem\",";
Debug.ShouldStop(16777216);
testresponsive.mostCurrent._activity.runVoidMethod ("AddMenuItem3",(Object)(BA.ObjectToString("SearchItem")),(Object)(BA.ObjectToString("SearchItem")),(Object)((testresponsive.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(testresponsive.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("search.png"))).getObject())),(Object)(testresponsive.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 26;BA.debugLine="scrollView.Initialize(Activity.Height)";
Debug.ShouldStop(33554432);
testresponsive.mostCurrent._scrollview.runVoidMethod ("Initialize",testresponsive.mostCurrent.activityBA,(Object)(testresponsive.mostCurrent._activity.runMethod(true,"getHeight")));
 BA.debugLineNum = 27;BA.debugLine="scrollView.Color = Colors.RGB(219,219,219)";
Debug.ShouldStop(67108864);
testresponsive.mostCurrent._scrollview.runVoidMethod ("setColor",testresponsive.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 219)),(Object)(BA.numberCast(int.class, 219)),(Object)(BA.numberCast(int.class, 219))));
 BA.debugLineNum = 28;BA.debugLine="Activity.AddView(scrollView,0,0,100%x,100%y)";
Debug.ShouldStop(134217728);
testresponsive.mostCurrent._activity.runVoidMethod ("AddView",(Object)((testresponsive.mostCurrent._scrollview.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(testresponsive.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),testresponsive.mostCurrent.activityBA)),(Object)(testresponsive.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),testresponsive.mostCurrent.activityBA)));
 BA.debugLineNum = 29;BA.debugLine="LoopView";
Debug.ShouldStop(268435456);
_loopview();
 BA.debugLineNum = 30;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
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
		Debug.PushSubsStack("Activity_Pause (testresponsive) ","testresponsive",4,testresponsive.mostCurrent.activityBA,testresponsive.mostCurrent,45);
if (RapidSub.canDelegate("activity_pause")) return testresponsive.remoteMe.runUserSub(false, "testresponsive","activity_pause", _userclosed);
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 45;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(4096);
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
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (testresponsive) ","testresponsive",4,testresponsive.mostCurrent.activityBA,testresponsive.mostCurrent,41);
if (RapidSub.canDelegate("activity_resume")) return testresponsive.remoteMe.runUserSub(false, "testresponsive","activity_resume");
 BA.debugLineNum = 41;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(256);
 BA.debugLineNum = 43;BA.debugLine="End Sub";
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
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 15;BA.debugLine="Dim scrollView As ScrollView";
testresponsive.mostCurrent._scrollview = RemoteObject.createNew ("anywheresoftware.b4a.objects.ScrollViewWrapper");
 //BA.debugLineNum = 16;BA.debugLine="Dim JSON As JSONParser";
testresponsive.mostCurrent._json = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");
 //BA.debugLineNum = 17;BA.debugLine="Dim su As StringUtils";
testresponsive.mostCurrent._su = RemoteObject.createNew ("anywheresoftware.b4a.objects.StringUtils");
 //BA.debugLineNum = 18;BA.debugLine="Private FirstContainer As Panel";
testresponsive.mostCurrent._firstcontainer = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private Label1 As Label";
testresponsive.mostCurrent._label1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 20;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _loopview() throws Exception{
try {
		Debug.PushSubsStack("LoopView (testresponsive) ","testresponsive",4,testresponsive.mostCurrent.activityBA,testresponsive.mostCurrent,32);
if (RapidSub.canDelegate("loopview")) return testresponsive.remoteMe.runUserSub(false, "testresponsive","loopview");
RemoteObject _container = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
 BA.debugLineNum = 32;BA.debugLine="Sub LoopView";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 33;BA.debugLine="Dim Container As Panel";
Debug.ShouldStop(1);
_container = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("Container", _container);
 BA.debugLineNum = 35;BA.debugLine="Container = scrollView.Panel";
Debug.ShouldStop(4);
_container = testresponsive.mostCurrent._scrollview.runMethod(false,"getPanel");Debug.locals.put("Container", _container);
 BA.debugLineNum = 36;BA.debugLine="Container.LoadLayout(\"testResponsive\")";
Debug.ShouldStop(8);
_container.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("testResponsive")),testresponsive.mostCurrent.activityBA);
 BA.debugLineNum = 37;BA.debugLine="Container.Height = 2000";
Debug.ShouldStop(16);
_container.runMethod(true,"setHeight",BA.numberCast(int.class, 2000));
 BA.debugLineNum = 39;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}