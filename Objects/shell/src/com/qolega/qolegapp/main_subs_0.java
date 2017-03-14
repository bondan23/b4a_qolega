package com.qolega.qolegapp;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,33);
if (RapidSub.canDelegate("activity_create")) return main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 33;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(1);
 BA.debugLineNum = 34;BA.debugLine="qAuth.Initialize(Activity)";
Debug.ShouldStop(2);
main.mostCurrent._qauth.runClassMethod (com.qolega.qolegapp.auth.class, "_initialize",main.mostCurrent.activityBA,(Object)(main.mostCurrent._activity));
 BA.debugLineNum = 55;BA.debugLine="qAuth.CheckLoginSession";
Debug.ShouldStop(4194304);
main.mostCurrent._qauth.runClassMethod (com.qolega.qolegapp.auth.class, "_checkloginsession");
 BA.debugLineNum = 58;BA.debugLine="Activity.LoadLayout(\"loginLayout\")";
Debug.ShouldStop(33554432);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("loginLayout")),main.mostCurrent.activityBA);
 BA.debugLineNum = 60;BA.debugLine="Wrapper.Top = (100%y - Wrapper.Height ) / 2";
Debug.ShouldStop(134217728);
main.mostCurrent._wrapper.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA),main.mostCurrent._wrapper.runMethod(true,"getHeight")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 62;BA.debugLine="Version.Text = \"V \"&Application.VersionName";
Debug.ShouldStop(536870912);
main.mostCurrent._version.runMethod(true,"setText",(RemoteObject.concat(RemoteObject.createImmutable("V "),main.mostCurrent.__c.getField(false,"Application").runMethod(true,"getVersionName"))));
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
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,71);
if (RapidSub.canDelegate("activity_pause")) return main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 71;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(64);
 BA.debugLineNum = 73;BA.debugLine="End Sub";
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
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,67);
if (RapidSub.canDelegate("activity_resume")) return main.remoteMe.runUserSub(false, "main","activity_resume");
 BA.debugLineNum = 67;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(4);
 BA.debugLineNum = 69;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 20;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 23;BA.debugLine="Private BackgroundPanel As Panel";
main.mostCurrent._backgroundpanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private SplashTimer As Timer";
main.mostCurrent._splashtimer = RemoteObject.createNew ("anywheresoftware.b4a.objects.Timer");
 //BA.debugLineNum = 25;BA.debugLine="Private Panel1 As Panel";
main.mostCurrent._panel1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Private EmailField As EditText";
main.mostCurrent._emailfield = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Private PasswordField As EditText";
main.mostCurrent._passwordfield = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Dim qAuth As Auth";
main.mostCurrent._qauth = RemoteObject.createNew ("com.qolega.qolegapp.auth");
 //BA.debugLineNum = 29;BA.debugLine="Private Wrapper As Panel";
main.mostCurrent._wrapper = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 30;BA.debugLine="Private Version As Label";
main.mostCurrent._version = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 31;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _loginbtn_click() throws Exception{
try {
		Debug.PushSubsStack("LoginBtn_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,96);
if (RapidSub.canDelegate("loginbtn_click")) return main.remoteMe.runUserSub(false, "main","loginbtn_click");
 BA.debugLineNum = 96;BA.debugLine="Sub LoginBtn_Click";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 98;BA.debugLine="If EmailField.Text = \"\" Then";
Debug.ShouldStop(2);
if (RemoteObject.solveBoolean("=",main.mostCurrent._emailfield.runMethod(true,"getText"),BA.ObjectToString(""))) { 
 BA.debugLineNum = 99;BA.debugLine="ToastMessageShow(\"Email Field is Required\",False";
Debug.ShouldStop(4);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToString("Email Field is Required")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 }else 
{ BA.debugLineNum = 100;BA.debugLine="Else If PasswordField.Text = \"\" Then";
Debug.ShouldStop(8);
if (RemoteObject.solveBoolean("=",main.mostCurrent._passwordfield.runMethod(true,"getText"),BA.ObjectToString(""))) { 
 BA.debugLineNum = 101;BA.debugLine="ToastMessageShow(\"Password Field is Required\",Fa";
Debug.ShouldStop(16);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToString("Password Field is Required")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 }else {
 BA.debugLineNum = 103;BA.debugLine="qAuth.Login(EmailField,PasswordField)";
Debug.ShouldStop(64);
main.mostCurrent._qauth.runClassMethod (com.qolega.qolegapp.auth.class, "_login",(Object)(main.mostCurrent._emailfield),(Object)(main.mostCurrent._passwordfield));
 }};
 BA.debugLineNum = 105;BA.debugLine="End Sub";
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

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
starter_subs_0._process_globals();
referringlist_subs_0._process_globals();
referringprogress_subs_0._process_globals();
testresponsive_subs_0._process_globals();
test3_subs_0._process_globals();
httputils2service_subs_0._process_globals();
test4_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("com.qolega.qolegapp.main");
starter.myClass = BA.getDeviceClass ("com.qolega.qolegapp.starter");
referringlist.myClass = BA.getDeviceClass ("com.qolega.qolegapp.referringlist");
referringprogress.myClass = BA.getDeviceClass ("com.qolega.qolegapp.referringprogress");
testresponsive.myClass = BA.getDeviceClass ("com.qolega.qolegapp.testresponsive");
test3.myClass = BA.getDeviceClass ("com.qolega.qolegapp.test3");
auth.myClass = BA.getDeviceClass ("com.qolega.qolegapp.auth");
fonts.myClass = BA.getDeviceClass ("com.qolega.qolegapp.fonts");
httpjob.myClass = BA.getDeviceClass ("com.qolega.qolegapp.httpjob");
httputils2service.myClass = BA.getDeviceClass ("com.qolega.qolegapp.httputils2service");
api.myClass = BA.getDeviceClass ("com.qolega.qolegapp.api");
test4.myClass = BA.getDeviceClass ("com.qolega.qolegapp.test4");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 18;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _showupdatedialog() throws Exception{
try {
		Debug.PushSubsStack("showUpdateDialog (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,75);
if (RapidSub.canDelegate("showupdatedialog")) return main.remoteMe.runUserSub(false, "main","showupdatedialog");
RemoteObject _i = RemoteObject.createImmutable(0);
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.phone.Phone.PhoneIntents");
 BA.debugLineNum = 75;BA.debugLine="Sub showUpdateDialog";
Debug.ShouldStop(1024);
 BA.debugLineNum = 77;BA.debugLine="Dim i As Int";
Debug.ShouldStop(4096);
_i = RemoteObject.createImmutable(0);Debug.locals.put("i", _i);
 BA.debugLineNum = 78;BA.debugLine="i = Msgbox2(\"There Was a New Version of This App,";
Debug.ShouldStop(8192);
_i = main.mostCurrent.__c.runMethodAndSync(true,"Msgbox2",(Object)(BA.ObjectToString("There Was a New Version of This App, Update to Continue")),(Object)(BA.ObjectToString("New Update Release")),(Object)(BA.ObjectToString("Update")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("Cancel")),(Object)((main.mostCurrent.__c.getField(false,"Null"))),main.mostCurrent.activityBA);Debug.locals.put("i", _i);
 BA.debugLineNum = 80;BA.debugLine="Select i";
Debug.ShouldStop(32768);
switch (BA.switchObjectToInt(_i,main.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE"),main.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"CANCEL"),main.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"NEGATIVE"))) {
case 0: {
 BA.debugLineNum = 82;BA.debugLine="Dim p As PhoneIntents";
Debug.ShouldStop(131072);
_p = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone.PhoneIntents");Debug.locals.put("p", _p);
 BA.debugLineNum = 83;BA.debugLine="StartActivity(p.OpenBrowser(\"http://qerja.com\"))";
Debug.ShouldStop(262144);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.mostCurrent.activityBA,(Object)((_p.runMethod(false,"OpenBrowser",(Object)(RemoteObject.createImmutable("http://qerja.com"))))));
 BA.debugLineNum = 84;BA.debugLine="ExitApplication";
Debug.ShouldStop(524288);
main.mostCurrent.__c.runVoidMethod ("ExitApplication");
 BA.debugLineNum = 85;BA.debugLine="Activity.Finish";
Debug.ShouldStop(1048576);
main.mostCurrent._activity.runVoidMethod ("Finish");
 break; }
case 1: {
 BA.debugLineNum = 87;BA.debugLine="Activity.Finish";
Debug.ShouldStop(4194304);
main.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 88;BA.debugLine="ExitApplication";
Debug.ShouldStop(8388608);
main.mostCurrent.__c.runVoidMethod ("ExitApplication");
 break; }
case 2: {
 BA.debugLineNum = 90;BA.debugLine="Activity.Finish";
Debug.ShouldStop(33554432);
main.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 91;BA.debugLine="ExitApplication";
Debug.ShouldStop(67108864);
main.mostCurrent.__c.runVoidMethod ("ExitApplication");
 break; }
}
;
 BA.debugLineNum = 94;BA.debugLine="End Sub";
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
}