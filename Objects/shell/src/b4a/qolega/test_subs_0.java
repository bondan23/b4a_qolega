package b4a.qolega;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class test_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (test) ","test",3,test.mostCurrent.activityBA,test.mostCurrent,20);
if (RapidSub.canDelegate("activity_create")) return test.remoteMe.runUserSub(false, "test","activity_create", _firsttime);
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 20;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(524288);
 BA.debugLineNum = 23;BA.debugLine="Activity.AddMenuItem3(\"SearchItem\", \"SearchItem\",";
Debug.ShouldStop(4194304);
test.mostCurrent._activity.runVoidMethod ("AddMenuItem3",(Object)(BA.ObjectToString("SearchItem")),(Object)(BA.ObjectToString("SearchItem")),(Object)((test.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(test.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("search.png"))).getObject())),(Object)(test.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 24;BA.debugLine="scrollView.Initialize(Activity.Height)";
Debug.ShouldStop(8388608);
test.mostCurrent._scrollview.runVoidMethod ("Initialize",test.mostCurrent.activityBA,(Object)(test.mostCurrent._activity.runMethod(true,"getHeight")));
 BA.debugLineNum = 25;BA.debugLine="scrollView.Color = Colors.RGB(219,219,219)";
Debug.ShouldStop(16777216);
test.mostCurrent._scrollview.runVoidMethod ("setColor",test.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 219)),(Object)(BA.numberCast(int.class, 219)),(Object)(BA.numberCast(int.class, 219))));
 BA.debugLineNum = 26;BA.debugLine="Activity.AddView(scrollView,0,0,100%x,100%y)";
Debug.ShouldStop(33554432);
test.mostCurrent._activity.runVoidMethod ("AddView",(Object)((test.mostCurrent._scrollview.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(test.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),test.mostCurrent.activityBA)),(Object)(test.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),test.mostCurrent.activityBA)));
 BA.debugLineNum = 27;BA.debugLine="LoopPanel";
Debug.ShouldStop(67108864);
_looppanel();
 BA.debugLineNum = 28;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (test) ","test",3,test.mostCurrent.activityBA,test.mostCurrent,183);
if (RapidSub.canDelegate("activity_pause")) return test.remoteMe.runUserSub(false, "test","activity_pause", _userclosed);
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 183;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 185;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (test) ","test",3,test.mostCurrent.activityBA,test.mostCurrent,179);
if (RapidSub.canDelegate("activity_resume")) return test.remoteMe.runUserSub(false, "test","activity_resume");
 BA.debugLineNum = 179;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(262144);
 BA.debugLineNum = 181;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _drawborder(RemoteObject _target,RemoteObject _acolor,RemoteObject _strokewidth) throws Exception{
try {
		Debug.PushSubsStack("DrawBorder (test) ","test",3,test.mostCurrent.activityBA,test.mostCurrent,187);
if (RapidSub.canDelegate("drawborder")) return test.remoteMe.runUserSub(false, "test","drawborder", _target, _acolor, _strokewidth);
RemoteObject _c = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper");
RemoteObject _r = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper");
Debug.locals.put("Target", _target);
Debug.locals.put("aColor", _acolor);
Debug.locals.put("StrokeWidth", _strokewidth);
 BA.debugLineNum = 187;BA.debugLine="Public Sub DrawBorder(Target As View, aColor As In";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 188;BA.debugLine="Dim c As Canvas";
Debug.ShouldStop(134217728);
_c = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper");Debug.locals.put("c", _c);
 BA.debugLineNum = 189;BA.debugLine="c.Initialize(Target)";
Debug.ShouldStop(268435456);
_c.runVoidMethod ("Initialize",(Object)((_target.getObject())));
 BA.debugLineNum = 190;BA.debugLine="Dim r As Rect : r.Initialize(0, 0, Target.Width";
Debug.ShouldStop(536870912);
_r = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper");Debug.locals.put("r", _r);
 BA.debugLineNum = 190;BA.debugLine="Dim r As Rect : r.Initialize(0, 0, Target.Width";
Debug.ShouldStop(536870912);
_r.runVoidMethod ("Initialize",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(_target.runMethod(true,"getWidth")),(Object)(_target.runMethod(true,"getHeight")));
 BA.debugLineNum = 191;BA.debugLine="c.DrawRect(r, aColor, False, StrokeWidth)";
Debug.ShouldStop(1073741824);
_c.runVoidMethod ("DrawRect",(Object)((_r.getObject())),(Object)(_acolor),(Object)(test.mostCurrent.__c.getField(true,"False")),(Object)(BA.numberCast(float.class, _strokewidth)));
 BA.debugLineNum = 192;BA.debugLine="Target.Invalidate";
Debug.ShouldStop(-2147483648);
_target.runVoidMethod ("Invalidate");
 BA.debugLineNum = 193;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 15;BA.debugLine="Dim scrollView As ScrollView";
test.mostCurrent._scrollview = RemoteObject.createNew ("anywheresoftware.b4a.objects.ScrollViewWrapper");
 //BA.debugLineNum = 16;BA.debugLine="Dim JSON As JSONParser";
test.mostCurrent._json = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");
 //BA.debugLineNum = 17;BA.debugLine="Dim su As StringUtils";
test.mostCurrent._su = RemoteObject.createNew ("anywheresoftware.b4a.objects.StringUtils");
 //BA.debugLineNum = 18;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _looppanel() throws Exception{
try {
		Debug.PushSubsStack("LoopPanel (test) ","test",3,test.mostCurrent.activityBA,test.mostCurrent,31);
if (RapidSub.canDelegate("looppanel")) return test.remoteMe.runUserSub(false, "test","looppanel");
RemoteObject _bitmap1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
RemoteObject _container = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _joblistpanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _referencepanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _paneltop = RemoteObject.createImmutable(0);
RemoteObject _panelheight = RemoteObject.createImmutable(0);
RemoteObject _referencetop = RemoteObject.createImmutable(0);
RemoteObject _referenceheight = RemoteObject.createImmutable(0);
RemoteObject _gap = RemoteObject.createImmutable(0);
RemoteObject _textheight = RemoteObject.createImmutable(0);
RemoteObject _jobtitle = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _location = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _jobdesc = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _currency = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _commision = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _root = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _colroot = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _reference = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _job_title = RemoteObject.createImmutable("");
RemoteObject _job_location = RemoteObject.createImmutable("");
RemoteObject _job_desc = RemoteObject.createImmutable("");
RemoteObject _job_commision = RemoteObject.createImmutable(0);
RemoteObject _sizeofref = RemoteObject.createImmutable(0);
RemoteObject _colreference = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _refname = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _refcompany = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _refstatus = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _statusref = RemoteObject.createImmutable("");
RemoteObject _rheight = RemoteObject.createImmutable(0);
RemoteObject _statusrefcolor = RemoteObject.createImmutable(0);
RemoteObject _detailbtn = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
RemoteObject _rname = RemoteObject.createImmutable("");
RemoteObject _rcompany = RemoteObject.createImmutable("");
RemoteObject _rstatus = RemoteObject.createImmutable("");
 BA.debugLineNum = 31;BA.debugLine="Sub LoopPanel";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 32;BA.debugLine="Dim Bitmap1 As Bitmap";
Debug.ShouldStop(-2147483648);
_bitmap1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");Debug.locals.put("Bitmap1", _bitmap1);
 BA.debugLineNum = 33;BA.debugLine="Dim Container As Panel";
Debug.ShouldStop(1);
_container = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("Container", _container);
 BA.debugLineNum = 34;BA.debugLine="Dim JoblistPanel,ReferencePanel As Panel";
Debug.ShouldStop(2);
_joblistpanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("JoblistPanel", _joblistpanel);
_referencepanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("ReferencePanel", _referencepanel);
 BA.debugLineNum = 35;BA.debugLine="Dim PanelTop,PanelHeight,ReferenceTop,ReferenceHe";
Debug.ShouldStop(4);
_paneltop = RemoteObject.createImmutable(0);Debug.locals.put("PanelTop", _paneltop);
_panelheight = RemoteObject.createImmutable(0);Debug.locals.put("PanelHeight", _panelheight);
_referencetop = RemoteObject.createImmutable(0);Debug.locals.put("ReferenceTop", _referencetop);
_referenceheight = RemoteObject.createImmutable(0);Debug.locals.put("ReferenceHeight", _referenceheight);
_gap = RemoteObject.createImmutable(0);Debug.locals.put("Gap", _gap);
_textheight = RemoteObject.createImmutable(0);Debug.locals.put("TextHeight", _textheight);
 BA.debugLineNum = 36;BA.debugLine="Dim JobTitle,Location,JobDesc,Currency,Commision";
Debug.ShouldStop(8);
_jobtitle = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("JobTitle", _jobtitle);
_location = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("Location", _location);
_jobdesc = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("JobDesc", _jobdesc);
_currency = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("Currency", _currency);
_commision = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("Commision", _commision);
 BA.debugLineNum = 39;BA.debugLine="PanelTop = 10dip";
Debug.ShouldStop(64);
_paneltop = test.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)));Debug.locals.put("PanelTop", _paneltop);
 BA.debugLineNum = 41;BA.debugLine="PanelHeight = 110dip";
Debug.ShouldStop(256);
_panelheight = test.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 110)));Debug.locals.put("PanelHeight", _panelheight);
 BA.debugLineNum = 43;BA.debugLine="Gap = 10dip";
Debug.ShouldStop(1024);
_gap = test.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)));Debug.locals.put("Gap", _gap);
 BA.debugLineNum = 46;BA.debugLine="Container = scrollView.Panel";
Debug.ShouldStop(8192);
_container = test.mostCurrent._scrollview.runMethod(false,"getPanel");Debug.locals.put("Container", _container);
 BA.debugLineNum = 47;BA.debugLine="Container.Color = Colors.RGB(219,219,219)";
Debug.ShouldStop(16384);
_container.runVoidMethod ("setColor",test.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 219)),(Object)(BA.numberCast(int.class, 219)),(Object)(BA.numberCast(int.class, 219))));
 BA.debugLineNum = 50;BA.debugLine="JSON.Initialize(File.ReadString(File.DirAssets";
Debug.ShouldStop(131072);
test.mostCurrent._json.runVoidMethod ("Initialize",(Object)(test.mostCurrent.__c.getField(false,"File").runMethod(true,"ReadString",(Object)(test.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("list.json")))));
 BA.debugLineNum = 51;BA.debugLine="Dim root As List = JSON.NextArray";
Debug.ShouldStop(262144);
_root = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_root = test.mostCurrent._json.runMethod(false,"NextArray");Debug.locals.put("root", _root);Debug.locals.put("root", _root);
 BA.debugLineNum = 52;BA.debugLine="For Each colroot As Map In root";
Debug.ShouldStop(524288);
_colroot = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
final RemoteObject group13 = _root;
final int groupLen13 = group13.runMethod(true,"getSize").<Integer>get();
for (int index13 = 0;index13 < groupLen13 ;index13++){
_colroot.setObject(group13.runMethod(false,"Get",index13));
Debug.locals.put("colroot", _colroot);
 BA.debugLineNum = 54;BA.debugLine="Dim reference As List = colroot.Get(\"reference\")";
Debug.ShouldStop(2097152);
_reference = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_reference.setObject(_colroot.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("reference")))));Debug.locals.put("reference", _reference);
 BA.debugLineNum = 55;BA.debugLine="Dim job_title As String = colroot.Get(\"jobtitle\"";
Debug.ShouldStop(4194304);
_job_title = BA.ObjectToString(_colroot.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("jobtitle")))));Debug.locals.put("job_title", _job_title);Debug.locals.put("job_title", _job_title);
 BA.debugLineNum = 56;BA.debugLine="Dim job_location As String = colroot.Get(\"locati";
Debug.ShouldStop(8388608);
_job_location = BA.ObjectToString(_colroot.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("location")))));Debug.locals.put("job_location", _job_location);Debug.locals.put("job_location", _job_location);
 BA.debugLineNum = 57;BA.debugLine="Dim job_desc As String = colroot.Get(\"jobdesc\")";
Debug.ShouldStop(16777216);
_job_desc = BA.ObjectToString(_colroot.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("jobdesc")))));Debug.locals.put("job_desc", _job_desc);Debug.locals.put("job_desc", _job_desc);
 BA.debugLineNum = 58;BA.debugLine="Dim job_commision As Double = colroot.Get(\"commi";
Debug.ShouldStop(33554432);
_job_commision = BA.numberCast(double.class, _colroot.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("commision")))));Debug.locals.put("job_commision", _job_commision);Debug.locals.put("job_commision", _job_commision);
 BA.debugLineNum = 61;BA.debugLine="JoblistPanel.Initialize(\"\")";
Debug.ShouldStop(268435456);
_joblistpanel.runVoidMethod ("Initialize",test.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 62;BA.debugLine="JobTitle.Initialize(\"JobTitle\")";
Debug.ShouldStop(536870912);
_jobtitle.runVoidMethod ("Initialize",test.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("JobTitle")));
 BA.debugLineNum = 63;BA.debugLine="Location.Initialize(\"Location\")";
Debug.ShouldStop(1073741824);
_location.runVoidMethod ("Initialize",test.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("Location")));
 BA.debugLineNum = 64;BA.debugLine="JobDesc.Initialize(\"JobDesc\")";
Debug.ShouldStop(-2147483648);
_jobdesc.runVoidMethod ("Initialize",test.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("JobDesc")));
 BA.debugLineNum = 65;BA.debugLine="Currency.Initialize(\"Currency\")";
Debug.ShouldStop(1);
_currency.runVoidMethod ("Initialize",test.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("Currency")));
 BA.debugLineNum = 66;BA.debugLine="Commision.Initialize(\"Commision\")";
Debug.ShouldStop(2);
_commision.runVoidMethod ("Initialize",test.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("Commision")));
 BA.debugLineNum = 69;BA.debugLine="JobTitle.Text = job_title";
Debug.ShouldStop(16);
_jobtitle.runMethod(true,"setText",(_job_title));
 BA.debugLineNum = 70;BA.debugLine="Location.Text = job_location";
Debug.ShouldStop(32);
_location.runMethod(true,"setText",(_job_location));
 BA.debugLineNum = 71;BA.debugLine="Location.TextColor = Colors.RGB(179,179,179)";
Debug.ShouldStop(64);
_location.runMethod(true,"setTextColor",test.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 179)),(Object)(BA.numberCast(int.class, 179)),(Object)(BA.numberCast(int.class, 179))));
 BA.debugLineNum = 72;BA.debugLine="JobDesc.Text = job_desc";
Debug.ShouldStop(128);
_jobdesc.runMethod(true,"setText",(_job_desc));
 BA.debugLineNum = 73;BA.debugLine="JobDesc.TextColor = Colors.RGB(179,179,179)";
Debug.ShouldStop(256);
_jobdesc.runMethod(true,"setTextColor",test.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 179)),(Object)(BA.numberCast(int.class, 179)),(Object)(BA.numberCast(int.class, 179))));
 BA.debugLineNum = 74;BA.debugLine="Currency.Text = \"IDR \"&NumberFormat(job_commisio";
Debug.ShouldStop(512);
_currency.runMethod(true,"setText",(RemoteObject.concat(RemoteObject.createImmutable("IDR "),test.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(_job_commision),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 2))))));
 BA.debugLineNum = 75;BA.debugLine="Currency.Typeface = Typeface.DEFAULT_BOLD";
Debug.ShouldStop(1024);
_currency.runMethod(false,"setTypeface",test.mostCurrent.__c.getField(false,"Typeface").getField(false,"DEFAULT_BOLD"));
 BA.debugLineNum = 76;BA.debugLine="Currency.TextColor = Colors.RGB(74,74,74)";
Debug.ShouldStop(2048);
_currency.runMethod(true,"setTextColor",test.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 74)),(Object)(BA.numberCast(int.class, 74)),(Object)(BA.numberCast(int.class, 74))));
 BA.debugLineNum = 77;BA.debugLine="Commision.Text = \"Commision\"";
Debug.ShouldStop(4096);
_commision.runMethod(true,"setText",RemoteObject.createImmutable(("Commision")));
 BA.debugLineNum = 78;BA.debugLine="Commision.TextColor = Colors.RGB(179,179,179)";
Debug.ShouldStop(8192);
_commision.runMethod(true,"setTextColor",test.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 179)),(Object)(BA.numberCast(int.class, 179)),(Object)(BA.numberCast(int.class, 179))));
 BA.debugLineNum = 81;BA.debugLine="JoblistPanel.AddView(JobTitle,10dip,10dip,100%x,";
Debug.ShouldStop(65536);
_joblistpanel.runVoidMethod ("AddView",(Object)((_jobtitle.getObject())),(Object)(test.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(test.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(test.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),test.mostCurrent.activityBA)),(Object)(test.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))));
 BA.debugLineNum = 82;BA.debugLine="TextHeight = su.MeasureMultilineTextHeight(JobTi";
Debug.ShouldStop(131072);
_textheight = test.mostCurrent._su.runMethod(true,"MeasureMultilineTextHeight",(Object)((_jobtitle.getObject())),(Object)(_jobtitle.runMethod(true,"getText")));Debug.locals.put("TextHeight", _textheight);
 BA.debugLineNum = 84;BA.debugLine="JoblistPanel.AddView(Location,10dip,TextHeight+G";
Debug.ShouldStop(524288);
_joblistpanel.runVoidMethod ("AddView",(Object)((_location.getObject())),(Object)(test.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(RemoteObject.solve(new RemoteObject[] {_textheight,_gap}, "+",1, 1)),(Object)(test.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),test.mostCurrent.activityBA)),(Object)(test.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))));
 BA.debugLineNum = 85;BA.debugLine="TextHeight = TextHeight + su.MeasureMultilineTex";
Debug.ShouldStop(1048576);
_textheight = RemoteObject.solve(new RemoteObject[] {_textheight,test.mostCurrent._su.runMethod(true,"MeasureMultilineTextHeight",(Object)((_location.getObject())),(Object)(_location.runMethod(true,"getText")))}, "+",1, 1);Debug.locals.put("TextHeight", _textheight);
 BA.debugLineNum = 87;BA.debugLine="JoblistPanel.AddView(JobDesc,10dip,TextHeight+Ga";
Debug.ShouldStop(4194304);
_joblistpanel.runVoidMethod ("AddView",(Object)((_jobdesc.getObject())),(Object)(test.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(RemoteObject.solve(new RemoteObject[] {_textheight,_gap}, "+",1, 1)),(Object)(test.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),test.mostCurrent.activityBA)),(Object)(test.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))));
 BA.debugLineNum = 88;BA.debugLine="TextHeight = TextHeight + su.MeasureMultilineTex";
Debug.ShouldStop(8388608);
_textheight = RemoteObject.solve(new RemoteObject[] {_textheight,test.mostCurrent._su.runMethod(true,"MeasureMultilineTextHeight",(Object)((_jobdesc.getObject())),(Object)(_jobdesc.runMethod(true,"getText")))}, "+",1, 1);Debug.locals.put("TextHeight", _textheight);
 BA.debugLineNum = 90;BA.debugLine="JoblistPanel.AddView(Currency,10dip,TextHeight+G";
Debug.ShouldStop(33554432);
_joblistpanel.runVoidMethod ("AddView",(Object)((_currency.getObject())),(Object)(test.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(RemoteObject.solve(new RemoteObject[] {_textheight,_gap}, "+",1, 1)),(Object)(test.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),test.mostCurrent.activityBA)),(Object)(test.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))));
 BA.debugLineNum = 91;BA.debugLine="JoblistPanel.AddView(Commision,110dip,TextHeight";
Debug.ShouldStop(67108864);
_joblistpanel.runVoidMethod ("AddView",(Object)((_commision.getObject())),(Object)(test.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 110)))),(Object)(RemoteObject.solve(new RemoteObject[] {_textheight,_gap}, "+",1, 1)),(Object)(test.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),test.mostCurrent.activityBA)),(Object)(test.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))));
 BA.debugLineNum = 92;BA.debugLine="TextHeight = TextHeight + su.MeasureMultilineTex";
Debug.ShouldStop(134217728);
_textheight = RemoteObject.solve(new RemoteObject[] {_textheight,test.mostCurrent._su.runMethod(true,"MeasureMultilineTextHeight",(Object)((_currency.getObject())),(Object)(_jobdesc.runMethod(true,"getText")))}, "+",1, 1);Debug.locals.put("TextHeight", _textheight);
 BA.debugLineNum = 94;BA.debugLine="JoblistPanel.Color=Colors.RGB(255,255,255)";
Debug.ShouldStop(536870912);
_joblistpanel.runVoidMethod ("setColor",test.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 255))));
 BA.debugLineNum = 97;BA.debugLine="ReferenceTop = TextHeight+Gap*2";
Debug.ShouldStop(1);
_referencetop = RemoteObject.solve(new RemoteObject[] {_textheight,_gap,RemoteObject.createImmutable(2)}, "+*",1, 1);Debug.locals.put("ReferenceTop", _referencetop);
 BA.debugLineNum = 99;BA.debugLine="ReferenceHeight = 89dip";
Debug.ShouldStop(4);
_referenceheight = test.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 89)));Debug.locals.put("ReferenceHeight", _referenceheight);
 BA.debugLineNum = 102;BA.debugLine="Dim SizeOfRef As Int = reference.Size";
Debug.ShouldStop(32);
_sizeofref = _reference.runMethod(true,"getSize");Debug.locals.put("SizeOfRef", _sizeofref);Debug.locals.put("SizeOfRef", _sizeofref);
 BA.debugLineNum = 106;BA.debugLine="PanelHeight = PanelHeight+(ReferenceHeight*SizeO";
Debug.ShouldStop(512);
_panelheight = RemoteObject.solve(new RemoteObject[] {_panelheight,(RemoteObject.solve(new RemoteObject[] {_referenceheight,_sizeofref}, "*",0, 1)),(RemoteObject.solve(new RemoteObject[] {_gap,_sizeofref}, "*",0, 1))}, "++",2, 1);Debug.locals.put("PanelHeight", _panelheight);
 BA.debugLineNum = 108;BA.debugLine="For Each colreference As Map In reference";
Debug.ShouldStop(2048);
_colreference = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
final RemoteObject group49 = _reference;
final int groupLen49 = group49.runMethod(true,"getSize").<Integer>get();
for (int index49 = 0;index49 < groupLen49 ;index49++){
_colreference.setObject(group49.runMethod(false,"Get",index49));
Debug.locals.put("colreference", _colreference);
 BA.debugLineNum = 109;BA.debugLine="Dim refName,refCompany,refStatus As Label";
Debug.ShouldStop(4096);
_refname = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("refName", _refname);
_refcompany = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("refCompany", _refcompany);
_refstatus = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("refStatus", _refstatus);
 BA.debugLineNum = 110;BA.debugLine="Dim statusRef As String";
Debug.ShouldStop(8192);
_statusref = RemoteObject.createImmutable("");Debug.locals.put("statusRef", _statusref);
 BA.debugLineNum = 111;BA.debugLine="Dim rHeight,statusRefColor As Int";
Debug.ShouldStop(16384);
_rheight = RemoteObject.createImmutable(0);Debug.locals.put("rHeight", _rheight);
_statusrefcolor = RemoteObject.createImmutable(0);Debug.locals.put("statusRefColor", _statusrefcolor);
 BA.debugLineNum = 112;BA.debugLine="Dim detailBtn As Button";
Debug.ShouldStop(32768);
_detailbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");Debug.locals.put("detailBtn", _detailbtn);
 BA.debugLineNum = 115;BA.debugLine="Dim rName As String = colreference.Get(\"name\")";
Debug.ShouldStop(262144);
_rname = BA.ObjectToString(_colreference.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("name")))));Debug.locals.put("rName", _rname);Debug.locals.put("rName", _rname);
 BA.debugLineNum = 116;BA.debugLine="Dim rCompany As String = colreference.Get(\"comp";
Debug.ShouldStop(524288);
_rcompany = BA.ObjectToString(_colreference.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("company")))));Debug.locals.put("rCompany", _rcompany);Debug.locals.put("rCompany", _rcompany);
 BA.debugLineNum = 117;BA.debugLine="Dim rStatus As String = colreference.Get(\"statu";
Debug.ShouldStop(1048576);
_rstatus = BA.ObjectToString(_colreference.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("status")))));Debug.locals.put("rStatus", _rstatus);Debug.locals.put("rStatus", _rstatus);
 BA.debugLineNum = 120;BA.debugLine="ReferencePanel.Initialize(\"\")";
Debug.ShouldStop(8388608);
_referencepanel.runVoidMethod ("Initialize",test.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 121;BA.debugLine="ReferencePanel.Color = Colors.White";
Debug.ShouldStop(16777216);
_referencepanel.runVoidMethod ("setColor",test.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 122;BA.debugLine="JoblistPanel.AddView(ReferencePanel,40,Referenc";
Debug.ShouldStop(33554432);
_joblistpanel.runVoidMethod ("AddView",(Object)((_referencepanel.getObject())),(Object)(BA.numberCast(int.class, 40)),(Object)(_referencetop),(Object)(RemoteObject.solve(new RemoteObject[] {test.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 90)),test.mostCurrent.activityBA),RemoteObject.createImmutable(10)}, "-",1, 1)),(Object)(_referenceheight));
 BA.debugLineNum = 123;BA.debugLine="DrawBorder(ReferencePanel,Colors.RGB(219,219,21";
Debug.ShouldStop(67108864);
_drawborder(RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), _referencepanel.getObject()),test.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 219)),(Object)(BA.numberCast(int.class, 219)),(Object)(BA.numberCast(int.class, 219))),BA.numberCast(int.class, 4));
 BA.debugLineNum = 126;BA.debugLine="refName.Initialize(\"\")";
Debug.ShouldStop(536870912);
_refname.runVoidMethod ("Initialize",test.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 127;BA.debugLine="refName.Text = rName";
Debug.ShouldStop(1073741824);
_refname.runMethod(true,"setText",(_rname));
 BA.debugLineNum = 128;BA.debugLine="refName.TextColor = Colors.RGB(74,74,74)";
Debug.ShouldStop(-2147483648);
_refname.runMethod(true,"setTextColor",test.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 74)),(Object)(BA.numberCast(int.class, 74)),(Object)(BA.numberCast(int.class, 74))));
 BA.debugLineNum = 129;BA.debugLine="refName.Typeface = Typeface.DEFAULT_BOLD";
Debug.ShouldStop(1);
_refname.runMethod(false,"setTypeface",test.mostCurrent.__c.getField(false,"Typeface").getField(false,"DEFAULT_BOLD"));
 BA.debugLineNum = 130;BA.debugLine="ReferencePanel.AddView(refName,10,10,ReferenceP";
Debug.ShouldStop(2);
_referencepanel.runVoidMethod ("AddView",(Object)((_refname.getObject())),(Object)(BA.numberCast(int.class, 10)),(Object)(BA.numberCast(int.class, 10)),(Object)(RemoteObject.solve(new RemoteObject[] {_referencepanel.runMethod(true,"getWidth"),_gap}, "-",1, 1)),(Object)(BA.numberCast(int.class, 50)));
 BA.debugLineNum = 131;BA.debugLine="rHeight = su.MeasureMultilineTextHeight(refName";
Debug.ShouldStop(4);
_rheight = test.mostCurrent._su.runMethod(true,"MeasureMultilineTextHeight",(Object)((_refname.getObject())),(Object)(_refname.runMethod(true,"getText")));Debug.locals.put("rHeight", _rheight);
 BA.debugLineNum = 134;BA.debugLine="refCompany.Initialize(\"\")";
Debug.ShouldStop(32);
_refcompany.runVoidMethod ("Initialize",test.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 135;BA.debugLine="refCompany.Text = rCompany";
Debug.ShouldStop(64);
_refcompany.runMethod(true,"setText",(_rcompany));
 BA.debugLineNum = 136;BA.debugLine="refCompany.TextColor = Colors.RGB(219,219,219)";
Debug.ShouldStop(128);
_refcompany.runMethod(true,"setTextColor",test.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 219)),(Object)(BA.numberCast(int.class, 219)),(Object)(BA.numberCast(int.class, 219))));
 BA.debugLineNum = 137;BA.debugLine="ReferencePanel.AddView(refCompany,10,rHeight+Ga";
Debug.ShouldStop(256);
_referencepanel.runVoidMethod ("AddView",(Object)((_refcompany.getObject())),(Object)(BA.numberCast(int.class, 10)),(Object)(RemoteObject.solve(new RemoteObject[] {_rheight,_gap}, "+",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {_referencepanel.runMethod(true,"getWidth"),_gap}, "-",1, 1)),(Object)(BA.numberCast(int.class, 50)));
 BA.debugLineNum = 138;BA.debugLine="rHeight = rHeight + su.MeasureMultilineTextHeig";
Debug.ShouldStop(512);
_rheight = RemoteObject.solve(new RemoteObject[] {_rheight,test.mostCurrent._su.runMethod(true,"MeasureMultilineTextHeight",(Object)((_refcompany.getObject())),(Object)(_refcompany.runMethod(true,"getText")))}, "+",1, 1);Debug.locals.put("rHeight", _rheight);
 BA.debugLineNum = 141;BA.debugLine="Select rStatus";
Debug.ShouldStop(4096);
switch (BA.switchObjectToInt(_rstatus,BA.NumberToString(0),BA.NumberToString(1))) {
case 0: {
 BA.debugLineNum = 143;BA.debugLine="statusRef = \"Qualifying\"";
Debug.ShouldStop(16384);
_statusref = BA.ObjectToString("Qualifying");Debug.locals.put("statusRef", _statusref);
 BA.debugLineNum = 144;BA.debugLine="statusRefColor = Colors.RGB(249,191,55)";
Debug.ShouldStop(32768);
_statusrefcolor = test.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 249)),(Object)(BA.numberCast(int.class, 191)),(Object)(BA.numberCast(int.class, 55)));Debug.locals.put("statusRefColor", _statusrefcolor);
 break; }
case 1: {
 BA.debugLineNum = 146;BA.debugLine="statusRef = \"1st Interview\"";
Debug.ShouldStop(131072);
_statusref = BA.ObjectToString("1st Interview");Debug.locals.put("statusRef", _statusref);
 BA.debugLineNum = 147;BA.debugLine="statusRefColor = Colors.RGB(102,195,67)";
Debug.ShouldStop(262144);
_statusrefcolor = test.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 102)),(Object)(BA.numberCast(int.class, 195)),(Object)(BA.numberCast(int.class, 67)));Debug.locals.put("statusRefColor", _statusrefcolor);
 break; }
default: {
 BA.debugLineNum = 149;BA.debugLine="statusRef = \"Completed\"";
Debug.ShouldStop(1048576);
_statusref = BA.ObjectToString("Completed");Debug.locals.put("statusRef", _statusref);
 BA.debugLineNum = 150;BA.debugLine="statusRefColor = Colors.RGB(22,176,221)";
Debug.ShouldStop(2097152);
_statusrefcolor = test.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 22)),(Object)(BA.numberCast(int.class, 176)),(Object)(BA.numberCast(int.class, 221)));Debug.locals.put("statusRefColor", _statusrefcolor);
 break; }
}
;
 BA.debugLineNum = 153;BA.debugLine="refStatus.Initialize(\"\")";
Debug.ShouldStop(16777216);
_refstatus.runVoidMethod ("Initialize",test.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 154;BA.debugLine="refStatus.Text = statusRef";
Debug.ShouldStop(33554432);
_refstatus.runMethod(true,"setText",(_statusref));
 BA.debugLineNum = 155;BA.debugLine="refStatus.TextColor = Colors.White";
Debug.ShouldStop(67108864);
_refstatus.runMethod(true,"setTextColor",test.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 156;BA.debugLine="refStatus.Color = statusRefColor";
Debug.ShouldStop(134217728);
_refstatus.runVoidMethod ("setColor",_statusrefcolor);
 BA.debugLineNum = 157;BA.debugLine="refStatus.Gravity = Gravity.CENTER";
Debug.ShouldStop(268435456);
_refstatus.runMethod(true,"setGravity",test.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 158;BA.debugLine="ReferencePanel.AddView(refStatus,10,rHeight+Gap";
Debug.ShouldStop(536870912);
_referencepanel.runVoidMethod ("AddView",(Object)((_refstatus.getObject())),(Object)(BA.numberCast(int.class, 10)),(Object)(RemoteObject.solve(new RemoteObject[] {_rheight,_gap,RemoteObject.createImmutable(10)}, "++",2, 1)),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_referencepanel.runMethod(true,"getWidth"),_gap}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0))),(Object)(BA.numberCast(int.class, 50)));
 BA.debugLineNum = 161;BA.debugLine="detailBtn.Initialize(\"detailBtn\")";
Debug.ShouldStop(1);
_detailbtn.runVoidMethod ("Initialize",test.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("detailBtn")));
 BA.debugLineNum = 162;BA.debugLine="detailBtn.Text = \"Detail Progress\"";
Debug.ShouldStop(2);
_detailbtn.runMethod(true,"setText",RemoteObject.createImmutable(("Detail Progress")));
 BA.debugLineNum = 163;BA.debugLine="detailBtn.Gravity = Gravity.CENTER";
Debug.ShouldStop(4);
_detailbtn.runMethod(true,"setGravity",test.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 164;BA.debugLine="detailBtn.TextSize = 10";
Debug.ShouldStop(8);
_detailbtn.runMethod(true,"setTextSize",BA.numberCast(float.class, 10));
 BA.debugLineNum = 165;BA.debugLine="ReferencePanel.AddView(detailBtn,((ReferencePan";
Debug.ShouldStop(16);
_referencepanel.runVoidMethod ("AddView",(Object)((_detailbtn.getObject())),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_referencepanel.runMethod(true,"getWidth"),_gap}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)),RemoteObject.createImmutable(10)}, "+",1, 0))),(Object)(RemoteObject.solve(new RemoteObject[] {_rheight,_gap}, "+",1, 1)),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_referencepanel.runMethod(true,"getWidth"),_gap}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0))),(Object)(BA.numberCast(int.class, 65)));
 BA.debugLineNum = 168;BA.debugLine="ReferenceTop = ReferenceTop+ReferenceHeight+Gap";
Debug.ShouldStop(128);
_referencetop = RemoteObject.solve(new RemoteObject[] {_referencetop,_referenceheight,_gap}, "++",2, 1);Debug.locals.put("ReferenceTop", _referencetop);
 }
Debug.locals.put("colreference", _colreference);
;
 BA.debugLineNum = 171;BA.debugLine="Container.AddView(JoblistPanel,0,PanelTop,Contai";
Debug.ShouldStop(1024);
_container.runVoidMethod ("AddView",(Object)((_joblistpanel.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(_paneltop),(Object)(_container.runMethod(true,"getWidth")),(Object)(_panelheight));
 BA.debugLineNum = 172;BA.debugLine="PanelTop = PanelTop+PanelHeight+Gap";
Debug.ShouldStop(2048);
_paneltop = RemoteObject.solve(new RemoteObject[] {_paneltop,_panelheight,_gap}, "++",2, 1);Debug.locals.put("PanelTop", _paneltop);
 BA.debugLineNum = 173;BA.debugLine="PanelHeight = 110dip";
Debug.ShouldStop(4096);
_panelheight = test.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 110)));Debug.locals.put("PanelHeight", _panelheight);
 }
Debug.locals.put("colroot", _colroot);
;
 BA.debugLineNum = 175;BA.debugLine="Container.Height = PanelTop";
Debug.ShouldStop(16384);
_container.runMethod(true,"setHeight",_paneltop);
 BA.debugLineNum = 176;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}