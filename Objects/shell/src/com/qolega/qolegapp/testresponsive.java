
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

public class testresponsive implements IRemote{
	public static testresponsive mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public testresponsive() {
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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("testresponsive"), "com.qolega.qolegapp.testresponsive");
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
		pcBA = new PCBA(this, testresponsive.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _scrollview1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ScrollViewWrapper");
public static RemoteObject _lstchecks = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
public static RemoteObject _height = RemoteObject.createImmutable(0);
public static com.qolega.qolegapp.main _main = null;
public static com.qolega.qolegapp.starter _starter = null;
public static com.qolega.qolegapp.referringlist _referringlist = null;
public static com.qolega.qolegapp.referringprogress _referringprogress = null;
public static com.qolega.qolegapp.test3 _test3 = null;
public static com.qolega.qolegapp.test4 _test4 = null;
public static com.qolega.qolegapp.httputils2service _httputils2service = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",testresponsive.mostCurrent._activity,"height",testresponsive._height,"HttpUtils2Service",Debug.moduleToString(com.qolega.qolegapp.httputils2service.class),"lstChecks",testresponsive.mostCurrent._lstchecks,"Main",Debug.moduleToString(com.qolega.qolegapp.main.class),"ReferringList",Debug.moduleToString(com.qolega.qolegapp.referringlist.class),"ReferringProgress",Debug.moduleToString(com.qolega.qolegapp.referringprogress.class),"ScrollView1",testresponsive.mostCurrent._scrollview1,"Starter",Debug.moduleToString(com.qolega.qolegapp.starter.class),"Test3",Debug.moduleToString(com.qolega.qolegapp.test3.class),"Test4",Debug.moduleToString(com.qolega.qolegapp.test4.class)};
}
}