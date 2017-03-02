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
public anywheresoftware.b4a.objects.ScrollViewWrapper _scrollview = null;
public anywheresoftware.b4a.objects.collections.JSONParser _json = null;
public anywheresoftware.b4a.objects.StringUtils _su = null;
public b4a.qolega.main _main = null;
public b4a.qolega.starter _starter = null;
public b4a.qolega.referringlist _referringlist = null;

public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public static String  _activity_create(boolean _firsttime) throws Exception{
 //BA.debugLineNum = 20;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 23;BA.debugLine="Activity.AddMenuItem3(\"SearchItem\", \"SearchItem\",";
mostCurrent._activity.AddMenuItem3("SearchItem","SearchItem",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"search.png").getObject()),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 24;BA.debugLine="scrollView.Initialize(Activity.Height)";
mostCurrent._scrollview.Initialize(mostCurrent.activityBA,mostCurrent._activity.getHeight());
 //BA.debugLineNum = 25;BA.debugLine="scrollView.Color = Colors.RGB(219,219,219)";
mostCurrent._scrollview.setColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (219),(int) (219),(int) (219)));
 //BA.debugLineNum = 26;BA.debugLine="Activity.AddView(scrollView,0,0,100%x,100%y)";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._scrollview.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 27;BA.debugLine="LoopPanel";
_looppanel();
 //BA.debugLineNum = 28;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 143;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 145;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 139;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 141;BA.debugLine="End Sub";
return "";
}
public static String  _drawborder(anywheresoftware.b4a.objects.ConcreteViewWrapper _target,int _acolor,int _strokewidth) throws Exception{
anywheresoftware.b4a.objects.drawable.CanvasWrapper _c = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper _r = null;
 //BA.debugLineNum = 147;BA.debugLine="Public Sub DrawBorder(Target As View, aColor As In";
 //BA.debugLineNum = 148;BA.debugLine="Dim c As Canvas";
_c = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();
 //BA.debugLineNum = 149;BA.debugLine="c.Initialize(Target)";
_c.Initialize((android.view.View)(_target.getObject()));
 //BA.debugLineNum = 150;BA.debugLine="Dim r As Rect : r.Initialize(0, 0, Target.Width";
_r = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper();
 //BA.debugLineNum = 150;BA.debugLine="Dim r As Rect : r.Initialize(0, 0, Target.Width";
_r.Initialize((int) (0),(int) (0),_target.getWidth(),_target.getHeight());
 //BA.debugLineNum = 151;BA.debugLine="c.DrawRect(r, aColor, False, StrokeWidth)";
_c.DrawRect((android.graphics.Rect)(_r.getObject()),_acolor,anywheresoftware.b4a.keywords.Common.False,(float) (_strokewidth));
 //BA.debugLineNum = 152;BA.debugLine="Target.Invalidate";
_target.Invalidate();
 //BA.debugLineNum = 153;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 15;BA.debugLine="Dim scrollView As ScrollView";
mostCurrent._scrollview = new anywheresoftware.b4a.objects.ScrollViewWrapper();
 //BA.debugLineNum = 16;BA.debugLine="Dim JSON As JSONParser";
mostCurrent._json = new anywheresoftware.b4a.objects.collections.JSONParser();
 //BA.debugLineNum = 17;BA.debugLine="Dim su As StringUtils";
mostCurrent._su = new anywheresoftware.b4a.objects.StringUtils();
 //BA.debugLineNum = 18;BA.debugLine="End Sub";
return "";
}
public static String  _looppanel() throws Exception{
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bitmap1 = null;
anywheresoftware.b4a.objects.PanelWrapper _container = null;
anywheresoftware.b4a.objects.PanelWrapper _joblistpanel = null;
anywheresoftware.b4a.objects.PanelWrapper _referencepanel = null;
int _paneltop = 0;
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
anywheresoftware.b4a.objects.collections.List _root = null;
anywheresoftware.b4a.objects.collections.Map _colroot = null;
anywheresoftware.b4a.objects.collections.List _reference = null;
String _job_title = "";
String _job_location = "";
String _job_desc = "";
double _job_commision = 0;
int _sizeofref = 0;
anywheresoftware.b4a.objects.collections.Map _colreference = null;
anywheresoftware.b4a.objects.LabelWrapper _refname = null;
anywheresoftware.b4a.objects.LabelWrapper _refcompany = null;
anywheresoftware.b4a.objects.LabelWrapper _refstatus = null;
String _rname = "";
 //BA.debugLineNum = 31;BA.debugLine="Sub LoopPanel";
 //BA.debugLineNum = 32;BA.debugLine="Dim Bitmap1 As Bitmap";
_bitmap1 = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
 //BA.debugLineNum = 33;BA.debugLine="Dim Container As Panel";
_container = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 34;BA.debugLine="Dim JoblistPanel,ReferencePanel As Panel";
_joblistpanel = new anywheresoftware.b4a.objects.PanelWrapper();
_referencepanel = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 35;BA.debugLine="Dim PanelTop,PanelHeight,ReferenceTop,ReferenceHe";
_paneltop = 0;
_panelheight = 0;
_referencetop = 0;
_referenceheight = 0;
_gap = 0;
_textheight = 0;
 //BA.debugLineNum = 36;BA.debugLine="Dim JobTitle,Location,JobDesc,Currency,Commision";
_jobtitle = new anywheresoftware.b4a.objects.LabelWrapper();
_location = new anywheresoftware.b4a.objects.LabelWrapper();
_jobdesc = new anywheresoftware.b4a.objects.LabelWrapper();
_currency = new anywheresoftware.b4a.objects.LabelWrapper();
_commision = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 39;BA.debugLine="PanelTop = 10";
_paneltop = (int) (10);
 //BA.debugLineNum = 41;BA.debugLine="PanelHeight = 100";
_panelheight = (int) (100);
 //BA.debugLineNum = 43;BA.debugLine="Gap = 10";
_gap = (int) (10);
 //BA.debugLineNum = 45;BA.debugLine="Bitmap1.Initialize(File.DirAssets,\"logo.png\")";
_bitmap1.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"logo.png");
 //BA.debugLineNum = 46;BA.debugLine="Container = scrollView.Panel";
_container = mostCurrent._scrollview.getPanel();
 //BA.debugLineNum = 47;BA.debugLine="Container.Color = Colors.RGB(219,219,219)";
_container.setColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (219),(int) (219),(int) (219)));
 //BA.debugLineNum = 50;BA.debugLine="JSON.Initialize(File.ReadString(File.DirAssets";
mostCurrent._json.Initialize(anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"list.json"));
 //BA.debugLineNum = 51;BA.debugLine="Dim root As List = JSON.NextArray";
_root = new anywheresoftware.b4a.objects.collections.List();
_root = mostCurrent._json.NextArray();
 //BA.debugLineNum = 52;BA.debugLine="For Each colroot As Map In root";
_colroot = new anywheresoftware.b4a.objects.collections.Map();
final anywheresoftware.b4a.BA.IterableList group14 = _root;
final int groupLen14 = group14.getSize();
for (int index14 = 0;index14 < groupLen14 ;index14++){
_colroot.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(group14.Get(index14)));
 //BA.debugLineNum = 54;BA.debugLine="Dim reference As List = colroot.Get(\"reference\")";
_reference = new anywheresoftware.b4a.objects.collections.List();
_reference.setObject((java.util.List)(_colroot.Get((Object)("reference"))));
 //BA.debugLineNum = 55;BA.debugLine="Dim job_title As String = colroot.Get(\"jobtitle\"";
_job_title = BA.ObjectToString(_colroot.Get((Object)("jobtitle")));
 //BA.debugLineNum = 56;BA.debugLine="Dim job_location As String = colroot.Get(\"locati";
_job_location = BA.ObjectToString(_colroot.Get((Object)("location")));
 //BA.debugLineNum = 57;BA.debugLine="Dim job_desc As String = colroot.Get(\"jobdesc\")";
_job_desc = BA.ObjectToString(_colroot.Get((Object)("jobdesc")));
 //BA.debugLineNum = 58;BA.debugLine="Dim job_commision As Double = colroot.Get(\"commi";
_job_commision = (double)(BA.ObjectToNumber(_colroot.Get((Object)("commision"))));
 //BA.debugLineNum = 61;BA.debugLine="JoblistPanel.Initialize(\"\")";
_joblistpanel.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 62;BA.debugLine="JobTitle.Initialize(\"JobTitle\")";
_jobtitle.Initialize(mostCurrent.activityBA,"JobTitle");
 //BA.debugLineNum = 63;BA.debugLine="Location.Initialize(\"Location\")";
_location.Initialize(mostCurrent.activityBA,"Location");
 //BA.debugLineNum = 64;BA.debugLine="JobDesc.Initialize(\"JobDesc\")";
_jobdesc.Initialize(mostCurrent.activityBA,"JobDesc");
 //BA.debugLineNum = 65;BA.debugLine="Currency.Initialize(\"Currency\")";
_currency.Initialize(mostCurrent.activityBA,"Currency");
 //BA.debugLineNum = 66;BA.debugLine="Commision.Initialize(\"Commision\")";
_commision.Initialize(mostCurrent.activityBA,"Commision");
 //BA.debugLineNum = 69;BA.debugLine="JobTitle.Text = job_title";
_jobtitle.setText((Object)(_job_title));
 //BA.debugLineNum = 70;BA.debugLine="Location.Text = job_location";
_location.setText((Object)(_job_location));
 //BA.debugLineNum = 71;BA.debugLine="Location.TextColor = Colors.RGB(179,179,179)";
_location.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (179),(int) (179),(int) (179)));
 //BA.debugLineNum = 72;BA.debugLine="JobDesc.Text = job_desc";
_jobdesc.setText((Object)(_job_desc));
 //BA.debugLineNum = 73;BA.debugLine="JobDesc.TextColor = Colors.RGB(179,179,179)";
_jobdesc.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (179),(int) (179),(int) (179)));
 //BA.debugLineNum = 74;BA.debugLine="Currency.Text = \"IDR \"&NumberFormat(job_commisio";
_currency.setText((Object)("IDR "+anywheresoftware.b4a.keywords.Common.NumberFormat(_job_commision,(int) (0),(int) (2))));
 //BA.debugLineNum = 75;BA.debugLine="Currency.Typeface = Typeface.DEFAULT_BOLD";
_currency.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 76;BA.debugLine="Currency.TextColor = Colors.RGB(74,74,74)";
_currency.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (74),(int) (74),(int) (74)));
 //BA.debugLineNum = 77;BA.debugLine="Commision.Text = \"Commision\"";
_commision.setText((Object)("Commision"));
 //BA.debugLineNum = 78;BA.debugLine="Commision.TextColor = Colors.RGB(179,179,179)";
_commision.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (179),(int) (179),(int) (179)));
 //BA.debugLineNum = 81;BA.debugLine="JoblistPanel.AddView(JobTitle,10,10,100%x,50)";
_joblistpanel.AddView((android.view.View)(_jobtitle.getObject()),(int) (10),(int) (10),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),(int) (50));
 //BA.debugLineNum = 82;BA.debugLine="TextHeight = su.MeasureMultilineTextHeight(JobTi";
_textheight = mostCurrent._su.MeasureMultilineTextHeight((android.widget.TextView)(_jobtitle.getObject()),_jobtitle.getText());
 //BA.debugLineNum = 84;BA.debugLine="JoblistPanel.AddView(Location,10,TextHeight+Gap,";
_joblistpanel.AddView((android.view.View)(_location.getObject()),(int) (10),(int) (_textheight+_gap),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),(int) (50));
 //BA.debugLineNum = 85;BA.debugLine="TextHeight = TextHeight + su.MeasureMultilineTex";
_textheight = (int) (_textheight+mostCurrent._su.MeasureMultilineTextHeight((android.widget.TextView)(_location.getObject()),_location.getText()));
 //BA.debugLineNum = 87;BA.debugLine="JoblistPanel.AddView(JobDesc,10,TextHeight+Gap,1";
_joblistpanel.AddView((android.view.View)(_jobdesc.getObject()),(int) (10),(int) (_textheight+_gap),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),(int) (50));
 //BA.debugLineNum = 88;BA.debugLine="TextHeight = TextHeight + su.MeasureMultilineTex";
_textheight = (int) (_textheight+mostCurrent._su.MeasureMultilineTextHeight((android.widget.TextView)(_jobdesc.getObject()),_jobdesc.getText()));
 //BA.debugLineNum = 90;BA.debugLine="JoblistPanel.AddView(Currency,10,TextHeight+Gap,";
_joblistpanel.AddView((android.view.View)(_currency.getObject()),(int) (10),(int) (_textheight+_gap),(int) (100),(int) (50));
 //BA.debugLineNum = 91;BA.debugLine="JoblistPanel.AddView(Commision,110,TextHeight+Ga";
_joblistpanel.AddView((android.view.View)(_commision.getObject()),(int) (110),(int) (_textheight+_gap),(int) (100),(int) (50));
 //BA.debugLineNum = 92;BA.debugLine="TextHeight = TextHeight + su.MeasureMultilineTex";
_textheight = (int) (_textheight+mostCurrent._su.MeasureMultilineTextHeight((android.widget.TextView)(_currency.getObject()),_jobdesc.getText()));
 //BA.debugLineNum = 94;BA.debugLine="JoblistPanel.Color=Colors.RGB(255,255,255)";
_joblistpanel.setColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (255),(int) (255),(int) (255)));
 //BA.debugLineNum = 97;BA.debugLine="ReferenceTop = TextHeight-Gap";
_referencetop = (int) (_textheight-_gap);
 //BA.debugLineNum = 99;BA.debugLine="ReferenceHeight = 89dip";
_referenceheight = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (89));
 //BA.debugLineNum = 102;BA.debugLine="Dim SizeOfRef As Int = reference.Size";
_sizeofref = _reference.getSize();
 //BA.debugLineNum = 106;BA.debugLine="PanelHeight = PanelHeight+(ReferenceHeight*SizeO";
_panelheight = (int) (_panelheight+(_referenceheight*_sizeofref)+(_gap*_sizeofref));
 //BA.debugLineNum = 108;BA.debugLine="For Each colreference As Map In reference";
_colreference = new anywheresoftware.b4a.objects.collections.Map();
final anywheresoftware.b4a.BA.IterableList group50 = _reference;
final int groupLen50 = group50.getSize();
for (int index50 = 0;index50 < groupLen50 ;index50++){
_colreference.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(group50.Get(index50)));
 //BA.debugLineNum = 109;BA.debugLine="Dim refName,refCompany,refStatus As Label";
_refname = new anywheresoftware.b4a.objects.LabelWrapper();
_refcompany = new anywheresoftware.b4a.objects.LabelWrapper();
_refstatus = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 111;BA.debugLine="Dim rName As String = colreference.Get(\"name\")";
_rname = BA.ObjectToString(_colreference.Get((Object)("name")));
 //BA.debugLineNum = 113;BA.debugLine="ReferencePanel.Initialize(\"\")";
_referencepanel.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 114;BA.debugLine="ReferencePanel.Color = Colors.White";
_referencepanel.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 //BA.debugLineNum = 115;BA.debugLine="JoblistPanel.AddView(ReferencePanel,40,Referenc";
_joblistpanel.AddView((android.view.View)(_referencepanel.getObject()),(int) (40),_referencetop,(int) (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (90),mostCurrent.activityBA)-10),_referenceheight);
 //BA.debugLineNum = 116;BA.debugLine="DrawBorder(ReferencePanel,Colors.RGB(219,219,21";
_drawborder((anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_referencepanel.getObject())),anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (219),(int) (219),(int) (219)),(int) (4));
 //BA.debugLineNum = 119;BA.debugLine="refName.Initialize(\"\")";
_refname.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 120;BA.debugLine="refName.Text = rName";
_refname.setText((Object)(_rname));
 //BA.debugLineNum = 121;BA.debugLine="refName.TextColor = Colors.RGB(74,74,74)";
_refname.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (74),(int) (74),(int) (74)));
 //BA.debugLineNum = 122;BA.debugLine="refName.Typeface = Typeface.DEFAULT_BOLD";
_refname.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 123;BA.debugLine="ReferencePanel.AddView(refName,10,10,200,50)";
_referencepanel.AddView((android.view.View)(_refname.getObject()),(int) (10),(int) (10),(int) (200),(int) (50));
 //BA.debugLineNum = 126;BA.debugLine="refCompany.Initialize(\"\")";
_refcompany.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 128;BA.debugLine="ReferenceTop = ReferenceTop+ReferenceHeight+Gap";
_referencetop = (int) (_referencetop+_referenceheight+_gap);
 }
;
 //BA.debugLineNum = 131;BA.debugLine="Container.AddView(JoblistPanel,0,PanelTop,Contai";
_container.AddView((android.view.View)(_joblistpanel.getObject()),(int) (0),_paneltop,_container.getWidth(),_panelheight);
 //BA.debugLineNum = 132;BA.debugLine="PanelTop = PanelTop+PanelHeight+Gap";
_paneltop = (int) (_paneltop+_panelheight+_gap);
 //BA.debugLineNum = 133;BA.debugLine="PanelHeight = 100";
_panelheight = (int) (100);
 }
;
 //BA.debugLineNum = 135;BA.debugLine="Container.Height = PanelTop";
_container.setHeight(_paneltop);
 //BA.debugLineNum = 136;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return "";
}
}
