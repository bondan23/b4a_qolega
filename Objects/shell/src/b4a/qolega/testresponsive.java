
package b4a.qolega;

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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("testresponsive"), "b4a.qolega.testresponsive");
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
public static RemoteObject _scrollview = RemoteObject.declareNull("anywheresoftware.b4a.objects.ScrollViewWrapper");
public static RemoteObject _json = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
public static RemoteObject _su = RemoteObject.declareNull("anywheresoftware.b4a.objects.StringUtils");
public static RemoteObject _firstcontainer = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _label1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static b4a.qolega.main _main = null;
public static b4a.qolega.starter _starter = null;
public static b4a.qolega.referringlist _referringlist = null;
public static b4a.qolega.test _test = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",testresponsive.mostCurrent._activity,"FirstContainer",testresponsive.mostCurrent._firstcontainer,"JSON",testresponsive.mostCurrent._json,"Label1",testresponsive.mostCurrent._label1,"Main",Debug.moduleToString(b4a.qolega.main.class),"ReferringList",Debug.moduleToString(b4a.qolega.referringlist.class),"scrollView",testresponsive.mostCurrent._scrollview,"Starter",Debug.moduleToString(b4a.qolega.starter.class),"su",testresponsive.mostCurrent._su,"Test",Debug.moduleToString(b4a.qolega.test.class)};
}
}