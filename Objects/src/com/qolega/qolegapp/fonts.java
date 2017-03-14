package com.qolega.qolegapp;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class fonts extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new anywheresoftware.b4a.ShellBA(_ba, this, htSubs, "com.qolega.qolegapp.fonts");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", com.qolega.qolegapp.fonts.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 
    public void  innerInitializeHelper(anywheresoftware.b4a.BA _ba) throws Exception{
        innerInitialize(_ba);
    }
    public Object callSub(String sub, Object sender, Object[] args) throws Exception {
        return BA.SubDelegator.SubNotFound;
    }
public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.keywords.constants.TypefaceWrapper _semibold = null;
public anywheresoftware.b4a.keywords.constants.TypefaceWrapper _regular = null;
public anywheresoftware.b4a.keywords.constants.TypefaceWrapper _light = null;
public njdude.fontawesome.lib.fontawesome _fa = null;
public com.qolega.qolegapp.main _main = null;
public com.qolega.qolegapp.starter _starter = null;
public com.qolega.qolegapp.referringlist _referringlist = null;
public com.qolega.qolegapp.referringprogress _referringprogress = null;
public com.qolega.qolegapp.testresponsive _testresponsive = null;
public com.qolega.qolegapp.test3 _test3 = null;
public com.qolega.qolegapp.httputils2service _httputils2service = null;
public com.qolega.qolegapp.test4 _test4 = null;
public String  _initialize(com.qolega.qolegapp.fonts __ref,anywheresoftware.b4a.BA _ba) throws Exception{
__ref = this;
innerInitialize(_ba);
RDebugUtils.currentModule="fonts";
if (Debug.shouldDelegate(ba, "initialize"))
	return (String) Debug.delegate(ba, "initialize", new Object[] {_ba});
RDebugUtils.currentLine=4194304;
 //BA.debugLineNum = 4194304;BA.debugLine="Public Sub Initialize";
RDebugUtils.currentLine=4194305;
 //BA.debugLineNum = 4194305;BA.debugLine="semiBold = Typeface.LoadFromAssets(\"fonts/proxima";
__ref._semibold.setObject((android.graphics.Typeface)(__c.Typeface.LoadFromAssets("fonts/proximanova-semibold.ttf")));
RDebugUtils.currentLine=4194306;
 //BA.debugLineNum = 4194306;BA.debugLine="regular = Typeface.LoadFromAssets(\"fonts/proximan";
__ref._regular.setObject((android.graphics.Typeface)(__c.Typeface.LoadFromAssets("fonts/proximanova-regular.ttf")));
RDebugUtils.currentLine=4194307;
 //BA.debugLineNum = 4194307;BA.debugLine="light = Typeface.LoadFromAssets(\"fonts/proximanov";
__ref._light.setObject((android.graphics.Typeface)(__c.Typeface.LoadFromAssets("fonts/proximanova-light.ttf")));
RDebugUtils.currentLine=4194308;
 //BA.debugLineNum = 4194308;BA.debugLine="FA.Initialize";
__ref._fa._initialize(ba);
RDebugUtils.currentLine=4194309;
 //BA.debugLineNum = 4194309;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.keywords.constants.TypefaceWrapper  _proximanovasemibold(com.qolega.qolegapp.fonts __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="fonts";
if (Debug.shouldDelegate(ba, "proximanovasemibold"))
	return (anywheresoftware.b4a.keywords.constants.TypefaceWrapper) Debug.delegate(ba, "proximanovasemibold", null);
RDebugUtils.currentLine=4259840;
 //BA.debugLineNum = 4259840;BA.debugLine="Public Sub proximanovaSemiBold() As Typeface";
RDebugUtils.currentLine=4259841;
 //BA.debugLineNum = 4259841;BA.debugLine="Return semiBold";
if (true) return __ref._semibold;
RDebugUtils.currentLine=4259842;
 //BA.debugLineNum = 4259842;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.keywords.constants.TypefaceWrapper  _proximanovaregular(com.qolega.qolegapp.fonts __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="fonts";
if (Debug.shouldDelegate(ba, "proximanovaregular"))
	return (anywheresoftware.b4a.keywords.constants.TypefaceWrapper) Debug.delegate(ba, "proximanovaregular", null);
RDebugUtils.currentLine=4325376;
 //BA.debugLineNum = 4325376;BA.debugLine="Public Sub proximanovaRegular() As Typeface";
RDebugUtils.currentLine=4325377;
 //BA.debugLineNum = 4325377;BA.debugLine="Return regular";
if (true) return __ref._regular;
RDebugUtils.currentLine=4325378;
 //BA.debugLineNum = 4325378;BA.debugLine="End Sub";
return null;
}
public njdude.fontawesome.lib.fontawesome  _awesome(com.qolega.qolegapp.fonts __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="fonts";
if (Debug.shouldDelegate(ba, "awesome"))
	return (njdude.fontawesome.lib.fontawesome) Debug.delegate(ba, "awesome", null);
RDebugUtils.currentLine=4456448;
 //BA.debugLineNum = 4456448;BA.debugLine="Public Sub awesome() As FontAwesome";
RDebugUtils.currentLine=4456449;
 //BA.debugLineNum = 4456449;BA.debugLine="Return FA";
if (true) return __ref._fa;
RDebugUtils.currentLine=4456450;
 //BA.debugLineNum = 4456450;BA.debugLine="End Sub";
return null;
}
public String  _class_globals(com.qolega.qolegapp.fonts __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="fonts";
RDebugUtils.currentLine=4128768;
 //BA.debugLineNum = 4128768;BA.debugLine="Sub Class_Globals";
RDebugUtils.currentLine=4128769;
 //BA.debugLineNum = 4128769;BA.debugLine="Dim semiBold As Typeface";
_semibold = new anywheresoftware.b4a.keywords.constants.TypefaceWrapper();
RDebugUtils.currentLine=4128770;
 //BA.debugLineNum = 4128770;BA.debugLine="Dim regular As Typeface";
_regular = new anywheresoftware.b4a.keywords.constants.TypefaceWrapper();
RDebugUtils.currentLine=4128771;
 //BA.debugLineNum = 4128771;BA.debugLine="Dim light As Typeface";
_light = new anywheresoftware.b4a.keywords.constants.TypefaceWrapper();
RDebugUtils.currentLine=4128772;
 //BA.debugLineNum = 4128772;BA.debugLine="Dim FA As FontAwesome";
_fa = new njdude.fontawesome.lib.fontawesome();
RDebugUtils.currentLine=4128773;
 //BA.debugLineNum = 4128773;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.keywords.constants.TypefaceWrapper  _proximanovalight(com.qolega.qolegapp.fonts __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="fonts";
if (Debug.shouldDelegate(ba, "proximanovalight"))
	return (anywheresoftware.b4a.keywords.constants.TypefaceWrapper) Debug.delegate(ba, "proximanovalight", null);
RDebugUtils.currentLine=4390912;
 //BA.debugLineNum = 4390912;BA.debugLine="Public Sub proximanovaLight() As Typeface";
RDebugUtils.currentLine=4390913;
 //BA.debugLineNum = 4390913;BA.debugLine="Return light";
if (true) return __ref._light;
RDebugUtils.currentLine=4390914;
 //BA.debugLineNum = 4390914;BA.debugLine="End Sub";
return null;
}
}