
package com.qolega.qolegapp;

import java.io.IOException;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RDebug;
import anywheresoftware.b4a.pc.RemoteObject;
import anywheresoftware.b4a.pc.RDebug.IRemote;
import anywheresoftware.b4a.pc.Debug;
import anywheresoftware.b4a.pc.B4XTypes.B4XClass;
import anywheresoftware.b4a.pc.B4XTypes.DeviceClass;

public class referringprogress implements IRemote{
	public static referringprogress mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public referringprogress() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
	public static void main (String[] args) throws Exception {
		new RDebug(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]), args[3]);
		RDebug.INSTANCE.waitForTask();

	}
    static {
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("referringprogress"), "com.qolega.qolegapp.referringprogress");
	}

public boolean isSingleton() {
		return true;
	}
     public static RemoteObject getObject() {
		return myClass;
	 }

	public RemoteObject activityBA;
	public RemoteObject _activity;
    private PCBA pcBA;

	public PCBA create(Object[] args) throws ClassNotFoundException{
		processBA = (RemoteObject) args[1];
		activityBA = (RemoteObject) args[2];
		_activity = (RemoteObject) args[3];
        anywheresoftware.b4a.keywords.Common.Density = (Float)args[4];
        remoteMe = (RemoteObject) args[5];
		pcBA = new PCBA(this, referringprogress.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _userid = RemoteObject.createImmutable(0);
public static RemoteObject _scrollview = RemoteObject.declareNull("anywheresoftware.b4a.objects.ScrollViewWrapper");
public static RemoteObject _json = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
public static RemoteObject _su = RemoteObject.declareNull("anywheresoftware.b4a.objects.StringUtils");
public static RemoteObject _container = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _font = RemoteObject.declareNull("com.qolega.qolegapp.fonts");
public static RemoteObject _bar = RemoteObject.declareNull("anywheresoftware.b4a.objects.StdActionBar");
public static RemoteObject _detaillist = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
public static RemoteObject _showicon = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _closeicon = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _api = RemoteObject.declareNull("com.qolega.qolegapp.api");
public static com.qolega.qolegapp.main _main = null;
public static com.qolega.qolegapp.starter _starter = null;
public static com.qolega.qolegapp.referringlist _referringlist = null;
public static com.qolega.qolegapp.testresponsive _testresponsive = null;
public static com.qolega.qolegapp.test3 _test3 = null;
public static com.qolega.qolegapp.httputils2service _httputils2service = null;
public static com.qolega.qolegapp.test4 _test4 = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",referringprogress.mostCurrent._activity,"Api",Debug.moduleToString(com.qolega.qolegapp.api.class),"bar",referringprogress.mostCurrent._bar,"closeIcon",referringprogress.mostCurrent._closeicon,"Container",referringprogress.mostCurrent._container,"detailList",referringprogress.mostCurrent._detaillist,"font",referringprogress.mostCurrent._font,"HttpUtils2Service",Debug.moduleToString(com.qolega.qolegapp.httputils2service.class),"JSON",referringprogress.mostCurrent._json,"Main",Debug.moduleToString(com.qolega.qolegapp.main.class),"ReferringList",Debug.moduleToString(com.qolega.qolegapp.referringlist.class),"scrollView",referringprogress.mostCurrent._scrollview,"showIcon",referringprogress.mostCurrent._showicon,"Starter",Debug.moduleToString(com.qolega.qolegapp.starter.class),"su",referringprogress.mostCurrent._su,"Test3",Debug.moduleToString(com.qolega.qolegapp.test3.class),"Test4",Debug.moduleToString(com.qolega.qolegapp.test4.class),"TestResponsive",Debug.moduleToString(com.qolega.qolegapp.testresponsive.class),"userId",referringprogress._userid};
}
}