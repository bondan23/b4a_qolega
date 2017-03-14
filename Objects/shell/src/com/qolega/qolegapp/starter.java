
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

public class starter implements IRemote{
	public static starter mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public starter() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
public boolean isSingleton() {
		return true;
	}
    static {
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("starter"), "com.qolega.qolegapp.starter");
	}
     public static RemoteObject getObject() {
		return myClass;
	 }
	public RemoteObject _service;
    private PCBA pcBA;

	public PCBA create(Object[] args) throws ClassNotFoundException{
		processBA = (RemoteObject) args[1];
        _service = (RemoteObject) args[2];
        remoteMe = RemoteObject.declareNull("com.qolega.qolegapp.starter");
        anywheresoftware.b4a.keywords.Common.Density = (Float)args[3];
		pcBA = new PCBA(this, starter.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _ghttpversionjob = RemoteObject.declareNull("com.qolega.qolegapp.httpjob");
public static RemoteObject _updateapp = RemoteObject.declareNull("com.qolega.qolegapp.httpjob");
public static RemoteObject _getversion = RemoteObject.createImmutable("");
public static RemoteObject _downloadappurl = RemoteObject.createImmutable("");
public static com.qolega.qolegapp.main _main = null;
public static com.qolega.qolegapp.referringlist _referringlist = null;
public static com.qolega.qolegapp.referringprogress _referringprogress = null;
public static com.qolega.qolegapp.testresponsive _testresponsive = null;
public static com.qolega.qolegapp.test3 _test3 = null;
public static com.qolega.qolegapp.httputils2service _httputils2service = null;
public static com.qolega.qolegapp.test4 _test4 = null;
  public Object[] GetGlobals() {
		return new Object[] {"downloadAppUrl",starter._downloadappurl,"getVersion",starter._getversion,"gHttpVersionJob",starter._ghttpversionjob,"HttpUtils2Service",Debug.moduleToString(com.qolega.qolegapp.httputils2service.class),"Main",Debug.moduleToString(com.qolega.qolegapp.main.class),"ReferringList",Debug.moduleToString(com.qolega.qolegapp.referringlist.class),"ReferringProgress",Debug.moduleToString(com.qolega.qolegapp.referringprogress.class),"Service",starter.mostCurrent._service,"Test3",Debug.moduleToString(com.qolega.qolegapp.test3.class),"Test4",Debug.moduleToString(com.qolega.qolegapp.test4.class),"TestResponsive",Debug.moduleToString(com.qolega.qolegapp.testresponsive.class),"updateApp",starter._updateapp};
}
}