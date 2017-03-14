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
			processBA = new BA(this.getApplicationContext(), null, null, "com.qolega.qolegapp", "com.qolega.qolegapp.referringlist");
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

public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public static String  _activity_create(boolean _firsttime) throws Exception{
 //BA.debugLineNum = 27;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 29;BA.debugLine="qAuth.Initialize(Activity)";
mostCurrent._qauth._initialize(mostCurrent.activityBA,mostCurrent._activity);
 //BA.debugLineNum = 30;BA.debugLine="font.Initialize";
mostCurrent._font._initialize(processBA);
 //BA.debugLineNum = 31;BA.debugLine="Api.Initialize(\"refferingList\",Me)";
mostCurrent._api._initialize(processBA,"refferingList",referringlist.getObject());
 //BA.debugLineNum = 35;BA.debugLine="Activity.AddMenuItem3(\"SearchItem\", \"SearchItem\",";
mostCurrent._activity.AddMenuItem3("SearchItem","SearchItem",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"Logout.png").getObject()),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 36;BA.debugLine="scrollView.Initialize(Activity.Height)";
mostCurrent._scrollview.Initialize(mostCurrent.activityBA,mostCurrent._activity.getHeight());
 //BA.debugLineNum = 37;BA.debugLine="scrollView.Color = Colors.RGB(246,246,246)";
mostCurrent._scrollview.setColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (246),(int) (246),(int) (246)));
 //BA.debugLineNum = 38;BA.debugLine="Activity.AddView(scrollView,0,0,100%x,100%y)";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._scrollview.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 39;BA.debugLine="detailList.Initialize";
mostCurrent._detaillist.Initialize();
 //BA.debugLineNum = 40;BA.debugLine="resultList.Initialize";
mostCurrent._resultlist.Initialize();
 //BA.debugLineNum = 45;BA.debugLine="Api.Get(\"/referrals/list/\"&qAuth.GetStore(\"id\"))";
mostCurrent._api._get("/referrals/list/"+mostCurrent._qauth._getstore("id"));
 //BA.debugLineNum = 46;BA.debugLine="ProgressDialogShow2(\"Loading Data\",False)";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow2(mostCurrent.activityBA,"Loading Data",anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 47;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 369;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 371;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 365;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 367;BA.debugLine="End Sub";
return "";
}
public static String  _detailbtn_click() throws Exception{
int _i = 0;
anywheresoftware.b4a.objects.ButtonWrapper _detailbtn = null;
 //BA.debugLineNum = 392;BA.debugLine="Sub detailBtn_Click";
 //BA.debugLineNum = 393;BA.debugLine="For i = 0 To detailList.Size - 1";
{
final int step1 = 1;
final int limit1 = (int) (mostCurrent._detaillist.getSize()-1);
for (_i = (int) (0) ; (step1 > 0 && _i <= limit1) || (step1 < 0 && _i >= limit1); _i = ((int)(0 + _i + step1)) ) {
 //BA.debugLineNum = 394;BA.debugLine="Dim detailBtn As Button";
_detailbtn = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 395;BA.debugLine="detailBtn = detailList.Get(i)";
_detailbtn.setObject((android.widget.Button)(mostCurrent._detaillist.Get(_i)));
 //BA.debugLineNum = 396;BA.debugLine="detailBtn = Sender";
_detailbtn.setObject((android.widget.Button)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
 }
};
 //BA.debugLineNum = 400;BA.debugLine="ReferringProgress.userId = detailBtn.Tag";
mostCurrent._referringprogress._userid = (int)(BA.ObjectToNumber(_detailbtn.getTag()));
 //BA.debugLineNum = 401;BA.debugLine="StartActivity(ReferringProgress)";
anywheresoftware.b4a.keywords.Common.StartActivity(mostCurrent.activityBA,(Object)(mostCurrent._referringprogress.getObject()));
 //BA.debugLineNum = 403;BA.debugLine="End Sub";
return "";
}
public static String  _detailbtn_down() throws Exception{
int _i = 0;
anywheresoftware.b4a.objects.ButtonWrapper _detailbtn = null;
 //BA.debugLineNum = 405;BA.debugLine="Sub detailBtn_Down";
 //BA.debugLineNum = 406;BA.debugLine="For i = 0 To detailList.Size - 1";
{
final int step1 = 1;
final int limit1 = (int) (mostCurrent._detaillist.getSize()-1);
for (_i = (int) (0) ; (step1 > 0 && _i <= limit1) || (step1 < 0 && _i >= limit1); _i = ((int)(0 + _i + step1)) ) {
 //BA.debugLineNum = 407;BA.debugLine="Dim detailBtn As Button";
_detailbtn = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 408;BA.debugLine="detailBtn = detailList.Get(i)";
_detailbtn.setObject((android.widget.Button)(mostCurrent._detaillist.Get(_i)));
 //BA.debugLineNum = 409;BA.debugLine="detailBtn = Sender";
_detailbtn.setObject((android.widget.Button)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
 }
};
 //BA.debugLineNum = 412;BA.debugLine="detailBtn.TextColor = Colors.RGB(105, 203, 231)";
_detailbtn.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (105),(int) (203),(int) (231)));
 //BA.debugLineNum = 413;BA.debugLine="End Sub";
return "";
}
public static String  _detailbtn_up() throws Exception{
int _i = 0;
anywheresoftware.b4a.objects.ButtonWrapper _detailbtn = null;
 //BA.debugLineNum = 415;BA.debugLine="Sub detailBtn_Up";
 //BA.debugLineNum = 416;BA.debugLine="For i = 0 To detailList.Size - 1";
{
final int step1 = 1;
final int limit1 = (int) (mostCurrent._detaillist.getSize()-1);
for (_i = (int) (0) ; (step1 > 0 && _i <= limit1) || (step1 < 0 && _i >= limit1); _i = ((int)(0 + _i + step1)) ) {
 //BA.debugLineNum = 417;BA.debugLine="Dim detailBtn As Button";
_detailbtn = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 418;BA.debugLine="detailBtn = detailList.Get(i)";
_detailbtn.setObject((android.widget.Button)(mostCurrent._detaillist.Get(_i)));
 //BA.debugLineNum = 419;BA.debugLine="detailBtn = Sender";
_detailbtn.setObject((android.widget.Button)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
 }
};
 //BA.debugLineNum = 422;BA.debugLine="detailBtn.TextColor = Colors.RGB(22,176,221)";
_detailbtn.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (22),(int) (176),(int) (221)));
 //BA.debugLineNum = 423;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 11;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 14;BA.debugLine="Dim scrollView As ScrollView";
mostCurrent._scrollview = new anywheresoftware.b4a.objects.ScrollViewWrapper();
 //BA.debugLineNum = 15;BA.debugLine="Dim JSON As JSONParser";
mostCurrent._json = new anywheresoftware.b4a.objects.collections.JSONParser();
 //BA.debugLineNum = 16;BA.debugLine="Dim su As StringUtils";
mostCurrent._su = new anywheresoftware.b4a.objects.StringUtils();
 //BA.debugLineNum = 17;BA.debugLine="Dim detailList As List";
mostCurrent._detaillist = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 18;BA.debugLine="Dim resultList As List";
mostCurrent._resultlist = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 19;BA.debugLine="Dim qAuth As Auth";
mostCurrent._qauth = new com.qolega.qolegapp.auth();
 //BA.debugLineNum = 20;BA.debugLine="Dim font As Fonts";
mostCurrent._font = new com.qolega.qolegapp.fonts();
 //BA.debugLineNum = 21;BA.debugLine="Dim loadMore As Button";
mostCurrent._loadmore = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 22;BA.debugLine="Dim Api As Api";
mostCurrent._api = new com.qolega.qolegapp.api();
 //BA.debugLineNum = 24;BA.debugLine="Dim loadMoreTop = 10dip As Int";
_loadmoretop = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
 //BA.debugLineNum = 25;BA.debugLine="End Sub";
return "";
}
public static String  _jobdone(com.qolega.qolegapp.httpjob _job) throws Exception{
 //BA.debugLineNum = 49;BA.debugLine="Sub JobDone(Job As HttpJob)";
 //BA.debugLineNum = 50;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
 //BA.debugLineNum = 51;BA.debugLine="Log(\"JobName = \" & Job.JobName & \", Success = \"";
anywheresoftware.b4a.keywords.Common.Log("JobName = "+_job._jobname+", Success = "+BA.ObjectToString(_job._success));
 //BA.debugLineNum = 52;BA.debugLine="If Job.Success = True Then";
if (_job._success==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 53;BA.debugLine="LoopPanel(loadMoreTop,Job.GetString)";
_looppanel(_loadmoretop,_job._getstring());
 }else {
 //BA.debugLineNum = 55;BA.debugLine="Log(\"Error: \" & Job.ErrorMessage)";
anywheresoftware.b4a.keywords.Common.Log("Error: "+_job._errormessage);
 //BA.debugLineNum = 56;BA.debugLine="ToastMessageShow(\"Error: \" & Job.ErrorMessag";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("Error: "+_job._errormessage,anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 58;BA.debugLine="Job.Release";
_job._release();
 //BA.debugLineNum = 59;BA.debugLine="End Sub";
return "";
}
public static String  _loadmore_click() throws Exception{
 //BA.debugLineNum = 373;BA.debugLine="Sub loadMore_Click";
 //BA.debugLineNum = 374;BA.debugLine="loadMore = Sender";
mostCurrent._loadmore.setObject((android.widget.Button)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
 //BA.debugLineNum = 375;BA.debugLine="loadMore.Text = \"Loading...\"";
mostCurrent._loadmore.setText((Object)("Loading..."));
 //BA.debugLineNum = 376;BA.debugLine="loadMore.Color = Colors.Gray";
mostCurrent._loadmore.setColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
 //BA.debugLineNum = 377;BA.debugLine="Sleep(1200)";
_sleep((long) (1200));
 //BA.debugLineNum = 378;BA.debugLine="loadMore.Visible = False";
mostCurrent._loadmore.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 379;BA.debugLine="loadMoreTop = loadMore.Tag";
_loadmoretop = (int)(BA.ObjectToNumber(mostCurrent._loadmore.getTag()));
 //BA.debugLineNum = 380;BA.debugLine="Api.Get(\"/referrals/list\")";
mostCurrent._api._get("/referrals/list");
 //BA.debugLineNum = 381;BA.debugLine="End Sub";
return "";
}
public static String  _looppanel(int _starttop,String _data) throws Exception{
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
 //BA.debugLineNum = 62;BA.debugLine="Sub LoopPanel(StartTop As Int,Data As String)";
 //BA.debugLineNum = 63;BA.debugLine="Dim Bitmap1 As Bitmap";
_bitmap1 = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
 //BA.debugLineNum = 64;BA.debugLine="Dim Container As Panel";
_container = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 65;BA.debugLine="Dim JoblistPanel,ReferencePanel As Panel";
_joblistpanel = new anywheresoftware.b4a.objects.PanelWrapper();
_referencepanel = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 66;BA.debugLine="Dim PanelTop,defaultPanelHeight,PanelHeight,Refer";
_paneltop = 0;
_defaultpanelheight = 0;
_panelheight = 0;
_referencetop = 0;
_referenceheight = 0;
_gap = 0;
_textheight = 0;
 //BA.debugLineNum = 67;BA.debugLine="Dim JobTitle,Location,JobDesc,Currency,Commision";
_jobtitle = new anywheresoftware.b4a.objects.LabelWrapper();
_location = new anywheresoftware.b4a.objects.LabelWrapper();
_jobdesc = new anywheresoftware.b4a.objects.LabelWrapper();
_currency = new anywheresoftware.b4a.objects.LabelWrapper();
_commision = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 68;BA.debugLine="Dim locationIcon,industryIcon,moneyIcon As ImageV";
_locationicon = new anywheresoftware.b4a.objects.ImageViewWrapper();
_industryicon = new anywheresoftware.b4a.objects.ImageViewWrapper();
_moneyicon = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 71;BA.debugLine="PanelTop = StartTop";
_paneltop = _starttop;
 //BA.debugLineNum = 74;BA.debugLine="PanelHeight = 110dip";
_panelheight = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (110));
 //BA.debugLineNum = 75;BA.debugLine="defaultPanelHeight = PanelHeight";
_defaultpanelheight = _panelheight;
 //BA.debugLineNum = 77;BA.debugLine="Gap = 10dip";
_gap = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
 //BA.debugLineNum = 80;BA.debugLine="Container = scrollView.Panel";
_container = mostCurrent._scrollview.getPanel();
 //BA.debugLineNum = 81;BA.debugLine="Container.Color = Colors.RGB(219,219,219)";
_container.setColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (219),(int) (219),(int) (219)));
 //BA.debugLineNum = 84;BA.debugLine="JSON.Initialize(Data)";
mostCurrent._json.Initialize(_data);
 //BA.debugLineNum = 85;BA.debugLine="Dim root As List = JSON.NextArray";
_root = new anywheresoftware.b4a.objects.collections.List();
_root = mostCurrent._json.NextArray();
 //BA.debugLineNum = 87;BA.debugLine="For Each colroot As Map In root";
_colroot = new anywheresoftware.b4a.objects.collections.Map();
final anywheresoftware.b4a.BA.IterableList group15 = _root;
final int groupLen15 = group15.getSize();
for (int index15 = 0;index15 < groupLen15 ;index15++){
_colroot.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(group15.Get(index15)));
 //BA.debugLineNum = 89;BA.debugLine="Dim reference As List = colroot.Get(\"reference\")";
_reference = new anywheresoftware.b4a.objects.collections.List();
_reference.setObject((java.util.List)(_colroot.Get((Object)("reference"))));
 //BA.debugLineNum = 90;BA.debugLine="Dim job_title As String = colroot.Get(\"job_title";
_job_title = BA.ObjectToString(_colroot.Get((Object)("job_title")));
 //BA.debugLineNum = 91;BA.debugLine="Dim job_location As String = colroot.Get(\"locati";
_job_location = BA.ObjectToString(_colroot.Get((Object)("location")));
 //BA.debugLineNum = 92;BA.debugLine="Dim job_desc As String = colroot.Get(\"industry\")";
_job_desc = BA.ObjectToString(_colroot.Get((Object)("industry")));
 //BA.debugLineNum = 93;BA.debugLine="Dim job_commision As Double = colroot.Get(\"commi";
_job_commision = (double)(BA.ObjectToNumber(_colroot.Get((Object)("commision"))));
 //BA.debugLineNum = 96;BA.debugLine="JoblistPanel.Initialize(\"\")";
_joblistpanel.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 97;BA.debugLine="JobTitle.Initialize(\"JobTitle\")";
_jobtitle.Initialize(mostCurrent.activityBA,"JobTitle");
 //BA.debugLineNum = 98;BA.debugLine="Location.Initialize(\"Location\")";
_location.Initialize(mostCurrent.activityBA,"Location");
 //BA.debugLineNum = 99;BA.debugLine="JobDesc.Initialize(\"JobDesc\")";
_jobdesc.Initialize(mostCurrent.activityBA,"JobDesc");
 //BA.debugLineNum = 100;BA.debugLine="Currency.Initialize(\"Currency\")";
_currency.Initialize(mostCurrent.activityBA,"Currency");
 //BA.debugLineNum = 101;BA.debugLine="Commision.Initialize(\"Commision\")";
_commision.Initialize(mostCurrent.activityBA,"Commision");
 //BA.debugLineNum = 104;BA.debugLine="locationIcon.Initialize(\"\")";
_locationicon.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 105;BA.debugLine="industryIcon.Initialize(\"\")";
_industryicon.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 106;BA.debugLine="moneyIcon.Initialize(\"\")";
_moneyicon.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 109;BA.debugLine="locationIcon.Bitmap = LoadBitmap(File.DirAssets,";
_locationicon.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"location.png").getObject()));
 //BA.debugLineNum = 110;BA.debugLine="industryIcon.Bitmap = LoadBitmap(File.DirAssets,";
_industryicon.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"industry.png").getObject()));
 //BA.debugLineNum = 111;BA.debugLine="moneyIcon.Bitmap = LoadBitmap(File.DirAssets,\"mo";
_moneyicon.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"money.png").getObject()));
 //BA.debugLineNum = 113;BA.debugLine="locationIcon.Gravity = Gravity.FILL";
_locationicon.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 //BA.debugLineNum = 114;BA.debugLine="moneyIcon.Gravity = Gravity.FILL";
_moneyicon.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 //BA.debugLineNum = 115;BA.debugLine="industryIcon.Gravity = Gravity.FILL";
_industryicon.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 //BA.debugLineNum = 119;BA.debugLine="JobTitle.Typeface = font.proximanovaSemiBold";
_jobtitle.setTypeface((android.graphics.Typeface)(mostCurrent._font._proximanovasemibold().getObject()));
 //BA.debugLineNum = 120;BA.debugLine="JobTitle.Text = job_title";
_jobtitle.setText((Object)(_job_title));
 //BA.debugLineNum = 122;BA.debugLine="JobTitle.TextColor = Colors.RGB(74,74,74)";
_jobtitle.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (74),(int) (74),(int) (74)));
 //BA.debugLineNum = 125;BA.debugLine="Location.Typeface = font.proximanovaRegular";
_location.setTypeface((android.graphics.Typeface)(mostCurrent._font._proximanovaregular().getObject()));
 //BA.debugLineNum = 126;BA.debugLine="Location.Text = job_location";
_location.setText((Object)(_job_location));
 //BA.debugLineNum = 127;BA.debugLine="Location.TextColor = Colors.RGB(179,179,179)";
_location.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (179),(int) (179),(int) (179)));
 //BA.debugLineNum = 128;BA.debugLine="Location.TextSize = JobTitle.TextSize / 1.25";
_location.setTextSize((float) (_jobtitle.getTextSize()/(double)1.25));
 //BA.debugLineNum = 130;BA.debugLine="JobDesc.Typeface = font.proximanovaRegular";
_jobdesc.setTypeface((android.graphics.Typeface)(mostCurrent._font._proximanovaregular().getObject()));
 //BA.debugLineNum = 131;BA.debugLine="JobDesc.Text = job_desc";
_jobdesc.setText((Object)(_job_desc));
 //BA.debugLineNum = 132;BA.debugLine="JobDesc.TextColor = Colors.RGB(179,179,179)";
_jobdesc.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (179),(int) (179),(int) (179)));
 //BA.debugLineNum = 133;BA.debugLine="JobDesc.TextSize = JobTitle.TextSize / 1.25";
_jobdesc.setTextSize((float) (_jobtitle.getTextSize()/(double)1.25));
 //BA.debugLineNum = 135;BA.debugLine="Currency.Typeface = font.proximanovaSemiBold";
_currency.setTypeface((android.graphics.Typeface)(mostCurrent._font._proximanovasemibold().getObject()));
 //BA.debugLineNum = 136;BA.debugLine="Currency.Text = \"IDR \"&NumberFormat(job_commisio";
_currency.setText((Object)("IDR "+anywheresoftware.b4a.keywords.Common.NumberFormat(_job_commision,(int) (0),(int) (2))));
 //BA.debugLineNum = 137;BA.debugLine="Currency.TextColor = Colors.RGB(74,74,74)";
_currency.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (74),(int) (74),(int) (74)));
 //BA.debugLineNum = 139;BA.debugLine="Commision.Typeface = font.proximanovaRegular";
_commision.setTypeface((android.graphics.Typeface)(mostCurrent._font._proximanovaregular().getObject()));
 //BA.debugLineNum = 140;BA.debugLine="Commision.Text = \"Commision\"";
_commision.setText((Object)("Commision"));
 //BA.debugLineNum = 141;BA.debugLine="Commision.TextColor = Colors.RGB(179,179,179)";
_commision.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (179),(int) (179),(int) (179)));
 //BA.debugLineNum = 142;BA.debugLine="Commision.TextSize = JobTitle.TextSize / 1.25";
_commision.setTextSize((float) (_jobtitle.getTextSize()/(double)1.25));
 //BA.debugLineNum = 145;BA.debugLine="JoblistPanel.AddView(JobTitle,10dip,10dip,100%x-";
_joblistpanel.AddView((android.view.View)(_jobtitle.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),(int) (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA)-(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))*2)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)));
 //BA.debugLineNum = 146;BA.debugLine="TextHeight = su.MeasureMultilineTextHeight(JobTi";
_textheight = mostCurrent._su.MeasureMultilineTextHeight((android.widget.TextView)(_jobtitle.getObject()),_jobtitle.getText());
 //BA.debugLineNum = 149;BA.debugLine="JoblistPanel.AddView(locationIcon,12dip,TextHeig";
_joblistpanel.AddView((android.view.View)(_locationicon.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (12)),(int) (_textheight+_gap*1.5),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (9.6)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (12)));
 //BA.debugLineNum = 152;BA.debugLine="JoblistPanel.AddView(Location,30dip,TextHeight+G";
_joblistpanel.AddView((android.view.View)(_location.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)),(int) (_textheight+_gap*1.5),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)));
 //BA.debugLineNum = 153;BA.debugLine="TextHeight = TextHeight + su.MeasureMultilineTex";
_textheight = (int) (_textheight+mostCurrent._su.MeasureMultilineTextHeight((android.widget.TextView)(_location.getObject()),_location.getText()));
 //BA.debugLineNum = 156;BA.debugLine="JoblistPanel.AddView(industryIcon,11dip,TextHeig";
_joblistpanel.AddView((android.view.View)(_industryicon.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (11)),(int) (_textheight+_gap*1.8),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (12)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (12)));
 //BA.debugLineNum = 158;BA.debugLine="JoblistPanel.AddView(JobDesc,30dip,TextHeight+Ga";
_joblistpanel.AddView((android.view.View)(_jobdesc.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)),(int) (_textheight+_gap*1.8),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)));
 //BA.debugLineNum = 159;BA.debugLine="TextHeight = TextHeight + su.MeasureMultilineTex";
_textheight = (int) (_textheight+mostCurrent._su.MeasureMultilineTextHeight((android.widget.TextView)(_jobdesc.getObject()),_jobdesc.getText()));
 //BA.debugLineNum = 162;BA.debugLine="JoblistPanel.AddView(moneyIcon,10dip,TextHeight+";
_joblistpanel.AddView((android.view.View)(_moneyicon.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),(int) (_textheight+_gap*2.2),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (14)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (11.2)));
 //BA.debugLineNum = 164;BA.debugLine="JoblistPanel.AddView(Currency,30.9dip,TextHeight";
_joblistpanel.AddView((android.view.View)(_currency.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30.9)),(int) (_textheight+_gap*2),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (105)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)));
 //BA.debugLineNum = 166;BA.debugLine="Dim Canv As Canvas";
_canv = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();
 //BA.debugLineNum = 167;BA.debugLine="Canv.Initialize(Currency)";
_canv.Initialize((android.view.View)(_currency.getObject()));
 //BA.debugLineNum = 168;BA.debugLine="Dim newCurrencyWidth = Canv.MeasureStringWidth(C";
_newcurrencywidth = (int) (_canv.MeasureStringWidth(_currency.getText(),(android.graphics.Typeface)(mostCurrent._font._proximanovaregular().getObject()),_currency.getTextSize()));
 //BA.debugLineNum = 169;BA.debugLine="Currency.Width = newCurrencyWidth+Gap/2";
_currency.setWidth((int) (_newcurrencywidth+_gap/(double)2));
 //BA.debugLineNum = 171;BA.debugLine="JoblistPanel.AddView(Commision,Currency.Width+Cu";
_joblistpanel.AddView((android.view.View)(_commision.getObject()),(int) (_currency.getWidth()+_currency.getLeft()),(int) (_textheight+_gap*2.2),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)));
 //BA.debugLineNum = 172;BA.debugLine="TextHeight = TextHeight + su.MeasureMultilineTex";
_textheight = (int) (_textheight+mostCurrent._su.MeasureMultilineTextHeight((android.widget.TextView)(_currency.getObject()),_currency.getText()));
 //BA.debugLineNum = 174;BA.debugLine="JoblistPanel.Color=Colors.RGB(255,255,255)";
_joblistpanel.setColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 177;BA.debugLine="ReferenceTop = TextHeight+Gap*3";
_referencetop = (int) (_textheight+_gap*3);
 //BA.debugLineNum = 179;BA.debugLine="ReferenceHeight = 92dip";
_referenceheight = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (92));
 //BA.debugLineNum = 182;BA.debugLine="Dim SizeOfRef As Int = reference.Size";
_sizeofref = _reference.getSize();
 //BA.debugLineNum = 186;BA.debugLine="PanelHeight = PanelHeight+(ReferenceHeight*SizeO";
_panelheight = (int) (_panelheight+(_referenceheight*_sizeofref)+(_gap*_sizeofref));
 //BA.debugLineNum = 188;BA.debugLine="For Each colreference As Map In reference";
_colreference = new anywheresoftware.b4a.objects.collections.Map();
final anywheresoftware.b4a.BA.IterableList group75 = _reference;
final int groupLen75 = group75.getSize();
for (int index75 = 0;index75 < groupLen75 ;index75++){
_colreference.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(group75.Get(index75)));
 //BA.debugLineNum = 189;BA.debugLine="Dim refName,refCompany,refStatus,detailBtn,refD";
_refname = new anywheresoftware.b4a.objects.LabelWrapper();
_refcompany = new anywheresoftware.b4a.objects.LabelWrapper();
_refstatus = new anywheresoftware.b4a.objects.LabelWrapper();
_detailbtn = new anywheresoftware.b4a.objects.LabelWrapper();
_refday = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 190;BA.debugLine="Dim detailButton As Button";
_detailbutton = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 191;BA.debugLine="Dim statusRef As String";
_statusref = "";
 //BA.debugLineNum = 192;BA.debugLine="Dim rHeight,statusRefColor As Int";
_rheight = 0;
_statusrefcolor = 0;
 //BA.debugLineNum = 193;BA.debugLine="Dim userIcon As ImageView";
_usericon = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 196;BA.debugLine="Dim rName As String = colreference.Get(\"name\")";
_rname = BA.ObjectToString(_colreference.Get((Object)("name")));
 //BA.debugLineNum = 197;BA.debugLine="Dim rCompany As String = colreference.Get(\"comp";
_rcompany = BA.ObjectToString(_colreference.Get((Object)("company")));
 //BA.debugLineNum = 198;BA.debugLine="Dim rStatus As String = colreference.Get(\"statu";
_rstatus = BA.ObjectToString(_colreference.Get((Object)("status")));
 //BA.debugLineNum = 200;BA.debugLine="Dim userId As Int = colreference.Get(\"user_id\")";
_userid = (int)(BA.ObjectToNumber(_colreference.Get((Object)("user_id"))));
 //BA.debugLineNum = 201;BA.debugLine="Dim daysAgo As String = colreference.Get(\"days_";
_daysago = BA.ObjectToString(_colreference.Get((Object)("days_ago")));
 //BA.debugLineNum = 204;BA.debugLine="userIcon.Initialize(\"\")";
_usericon.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 205;BA.debugLine="userIcon.Bitmap = LoadBitmap(File.DirAssets,\"us";
_usericon.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"user.png").getObject()));
 //BA.debugLineNum = 206;BA.debugLine="userIcon.Gravity = Gravity.FILL";
_usericon.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 //BA.debugLineNum = 207;BA.debugLine="ReferencePanel.Initialize(\"\")";
_referencepanel.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 209;BA.debugLine="JoblistPanel.AddView(ReferencePanel,25dip,Refer";
_joblistpanel.AddView((android.view.View)(_referencepanel.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25)),_referencetop,(int) (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA)-(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25))*2)),_referenceheight);
 //BA.debugLineNum = 211;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
 //BA.debugLineNum = 213;BA.debugLine="cd.Initialize2(Colors.White, 3dip, 1.9dip, Colo";
_cd.Initialize2(anywheresoftware.b4a.keywords.Common.Colors.White,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (3)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1.9)),anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (218),(int) (218),(int) (218)));
 //BA.debugLineNum = 214;BA.debugLine="ReferencePanel.Background = cd";
_referencepanel.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
 //BA.debugLineNum = 219;BA.debugLine="ReferencePanel.AddView(userIcon,10dip,10dip,24d";
_referencepanel.AddView((android.view.View)(_usericon.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (24)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (24)));
 //BA.debugLineNum = 220;BA.debugLine="refName.Initialize(\"\")";
_refname.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 221;BA.debugLine="refName.Text = rName";
_refname.setText((Object)(_rname));
 //BA.debugLineNum = 222;BA.debugLine="refName.TextColor = Colors.RGB(74,74,74)";
_refname.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (74),(int) (74),(int) (74)));
 //BA.debugLineNum = 224;BA.debugLine="refName.Typeface = font.proximanovaSemiBold";
_refname.setTypeface((android.graphics.Typeface)(mostCurrent._font._proximanovasemibold().getObject()));
 //BA.debugLineNum = 225;BA.debugLine="refName.Gravity = Gravity.CENTER_VERTICAL";
_refname.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
 //BA.debugLineNum = 226;BA.debugLine="ReferencePanel.AddView(refName,38dip,12dip,Refe";
_referencepanel.AddView((android.view.View)(_refname.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (38)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (12)),(int) (_referencepanel.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (38))*2),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)));
 //BA.debugLineNum = 229;BA.debugLine="refDay.Initialize(\"\")";
_refday.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 230;BA.debugLine="refDay.Text = daysAgo&\"d\"";
_refday.setText((Object)(_daysago+"d"));
 //BA.debugLineNum = 231;BA.debugLine="refDay.Typeface = font.proximanovaRegular";
_refday.setTypeface((android.graphics.Typeface)(mostCurrent._font._proximanovaregular().getObject()));
 //BA.debugLineNum = 232;BA.debugLine="refDay.TextColor = Colors.RGB(179,179,179)";
_refday.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (179),(int) (179),(int) (179)));
 //BA.debugLineNum = 233;BA.debugLine="refDay.Gravity = Gravity.CENTER";
_refday.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
 //BA.debugLineNum = 234;BA.debugLine="refDay.TextSize = refName.TextSize / 1.25";
_refday.setTextSize((float) (_refname.getTextSize()/(double)1.25));
 //BA.debugLineNum = 235;BA.debugLine="ReferencePanel.AddView(refDay,ReferencePanel.Wi";
_referencepanel.AddView((android.view.View)(_refday.getObject()),(int) (_referencepanel.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))-_gap),_refname.getTop(),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)),_refname.getHeight());
 //BA.debugLineNum = 239;BA.debugLine="refCompany.Initialize(\"\")";
_refcompany.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 240;BA.debugLine="refCompany.Text = rCompany";
_refcompany.setText((Object)(_rcompany));
 //BA.debugLineNum = 241;BA.debugLine="refCompany.TextColor = Colors.RGB(179,179,179)";
_refcompany.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (179),(int) (179),(int) (179)));
 //BA.debugLineNum = 242;BA.debugLine="refCompany.TextSize = JobTitle.TextSize / 1.25";
_refcompany.setTextSize((float) (_jobtitle.getTextSize()/(double)1.25));
 //BA.debugLineNum = 243;BA.debugLine="refCompany.Gravity = Gravity.CENTER_VERTICAL";
_refcompany.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
 //BA.debugLineNum = 244;BA.debugLine="ReferencePanel.AddView(refCompany,38dip,refName";
_referencepanel.AddView((android.view.View)(_refcompany.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (38)),(int) (_refname.getHeight()+_refname.getTop()),(int) (_referencepanel.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (38))*2),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)));
 //BA.debugLineNum = 247;BA.debugLine="refStatus.Initialize(\"\")";
_refstatus.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 248;BA.debugLine="Select rStatus";
switch (BA.switchObjectToInt(_rstatus,"qualifying","interview_by_consultant","sent_to_client","1st_interview","2nd_interview","3rd_interview","follow_up","hired","1st_day")) {
case 0: {
 //BA.debugLineNum = 250;BA.debugLine="cd.Initialize(Colors.RGB(249,128,55), 2dip)";
_cd.Initialize(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (249),(int) (128),(int) (55)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)));
 //BA.debugLineNum = 251;BA.debugLine="refStatus.Background = cd";
_refstatus.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
 break; }
case 1: {
 //BA.debugLineNum = 253;BA.debugLine="cd.Initialize(Colors.RGB(248,190,56), 2dip)";
_cd.Initialize(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (248),(int) (190),(int) (56)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)));
 //BA.debugLineNum = 254;BA.debugLine="refStatus.Background = cd";
_refstatus.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
 break; }
case 2: {
 //BA.debugLineNum = 256;BA.debugLine="cd.Initialize(Colors.RGB(186,220,63), 2dip)";
_cd.Initialize(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (186),(int) (220),(int) (63)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)));
 //BA.debugLineNum = 257;BA.debugLine="refStatus.Background = cd";
_refstatus.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
 break; }
case 3: 
case 4: 
case 5: {
 //BA.debugLineNum = 259;BA.debugLine="cd.Initialize(Colors.RGB(103,195,68), 2dip)";
_cd.Initialize(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (103),(int) (195),(int) (68)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)));
 //BA.debugLineNum = 260;BA.debugLine="refStatus.Background = cd";
_refstatus.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
 break; }
case 6: {
 //BA.debugLineNum = 262;BA.debugLine="cd.Initialize(Colors.RGB(62,222,176), 2dip)";
_cd.Initialize(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (62),(int) (222),(int) (176)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)));
 //BA.debugLineNum = 263;BA.debugLine="refStatus.Background = cd";
_refstatus.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
 break; }
case 7: {
 //BA.debugLineNum = 265;BA.debugLine="cd.Initialize(Colors.RGB(21,176,220), 2dip)";
_cd.Initialize(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (21),(int) (176),(int) (220)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)));
 //BA.debugLineNum = 266;BA.debugLine="refStatus.Background = cd";
_refstatus.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
 break; }
case 8: {
 //BA.debugLineNum = 268;BA.debugLine="cd.Initialize(Colors.RGB(38,143,235), 2dip)";
_cd.Initialize(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (38),(int) (143),(int) (235)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)));
 //BA.debugLineNum = 269;BA.debugLine="refStatus.Background = cd";
_refstatus.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
 break; }
default: {
 //BA.debugLineNum = 271;BA.debugLine="cd.Initialize(Colors.RGB(3,117,216), 2dip)";
_cd.Initialize(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (3),(int) (117),(int) (216)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)));
 //BA.debugLineNum = 272;BA.debugLine="refStatus.Background = cd";
_refstatus.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
 break; }
}
;
 //BA.debugLineNum = 275;BA.debugLine="refStatus.Text = ToMixCase(rStatus.Replace(\"_\",";
_refstatus.setText((Object)(_tomixcase(_rstatus.replace("_"," "))));
 //BA.debugLineNum = 276;BA.debugLine="refStatus.TextColor = Colors.White";
_refstatus.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 //BA.debugLineNum = 279;BA.debugLine="refStatus.Gravity = Gravity.CENTER";
_refstatus.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
 //BA.debugLineNum = 281;BA.debugLine="ReferencePanel.AddView(refStatus,38dip,refCompa";
_referencepanel.AddView((android.view.View)(_refstatus.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (38)),(int) (_refcompany.getTop()+_refcompany.getHeight()+_gap),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)));
 //BA.debugLineNum = 282;BA.debugLine="Dim refStatusHeight As Int";
_refstatusheight = 0;
 //BA.debugLineNum = 283;BA.debugLine="refStatusHeight =  su.MeasureMultilineTextHeigh";
_refstatusheight = mostCurrent._su.MeasureMultilineTextHeight((android.widget.TextView)(_refstatus.getObject()),_refstatus.getText());
 //BA.debugLineNum = 285;BA.debugLine="If refStatusHeight > refStatus.Height Then";
if (_refstatusheight>_refstatus.getHeight()) { 
 //BA.debugLineNum = 286;BA.debugLine="refStatus.Height = refStatusHeight";
_refstatus.setHeight(_refstatusheight);
 //BA.debugLineNum = 287;BA.debugLine="ReferencePanel.Height = ReferenceHeight + Gap";
_referencepanel.setHeight((int) (_referenceheight+_gap));
 };
 //BA.debugLineNum = 301;BA.debugLine="Dim sld As StateListDrawable";
_sld = new anywheresoftware.b4a.objects.drawable.StateListDrawable();
 //BA.debugLineNum = 302;BA.debugLine="Dim pressed As ColorDrawable";
_pressed = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
 //BA.debugLineNum = 303;BA.debugLine="pressed.Initialize(Colors.RGB(255, 255, 255)";
_pressed.Initialize(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (255),(int) (255),(int) (255)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)));
 //BA.debugLineNum = 305;BA.debugLine="sld.Initialize";
_sld.Initialize();
 //BA.debugLineNum = 306;BA.debugLine="sld.AddState(sld.State_Pressed,pressed)";
_sld.AddState(_sld.State_Pressed,(android.graphics.drawable.Drawable)(_pressed.getObject()));
 //BA.debugLineNum = 309;BA.debugLine="detailButton.Initialize(\"detailBtn\")";
_detailbutton.Initialize(mostCurrent.activityBA,"detailBtn");
 //BA.debugLineNum = 310;BA.debugLine="detailButton.Typeface = font.awesome.FontAwesom";
_detailbutton.setTypeface((android.graphics.Typeface)(mostCurrent._font._awesome()._fontawesometypeface().getObject()));
 //BA.debugLineNum = 311;BA.debugLine="detailButton.Tag = userId";
_detailbutton.setTag((Object)(_userid));
 //BA.debugLineNum = 312;BA.debugLine="detailButton.Text = \"Detail Progress \"&font.awe";
_detailbutton.setText((Object)("Detail Progress "+mostCurrent._font._awesome()._getfontawesomeiconbyname("fa-arrow-right")));
 //BA.debugLineNum = 313;BA.debugLine="detailButton.TextSize = JobTitle.TextSize / 1.4";
_detailbutton.setTextSize((float) (_jobtitle.getTextSize()/(double)1.4));
 //BA.debugLineNum = 314;BA.debugLine="detailButton.TextColor = Colors.RGB(22,176,221)";
_detailbutton.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (22),(int) (176),(int) (221)));
 //BA.debugLineNum = 315;BA.debugLine="detailButton.Gravity = Gravity.CENTER";
_detailbutton.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
 //BA.debugLineNum = 316;BA.debugLine="detailButton.Background = sld";
_detailbutton.setBackground((android.graphics.drawable.Drawable)(_sld.getObject()));
 //BA.debugLineNum = 327;BA.debugLine="detailList.Add(detailButton)";
mostCurrent._detaillist.Add((Object)(_detailbutton.getObject()));
 //BA.debugLineNum = 330;BA.debugLine="ReferencePanel.AddView(detailButton,(ReferenceP";
_referencepanel.AddView((android.view.View)(_detailbutton.getObject()),(int) ((_referencepanel.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (125)))-_gap),(int) (_refcompany.getTop()+_refcompany.getHeight()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (125)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (35)));
 //BA.debugLineNum = 332;BA.debugLine="ReferenceTop = ReferenceTop+ReferenceHeight+Gap";
_referencetop = (int) (_referencetop+_referenceheight+_gap);
 }
;
 //BA.debugLineNum = 335;BA.debugLine="Container.AddView(JoblistPanel,0,PanelTop,Contai";
_container.AddView((android.view.View)(_joblistpanel.getObject()),(int) (0),_paneltop,_container.getWidth(),_panelheight);
 //BA.debugLineNum = 336;BA.debugLine="PanelTop = PanelTop+PanelHeight+Gap";
_paneltop = (int) (_paneltop+_panelheight+_gap);
 //BA.debugLineNum = 337;BA.debugLine="PanelHeight = defaultPanelHeight";
_panelheight = _defaultpanelheight;
 }
;
 //BA.debugLineNum = 341;BA.debugLine="Dim sld As StateListDrawable";
_sld = new anywheresoftware.b4a.objects.drawable.StateListDrawable();
 //BA.debugLineNum = 342;BA.debugLine="Dim pressed,enabled As ColorDrawable";
_pressed = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
_enabled = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
 //BA.debugLineNum = 343;BA.debugLine="pressed.Initialize(Colors.RGB(105, 203, 231), 2di";
_pressed.Initialize(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (105),(int) (203),(int) (231)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)));
 //BA.debugLineNum = 344;BA.debugLine="enabled.Initialize(Colors.RGB(22,176,221), 2dip)";
_enabled.Initialize(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (22),(int) (176),(int) (221)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)));
 //BA.debugLineNum = 346;BA.debugLine="sld.Initialize";
_sld.Initialize();
 //BA.debugLineNum = 347;BA.debugLine="sld.AddState(sld.State_Pressed,pressed)";
_sld.AddState(_sld.State_Pressed,(android.graphics.drawable.Drawable)(_pressed.getObject()));
 //BA.debugLineNum = 348;BA.debugLine="sld.AddState(sld.State_Enabled,enabled)";
_sld.AddState(_sld.State_Enabled,(android.graphics.drawable.Drawable)(_enabled.getObject()));
 //BA.debugLineNum = 350;BA.debugLine="loadMore.Initialize(\"loadMore\")";
mostCurrent._loadmore.Initialize(mostCurrent.activityBA,"loadMore");
 //BA.debugLineNum = 351;BA.debugLine="loadMore.Text = \"Load More\"";
mostCurrent._loadmore.setText((Object)("Load More"));
 //BA.debugLineNum = 352;BA.debugLine="loadMore.Background = sld";
mostCurrent._loadmore.setBackground((android.graphics.drawable.Drawable)(_sld.getObject()));
 //BA.debugLineNum = 353;BA.debugLine="loadMore.TextColor = Colors.White";
mostCurrent._loadmore.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 //BA.debugLineNum = 354;BA.debugLine="loadMore.Gravity = Gravity.CENTER";
mostCurrent._loadmore.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
 //BA.debugLineNum = 355;BA.debugLine="loadMore.Tag = PanelTop";
mostCurrent._loadmore.setTag((Object)(_paneltop));
 //BA.debugLineNum = 358;BA.debugLine="Container.Height = PanelTop' + 50dip";
_container.setHeight(_paneltop);
 //BA.debugLineNum = 359;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="End Sub";
return "";
}
public static String  _searchitem_click() throws Exception{
 //BA.debugLineNum = 361;BA.debugLine="Sub SearchItem_Click";
 //BA.debugLineNum = 362;BA.debugLine="qAuth.Logout";
mostCurrent._qauth._logout();
 //BA.debugLineNum = 363;BA.debugLine="End Sub";
return "";
}
public static String  _sleep(long _ms) throws Exception{
long _now = 0L;
 //BA.debugLineNum = 383;BA.debugLine="Sub Sleep(ms As Long)";
 //BA.debugLineNum = 384;BA.debugLine="Dim now As Long";
_now = 0L;
 //BA.debugLineNum = 385;BA.debugLine="If ms > 1000 Then ms =1000   'avoid application";
if (_ms>1000) { 
_ms = (long) (1000);};
 //BA.debugLineNum = 386;BA.debugLine="now=DateTime.Now";
_now = anywheresoftware.b4a.keywords.Common.DateTime.getNow();
 //BA.debugLineNum = 387;BA.debugLine="Do Until (DateTime.Now>now+ms)";
while (!((anywheresoftware.b4a.keywords.Common.DateTime.getNow()>_now+_ms))) {
 //BA.debugLineNum = 388;BA.debugLine="DoEvents";
anywheresoftware.b4a.keywords.Common.DoEvents();
 }
;
 //BA.debugLineNum = 390;BA.debugLine="End Sub";
return "";
}
public static String  _tomixcase(String _entry) throws Exception{
anywheresoftware.b4a.keywords.StringBuilderWrapper _sb = null;
anywheresoftware.b4a.keywords.Regex.MatcherWrapper _m = null;
int _i = 0;
 //BA.debugLineNum = 425;BA.debugLine="Sub ToMixCase(Entry As String) As String";
 //BA.debugLineNum = 427;BA.debugLine="Dim sb As StringBuilder";
_sb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 428;BA.debugLine="Dim m As Matcher";
_m = new anywheresoftware.b4a.keywords.Regex.MatcherWrapper();
 //BA.debugLineNum = 429;BA.debugLine="Dim I As Int";
_i = 0;
 //BA.debugLineNum = 431;BA.debugLine="Entry = Entry.ToLowerCase";
_entry = _entry.toLowerCase();
 //BA.debugLineNum = 433;BA.debugLine="sb.Initialize";
_sb.Initialize();
 //BA.debugLineNum = 435;BA.debugLine="m = Regex.Matcher(\"(^\\w)|(\\s\\w)\", Entry)";
_m = anywheresoftware.b4a.keywords.Common.Regex.Matcher("(^\\w)|(\\s\\w)",_entry);
 //BA.debugLineNum = 437;BA.debugLine="Do While m.Find";
while (_m.Find()) {
 //BA.debugLineNum = 439;BA.debugLine="If m.Match.Length > 1 Then";
if (_m.getMatch().length()>1) { 
 //BA.debugLineNum = 441;BA.debugLine="sb.Append(Entry.SubString2(I, m.GetStart";
_sb.Append(_entry.substring(_i,(int) (_m.GetStart((int) (0))+1)));
 //BA.debugLineNum = 442;BA.debugLine="sb.Append(m.Match.SubString(1).ToUpperCa";
_sb.Append(_m.getMatch().substring((int) (1)).toUpperCase());
 }else {
 //BA.debugLineNum = 446;BA.debugLine="sb.Append(Entry.SubString2(I, m.GetStart";
_sb.Append(_entry.substring(_i,_m.GetStart((int) (0))));
 //BA.debugLineNum = 447;BA.debugLine="sb.Append(m.Match.ToUpperCase)";
_sb.Append(_m.getMatch().toUpperCase());
 };
 //BA.debugLineNum = 451;BA.debugLine="I = m.GetEnd(0)";
_i = _m.GetEnd((int) (0));
 }
;
 //BA.debugLineNum = 455;BA.debugLine="If I < Entry.Length Then";
if (_i<_entry.length()) { 
 //BA.debugLineNum = 457;BA.debugLine="sb.Append(Entry.SubString(I))";
_sb.Append(_entry.substring(_i));
 };
 //BA.debugLineNum = 461;BA.debugLine="Return sb.ToString";
if (true) return _sb.ToString();
 //BA.debugLineNum = 463;BA.debugLine="End Sub";
return "";
}
}
