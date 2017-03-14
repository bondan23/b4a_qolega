
package com.qolega.qolegapp;

import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RemoteObject;

public class auth {
    public static RemoteObject myClass;
	public auth() {
	}
    public static PCBA staticBA = new PCBA(null, auth.class);

public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _manager = RemoteObject.declareNull("anywheresoftware.b4a.objects.preferenceactivity.PreferenceManager");
public static RemoteObject _act = RemoteObject.declareNull("anywheresoftware.b4a.objects.ActivityWrapper");
public static RemoteObject _urlapi = RemoteObject.createImmutable("");
public static RemoteObject _clientsecret = RemoteObject.createImmutable("");
public static RemoteObject _clientid = RemoteObject.createImmutable("");
public static com.qolega.qolegapp.main _main = null;
public static com.qolega.qolegapp.starter _starter = null;
public static com.qolega.qolegapp.referringlist _referringlist = null;
public static com.qolega.qolegapp.referringprogress _referringprogress = null;
public static com.qolega.qolegapp.testresponsive _testresponsive = null;
public static com.qolega.qolegapp.test3 _test3 = null;
public static com.qolega.qolegapp.test4 _test4 = null;
public static com.qolega.qolegapp.httputils2service _httputils2service = null;
public static Object[] GetGlobals(RemoteObject _ref) throws Exception {
		return new Object[] {"Act",_ref.getField(false, "_act"),"clientId",_ref.getField(false, "_clientid"),"clientSecret",_ref.getField(false, "_clientsecret"),"manager",_ref.getField(false, "_manager"),"urlApi",_ref.getField(false, "_urlapi")};
}
}