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

public class referringprogress extends Activity implements B4AActivity{
	public static referringprogress mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "com.qolega.qolegapp", "com.qolega.qolegapp.referringprogress");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (referringprogress).");
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
		activityBA = new BA(this, layout, processBA, "com.qolega.qolegapp", "com.qolega.qolegapp.referringprogress");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "com.qolega.qolegapp.referringprogress", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (referringprogress) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (referringprogress) Resume **");
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
		return referringprogress.class;
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
        BA.LogInfo("** Activity (referringprogress) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
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
            BA.LogInfo("** Activity (referringprogress) Resume **");
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


public static class _rowcol{
public boolean IsInitialized;
public int Row;
public int Col;
public void Initialize() {
IsInitialized = true;
Row = 0;
Col = 0;
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}

public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public anywheresoftware.b4a.keywords.Common __c = null;
public static int _userid = 0;
public anywheresoftware.b4a.objects.ScrollViewWrapper _scrollview = null;
public anywheresoftware.b4a.objects.collections.JSONParser _json = null;
public anywheresoftware.b4a.objects.StringUtils _su = null;
public anywheresoftware.b4a.objects.PanelWrapper _container = null;
public com.qolega.qolegapp.fonts _font = null;
public anywheresoftware.b4a.objects.StdActionBar _bar = null;
public anywheresoftware.b4a.objects.collections.List _detaillist = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _showicon = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _closeicon = null;
public com.qolega.qolegapp.api _api = null;
public com.qolega.qolegapp.main _main = null;
public com.qolega.qolegapp.starter _starter = null;
public com.qolega.qolegapp.referringlist _referringlist = null;
public com.qolega.qolegapp.testresponsive _testresponsive = null;
public com.qolega.qolegapp.test3 _test3 = null;
public com.qolega.qolegapp.httputils2service _httputils2service = null;
public com.qolega.qolegapp.test4 _test4 = null;
public static String  _activity_actionbarhomeclick() throws Exception{
RDebugUtils.currentModule="referringprogress";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_actionbarhomeclick"))
	return (String) Debug.delegate(mostCurrent.activityBA, "activity_actionbarhomeclick", null);
RDebugUtils.currentLine=2162688;
 //BA.debugLineNum = 2162688;BA.debugLine="Sub Activity_ActionBarHomeClick";
RDebugUtils.currentLine=2162689;
 //BA.debugLineNum = 2162689;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=2162690;
 //BA.debugLineNum = 2162690;BA.debugLine="End Sub";
return "";
}
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="referringprogress";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create"))
	return (String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime});
RDebugUtils.currentLine=1966080;
 //BA.debugLineNum = 1966080;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=1966082;
 //BA.debugLineNum = 1966082;BA.debugLine="font.Initialize";
mostCurrent._font._initialize(null,processBA);
RDebugUtils.currentLine=1966083;
 //BA.debugLineNum = 1966083;BA.debugLine="Api.Initialize(\"referringProgress\",Me)";
mostCurrent._api._initialize(null,processBA,"referringProgress",referringprogress.getObject());
RDebugUtils.currentLine=1966084;
 //BA.debugLineNum = 1966084;BA.debugLine="detailList.Initialize";
mostCurrent._detaillist.Initialize();
RDebugUtils.currentLine=1966088;
 //BA.debugLineNum = 1966088;BA.debugLine="Activity.Title = \"Candidate Progress\"";
mostCurrent._activity.setTitle((Object)("Candidate Progress"));
RDebugUtils.currentLine=1966090;
 //BA.debugLineNum = 1966090;BA.debugLine="Container.Initialize(\"\")";
mostCurrent._container.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1966091;
 //BA.debugLineNum = 1966091;BA.debugLine="Container.Color = Colors.RGB(246,246,246)";
mostCurrent._container.setColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (246),(int) (246),(int) (246)));
RDebugUtils.currentLine=1966092;
 //BA.debugLineNum = 1966092;BA.debugLine="Activity.AddView(Container,0,0,100%x,100%y)";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._container.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
RDebugUtils.currentLine=1966094;
 //BA.debugLineNum = 1966094;BA.debugLine="bar.Initialize(\"bar\")";
mostCurrent._bar.Initialize("bar",mostCurrent.activityBA);
RDebugUtils.currentLine=1966095;
 //BA.debugLineNum = 1966095;BA.debugLine="bar.ShowUpIndicator = True";
mostCurrent._bar.setShowUpIndicator(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1966097;
 //BA.debugLineNum = 1966097;BA.debugLine="ProgressDialogShow(\"Loading Data\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,"Loading Data");
RDebugUtils.currentLine=1966098;
 //BA.debugLineNum = 1966098;BA.debugLine="Api.Get(\"/referrals/detail/\"&userId)";
mostCurrent._api._get(null,"/referrals/detail/"+BA.NumberToString(_userid));
RDebugUtils.currentLine=1966099;
 //BA.debugLineNum = 1966099;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="referringprogress";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_pause"))
	return (String) Debug.delegate(mostCurrent.activityBA, "activity_pause", new Object[] {_userclosed});
RDebugUtils.currentLine=2293760;
 //BA.debugLineNum = 2293760;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=2293762;
 //BA.debugLineNum = 2293762;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="referringprogress";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume"))
	return (String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null);
RDebugUtils.currentLine=2228224;
 //BA.debugLineNum = 2228224;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=2228226;
 //BA.debugLineNum = 2228226;BA.debugLine="End Sub";
return "";
}
public static boolean  _areequal(int _b1,int _b2) throws Exception{
RDebugUtils.currentModule="referringprogress";
if (Debug.shouldDelegate(mostCurrent.activityBA, "areequal"))
	return (Boolean) Debug.delegate(mostCurrent.activityBA, "areequal", new Object[] {_b1,_b2});
RDebugUtils.currentLine=2686976;
 //BA.debugLineNum = 2686976;BA.debugLine="Sub AreEqual(b1 As Int, b2 As Int) As Boolean";
RDebugUtils.currentLine=2686977;
 //BA.debugLineNum = 2686977;BA.debugLine="If b1 <> b2 Then Return False";
if (_b1!=_b2) { 
if (true) return anywheresoftware.b4a.keywords.Common.False;};
RDebugUtils.currentLine=2686978;
 //BA.debugLineNum = 2686978;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=2686979;
 //BA.debugLineNum = 2686979;BA.debugLine="End Sub";
return false;
}
public static String  _closeicon_click() throws Exception{
RDebugUtils.currentModule="referringprogress";
if (Debug.shouldDelegate(mostCurrent.activityBA, "closeicon_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "closeicon_click", null);
anywheresoftware.b4a.objects.PanelWrapper _detailpanel = null;
anywheresoftware.b4a.objects.PanelWrapper _jobtitlepanel = null;
anywheresoftware.b4a.objects.PanelWrapper _journeypanel = null;
anywheresoftware.b4a.objects.LabelWrapper _utiltextlabel = null;
RDebugUtils.currentLine=2490368;
 //BA.debugLineNum = 2490368;BA.debugLine="Sub closeIcon_Click";
RDebugUtils.currentLine=2490369;
 //BA.debugLineNum = 2490369;BA.debugLine="Dim detailPanel,jobTitlePanel,journeyPanel As Pan";
_detailpanel = new anywheresoftware.b4a.objects.PanelWrapper();
_jobtitlepanel = new anywheresoftware.b4a.objects.PanelWrapper();
_journeypanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=2490370;
 //BA.debugLineNum = 2490370;BA.debugLine="Dim utilTextLabel As Label";
_utiltextlabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2490372;
 //BA.debugLineNum = 2490372;BA.debugLine="detailPanel = detailList.Get(0)";
_detailpanel.setObject((android.view.ViewGroup)(mostCurrent._detaillist.Get((int) (0))));
RDebugUtils.currentLine=2490373;
 //BA.debugLineNum = 2490373;BA.debugLine="utilTextLabel = detailList.Get(1)";
_utiltextlabel.setObject((android.widget.TextView)(mostCurrent._detaillist.Get((int) (1))));
RDebugUtils.currentLine=2490374;
 //BA.debugLineNum = 2490374;BA.debugLine="jobTitlePanel = detailList.Get(2)";
_jobtitlepanel.setObject((android.view.ViewGroup)(mostCurrent._detaillist.Get((int) (2))));
RDebugUtils.currentLine=2490375;
 //BA.debugLineNum = 2490375;BA.debugLine="journeyPanel = detailList.Get(3)";
_journeypanel.setObject((android.view.ViewGroup)(mostCurrent._detaillist.Get((int) (3))));
RDebugUtils.currentLine=2490377;
 //BA.debugLineNum = 2490377;BA.debugLine="detailPanel.Height = detailPanel.Height - 200dip";
_detailpanel.setHeight((int) (_detailpanel.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (200))));
RDebugUtils.currentLine=2490378;
 //BA.debugLineNum = 2490378;BA.debugLine="utilTextLabel.Top = detailPanel.Height";
_utiltextlabel.setTop(_detailpanel.getHeight());
RDebugUtils.currentLine=2490379;
 //BA.debugLineNum = 2490379;BA.debugLine="utilTextLabel.Text = \"Show candidate details\"";
_utiltextlabel.setText((Object)("Show candidate details"));
RDebugUtils.currentLine=2490380;
 //BA.debugLineNum = 2490380;BA.debugLine="jobTitlePanel.Top = utilTextLabel.Top + utilTextL";
_jobtitlepanel.setTop((int) (_utiltextlabel.getTop()+_utiltextlabel.getHeight()));
RDebugUtils.currentLine=2490381;
 //BA.debugLineNum = 2490381;BA.debugLine="scrollView.Top = jobTitlePanel.Top + jobTitlePane";
mostCurrent._scrollview.setTop((int) (_jobtitlepanel.getTop()+_jobtitlepanel.getHeight()));
RDebugUtils.currentLine=2490382;
 //BA.debugLineNum = 2490382;BA.debugLine="journeyPanel.Height = journeyPanel.Height - jobTi";
_journeypanel.setHeight((int) (_journeypanel.getHeight()-_jobtitlepanel.getTop()+_jobtitlepanel.getHeight()));
RDebugUtils.currentLine=2490387;
 //BA.debugLineNum = 2490387;BA.debugLine="showIcon.Visible = True";
mostCurrent._showicon.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2490388;
 //BA.debugLineNum = 2490388;BA.debugLine="closeIcon.Visible = False";
mostCurrent._closeicon.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2490389;
 //BA.debugLineNum = 2490389;BA.debugLine="End Sub";
return "";
}
public static String  _drawbordertop(anywheresoftware.b4a.objects.ConcreteViewWrapper _target,int _acolor,int _strokewidth) throws Exception{
RDebugUtils.currentModule="referringprogress";
if (Debug.shouldDelegate(mostCurrent.activityBA, "drawbordertop"))
	return (String) Debug.delegate(mostCurrent.activityBA, "drawbordertop", new Object[] {_target,_acolor,_strokewidth});
anywheresoftware.b4a.objects.drawable.CanvasWrapper _c = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.PathWrapper _path = null;
RDebugUtils.currentLine=2621440;
 //BA.debugLineNum = 2621440;BA.debugLine="Sub DrawBorderTop(Target As View,aColor As Int,Str";
RDebugUtils.currentLine=2621441;
 //BA.debugLineNum = 2621441;BA.debugLine="Dim c As Canvas";
_c = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();
RDebugUtils.currentLine=2621442;
 //BA.debugLineNum = 2621442;BA.debugLine="c.Initialize(Target)";
_c.Initialize((android.view.View)(_target.getObject()));
RDebugUtils.currentLine=2621443;
 //BA.debugLineNum = 2621443;BA.debugLine="Dim Path As Path";
_path = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.PathWrapper();
RDebugUtils.currentLine=2621444;
 //BA.debugLineNum = 2621444;BA.debugLine="Path.Initialize(0,0)";
_path.Initialize((float) (0),(float) (0));
RDebugUtils.currentLine=2621445;
 //BA.debugLineNum = 2621445;BA.debugLine="Path.LineTo(Target.Width,0)";
_path.LineTo((float) (_target.getWidth()),(float) (0));
RDebugUtils.currentLine=2621446;
 //BA.debugLineNum = 2621446;BA.debugLine="c.DrawPath(Path,aColor,False,StrokeWidth)";
_c.DrawPath((android.graphics.Path)(_path.getObject()),_acolor,anywheresoftware.b4a.keywords.Common.False,(float) (_strokewidth));
RDebugUtils.currentLine=2621447;
 //BA.debugLineNum = 2621447;BA.debugLine="Target.Invalidate";
_target.Invalidate();
RDebugUtils.currentLine=2621448;
 //BA.debugLineNum = 2621448;BA.debugLine="End Sub";
return "";
}
public static String  _drawdashline(anywheresoftware.b4a.objects.ConcreteViewWrapper _target,float _x1,float _y1,float _x2,float _y2,int _col,float _stroke) throws Exception{
RDebugUtils.currentModule="referringprogress";
if (Debug.shouldDelegate(mostCurrent.activityBA, "drawdashline"))
	return (String) Debug.delegate(mostCurrent.activityBA, "drawdashline", new Object[] {_target,_x1,_y1,_x2,_y2,_col,_stroke});
com.AB.ABExtDrawing.ABExtDrawing.ABPaint _p = null;
com.AB.ABExtDrawing.ABExtDrawing _extdrawing = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper _cvsmain = null;
RDebugUtils.currentLine=2555904;
 //BA.debugLineNum = 2555904;BA.debugLine="Sub DrawDashLine(Target As View,x1 As Float, y1 As";
RDebugUtils.currentLine=2555905;
 //BA.debugLineNum = 2555905;BA.debugLine="Dim p As ABPaint";
_p = new com.AB.ABExtDrawing.ABExtDrawing.ABPaint();
RDebugUtils.currentLine=2555906;
 //BA.debugLineNum = 2555906;BA.debugLine="Dim ExtDrawing As ABExtDrawing";
_extdrawing = new com.AB.ABExtDrawing.ABExtDrawing();
RDebugUtils.currentLine=2555907;
 //BA.debugLineNum = 2555907;BA.debugLine="Dim cvsMain As Canvas";
_cvsmain = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();
RDebugUtils.currentLine=2555909;
 //BA.debugLineNum = 2555909;BA.debugLine="cvsMain.Initialize(Target)";
_cvsmain.Initialize((android.view.View)(_target.getObject()));
RDebugUtils.currentLine=2555911;
 //BA.debugLineNum = 2555911;BA.debugLine="p.Initialize";
_p.Initialize();
RDebugUtils.currentLine=2555912;
 //BA.debugLineNum = 2555912;BA.debugLine="p.SetStrokeWidth(Stroke)";
_p.SetStrokeWidth(_stroke);
RDebugUtils.currentLine=2555913;
 //BA.debugLineNum = 2555913;BA.debugLine="p.SetStyle(p.Style_STROKE)";
_p.SetStyle(_p.Style_STROKE);
RDebugUtils.currentLine=2555914;
 //BA.debugLineNum = 2555914;BA.debugLine="p.SetColor(col)";
_p.SetColor(_col);
RDebugUtils.currentLine=2555915;
 //BA.debugLineNum = 2555915;BA.debugLine="p.SetDashPathEffect(1, Array As Float(2dip, 2d";
_p.SetDashPathEffect((int) (1),new float[]{(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2))),(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)))},(float) (0));
RDebugUtils.currentLine=2555916;
 //BA.debugLineNum = 2555916;BA.debugLine="p.DoPathEffectSingle(1)";
_p.DoPathEffectSingle((int) (1));
RDebugUtils.currentLine=2555917;
 //BA.debugLineNum = 2555917;BA.debugLine="ExtDrawing.DrawLine(cvsMain, x1, y1, x2, y2, p";
_extdrawing.drawLine(_cvsmain,_x1,_y1,_x2,_y2,_p);
RDebugUtils.currentLine=2555918;
 //BA.debugLineNum = 2555918;BA.debugLine="End Sub";
return "";
}
public static String  _drawleftborder(anywheresoftware.b4a.objects.ConcreteViewWrapper _target,int _acolor,int _strokewidth,boolean _last,boolean _single) throws Exception{
RDebugUtils.currentModule="referringprogress";
if (Debug.shouldDelegate(mostCurrent.activityBA, "drawleftborder"))
	return (String) Debug.delegate(mostCurrent.activityBA, "drawleftborder", new Object[] {_target,_acolor,_strokewidth,_last,_single});
anywheresoftware.b4a.objects.drawable.CanvasWrapper _c = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.PathWrapper _path1 = null;
RDebugUtils.currentLine=2359296;
 //BA.debugLineNum = 2359296;BA.debugLine="Public Sub DrawLeftBorder(Target As View, aColor A";
RDebugUtils.currentLine=2359297;
 //BA.debugLineNum = 2359297;BA.debugLine="Dim c As Canvas";
_c = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();
RDebugUtils.currentLine=2359298;
 //BA.debugLineNum = 2359298;BA.debugLine="c.Initialize(Target)";
_c.Initialize((android.view.View)(_target.getObject()));
RDebugUtils.currentLine=2359299;
 //BA.debugLineNum = 2359299;BA.debugLine="Dim Path1 As Path";
_path1 = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.PathWrapper();
RDebugUtils.currentLine=2359300;
 //BA.debugLineNum = 2359300;BA.debugLine="Path1.Initialize(0,0)";
_path1.Initialize((float) (0),(float) (0));
RDebugUtils.currentLine=2359302;
 //BA.debugLineNum = 2359302;BA.debugLine="If Last == True Then";
if (_last==anywheresoftware.b4a.keywords.Common.True) { 
 }else {
RDebugUtils.currentLine=2359305;
 //BA.debugLineNum = 2359305;BA.debugLine="If Single == True Then";
if (_single==anywheresoftware.b4a.keywords.Common.True) { 
 }else {
RDebugUtils.currentLine=2359308;
 //BA.debugLineNum = 2359308;BA.debugLine="Path1.LineTo(0,Target.Height)";
_path1.LineTo((float) (0),(float) (_target.getHeight()));
 };
 };
RDebugUtils.currentLine=2359312;
 //BA.debugLineNum = 2359312;BA.debugLine="c.DrawPath(Path1, aColor, False, StrokeWidth)";
_c.DrawPath((android.graphics.Path)(_path1.getObject()),_acolor,anywheresoftware.b4a.keywords.Common.False,(float) (_strokewidth));
RDebugUtils.currentLine=2359313;
 //BA.debugLineNum = 2359313;BA.debugLine="Target.Invalidate";
_target.Invalidate();
RDebugUtils.currentLine=2359314;
 //BA.debugLineNum = 2359314;BA.debugLine="End Sub";
return "";
}
public static String  _jobdone(com.qolega.qolegapp.httpjob _job) throws Exception{
RDebugUtils.currentModule="referringprogress";
if (Debug.shouldDelegate(mostCurrent.activityBA, "jobdone"))
	return (String) Debug.delegate(mostCurrent.activityBA, "jobdone", new Object[] {_job});
RDebugUtils.currentLine=2031616;
 //BA.debugLineNum = 2031616;BA.debugLine="Sub JobDone(Job As HttpJob)";
RDebugUtils.currentLine=2031617;
 //BA.debugLineNum = 2031617;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
RDebugUtils.currentLine=2031618;
 //BA.debugLineNum = 2031618;BA.debugLine="Log(\"JobName = \" & Job.JobName & \", Success = \"";
anywheresoftware.b4a.keywords.Common.Log("JobName = "+_job._jobname+", Success = "+BA.ObjectToString(_job._success));
RDebugUtils.currentLine=2031619;
 //BA.debugLineNum = 2031619;BA.debugLine="If Job.Success = True Then";
if (_job._success==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=2031620;
 //BA.debugLineNum = 2031620;BA.debugLine="LoopPanel(Job.GetString)";
_looppanel(_job._getstring(null));
 }else {
RDebugUtils.currentLine=2031622;
 //BA.debugLineNum = 2031622;BA.debugLine="Log(\"Error: \" & Job.ErrorMessage)";
anywheresoftware.b4a.keywords.Common.Log("Error: "+_job._errormessage);
RDebugUtils.currentLine=2031623;
 //BA.debugLineNum = 2031623;BA.debugLine="ToastMessageShow(\"Error: \" & Job.ErrorMessag";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("Error: "+_job._errormessage,anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=2031625;
 //BA.debugLineNum = 2031625;BA.debugLine="Job.Release";
_job._release(null);
RDebugUtils.currentLine=2031626;
 //BA.debugLineNum = 2031626;BA.debugLine="End Sub";
return "";
}
public static String  _looppanel(String _data) throws Exception{
RDebugUtils.currentModule="referringprogress";
if (Debug.shouldDelegate(mostCurrent.activityBA, "looppanel"))
	return (String) Debug.delegate(mostCurrent.activityBA, "looppanel", new Object[] {_data});
anywheresoftware.b4a.objects.PanelWrapper _jobtitlepanel = null;
anywheresoftware.b4a.objects.PanelWrapper _detailpanel = null;
anywheresoftware.b4a.objects.PanelWrapper _journeypanel = null;
anywheresoftware.b4a.objects.PanelWrapper _referencepanel = null;
anywheresoftware.b4a.objects.PanelWrapper _progressbox = null;
int _paneltop = 0;
int _icontop = 0;
int _panelheight = 0;
int _referencetop = 0;
int _referenceheight = 0;
int _gap = 0;
int _textheight = 0;
anywheresoftware.b4a.objects.LabelWrapper _jobtitle = null;
anywheresoftware.b4a.objects.LabelWrapper _utiltext = null;
anywheresoftware.b4a.objects.LabelWrapper _refname = null;
anywheresoftware.b4a.objects.LabelWrapper _refcompany = null;
anywheresoftware.b4a.objects.LabelWrapper _refstatus = null;
anywheresoftware.b4a.objects.LabelWrapper _reftext = null;
anywheresoftware.b4a.objects.LabelWrapper _detailbtn = null;
anywheresoftware.b4a.objects.PanelWrapper _refdetwrapper = null;
anywheresoftware.b4a.objects.ImageViewWrapper _usericon = null;
anywheresoftware.b4a.objects.collections.Map _root = null;
String _dataname = "";
String _datacompany = "";
String _datalatestpos = "";
String _dataphonenum = "";
String _dataurl = "";
String _dataemail = "";
String _datanote = "";
String _datajobtitle = "";
anywheresoftware.b4a.objects.LabelWrapper _detemail = null;
anywheresoftware.b4a.objects.LabelWrapper _detphonenumber = null;
anywheresoftware.b4a.objects.LabelWrapper _detlatestcomp = null;
anywheresoftware.b4a.objects.LabelWrapper _detlastpos = null;
anywheresoftware.b4a.objects.LabelWrapper _detlinkedinurl = null;
anywheresoftware.b4a.objects.LabelWrapper _detnote = null;
anywheresoftware.b4a.objects.collections.List _textlist = null;
anywheresoftware.b4a.objects.collections.List _valuelist = null;
int _toppos = 0;
int _i = 0;
anywheresoftware.b4a.objects.LabelWrapper _l = null;
anywheresoftware.b4a.objects.LabelWrapper _ll = null;
anywheresoftware.b4a.objects.LabelWrapper _lll = null;
int _x = 0;
int _utiltextw = 0;
int _titleheight = 0;
anywheresoftware.b4a.objects.PanelWrapper _referencewrapper = null;
anywheresoftware.b4a.objects.collections.List _journeys = null;
int _iterator = 0;
int _lasticontop = 0;
int _incrementboxheight = 0;
int _boxheight = 0;
anywheresoftware.b4a.objects.collections.Map _coljourneys = null;
String _journeytext = "";
String _rstatus = "";
String _rstate = "";
String _rstatedesc = "";
String _daysago = "";
String _iconname = "";
anywheresoftware.b4a.objects.ImageViewWrapper _statusicon = null;
anywheresoftware.b4a.objects.drawable.ColorDrawable _cd = null;
int _refstatusheight = 0;
anywheresoftware.b4a.objects.LabelWrapper _refday = null;
int _addheight = 0;
RDebugUtils.currentLine=2097152;
 //BA.debugLineNum = 2097152;BA.debugLine="Sub LoopPanel(Data As String)";
RDebugUtils.currentLine=2097153;
 //BA.debugLineNum = 2097153;BA.debugLine="Dim jobTitlePanel,detailPanel,journeyPanel,refere";
_jobtitlepanel = new anywheresoftware.b4a.objects.PanelWrapper();
_detailpanel = new anywheresoftware.b4a.objects.PanelWrapper();
_journeypanel = new anywheresoftware.b4a.objects.PanelWrapper();
_referencepanel = new anywheresoftware.b4a.objects.PanelWrapper();
_progressbox = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=2097154;
 //BA.debugLineNum = 2097154;BA.debugLine="Dim PanelTop,IconTop,PanelHeight,ReferenceTop,Ref";
_paneltop = 0;
_icontop = 0;
_panelheight = 0;
_referencetop = 0;
_referenceheight = 0;
_gap = 0;
_textheight = 0;
RDebugUtils.currentLine=2097155;
 //BA.debugLineNum = 2097155;BA.debugLine="Dim jobTitle,utilText,refName,refCompany,refStatu";
_jobtitle = new anywheresoftware.b4a.objects.LabelWrapper();
_utiltext = new anywheresoftware.b4a.objects.LabelWrapper();
_refname = new anywheresoftware.b4a.objects.LabelWrapper();
_refcompany = new anywheresoftware.b4a.objects.LabelWrapper();
_refstatus = new anywheresoftware.b4a.objects.LabelWrapper();
_reftext = new anywheresoftware.b4a.objects.LabelWrapper();
_detailbtn = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2097157;
 //BA.debugLineNum = 2097157;BA.debugLine="Dim refDetWrapper As Panel";
_refdetwrapper = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=2097159;
 //BA.debugLineNum = 2097159;BA.debugLine="Dim userIcon As ImageView";
_usericon = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=2097162;
 //BA.debugLineNum = 2097162;BA.debugLine="JSON.Initialize(Data)";
mostCurrent._json.Initialize(_data);
RDebugUtils.currentLine=2097163;
 //BA.debugLineNum = 2097163;BA.debugLine="Dim root As Map = JSON.NextObject";
_root = new anywheresoftware.b4a.objects.collections.Map();
_root = mostCurrent._json.NextObject();
RDebugUtils.currentLine=2097165;
 //BA.debugLineNum = 2097165;BA.debugLine="Dim dataName As String = root.Get(\"name\")";
_dataname = BA.ObjectToString(_root.Get((Object)("name")));
RDebugUtils.currentLine=2097166;
 //BA.debugLineNum = 2097166;BA.debugLine="Dim dataCompany As String = root.Get(\"company\")";
_datacompany = BA.ObjectToString(_root.Get((Object)("company")));
RDebugUtils.currentLine=2097167;
 //BA.debugLineNum = 2097167;BA.debugLine="Dim dataLatestPos As String = root.Get(\"user_job_";
_datalatestpos = BA.ObjectToString(_root.Get((Object)("user_job_title")));
RDebugUtils.currentLine=2097168;
 //BA.debugLineNum = 2097168;BA.debugLine="Dim dataPhoneNum As String = root.Get(\"phone\")";
_dataphonenum = BA.ObjectToString(_root.Get((Object)("phone")));
RDebugUtils.currentLine=2097169;
 //BA.debugLineNum = 2097169;BA.debugLine="Dim dataUrl As String = root.Get(\"linkedin\")";
_dataurl = BA.ObjectToString(_root.Get((Object)("linkedin")));
RDebugUtils.currentLine=2097170;
 //BA.debugLineNum = 2097170;BA.debugLine="Dim dataEmail As String = root.Get(\"email\")";
_dataemail = BA.ObjectToString(_root.Get((Object)("email")));
RDebugUtils.currentLine=2097171;
 //BA.debugLineNum = 2097171;BA.debugLine="Dim dataNote As String = root.Get(\"note\")";
_datanote = BA.ObjectToString(_root.Get((Object)("note")));
RDebugUtils.currentLine=2097172;
 //BA.debugLineNum = 2097172;BA.debugLine="Dim dataJobtitle As String = \"Text\"";
_datajobtitle = "Text";
RDebugUtils.currentLine=2097175;
 //BA.debugLineNum = 2097175;BA.debugLine="PanelTop = 10dip";
_paneltop = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
RDebugUtils.currentLine=2097177;
 //BA.debugLineNum = 2097177;BA.debugLine="PanelHeight = 110dip";
_panelheight = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (110));
RDebugUtils.currentLine=2097179;
 //BA.debugLineNum = 2097179;BA.debugLine="Gap = 10dip";
_gap = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
RDebugUtils.currentLine=2097181;
 //BA.debugLineNum = 2097181;BA.debugLine="detailPanel.Initialize(\"\")";
_detailpanel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2097182;
 //BA.debugLineNum = 2097182;BA.debugLine="detailPanel.Color = Colors.White";
_detailpanel.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=2097183;
 //BA.debugLineNum = 2097183;BA.debugLine="Container.AddView(detailPanel,0,10dip,100%x,70dip";
mostCurrent._container.AddView((android.view.View)(_detailpanel.getObject()),(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (70)));
RDebugUtils.currentLine=2097186;
 //BA.debugLineNum = 2097186;BA.debugLine="userIcon.Initialize(\"\")";
_usericon.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2097187;
 //BA.debugLineNum = 2097187;BA.debugLine="userIcon.Bitmap = LoadBitmap(File.DirAssets,\"user";
_usericon.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"user.png").getObject()));
RDebugUtils.currentLine=2097188;
 //BA.debugLineNum = 2097188;BA.debugLine="userIcon.Gravity = Gravity.FILL";
_usericon.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
RDebugUtils.currentLine=2097189;
 //BA.debugLineNum = 2097189;BA.debugLine="refName.Initialize(\"\")";
_refname.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2097190;
 //BA.debugLineNum = 2097190;BA.debugLine="refName.Text = dataName";
_refname.setText((Object)(_dataname));
RDebugUtils.currentLine=2097191;
 //BA.debugLineNum = 2097191;BA.debugLine="refName.TextColor = Colors.RGB(74,74,74)";
_refname.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (74),(int) (74),(int) (74)));
RDebugUtils.currentLine=2097193;
 //BA.debugLineNum = 2097193;BA.debugLine="refName.Typeface = font.proximanovaSemiBold";
_refname.setTypeface((android.graphics.Typeface)(mostCurrent._font._proximanovasemibold(null).getObject()));
RDebugUtils.currentLine=2097196;
 //BA.debugLineNum = 2097196;BA.debugLine="detailPanel.AddView(userIcon,10dip,10dip,24dip,24";
_detailpanel.AddView((android.view.View)(_usericon.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (24)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (24)));
RDebugUtils.currentLine=2097197;
 //BA.debugLineNum = 2097197;BA.debugLine="detailPanel.AddView(refName,38dip,12dip,detailPan";
_detailpanel.AddView((android.view.View)(_refname.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (38)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (12)),(int) (_detailpanel.getWidth()-(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (38))*2)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)));
RDebugUtils.currentLine=2097200;
 //BA.debugLineNum = 2097200;BA.debugLine="refCompany.Initialize(\"\")";
_refcompany.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2097201;
 //BA.debugLineNum = 2097201;BA.debugLine="refCompany.Text = dataCompany";
_refcompany.setText((Object)(_datacompany));
RDebugUtils.currentLine=2097202;
 //BA.debugLineNum = 2097202;BA.debugLine="refCompany.TextColor = Colors.RGB(179,179,179)";
_refcompany.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (179),(int) (179),(int) (179)));
RDebugUtils.currentLine=2097204;
 //BA.debugLineNum = 2097204;BA.debugLine="refCompany.Typeface = font.proximanovaRegular";
_refcompany.setTypeface((android.graphics.Typeface)(mostCurrent._font._proximanovaregular(null).getObject()));
RDebugUtils.currentLine=2097205;
 //BA.debugLineNum = 2097205;BA.debugLine="detailPanel.AddView(refCompany,38dip,refName.Top+";
_detailpanel.AddView((android.view.View)(_refcompany.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (38)),(int) (_refname.getTop()+_refname.getHeight()),(int) (_detailpanel.getWidth()-(38*2)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)));
RDebugUtils.currentLine=2097209;
 //BA.debugLineNum = 2097209;BA.debugLine="refDetWrapper.Initialize(\"\")";
_refdetwrapper.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2097210;
 //BA.debugLineNum = 2097210;BA.debugLine="detailPanel.AddView(refDetWrapper,10dip,refCompan";
_detailpanel.AddView((android.view.View)(_refdetwrapper.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),(int) (_refcompany.getTop()+_refcompany.getHeight()+_gap*2),(int) (_detailpanel.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
RDebugUtils.currentLine=2097211;
 //BA.debugLineNum = 2097211;BA.debugLine="DrawBorderTop(refDetWrapper,Colors.RGB(219,219,21";
_drawbordertop((anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_refdetwrapper.getObject())),anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (219),(int) (219),(int) (219)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)));
RDebugUtils.currentLine=2097214;
 //BA.debugLineNum = 2097214;BA.debugLine="Dim detEmail,detPhoneNumber,detLatestComp,detLast";
_detemail = new anywheresoftware.b4a.objects.LabelWrapper();
_detphonenumber = new anywheresoftware.b4a.objects.LabelWrapper();
_detlatestcomp = new anywheresoftware.b4a.objects.LabelWrapper();
_detlastpos = new anywheresoftware.b4a.objects.LabelWrapper();
_detlinkedinurl = new anywheresoftware.b4a.objects.LabelWrapper();
_detnote = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2097220;
 //BA.debugLineNum = 2097220;BA.debugLine="Dim textList,valueList As List";
_textlist = new anywheresoftware.b4a.objects.collections.List();
_valuelist = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=2097221;
 //BA.debugLineNum = 2097221;BA.debugLine="textList.Initialize";
_textlist.Initialize();
RDebugUtils.currentLine=2097222;
 //BA.debugLineNum = 2097222;BA.debugLine="textList.AddAll(Array As String(\"Email\", \"Phone N";
_textlist.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"Email","Phone Number","Latest Company","Latest Position","LinkedIn URL","Note"}));
RDebugUtils.currentLine=2097223;
 //BA.debugLineNum = 2097223;BA.debugLine="valueList.Initialize";
_valuelist.Initialize();
RDebugUtils.currentLine=2097224;
 //BA.debugLineNum = 2097224;BA.debugLine="valueList.AddAll(Array As String(dataEmail,dataPh";
_valuelist.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{_dataemail,_dataphonenum,_datacompany,_datalatestpos,_dataurl,_datanote}));
RDebugUtils.currentLine=2097225;
 //BA.debugLineNum = 2097225;BA.debugLine="Dim topPos As Int";
_toppos = 0;
RDebugUtils.currentLine=2097226;
 //BA.debugLineNum = 2097226;BA.debugLine="topPos = 20dip";
_toppos = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20));
RDebugUtils.currentLine=2097228;
 //BA.debugLineNum = 2097228;BA.debugLine="For i=0 To textList.Size -1";
{
final int step47 = 1;
final int limit47 = (int) (_textlist.getSize()-1);
for (_i = (int) (0) ; (step47 > 0 && _i <= limit47) || (step47 < 0 && _i >= limit47); _i = ((int)(0 + _i + step47)) ) {
RDebugUtils.currentLine=2097229;
 //BA.debugLineNum = 2097229;BA.debugLine="Dim l,ll,lll As Label";
_l = new anywheresoftware.b4a.objects.LabelWrapper();
_ll = new anywheresoftware.b4a.objects.LabelWrapper();
_lll = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2097230;
 //BA.debugLineNum = 2097230;BA.debugLine="l.Initialize(\"cell\")";
_l.Initialize(mostCurrent.activityBA,"cell");
RDebugUtils.currentLine=2097231;
 //BA.debugLineNum = 2097231;BA.debugLine="l.Text = textList.Get(i)";
_l.setText(_textlist.Get(_i));
RDebugUtils.currentLine=2097232;
 //BA.debugLineNum = 2097232;BA.debugLine="l.Typeface = font.proximanovaRegular";
_l.setTypeface((android.graphics.Typeface)(mostCurrent._font._proximanovaregular(null).getObject()));
RDebugUtils.currentLine=2097233;
 //BA.debugLineNum = 2097233;BA.debugLine="l.TextColor = Colors.RGB(179,179,179)";
_l.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (179),(int) (179),(int) (179)));
RDebugUtils.currentLine=2097235;
 //BA.debugLineNum = 2097235;BA.debugLine="refDetWrapper.AddView(l,0,topPos,120dip,20dip)";
_refdetwrapper.AddView((android.view.View)(_l.getObject()),(int) (0),_toppos,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (120)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)));
RDebugUtils.currentLine=2097237;
 //BA.debugLineNum = 2097237;BA.debugLine="ll.Initialize(\"cell2\")";
_ll.Initialize(mostCurrent.activityBA,"cell2");
RDebugUtils.currentLine=2097238;
 //BA.debugLineNum = 2097238;BA.debugLine="ll.Text = \":\"";
_ll.setText((Object)(":"));
RDebugUtils.currentLine=2097239;
 //BA.debugLineNum = 2097239;BA.debugLine="ll.Typeface = font.proximanovaRegular";
_ll.setTypeface((android.graphics.Typeface)(mostCurrent._font._proximanovaregular(null).getObject()));
RDebugUtils.currentLine=2097240;
 //BA.debugLineNum = 2097240;BA.debugLine="ll.TextColor = Colors.RGB(179,179,179)";
_ll.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (179),(int) (179),(int) (179)));
RDebugUtils.currentLine=2097241;
 //BA.debugLineNum = 2097241;BA.debugLine="refDetWrapper.AddView(ll,l.Width,topPos,10dip,20";
_refdetwrapper.AddView((android.view.View)(_ll.getObject()),_l.getWidth(),_toppos,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)));
RDebugUtils.currentLine=2097243;
 //BA.debugLineNum = 2097243;BA.debugLine="lll.Initialize(\"cell3\")";
_lll.Initialize(mostCurrent.activityBA,"cell3");
RDebugUtils.currentLine=2097245;
 //BA.debugLineNum = 2097245;BA.debugLine="If i > 0 Then";
if (_i>0) { 
RDebugUtils.currentLine=2097246;
 //BA.debugLineNum = 2097246;BA.debugLine="lll.TextColor = Colors.RGB(74,74,74)";
_lll.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (74),(int) (74),(int) (74)));
 }else {
RDebugUtils.currentLine=2097248;
 //BA.debugLineNum = 2097248;BA.debugLine="lll.TextColor = Colors.RGB(179,179,179)";
_lll.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (179),(int) (179),(int) (179)));
 };
RDebugUtils.currentLine=2097251;
 //BA.debugLineNum = 2097251;BA.debugLine="lll.Typeface = font.proximanovaRegular";
_lll.setTypeface((android.graphics.Typeface)(mostCurrent._font._proximanovaregular(null).getObject()));
RDebugUtils.currentLine=2097252;
 //BA.debugLineNum = 2097252;BA.debugLine="If valueList.Get(i) = \"\" Then";
if ((_valuelist.Get(_i)).equals((Object)(""))) { 
RDebugUtils.currentLine=2097253;
 //BA.debugLineNum = 2097253;BA.debugLine="lll.Text = \"-\"";
_lll.setText((Object)("-"));
 }else {
RDebugUtils.currentLine=2097255;
 //BA.debugLineNum = 2097255;BA.debugLine="lll.Text = valueList.Get(i)";
_lll.setText(_valuelist.Get(_i));
 };
RDebugUtils.currentLine=2097257;
 //BA.debugLineNum = 2097257;BA.debugLine="refDetWrapper.AddView(lll,l.Width+ll.Width+Gap,t";
_refdetwrapper.AddView((android.view.View)(_lll.getObject()),(int) (_l.getWidth()+_ll.getWidth()+_gap),_toppos,(int) (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA)/(double)1.5),(int) (-2));
RDebugUtils.currentLine=2097258;
 //BA.debugLineNum = 2097258;BA.debugLine="Dim x As Int";
_x = 0;
RDebugUtils.currentLine=2097259;
 //BA.debugLineNum = 2097259;BA.debugLine="x = su.MeasureMultilineTextHeight(lll,lll.Text)";
_x = mostCurrent._su.MeasureMultilineTextHeight((android.widget.TextView)(_lll.getObject()),_lll.getText());
RDebugUtils.currentLine=2097261;
 //BA.debugLineNum = 2097261;BA.debugLine="topPos = topPos + x + Gap";
_toppos = (int) (_toppos+_x+_gap);
 }
};
RDebugUtils.currentLine=2097266;
 //BA.debugLineNum = 2097266;BA.debugLine="detailList.Add(detailPanel)";
mostCurrent._detaillist.Add((Object)(_detailpanel.getObject()));
RDebugUtils.currentLine=2097269;
 //BA.debugLineNum = 2097269;BA.debugLine="showIcon.Initialize(\"showIcon\")";
mostCurrent._showicon.Initialize(mostCurrent.activityBA,"showIcon");
RDebugUtils.currentLine=2097270;
 //BA.debugLineNum = 2097270;BA.debugLine="showIcon.Bitmap = LoadBitmap(File.DirAssets,\"Show";
mostCurrent._showicon.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"Show.png").getObject()));
RDebugUtils.currentLine=2097271;
 //BA.debugLineNum = 2097271;BA.debugLine="showIcon.Gravity = Gravity.FILL";
mostCurrent._showicon.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
RDebugUtils.currentLine=2097272;
 //BA.debugLineNum = 2097272;BA.debugLine="Container.AddView(showIcon,(detailPanel.Width/2)-";
mostCurrent._container.AddView((android.view.View)(mostCurrent._showicon.getObject()),(int) ((_detailpanel.getWidth()/(double)2)-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (15))),(int) (_detailpanel.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)));
RDebugUtils.currentLine=2097275;
 //BA.debugLineNum = 2097275;BA.debugLine="closeIcon.Initialize(\"closeIcon\")";
mostCurrent._closeicon.Initialize(mostCurrent.activityBA,"closeIcon");
RDebugUtils.currentLine=2097276;
 //BA.debugLineNum = 2097276;BA.debugLine="closeIcon.Bitmap = LoadBitmap(File.DirAssets,\"Clo";
mostCurrent._closeicon.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"Close.png").getObject()));
RDebugUtils.currentLine=2097277;
 //BA.debugLineNum = 2097277;BA.debugLine="closeIcon.Visible = False";
mostCurrent._closeicon.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2097278;
 //BA.debugLineNum = 2097278;BA.debugLine="closeIcon.Gravity = Gravity.FILL";
mostCurrent._closeicon.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
RDebugUtils.currentLine=2097279;
 //BA.debugLineNum = 2097279;BA.debugLine="Container.AddView(closeIcon,(detailPanel.Width/2)";
mostCurrent._container.AddView((android.view.View)(mostCurrent._closeicon.getObject()),(int) ((_detailpanel.getWidth()/(double)2)-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (15))),(int) (_detailpanel.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)));
RDebugUtils.currentLine=2097281;
 //BA.debugLineNum = 2097281;BA.debugLine="Dim utilTextW As Int = 100dip";
_utiltextw = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100));
RDebugUtils.currentLine=2097284;
 //BA.debugLineNum = 2097284;BA.debugLine="utilText.Initialize(\"\")";
_utiltext.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2097285;
 //BA.debugLineNum = 2097285;BA.debugLine="Container.AddView(utilText,0,detailPanel.Height,1";
mostCurrent._container.AddView((android.view.View)(_utiltext.getObject()),(int) (0),_detailpanel.getHeight(),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (70)));
RDebugUtils.currentLine=2097286;
 //BA.debugLineNum = 2097286;BA.debugLine="utilText.TextColor = Colors.RGB(179,179,179)";
_utiltext.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (179),(int) (179),(int) (179)));
RDebugUtils.currentLine=2097287;
 //BA.debugLineNum = 2097287;BA.debugLine="utilText.Text = \"Show candidate details\"";
_utiltext.setText((Object)("Show candidate details"));
RDebugUtils.currentLine=2097288;
 //BA.debugLineNum = 2097288;BA.debugLine="utilText.Gravity = Gravity.CENTER";
_utiltext.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=2097291;
 //BA.debugLineNum = 2097291;BA.debugLine="detailList.Add(utilText)";
mostCurrent._detaillist.Add((Object)(_utiltext.getObject()));
RDebugUtils.currentLine=2097294;
 //BA.debugLineNum = 2097294;BA.debugLine="jobTitlePanel.Initialize(\"\")";
_jobtitlepanel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2097295;
 //BA.debugLineNum = 2097295;BA.debugLine="Container.AddView(jobTitlePanel,0,(detailPanel.He";
mostCurrent._container.AddView((android.view.View)(_jobtitlepanel.getObject()),(int) (0),(int) ((_detailpanel.getHeight()+_utiltext.getHeight())-_gap),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
RDebugUtils.currentLine=2097296;
 //BA.debugLineNum = 2097296;BA.debugLine="jobTitlePanel.Color = Colors.White";
_jobtitlepanel.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=2097299;
 //BA.debugLineNum = 2097299;BA.debugLine="detailList.Add(jobTitlePanel)";
mostCurrent._detaillist.Add((Object)(_jobtitlepanel.getObject()));
RDebugUtils.currentLine=2097301;
 //BA.debugLineNum = 2097301;BA.debugLine="jobTitle.Initialize(\"\")";
_jobtitle.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2097302;
 //BA.debugLineNum = 2097302;BA.debugLine="jobTitle.Text = \"Referal Progress for \"&dataJobti";
_jobtitle.setText((Object)("Referal Progress for "+_datajobtitle));
RDebugUtils.currentLine=2097304;
 //BA.debugLineNum = 2097304;BA.debugLine="jobTitle.TextColor = Colors.RGB(74,74,74)";
_jobtitle.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (74),(int) (74),(int) (74)));
RDebugUtils.currentLine=2097305;
 //BA.debugLineNum = 2097305;BA.debugLine="jobTitlePanel.AddView(jobTitle,10dip,6dip,jobTitl";
_jobtitlepanel.AddView((android.view.View)(_jobtitle.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (6)),(int) (_jobtitlepanel.getWidth()-(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))*2)),_jobtitlepanel.getHeight());
RDebugUtils.currentLine=2097306;
 //BA.debugLineNum = 2097306;BA.debugLine="Dim titleHeight As Int";
_titleheight = 0;
RDebugUtils.currentLine=2097307;
 //BA.debugLineNum = 2097307;BA.debugLine="titleHeight = su.MeasureMultilineTextHeight(jobTi";
_titleheight = mostCurrent._su.MeasureMultilineTextHeight((android.widget.TextView)(_jobtitle.getObject()),_jobtitle.getText());
RDebugUtils.currentLine=2097309;
 //BA.debugLineNum = 2097309;BA.debugLine="jobTitlePanel.Height = titleHeight + 20dip";
_jobtitlepanel.setHeight((int) (_titleheight+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))));
RDebugUtils.currentLine=2097311;
 //BA.debugLineNum = 2097311;BA.debugLine="scrollView.Initialize(Activity.Height)";
mostCurrent._scrollview.Initialize(mostCurrent.activityBA,mostCurrent._activity.getHeight());
RDebugUtils.currentLine=2097312;
 //BA.debugLineNum = 2097312;BA.debugLine="scrollView.Color = Colors.White";
mostCurrent._scrollview.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=2097313;
 //BA.debugLineNum = 2097313;BA.debugLine="Container.AddView(scrollView,0,(detailPanel.Heigh";
mostCurrent._container.AddView((android.view.View)(mostCurrent._scrollview.getObject()),(int) (0),(int) ((_detailpanel.getHeight()+_utiltext.getHeight()+_jobtitlepanel.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)))),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
RDebugUtils.currentLine=2097314;
 //BA.debugLineNum = 2097314;BA.debugLine="journeyPanel = scrollView.Panel";
_journeypanel = mostCurrent._scrollview.getPanel();
RDebugUtils.currentLine=2097317;
 //BA.debugLineNum = 2097317;BA.debugLine="detailList.Add(journeyPanel)";
mostCurrent._detaillist.Add((Object)(_journeypanel.getObject()));
RDebugUtils.currentLine=2097319;
 //BA.debugLineNum = 2097319;BA.debugLine="Dim referenceWrapper As Panel";
_referencewrapper = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=2097320;
 //BA.debugLineNum = 2097320;BA.debugLine="referenceWrapper.Initialize(\"\")";
_referencewrapper.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2097322;
 //BA.debugLineNum = 2097322;BA.debugLine="PanelTop = 0";
_paneltop = (int) (0);
RDebugUtils.currentLine=2097323;
 //BA.debugLineNum = 2097323;BA.debugLine="IconTop = 12dip";
_icontop = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (12));
RDebugUtils.currentLine=2097325;
 //BA.debugLineNum = 2097325;BA.debugLine="Dim journeys As List = root.Get(\"journeys\")";
_journeys = new anywheresoftware.b4a.objects.collections.List();
_journeys.setObject((java.util.List)(_root.Get((Object)("journeys"))));
RDebugUtils.currentLine=2097326;
 //BA.debugLineNum = 2097326;BA.debugLine="Dim iterator As Int = 1";
_iterator = (int) (1);
RDebugUtils.currentLine=2097327;
 //BA.debugLineNum = 2097327;BA.debugLine="Dim LastIconTop As Int";
_lasticontop = 0;
RDebugUtils.currentLine=2097328;
 //BA.debugLineNum = 2097328;BA.debugLine="Dim IncrementBoxHeight As Int";
_incrementboxheight = 0;
RDebugUtils.currentLine=2097329;
 //BA.debugLineNum = 2097329;BA.debugLine="Dim BoxHeight As Int = 50dip";
_boxheight = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50));
RDebugUtils.currentLine=2097331;
 //BA.debugLineNum = 2097331;BA.debugLine="journeyPanel.AddView(referenceWrapper,30dip,Panel";
_journeypanel.AddView((android.view.View)(_referencewrapper.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)),_paneltop,(int) (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA)-(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30))*2)),_boxheight);
RDebugUtils.currentLine=2097333;
 //BA.debugLineNum = 2097333;BA.debugLine="For Each coljourneys As Map In journeys";
_coljourneys = new anywheresoftware.b4a.objects.collections.Map();
final anywheresoftware.b4a.BA.IterableList group119 = _journeys;
final int groupLen119 = group119.getSize();
for (int index119 = 0;index119 < groupLen119 ;index119++){
_coljourneys.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(group119.Get(index119)));
RDebugUtils.currentLine=2097334;
 //BA.debugLineNum = 2097334;BA.debugLine="Dim journeyText As String = coljourneys.Get(\"tex";
_journeytext = BA.ObjectToString(_coljourneys.Get((Object)("text")));
RDebugUtils.currentLine=2097335;
 //BA.debugLineNum = 2097335;BA.debugLine="Dim rStatus As String = coljourneys.Get(\"status\"";
_rstatus = BA.ObjectToString(_coljourneys.Get((Object)("status")));
RDebugUtils.currentLine=2097336;
 //BA.debugLineNum = 2097336;BA.debugLine="Dim rState As String = coljourneys.Get(\"state_st";
_rstate = BA.ObjectToString(_coljourneys.Get((Object)("state_status")));
RDebugUtils.currentLine=2097337;
 //BA.debugLineNum = 2097337;BA.debugLine="Dim rStateDesc As String = coljourneys.Get(\"stat";
_rstatedesc = BA.ObjectToString(_coljourneys.Get((Object)("state_description")));
RDebugUtils.currentLine=2097338;
 //BA.debugLineNum = 2097338;BA.debugLine="Dim daysAgo As String = coljourneys.Get(\"days_ag";
_daysago = BA.ObjectToString(_coljourneys.Get((Object)("days_ago")));
RDebugUtils.currentLine=2097340;
 //BA.debugLineNum = 2097340;BA.debugLine="progressBox.Initialize(\"\")";
_progressbox.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2097342;
 //BA.debugLineNum = 2097342;BA.debugLine="journeyPanel.AddView(progressBox,30dip,PanelTop,";
_journeypanel.AddView((android.view.View)(_progressbox.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)),_paneltop,(int) (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA)-(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30))*2)),_boxheight);
RDebugUtils.currentLine=2097344;
 //BA.debugLineNum = 2097344;BA.debugLine="Dim iconName As String";
_iconname = "";
RDebugUtils.currentLine=2097345;
 //BA.debugLineNum = 2097345;BA.debugLine="If rStatus = \"null\" Then";
if ((_rstatus).equals("null")) { 
RDebugUtils.currentLine=2097346;
 //BA.debugLineNum = 2097346;BA.debugLine="Select rState";
switch (BA.switchObjectToInt(_rstate,"WAITING","COMPLETE","FAILED")) {
case 0: {
RDebugUtils.currentLine=2097348;
 //BA.debugLineNum = 2097348;BA.debugLine="iconName = \"Progress.png\"";
_iconname = "Progress.png";
 break; }
case 1: {
RDebugUtils.currentLine=2097350;
 //BA.debugLineNum = 2097350;BA.debugLine="iconName = \"Done.png\"";
_iconname = "Done.png";
 break; }
case 2: {
RDebugUtils.currentLine=2097352;
 //BA.debugLineNum = 2097352;BA.debugLine="iconName = \"Fail.png\"";
_iconname = "Fail.png";
 break; }
}
;
 }else {
RDebugUtils.currentLine=2097355;
 //BA.debugLineNum = 2097355;BA.debugLine="iconName = \"Done.png\"";
_iconname = "Done.png";
 };
RDebugUtils.currentLine=2097359;
 //BA.debugLineNum = 2097359;BA.debugLine="Dim statusIcon As ImageView";
_statusicon = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=2097360;
 //BA.debugLineNum = 2097360;BA.debugLine="statusIcon.Initialize(\"\")";
_statusicon.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2097361;
 //BA.debugLineNum = 2097361;BA.debugLine="statusIcon.Bitmap = LoadBitmap(File.DirAssets,ic";
_statusicon.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),_iconname).getObject()));
RDebugUtils.currentLine=2097362;
 //BA.debugLineNum = 2097362;BA.debugLine="statusIcon.Gravity = Gravity.FILL";
_statusicon.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
RDebugUtils.currentLine=2097363;
 //BA.debugLineNum = 2097363;BA.debugLine="journeyPanel.AddView(statusIcon,30dip-7.5dip,Ico";
_journeypanel.AddView((android.view.View)(_statusicon.getObject()),(int) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30))-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (7.5))),_icontop,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (16)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (16)));
RDebugUtils.currentLine=2097366;
 //BA.debugLineNum = 2097366;BA.debugLine="If rStatus <> \"null\" Then";
if ((_rstatus).equals("null") == false) { 
RDebugUtils.currentLine=2097367;
 //BA.debugLineNum = 2097367;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
RDebugUtils.currentLine=2097368;
 //BA.debugLineNum = 2097368;BA.debugLine="refStatus.Initialize(\"\")";
_refstatus.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2097369;
 //BA.debugLineNum = 2097369;BA.debugLine="Select rStatus";
switch (BA.switchObjectToInt(_rstatus,"qualifying","interview_by_consultant","sent_to_client","1st_interview","2nd_interview","3rd_interview","follow_up","hired","1st_day")) {
case 0: {
RDebugUtils.currentLine=2097371;
 //BA.debugLineNum = 2097371;BA.debugLine="cd.Initialize(Colors.RGB(249,128,55), 2dip)";
_cd.Initialize(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (249),(int) (128),(int) (55)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)));
RDebugUtils.currentLine=2097372;
 //BA.debugLineNum = 2097372;BA.debugLine="refStatus.Background = cd";
_refstatus.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
 break; }
case 1: {
RDebugUtils.currentLine=2097374;
 //BA.debugLineNum = 2097374;BA.debugLine="cd.Initialize(Colors.RGB(248,190,56), 2dip)";
_cd.Initialize(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (248),(int) (190),(int) (56)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)));
RDebugUtils.currentLine=2097375;
 //BA.debugLineNum = 2097375;BA.debugLine="refStatus.Background = cd";
_refstatus.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
 break; }
case 2: {
RDebugUtils.currentLine=2097377;
 //BA.debugLineNum = 2097377;BA.debugLine="cd.Initialize(Colors.RGB(186,220,63), 2dip)";
_cd.Initialize(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (186),(int) (220),(int) (63)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)));
RDebugUtils.currentLine=2097378;
 //BA.debugLineNum = 2097378;BA.debugLine="refStatus.Background = cd";
_refstatus.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
 break; }
case 3: 
case 4: 
case 5: {
RDebugUtils.currentLine=2097380;
 //BA.debugLineNum = 2097380;BA.debugLine="cd.Initialize(Colors.RGB(103,195,68), 2dip)";
_cd.Initialize(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (103),(int) (195),(int) (68)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)));
RDebugUtils.currentLine=2097381;
 //BA.debugLineNum = 2097381;BA.debugLine="refStatus.Background = cd";
_refstatus.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
 break; }
case 6: {
RDebugUtils.currentLine=2097383;
 //BA.debugLineNum = 2097383;BA.debugLine="cd.Initialize(Colors.RGB(62,222,176), 2dip)";
_cd.Initialize(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (62),(int) (222),(int) (176)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)));
RDebugUtils.currentLine=2097384;
 //BA.debugLineNum = 2097384;BA.debugLine="refStatus.Background = cd";
_refstatus.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
 break; }
case 7: {
RDebugUtils.currentLine=2097386;
 //BA.debugLineNum = 2097386;BA.debugLine="cd.Initialize(Colors.RGB(21,176,220), 2dip)";
_cd.Initialize(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (21),(int) (176),(int) (220)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)));
RDebugUtils.currentLine=2097387;
 //BA.debugLineNum = 2097387;BA.debugLine="refStatus.Background = cd";
_refstatus.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
 break; }
case 8: {
RDebugUtils.currentLine=2097389;
 //BA.debugLineNum = 2097389;BA.debugLine="cd.Initialize(Colors.RGB(38,143,235), 2dip)";
_cd.Initialize(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (38),(int) (143),(int) (235)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)));
RDebugUtils.currentLine=2097390;
 //BA.debugLineNum = 2097390;BA.debugLine="refStatus.Background = cd";
_refstatus.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
 break; }
default: {
RDebugUtils.currentLine=2097392;
 //BA.debugLineNum = 2097392;BA.debugLine="cd.Initialize(Colors.RGB(3,117,216), 2dip)";
_cd.Initialize(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (3),(int) (117),(int) (216)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)));
RDebugUtils.currentLine=2097393;
 //BA.debugLineNum = 2097393;BA.debugLine="refStatus.Background = cd";
_refstatus.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
 break; }
}
;
RDebugUtils.currentLine=2097396;
 //BA.debugLineNum = 2097396;BA.debugLine="refStatus.TextColor = Colors.White";
_refstatus.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=2097398;
 //BA.debugLineNum = 2097398;BA.debugLine="refStatus.Text = ToMixCase(rStatus.Replace(\"_\",";
_refstatus.setText((Object)(_tomixcase(_rstatus.replace("_"," "))));
RDebugUtils.currentLine=2097399;
 //BA.debugLineNum = 2097399;BA.debugLine="refStatus.Typeface = font.proximanovaSemiBold";
_refstatus.setTypeface((android.graphics.Typeface)(mostCurrent._font._proximanovasemibold(null).getObject()));
RDebugUtils.currentLine=2097400;
 //BA.debugLineNum = 2097400;BA.debugLine="refStatus.Gravity = Gravity.CENTER";
_refstatus.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=2097401;
 //BA.debugLineNum = 2097401;BA.debugLine="progressBox.AddView(refStatus,15dip,10dip,100di";
_progressbox.AddView((android.view.View)(_refstatus.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (15)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)));
RDebugUtils.currentLine=2097402;
 //BA.debugLineNum = 2097402;BA.debugLine="Dim refStatusHeight As Int";
_refstatusheight = 0;
RDebugUtils.currentLine=2097403;
 //BA.debugLineNum = 2097403;BA.debugLine="refStatusHeight =  su.MeasureMultilineTextHeigh";
_refstatusheight = mostCurrent._su.MeasureMultilineTextHeight((android.widget.TextView)(_refstatus.getObject()),_refstatus.getText());
RDebugUtils.currentLine=2097405;
 //BA.debugLineNum = 2097405;BA.debugLine="If refStatusHeight > refStatus.Height Then";
if (_refstatusheight>_refstatus.getHeight()) { 
RDebugUtils.currentLine=2097406;
 //BA.debugLineNum = 2097406;BA.debugLine="refStatus.Height = refStatusHeight";
_refstatus.setHeight(_refstatusheight);
 };
RDebugUtils.currentLine=2097410;
 //BA.debugLineNum = 2097410;BA.debugLine="Dim refDay As Label";
_refday = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2097411;
 //BA.debugLineNum = 2097411;BA.debugLine="refDay.Initialize(\"\")";
_refday.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2097412;
 //BA.debugLineNum = 2097412;BA.debugLine="refDay.Text = daysAgo&\"d\"";
_refday.setText((Object)(_daysago+"d"));
RDebugUtils.currentLine=2097413;
 //BA.debugLineNum = 2097413;BA.debugLine="refDay.Typeface = font.proximanovaRegular";
_refday.setTypeface((android.graphics.Typeface)(mostCurrent._font._proximanovaregular(null).getObject()));
RDebugUtils.currentLine=2097414;
 //BA.debugLineNum = 2097414;BA.debugLine="refDay.TextColor = Colors.RGB(179,179,179)";
_refday.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (179),(int) (179),(int) (179)));
RDebugUtils.currentLine=2097415;
 //BA.debugLineNum = 2097415;BA.debugLine="refDay.TextSize = refName.TextSize / 1.25";
_refday.setTextSize((float) (_refname.getTextSize()/(double)1.25));
RDebugUtils.currentLine=2097416;
 //BA.debugLineNum = 2097416;BA.debugLine="progressBox.AddView(refDay,15dip,refStatus.Top+";
_progressbox.AddView((android.view.View)(_refday.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (15)),(int) (_refstatus.getTop()+_refstatus.getHeight()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)));
 };
RDebugUtils.currentLine=2097420;
 //BA.debugLineNum = 2097420;BA.debugLine="refText.Initialize(\"\")";
_reftext.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2097421;
 //BA.debugLineNum = 2097421;BA.debugLine="refText.Typeface = font.proximanovaRegular";
_reftext.setTypeface((android.graphics.Typeface)(mostCurrent._font._proximanovaregular(null).getObject()));
RDebugUtils.currentLine=2097423;
 //BA.debugLineNum = 2097423;BA.debugLine="If rStatus <> \"null\" Then";
if ((_rstatus).equals("null") == false) { 
RDebugUtils.currentLine=2097424;
 //BA.debugLineNum = 2097424;BA.debugLine="refText.Text = journeyText";
_reftext.setText((Object)(_journeytext));
RDebugUtils.currentLine=2097425;
 //BA.debugLineNum = 2097425;BA.debugLine="progressBox.AddView(refText,refStatus.Left+refS";
_progressbox.AddView((android.view.View)(_reftext.getObject()),(int) (_refstatus.getLeft()+_refstatus.getWidth()+_gap),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),(int) (_progressbox.getWidth()/(double)2),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)));
 }else {
RDebugUtils.currentLine=2097427;
 //BA.debugLineNum = 2097427;BA.debugLine="refText.Text = rStateDesc";
_reftext.setText((Object)(_rstatedesc));
RDebugUtils.currentLine=2097428;
 //BA.debugLineNum = 2097428;BA.debugLine="progressBox.AddView(refText,15dip,13.5dip,progr";
_progressbox.AddView((android.view.View)(_reftext.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (15)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (13.5)),(int) (_progressbox.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)));
 };
RDebugUtils.currentLine=2097432;
 //BA.debugLineNum = 2097432;BA.debugLine="Dim TextHeight As Int";
_textheight = 0;
RDebugUtils.currentLine=2097433;
 //BA.debugLineNum = 2097433;BA.debugLine="TextHeight =  su.MeasureMultilineTextHeight(refT";
_textheight = mostCurrent._su.MeasureMultilineTextHeight((android.widget.TextView)(_reftext.getObject()),_reftext.getText());
RDebugUtils.currentLine=2097435;
 //BA.debugLineNum = 2097435;BA.debugLine="If refText.Height < TextHeight Then";
if (_reftext.getHeight()<_textheight) { 
RDebugUtils.currentLine=2097437;
 //BA.debugLineNum = 2097437;BA.debugLine="refText.Height = TextHeight";
_reftext.setHeight(_textheight);
RDebugUtils.currentLine=2097438;
 //BA.debugLineNum = 2097438;BA.debugLine="If progressBox.Height < TextHeight+refText.Top";
if (_progressbox.getHeight()<_textheight+_reftext.getTop()) { 
RDebugUtils.currentLine=2097439;
 //BA.debugLineNum = 2097439;BA.debugLine="Dim addHeight As Int = (TextHeight+refText.Top";
_addheight = (int) ((_textheight+_reftext.getTop())-_progressbox.getHeight());
RDebugUtils.currentLine=2097440;
 //BA.debugLineNum = 2097440;BA.debugLine="progressBox.Height = progressBox.Height + addH";
_progressbox.setHeight((int) (_progressbox.getHeight()+_addheight+_reftext.getTop()));
 };
 };
RDebugUtils.currentLine=2097445;
 //BA.debugLineNum = 2097445;BA.debugLine="IconTop = IconTop + progressBox.Height + Gap";
_icontop = (int) (_icontop+_progressbox.getHeight()+_gap);
RDebugUtils.currentLine=2097446;
 //BA.debugLineNum = 2097446;BA.debugLine="PanelTop = PanelTop + progressBox.Height + Gap";
_paneltop = (int) (_paneltop+_progressbox.getHeight()+_gap);
RDebugUtils.currentLine=2097447;
 //BA.debugLineNum = 2097447;BA.debugLine="LastIconTop = statusIcon.Top";
_lasticontop = _statusicon.getTop();
 }
;
RDebugUtils.currentLine=2097450;
 //BA.debugLineNum = 2097450;BA.debugLine="journeyPanel.Height = PanelTop + scrollView.Top";
_journeypanel.setHeight((int) (_paneltop+mostCurrent._scrollview.getTop()));
RDebugUtils.currentLine=2097452;
 //BA.debugLineNum = 2097452;BA.debugLine="referenceWrapper.Height = LastIconTop";
_referencewrapper.setHeight(_lasticontop);
RDebugUtils.currentLine=2097453;
 //BA.debugLineNum = 2097453;BA.debugLine="DrawDashLine(referenceWrapper,0,0,0,referenceWrap";
_drawdashline((anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_referencewrapper.getObject())),(float) (0),(float) (0),(float) (0),(float) (_referencewrapper.getHeight()),anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (177),(int) (177),(int) (177)),(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (4))));
RDebugUtils.currentLine=2097455;
 //BA.debugLineNum = 2097455;BA.debugLine="End Sub";
return "";
}
public static String  _tomixcase(String _entry) throws Exception{
RDebugUtils.currentModule="referringprogress";
if (Debug.shouldDelegate(mostCurrent.activityBA, "tomixcase"))
	return (String) Debug.delegate(mostCurrent.activityBA, "tomixcase", new Object[] {_entry});
anywheresoftware.b4a.keywords.StringBuilderWrapper _sb = null;
anywheresoftware.b4a.keywords.Regex.MatcherWrapper _m = null;
int _i = 0;
RDebugUtils.currentLine=2752512;
 //BA.debugLineNum = 2752512;BA.debugLine="Sub ToMixCase(Entry As String) As String";
RDebugUtils.currentLine=2752514;
 //BA.debugLineNum = 2752514;BA.debugLine="Dim sb As StringBuilder";
_sb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
RDebugUtils.currentLine=2752515;
 //BA.debugLineNum = 2752515;BA.debugLine="Dim m As Matcher";
_m = new anywheresoftware.b4a.keywords.Regex.MatcherWrapper();
RDebugUtils.currentLine=2752516;
 //BA.debugLineNum = 2752516;BA.debugLine="Dim I As Int";
_i = 0;
RDebugUtils.currentLine=2752518;
 //BA.debugLineNum = 2752518;BA.debugLine="Entry = Entry.ToLowerCase";
_entry = _entry.toLowerCase();
RDebugUtils.currentLine=2752520;
 //BA.debugLineNum = 2752520;BA.debugLine="sb.Initialize";
_sb.Initialize();
RDebugUtils.currentLine=2752522;
 //BA.debugLineNum = 2752522;BA.debugLine="m = Regex.Matcher(\"(^\\w)|(\\s\\w)\", Entry)";
_m = anywheresoftware.b4a.keywords.Common.Regex.Matcher("(^\\w)|(\\s\\w)",_entry);
RDebugUtils.currentLine=2752524;
 //BA.debugLineNum = 2752524;BA.debugLine="Do While m.Find";
while (_m.Find()) {
RDebugUtils.currentLine=2752526;
 //BA.debugLineNum = 2752526;BA.debugLine="If m.Match.Length > 1 Then";
if (_m.getMatch().length()>1) { 
RDebugUtils.currentLine=2752528;
 //BA.debugLineNum = 2752528;BA.debugLine="sb.Append(Entry.SubString2(I, m.GetStart";
_sb.Append(_entry.substring(_i,(int) (_m.GetStart((int) (0))+1)));
RDebugUtils.currentLine=2752529;
 //BA.debugLineNum = 2752529;BA.debugLine="sb.Append(m.Match.SubString(1).ToUpperCa";
_sb.Append(_m.getMatch().substring((int) (1)).toUpperCase());
 }else {
RDebugUtils.currentLine=2752533;
 //BA.debugLineNum = 2752533;BA.debugLine="sb.Append(Entry.SubString2(I, m.GetStart";
_sb.Append(_entry.substring(_i,_m.GetStart((int) (0))));
RDebugUtils.currentLine=2752534;
 //BA.debugLineNum = 2752534;BA.debugLine="sb.Append(m.Match.ToUpperCase)";
_sb.Append(_m.getMatch().toUpperCase());
 };
RDebugUtils.currentLine=2752538;
 //BA.debugLineNum = 2752538;BA.debugLine="I = m.GetEnd(0)";
_i = _m.GetEnd((int) (0));
 }
;
RDebugUtils.currentLine=2752542;
 //BA.debugLineNum = 2752542;BA.debugLine="If I < Entry.Length Then";
if (_i<_entry.length()) { 
RDebugUtils.currentLine=2752544;
 //BA.debugLineNum = 2752544;BA.debugLine="sb.Append(Entry.SubString(I))";
_sb.Append(_entry.substring(_i));
 };
RDebugUtils.currentLine=2752548;
 //BA.debugLineNum = 2752548;BA.debugLine="Return sb.ToString";
if (true) return _sb.ToString();
RDebugUtils.currentLine=2752550;
 //BA.debugLineNum = 2752550;BA.debugLine="End Sub";
return "";
}
public static String  _showicon_click() throws Exception{
RDebugUtils.currentModule="referringprogress";
if (Debug.shouldDelegate(mostCurrent.activityBA, "showicon_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "showicon_click", null);
anywheresoftware.b4a.objects.PanelWrapper _detailpanel = null;
anywheresoftware.b4a.objects.PanelWrapper _jobtitlepanel = null;
anywheresoftware.b4a.objects.PanelWrapper _journeypanel = null;
anywheresoftware.b4a.objects.LabelWrapper _utiltextlabel = null;
RDebugUtils.currentLine=2424832;
 //BA.debugLineNum = 2424832;BA.debugLine="Sub showIcon_Click";
RDebugUtils.currentLine=2424833;
 //BA.debugLineNum = 2424833;BA.debugLine="Dim detailPanel,jobTitlePanel,journeyPanel As Pan";
_detailpanel = new anywheresoftware.b4a.objects.PanelWrapper();
_jobtitlepanel = new anywheresoftware.b4a.objects.PanelWrapper();
_journeypanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=2424834;
 //BA.debugLineNum = 2424834;BA.debugLine="Dim utilTextLabel As Label";
_utiltextlabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2424836;
 //BA.debugLineNum = 2424836;BA.debugLine="detailPanel = detailList.Get(0)";
_detailpanel.setObject((android.view.ViewGroup)(mostCurrent._detaillist.Get((int) (0))));
RDebugUtils.currentLine=2424837;
 //BA.debugLineNum = 2424837;BA.debugLine="utilTextLabel = detailList.Get(1)";
_utiltextlabel.setObject((android.widget.TextView)(mostCurrent._detaillist.Get((int) (1))));
RDebugUtils.currentLine=2424838;
 //BA.debugLineNum = 2424838;BA.debugLine="jobTitlePanel = detailList.Get(2)";
_jobtitlepanel.setObject((android.view.ViewGroup)(mostCurrent._detaillist.Get((int) (2))));
RDebugUtils.currentLine=2424839;
 //BA.debugLineNum = 2424839;BA.debugLine="journeyPanel = detailList.Get(3)";
_journeypanel.setObject((android.view.ViewGroup)(mostCurrent._detaillist.Get((int) (3))));
RDebugUtils.currentLine=2424841;
 //BA.debugLineNum = 2424841;BA.debugLine="detailPanel.Height = detailPanel.Height + 200dip";
_detailpanel.setHeight((int) (_detailpanel.getHeight()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (200))));
RDebugUtils.currentLine=2424842;
 //BA.debugLineNum = 2424842;BA.debugLine="utilTextLabel.Top = detailPanel.Height";
_utiltextlabel.setTop(_detailpanel.getHeight());
RDebugUtils.currentLine=2424843;
 //BA.debugLineNum = 2424843;BA.debugLine="utilTextLabel.Text = \"Hide candidate details\"";
_utiltextlabel.setText((Object)("Hide candidate details"));
RDebugUtils.currentLine=2424844;
 //BA.debugLineNum = 2424844;BA.debugLine="jobTitlePanel.Top = utilTextLabel.Top + utilTextL";
_jobtitlepanel.setTop((int) (_utiltextlabel.getTop()+_utiltextlabel.getHeight()));
RDebugUtils.currentLine=2424845;
 //BA.debugLineNum = 2424845;BA.debugLine="scrollView.Top = jobTitlePanel.Top + jobTitlePane";
mostCurrent._scrollview.setTop((int) (_jobtitlepanel.getTop()+_jobtitlepanel.getHeight()));
RDebugUtils.currentLine=2424846;
 //BA.debugLineNum = 2424846;BA.debugLine="journeyPanel.Height = journeyPanel.Height + jobTi";
_journeypanel.setHeight((int) (_journeypanel.getHeight()+_jobtitlepanel.getTop()+_jobtitlepanel.getHeight()));
RDebugUtils.currentLine=2424848;
 //BA.debugLineNum = 2424848;BA.debugLine="showIcon.Visible = False";
mostCurrent._showicon.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2424850;
 //BA.debugLineNum = 2424850;BA.debugLine="closeIcon.Top = detailPanel.Height - 5dip";
mostCurrent._closeicon.setTop((int) (_detailpanel.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))));
RDebugUtils.currentLine=2424851;
 //BA.debugLineNum = 2424851;BA.debugLine="closeIcon.Visible = True";
mostCurrent._closeicon.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2424852;
 //BA.debugLineNum = 2424852;BA.debugLine="End Sub";
return "";
}
}