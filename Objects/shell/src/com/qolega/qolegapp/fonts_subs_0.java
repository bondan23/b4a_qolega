package com.qolega.qolegapp;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class fonts_subs_0 {


public static RemoteObject  _awesome(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("awesome (fonts) ","fonts",7,__ref.getField(false, "ba"),__ref,29);
if (RapidSub.canDelegate("awesome")) return __ref.runUserSub(false, "fonts","awesome", __ref);
 BA.debugLineNum = 29;BA.debugLine="Public Sub awesome() As FontAwesome";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 30;BA.debugLine="Return FA";
Debug.ShouldStop(536870912);
Debug.CheckDeviceExceptions();if (true) return __ref.getField(false,"_fa");
 BA.debugLineNum = 31;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _class_globals(RemoteObject __ref) throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 3;BA.debugLine="Dim semiBold As Typeface";
fonts._semibold = RemoteObject.createNew ("anywheresoftware.b4a.keywords.constants.TypefaceWrapper");__ref.setField("_semibold",fonts._semibold);
 //BA.debugLineNum = 4;BA.debugLine="Dim regular As Typeface";
fonts._regular = RemoteObject.createNew ("anywheresoftware.b4a.keywords.constants.TypefaceWrapper");__ref.setField("_regular",fonts._regular);
 //BA.debugLineNum = 5;BA.debugLine="Dim light As Typeface";
fonts._light = RemoteObject.createNew ("anywheresoftware.b4a.keywords.constants.TypefaceWrapper");__ref.setField("_light",fonts._light);
 //BA.debugLineNum = 6;BA.debugLine="Dim FA As FontAwesome";
fonts._fa = RemoteObject.createNew ("njdude.fontawesome.lib.fontawesome");__ref.setField("_fa",fonts._fa);
 //BA.debugLineNum = 7;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _initialize(RemoteObject __ref,RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("Initialize (fonts) ","fonts",7,__ref.getField(false, "ba"),__ref,10);
if (RapidSub.canDelegate("initialize")) return __ref.runUserSub(false, "fonts","initialize", __ref, _ba);
__ref.runVoidMethodAndSync("innerInitializeHelper", _ba);
Debug.locals.put("ba", _ba);
 BA.debugLineNum = 10;BA.debugLine="Public Sub Initialize";
Debug.ShouldStop(512);
 BA.debugLineNum = 11;BA.debugLine="semiBold = Typeface.LoadFromAssets(\"fonts/proxima";
Debug.ShouldStop(1024);
__ref.getField(false,"_semibold").setObject (fonts.__c.getField(false,"Typeface").runMethod(false,"LoadFromAssets",(Object)(RemoteObject.createImmutable("fonts/proximanova-semibold.ttf"))));
 BA.debugLineNum = 12;BA.debugLine="regular = Typeface.LoadFromAssets(\"fonts/proximan";
Debug.ShouldStop(2048);
__ref.getField(false,"_regular").setObject (fonts.__c.getField(false,"Typeface").runMethod(false,"LoadFromAssets",(Object)(RemoteObject.createImmutable("fonts/proximanova-regular.ttf"))));
 BA.debugLineNum = 13;BA.debugLine="light = Typeface.LoadFromAssets(\"fonts/proximanov";
Debug.ShouldStop(4096);
__ref.getField(false,"_light").setObject (fonts.__c.getField(false,"Typeface").runMethod(false,"LoadFromAssets",(Object)(RemoteObject.createImmutable("fonts/proximanova-light.ttf"))));
 BA.debugLineNum = 14;BA.debugLine="FA.Initialize";
Debug.ShouldStop(8192);
__ref.getField(false,"_fa").runVoidMethod ("_initialize",__ref.getField(false, "ba"));
 BA.debugLineNum = 15;BA.debugLine="End Sub";
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
public static RemoteObject  _proximanovalight(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("proximanovaLight (fonts) ","fonts",7,__ref.getField(false, "ba"),__ref,25);
if (RapidSub.canDelegate("proximanovalight")) return __ref.runUserSub(false, "fonts","proximanovalight", __ref);
 BA.debugLineNum = 25;BA.debugLine="Public Sub proximanovaLight() As Typeface";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 26;BA.debugLine="Return light";
Debug.ShouldStop(33554432);
Debug.CheckDeviceExceptions();if (true) return __ref.getField(false,"_light");
 BA.debugLineNum = 27;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _proximanovaregular(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("proximanovaRegular (fonts) ","fonts",7,__ref.getField(false, "ba"),__ref,21);
if (RapidSub.canDelegate("proximanovaregular")) return __ref.runUserSub(false, "fonts","proximanovaregular", __ref);
 BA.debugLineNum = 21;BA.debugLine="Public Sub proximanovaRegular() As Typeface";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 22;BA.debugLine="Return regular";
Debug.ShouldStop(2097152);
Debug.CheckDeviceExceptions();if (true) return __ref.getField(false,"_regular");
 BA.debugLineNum = 23;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _proximanovasemibold(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("proximanovaSemiBold (fonts) ","fonts",7,__ref.getField(false, "ba"),__ref,17);
if (RapidSub.canDelegate("proximanovasemibold")) return __ref.runUserSub(false, "fonts","proximanovasemibold", __ref);
 BA.debugLineNum = 17;BA.debugLine="Public Sub proximanovaSemiBold() As Typeface";
Debug.ShouldStop(65536);
 BA.debugLineNum = 18;BA.debugLine="Return semiBold";
Debug.ShouldStop(131072);
Debug.CheckDeviceExceptions();if (true) return __ref.getField(false,"_semibold");
 BA.debugLineNum = 19;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
}