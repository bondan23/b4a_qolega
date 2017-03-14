
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

public class referringlist implements IRemote{
	public static referringlist mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public referringlist() {
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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("referringlist"), "com.qolega.qolegapp.referringlist");
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
		pcBA = new PCBA(this, referringlist.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _scrollview = RemoteObject.declareNull("anywheresoftware.b4a.objects.ScrollViewWrapper");
public static RemoteObject _json = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
public static RemoteObject _su = RemoteObject.declareNull("anywheresoftware.b4a.objects.StringUtils");
public static RemoteObject _detaillist = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
public static RemoteObject _resultlist = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
public static RemoteObject _qauth = RemoteObject.declareNull("com.qolega.qolegapp.auth");
public static RemoteObject _font = RemoteObject.declareNull("com.qolega.qolegapp.fonts");
public static RemoteObject _loadmore = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _api = RemoteObject.declareNull("com.qolega.qolegapp.api");
public static RemoteObject _loadmoretop = RemoteObject.createImmutable(0);
public static com.qolega.qolegapp.main _main = null;
public static com.qolega.qolegapp.starter _starter = null;
public static com.qolega.qolegapp.referringprogress _referringprogress = null;
public static com.qolega.qolegapp.testresponsive _testresponsive = null;
public static com.qolega.qolegapp.test3 _test3 = null;
public static com.qolega.qolegapp.httputils2service _httputils2service = null;
public static com.qolega.qolegapp.test4 _test4 = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",referringlist.mostCurrent._activity,"Api",Debug.moduleToString(com.qolega.qolegapp.api.class),"detailList",referringlist.mostCurrent._detaillist,"font",referringlist.mostCurrent._font,"HttpUtils2Service",Debug.moduleToString(com.qolega.qolegapp.httputils2service.class),"JSON",referringlist.mostCurrent._json,"loadMore",referringlist.mostCurrent._loadmore,"loadMoreTop",referringlist._loadmoretop,"Main",Debug.moduleToString(com.qolega.qolegapp.main.class),"qAuth",referringlist.mostCurrent._qauth,"ReferringProgress",Debug.moduleToString(com.qolega.qolegapp.referringprogress.class),"resultList",referringlist.mostCurrent._resultlist,"scrollView",referringlist.mostCurrent._scrollview,"Starter",Debug.moduleToString(com.qolega.qolegapp.starter.class),"su",referringlist.mostCurrent._su,"Test3",Debug.moduleToString(com.qolega.qolegapp.test3.class),"Test4",Debug.moduleToString(com.qolega.qolegapp.test4.class),"TestResponsive",Debug.moduleToString(com.qolega.qolegapp.testresponsive.class)};
}
}