package com.qolega.qolegapp;


import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class referringlist extends Activity implements B4AActivity{
	public static referringlist mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = true;
    public static WeakReference<Activity> previousOne;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (isFirst) {
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "com.qolega.qolegapp", "com.qolega.qolegapp.referringlist");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (referringlist).");
				p.finish();
			}
		}
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		mostCurrent = this;
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
        WaitForLayout wl = new WaitForLayout();
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(processBA, wl, false))
		    BA.handler.postDelayed(wl, 5);

	}
	static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "com.qolega.qolegapp", "com.qolega.qolegapp.referringlist");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "com.qolega.qolegapp.referringlist", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (referringlist) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (referringlist) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEvent(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return referringlist.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null) //workaround for emulator bug (Issue 2423)
            return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        BA.LogInfo("** Activity (referringlist) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        processBA.setActivityPaused(true);
        mostCurrent = null;
        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
			if (mostCurrent == null || mostCurrent != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (referringlist) Resume **");
		    processBA.raiseEvent(mostCurrent._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}



public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.ScrollViewWrapper _scrollview = null;
public anywheresoftware.b4a.objects.collections.JSONParser _json = null;
public anywheresoftware.b4a.objects.StringUtils _su = null;
public anywheresoftware.b4a.objects.collections.List _detaillist = null;
public anywheresoftware.b4a.objects.collections.List _resultlist = null;
public com.qolega.qolegapp.auth _qauth = null;
public com.qolega.qolegapp.fonts _font = null;
public anywheresoftware.b4a.objects.ButtonWrapper _loadmore = null;
public com.qolega.qolegapp.api _api = null;
public static int _loadmoretop = 0;
public com.qolega.qolegapp.main _main = null;
public com.qolega.qolegapp.starter _starter = null;
public com.qolega.qolegapp.referringprogress _referringprogress = null;
public com.qolega.qolegapp.testresponsive _testresponsive = null;
public com.qolega.qolegapp.test3 _test3 = null;
public com.qolega.qolegapp.httputils2service _httputils2service = null;
public com.qolega.qolegapp.test4 _test4 = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="referringlist";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create"))
	return (String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime});
RDebugUtils.currentLine=917504;
 //BA.debugLineNum = 917504;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=917506;
 //BA.debugLineNum = 917506;BA.debugLine="qAuth.Initialize(Activity)";
mostCurrent._qauth._initialize(null,mostCurrent.activityBA,mostCurrent._activity);
RDebugUtils.currentLine=917507;
 //BA.debugLineNum = 917507;BA.debugLine="font.Initialize";
mostCurrent._font._initialize(null,processBA);
RDebugUtils.currentLine=917508;
 //BA.debugLineNum = 917508;BA.debugLine="Api.Initialize(\"refferingList\",Me)";
mostCurrent._api._initialize(null,processBA,"refferingList",referringlist.getObject());
RDebugUtils.currentLine=917512;
 //BA.debugLineNum = 917512;BA.debugLine="Activity.AddMenuItem3(\"SearchItem\", \"SearchItem\",";
mostCurrent._activity.AddMenuItem3("SearchItem","SearchItem",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"Logout.png").getObject()),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=917513;
 //BA.debugLineNum = 917513;BA.debugLine="scrollView.Initialize(Activity.Height)";
mostCurrent._scrollview.Initialize(mostCurrent.activityBA,mostCurrent._activity.getHeight());
RDebugUtils.currentLine=917514;
 //BA.debugLineNum = 917514;BA.debugLine="scrollView.Color = Colors.RGB(246,246,246)";
mostCurrent._scrollview.setColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (246),(int) (246),(int) (246)));
RDebugUtils.currentLine=917515;
 //BA.debugLineNum = 917515;BA.debugLine="Activity.AddView(scrollView,0,0,100%x,100%y)";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._scrollview.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
RDebugUtils.currentLine=917516;
 //BA.debugLineNum = 917516;BA.debugLine="detailList.Initialize";
mostCurrent._detaillist.Initialize();
RDebugUtils.currentLine=917517;
 //BA.debugLineNum = 917517;BA.debugLine="resultList.Initialize";
mostCurrent._resultlist.Initialize();
RDebugUtils.currentLine=917522;
 //BA.debugLineNum = 917522;BA.debugLine="Api.Get(\"/referrals/list/\"&qAuth.GetStore(\"id\"))";
mostCurrent._api._get(null,"/referrals/list/"+mostCurrent._qauth._getstore(null,"id"));
RDebugUtils.currentLine=917523;
 //BA.debugLineNum = 917523;BA.debugLine="ProgressDialogShow2(\"Loading Data\",False)";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow2(mostCurrent.activityBA,"Loading Data",anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=917524;
 //BA.debugLineNum = 917524;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="referringlist";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_pause"))
	return (String) Debug.delegate(mostCurrent.activityBA, "activity_pause", new Object[] {_userclosed});
RDebugUtils.currentLine=1245184;
 //BA.debugLineNum = 1245184;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=1245186;
 //BA.debugLineNum = 1245186;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="referringlist";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume"))
	return (String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null);
RDebugUtils.currentLine=1179648;
 //BA.debugLineNum = 1179648;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=1179650;
 //BA.debugLineNum = 1179650;BA.debugLine="End Sub";
return "";
}
public static String  _detailbtn_click() throws Exception{
RDebugUtils.currentModule="referringlist";
if (Debug.shouldDelegate(mostCurrent.activityBA, "detailbtn_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "detailbtn_click", null);
int _i = 0;
anywheresoftware.b4a.objects.ButtonWrapper _detailbtn = null;
RDebugUtils.currentLine=1441792;
 //BA.debugLineNum = 1441792;BA.debugLine="Sub detailBtn_Click";
RDebugUtils.currentLine=1441793;
 //BA.debugLineNum = 1441793;BA.debugLine="For i = 0 To detailList.Size - 1";
{
final int step1 = 1;
final int limit1 = (int) (mostCurrent._detaillist.getSize()-1);
for (_i = (int) (0) ; (step1 > 0 && _i <= limit1) || (step1 < 0 && _i >= limit1); _i = ((int)(0 + _i + step1)) ) {
RDebugUtils.currentLine=1441794;
 //BA.debugLineNum = 1441794;BA.debugLine="Dim detailBtn As Button";
_detailbtn = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=1441795;
 //BA.debugLineNum = 1441795;BA.debugLine="detailBtn = detailList.Get(i)";
_detailbtn.setObject((android.widget.Button)(mostCurrent._detaillist.Get(_i)));
RDebugUtils.currentLine=1441796;
 //BA.debugLineNum = 1441796;BA.debugLine="detailBtn = Sender";
_detailbtn.setObject((android.widget.Button)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
 }
};
RDebugUtils.currentLine=1441800;
 //BA.debugLineNum = 1441800;BA.debugLine="ReferringProgress.userId = detailBtn.Tag";
mostCurrent._referringprogress._userid = (int)(BA.ObjectToNumber(_detailbtn.getTag()));
RDebugUtils.currentLine=1441801;
 //BA.debugLineNum = 1441801;BA.debugLine="StartActivity(ReferringProgress)";
anywheresoftware.b4a.keywords.Common.StartActivity(mostCurrent.activityBA,(Object)(mostCurrent._referringprogress.getObject()));
RDebugUtils.currentLine=1441803;
 //BA.debugLineNum = 1441803;BA.debugLine="End Sub";
return "";
}
public static String  _detailbtn_down() throws Exception{
RDebugUtils.currentModule="referringlist";
if (Debug.shouldDelegate(mostCurrent.activityBA, "detailbtn_down"))
	return (String) Debug.delegate(mostCurrent.activityBA, "detailbtn_down", null);
int _i = 0;
anywheresoftware.b4a.objects.ButtonWrapper _detailbtn = null;
RDebugUtils.currentLine=1507328;
 //BA.debugLineNum = 1507328;BA.debugLine="Sub detailBtn_Down";
RDebugUtils.currentLine=1507329;
 //BA.debugLineNum = 1507329;BA.debugLine="For i = 0 To detailList.Size - 1";
{
final int step1 = 1;
final int limit1 = (int) (mostCurrent._detaillist.getSize()-1);
for (_i = (int) (0) ; (step1 > 0 && _i <= limit1) || (step1 < 0 && _i >= limit1); _i = ((int)(0 + _i + step1)) ) {
RDebugUtils.currentLine=1507330;
 //BA.debugLineNum = 1507330;BA.debugLine="Dim detailBtn As Button";
_detailbtn = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=1507331;
 //BA.debugLineNum = 1507331;BA.debugLine="detailBtn = detailList.Get(i)";
_detailbtn.setObject((android.widget.Button)(mostCurrent._detaillist.Get(_i)));
RDebugUtils.currentLine=1507332;
 //BA.debugLineNum = 1507332;BA.debugLine="detailBtn = Sender";
_detailbtn.setObject((android.widget.Button)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
 }
};
RDebugUtils.currentLine=1507335;
 //BA.debugLineNum = 1507335;BA.debugLine="detailBtn.TextColor = Colors.RGB(105, 203, 231)";
_detailbtn.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (105),(int) (203),(int) (231)));
RDebugUtils.currentLine=1507336;
 //BA.debugLineNum = 1507336;BA.debugLine="End Sub";
return "";
}
public static String  _detailbtn_up() throws Exception{
RDebugUtils.currentModule="referringlist";
if (Debug.shouldDelegate(mostCurrent.activityBA, "detailbtn_up"))
	return (String) Debug.delegate(mostCurrent.activityBA, "detailbtn_up", null);
int _i = 0;
anywheresoftware.b4a.objects.ButtonWrapper _detailbtn = null;
RDebugUtils.currentLine=1572864;
 //BA.debugLineNum = 1572864;BA.debugLine="Sub detailBtn_Up";
RDebugUtils.currentLine=1572865;
 //BA.debugLineNum = 1572865;BA.debugLine="For i = 0 To detailList.Size - 1";
{
final int step1 = 1;
final int limit1 = (int) (mostCurrent._detaillist.getSize()-1);
for (_i = (int) (0) ; (step1 > 0 && _i <= limit1) || (step1 < 0 && _i >= limit1); _i = ((int)(0 + _i + step1)) ) {
RDebugUtils.currentLine=1572866;
 //BA.debugLineNum = 1572866;BA.debugLine="Dim detailBtn As Button";
_detailbtn = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=1572867;
 //BA.debugLineNum = 1572867;BA.debugLine="detailBtn = detailList.Get(i)";
_detailbtn.setObject((android.widget.Button)(mostCurrent._detaillist.Get(_i)));
RDebugUtils.currentLine=1572868;
 //BA.debugLineNum = 1572868;BA.debugLine="detailBtn = Sender";
_detailbtn.setObject((android.widget.Button)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
 }
};
RDebugUtils.currentLine=1572871;
 //BA.debugLineNum = 1572871;BA.debugLine="detailBtn.TextColor = Colors.RGB(22,176,221)";
_detailbtn.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (22),(int) (176),(int) (221)));
RDebugUtils.currentLine=1572872;
 //BA.debugLineNum = 1572872;BA.debugLine="End Sub";
return "";
}
public static String  _jobdone(com.qolega.qolegapp.httpjob _job) throws Exception{
RDebugUtils.currentModule="referringlist";
if (Debug.shouldDelegate(mostCurrent.activityBA, "jobdone"))
	return (String) Debug.delegate(mostCurrent.activityBA, "jobdone", new Object[] {_job});
RDebugUtils.currentLine=983040;
 //BA.debugLineNum = 983040;BA.debugLine="Sub JobDone(Job As HttpJob)";
RDebugUtils.currentLine=983041;
 //BA.debugLineNum = 983041;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
RDebugUtils.currentLine=983042;
 //BA.debugLineNum = 983042;BA.debugLine="Log(\"JobName = \" & Job.JobName & \", Success = \"";
anywheresoftware.b4a.keywords.Common.Log("JobName = "+_job._jobname+", Success = "+BA.ObjectToString(_job._success));
RDebugUtils.currentLine=983043;
 //BA.debugLineNum = 983043;BA.debugLine="If Job.Success = True Then";
if (_job._success==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=983044;
 //BA.debugLineNum = 983044;BA.debugLine="LoopPanel(loadMoreTop,Job.GetString)";
_looppanel(_loadmoretop,_job._getstring(null));
 }else {
RDebugUtils.currentLine=983046;
 //BA.debugLineNum = 983046;BA.debugLine="Log(\"Error: \" & Job.ErrorMessage)";
anywheresoftware.b4a.keywords.Common.Log("Error: "+_job._errormessage);
RDebugUtils.currentLine=983047;
 //BA.debugLineNum = 983047;BA.debugLine="ToastMessageShow(\"Error: \" & Job.ErrorMessag";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("Error: "+_job._errormessage,anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=983049;
 //BA.debugLineNum = 983049;BA.debugLine="Job.Release";
_job._release(null);
RDebugUtils.currentLine=983050;
 //BA.debugLineNum = 983050;BA.debugLine="End Sub";
return "";
}
public static String  _looppanel(int _starttop,String _data) throws Exception{
RDebugUtils.currentModule="referringlist";
if (Debug.shouldDelegate(mostCurrent.activityBA, "looppanel"))
	return (String) Debug.delegate(mostCurrent.activityBA, "looppanel", new Object[] {_starttop,_data});
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bitmap1 = null;
anywheresoftware.b4a.objects.PanelWrapper _container = null;
anywheresoftware.b4a.objects.PanelWrapper _joblistpanel = null;
anywheresoftware.b4a.objects.PanelWrapper _referencepanel = null;
int _paneltop = 0;
int _defaultpanelheight = 0;
int _panelheight = 0;
int _referencetop = 0;
int _referenceheight = 0;
int _gap = 0;
int _textheight = 0;
anywheresoftware.b4a.objects.LabelWrapper _jobtitle = null;
anywheresoftware.b4a.objects.LabelWrapper _location = null;
anywheresoftware.b4a.objects.LabelWrapper _jobdesc = null;
anywheresoftware.b4a.objects.LabelWrapper _currency = null;
anywheresoftware.b4a.objects.LabelWrapper _commision = null;
anywheresoftware.b4a.objects.ImageViewWrapper _locationicon = null;
anywheresoftware.b4a.objects.ImageViewWrapper _industryicon = null;
anywheresoftware.b4a.objects.ImageViewWrapper _moneyicon = null;
anywheresoftware.b4a.objects.collections.List _root = null;
anywheresoftware.b4a.objects.collections.Map _colroot = null;
anywheresoftware.b4a.objects.collections.List _reference = null;
String _job_title = "";
String _job_location = "";
String _job_desc = "";
double _job_commision = 0;
anywheresoftware.b4a.objects.drawable.CanvasWrapper _canv = null;
int _newcurrencywidth = 0;
int _sizeofref = 0;
anywheresoftware.b4a.objects.collections.Map _colreference = null;
anywheresoftware.b4a.objects.LabelWrapper _refname = null;
anywheresoftware.b4a.objects.LabelWrapper _refcompany = null;
anywheresoftware.b4a.objects.LabelWrapper _refstatus = null;
anywheresoftware.b4a.objects.LabelWrapper _detailbtn = null;
anywheresoftware.b4a.objects.LabelWrapper _refday = null;
anywheresoftware.b4a.objects.ButtonWrapper _detailbutton = null;
String _statusref = "";
int _rheight = 0;
int _statusrefcolor = 0;
anywheresoftware.b4a.objects.ImageViewWrapper _usericon = null;
String _rname = "";
String _rcompany = "";
String _rstatus = "";
int _userid = 0;
String _daysago = "";
anywheresoftware.b4a.objects.drawable.ColorDrawable _cd = null;
int _refstatusheight = 0;
anywheresoftware.b4a.objects.drawable.StateListDrawable _sld = null;
anywheresoftware.b4a.objects.drawable.ColorDrawable _pressed = null;
anywheresoftware.b4a.objects.drawable.ColorDrawable _enabled = null;
RDebugUtils.currentLine=1048576;
 //BA.debugLineNum = 1048576;BA.debugLine="Sub LoopPanel(StartTop As Int,Data As String)";
RDebugUtils.currentLine=1048577;
 //BA.debugLineNum = 1048577;BA.debugLine="Dim Bitmap1 As Bitmap";
_bitmap1 = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
RDebugUtils.currentLine=1048578;
 //BA.debugLineNum = 1048578;BA.debugLine="Dim Container As Panel";
_container = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=1048579;
 //BA.debugLineNum = 1048579;BA.debugLine="Dim JoblistPanel,ReferencePanel As Panel";
_joblistpanel = new anywheresoftware.b4a.objects.PanelWrapper();
_referencepanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=1048580;
 //BA.debugLineNum = 1048580;BA.debugLine="Dim PanelTop,defaultPanelHeight,PanelHeight,Refer";
_paneltop = 0;
_defaultpanelheight = 0;
_panelheight = 0;
_referencetop = 0;
_referenceheight = 0;
_gap = 0;
_textheight = 0;
RDebugUtils.currentLine=1048581;
 //BA.debugLineNum = 1048581;BA.debugLine="Dim JobTitle,Location,JobDesc,Currency,Commision";
_jobtitle = new anywheresoftware.b4a.objects.LabelWrapper();
_location = new anywheresoftware.b4a.objects.LabelWrapper();
_jobdesc = new anywheresoftware.b4a.objects.LabelWrapper();
_currency = new anywheresoftware.b4a.objects.LabelWrapper();
_commision = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=1048582;
 //BA.debugLineNum = 1048582;BA.debugLine="Dim locationIcon,industryIcon,moneyIcon As ImageV";
_locationicon = new anywheresoftware.b4a.objects.ImageViewWrapper();
_industryicon = new anywheresoftware.b4a.objects.ImageViewWrapper();
_moneyicon = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=1048585;
 //BA.debugLineNum = 1048585;BA.debugLine="PanelTop = StartTop";
_paneltop = _starttop;
RDebugUtils.currentLine=1048588;
 //BA.debugLineNum = 1048588;BA.debugLine="PanelHeight = 110dip";
_panelheight = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (110));
RDebugUtils.currentLine=1048589;
 //BA.debugLineNum = 1048589;BA.debugLine="defaultPanelHeight = PanelHeight";
_defaultpanelheight = _panelheight;
RDebugUtils.currentLine=1048591;
 //BA.debugLineNum = 1048591;BA.debugLine="Gap = 10dip";
_gap = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
RDebugUtils.currentLine=1048594;
 //BA.debugLineNum = 1048594;BA.debugLine="Container = scrollView.Panel";
_container = mostCurrent._scrollview.getPanel();
RDebugUtils.currentLine=1048595;
 //BA.debugLineNum = 1048595;BA.debugLine="Container.Color = Colors.RGB(219,219,219)";
_container.setColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (219),(int) (219),(int) (219)));
RDebugUtils.currentLine=1048598;
 //BA.debugLineNum = 1048598;BA.debugLine="JSON.Initialize(Data)";
mostCurrent._json.Initialize(_data);
RDebugUtils.currentLine=1048599;
 //BA.debugLineNum = 1048599;BA.debugLine="Dim root As List = JSON.NextArray";
_root = new anywheresoftware.b4a.objects.collections.List();
_root = mostCurrent._json.NextArray();
RDebugUtils.currentLine=1048601;
 //BA.debugLineNum = 1048601;BA.debugLine="For Each colroot As Map In root";
_colroot = new anywheresoftware.b4a.objects.collections.Map();
final anywheresoftware.b4a.BA.IterableList group15 = _root;
final int groupLen15 = group15.getSize();
for (int index15 = 0;index15 < groupLen15 ;index15++){
_colroot.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(group15.Get(index15)));
RDebugUtils.currentLine=1048603;
 //BA.debugLineNum = 1048603;BA.debugLine="Dim reference As List = colroot.Get(\"reference\")";
_reference = new anywheresoftware.b4a.objects.collections.List();
_reference.setObject((java.util.List)(_colroot.Get((Object)("reference"))));
RDebugUtils.currentLine=1048604;
 //BA.debugLineNum = 1048604;BA.debugLine="Dim job_title As String = colroot.Get(\"job_title";
_job_title = BA.ObjectToString(_colroot.Get((Object)("job_title")));
RDebugUtils.currentLine=1048605;
 //BA.debugLineNum = 1048605;BA.debugLine="Dim job_location As String = colroot.Get(\"locati";
_job_location = BA.ObjectToString(_colroot.Get((Object)("location")));
RDebugUtils.currentLine=1048606;
 //BA.debugLineNum = 1048606;BA.debugLine="Dim job_desc As String = colroot.Get(\"industry\")";
_job_desc = BA.ObjectToString(_colroot.Get((Object)("industry")));
RDebugUtils.currentLine=1048607;
 //BA.debugLineNum = 1048607;BA.debugLine="Dim job_commision As Double = colroot.Get(\"commi";
_job_commision = (double)(BA.ObjectToNumber(_colroot.Get((Object)("commision"))));
RDebugUtils.currentLine=1048610;
 //BA.debugLineNum = 1048610;BA.debugLine="JoblistPanel.Initialize(\"\")";
_joblistpanel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1048611;
 //BA.debugLineNum = 1048611;BA.debugLine="JobTitle.Initialize(\"JobTitle\")";
_jobtitle.Initialize(mostCurrent.activityBA,"JobTitle");
RDebugUtils.currentLine=1048612;
 //BA.debugLineNum = 1048612;BA.debugLine="Location.Initialize(\"Location\")";
_location.Initialize(mostCurrent.activityBA,"Location");
RDebugUtils.currentLine=1048613;
 //BA.debugLineNum = 1048613;BA.debugLine="JobDesc.Initialize(\"JobDesc\")";
_jobdesc.Initialize(mostCurrent.activityBA,"JobDesc");
RDebugUtils.currentLine=1048614;
 //BA.debugLineNum = 1048614;BA.debugLine="Currency.Initialize(\"Currency\")";
_currency.Initialize(mostCurrent.activityBA,"Currency");
RDebugUtils.currentLine=1048615;
 //BA.debugLineNum = 1048615;BA.debugLine="Commision.Initialize(\"Commision\")";
_commision.Initialize(mostCurrent.activityBA,"Commision");
RDebugUtils.currentLine=1048618;
 //BA.debugLineNum = 1048618;BA.debugLine="locationIcon.Initialize(\"\")";
_locationicon.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1048619;
 //BA.debugLineNum = 1048619;BA.debugLine="industryIcon.Initialize(\"\")";
_industryicon.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1048620;
 //BA.debugLineNum = 1048620;BA.debugLine="moneyIcon.Initialize(\"\")";
_moneyicon.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1048623;
 //BA.debugLineNum = 1048623;BA.debugLine="locationIcon.Bitmap = LoadBitmap(File.DirAssets,";
_locationicon.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"location.png").getObject()));
RDebugUtils.currentLine=1048624;
 //BA.debugLineNum = 1048624;BA.debugLine="industryIcon.Bitmap = LoadBitmap(File.DirAssets,";
_industryicon.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"industry.png").getObject()));
RDebugUtils.currentLine=1048625;
 //BA.debugLineNum = 1048625;BA.debugLine="moneyIcon.Bitmap = LoadBitmap(File.DirAssets,\"mo";
_moneyicon.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"money.png").getObject()));
RDebugUtils.currentLine=1048627;
 //BA.debugLineNum = 1048627;BA.debugLine="locationIcon.Gravity = Gravity.FILL";
_locationicon.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
RDebugUtils.currentLine=1048628;
 //BA.debugLineNum = 1048628;BA.debugLine="moneyIcon.Gravity = Gravity.FILL";
_moneyicon.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
RDebugUtils.currentLine=1048629;
 //BA.debugLineNum = 1048629;BA.debugLine="industryIcon.Gravity = Gravity.FILL";
_industryicon.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
RDebugUtils.currentLine=1048633;
 //BA.debugLineNum = 1048633;BA.debugLine="JobTitle.Typeface = font.proximanovaSemiBold";
_jobtitle.setTypeface((android.graphics.Typeface)(mostCurrent._font._proximanovasemibold(null).getObject()));
RDebugUtils.currentLine=1048634;
 //BA.debugLineNum = 1048634;BA.debugLine="JobTitle.Text = job_title";
_jobtitle.setText((Object)(_job_title));
RDebugUtils.currentLine=1048636;
 //BA.debugLineNum = 1048636;BA.debugLine="JobTitle.TextColor = Colors.RGB(74,74,74)";
_jobtitle.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (74),(int) (74),(int) (74)));
RDebugUtils.currentLine=1048639;
 //BA.debugLineNum = 1048639;BA.debugLine="Location.Typeface = font.proximanovaRegular";
_location.setTypeface((android.graphics.Typeface)(mostCurrent._font._proximanovaregular(null).getObject()));
RDebugUtils.currentLine=1048640;
 //BA.debugLineNum = 1048640;BA.debugLine="Location.Text = job_location";
_location.setText((Object)(_job_location));
RDebugUtils.currentLine=1048641;
 //BA.debugLineNum = 1048641;BA.debugLine="Location.TextColor = Colors.RGB(179,179,179)";
_location.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (179),(int) (179),(int) (179)));
RDebugUtils.currentLine=1048642;
 //BA.debugLineNum = 1048642;BA.debugLine="Location.TextSize = JobTitle.TextSize / 1.25";
_location.setTextSize((float) (_jobtitle.getTextSize()/(double)1.25));
RDebugUtils.currentLine=1048644;
 //BA.debugLineNum = 1048644;BA.debugLine="JobDesc.Typeface = font.proximanovaRegular";
_jobdesc.setTypeface((android.graphics.Typeface)(mostCurrent._font._proximanovaregular(null).getObject()));
RDebugUtils.currentLine=1048645;
 //BA.debugLineNum = 1048645;BA.debugLine="JobDesc.Text = job_desc";
_jobdesc.setText((Object)(_job_desc));
RDebugUtils.currentLine=1048646;
 //BA.debugLineNum = 1048646;BA.debugLine="JobDesc.TextColor = Colors.RGB(179,179,179)";
_jobdesc.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (179),(int) (179),(int) (179)));
RDebugUtils.currentLine=1048647;
 //BA.debugLineNum = 1048647;BA.debugLine="JobDesc.TextSize = JobTitle.TextSize / 1.25";
_jobdesc.setTextSize((float) (_jobtitle.getTextSize()/(double)1.25));
RDebugUtils.currentLine=1048649;
 //BA.debugLineNum = 1048649;BA.debugLine="Currency.Typeface = font.proximanovaSemiBold";
_currency.setTypeface((android.graphics.Typeface)(mostCurrent._font._proximanovasemibold(null).getObject()));
RDebugUtils.currentLine=1048650;
 //BA.debugLineNum = 1048650;BA.debugLine="Currency.Text = \"IDR \"&NumberFormat(job_commisio";
_currency.setText((Object)("IDR "+anywheresoftware.b4a.keywords.Common.NumberFormat(_job_commision,(int) (0),(int) (2))));
RDebugUtils.currentLine=1048651;
 //BA.debugLineNum = 1048651;BA.debugLine="Currency.TextColor = Colors.RGB(74,74,74)";
_currency.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (74),(int) (74),(int) (74)));
RDebugUtils.currentLine=1048653;
 //BA.debugLineNum = 1048653;BA.debugLine="Commision.Typeface = font.proximanovaRegular";
_commision.setTypeface((android.graphics.Typeface)(mostCurrent._font._proximanovaregular(null).getObject()));
RDebugUtils.currentLine=1048654;
 //BA.debugLineNum = 1048654;BA.debugLine="Commision.Text = \"Commision\"";
_commision.setText((Object)("Commision"));
RDebugUtils.currentLine=1048655;
 //BA.debugLineNum = 1048655;BA.debugLine="Commision.TextColor = Colors.RGB(179,179,179)";
_commision.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (179),(int) (179),(int) (179)));
RDebugUtils.currentLine=1048656;
 //BA.debugLineNum = 1048656;BA.debugLine="Commision.TextSize = JobTitle.TextSize / 1.25";
_commision.setTextSize((float) (_jobtitle.getTextSize()/(double)1.25));
RDebugUtils.currentLine=1048659;
 //BA.debugLineNum = 1048659;BA.debugLine="JoblistPanel.AddView(JobTitle,10dip,10dip,100%x-";
_joblistpanel.AddView((android.view.View)(_jobtitle.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),(int) (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA)-(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))*2)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)));
RDebugUtils.currentLine=1048660;
 //BA.debugLineNum = 1048660;BA.debugLine="TextHeight = su.MeasureMultilineTextHeight(JobTi";
_textheight = mostCurrent._su.MeasureMultilineTextHeight((android.widget.TextView)(_jobtitle.getObject()),_jobtitle.getText());
RDebugUtils.currentLine=1048663;
 //BA.debugLineNum = 1048663;BA.debugLine="JoblistPanel.AddView(locationIcon,12dip,TextHeig";
_joblistpanel.AddView((android.view.View)(_locationicon.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (12)),(int) (_textheight+_gap*1.5),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (9.6)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (12)));
RDebugUtils.currentLine=1048666;
 //BA.debugLineNum = 1048666;BA.debugLine="JoblistPanel.AddView(Location,30dip,TextHeight+G";
_joblistpanel.AddView((android.view.View)(_location.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)),(int) (_textheight+_gap*1.5),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)));
RDebugUtils.currentLine=1048667;
 //BA.debugLineNum = 1048667;BA.debugLine="TextHeight = TextHeight + su.MeasureMultilineTex";
_textheight = (int) (_textheight+mostCurrent._su.MeasureMultilineTextHeight((android.widget.TextView)(_location.getObject()),_location.getText()));
RDebugUtils.currentLine=1048670;
 //BA.debugLineNum = 1048670;BA.debugLine="JoblistPanel.AddView(industryIcon,11dip,TextHeig";
_joblistpanel.AddView((android.view.View)(_industryicon.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (11)),(int) (_textheight+_gap*1.8),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (12)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (12)));
RDebugUtils.currentLine=1048672;
 //BA.debugLineNum = 1048672;BA.debugLine="JoblistPanel.AddView(JobDesc,30dip,TextHeight+Ga";
_joblistpanel.AddView((android.view.View)(_jobdesc.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)),(int) (_textheight+_gap*1.8),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)));
RDebugUtils.currentLine=1048673;
 //BA.debugLineNum = 1048673;BA.debugLine="TextHeight = TextHeight + su.MeasureMultilineTex";
_textheight = (int) (_textheight+mostCurrent._su.MeasureMultilineTextHeight((android.widget.TextView)(_jobdesc.getObject()),_jobdesc.getText()));
RDebugUtils.currentLine=1048676;
 //BA.debugLineNum = 1048676;BA.debugLine="JoblistPanel.AddView(moneyIcon,10dip,TextHeight+";
_joblistpanel.AddView((android.view.View)(_moneyicon.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),(int) (_textheight+_gap*2.2),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (14)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (11.2)));
RDebugUtils.currentLine=1048678;
 //BA.debugLineNum = 1048678;BA.debugLine="JoblistPanel.AddView(Currency,30.9dip,TextHeight";
_joblistpanel.AddView((android.view.View)(_currency.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30.9)),(int) (_textheight+_gap*2),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (105)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)));
RDebugUtils.currentLine=1048680;
 //BA.debugLineNum = 1048680;BA.debugLine="Dim Canv As Canvas";
_canv = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();
RDebugUtils.currentLine=1048681;
 //BA.debugLineNum = 1048681;BA.debugLine="Canv.Initialize(Currency)";
_canv.Initialize((android.view.View)(_currency.getObject()));
RDebugUtils.currentLine=1048682;
 //BA.debugLineNum = 1048682;BA.debugLine="Dim newCurrencyWidth = Canv.MeasureStringWidth(C";
_newcurrencywidth = (int) (_canv.MeasureStringWidth(_currency.getText(),(android.graphics.Typeface)(mostCurrent._font._proximanovaregular(null).getObject()),_currency.getTextSize()));
RDebugUtils.currentLine=1048683;
 //BA.debugLineNum = 1048683;BA.debugLine="Currency.Width = newCurrencyWidth+Gap/2";
_currency.setWidth((int) (_newcurrencywidth+_gap/(double)2));
RDebugUtils.currentLine=1048685;
 //BA.debugLineNum = 1048685;BA.debugLine="JoblistPanel.AddView(Commision,Currency.Width+Cu";
_joblistpanel.AddView((android.view.View)(_commision.getObject()),(int) (_currency.getWidth()+_currency.getLeft()),(int) (_textheight+_gap*2.2),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)));
RDebugUtils.currentLine=1048686;
 //BA.debugLineNum = 1048686;BA.debugLine="TextHeight = TextHeight + su.MeasureMultilineTex";
_textheight = (int) (_textheight+mostCurrent._su.MeasureMultilineTextHeight((android.widget.TextView)(_currency.getObject()),_currency.getText()));
RDebugUtils.currentLine=1048688;
 //BA.debugLineNum = 1048688;BA.debugLine="JoblistPanel.Color=Colors.RGB(255,255,255)";
_joblistpanel.setColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (255),(int) (255),(int) (255)));
RDebugUtils.currentLine=1048691;
 //BA.debugLineNum = 1048691;BA.debugLine="ReferenceTop = TextHeight+Gap*3";
_referencetop = (int) (_textheight+_gap*3);
RDebugUtils.currentLine=1048693;
 //BA.debugLineNum = 1048693;BA.debugLine="ReferenceHeight = 92dip";
_referenceheight = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (92));
RDebugUtils.currentLine=1048696;
 //BA.debugLineNum = 1048696;BA.debugLine="Dim SizeOfRef As Int = reference.Size";
_sizeofref = _reference.getSize();
RDebugUtils.currentLine=1048700;
 //BA.debugLineNum = 1048700;BA.debugLine="PanelHeight = PanelHeight+(ReferenceHeight*SizeO";
_panelheight = (int) (_panelheight+(_referenceheight*_sizeofref)+(_gap*_sizeofref));
RDebugUtils.currentLine=1048702;
 //BA.debugLineNum = 1048702;BA.debugLine="For Each colreference As Map In reference";
_colreference = new anywheresoftware.b4a.objects.collections.Map();
final anywheresoftware.b4a.BA.IterableList group75 = _reference;
final int groupLen75 = group75.getSize();
for (int index75 = 0;index75 < groupLen75 ;index75++){
_colreference.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(group75.Get(index75)));
RDebugUtils.currentLine=1048703;
 //BA.debugLineNum = 1048703;BA.debugLine="Dim refName,refCompany,refStatus,detailBtn,refD";
_refname = new anywheresoftware.b4a.objects.LabelWrapper();
_refcompany = new anywheresoftware.b4a.objects.LabelWrapper();
_refstatus = new anywheresoftware.b4a.objects.LabelWrapper();
_detailbtn = new anywheresoftware.b4a.objects.LabelWrapper();
_refday = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=1048704;
 //BA.debugLineNum = 1048704;BA.debugLine="Dim detailButton As Button";
_detailbutton = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=1048705;
 //BA.debugLineNum = 1048705;BA.debugLine="Dim statusRef As String";
_statusref = "";
RDebugUtils.currentLine=1048706;
 //BA.debugLineNum = 1048706;BA.debugLine="Dim rHeight,statusRefColor As Int";
_rheight = 0;
_statusrefcolor = 0;
RDebugUtils.currentLine=1048707;
 //BA.debugLineNum = 1048707;BA.debugLine="Dim userIcon As ImageView";
_usericon = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=1048710;
 //BA.debugLineNum = 1048710;BA.debugLine="Dim rName As String = colreference.Get(\"name\")";
_rname = BA.ObjectToString(_colreference.Get((Object)("name")));
RDebugUtils.currentLine=1048711;
 //BA.debugLineNum = 1048711;BA.debugLine="Dim rCompany As String = colreference.Get(\"comp";
_rcompany = BA.ObjectToString(_colreference.Get((Object)("company")));
RDebugUtils.currentLine=1048712;
 //BA.debugLineNum = 1048712;BA.debugLine="Dim rStatus As String = colreference.Get(\"statu";
_rstatus = BA.ObjectToString(_colreference.Get((Object)("status")));
RDebugUtils.currentLine=1048714;
 //BA.debugLineNum = 1048714;BA.debugLine="Dim userId As Int = colreference.Get(\"user_id\")";
_userid = (int)(BA.ObjectToNumber(_colreference.Get((Object)("user_id"))));
RDebugUtils.currentLine=1048715;
 //BA.debugLineNum = 1048715;BA.debugLine="Dim daysAgo As String = colreference.Get(\"days_";
_daysago = BA.ObjectToString(_colreference.Get((Object)("days_ago")));
RDebugUtils.currentLine=1048718;
 //BA.debugLineNum = 1048718;BA.debugLine="userIcon.Initialize(\"\")";
_usericon.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1048719;
 //BA.debugLineNum = 1048719;BA.debugLine="userIcon.Bitmap = LoadBitmap(File.DirAssets,\"us";
_usericon.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"user.png").getObject()));
RDebugUtils.currentLine=1048720;
 //BA.debugLineNum = 1048720;BA.debugLine="userIcon.Gravity = Gravity.FILL";
_usericon.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
RDebugUtils.currentLine=1048721;
 //BA.debugLineNum = 1048721;BA.debugLine="ReferencePanel.Initialize(\"\")";
_referencepanel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1048723;
 //BA.debugLineNum = 1048723;BA.debugLine="JoblistPanel.AddView(ReferencePanel,25dip,Refer";
_joblistpanel.AddView((android.view.View)(_referencepanel.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25)),_referencetop,(int) (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA)-(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25))*2)),_referenceheight);
RDebugUtils.currentLine=1048725;
 //BA.debugLineNum = 1048725;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
RDebugUtils.currentLine=1048727;
 //BA.debugLineNum = 1048727;BA.debugLine="cd.Initialize2(Colors.White, 3dip, 1.9dip, Colo";
_cd.Initialize2(anywheresoftware.b4a.keywords.Common.Colors.White,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (3)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1.9)),anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (218),(int) (218),(int) (218)));
RDebugUtils.currentLine=1048728;
 //BA.debugLineNum = 1048728;BA.debugLine="ReferencePanel.Background = cd";
_referencepanel.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
RDebugUtils.currentLine=1048733;
 //BA.debugLineNum = 1048733;BA.debugLine="ReferencePanel.AddView(userIcon,10dip,10dip,24d";
_referencepanel.AddView((android.view.View)(_usericon.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (24)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (24)));
RDebugUtils.currentLine=1048734;
 //BA.debugLineNum = 1048734;BA.debugLine="refName.Initialize(\"\")";
_refname.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1048735;
 //BA.debugLineNum = 1048735;BA.debugLine="refName.Text = rName";
_refname.setText((Object)(_rname));
RDebugUtils.currentLine=1048736;
 //BA.debugLineNum = 1048736;BA.debugLine="refName.TextColor = Colors.RGB(74,74,74)";
_refname.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (74),(int) (74),(int) (74)));
RDebugUtils.currentLine=1048738;
 //BA.debugLineNum = 1048738;BA.debugLine="refName.Typeface = font.proximanovaSemiBold";
_refname.setTypeface((android.graphics.Typeface)(mostCurrent._font._proximanovasemibold(null).getObject()));
RDebugUtils.currentLine=1048739;
 //BA.debugLineNum = 1048739;BA.debugLine="refName.Gravity = Gravity.CENTER_VERTICAL";
_refname.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=1048740;
 //BA.debugLineNum = 1048740;BA.debugLine="ReferencePanel.AddView(refName,38dip,12dip,Refe";
_referencepanel.AddView((android.view.View)(_refname.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (38)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (12)),(int) (_referencepanel.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (38))*2),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)));
RDebugUtils.currentLine=1048743;
 //BA.debugLineNum = 1048743;BA.debugLine="refDay.Initialize(\"\")";
_refday.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1048744;
 //BA.debugLineNum = 1048744;BA.debugLine="refDay.Text = daysAgo&\"d\"";
_refday.setText((Object)(_daysago+"d"));
RDebugUtils.currentLine=1048745;
 //BA.debugLineNum = 1048745;BA.debugLine="refDay.Typeface = font.proximanovaRegular";
_refday.setTypeface((android.graphics.Typeface)(mostCurrent._font._proximanovaregular(null).getObject()));
RDebugUtils.currentLine=1048746;
 //BA.debugLineNum = 1048746;BA.debugLine="refDay.TextColor = Colors.RGB(179,179,179)";
_refday.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (179),(int) (179),(int) (179)));
RDebugUtils.currentLine=1048747;
 //BA.debugLineNum = 1048747;BA.debugLine="refDay.Gravity = Gravity.CENTER";
_refday.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=1048748;
 //BA.debugLineNum = 1048748;BA.debugLine="refDay.TextSize = refName.TextSize / 1.25";
_refday.setTextSize((float) (_refname.getTextSize()/(double)1.25));
RDebugUtils.currentLine=1048749;
 //BA.debugLineNum = 1048749;BA.debugLine="ReferencePanel.AddView(refDay,ReferencePanel.Wi";
_referencepanel.AddView((android.view.View)(_refday.getObject()),(int) (_referencepanel.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))-_gap),_refname.getTop(),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)),_refname.getHeight());
RDebugUtils.currentLine=1048753;
 //BA.debugLineNum = 1048753;BA.debugLine="refCompany.Initialize(\"\")";
_refcompany.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1048754;
 //BA.debugLineNum = 1048754;BA.debugLine="refCompany.Text = rCompany";
_refcompany.setText((Object)(_rcompany));
RDebugUtils.currentLine=1048755;
 //BA.debugLineNum = 1048755;BA.debugLine="refCompany.TextColor = Colors.RGB(179,179,179)";
_refcompany.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (179),(int) (179),(int) (179)));
RDebugUtils.currentLine=1048756;
 //BA.debugLineNum = 1048756;BA.debugLine="refCompany.TextSize = JobTitle.TextSize / 1.25";
_refcompany.setTextSize((float) (_jobtitle.getTextSize()/(double)1.25));
RDebugUtils.currentLine=1048757;
 //BA.debugLineNum = 1048757;BA.debugLine="refCompany.Gravity = Gravity.CENTER_VERTICAL";
_refcompany.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=1048758;
 //BA.debugLineNum = 1048758;BA.debugLine="ReferencePanel.AddView(refCompany,38dip,refName";
_referencepanel.AddView((android.view.View)(_refcompany.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (38)),(int) (_refname.getHeight()+_refname.getTop()),(int) (_referencepanel.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (38))*2),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)));
RDebugUtils.currentLine=1048761;
 //BA.debugLineNum = 1048761;BA.debugLine="refStatus.Initialize(\"\")";
_refstatus.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1048762;
 //BA.debugLineNum = 1048762;BA.debugLine="Select rStatus";
switch (BA.switchObjectToInt(_rstatus,"qualifying","interview_by_consultant","sent_to_client","1st_interview","2nd_interview","3rd_interview","follow_up","hired","1st_day")) {
case 0: {
RDebugUtils.currentLine=1048764;
 //BA.debugLineNum = 1048764;BA.debugLine="cd.Initialize(Colors.RGB(249,128,55), 2dip)";
_cd.Initialize(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (249),(int) (128),(int) (55)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)));
RDebugUtils.currentLine=1048765;
 //BA.debugLineNum = 1048765;BA.debugLine="refStatus.Background = cd";
_refstatus.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
 break; }
case 1: {
RDebugUtils.currentLine=1048767;
 //BA.debugLineNum = 1048767;BA.debugLine="cd.Initialize(Colors.RGB(248,190,56), 2dip)";
_cd.Initialize(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (248),(int) (190),(int) (56)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)));
RDebugUtils.currentLine=1048768;
 //BA.debugLineNum = 1048768;BA.debugLine="refStatus.Background = cd";
_refstatus.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
 break; }
case 2: {
RDebugUtils.currentLine=1048770;
 //BA.debugLineNum = 1048770;BA.debugLine="cd.Initialize(Colors.RGB(186,220,63), 2dip)";
_cd.Initialize(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (186),(int) (220),(int) (63)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)));
RDebugUtils.currentLine=1048771;
 //BA.debugLineNum = 1048771;BA.debugLine="refStatus.Background = cd";
_refstatus.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
 break; }
case 3: 
case 4: 
case 5: {
RDebugUtils.currentLine=1048773;
 //BA.debugLineNum = 1048773;BA.debugLine="cd.Initialize(Colors.RGB(103,195,68), 2dip)";
_cd.Initialize(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (103),(int) (195),(int) (68)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)));
RDebugUtils.currentLine=1048774;
 //BA.debugLineNum = 1048774;BA.debugLine="refStatus.Background = cd";
_refstatus.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
 break; }
case 6: {
RDebugUtils.currentLine=1048776;
 //BA.debugLineNum = 1048776;BA.debugLine="cd.Initialize(Colors.RGB(62,222,176), 2dip)";
_cd.Initialize(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (62),(int) (222),(int) (176)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)));
RDebugUtils.currentLine=1048777;
 //BA.debugLineNum = 1048777;BA.debugLine="refStatus.Background = cd";
_refstatus.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
 break; }
case 7: {
RDebugUtils.currentLine=1048779;
 //BA.debugLineNum = 1048779;BA.debugLine="cd.Initialize(Colors.RGB(21,176,220), 2dip)";
_cd.Initialize(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (21),(int) (176),(int) (220)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)));
RDebugUtils.currentLine=1048780;
 //BA.debugLineNum = 1048780;BA.debugLine="refStatus.Background = cd";
_refstatus.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
 break; }
case 8: {
RDebugUtils.currentLine=1048782;
 //BA.debugLineNum = 1048782;BA.debugLine="cd.Initialize(Colors.RGB(38,143,235), 2dip)";
_cd.Initialize(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (38),(int) (143),(int) (235)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)));
RDebugUtils.currentLine=1048783;
 //BA.debugLineNum = 1048783;BA.debugLine="refStatus.Background = cd";
_refstatus.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
 break; }
default: {
RDebugUtils.currentLine=1048785;
 //BA.debugLineNum = 1048785;BA.debugLine="cd.Initialize(Colors.RGB(3,117,216), 2dip)";
_cd.Initialize(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (3),(int) (117),(int) (216)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)));
RDebugUtils.currentLine=1048786;
 //BA.debugLineNum = 1048786;BA.debugLine="refStatus.Background = cd";
_refstatus.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
 break; }
}
;
RDebugUtils.currentLine=1048789;
 //BA.debugLineNum = 1048789;BA.debugLine="refStatus.Text = ToMixCase(rStatus.Replace(\"_\",";
_refstatus.setText((Object)(_tomixcase(_rstatus.replace("_"," "))));
RDebugUtils.currentLine=1048790;
 //BA.debugLineNum = 1048790;BA.debugLine="refStatus.TextColor = Colors.White";
_refstatus.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=1048793;
 //BA.debugLineNum = 1048793;BA.debugLine="refStatus.Gravity = Gravity.CENTER";
_refstatus.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=1048795;
 //BA.debugLineNum = 1048795;BA.debugLine="ReferencePanel.AddView(refStatus,38dip,refCompa";
_referencepanel.AddView((android.view.View)(_refstatus.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (38)),(int) (_refcompany.getTop()+_refcompany.getHeight()+_gap),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)));
RDebugUtils.currentLine=1048796;
 //BA.debugLineNum = 1048796;BA.debugLine="Dim refStatusHeight As Int";
_refstatusheight = 0;
RDebugUtils.currentLine=1048797;
 //BA.debugLineNum = 1048797;BA.debugLine="refStatusHeight =  su.MeasureMultilineTextHeigh";
_refstatusheight = mostCurrent._su.MeasureMultilineTextHeight((android.widget.TextView)(_refstatus.getObject()),_refstatus.getText());
RDebugUtils.currentLine=1048799;
 //BA.debugLineNum = 1048799;BA.debugLine="If refStatusHeight > refStatus.Height Then";
if (_refstatusheight>_refstatus.getHeight()) { 
RDebugUtils.currentLine=1048800;
 //BA.debugLineNum = 1048800;BA.debugLine="refStatus.Height = refStatusHeight";
_refstatus.setHeight(_refstatusheight);
RDebugUtils.currentLine=1048801;
 //BA.debugLineNum = 1048801;BA.debugLine="ReferencePanel.Height = ReferenceHeight + Gap";
_referencepanel.setHeight((int) (_referenceheight+_gap));
 };
RDebugUtils.currentLine=1048815;
 //BA.debugLineNum = 1048815;BA.debugLine="Dim sld As StateListDrawable";
_sld = new anywheresoftware.b4a.objects.drawable.StateListDrawable();
RDebugUtils.currentLine=1048816;
 //BA.debugLineNum = 1048816;BA.debugLine="Dim pressed As ColorDrawable";
_pressed = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
RDebugUtils.currentLine=1048817;
 //BA.debugLineNum = 1048817;BA.debugLine="pressed.Initialize(Colors.RGB(255, 255, 255)";
_pressed.Initialize(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (255),(int) (255),(int) (255)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)));
RDebugUtils.currentLine=1048819;
 //BA.debugLineNum = 1048819;BA.debugLine="sld.Initialize";
_sld.Initialize();
RDebugUtils.currentLine=1048820;
 //BA.debugLineNum = 1048820;BA.debugLine="sld.AddState(sld.State_Pressed,pressed)";
_sld.AddState(_sld.State_Pressed,(android.graphics.drawable.Drawable)(_pressed.getObject()));
RDebugUtils.currentLine=1048823;
 //BA.debugLineNum = 1048823;BA.debugLine="detailButton.Initialize(\"detailBtn\")";
_detailbutton.Initialize(mostCurrent.activityBA,"detailBtn");
RDebugUtils.currentLine=1048824;
 //BA.debugLineNum = 1048824;BA.debugLine="detailButton.Typeface = font.awesome.FontAwesom";
_detailbutton.setTypeface((android.graphics.Typeface)(mostCurrent._font._awesome(null)._fontawesometypeface().getObject()));
RDebugUtils.currentLine=1048825;
 //BA.debugLineNum = 1048825;BA.debugLine="detailButton.Tag = userId";
_detailbutton.setTag((Object)(_userid));
RDebugUtils.currentLine=1048826;
 //BA.debugLineNum = 1048826;BA.debugLine="detailButton.Text = \"Detail Progress \"&font.awe";
_detailbutton.setText((Object)("Detail Progress "+mostCurrent._font._awesome(null)._getfontawesomeiconbyname("fa-arrow-right")));
RDebugUtils.currentLine=1048827;
 //BA.debugLineNum = 1048827;BA.debugLine="detailButton.TextSize = JobTitle.TextSize / 1.4";
_detailbutton.setTextSize((float) (_jobtitle.getTextSize()/(double)1.4));
RDebugUtils.currentLine=1048828;
 //BA.debugLineNum = 1048828;BA.debugLine="detailButton.TextColor = Colors.RGB(22,176,221)";
_detailbutton.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (22),(int) (176),(int) (221)));
RDebugUtils.currentLine=1048829;
 //BA.debugLineNum = 1048829;BA.debugLine="detailButton.Gravity = Gravity.CENTER";
_detailbutton.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=1048830;
 //BA.debugLineNum = 1048830;BA.debugLine="detailButton.Background = sld";
_detailbutton.setBackground((android.graphics.drawable.Drawable)(_sld.getObject()));
RDebugUtils.currentLine=1048841;
 //BA.debugLineNum = 1048841;BA.debugLine="detailList.Add(detailButton)";
mostCurrent._detaillist.Add((Object)(_detailbutton.getObject()));
RDebugUtils.currentLine=1048844;
 //BA.debugLineNum = 1048844;BA.debugLine="ReferencePanel.AddView(detailButton,(ReferenceP";
_referencepanel.AddView((android.view.View)(_detailbutton.getObject()),(int) ((_referencepanel.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (125)))-_gap),(int) (_refcompany.getTop()+_refcompany.getHeight()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (125)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (35)));
RDebugUtils.currentLine=1048846;
 //BA.debugLineNum = 1048846;BA.debugLine="ReferenceTop = ReferenceTop+ReferenceHeight+Gap";
_referencetop = (int) (_referencetop+_referenceheight+_gap);
 }
;
RDebugUtils.currentLine=1048849;
 //BA.debugLineNum = 1048849;BA.debugLine="Container.AddView(JoblistPanel,0,PanelTop,Contai";
_container.AddView((android.view.View)(_joblistpanel.getObject()),(int) (0),_paneltop,_container.getWidth(),_panelheight);
RDebugUtils.currentLine=1048850;
 //BA.debugLineNum = 1048850;BA.debugLine="PanelTop = PanelTop+PanelHeight+Gap";
_paneltop = (int) (_paneltop+_panelheight+_gap);
RDebugUtils.currentLine=1048851;
 //BA.debugLineNum = 1048851;BA.debugLine="PanelHeight = defaultPanelHeight";
_panelheight = _defaultpanelheight;
 }
;
RDebugUtils.currentLine=1048855;
 //BA.debugLineNum = 1048855;BA.debugLine="Dim sld As StateListDrawable";
_sld = new anywheresoftware.b4a.objects.drawable.StateListDrawable();
RDebugUtils.currentLine=1048856;
 //BA.debugLineNum = 1048856;BA.debugLine="Dim pressed,enabled As ColorDrawable";
_pressed = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
_enabled = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
RDebugUtils.currentLine=1048857;
 //BA.debugLineNum = 1048857;BA.debugLine="pressed.Initialize(Colors.RGB(105, 203, 231), 2di";
_pressed.Initialize(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (105),(int) (203),(int) (231)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)));
RDebugUtils.currentLine=1048858;
 //BA.debugLineNum = 1048858;BA.debugLine="enabled.Initialize(Colors.RGB(22,176,221), 2dip)";
_enabled.Initialize(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (22),(int) (176),(int) (221)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)));
RDebugUtils.currentLine=1048860;
 //BA.debugLineNum = 1048860;BA.debugLine="sld.Initialize";
_sld.Initialize();
RDebugUtils.currentLine=1048861;
 //BA.debugLineNum = 1048861;BA.debugLine="sld.AddState(sld.State_Pressed,pressed)";
_sld.AddState(_sld.State_Pressed,(android.graphics.drawable.Drawable)(_pressed.getObject()));
RDebugUtils.currentLine=1048862;
 //BA.debugLineNum = 1048862;BA.debugLine="sld.AddState(sld.State_Enabled,enabled)";
_sld.AddState(_sld.State_Enabled,(android.graphics.drawable.Drawable)(_enabled.getObject()));
RDebugUtils.currentLine=1048864;
 //BA.debugLineNum = 1048864;BA.debugLine="loadMore.Initialize(\"loadMore\")";
mostCurrent._loadmore.Initialize(mostCurrent.activityBA,"loadMore");
RDebugUtils.currentLine=1048865;
 //BA.debugLineNum = 1048865;BA.debugLine="loadMore.Text = \"Load More\"";
mostCurrent._loadmore.setText((Object)("Load More"));
RDebugUtils.currentLine=1048866;
 //BA.debugLineNum = 1048866;BA.debugLine="loadMore.Background = sld";
mostCurrent._loadmore.setBackground((android.graphics.drawable.Drawable)(_sld.getObject()));
RDebugUtils.currentLine=1048867;
 //BA.debugLineNum = 1048867;BA.debugLine="loadMore.TextColor = Colors.White";
mostCurrent._loadmore.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=1048868;
 //BA.debugLineNum = 1048868;BA.debugLine="loadMore.Gravity = Gravity.CENTER";
mostCurrent._loadmore.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=1048869;
 //BA.debugLineNum = 1048869;BA.debugLine="loadMore.Tag = PanelTop";
mostCurrent._loadmore.setTag((Object)(_paneltop));
RDebugUtils.currentLine=1048872;
 //BA.debugLineNum = 1048872;BA.debugLine="Container.Height = PanelTop' + 50dip";
_container.setHeight(_paneltop);
RDebugUtils.currentLine=1048873;
 //BA.debugLineNum = 1048873;BA.debugLine="End Sub";
return "";
}
public static String  _loadmore_click() throws Exception{
RDebugUtils.currentModule="referringlist";
if (Debug.shouldDelegate(mostCurrent.activityBA, "loadmore_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "loadmore_click", null);
RDebugUtils.currentLine=1310720;
 //BA.debugLineNum = 1310720;BA.debugLine="Sub loadMore_Click";
RDebugUtils.currentLine=1310721;
 //BA.debugLineNum = 1310721;BA.debugLine="loadMore = Sender";
mostCurrent._loadmore.setObject((android.widget.Button)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=1310722;
 //BA.debugLineNum = 1310722;BA.debugLine="loadMore.Text = \"Loading...\"";
mostCurrent._loadmore.setText((Object)("Loading..."));
RDebugUtils.currentLine=1310723;
 //BA.debugLineNum = 1310723;BA.debugLine="loadMore.Color = Colors.Gray";
mostCurrent._loadmore.setColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=1310724;
 //BA.debugLineNum = 1310724;BA.debugLine="Sleep(1200)";
_sleep((long) (1200));
RDebugUtils.currentLine=1310725;
 //BA.debugLineNum = 1310725;BA.debugLine="loadMore.Visible = False";
mostCurrent._loadmore.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1310726;
 //BA.debugLineNum = 1310726;BA.debugLine="loadMoreTop = loadMore.Tag";
_loadmoretop = (int)(BA.ObjectToNumber(mostCurrent._loadmore.getTag()));
RDebugUtils.currentLine=1310727;
 //BA.debugLineNum = 1310727;BA.debugLine="Api.Get(\"/referrals/list\")";
mostCurrent._api._get(null,"/referrals/list");
RDebugUtils.currentLine=1310728;
 //BA.debugLineNum = 1310728;BA.debugLine="End Sub";
return "";
}
public static String  _sleep(long _ms) throws Exception{
RDebugUtils.currentModule="referringlist";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sleep"))
	return (String) Debug.delegate(mostCurrent.activityBA, "sleep", new Object[] {_ms});
long _now = 0L;
RDebugUtils.currentLine=1376256;
 //BA.debugLineNum = 1376256;BA.debugLine="Sub Sleep(ms As Long)";
RDebugUtils.currentLine=1376257;
 //BA.debugLineNum = 1376257;BA.debugLine="Dim now As Long";
_now = 0L;
RDebugUtils.currentLine=1376258;
 //BA.debugLineNum = 1376258;BA.debugLine="If ms > 1000 Then ms =1000   'avoid application";
if (_ms>1000) { 
_ms = (long) (1000);};
RDebugUtils.currentLine=1376259;
 //BA.debugLineNum = 1376259;BA.debugLine="now=DateTime.Now";
_now = anywheresoftware.b4a.keywords.Common.DateTime.getNow();
RDebugUtils.currentLine=1376260;
 //BA.debugLineNum = 1376260;BA.debugLine="Do Until (DateTime.Now>now+ms)";
while (!((anywheresoftware.b4a.keywords.Common.DateTime.getNow()>_now+_ms))) {
RDebugUtils.currentLine=1376261;
 //BA.debugLineNum = 1376261;BA.debugLine="DoEvents";
anywheresoftware.b4a.keywords.Common.DoEvents();
 }
;
RDebugUtils.currentLine=1376263;
 //BA.debugLineNum = 1376263;BA.debugLine="End Sub";
return "";
}
public static String  _tomixcase(String _entry) throws Exception{
RDebugUtils.currentModule="referringlist";
if (Debug.shouldDelegate(mostCurrent.activityBA, "tomixcase"))
	return (String) Debug.delegate(mostCurrent.activityBA, "tomixcase", new Object[] {_entry});
anywheresoftware.b4a.keywords.StringBuilderWrapper _sb = null;
anywheresoftware.b4a.keywords.Regex.MatcherWrapper _m = null;
int _i = 0;
RDebugUtils.currentLine=1638400;
 //BA.debugLineNum = 1638400;BA.debugLine="Sub ToMixCase(Entry As String) As String";
RDebugUtils.currentLine=1638402;
 //BA.debugLineNum = 1638402;BA.debugLine="Dim sb As StringBuilder";
_sb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
RDebugUtils.currentLine=1638403;
 //BA.debugLineNum = 1638403;BA.debugLine="Dim m As Matcher";
_m = new anywheresoftware.b4a.keywords.Regex.MatcherWrapper();
RDebugUtils.currentLine=1638404;
 //BA.debugLineNum = 1638404;BA.debugLine="Dim I As Int";
_i = 0;
RDebugUtils.currentLine=1638406;
 //BA.debugLineNum = 1638406;BA.debugLine="Entry = Entry.ToLowerCase";
_entry = _entry.toLowerCase();
RDebugUtils.currentLine=1638408;
 //BA.debugLineNum = 1638408;BA.debugLine="sb.Initialize";
_sb.Initialize();
RDebugUtils.currentLine=1638410;
 //BA.debugLineNum = 1638410;BA.debugLine="m = Regex.Matcher(\"(^\\w)|(\\s\\w)\", Entry)";
_m = anywheresoftware.b4a.keywords.Common.Regex.Matcher("(^\\w)|(\\s\\w)",_entry);
RDebugUtils.currentLine=1638412;
 //BA.debugLineNum = 1638412;BA.debugLine="Do While m.Find";
while (_m.Find()) {
RDebugUtils.currentLine=1638414;
 //BA.debugLineNum = 1638414;BA.debugLine="If m.Match.Length > 1 Then";
if (_m.getMatch().length()>1) { 
RDebugUtils.currentLine=1638416;
 //BA.debugLineNum = 1638416;BA.debugLine="sb.Append(Entry.SubString2(I, m.GetStart";
_sb.Append(_entry.substring(_i,(int) (_m.GetStart((int) (0))+1)));
RDebugUtils.currentLine=1638417;
 //BA.debugLineNum = 1638417;BA.debugLine="sb.Append(m.Match.SubString(1).ToUpperCa";
_sb.Append(_m.getMatch().substring((int) (1)).toUpperCase());
 }else {
RDebugUtils.currentLine=1638421;
 //BA.debugLineNum = 1638421;BA.debugLine="sb.Append(Entry.SubString2(I, m.GetStart";
_sb.Append(_entry.substring(_i,_m.GetStart((int) (0))));
RDebugUtils.currentLine=1638422;
 //BA.debugLineNum = 1638422;BA.debugLine="sb.Append(m.Match.ToUpperCase)";
_sb.Append(_m.getMatch().toUpperCase());
 };
RDebugUtils.currentLine=1638426;
 //BA.debugLineNum = 1638426;BA.debugLine="I = m.GetEnd(0)";
_i = _m.GetEnd((int) (0));
 }
;
RDebugUtils.currentLine=1638430;
 //BA.debugLineNum = 1638430;BA.debugLine="If I < Entry.Length Then";
if (_i<_entry.length()) { 
RDebugUtils.currentLine=1638432;
 //BA.debugLineNum = 1638432;BA.debugLine="sb.Append(Entry.SubString(I))";
_sb.Append(_entry.substring(_i));
 };
RDebugUtils.currentLine=1638436;
 //BA.debugLineNum = 1638436;BA.debugLine="Return sb.ToString";
if (true) return _sb.ToString();
RDebugUtils.currentLine=1638438;
 //BA.debugLineNum = 1638438;BA.debugLine="End Sub";
return "";
}
public static String  _searchitem_click() throws Exception{
RDebugUtils.currentModule="referringlist";
if (Debug.shouldDelegate(mostCurrent.activityBA, "searchitem_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "searchitem_click", null);
RDebugUtils.currentLine=1114112;
 //BA.debugLineNum = 1114112;BA.debugLine="Sub SearchItem_Click";
RDebugUtils.currentLine=1114113;
 //BA.debugLineNum = 1114113;BA.debugLine="qAuth.Logout";
mostCurrent._qauth._logout(null);
RDebugUtils.currentLine=1114114;
 //BA.debugLineNum = 1114114;BA.debugLine="End Sub";
return "";
}
}