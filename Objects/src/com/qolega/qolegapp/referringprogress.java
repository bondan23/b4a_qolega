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
			processBA = new BA(this.getApplicationContext(), null, null, "com.qolega.qolegapp", "com.qolega.qolegapp.referringprogress");
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
public static String  _activity_actionbarhomeclick() throws Exception{
 //BA.debugLineNum = 367;BA.debugLine="Sub Activity_ActionBarHomeClick";
 //BA.debugLineNum = 368;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 369;BA.debugLine="End Sub";
return "";
}
public static String  _activity_create(boolean _firsttime) throws Exception{
 //BA.debugLineNum = 29;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 31;BA.debugLine="font.Initialize";
mostCurrent._font._initialize(processBA);
 //BA.debugLineNum = 32;BA.debugLine="Api.Initialize(\"referringProgress\",Me)";
mostCurrent._api._initialize(processBA,"referringProgress",referringprogress.getObject());
 //BA.debugLineNum = 33;BA.debugLine="detailList.Initialize";
mostCurrent._detaillist.Initialize();
 //BA.debugLineNum = 37;BA.debugLine="Activity.Title = \"Candidate Progress\"";
mostCurrent._activity.setTitle((Object)("Candidate Progress"));
 //BA.debugLineNum = 39;BA.debugLine="Container.Initialize(\"\")";
mostCurrent._container.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 40;BA.debugLine="Container.Color = Colors.RGB(246,246,246)";
mostCurrent._container.setColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (246),(int) (246),(int) (246)));
 //BA.debugLineNum = 41;BA.debugLine="Activity.AddView(Container,0,0,100%x,100%y)";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._container.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 43;BA.debugLine="bar.Initialize(\"bar\")";
mostCurrent._bar.Initialize("bar",mostCurrent.activityBA);
 //BA.debugLineNum = 44;BA.debugLine="bar.ShowUpIndicator = True";
mostCurrent._bar.setShowUpIndicator(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 46;BA.debugLine="ProgressDialogShow(\"Loading Data\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,"Loading Data");
 //BA.debugLineNum = 47;BA.debugLine="Api.Get(\"/referrals/detail/\"&userId)";
mostCurrent._api._get("/referrals/detail/"+BA.NumberToString(_userid));
 //BA.debugLineNum = 48;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 375;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 377;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 371;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 373;BA.debugLine="End Sub";
return "";
}
public static boolean  _areequal(int _b1,int _b2) throws Exception{
 //BA.debugLineNum = 471;BA.debugLine="Sub AreEqual(b1 As Int, b2 As Int) As Boolean";
 //BA.debugLineNum = 472;BA.debugLine="If b1 <> b2 Then Return False";
if (_b1!=_b2) { 
if (true) return anywheresoftware.b4a.keywords.Common.False;};
 //BA.debugLineNum = 473;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 474;BA.debugLine="End Sub";
return false;
}
public static String  _closeicon_click() throws Exception{
anywheresoftware.b4a.objects.PanelWrapper _detailpanel = null;
anywheresoftware.b4a.objects.PanelWrapper _jobtitlepanel = null;
anywheresoftware.b4a.objects.PanelWrapper _journeypanel = null;
anywheresoftware.b4a.objects.LabelWrapper _utiltextlabel = null;
 //BA.debugLineNum = 421;BA.debugLine="Sub closeIcon_Click";
 //BA.debugLineNum = 422;BA.debugLine="Dim detailPanel,jobTitlePanel,journeyPanel As Pan";
_detailpanel = new anywheresoftware.b4a.objects.PanelWrapper();
_jobtitlepanel = new anywheresoftware.b4a.objects.PanelWrapper();
_journeypanel = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 423;BA.debugLine="Dim utilTextLabel As Label";
_utiltextlabel = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 425;BA.debugLine="detailPanel = detailList.Get(0)";
_detailpanel.setObject((android.view.ViewGroup)(mostCurrent._detaillist.Get((int) (0))));
 //BA.debugLineNum = 426;BA.debugLine="utilTextLabel = detailList.Get(1)";
_utiltextlabel.setObject((android.widget.TextView)(mostCurrent._detaillist.Get((int) (1))));
 //BA.debugLineNum = 427;BA.debugLine="jobTitlePanel = detailList.Get(2)";
_jobtitlepanel.setObject((android.view.ViewGroup)(mostCurrent._detaillist.Get((int) (2))));
 //BA.debugLineNum = 428;BA.debugLine="journeyPanel = detailList.Get(3)";
_journeypanel.setObject((android.view.ViewGroup)(mostCurrent._detaillist.Get((int) (3))));
 //BA.debugLineNum = 430;BA.debugLine="detailPanel.Height = detailPanel.Height - 200dip";
_detailpanel.setHeight((int) (_detailpanel.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (200))));
 //BA.debugLineNum = 431;BA.debugLine="utilTextLabel.Top = detailPanel.Height";
_utiltextlabel.setTop(_detailpanel.getHeight());
 //BA.debugLineNum = 432;BA.debugLine="utilTextLabel.Text = \"Show candidate details\"";
_utiltextlabel.setText((Object)("Show candidate details"));
 //BA.debugLineNum = 433;BA.debugLine="jobTitlePanel.Top = utilTextLabel.Top + utilTextL";
_jobtitlepanel.setTop((int) (_utiltextlabel.getTop()+_utiltextlabel.getHeight()));
 //BA.debugLineNum = 434;BA.debugLine="scrollView.Top = jobTitlePanel.Top + jobTitlePane";
mostCurrent._scrollview.setTop((int) (_jobtitlepanel.getTop()+_jobtitlepanel.getHeight()));
 //BA.debugLineNum = 435;BA.debugLine="journeyPanel.Height = journeyPanel.Height - jobTi";
_journeypanel.setHeight((int) (_journeypanel.getHeight()-_jobtitlepanel.getTop()+_jobtitlepanel.getHeight()));
 //BA.debugLineNum = 440;BA.debugLine="showIcon.Visible = True";
mostCurrent._showicon.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 441;BA.debugLine="closeIcon.Visible = False";
mostCurrent._closeicon.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 442;BA.debugLine="End Sub";
return "";
}
public static String  _drawbordertop(anywheresoftware.b4a.objects.ConcreteViewWrapper _target,int _acolor,int _strokewidth) throws Exception{
anywheresoftware.b4a.objects.drawable.CanvasWrapper _c = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.PathWrapper _path = null;
 //BA.debugLineNum = 461;BA.debugLine="Sub DrawBorderTop(Target As View,aColor As Int,Str";
 //BA.debugLineNum = 462;BA.debugLine="Dim c As Canvas";
_c = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();
 //BA.debugLineNum = 463;BA.debugLine="c.Initialize(Target)";
_c.Initialize((android.view.View)(_target.getObject()));
 //BA.debugLineNum = 464;BA.debugLine="Dim Path As Path";
_path = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.PathWrapper();
 //BA.debugLineNum = 465;BA.debugLine="Path.Initialize(0,0)";
_path.Initialize((float) (0),(float) (0));
 //BA.debugLineNum = 466;BA.debugLine="Path.LineTo(Target.Width,0)";
_path.LineTo((float) (_target.getWidth()),(float) (0));
 //BA.debugLineNum = 467;BA.debugLine="c.DrawPath(Path,aColor,False,StrokeWidth)";
_c.DrawPath((android.graphics.Path)(_path.getObject()),_acolor,anywheresoftware.b4a.keywords.Common.False,(float) (_strokewidth));
 //BA.debugLineNum = 468;BA.debugLine="Target.Invalidate";
_target.Invalidate();
 //BA.debugLineNum = 469;BA.debugLine="End Sub";
return "";
}
public static String  _drawdashline(anywheresoftware.b4a.objects.ConcreteViewWrapper _target,float _x1,float _y1,float _x2,float _y2,int _col,float _stroke) throws Exception{
com.AB.ABExtDrawing.ABExtDrawing.ABPaint _p = null;
com.AB.ABExtDrawing.ABExtDrawing _extdrawing = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper _cvsmain = null;
 //BA.debugLineNum = 445;BA.debugLine="Sub DrawDashLine(Target As View,x1 As Float, y1 As";
 //BA.debugLineNum = 446;BA.debugLine="Dim p As ABPaint";
_p = new com.AB.ABExtDrawing.ABExtDrawing.ABPaint();
 //BA.debugLineNum = 447;BA.debugLine="Dim ExtDrawing As ABExtDrawing";
_extdrawing = new com.AB.ABExtDrawing.ABExtDrawing();
 //BA.debugLineNum = 448;BA.debugLine="Dim cvsMain As Canvas";
_cvsmain = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();
 //BA.debugLineNum = 450;BA.debugLine="cvsMain.Initialize(Target)";
_cvsmain.Initialize((android.view.View)(_target.getObject()));
 //BA.debugLineNum = 452;BA.debugLine="p.Initialize";
_p.Initialize();
 //BA.debugLineNum = 453;BA.debugLine="p.SetStrokeWidth(Stroke)";
_p.SetStrokeWidth(_stroke);
 //BA.debugLineNum = 454;BA.debugLine="p.SetStyle(p.Style_STROKE)";
_p.SetStyle(_p.Style_STROKE);
 //BA.debugLineNum = 455;BA.debugLine="p.SetColor(col)";
_p.SetColor(_col);
 //BA.debugLineNum = 456;BA.debugLine="p.SetDashPathEffect(1, Array As Float(2dip, 2d";
_p.SetDashPathEffect((int) (1),new float[]{(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2))),(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)))},(float) (0));
 //BA.debugLineNum = 457;BA.debugLine="p.DoPathEffectSingle(1)";
_p.DoPathEffectSingle((int) (1));
 //BA.debugLineNum = 458;BA.debugLine="ExtDrawing.DrawLine(cvsMain, x1, y1, x2, y2, p";
_extdrawing.drawLine(_cvsmain,_x1,_y1,_x2,_y2,_p);
 //BA.debugLineNum = 459;BA.debugLine="End Sub";
return "";
}
public static String  _drawleftborder(anywheresoftware.b4a.objects.ConcreteViewWrapper _target,int _acolor,int _strokewidth,boolean _last,boolean _single) throws Exception{
anywheresoftware.b4a.objects.drawable.CanvasWrapper _c = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.PathWrapper _path1 = null;
 //BA.debugLineNum = 379;BA.debugLine="Public Sub DrawLeftBorder(Target As View, aColor A";
 //BA.debugLineNum = 380;BA.debugLine="Dim c As Canvas";
_c = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();
 //BA.debugLineNum = 381;BA.debugLine="c.Initialize(Target)";
_c.Initialize((android.view.View)(_target.getObject()));
 //BA.debugLineNum = 382;BA.debugLine="Dim Path1 As Path";
_path1 = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.PathWrapper();
 //BA.debugLineNum = 383;BA.debugLine="Path1.Initialize(0,0)";
_path1.Initialize((float) (0),(float) (0));
 //BA.debugLineNum = 385;BA.debugLine="If Last == True Then";
if (_last==anywheresoftware.b4a.keywords.Common.True) { 
 }else {
 //BA.debugLineNum = 388;BA.debugLine="If Single == True Then";
if (_single==anywheresoftware.b4a.keywords.Common.True) { 
 }else {
 //BA.debugLineNum = 391;BA.debugLine="Path1.LineTo(0,Target.Height)";
_path1.LineTo((float) (0),(float) (_target.getHeight()));
 };
 };
 //BA.debugLineNum = 395;BA.debugLine="c.DrawPath(Path1, aColor, False, StrokeWidth)";
_c.DrawPath((android.graphics.Path)(_path1.getObject()),_acolor,anywheresoftware.b4a.keywords.Common.False,(float) (_strokewidth));
 //BA.debugLineNum = 396;BA.debugLine="Target.Invalidate";
_target.Invalidate();
 //BA.debugLineNum = 397;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 13;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 16;BA.debugLine="Dim scrollView As ScrollView";
mostCurrent._scrollview = new anywheresoftware.b4a.objects.ScrollViewWrapper();
 //BA.debugLineNum = 17;BA.debugLine="Dim JSON As JSONParser";
mostCurrent._json = new anywheresoftware.b4a.objects.collections.JSONParser();
 //BA.debugLineNum = 18;BA.debugLine="Dim su As StringUtils";
mostCurrent._su = new anywheresoftware.b4a.objects.StringUtils();
 //BA.debugLineNum = 19;BA.debugLine="Dim Container As Panel";
mostCurrent._container = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 20;BA.debugLine="Dim font As Fonts";
mostCurrent._font = new com.qolega.qolegapp.fonts();
 //BA.debugLineNum = 21;BA.debugLine="Private bar As StdActionBar";
mostCurrent._bar = new anywheresoftware.b4a.objects.StdActionBar();
 //BA.debugLineNum = 22;BA.debugLine="Dim detailList As List";
mostCurrent._detaillist = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 24;BA.debugLine="Type RowCol (Row As Int, Col As Int)";
;
 //BA.debugLineNum = 25;BA.debugLine="Dim showIcon,closeIcon As ImageView";
mostCurrent._showicon = new anywheresoftware.b4a.objects.ImageViewWrapper();
mostCurrent._closeicon = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 26;BA.debugLine="Dim Api As Api";
mostCurrent._api = new com.qolega.qolegapp.api();
 //BA.debugLineNum = 27;BA.debugLine="End Sub";
return "";
}
public static String  _jobdone(com.qolega.qolegapp.httpjob _job) throws Exception{
 //BA.debugLineNum = 50;BA.debugLine="Sub JobDone(Job As HttpJob)";
 //BA.debugLineNum = 51;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
 //BA.debugLineNum = 52;BA.debugLine="Log(\"JobName = \" & Job.JobName & \", Success = \"";
anywheresoftware.b4a.keywords.Common.Log("JobName = "+_job._jobname+", Success = "+BA.ObjectToString(_job._success));
 //BA.debugLineNum = 53;BA.debugLine="If Job.Success = True Then";
if (_job._success==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 54;BA.debugLine="LoopPanel(Job.GetString)";
_looppanel(_job._getstring());
 }else {
 //BA.debugLineNum = 56;BA.debugLine="Log(\"Error: \" & Job.ErrorMessage)";
anywheresoftware.b4a.keywords.Common.Log("Error: "+_job._errormessage);
 //BA.debugLineNum = 57;BA.debugLine="ToastMessageShow(\"Error: \" & Job.ErrorMessag";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("Error: "+_job._errormessage,anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 59;BA.debugLine="Job.Release";
_job._release();
 //BA.debugLineNum = 60;BA.debugLine="End Sub";
return "";
}
public static String  _looppanel(String _data) throws Exception{
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
 //BA.debugLineNum = 62;BA.debugLine="Sub LoopPanel(Data As String)";
 //BA.debugLineNum = 63;BA.debugLine="Dim jobTitlePanel,detailPanel,journeyPanel,refere";
_jobtitlepanel = new anywheresoftware.b4a.objects.PanelWrapper();
_detailpanel = new anywheresoftware.b4a.objects.PanelWrapper();
_journeypanel = new anywheresoftware.b4a.objects.PanelWrapper();
_referencepanel = new anywheresoftware.b4a.objects.PanelWrapper();
_progressbox = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 64;BA.debugLine="Dim PanelTop,IconTop,PanelHeight,ReferenceTop,Ref";
_paneltop = 0;
_icontop = 0;
_panelheight = 0;
_referencetop = 0;
_referenceheight = 0;
_gap = 0;
_textheight = 0;
 //BA.debugLineNum = 65;BA.debugLine="Dim jobTitle,utilText,refName,refCompany,refStatu";
_jobtitle = new anywheresoftware.b4a.objects.LabelWrapper();
_utiltext = new anywheresoftware.b4a.objects.LabelWrapper();
_refname = new anywheresoftware.b4a.objects.LabelWrapper();
_refcompany = new anywheresoftware.b4a.objects.LabelWrapper();
_refstatus = new anywheresoftware.b4a.objects.LabelWrapper();
_reftext = new anywheresoftware.b4a.objects.LabelWrapper();
_detailbtn = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 67;BA.debugLine="Dim refDetWrapper As Panel";
_refdetwrapper = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 69;BA.debugLine="Dim userIcon As ImageView";
_usericon = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 72;BA.debugLine="JSON.Initialize(Data)";
mostCurrent._json.Initialize(_data);
 //BA.debugLineNum = 73;BA.debugLine="Dim root As Map = JSON.NextObject";
_root = new anywheresoftware.b4a.objects.collections.Map();
_root = mostCurrent._json.NextObject();
 //BA.debugLineNum = 75;BA.debugLine="Dim dataName As String = root.Get(\"name\")";
_dataname = BA.ObjectToString(_root.Get((Object)("name")));
 //BA.debugLineNum = 76;BA.debugLine="Dim dataCompany As String = root.Get(\"company\")";
_datacompany = BA.ObjectToString(_root.Get((Object)("company")));
 //BA.debugLineNum = 77;BA.debugLine="Dim dataLatestPos As String = root.Get(\"user_job_";
_datalatestpos = BA.ObjectToString(_root.Get((Object)("user_job_title")));
 //BA.debugLineNum = 78;BA.debugLine="Dim dataPhoneNum As String = root.Get(\"phone\")";
_dataphonenum = BA.ObjectToString(_root.Get((Object)("phone")));
 //BA.debugLineNum = 79;BA.debugLine="Dim dataUrl As String = root.Get(\"linkedin\")";
_dataurl = BA.ObjectToString(_root.Get((Object)("linkedin")));
 //BA.debugLineNum = 80;BA.debugLine="Dim dataEmail As String = root.Get(\"email\")";
_dataemail = BA.ObjectToString(_root.Get((Object)("email")));
 //BA.debugLineNum = 81;BA.debugLine="Dim dataNote As String = root.Get(\"note\")";
_datanote = BA.ObjectToString(_root.Get((Object)("note")));
 //BA.debugLineNum = 82;BA.debugLine="Dim dataJobtitle As String = \"Text\"";
_datajobtitle = "Text";
 //BA.debugLineNum = 85;BA.debugLine="PanelTop = 10dip";
_paneltop = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
 //BA.debugLineNum = 87;BA.debugLine="PanelHeight = 110dip";
_panelheight = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (110));
 //BA.debugLineNum = 89;BA.debugLine="Gap = 10dip";
_gap = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
 //BA.debugLineNum = 91;BA.debugLine="detailPanel.Initialize(\"\")";
_detailpanel.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 92;BA.debugLine="detailPanel.Color = Colors.White";
_detailpanel.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 //BA.debugLineNum = 93;BA.debugLine="Container.AddView(detailPanel,0,10dip,100%x,70dip";
mostCurrent._container.AddView((android.view.View)(_detailpanel.getObject()),(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (70)));
 //BA.debugLineNum = 96;BA.debugLine="userIcon.Initialize(\"\")";
_usericon.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 97;BA.debugLine="userIcon.Bitmap = LoadBitmap(File.DirAssets,\"user";
_usericon.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"user.png").getObject()));
 //BA.debugLineNum = 98;BA.debugLine="userIcon.Gravity = Gravity.FILL";
_usericon.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 //BA.debugLineNum = 99;BA.debugLine="refName.Initialize(\"\")";
_refname.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 100;BA.debugLine="refName.Text = dataName";
_refname.setText((Object)(_dataname));
 //BA.debugLineNum = 101;BA.debugLine="refName.TextColor = Colors.RGB(74,74,74)";
_refname.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (74),(int) (74),(int) (74)));
 //BA.debugLineNum = 103;BA.debugLine="refName.Typeface = font.proximanovaSemiBold";
_refname.setTypeface((android.graphics.Typeface)(mostCurrent._font._proximanovasemibold().getObject()));
 //BA.debugLineNum = 106;BA.debugLine="detailPanel.AddView(userIcon,10dip,10dip,24dip,24";
_detailpanel.AddView((android.view.View)(_usericon.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (24)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (24)));
 //BA.debugLineNum = 107;BA.debugLine="detailPanel.AddView(refName,38dip,12dip,detailPan";
_detailpanel.AddView((android.view.View)(_refname.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (38)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (12)),(int) (_detailpanel.getWidth()-(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (38))*2)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)));
 //BA.debugLineNum = 110;BA.debugLine="refCompany.Initialize(\"\")";
_refcompany.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 111;BA.debugLine="refCompany.Text = dataCompany";
_refcompany.setText((Object)(_datacompany));
 //BA.debugLineNum = 112;BA.debugLine="refCompany.TextColor = Colors.RGB(179,179,179)";
_refcompany.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (179),(int) (179),(int) (179)));
 //BA.debugLineNum = 114;BA.debugLine="refCompany.Typeface = font.proximanovaRegular";
_refcompany.setTypeface((android.graphics.Typeface)(mostCurrent._font._proximanovaregular().getObject()));
 //BA.debugLineNum = 115;BA.debugLine="detailPanel.AddView(refCompany,38dip,refName.Top+";
_detailpanel.AddView((android.view.View)(_refcompany.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (38)),(int) (_refname.getTop()+_refname.getHeight()),(int) (_detailpanel.getWidth()-(38*2)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)));
 //BA.debugLineNum = 119;BA.debugLine="refDetWrapper.Initialize(\"\")";
_refdetwrapper.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 120;BA.debugLine="detailPanel.AddView(refDetWrapper,10dip,refCompan";
_detailpanel.AddView((android.view.View)(_refdetwrapper.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),(int) (_refcompany.getTop()+_refcompany.getHeight()+_gap*2),(int) (_detailpanel.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 121;BA.debugLine="DrawBorderTop(refDetWrapper,Colors.RGB(219,219,21";
_drawbordertop((anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_refdetwrapper.getObject())),anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (219),(int) (219),(int) (219)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)));
 //BA.debugLineNum = 124;BA.debugLine="Dim detEmail,detPhoneNumber,detLatestComp,detLast";
_detemail = new anywheresoftware.b4a.objects.LabelWrapper();
_detphonenumber = new anywheresoftware.b4a.objects.LabelWrapper();
_detlatestcomp = new anywheresoftware.b4a.objects.LabelWrapper();
_detlastpos = new anywheresoftware.b4a.objects.LabelWrapper();
_detlinkedinurl = new anywheresoftware.b4a.objects.LabelWrapper();
_detnote = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 130;BA.debugLine="Dim textList,valueList As List";
_textlist = new anywheresoftware.b4a.objects.collections.List();
_valuelist = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 131;BA.debugLine="textList.Initialize";
_textlist.Initialize();
 //BA.debugLineNum = 132;BA.debugLine="textList.AddAll(Array As String(\"Email\", \"Phone N";
_textlist.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"Email","Phone Number","Latest Company","Latest Position","LinkedIn URL","Note"}));
 //BA.debugLineNum = 133;BA.debugLine="valueList.Initialize";
_valuelist.Initialize();
 //BA.debugLineNum = 134;BA.debugLine="valueList.AddAll(Array As String(dataEmail,dataPh";
_valuelist.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{_dataemail,_dataphonenum,_datacompany,_datalatestpos,_dataurl,_datanote}));
 //BA.debugLineNum = 135;BA.debugLine="Dim topPos As Int";
_toppos = 0;
 //BA.debugLineNum = 136;BA.debugLine="topPos = 20dip";
_toppos = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20));
 //BA.debugLineNum = 138;BA.debugLine="For i=0 To textList.Size -1";
{
final int step47 = 1;
final int limit47 = (int) (_textlist.getSize()-1);
for (_i = (int) (0) ; (step47 > 0 && _i <= limit47) || (step47 < 0 && _i >= limit47); _i = ((int)(0 + _i + step47)) ) {
 //BA.debugLineNum = 139;BA.debugLine="Dim l,ll,lll As Label";
_l = new anywheresoftware.b4a.objects.LabelWrapper();
_ll = new anywheresoftware.b4a.objects.LabelWrapper();
_lll = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 140;BA.debugLine="l.Initialize(\"cell\")";
_l.Initialize(mostCurrent.activityBA,"cell");
 //BA.debugLineNum = 141;BA.debugLine="l.Text = textList.Get(i)";
_l.setText(_textlist.Get(_i));
 //BA.debugLineNum = 142;BA.debugLine="l.Typeface = font.proximanovaRegular";
_l.setTypeface((android.graphics.Typeface)(mostCurrent._font._proximanovaregular().getObject()));
 //BA.debugLineNum = 143;BA.debugLine="l.TextColor = Colors.RGB(179,179,179)";
_l.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (179),(int) (179),(int) (179)));
 //BA.debugLineNum = 145;BA.debugLine="refDetWrapper.AddView(l,0,topPos,120dip,20dip)";
_refdetwrapper.AddView((android.view.View)(_l.getObject()),(int) (0),_toppos,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (120)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)));
 //BA.debugLineNum = 147;BA.debugLine="ll.Initialize(\"cell2\")";
_ll.Initialize(mostCurrent.activityBA,"cell2");
 //BA.debugLineNum = 148;BA.debugLine="ll.Text = \":\"";
_ll.setText((Object)(":"));
 //BA.debugLineNum = 149;BA.debugLine="ll.Typeface = font.proximanovaRegular";
_ll.setTypeface((android.graphics.Typeface)(mostCurrent._font._proximanovaregular().getObject()));
 //BA.debugLineNum = 150;BA.debugLine="ll.TextColor = Colors.RGB(179,179,179)";
_ll.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (179),(int) (179),(int) (179)));
 //BA.debugLineNum = 151;BA.debugLine="refDetWrapper.AddView(ll,l.Width,topPos,10dip,20";
_refdetwrapper.AddView((android.view.View)(_ll.getObject()),_l.getWidth(),_toppos,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)));
 //BA.debugLineNum = 153;BA.debugLine="lll.Initialize(\"cell3\")";
_lll.Initialize(mostCurrent.activityBA,"cell3");
 //BA.debugLineNum = 155;BA.debugLine="If i > 0 Then";
if (_i>0) { 
 //BA.debugLineNum = 156;BA.debugLine="lll.TextColor = Colors.RGB(74,74,74)";
_lll.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (74),(int) (74),(int) (74)));
 }else {
 //BA.debugLineNum = 158;BA.debugLine="lll.TextColor = Colors.RGB(179,179,179)";
_lll.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (179),(int) (179),(int) (179)));
 };
 //BA.debugLineNum = 161;BA.debugLine="lll.Typeface = font.proximanovaRegular";
_lll.setTypeface((android.graphics.Typeface)(mostCurrent._font._proximanovaregular().getObject()));
 //BA.debugLineNum = 162;BA.debugLine="If valueList.Get(i) = \"\" Then";
if ((_valuelist.Get(_i)).equals((Object)(""))) { 
 //BA.debugLineNum = 163;BA.debugLine="lll.Text = \"-\"";
_lll.setText((Object)("-"));
 }else {
 //BA.debugLineNum = 165;BA.debugLine="lll.Text = valueList.Get(i)";
_lll.setText(_valuelist.Get(_i));
 };
 //BA.debugLineNum = 167;BA.debugLine="refDetWrapper.AddView(lll,l.Width+ll.Width+Gap,t";
_refdetwrapper.AddView((android.view.View)(_lll.getObject()),(int) (_l.getWidth()+_ll.getWidth()+_gap),_toppos,(int) (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA)/(double)1.5),(int) (-2));
 //BA.debugLineNum = 168;BA.debugLine="Dim x As Int";
_x = 0;
 //BA.debugLineNum = 169;BA.debugLine="x = su.MeasureMultilineTextHeight(lll,lll.Text)";
_x = mostCurrent._su.MeasureMultilineTextHeight((android.widget.TextView)(_lll.getObject()),_lll.getText());
 //BA.debugLineNum = 171;BA.debugLine="topPos = topPos + x + Gap";
_toppos = (int) (_toppos+_x+_gap);
 }
};
 //BA.debugLineNum = 176;BA.debugLine="detailList.Add(detailPanel)";
mostCurrent._detaillist.Add((Object)(_detailpanel.getObject()));
 //BA.debugLineNum = 179;BA.debugLine="showIcon.Initialize(\"showIcon\")";
mostCurrent._showicon.Initialize(mostCurrent.activityBA,"showIcon");
 //BA.debugLineNum = 180;BA.debugLine="showIcon.Bitmap = LoadBitmap(File.DirAssets,\"Show";
mostCurrent._showicon.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"Show.png").getObject()));
 //BA.debugLineNum = 181;BA.debugLine="showIcon.Gravity = Gravity.FILL";
mostCurrent._showicon.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 //BA.debugLineNum = 182;BA.debugLine="Container.AddView(showIcon,(detailPanel.Width/2)-";
mostCurrent._container.AddView((android.view.View)(mostCurrent._showicon.getObject()),(int) ((_detailpanel.getWidth()/(double)2)-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (15))),(int) (_detailpanel.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)));
 //BA.debugLineNum = 185;BA.debugLine="closeIcon.Initialize(\"closeIcon\")";
mostCurrent._closeicon.Initialize(mostCurrent.activityBA,"closeIcon");
 //BA.debugLineNum = 186;BA.debugLine="closeIcon.Bitmap = LoadBitmap(File.DirAssets,\"Clo";
mostCurrent._closeicon.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"Close.png").getObject()));
 //BA.debugLineNum = 187;BA.debugLine="closeIcon.Visible = False";
mostCurrent._closeicon.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 188;BA.debugLine="closeIcon.Gravity = Gravity.FILL";
mostCurrent._closeicon.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 //BA.debugLineNum = 189;BA.debugLine="Container.AddView(closeIcon,(detailPanel.Width/2)";
mostCurrent._container.AddView((android.view.View)(mostCurrent._closeicon.getObject()),(int) ((_detailpanel.getWidth()/(double)2)-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (15))),(int) (_detailpanel.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)));
 //BA.debugLineNum = 191;BA.debugLine="Dim utilTextW As Int = 100dip";
_utiltextw = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100));
 //BA.debugLineNum = 194;BA.debugLine="utilText.Initialize(\"\")";
_utiltext.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 195;BA.debugLine="Container.AddView(utilText,0,detailPanel.Height,1";
mostCurrent._container.AddView((android.view.View)(_utiltext.getObject()),(int) (0),_detailpanel.getHeight(),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (70)));
 //BA.debugLineNum = 196;BA.debugLine="utilText.TextColor = Colors.RGB(179,179,179)";
_utiltext.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (179),(int) (179),(int) (179)));
 //BA.debugLineNum = 197;BA.debugLine="utilText.Text = \"Show candidate details\"";
_utiltext.setText((Object)("Show candidate details"));
 //BA.debugLineNum = 198;BA.debugLine="utilText.Gravity = Gravity.CENTER";
_utiltext.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
 //BA.debugLineNum = 201;BA.debugLine="detailList.Add(utilText)";
mostCurrent._detaillist.Add((Object)(_utiltext.getObject()));
 //BA.debugLineNum = 204;BA.debugLine="jobTitlePanel.Initialize(\"\")";
_jobtitlepanel.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 205;BA.debugLine="Container.AddView(jobTitlePanel,0,(detailPanel.He";
mostCurrent._container.AddView((android.view.View)(_jobtitlepanel.getObject()),(int) (0),(int) ((_detailpanel.getHeight()+_utiltext.getHeight())-_gap),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
 //BA.debugLineNum = 206;BA.debugLine="jobTitlePanel.Color = Colors.White";
_jobtitlepanel.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 //BA.debugLineNum = 209;BA.debugLine="detailList.Add(jobTitlePanel)";
mostCurrent._detaillist.Add((Object)(_jobtitlepanel.getObject()));
 //BA.debugLineNum = 211;BA.debugLine="jobTitle.Initialize(\"\")";
_jobtitle.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 212;BA.debugLine="jobTitle.Text = \"Referal Progress for \"&dataJobti";
_jobtitle.setText((Object)("Referal Progress for "+_datajobtitle));
 //BA.debugLineNum = 214;BA.debugLine="jobTitle.TextColor = Colors.RGB(74,74,74)";
_jobtitle.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (74),(int) (74),(int) (74)));
 //BA.debugLineNum = 215;BA.debugLine="jobTitlePanel.AddView(jobTitle,10dip,6dip,jobTitl";
_jobtitlepanel.AddView((android.view.View)(_jobtitle.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (6)),(int) (_jobtitlepanel.getWidth()-(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))*2)),_jobtitlepanel.getHeight());
 //BA.debugLineNum = 216;BA.debugLine="Dim titleHeight As Int";
_titleheight = 0;
 //BA.debugLineNum = 217;BA.debugLine="titleHeight = su.MeasureMultilineTextHeight(jobTi";
_titleheight = mostCurrent._su.MeasureMultilineTextHeight((android.widget.TextView)(_jobtitle.getObject()),_jobtitle.getText());
 //BA.debugLineNum = 219;BA.debugLine="jobTitlePanel.Height = titleHeight + 20dip";
_jobtitlepanel.setHeight((int) (_titleheight+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))));
 //BA.debugLineNum = 221;BA.debugLine="scrollView.Initialize(Activity.Height)";
mostCurrent._scrollview.Initialize(mostCurrent.activityBA,mostCurrent._activity.getHeight());
 //BA.debugLineNum = 222;BA.debugLine="scrollView.Color = Colors.White";
mostCurrent._scrollview.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 //BA.debugLineNum = 223;BA.debugLine="Container.AddView(scrollView,0,(detailPanel.Heigh";
mostCurrent._container.AddView((android.view.View)(mostCurrent._scrollview.getObject()),(int) (0),(int) ((_detailpanel.getHeight()+_utiltext.getHeight()+_jobtitlepanel.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)))),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 224;BA.debugLine="journeyPanel = scrollView.Panel";
_journeypanel = mostCurrent._scrollview.getPanel();
 //BA.debugLineNum = 227;BA.debugLine="detailList.Add(journeyPanel)";
mostCurrent._detaillist.Add((Object)(_journeypanel.getObject()));
 //BA.debugLineNum = 229;BA.debugLine="Dim referenceWrapper As Panel";
_referencewrapper = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 230;BA.debugLine="referenceWrapper.Initialize(\"\")";
_referencewrapper.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 232;BA.debugLine="PanelTop = 0";
_paneltop = (int) (0);
 //BA.debugLineNum = 233;BA.debugLine="IconTop = 12dip";
_icontop = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (12));
 //BA.debugLineNum = 235;BA.debugLine="Dim journeys As List = root.Get(\"journeys\")";
_journeys = new anywheresoftware.b4a.objects.collections.List();
_journeys.setObject((java.util.List)(_root.Get((Object)("journeys"))));
 //BA.debugLineNum = 236;BA.debugLine="Dim iterator As Int = 1";
_iterator = (int) (1);
 //BA.debugLineNum = 237;BA.debugLine="Dim LastIconTop As Int";
_lasticontop = 0;
 //BA.debugLineNum = 238;BA.debugLine="Dim IncrementBoxHeight As Int";
_incrementboxheight = 0;
 //BA.debugLineNum = 239;BA.debugLine="Dim BoxHeight As Int = 50dip";
_boxheight = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50));
 //BA.debugLineNum = 241;BA.debugLine="journeyPanel.AddView(referenceWrapper,30dip,Panel";
_journeypanel.AddView((android.view.View)(_referencewrapper.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)),_paneltop,(int) (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA)-(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30))*2)),_boxheight);
 //BA.debugLineNum = 243;BA.debugLine="For Each coljourneys As Map In journeys";
_coljourneys = new anywheresoftware.b4a.objects.collections.Map();
final anywheresoftware.b4a.BA.IterableList group119 = _journeys;
final int groupLen119 = group119.getSize();
for (int index119 = 0;index119 < groupLen119 ;index119++){
_coljourneys.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(group119.Get(index119)));
 //BA.debugLineNum = 244;BA.debugLine="Dim journeyText As String = coljourneys.Get(\"tex";
_journeytext = BA.ObjectToString(_coljourneys.Get((Object)("text")));
 //BA.debugLineNum = 245;BA.debugLine="Dim rStatus As String = coljourneys.Get(\"status\"";
_rstatus = BA.ObjectToString(_coljourneys.Get((Object)("status")));
 //BA.debugLineNum = 246;BA.debugLine="Dim rState As String = coljourneys.Get(\"state_st";
_rstate = BA.ObjectToString(_coljourneys.Get((Object)("state_status")));
 //BA.debugLineNum = 247;BA.debugLine="Dim rStateDesc As String = coljourneys.Get(\"stat";
_rstatedesc = BA.ObjectToString(_coljourneys.Get((Object)("state_description")));
 //BA.debugLineNum = 248;BA.debugLine="Dim daysAgo As String = coljourneys.Get(\"days_ag";
_daysago = BA.ObjectToString(_coljourneys.Get((Object)("days_ago")));
 //BA.debugLineNum = 250;BA.debugLine="progressBox.Initialize(\"\")";
_progressbox.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 252;BA.debugLine="journeyPanel.AddView(progressBox,30dip,PanelTop,";
_journeypanel.AddView((android.view.View)(_progressbox.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)),_paneltop,(int) (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA)-(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30))*2)),_boxheight);
 //BA.debugLineNum = 254;BA.debugLine="Dim iconName As String";
_iconname = "";
 //BA.debugLineNum = 255;BA.debugLine="If rStatus = \"null\" Then";
if ((_rstatus).equals("null")) { 
 //BA.debugLineNum = 256;BA.debugLine="Select rState";
switch (BA.switchObjectToInt(_rstate,"WAITING","COMPLETE","FAILED")) {
case 0: {
 //BA.debugLineNum = 258;BA.debugLine="iconName = \"Progress.png\"";
_iconname = "Progress.png";
 break; }
case 1: {
 //BA.debugLineNum = 260;BA.debugLine="iconName = \"Done.png\"";
_iconname = "Done.png";
 break; }
case 2: {
 //BA.debugLineNum = 262;BA.debugLine="iconName = \"Fail.png\"";
_iconname = "Fail.png";
 break; }
}
;
 }else {
 //BA.debugLineNum = 265;BA.debugLine="iconName = \"Done.png\"";
_iconname = "Done.png";
 };
 //BA.debugLineNum = 269;BA.debugLine="Dim statusIcon As ImageView";
_statusicon = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 270;BA.debugLine="statusIcon.Initialize(\"\")";
_statusicon.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 271;BA.debugLine="statusIcon.Bitmap = LoadBitmap(File.DirAssets,ic";
_statusicon.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),_iconname).getObject()));
 //BA.debugLineNum = 272;BA.debugLine="statusIcon.Gravity = Gravity.FILL";
_statusicon.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 //BA.debugLineNum = 273;BA.debugLine="journeyPanel.AddView(statusIcon,30dip-7.5dip,Ico";
_journeypanel.AddView((android.view.View)(_statusicon.getObject()),(int) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30))-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (7.5))),_icontop,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (16)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (16)));
 //BA.debugLineNum = 276;BA.debugLine="If rStatus <> \"null\" Then";
if ((_rstatus).equals("null") == false) { 
 //BA.debugLineNum = 277;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
 //BA.debugLineNum = 278;BA.debugLine="refStatus.Initialize(\"\")";
_refstatus.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 279;BA.debugLine="Select rStatus";
switch (BA.switchObjectToInt(_rstatus,"qualifying","interview_by_consultant","sent_to_client","1st_interview","2nd_interview","3rd_interview","follow_up","hired","1st_day")) {
case 0: {
 //BA.debugLineNum = 281;BA.debugLine="cd.Initialize(Colors.RGB(249,128,55), 2dip)";
_cd.Initialize(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (249),(int) (128),(int) (55)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)));
 //BA.debugLineNum = 282;BA.debugLine="refStatus.Background = cd";
_refstatus.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
 break; }
case 1: {
 //BA.debugLineNum = 284;BA.debugLine="cd.Initialize(Colors.RGB(248,190,56), 2dip)";
_cd.Initialize(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (248),(int) (190),(int) (56)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)));
 //BA.debugLineNum = 285;BA.debugLine="refStatus.Background = cd";
_refstatus.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
 break; }
case 2: {
 //BA.debugLineNum = 287;BA.debugLine="cd.Initialize(Colors.RGB(186,220,63), 2dip)";
_cd.Initialize(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (186),(int) (220),(int) (63)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)));
 //BA.debugLineNum = 288;BA.debugLine="refStatus.Background = cd";
_refstatus.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
 break; }
case 3: 
case 4: 
case 5: {
 //BA.debugLineNum = 290;BA.debugLine="cd.Initialize(Colors.RGB(103,195,68), 2dip)";
_cd.Initialize(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (103),(int) (195),(int) (68)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)));
 //BA.debugLineNum = 291;BA.debugLine="refStatus.Background = cd";
_refstatus.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
 break; }
case 6: {
 //BA.debugLineNum = 293;BA.debugLine="cd.Initialize(Colors.RGB(62,222,176), 2dip)";
_cd.Initialize(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (62),(int) (222),(int) (176)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)));
 //BA.debugLineNum = 294;BA.debugLine="refStatus.Background = cd";
_refstatus.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
 break; }
case 7: {
 //BA.debugLineNum = 296;BA.debugLine="cd.Initialize(Colors.RGB(21,176,220), 2dip)";
_cd.Initialize(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (21),(int) (176),(int) (220)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)));
 //BA.debugLineNum = 297;BA.debugLine="refStatus.Background = cd";
_refstatus.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
 break; }
case 8: {
 //BA.debugLineNum = 299;BA.debugLine="cd.Initialize(Colors.RGB(38,143,235), 2dip)";
_cd.Initialize(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (38),(int) (143),(int) (235)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)));
 //BA.debugLineNum = 300;BA.debugLine="refStatus.Background = cd";
_refstatus.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
 break; }
default: {
 //BA.debugLineNum = 302;BA.debugLine="cd.Initialize(Colors.RGB(3,117,216), 2dip)";
_cd.Initialize(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (3),(int) (117),(int) (216)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)));
 //BA.debugLineNum = 303;BA.debugLine="refStatus.Background = cd";
_refstatus.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
 break; }
}
;
 //BA.debugLineNum = 306;BA.debugLine="refStatus.TextColor = Colors.White";
_refstatus.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 //BA.debugLineNum = 308;BA.debugLine="refStatus.Text = ToMixCase(rStatus.Replace(\"_\",";
_refstatus.setText((Object)(_tomixcase(_rstatus.replace("_"," "))));
 //BA.debugLineNum = 309;BA.debugLine="refStatus.Typeface = font.proximanovaSemiBold";
_refstatus.setTypeface((android.graphics.Typeface)(mostCurrent._font._proximanovasemibold().getObject()));
 //BA.debugLineNum = 310;BA.debugLine="refStatus.Gravity = Gravity.CENTER";
_refstatus.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
 //BA.debugLineNum = 311;BA.debugLine="progressBox.AddView(refStatus,15dip,10dip,100di";
_progressbox.AddView((android.view.View)(_refstatus.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (15)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)));
 //BA.debugLineNum = 312;BA.debugLine="Dim refStatusHeight As Int";
_refstatusheight = 0;
 //BA.debugLineNum = 313;BA.debugLine="refStatusHeight =  su.MeasureMultilineTextHeigh";
_refstatusheight = mostCurrent._su.MeasureMultilineTextHeight((android.widget.TextView)(_refstatus.getObject()),_refstatus.getText());
 //BA.debugLineNum = 315;BA.debugLine="If refStatusHeight > refStatus.Height Then";
if (_refstatusheight>_refstatus.getHeight()) { 
 //BA.debugLineNum = 316;BA.debugLine="refStatus.Height = refStatusHeight";
_refstatus.setHeight(_refstatusheight);
 };
 //BA.debugLineNum = 320;BA.debugLine="Dim refDay As Label";
_refday = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 321;BA.debugLine="refDay.Initialize(\"\")";
_refday.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 322;BA.debugLine="refDay.Text = daysAgo&\"d\"";
_refday.setText((Object)(_daysago+"d"));
 //BA.debugLineNum = 323;BA.debugLine="refDay.Typeface = font.proximanovaRegular";
_refday.setTypeface((android.graphics.Typeface)(mostCurrent._font._proximanovaregular().getObject()));
 //BA.debugLineNum = 324;BA.debugLine="refDay.TextColor = Colors.RGB(179,179,179)";
_refday.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (179),(int) (179),(int) (179)));
 //BA.debugLineNum = 325;BA.debugLine="refDay.TextSize = refName.TextSize / 1.25";
_refday.setTextSize((float) (_refname.getTextSize()/(double)1.25));
 //BA.debugLineNum = 326;BA.debugLine="progressBox.AddView(refDay,15dip,refStatus.Top+";
_progressbox.AddView((android.view.View)(_refday.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (15)),(int) (_refstatus.getTop()+_refstatus.getHeight()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)));
 };
 //BA.debugLineNum = 330;BA.debugLine="refText.Initialize(\"\")";
_reftext.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 331;BA.debugLine="refText.Typeface = font.proximanovaRegular";
_reftext.setTypeface((android.graphics.Typeface)(mostCurrent._font._proximanovaregular().getObject()));
 //BA.debugLineNum = 333;BA.debugLine="If rStatus <> \"null\" Then";
if ((_rstatus).equals("null") == false) { 
 //BA.debugLineNum = 334;BA.debugLine="refText.Text = journeyText";
_reftext.setText((Object)(_journeytext));
 //BA.debugLineNum = 335;BA.debugLine="progressBox.AddView(refText,refStatus.Left+refS";
_progressbox.AddView((android.view.View)(_reftext.getObject()),(int) (_refstatus.getLeft()+_refstatus.getWidth()+_gap),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),(int) (_progressbox.getWidth()/(double)2),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)));
 }else {
 //BA.debugLineNum = 337;BA.debugLine="refText.Text = rStateDesc";
_reftext.setText((Object)(_rstatedesc));
 //BA.debugLineNum = 338;BA.debugLine="progressBox.AddView(refText,15dip,13.5dip,progr";
_progressbox.AddView((android.view.View)(_reftext.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (15)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (13.5)),(int) (_progressbox.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)));
 };
 //BA.debugLineNum = 342;BA.debugLine="Dim TextHeight As Int";
_textheight = 0;
 //BA.debugLineNum = 343;BA.debugLine="TextHeight =  su.MeasureMultilineTextHeight(refT";
_textheight = mostCurrent._su.MeasureMultilineTextHeight((android.widget.TextView)(_reftext.getObject()),_reftext.getText());
 //BA.debugLineNum = 345;BA.debugLine="If refText.Height < TextHeight Then";
if (_reftext.getHeight()<_textheight) { 
 //BA.debugLineNum = 347;BA.debugLine="refText.Height = TextHeight";
_reftext.setHeight(_textheight);
 //BA.debugLineNum = 348;BA.debugLine="If progressBox.Height < TextHeight+refText.Top";
if (_progressbox.getHeight()<_textheight+_reftext.getTop()) { 
 //BA.debugLineNum = 349;BA.debugLine="Dim addHeight As Int = (TextHeight+refText.Top";
_addheight = (int) ((_textheight+_reftext.getTop())-_progressbox.getHeight());
 //BA.debugLineNum = 350;BA.debugLine="progressBox.Height = progressBox.Height + addH";
_progressbox.setHeight((int) (_progressbox.getHeight()+_addheight+_reftext.getTop()));
 };
 };
 //BA.debugLineNum = 355;BA.debugLine="IconTop = IconTop + progressBox.Height + Gap";
_icontop = (int) (_icontop+_progressbox.getHeight()+_gap);
 //BA.debugLineNum = 356;BA.debugLine="PanelTop = PanelTop + progressBox.Height + Gap";
_paneltop = (int) (_paneltop+_progressbox.getHeight()+_gap);
 //BA.debugLineNum = 357;BA.debugLine="LastIconTop = statusIcon.Top";
_lasticontop = _statusicon.getTop();
 }
;
 //BA.debugLineNum = 360;BA.debugLine="journeyPanel.Height = PanelTop + scrollView.Top";
_journeypanel.setHeight((int) (_paneltop+mostCurrent._scrollview.getTop()));
 //BA.debugLineNum = 362;BA.debugLine="referenceWrapper.Height = LastIconTop";
_referencewrapper.setHeight(_lasticontop);
 //BA.debugLineNum = 363;BA.debugLine="DrawDashLine(referenceWrapper,0,0,0,referenceWrap";
_drawdashline((anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_referencewrapper.getObject())),(float) (0),(float) (0),(float) (0),(float) (_referencewrapper.getHeight()),anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (177),(int) (177),(int) (177)),(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (4))));
 //BA.debugLineNum = 365;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="Public userId As Int";
_userid = 0;
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return "";
}
public static String  _showicon_click() throws Exception{
anywheresoftware.b4a.objects.PanelWrapper _detailpanel = null;
anywheresoftware.b4a.objects.PanelWrapper _jobtitlepanel = null;
anywheresoftware.b4a.objects.PanelWrapper _journeypanel = null;
anywheresoftware.b4a.objects.LabelWrapper _utiltextlabel = null;
 //BA.debugLineNum = 399;BA.debugLine="Sub showIcon_Click";
 //BA.debugLineNum = 400;BA.debugLine="Dim detailPanel,jobTitlePanel,journeyPanel As Pan";
_detailpanel = new anywheresoftware.b4a.objects.PanelWrapper();
_jobtitlepanel = new anywheresoftware.b4a.objects.PanelWrapper();
_journeypanel = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 401;BA.debugLine="Dim utilTextLabel As Label";
_utiltextlabel = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 403;BA.debugLine="detailPanel = detailList.Get(0)";
_detailpanel.setObject((android.view.ViewGroup)(mostCurrent._detaillist.Get((int) (0))));
 //BA.debugLineNum = 404;BA.debugLine="utilTextLabel = detailList.Get(1)";
_utiltextlabel.setObject((android.widget.TextView)(mostCurrent._detaillist.Get((int) (1))));
 //BA.debugLineNum = 405;BA.debugLine="jobTitlePanel = detailList.Get(2)";
_jobtitlepanel.setObject((android.view.ViewGroup)(mostCurrent._detaillist.Get((int) (2))));
 //BA.debugLineNum = 406;BA.debugLine="journeyPanel = detailList.Get(3)";
_journeypanel.setObject((android.view.ViewGroup)(mostCurrent._detaillist.Get((int) (3))));
 //BA.debugLineNum = 408;BA.debugLine="detailPanel.Height = detailPanel.Height + 200dip";
_detailpanel.setHeight((int) (_detailpanel.getHeight()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (200))));
 //BA.debugLineNum = 409;BA.debugLine="utilTextLabel.Top = detailPanel.Height";
_utiltextlabel.setTop(_detailpanel.getHeight());
 //BA.debugLineNum = 410;BA.debugLine="utilTextLabel.Text = \"Hide candidate details\"";
_utiltextlabel.setText((Object)("Hide candidate details"));
 //BA.debugLineNum = 411;BA.debugLine="jobTitlePanel.Top = utilTextLabel.Top + utilTextL";
_jobtitlepanel.setTop((int) (_utiltextlabel.getTop()+_utiltextlabel.getHeight()));
 //BA.debugLineNum = 412;BA.debugLine="scrollView.Top = jobTitlePanel.Top + jobTitlePane";
mostCurrent._scrollview.setTop((int) (_jobtitlepanel.getTop()+_jobtitlepanel.getHeight()));
 //BA.debugLineNum = 413;BA.debugLine="journeyPanel.Height = journeyPanel.Height + jobTi";
_journeypanel.setHeight((int) (_journeypanel.getHeight()+_jobtitlepanel.getTop()+_jobtitlepanel.getHeight()));
 //BA.debugLineNum = 415;BA.debugLine="showIcon.Visible = False";
mostCurrent._showicon.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 417;BA.debugLine="closeIcon.Top = detailPanel.Height - 5dip";
mostCurrent._closeicon.setTop((int) (_detailpanel.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))));
 //BA.debugLineNum = 418;BA.debugLine="closeIcon.Visible = True";
mostCurrent._closeicon.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 419;BA.debugLine="End Sub";
return "";
}
public static String  _tomixcase(String _entry) throws Exception{
anywheresoftware.b4a.keywords.StringBuilderWrapper _sb = null;
anywheresoftware.b4a.keywords.Regex.MatcherWrapper _m = null;
int _i = 0;
 //BA.debugLineNum = 476;BA.debugLine="Sub ToMixCase(Entry As String) As String";
 //BA.debugLineNum = 478;BA.debugLine="Dim sb As StringBuilder";
_sb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 479;BA.debugLine="Dim m As Matcher";
_m = new anywheresoftware.b4a.keywords.Regex.MatcherWrapper();
 //BA.debugLineNum = 480;BA.debugLine="Dim I As Int";
_i = 0;
 //BA.debugLineNum = 482;BA.debugLine="Entry = Entry.ToLowerCase";
_entry = _entry.toLowerCase();
 //BA.debugLineNum = 484;BA.debugLine="sb.Initialize";
_sb.Initialize();
 //BA.debugLineNum = 486;BA.debugLine="m = Regex.Matcher(\"(^\\w)|(\\s\\w)\", Entry)";
_m = anywheresoftware.b4a.keywords.Common.Regex.Matcher("(^\\w)|(\\s\\w)",_entry);
 //BA.debugLineNum = 488;BA.debugLine="Do While m.Find";
while (_m.Find()) {
 //BA.debugLineNum = 490;BA.debugLine="If m.Match.Length > 1 Then";
if (_m.getMatch().length()>1) { 
 //BA.debugLineNum = 492;BA.debugLine="sb.Append(Entry.SubString2(I, m.GetStart";
_sb.Append(_entry.substring(_i,(int) (_m.GetStart((int) (0))+1)));
 //BA.debugLineNum = 493;BA.debugLine="sb.Append(m.Match.SubString(1).ToUpperCa";
_sb.Append(_m.getMatch().substring((int) (1)).toUpperCase());
 }else {
 //BA.debugLineNum = 497;BA.debugLine="sb.Append(Entry.SubString2(I, m.GetStart";
_sb.Append(_entry.substring(_i,_m.GetStart((int) (0))));
 //BA.debugLineNum = 498;BA.debugLine="sb.Append(m.Match.ToUpperCase)";
_sb.Append(_m.getMatch().toUpperCase());
 };
 //BA.debugLineNum = 502;BA.debugLine="I = m.GetEnd(0)";
_i = _m.GetEnd((int) (0));
 }
;
 //BA.debugLineNum = 506;BA.debugLine="If I < Entry.Length Then";
if (_i<_entry.length()) { 
 //BA.debugLineNum = 508;BA.debugLine="sb.Append(Entry.SubString(I))";
_sb.Append(_entry.substring(_i));
 };
 //BA.debugLineNum = 512;BA.debugLine="Return sb.ToString";
if (true) return _sb.ToString();
 //BA.debugLineNum = 514;BA.debugLine="End Sub";
return "";
}
}
