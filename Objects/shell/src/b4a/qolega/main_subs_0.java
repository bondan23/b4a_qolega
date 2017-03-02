package b4a.qolega;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,29);
if (RapidSub.canDelegate("activity_create")) return main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);
RemoteObject _qolegalogo = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 29;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 37;BA.debugLine="SplashTimer.Initialize(\"SplashTimer\",3000)";
Debug.ShouldStop(16);
main._splashtimer.runVoidMethod ("Initialize",main.processBA,(Object)(BA.ObjectToString("SplashTimer")),(Object)(BA.numberCast(long.class, 3000)));
 BA.debugLineNum = 38;BA.debugLine="SplashTimer.Enabled = True";
Debug.ShouldStop(32);
main._splashtimer.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 40;BA.debugLine="Panel1.Initialize(\"Panel1\")";
Debug.ShouldStop(128);
main.mostCurrent._panel1.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("Panel1")));
 BA.debugLineNum = 41;BA.debugLine="Panel1.SetBackgroundImage(LoadBitmap(File.DirAsse";
Debug.ShouldStop(256);
main.mostCurrent._panel1.runVoidMethod ("SetBackgroundImage",(Object)((main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("7aa1c09d-5afb-40e9-8e79-0d3e5b17a8ea.png"))).getObject())));
 BA.debugLineNum = 42;BA.debugLine="Panel1.Visible=True";
Debug.ShouldStop(512);
main.mostCurrent._panel1.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 44;BA.debugLine="Dim QolegaLogo As ImageView";
Debug.ShouldStop(2048);
_qolegalogo = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");Debug.locals.put("QolegaLogo", _qolegalogo);
 BA.debugLineNum = 46;BA.debugLine="QolegaLogo.Initialize(\"QolegaLabel\")";
Debug.ShouldStop(8192);
_qolegalogo.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("QolegaLabel")));
 BA.debugLineNum = 47;BA.debugLine="QolegaLogo.bitmap = LoadBitmap(File.DirAssets,\"lo";
Debug.ShouldStop(16384);
_qolegalogo.runMethod(false,"setBitmap",(main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("logo.png"))).getObject()));
 BA.debugLineNum = 48;BA.debugLine="Panel1.AddView(QolegaLogo, 0, 100%y/2, 300dip,";
Debug.ShouldStop(32768);
main.mostCurrent._panel1.runVoidMethod ("AddView",(Object)((_qolegalogo.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA),RemoteObject.createImmutable(2)}, "/",0, 0))),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 300)))),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))));
 BA.debugLineNum = 50;BA.debugLine="Activity.LoadLayout(\"loginLayout\")";
Debug.ShouldStop(131072);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("loginLayout")),main.mostCurrent.activityBA);
 BA.debugLineNum = 51;BA.debugLine="Activity.AddView(Panel1,0,0,Activity.Width,Activi";
Debug.ShouldStop(262144);
main.mostCurrent._activity.runVoidMethod ("AddView",(Object)((main.mostCurrent._panel1.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent._activity.runMethod(true,"getWidth")),(Object)(main.mostCurrent._activity.runMethod(true,"getHeight")));
 BA.debugLineNum = 53;BA.debugLine="End Sub";
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
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,59);
if (RapidSub.canDelegate("activity_pause")) return main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 59;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 61;BA.debugLine="End Sub";
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
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,55);
if (RapidSub.canDelegate("activity_resume")) return main.remoteMe.runUserSub(false, "main","activity_resume");
 BA.debugLineNum = 55;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 57;BA.debugLine="End Sub";
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
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 21;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 25;BA.debugLine="Private BackgroundPanel As Panel";
main.mostCurrent._backgroundpanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Dim Panel1 As Panel";
main.mostCurrent._panel1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 27;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _loginbtn_click() throws Exception{
try {
		Debug.PushSubsStack("LoginBtn_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,63);
if (RapidSub.canDelegate("loginbtn_click")) return main.remoteMe.runUserSub(false, "main","loginbtn_click");
 BA.debugLineNum = 63;BA.debugLine="Sub LoginBtn_Click";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 64;BA.debugLine="StartActivity(Test)";
Debug.ShouldStop(-2147483648);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.mostCurrent.activityBA,(Object)((main.mostCurrent._test.getObject())));
 BA.debugLineNum = 65;BA.debugLine="End Sub";
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

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
starter_subs_0._process_globals();
referringlist_subs_0._process_globals();
test_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("b4a.qolega.main");
starter.myClass = BA.getDeviceClass ("b4a.qolega.starter");
referringlist.myClass = BA.getDeviceClass ("b4a.qolega.referringlist");
test.myClass = BA.getDeviceClass ("b4a.qolega.test");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 18;BA.debugLine="Dim SplashTimer As Timer";
main._splashtimer = RemoteObject.createNew ("anywheresoftware.b4a.objects.Timer");
 //BA.debugLineNum = 19;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _splashtimer_tick() throws Exception{
try {
		Debug.PushSubsStack("SplashTimer_Tick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,67);
if (RapidSub.canDelegate("splashtimer_tick")) return main.remoteMe.runUserSub(false, "main","splashtimer_tick");
 BA.debugLineNum = 67;BA.debugLine="Sub SplashTimer_Tick";
Debug.ShouldStop(4);
 BA.debugLineNum = 68;BA.debugLine="Panel1.RemoveView()";
Debug.ShouldStop(8);
main.mostCurrent._panel1.runVoidMethod ("RemoveView");
 BA.debugLineNum = 69;BA.debugLine="SplashTimer.Enabled = False";
Debug.ShouldStop(16);
main._splashtimer.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 70;BA.debugLine="End Sub";
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
}