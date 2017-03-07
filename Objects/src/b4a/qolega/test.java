package b4a.qolega;


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

public class test extends Activity implements B4AActivity{
	public static test mostCurrent;
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
			processBA = new BA(this.getApplicationContext(), null, null, "b4a.qolega", "b4a.qolega.test");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (test).");
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
		activityBA = new BA(this, layout, processBA, "b4a.qolega", "b4a.qolega.test");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.qolega.test", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (test) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (test) Resume **");
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
		return test.class;
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
        BA.LogInfo("** Activity (test) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
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
            BA.LogInfo("** Activity (test) Resume **");
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
public anywheresoftware.b4a.objects.StdActionBar _bar = null;
public anywheresoftware.b4a.samples.httputils2.httputils2service _httputils2service = null;
public b4a.qolega.main _main = null;
public b4a.qolega.starter _starter = null;
public b4a.qolega.referringlist _referringlist = null;
public b4a.qolega.testresponsive _testresponsive = null;
public b4a.qolega.test3 _test3 = null;
public b4a.qolega.test4 _test4 = null;

public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public static String  _activity_actionbarhomeclick() throws Exception{
 //BA.debugLineNum = 181;BA.debugLine="Sub Activity_ActionBarHomeClick";
 //BA.debugLineNum = 182;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 183;BA.debugLine="End Sub";
return "";
}
public static String  _activity_create(boolean _firsttime) throws Exception{
 //BA.debugLineNum = 24;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 27;BA.debugLine="Activity.Title = \"Candidate Progress\"";
mostCurrent._activity.setTitle((Object)("Candidate Progress"));
 //BA.debugLineNum = 29;BA.debugLine="Container.Initialize(\"\")";
mostCurrent._container.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 30;BA.debugLine="Container.Color = Colors.RGB(219,219,219)";
mostCurrent._container.setColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (219),(int) (219),(int) (219)));
 //BA.debugLineNum = 31;BA.debugLine="Activity.AddView(Container,0,0,100%x,100%y)";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._container.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 33;BA.debugLine="bar.Initialize(\"bar\")";
mostCurrent._bar.Initialize("bar",mostCurrent.activityBA);
 //BA.debugLineNum = 34;BA.debugLine="bar.ShowUpIndicator = True";
mostCurrent._bar.setShowUpIndicator(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 35;BA.debugLine="LoopPanel";
_looppanel();
 //BA.debugLineNum = 36;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 189;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 191;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 185;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 187;BA.debugLine="End Sub";
return "";
}
public static boolean  _areequal(int _b1,int _b2) throws Exception{
 //BA.debugLineNum = 209;BA.debugLine="Sub AreEqual(b1 As Int, b2 As Int) As Boolean";
 //BA.debugLineNum = 210;BA.debugLine="If b1 <> b2 Then Return False";
if (_b1!=_b2) { 
if (true) return anywheresoftware.b4a.keywords.Common.False;};
 //BA.debugLineNum = 211;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 212;BA.debugLine="End Sub";
return false;
}
public static String  _drawleftborder(anywheresoftware.b4a.objects.ConcreteViewWrapper _target,int _acolor,int _strokewidth,boolean _last) throws Exception{
anywheresoftware.b4a.objects.drawable.CanvasWrapper _c = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.PathWrapper _path1 = null;
 //BA.debugLineNum = 193;BA.debugLine="Public Sub DrawLeftBorder(Target As View, aColor A";
 //BA.debugLineNum = 194;BA.debugLine="Dim c As Canvas";
_c = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();
 //BA.debugLineNum = 195;BA.debugLine="c.Initialize(Target)";
_c.Initialize((android.view.View)(_target.getObject()));
 //BA.debugLineNum = 196;BA.debugLine="Dim Path1 As Path";
_path1 = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.PathWrapper();
 //BA.debugLineNum = 197;BA.debugLine="Path1.Initialize(0,0)";
_path1.Initialize((float) (0),(float) (0));
 //BA.debugLineNum = 199;BA.debugLine="If Last == True Then";
if (_last==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 200;BA.debugLine="Path1.LineTo(0,Target.Top)";
_path1.LineTo((float) (0),(float) (_target.getTop()));
 }else {
 //BA.debugLineNum = 202;BA.debugLine="Path1.LineTo(0,Target.Height)";
_path1.LineTo((float) (0),(float) (_target.getHeight()));
 };
 //BA.debugLineNum = 205;BA.debugLine="c.DrawPath(Path1, aColor, False, StrokeWidth)";
_c.DrawPath((android.graphics.Path)(_path1.getObject()),_acolor,anywheresoftware.b4a.keywords.Common.False,(float) (_strokewidth));
 //BA.debugLineNum = 206;BA.debugLine="Target.Invalidate";
_target.Invalidate();
 //BA.debugLineNum = 207;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 21;BA.debugLine="Private bar As StdActionBar";
mostCurrent._bar = new anywheresoftware.b4a.objects.StdActionBar();
 //BA.debugLineNum = 22;BA.debugLine="End Sub";
return "";
}
public static String  _looppanel() throws Exception{
anywheresoftware.b4a.objects.PanelWrapper _jobtitlepanel = null;
anywheresoftware.b4a.objects.PanelWrapper _detailpanel = null;
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
anywheresoftware.b4a.objects.collections.Map _root = null;
String _dataname = "";
String _datacompany = "";
String _datajobtitle = "";
int _utiltextw = 0;
anywheresoftware.b4a.objects.collections.List _journeys = null;
int _iterator = 0;
anywheresoftware.b4a.objects.collections.Map _coljourneys = null;
String _journeytext = "";
anywheresoftware.b4a.objects.ImageViewWrapper _statusicon = null;
int _theight = 0;
 //BA.debugLineNum = 38;BA.debugLine="Sub LoopPanel";
 //BA.debugLineNum = 39;BA.debugLine="Dim jobTitlePanel,detailPanel,referencePanel,prog";
_jobtitlepanel = new anywheresoftware.b4a.objects.PanelWrapper();
_detailpanel = new anywheresoftware.b4a.objects.PanelWrapper();
_referencepanel = new anywheresoftware.b4a.objects.PanelWrapper();
_progressbox = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 40;BA.debugLine="Dim PanelTop,IconTop,PanelHeight,ReferenceTop,Ref";
_paneltop = 0;
_icontop = 0;
_panelheight = 0;
_referencetop = 0;
_referenceheight = 0;
_gap = 0;
_textheight = 0;
 //BA.debugLineNum = 41;BA.debugLine="Dim jobTitle,utilText,refName,refCompany,refStatu";
_jobtitle = new anywheresoftware.b4a.objects.LabelWrapper();
_utiltext = new anywheresoftware.b4a.objects.LabelWrapper();
_refname = new anywheresoftware.b4a.objects.LabelWrapper();
_refcompany = new anywheresoftware.b4a.objects.LabelWrapper();
_refstatus = new anywheresoftware.b4a.objects.LabelWrapper();
_reftext = new anywheresoftware.b4a.objects.LabelWrapper();
_detailbtn = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 45;BA.debugLine="JSON.Initialize(File.ReadString(File.DirAssets";
mostCurrent._json.Initialize(anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"status_reference.json"));
 //BA.debugLineNum = 46;BA.debugLine="Dim root As Map = JSON.NextObject";
_root = new anywheresoftware.b4a.objects.collections.Map();
_root = mostCurrent._json.NextObject();
 //BA.debugLineNum = 48;BA.debugLine="Dim dataName As String = root.Get(\"name\")";
_dataname = BA.ObjectToString(_root.Get((Object)("name")));
 //BA.debugLineNum = 49;BA.debugLine="Dim dataCompany As String = root.Get(\"company\")";
_datacompany = BA.ObjectToString(_root.Get((Object)("company")));
 //BA.debugLineNum = 50;BA.debugLine="Dim dataJobtitle As String = root.Get(\"jobtitle\")";
_datajobtitle = BA.ObjectToString(_root.Get((Object)("jobtitle")));
 //BA.debugLineNum = 53;BA.debugLine="PanelTop = 10dip";
_paneltop = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
 //BA.debugLineNum = 55;BA.debugLine="PanelHeight = 110dip";
_panelheight = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (110));
 //BA.debugLineNum = 57;BA.debugLine="Gap = 10dip";
_gap = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
 //BA.debugLineNum = 59;BA.debugLine="detailPanel.Initialize(\"\")";
_detailpanel.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 60;BA.debugLine="detailPanel.Color = Colors.White";
_detailpanel.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 //BA.debugLineNum = 61;BA.debugLine="Container.AddView(detailPanel,0,10dip,100%x,75dip";
mostCurrent._container.AddView((android.view.View)(_detailpanel.getObject()),(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (75)));
 //BA.debugLineNum = 63;BA.debugLine="refName.Initialize(\"\")";
_refname.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 64;BA.debugLine="refName.Text = dataName";
_refname.setText((Object)(_dataname));
 //BA.debugLineNum = 65;BA.debugLine="refName.TextColor = Colors.RGB(74,74,74)";
_refname.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (74),(int) (74),(int) (74)));
 //BA.debugLineNum = 66;BA.debugLine="refName.Typeface = Typeface.DEFAULT_BOLD";
_refname.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 67;BA.debugLine="detailPanel.AddView(refName,10dip,10dip,detailPan";
_detailpanel.AddView((android.view.View)(_refname.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),(int) (_detailpanel.getWidth()-(_gap*2)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)));
 //BA.debugLineNum = 68;BA.debugLine="TextHeight = su.MeasureMultilineTextHeight(refNam";
_textheight = mostCurrent._su.MeasureMultilineTextHeight((android.widget.TextView)(_refname.getObject()),_refname.getText());
 //BA.debugLineNum = 71;BA.debugLine="refCompany.Initialize(\"\")";
_refcompany.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 72;BA.debugLine="refCompany.Text = dataCompany";
_refcompany.setText((Object)(_datacompany));
 //BA.debugLineNum = 73;BA.debugLine="refCompany.TextColor = Colors.RGB(179,179,179)";
_refcompany.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (179),(int) (179),(int) (179)));
 //BA.debugLineNum = 74;BA.debugLine="detailPanel.AddView(refCompany,10dip,TextHeight+G";
_detailpanel.AddView((android.view.View)(_refcompany.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),(int) (_textheight+_gap),(int) (_detailpanel.getWidth()-(_gap*2)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)));
 //BA.debugLineNum = 76;BA.debugLine="Dim utilTextW As Int = 100dip";
_utiltextw = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100));
 //BA.debugLineNum = 79;BA.debugLine="utilText.Initialize(\"\")";
_utiltext.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 80;BA.debugLine="Container.AddView(utilText,0,detailPanel.Height,1";
mostCurrent._container.AddView((android.view.View)(_utiltext.getObject()),(int) (0),_detailpanel.getHeight(),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)));
 //BA.debugLineNum = 81;BA.debugLine="utilText.Text = \"Show Candidate Text\"";
_utiltext.setText((Object)("Show Candidate Text"));
 //BA.debugLineNum = 82;BA.debugLine="utilText.Gravity = Gravity.CENTER";
_utiltext.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
 //BA.debugLineNum = 84;BA.debugLine="jobTitlePanel.Initialize(\"\")";
_jobtitlepanel.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 85;BA.debugLine="Container.AddView(jobTitlePanel,0,(detailPanel.He";
mostCurrent._container.AddView((android.view.View)(_jobtitlepanel.getObject()),(int) (0),(int) ((_detailpanel.getHeight()+_utiltext.getHeight())-_gap),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)));
 //BA.debugLineNum = 86;BA.debugLine="jobTitlePanel.Color = Colors.White";
_jobtitlepanel.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 //BA.debugLineNum = 88;BA.debugLine="jobTitle.Initialize(\"\")";
_jobtitle.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 89;BA.debugLine="jobTitle.Text = \"Referal Progress for \"&dataJobti";
_jobtitle.setText((Object)("Referal Progress for "+_datajobtitle));
 //BA.debugLineNum = 90;BA.debugLine="jobTitle.TextColor = Colors.RGB(74,74,74)";
_jobtitle.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (74),(int) (74),(int) (74)));
 //BA.debugLineNum = 91;BA.debugLine="jobTitlePanel.AddView(jobTitle,10dip,6dip,jobTitl";
_jobtitlepanel.AddView((android.view.View)(_jobtitle.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (6)),(int) (_jobtitlepanel.getWidth()-(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))*2)),_jobtitlepanel.getHeight());
 //BA.debugLineNum = 93;BA.debugLine="scrollView.Initialize(Activity.Height)";
mostCurrent._scrollview.Initialize(mostCurrent.activityBA,mostCurrent._activity.getHeight());
 //BA.debugLineNum = 94;BA.debugLine="scrollView.Color = Colors.White";
mostCurrent._scrollview.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 //BA.debugLineNum = 95;BA.debugLine="Container.AddView(scrollView,0,(detailPanel.Heigh";
mostCurrent._container.AddView((android.view.View)(mostCurrent._scrollview.getObject()),(int) (0),(int) ((_detailpanel.getHeight()+_utiltext.getHeight()+_jobtitlepanel.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)))),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 96;BA.debugLine="detailPanel = scrollView.Panel";
_detailpanel = mostCurrent._scrollview.getPanel();
 //BA.debugLineNum = 98;BA.debugLine="PanelTop = 0";
_paneltop = (int) (0);
 //BA.debugLineNum = 99;BA.debugLine="IconTop = 12dip";
_icontop = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (12));
 //BA.debugLineNum = 101;BA.debugLine="Dim journeys As List = root.Get(\"journeys\")";
_journeys = new anywheresoftware.b4a.objects.collections.List();
_journeys.setObject((java.util.List)(_root.Get((Object)("journeys"))));
 //BA.debugLineNum = 102;BA.debugLine="Dim iterator As Int = 1";
_iterator = (int) (1);
 //BA.debugLineNum = 104;BA.debugLine="For Each coljourneys As Map In journeys";
_coljourneys = new anywheresoftware.b4a.objects.collections.Map();
final anywheresoftware.b4a.BA.IterableList group45 = _journeys;
final int groupLen45 = group45.getSize();
for (int index45 = 0;index45 < groupLen45 ;index45++){
_coljourneys.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(group45.Get(index45)));
 //BA.debugLineNum = 105;BA.debugLine="Dim journeyText As String = coljourneys.Get(\"tex";
_journeytext = BA.ObjectToString(_coljourneys.Get((Object)("text")));
 //BA.debugLineNum = 107;BA.debugLine="progressBox.Initialize(\"\")";
_progressbox.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 108;BA.debugLine="detailPanel.AddView(progressBox,30dip,PanelTop,1";
_detailpanel.AddView((android.view.View)(_progressbox.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)),_paneltop,(int) (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA)-(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30))*2)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
 //BA.debugLineNum = 109;BA.debugLine="If iterator < journeys.size Then";
if (_iterator<_journeys.getSize()) { 
 //BA.debugLineNum = 110;BA.debugLine="DrawLeftBorder(progressBox,Colors.RGB(151,151,1";
_drawleftborder((anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_progressbox.getObject())),anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (151),(int) (151),(int) (151)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)),anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 112;BA.debugLine="DrawLeftBorder(progressBox,Colors.RGB(151,151,1";
_drawleftborder((anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_progressbox.getObject())),anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (151),(int) (151),(int) (151)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)),anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 116;BA.debugLine="Dim statusIcon As ImageView";
_statusicon = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 117;BA.debugLine="statusIcon.Initialize(\"\")";
_statusicon.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 118;BA.debugLine="statusIcon.Bitmap = LoadBitmap(File.DirAssets,\"c";
_statusicon.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"checked.png").getObject()));
 //BA.debugLineNum = 119;BA.debugLine="detailPanel.AddView(statusIcon,24dip,IconTop,16d";
_detailpanel.AddView((android.view.View)(_statusicon.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (24)),_icontop,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (16)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (16)));
 //BA.debugLineNum = 121;BA.debugLine="refStatus.Initialize(\"\")";
_refstatus.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 122;BA.debugLine="refStatus.Text = \"Qualifying\"";
_refstatus.setText((Object)("Qualifying"));
 //BA.debugLineNum = 123;BA.debugLine="refStatus.Color =  Colors.RGB(249,191,55)";
_refstatus.setColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (249),(int) (191),(int) (55)));
 //BA.debugLineNum = 124;BA.debugLine="refStatus.TextColor = Colors.White";
_refstatus.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 //BA.debugLineNum = 125;BA.debugLine="refStatus.Gravity = Gravity.CENTER";
_refstatus.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
 //BA.debugLineNum = 126;BA.debugLine="progressBox.AddView(refStatus,15dip,10dip,100dip";
_progressbox.AddView((android.view.View)(_refstatus.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (15)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)));
 //BA.debugLineNum = 128;BA.debugLine="refText.Initialize(\"\")";
_reftext.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 129;BA.debugLine="refText.Text = journeyText";
_reftext.setText((Object)(_journeytext));
 //BA.debugLineNum = 130;BA.debugLine="refText.TextSize = 12";
_reftext.setTextSize((float) (12));
 //BA.debugLineNum = 131;BA.debugLine="progressBox.AddView(refText,refStatus.Width+(Gap";
_progressbox.AddView((android.view.View)(_reftext.getObject()),(int) (_refstatus.getWidth()+(_gap*2)+5),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),(int) (_progressbox.getWidth()/(double)2),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 132;BA.debugLine="Dim tHeight As Int";
_theight = 0;
 //BA.debugLineNum = 134;BA.debugLine="tHeight =  su.MeasureMultilineTextHeight(refText";
_theight = mostCurrent._su.MeasureMultilineTextHeight((android.widget.TextView)(_reftext.getObject()),_reftext.getText());
 //BA.debugLineNum = 137;BA.debugLine="If progressBox.Height < tHeight Then";
if (_progressbox.getHeight()<_theight) { 
 //BA.debugLineNum = 138;BA.debugLine="progressBox.Height = tHeight";
_progressbox.setHeight(_theight);
 //BA.debugLineNum = 139;BA.debugLine="PanelTop = PanelTop + tHeight";
_paneltop = (int) (_paneltop+_theight);
 //BA.debugLineNum = 140;BA.debugLine="IconTop = IconTop + tHeight";
_icontop = (int) (_icontop+_theight);
 }else {
 //BA.debugLineNum = 142;BA.debugLine="PanelTop = PanelTop + progressBox.Height";
_paneltop = (int) (_paneltop+_progressbox.getHeight());
 //BA.debugLineNum = 143;BA.debugLine="IconTop = IconTop + progressBox.Height";
_icontop = (int) (_icontop+_progressbox.getHeight());
 };
 //BA.debugLineNum = 145;BA.debugLine="iterator = iterator + 1";
_iterator = (int) (_iterator+1);
 //BA.debugLineNum = 147;BA.debugLine="Log(PanelTop)";
anywheresoftware.b4a.keywords.Common.Log(BA.NumberToString(_paneltop));
 }
;
 //BA.debugLineNum = 150;BA.debugLine="detailPanel.Height = PanelTop+(PanelTop/journeys.";
_detailpanel.setHeight((int) (_paneltop+(_paneltop/(double)_journeys.getSize())+(_gap*2)+(_gap*_journeys.getSize())));
 //BA.debugLineNum = 179;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="Public userId As Int";
_userid = 0;
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return "";
}
}
