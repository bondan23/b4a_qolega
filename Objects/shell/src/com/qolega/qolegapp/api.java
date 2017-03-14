
package com.qolega.qolegapp;

import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RemoteObject;

public class api {
    public static RemoteObject myClass;
	public api() {
	}
    public static PCBA staticBA = new PCBA(null, api.class);

public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _apiurl = RemoteObject.createImmutable("");
public static RemoteObject _result = RemoteObject.createImmutable("");
public static RemoteObject _job = RemoteObject.declareNull("com.qolega.qolegapp.httpjob");
public static com.qolega.qolegapp.main _main = null;
public static com.qolega.qolegapp.starter _starter = null;
public static com.qolega.qolegapp.referringlist _referringlist = null;
public static com.qolega.qolegapp.referringprogress _referringprogress = null;
public static com.qolega.qolegapp.testresponsive _testresponsive = null;
public static com.qolega.qolegapp.test3 _test3 = null;
public static com.qolega.qolegapp.httputils2service _httputils2service = null;
public static com.qolega.qolegapp.test4 _test4 = null;
public static Object[] GetGlobals(RemoteObject _ref) throws Exception {
		return new Object[] {"apiUrl",_ref.getField(false, "_apiurl"),"Job",_ref.getField(false, "_job"),"result",_ref.getField(false, "_result")};
}
}