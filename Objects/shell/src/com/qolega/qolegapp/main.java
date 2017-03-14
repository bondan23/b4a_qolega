
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

public class main implements IRemote{
	public static main mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public main() {
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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("main"), "com.qolega.qolegapp.main");
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
		pcBA = new PCBA(this, main.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _backgroundpanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _splashtimer = RemoteObject.declareNull("anywheresoftware.b4a.objects.Timer");
public static RemoteObject _panel1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _emailfield = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _passwordfield = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _qauth = RemoteObject.declareNull("com.qolega.qolegapp.auth");
public static RemoteObject _wrapper = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _version = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static com.qolega.qolegapp.starter _starter = null;
public static com.qolega.qolegapp.referringlist _referringlist = null;
public static com.qolega.qolegapp.referringprogress _referringprogress = null;
public static com.qolega.qolegapp.testresponsive _testresponsive = null;
public static com.qolega.qolegapp.test3 _test3 = null;
public static com.qolega.qolegapp.test4 _test4 = null;
public static com.qolega.qolegapp.httputils2service _httputils2service = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",main.mostCurrent._activity,"BackgroundPanel",main.mostCurrent._backgroundpanel,"EmailField",main.mostCurrent._emailfield,"HttpUtils2Service",Debug.moduleToString(com.qolega.qolegapp.httputils2service.class),"Panel1",main.mostCurrent._panel1,"PasswordField",main.mostCurrent._passwordfield,"qAuth",main.mostCurrent._qauth,"ReferringList",Debug.moduleToString(com.qolega.qolegapp.referringlist.class),"ReferringProgress",Debug.moduleToString(com.qolega.qolegapp.referringprogress.class),"SplashTimer",main.mostCurrent._splashtimer,"Starter",Debug.moduleToString(com.qolega.qolegapp.starter.class),"Test3",Debug.moduleToString(com.qolega.qolegapp.test3.class),"Test4",Debug.moduleToString(com.qolega.qolegapp.test4.class),"TestResponsive",Debug.moduleToString(com.qolega.qolegapp.testresponsive.class),"Version",main.mostCurrent._version,"Wrapper",main.mostCurrent._wrapper};
}
}