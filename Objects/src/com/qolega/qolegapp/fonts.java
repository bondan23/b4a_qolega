package com.qolega.qolegapp;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class fonts extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "com.qolega.qolegapp.fonts");
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

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.keywords.constants.TypefaceWrapper _semibold = null;
public anywheresoftware.b4a.keywords.constants.TypefaceWrapper _regular = null;
public anywheresoftware.b4a.keywords.constants.TypefaceWrapper _light = null;
public njdude.fontawesome.lib.fontawesome _fa = null;
public anywheresoftware.b4a.samples.httputils2.httputils2service _httputils2service = null;
public com.qolega.qolegapp.main _main = null;
public com.qolega.qolegapp.starter _starter = null;
public com.qolega.qolegapp.referringlist _referringlist = null;
public com.qolega.qolegapp.referringprogress _referringprogress = null;
public com.qolega.qolegapp.testresponsive _testresponsive = null;
public com.qolega.qolegapp.test3 _test3 = null;
public com.qolega.qolegapp.test4 _test4 = null;
public njdude.fontawesome.lib.fontawesome  _awesome() throws Exception{
 //BA.debugLineNum = 29;BA.debugLine="Public Sub awesome() As FontAwesome";
 //BA.debugLineNum = 30;BA.debugLine="Return FA";
if (true) return _fa;
 //BA.debugLineNum = 31;BA.debugLine="End Sub";
return null;
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 3;BA.debugLine="Dim semiBold As Typeface";
_semibold = new anywheresoftware.b4a.keywords.constants.TypefaceWrapper();
 //BA.debugLineNum = 4;BA.debugLine="Dim regular As Typeface";
_regular = new anywheresoftware.b4a.keywords.constants.TypefaceWrapper();
 //BA.debugLineNum = 5;BA.debugLine="Dim light As Typeface";
_light = new anywheresoftware.b4a.keywords.constants.TypefaceWrapper();
 //BA.debugLineNum = 6;BA.debugLine="Dim FA As FontAwesome";
_fa = new njdude.fontawesome.lib.fontawesome();
 //BA.debugLineNum = 7;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 10;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 11;BA.debugLine="semiBold = Typeface.LoadFromAssets(\"fonts/proxima";
_semibold.setObject((android.graphics.Typeface)(__c.Typeface.LoadFromAssets("fonts/proximanova-semibold.ttf")));
 //BA.debugLineNum = 12;BA.debugLine="regular = Typeface.LoadFromAssets(\"fonts/proximan";
_regular.setObject((android.graphics.Typeface)(__c.Typeface.LoadFromAssets("fonts/proximanova-regular.ttf")));
 //BA.debugLineNum = 13;BA.debugLine="light = Typeface.LoadFromAssets(\"fonts/proximanov";
_light.setObject((android.graphics.Typeface)(__c.Typeface.LoadFromAssets("fonts/proximanova-light.ttf")));
 //BA.debugLineNum = 14;BA.debugLine="FA.Initialize";
_fa._initialize(ba);
 //BA.debugLineNum = 15;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.keywords.constants.TypefaceWrapper  _proximanovalight() throws Exception{
 //BA.debugLineNum = 25;BA.debugLine="Public Sub proximanovaLight() As Typeface";
 //BA.debugLineNum = 26;BA.debugLine="Return light";
if (true) return _light;
 //BA.debugLineNum = 27;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.keywords.constants.TypefaceWrapper  _proximanovaregular() throws Exception{
 //BA.debugLineNum = 21;BA.debugLine="Public Sub proximanovaRegular() As Typeface";
 //BA.debugLineNum = 22;BA.debugLine="Return regular";
if (true) return _regular;
 //BA.debugLineNum = 23;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.keywords.constants.TypefaceWrapper  _proximanovasemibold() throws Exception{
 //BA.debugLineNum = 17;BA.debugLine="Public Sub proximanovaSemiBold() As Typeface";
 //BA.debugLineNum = 18;BA.debugLine="Return semiBold";
if (true) return _semibold;
 //BA.debugLineNum = 19;BA.debugLine="End Sub";
return null;
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
