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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.qolega", "b4a.qolega.test");
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
public b4a.qolega.main _main = null;
public b4a.qolega.starter _starter = null;
public b4a.qolega.referringlist _referringlist = null;
public b4a.qolega.testresponsive _testresponsive = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="test";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create"))
	return (String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime});
RDebugUtils.currentLine=1310720;
 //BA.debugLineNum = 1310720;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=1310723;
 //BA.debugLineNum = 1310723;BA.debugLine="Activity.AddMenuItem3(\"SearchItem\", \"SearchItem\",";
mostCurrent._activity.AddMenuItem3("SearchItem","SearchItem",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"search.png").getObject()),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1310724;
 //BA.debugLineNum = 1310724;BA.debugLine="scrollView.Initialize(Activity.Height)";
mostCurrent._scrollview.Initialize(mostCurrent.activityBA,mostCurrent._activity.getHeight());
RDebugUtils.currentLine=1310725;
 //BA.debugLineNum = 1310725;BA.debugLine="scrollView.Color = Colors.RGB(219,219,219)";
mostCurrent._scrollview.setColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (219),(int) (219),(int) (219)));
RDebugUtils.currentLine=1310726;
 //BA.debugLineNum = 1310726;BA.debugLine="Activity.AddView(scrollView,0,0,100%x,100%y)";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._scrollview.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
RDebugUtils.currentLine=1310727;
 //BA.debugLineNum = 1310727;BA.debugLine="LoopPanel";
_looppanel();
RDebugUtils.currentLine=1310728;
 //BA.debugLineNum = 1310728;BA.debugLine="End Sub";
return "";
}
public static String  _looppanel() throws Exception{
RDebugUtils.currentModule="test";
if (Debug.shouldDelegate(mostCurrent.activityBA, "looppanel"))
	return (String) Debug.delegate(mostCurrent.activityBA, "looppanel", null);
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
String _statusref = "";
int _rheight = 0;
int _statusrefcolor = 0;
anywheresoftware.b4a.objects.ButtonWrapper _detailbtn = null;
String _rname = "";
String _rcompany = "";
String _rstatus = "";
RDebugUtils.currentLine=1376256;
 //BA.debugLineNum = 1376256;BA.debugLine="Sub LoopPanel";
RDebugUtils.currentLine=1376257;
 //BA.debugLineNum = 1376257;BA.debugLine="Dim Bitmap1 As Bitmap";
_bitmap1 = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
RDebugUtils.currentLine=1376258;
 //BA.debugLineNum = 1376258;BA.debugLine="Dim Container As Panel";
_container = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=1376259;
 //BA.debugLineNum = 1376259;BA.debugLine="Dim JoblistPanel,ReferencePanel As Panel";
_joblistpanel = new anywheresoftware.b4a.objects.PanelWrapper();
_referencepanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=1376260;
 //BA.debugLineNum = 1376260;BA.debugLine="Dim PanelTop,PanelHeight,ReferenceTop,ReferenceHe";
_paneltop = 0;
_panelheight = 0;
_referencetop = 0;
_referenceheight = 0;
_gap = 0;
_textheight = 0;
RDebugUtils.currentLine=1376261;
 //BA.debugLineNum = 1376261;BA.debugLine="Dim JobTitle,Location,JobDesc,Currency,Commision";
_jobtitle = new anywheresoftware.b4a.objects.LabelWrapper();
_location = new anywheresoftware.b4a.objects.LabelWrapper();
_jobdesc = new anywheresoftware.b4a.objects.LabelWrapper();
_currency = new anywheresoftware.b4a.objects.LabelWrapper();
_commision = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=1376264;
 //BA.debugLineNum = 1376264;BA.debugLine="PanelTop = 10dip";
_paneltop = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
RDebugUtils.currentLine=1376266;
 //BA.debugLineNum = 1376266;BA.debugLine="PanelHeight = 110dip";
_panelheight = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (110));
RDebugUtils.currentLine=1376268;
 //BA.debugLineNum = 1376268;BA.debugLine="Gap = 10dip";
_gap = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
RDebugUtils.currentLine=1376271;
 //BA.debugLineNum = 1376271;BA.debugLine="Container = scrollView.Panel";
_container = mostCurrent._scrollview.getPanel();
RDebugUtils.currentLine=1376272;
 //BA.debugLineNum = 1376272;BA.debugLine="Container.Color = Colors.RGB(219,219,219)";
_container.setColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (219),(int) (219),(int) (219)));
RDebugUtils.currentLine=1376275;
 //BA.debugLineNum = 1376275;BA.debugLine="JSON.Initialize(File.ReadString(File.DirAssets";
mostCurrent._json.Initialize(anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"list.json"));
RDebugUtils.currentLine=1376276;
 //BA.debugLineNum = 1376276;BA.debugLine="Dim root As List = JSON.NextArray";
_root = new anywheresoftware.b4a.objects.collections.List();
_root = mostCurrent._json.NextArray();
RDebugUtils.currentLine=1376277;
 //BA.debugLineNum = 1376277;BA.debugLine="For Each colroot As Map In root";
_colroot = new anywheresoftware.b4a.objects.collections.Map();
final anywheresoftware.b4a.BA.IterableList group13 = _root;
final int groupLen13 = group13.getSize();
for (int index13 = 0;index13 < groupLen13 ;index13++){
_colroot.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(group13.Get(index13)));
RDebugUtils.currentLine=1376279;
 //BA.debugLineNum = 1376279;BA.debugLine="Dim reference As List = colroot.Get(\"reference\")";
_reference = new anywheresoftware.b4a.objects.collections.List();
_reference.setObject((java.util.List)(_colroot.Get((Object)("reference"))));
RDebugUtils.currentLine=1376280;
 //BA.debugLineNum = 1376280;BA.debugLine="Dim job_title As String = colroot.Get(\"jobtitle\"";
_job_title = BA.ObjectToString(_colroot.Get((Object)("jobtitle")));
RDebugUtils.currentLine=1376281;
 //BA.debugLineNum = 1376281;BA.debugLine="Dim job_location As String = colroot.Get(\"locati";
_job_location = BA.ObjectToString(_colroot.Get((Object)("location")));
RDebugUtils.currentLine=1376282;
 //BA.debugLineNum = 1376282;BA.debugLine="Dim job_desc As String = colroot.Get(\"jobdesc\")";
_job_desc = BA.ObjectToString(_colroot.Get((Object)("jobdesc")));
RDebugUtils.currentLine=1376283;
 //BA.debugLineNum = 1376283;BA.debugLine="Dim job_commision As Double = colroot.Get(\"commi";
_job_commision = (double)(BA.ObjectToNumber(_colroot.Get((Object)("commision"))));
RDebugUtils.currentLine=1376286;
 //BA.debugLineNum = 1376286;BA.debugLine="JoblistPanel.Initialize(\"\")";
_joblistpanel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1376287;
 //BA.debugLineNum = 1376287;BA.debugLine="JobTitle.Initialize(\"JobTitle\")";
_jobtitle.Initialize(mostCurrent.activityBA,"JobTitle");
RDebugUtils.currentLine=1376288;
 //BA.debugLineNum = 1376288;BA.debugLine="Location.Initialize(\"Location\")";
_location.Initialize(mostCurrent.activityBA,"Location");
RDebugUtils.currentLine=1376289;
 //BA.debugLineNum = 1376289;BA.debugLine="JobDesc.Initialize(\"JobDesc\")";
_jobdesc.Initialize(mostCurrent.activityBA,"JobDesc");
RDebugUtils.currentLine=1376290;
 //BA.debugLineNum = 1376290;BA.debugLine="Currency.Initialize(\"Currency\")";
_currency.Initialize(mostCurrent.activityBA,"Currency");
RDebugUtils.currentLine=1376291;
 //BA.debugLineNum = 1376291;BA.debugLine="Commision.Initialize(\"Commision\")";
_commision.Initialize(mostCurrent.activityBA,"Commision");
RDebugUtils.currentLine=1376294;
 //BA.debugLineNum = 1376294;BA.debugLine="JobTitle.Text = job_title";
_jobtitle.setText((Object)(_job_title));
RDebugUtils.currentLine=1376295;
 //BA.debugLineNum = 1376295;BA.debugLine="Location.Text = job_location";
_location.setText((Object)(_job_location));
RDebugUtils.currentLine=1376296;
 //BA.debugLineNum = 1376296;BA.debugLine="Location.TextColor = Colors.RGB(179,179,179)";
_location.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (179),(int) (179),(int) (179)));
RDebugUtils.currentLine=1376297;
 //BA.debugLineNum = 1376297;BA.debugLine="JobDesc.Text = job_desc";
_jobdesc.setText((Object)(_job_desc));
RDebugUtils.currentLine=1376298;
 //BA.debugLineNum = 1376298;BA.debugLine="JobDesc.TextColor = Colors.RGB(179,179,179)";
_jobdesc.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (179),(int) (179),(int) (179)));
RDebugUtils.currentLine=1376299;
 //BA.debugLineNum = 1376299;BA.debugLine="Currency.Text = \"IDR \"&NumberFormat(job_commisio";
_currency.setText((Object)("IDR "+anywheresoftware.b4a.keywords.Common.NumberFormat(_job_commision,(int) (0),(int) (2))));
RDebugUtils.currentLine=1376300;
 //BA.debugLineNum = 1376300;BA.debugLine="Currency.Typeface = Typeface.DEFAULT_BOLD";
_currency.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT_BOLD);
RDebugUtils.currentLine=1376301;
 //BA.debugLineNum = 1376301;BA.debugLine="Currency.TextColor = Colors.RGB(74,74,74)";
_currency.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (74),(int) (74),(int) (74)));
RDebugUtils.currentLine=1376302;
 //BA.debugLineNum = 1376302;BA.debugLine="Commision.Text = \"Commision\"";
_commision.setText((Object)("Commision"));
RDebugUtils.currentLine=1376303;
 //BA.debugLineNum = 1376303;BA.debugLine="Commision.TextColor = Colors.RGB(179,179,179)";
_commision.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (179),(int) (179),(int) (179)));
RDebugUtils.currentLine=1376306;
 //BA.debugLineNum = 1376306;BA.debugLine="JoblistPanel.AddView(JobTitle,10dip,10dip,100%x,";
_joblistpanel.AddView((android.view.View)(_jobtitle.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)));
RDebugUtils.currentLine=1376307;
 //BA.debugLineNum = 1376307;BA.debugLine="TextHeight = su.MeasureMultilineTextHeight(JobTi";
_textheight = mostCurrent._su.MeasureMultilineTextHeight((android.widget.TextView)(_jobtitle.getObject()),_jobtitle.getText());
RDebugUtils.currentLine=1376309;
 //BA.debugLineNum = 1376309;BA.debugLine="JoblistPanel.AddView(Location,10dip,TextHeight+G";
_joblistpanel.AddView((android.view.View)(_location.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),(int) (_textheight+_gap),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)));
RDebugUtils.currentLine=1376310;
 //BA.debugLineNum = 1376310;BA.debugLine="TextHeight = TextHeight + su.MeasureMultilineTex";
_textheight = (int) (_textheight+mostCurrent._su.MeasureMultilineTextHeight((android.widget.TextView)(_location.getObject()),_location.getText()));
RDebugUtils.currentLine=1376312;
 //BA.debugLineNum = 1376312;BA.debugLine="JoblistPanel.AddView(JobDesc,10dip,TextHeight+Ga";
_joblistpanel.AddView((android.view.View)(_jobdesc.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),(int) (_textheight+_gap),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)));
RDebugUtils.currentLine=1376313;
 //BA.debugLineNum = 1376313;BA.debugLine="TextHeight = TextHeight + su.MeasureMultilineTex";
_textheight = (int) (_textheight+mostCurrent._su.MeasureMultilineTextHeight((android.widget.TextView)(_jobdesc.getObject()),_jobdesc.getText()));
RDebugUtils.currentLine=1376315;
 //BA.debugLineNum = 1376315;BA.debugLine="JoblistPanel.AddView(Currency,10dip,TextHeight+G";
_joblistpanel.AddView((android.view.View)(_currency.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),(int) (_textheight+_gap),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)));
RDebugUtils.currentLine=1376316;
 //BA.debugLineNum = 1376316;BA.debugLine="JoblistPanel.AddView(Commision,110dip,TextHeight";
_joblistpanel.AddView((android.view.View)(_commision.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (110)),(int) (_textheight+_gap),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)));
RDebugUtils.currentLine=1376317;
 //BA.debugLineNum = 1376317;BA.debugLine="TextHeight = TextHeight + su.MeasureMultilineTex";
_textheight = (int) (_textheight+mostCurrent._su.MeasureMultilineTextHeight((android.widget.TextView)(_currency.getObject()),_jobdesc.getText()));
RDebugUtils.currentLine=1376319;
 //BA.debugLineNum = 1376319;BA.debugLine="JoblistPanel.Color=Colors.RGB(255,255,255)";
_joblistpanel.setColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (255),(int) (255),(int) (255)));
RDebugUtils.currentLine=1376322;
 //BA.debugLineNum = 1376322;BA.debugLine="ReferenceTop = TextHeight+Gap*2";
_referencetop = (int) (_textheight+_gap*2);
RDebugUtils.currentLine=1376324;
 //BA.debugLineNum = 1376324;BA.debugLine="ReferenceHeight = 89dip";
_referenceheight = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (89));
RDebugUtils.currentLine=1376327;
 //BA.debugLineNum = 1376327;BA.debugLine="Dim SizeOfRef As Int = reference.Size";
_sizeofref = _reference.getSize();
RDebugUtils.currentLine=1376331;
 //BA.debugLineNum = 1376331;BA.debugLine="PanelHeight = PanelHeight+(ReferenceHeight*SizeO";
_panelheight = (int) (_panelheight+(_referenceheight*_sizeofref)+(_gap*_sizeofref));
RDebugUtils.currentLine=1376333;
 //BA.debugLineNum = 1376333;BA.debugLine="For Each colreference As Map In reference";
_colreference = new anywheresoftware.b4a.objects.collections.Map();
final anywheresoftware.b4a.BA.IterableList group49 = _reference;
final int groupLen49 = group49.getSize();
for (int index49 = 0;index49 < groupLen49 ;index49++){
_colreference.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(group49.Get(index49)));
RDebugUtils.currentLine=1376334;
 //BA.debugLineNum = 1376334;BA.debugLine="Dim refName,refCompany,refStatus As Label";
_refname = new anywheresoftware.b4a.objects.LabelWrapper();
_refcompany = new anywheresoftware.b4a.objects.LabelWrapper();
_refstatus = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=1376335;
 //BA.debugLineNum = 1376335;BA.debugLine="Dim statusRef As String";
_statusref = "";
RDebugUtils.currentLine=1376336;
 //BA.debugLineNum = 1376336;BA.debugLine="Dim rHeight,statusRefColor As Int";
_rheight = 0;
_statusrefcolor = 0;
RDebugUtils.currentLine=1376337;
 //BA.debugLineNum = 1376337;BA.debugLine="Dim detailBtn As Button";
_detailbtn = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=1376340;
 //BA.debugLineNum = 1376340;BA.debugLine="Dim rName As String = colreference.Get(\"name\")";
_rname = BA.ObjectToString(_colreference.Get((Object)("name")));
RDebugUtils.currentLine=1376341;
 //BA.debugLineNum = 1376341;BA.debugLine="Dim rCompany As String = colreference.Get(\"comp";
_rcompany = BA.ObjectToString(_colreference.Get((Object)("company")));
RDebugUtils.currentLine=1376342;
 //BA.debugLineNum = 1376342;BA.debugLine="Dim rStatus As String = colreference.Get(\"statu";
_rstatus = BA.ObjectToString(_colreference.Get((Object)("status")));
RDebugUtils.currentLine=1376345;
 //BA.debugLineNum = 1376345;BA.debugLine="ReferencePanel.Initialize(\"\")";
_referencepanel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1376346;
 //BA.debugLineNum = 1376346;BA.debugLine="ReferencePanel.Color = Colors.White";
_referencepanel.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=1376347;
 //BA.debugLineNum = 1376347;BA.debugLine="JoblistPanel.AddView(ReferencePanel,40,Referenc";
_joblistpanel.AddView((android.view.View)(_referencepanel.getObject()),(int) (40),_referencetop,(int) (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (90),mostCurrent.activityBA)-10),_referenceheight);
RDebugUtils.currentLine=1376348;
 //BA.debugLineNum = 1376348;BA.debugLine="DrawBorder(ReferencePanel,Colors.RGB(219,219,21";
_drawborder((anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_referencepanel.getObject())),anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (219),(int) (219),(int) (219)),(int) (4));
RDebugUtils.currentLine=1376351;
 //BA.debugLineNum = 1376351;BA.debugLine="refName.Initialize(\"\")";
_refname.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1376352;
 //BA.debugLineNum = 1376352;BA.debugLine="refName.Text = rName";
_refname.setText((Object)(_rname));
RDebugUtils.currentLine=1376353;
 //BA.debugLineNum = 1376353;BA.debugLine="refName.TextColor = Colors.RGB(74,74,74)";
_refname.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (74),(int) (74),(int) (74)));
RDebugUtils.currentLine=1376354;
 //BA.debugLineNum = 1376354;BA.debugLine="refName.Typeface = Typeface.DEFAULT_BOLD";
_refname.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT_BOLD);
RDebugUtils.currentLine=1376355;
 //BA.debugLineNum = 1376355;BA.debugLine="ReferencePanel.AddView(refName,10,10,ReferenceP";
_referencepanel.AddView((android.view.View)(_refname.getObject()),(int) (10),(int) (10),(int) (_referencepanel.getWidth()-_gap),(int) (50));
RDebugUtils.currentLine=1376356;
 //BA.debugLineNum = 1376356;BA.debugLine="rHeight = su.MeasureMultilineTextHeight(refName";
_rheight = mostCurrent._su.MeasureMultilineTextHeight((android.widget.TextView)(_refname.getObject()),_refname.getText());
RDebugUtils.currentLine=1376359;
 //BA.debugLineNum = 1376359;BA.debugLine="refCompany.Initialize(\"\")";
_refcompany.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1376360;
 //BA.debugLineNum = 1376360;BA.debugLine="refCompany.Text = rCompany";
_refcompany.setText((Object)(_rcompany));
RDebugUtils.currentLine=1376361;
 //BA.debugLineNum = 1376361;BA.debugLine="refCompany.TextColor = Colors.RGB(219,219,219)";
_refcompany.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (219),(int) (219),(int) (219)));
RDebugUtils.currentLine=1376362;
 //BA.debugLineNum = 1376362;BA.debugLine="ReferencePanel.AddView(refCompany,10,rHeight+Ga";
_referencepanel.AddView((android.view.View)(_refcompany.getObject()),(int) (10),(int) (_rheight+_gap),(int) (_referencepanel.getWidth()-_gap),(int) (50));
RDebugUtils.currentLine=1376363;
 //BA.debugLineNum = 1376363;BA.debugLine="rHeight = rHeight + su.MeasureMultilineTextHeig";
_rheight = (int) (_rheight+mostCurrent._su.MeasureMultilineTextHeight((android.widget.TextView)(_refcompany.getObject()),_refcompany.getText()));
RDebugUtils.currentLine=1376366;
 //BA.debugLineNum = 1376366;BA.debugLine="Select rStatus";
switch (BA.switchObjectToInt(_rstatus,BA.NumberToString(0),BA.NumberToString(1))) {
case 0: {
RDebugUtils.currentLine=1376368;
 //BA.debugLineNum = 1376368;BA.debugLine="statusRef = \"Qualifying\"";
_statusref = "Qualifying";
RDebugUtils.currentLine=1376369;
 //BA.debugLineNum = 1376369;BA.debugLine="statusRefColor = Colors.RGB(249,191,55)";
_statusrefcolor = anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (249),(int) (191),(int) (55));
 break; }
case 1: {
RDebugUtils.currentLine=1376371;
 //BA.debugLineNum = 1376371;BA.debugLine="statusRef = \"1st Interview\"";
_statusref = "1st Interview";
RDebugUtils.currentLine=1376372;
 //BA.debugLineNum = 1376372;BA.debugLine="statusRefColor = Colors.RGB(102,195,67)";
_statusrefcolor = anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (102),(int) (195),(int) (67));
 break; }
default: {
RDebugUtils.currentLine=1376374;
 //BA.debugLineNum = 1376374;BA.debugLine="statusRef = \"Completed\"";
_statusref = "Completed";
RDebugUtils.currentLine=1376375;
 //BA.debugLineNum = 1376375;BA.debugLine="statusRefColor = Colors.RGB(22,176,221)";
_statusrefcolor = anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (22),(int) (176),(int) (221));
 break; }
}
;
RDebugUtils.currentLine=1376378;
 //BA.debugLineNum = 1376378;BA.debugLine="refStatus.Initialize(\"\")";
_refstatus.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1376379;
 //BA.debugLineNum = 1376379;BA.debugLine="refStatus.Text = statusRef";
_refstatus.setText((Object)(_statusref));
RDebugUtils.currentLine=1376380;
 //BA.debugLineNum = 1376380;BA.debugLine="refStatus.TextColor = Colors.White";
_refstatus.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=1376381;
 //BA.debugLineNum = 1376381;BA.debugLine="refStatus.Color = statusRefColor";
_refstatus.setColor(_statusrefcolor);
RDebugUtils.currentLine=1376382;
 //BA.debugLineNum = 1376382;BA.debugLine="refStatus.Gravity = Gravity.CENTER";
_refstatus.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=1376383;
 //BA.debugLineNum = 1376383;BA.debugLine="ReferencePanel.AddView(refStatus,10,rHeight+Gap";
_referencepanel.AddView((android.view.View)(_refstatus.getObject()),(int) (10),(int) (_rheight+_gap+10),(int) ((_referencepanel.getWidth()-_gap)/(double)2),(int) (50));
RDebugUtils.currentLine=1376386;
 //BA.debugLineNum = 1376386;BA.debugLine="detailBtn.Initialize(\"detailBtn\")";
_detailbtn.Initialize(mostCurrent.activityBA,"detailBtn");
RDebugUtils.currentLine=1376387;
 //BA.debugLineNum = 1376387;BA.debugLine="detailBtn.Text = \"Detail Progress\"";
_detailbtn.setText((Object)("Detail Progress"));
RDebugUtils.currentLine=1376388;
 //BA.debugLineNum = 1376388;BA.debugLine="detailBtn.Gravity = Gravity.CENTER";
_detailbtn.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=1376389;
 //BA.debugLineNum = 1376389;BA.debugLine="detailBtn.TextSize = 10";
_detailbtn.setTextSize((float) (10));
RDebugUtils.currentLine=1376390;
 //BA.debugLineNum = 1376390;BA.debugLine="ReferencePanel.AddView(detailBtn,((ReferencePan";
_referencepanel.AddView((android.view.View)(_detailbtn.getObject()),(int) (((_referencepanel.getWidth()-_gap)/(double)2)+10),(int) (_rheight+_gap),(int) ((_referencepanel.getWidth()-_gap)/(double)2),(int) (65));
RDebugUtils.currentLine=1376393;
 //BA.debugLineNum = 1376393;BA.debugLine="ReferenceTop = ReferenceTop+ReferenceHeight+Gap";
_referencetop = (int) (_referencetop+_referenceheight+_gap);
 }
;
RDebugUtils.currentLine=1376396;
 //BA.debugLineNum = 1376396;BA.debugLine="Container.AddView(JoblistPanel,0,PanelTop,Contai";
_container.AddView((android.view.View)(_joblistpanel.getObject()),(int) (0),_paneltop,_container.getWidth(),_panelheight);
RDebugUtils.currentLine=1376397;
 //BA.debugLineNum = 1376397;BA.debugLine="PanelTop = PanelTop+PanelHeight+Gap";
_paneltop = (int) (_paneltop+_panelheight+_gap);
RDebugUtils.currentLine=1376398;
 //BA.debugLineNum = 1376398;BA.debugLine="PanelHeight = 110dip";
_panelheight = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (110));
 }
;
RDebugUtils.currentLine=1376400;
 //BA.debugLineNum = 1376400;BA.debugLine="Container.Height = PanelTop";
_container.setHeight(_paneltop);
RDebugUtils.currentLine=1376401;
 //BA.debugLineNum = 1376401;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="test";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_pause"))
	return (String) Debug.delegate(mostCurrent.activityBA, "activity_pause", new Object[] {_userclosed});
RDebugUtils.currentLine=1507328;
 //BA.debugLineNum = 1507328;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=1507330;
 //BA.debugLineNum = 1507330;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="test";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume"))
	return (String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null);
RDebugUtils.currentLine=1441792;
 //BA.debugLineNum = 1441792;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=1441794;
 //BA.debugLineNum = 1441794;BA.debugLine="End Sub";
return "";
}
public static String  _drawborder(anywheresoftware.b4a.objects.ConcreteViewWrapper _target,int _acolor,int _strokewidth) throws Exception{
RDebugUtils.currentModule="test";
if (Debug.shouldDelegate(mostCurrent.activityBA, "drawborder"))
	return (String) Debug.delegate(mostCurrent.activityBA, "drawborder", new Object[] {_target,_acolor,_strokewidth});
anywheresoftware.b4a.objects.drawable.CanvasWrapper _c = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper _r = null;
RDebugUtils.currentLine=1638400;
 //BA.debugLineNum = 1638400;BA.debugLine="Public Sub DrawBorder(Target As View, aColor As In";
RDebugUtils.currentLine=1638401;
 //BA.debugLineNum = 1638401;BA.debugLine="Dim c As Canvas";
_c = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();
RDebugUtils.currentLine=1638402;
 //BA.debugLineNum = 1638402;BA.debugLine="c.Initialize(Target)";
_c.Initialize((android.view.View)(_target.getObject()));
RDebugUtils.currentLine=1638403;
 //BA.debugLineNum = 1638403;BA.debugLine="Dim r As Rect : r.Initialize(0, 0, Target.Width";
_r = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper();
RDebugUtils.currentLine=1638403;
 //BA.debugLineNum = 1638403;BA.debugLine="Dim r As Rect : r.Initialize(0, 0, Target.Width";
_r.Initialize((int) (0),(int) (0),_target.getWidth(),_target.getHeight());
RDebugUtils.currentLine=1638404;
 //BA.debugLineNum = 1638404;BA.debugLine="c.DrawRect(r, aColor, False, StrokeWidth)";
_c.DrawRect((android.graphics.Rect)(_r.getObject()),_acolor,anywheresoftware.b4a.keywords.Common.False,(float) (_strokewidth));
RDebugUtils.currentLine=1638405;
 //BA.debugLineNum = 1638405;BA.debugLine="Target.Invalidate";
_target.Invalidate();
RDebugUtils.currentLine=1638406;
 //BA.debugLineNum = 1638406;BA.debugLine="End Sub";
return "";
}
}