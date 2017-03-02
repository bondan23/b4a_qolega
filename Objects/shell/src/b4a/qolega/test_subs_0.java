package b4a.qolega;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class test_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (test) ","test",3,test.mostCurrent.activityBA,test.mostCurrent,19);
if (RapidSub.canDelegate("activity_create")) return test.remoteMe.runUserSub(false, "test","activity_create", _firsttime);
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 19;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(262144);
 BA.debugLineNum = 22;BA.debugLine="Activity.AddMenuItem3(\"SearchItem\", \"SearchItem\",";
Debug.ShouldStop(2097152);
test.mostCurrent._activity.runVoidMethod ("AddMenuItem3",(Object)(BA.ObjectToString("SearchItem")),(Object)(BA.ObjectToString("SearchItem")),(Object)((test.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(test.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("search.png"))).getObject())),(Object)(test.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 23;BA.debugLine="scrollView.Initialize(Activity.Height)";
Debug.ShouldStop(4194304);
test.mostCurrent._scrollview.runVoidMethod ("Initialize",test.mostCurrent.activityBA,(Object)(test.mostCurrent._activity.runMethod(true,"getHeight")));
 BA.debugLineNum = 24;BA.debugLine="Activity.AddView(scrollView,0,0,100%x,100%y)";
Debug.ShouldStop(8388608);
test.mostCurrent._activity.runVoidMethod ("AddView",(Object)((test.mostCurrent._scrollview.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(test.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),test.mostCurrent.activityBA)),(Object)(test.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),test.mostCurrent.activityBA)));
 BA.debugLineNum = 25;BA.debugLine="LoopPanel";
Debug.ShouldStop(16777216);
_looppanel();
 BA.debugLineNum = 26;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
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
		Debug.PushSubsStack("Activity_Pause (test) ","test",3,test.mostCurrent.activityBA,test.mostCurrent,111);
if (RapidSub.canDelegate("activity_pause")) return test.remoteMe.runUserSub(false, "test","activity_pause", _userclosed);
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 111;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(16384);
 BA.debugLineNum = 113;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
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
		Debug.PushSubsStack("Activity_Resume (test) ","test",3,test.mostCurrent.activityBA,test.mostCurrent,107);
if (RapidSub.canDelegate("activity_resume")) return test.remoteMe.runUserSub(false, "test","activity_resume");
 BA.debugLineNum = 107;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(1024);
 BA.debugLineNum = 109;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
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
 //BA.debugLineNum = 17;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _looppanel() throws Exception{
try {
		Debug.PushSubsStack("LoopPanel (test) ","test",3,test.mostCurrent.activityBA,test.mostCurrent,29);
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
RemoteObject _jobtitle = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _location = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _jobdesc = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _currency = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _commision = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _root = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _colroot = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _reference = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _sizeofref = RemoteObject.createImmutable(0);
RemoteObject _colreference = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
 BA.debugLineNum = 29;BA.debugLine="Sub LoopPanel";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 30;BA.debugLine="Dim Bitmap1 As Bitmap";
Debug.ShouldStop(536870912);
_bitmap1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");Debug.locals.put("Bitmap1", _bitmap1);
 BA.debugLineNum = 31;BA.debugLine="Dim Container As Panel";
Debug.ShouldStop(1073741824);
_container = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("Container", _container);
 BA.debugLineNum = 32;BA.debugLine="Dim JoblistPanel,ReferencePanel As Panel";
Debug.ShouldStop(-2147483648);
_joblistpanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("JoblistPanel", _joblistpanel);
_referencepanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("ReferencePanel", _referencepanel);
 BA.debugLineNum = 33;BA.debugLine="Dim PanelTop,PanelHeight,ReferenceTop,ReferenceHe";
Debug.ShouldStop(1);
_paneltop = RemoteObject.createImmutable(0);Debug.locals.put("PanelTop", _paneltop);
_panelheight = RemoteObject.createImmutable(0);Debug.locals.put("PanelHeight", _panelheight);
_referencetop = RemoteObject.createImmutable(0);Debug.locals.put("ReferenceTop", _referencetop);
_referenceheight = RemoteObject.createImmutable(0);Debug.locals.put("ReferenceHeight", _referenceheight);
_gap = RemoteObject.createImmutable(0);Debug.locals.put("Gap", _gap);
 BA.debugLineNum = 34;BA.debugLine="Dim JobTitle,Location,JobDesc,Currency,Commision";
Debug.ShouldStop(2);
_jobtitle = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("JobTitle", _jobtitle);
_location = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("Location", _location);
_jobdesc = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("JobDesc", _jobdesc);
_currency = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("Currency", _currency);
_commision = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("Commision", _commision);
 BA.debugLineNum = 37;BA.debugLine="PanelTop = 10";
Debug.ShouldStop(16);
_paneltop = BA.numberCast(int.class, 10);Debug.locals.put("PanelTop", _paneltop);
 BA.debugLineNum = 39;BA.debugLine="PanelHeight = 170";
Debug.ShouldStop(64);
_panelheight = BA.numberCast(int.class, 170);Debug.locals.put("PanelHeight", _panelheight);
 BA.debugLineNum = 41;BA.debugLine="Gap = 10";
Debug.ShouldStop(256);
_gap = BA.numberCast(int.class, 10);Debug.locals.put("Gap", _gap);
 BA.debugLineNum = 43;BA.debugLine="Bitmap1.Initialize(File.DirAssets,\"logo.png\")";
Debug.ShouldStop(1024);
_bitmap1.runVoidMethod ("Initialize",(Object)(test.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("logo.png")));
 BA.debugLineNum = 44;BA.debugLine="Container = scrollView.Panel";
Debug.ShouldStop(2048);
_container = test.mostCurrent._scrollview.runMethod(false,"getPanel");Debug.locals.put("Container", _container);
 BA.debugLineNum = 45;BA.debugLine="Container.Color = Colors.RGB(219,219,219)";
Debug.ShouldStop(4096);
_container.runVoidMethod ("setColor",test.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 219)),(Object)(BA.numberCast(int.class, 219)),(Object)(BA.numberCast(int.class, 219))));
 BA.debugLineNum = 48;BA.debugLine="JSON.Initialize(File.ReadString(File.DirAssets";
Debug.ShouldStop(32768);
test.mostCurrent._json.runVoidMethod ("Initialize",(Object)(test.mostCurrent.__c.getField(false,"File").runMethod(true,"ReadString",(Object)(test.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("list.json")))));
 BA.debugLineNum = 49;BA.debugLine="Dim root As List = JSON.NextArray";
Debug.ShouldStop(65536);
_root = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_root = test.mostCurrent._json.runMethod(false,"NextArray");Debug.locals.put("root", _root);Debug.locals.put("root", _root);
 BA.debugLineNum = 50;BA.debugLine="For Each colroot As Map In root";
Debug.ShouldStop(131072);
_colroot = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
final RemoteObject group14 = _root;
final int groupLen14 = group14.runMethod(true,"getSize").<Integer>get();
for (int index14 = 0;index14 < groupLen14 ;index14++){
_colroot.setObject(group14.runMethod(false,"Get",index14));
Debug.locals.put("colroot", _colroot);
 BA.debugLineNum = 52;BA.debugLine="Dim reference As List = colroot.Get(\"reference\")";
Debug.ShouldStop(524288);
_reference = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_reference.setObject(_colroot.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("reference")))));Debug.locals.put("reference", _reference);
 BA.debugLineNum = 55;BA.debugLine="JoblistPanel.Initialize(\"\")";
Debug.ShouldStop(4194304);
_joblistpanel.runVoidMethod ("Initialize",test.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 56;BA.debugLine="JobTitle.Initialize(\"JobTitle\")";
Debug.ShouldStop(8388608);
_jobtitle.runVoidMethod ("Initialize",test.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("JobTitle")));
 BA.debugLineNum = 57;BA.debugLine="Location.Initialize(\"Location\")";
Debug.ShouldStop(16777216);
_location.runVoidMethod ("Initialize",test.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("Location")));
 BA.debugLineNum = 58;BA.debugLine="JobDesc.Initialize(\"JobDesc\")";
Debug.ShouldStop(33554432);
_jobdesc.runVoidMethod ("Initialize",test.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("JobDesc")));
 BA.debugLineNum = 59;BA.debugLine="Currency.Initialize(\"Currency\")";
Debug.ShouldStop(67108864);
_currency.runVoidMethod ("Initialize",test.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("Currency")));
 BA.debugLineNum = 60;BA.debugLine="Commision.Initialize(\"Commision\")";
Debug.ShouldStop(134217728);
_commision.runVoidMethod ("Initialize",test.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("Commision")));
 BA.debugLineNum = 63;BA.debugLine="JobTitle.Text = \"Senior UX Architect(Content Pla";
Debug.ShouldStop(1073741824);
_jobtitle.runMethod(true,"setText",RemoteObject.createImmutable(("Senior UX Architect(Content Planning, Interaction Design)")));
 BA.debugLineNum = 64;BA.debugLine="Location.Text = \"Greater Jakarta Area, Indonesia";
Debug.ShouldStop(-2147483648);
_location.runMethod(true,"setText",RemoteObject.createImmutable(("Greater Jakarta Area, Indonesia")));
 BA.debugLineNum = 65;BA.debugLine="Location.TextColor = Colors.RGB(179,179,179)";
Debug.ShouldStop(1);
_location.runMethod(true,"setTextColor",test.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 179)),(Object)(BA.numberCast(int.class, 179)),(Object)(BA.numberCast(int.class, 179))));
 BA.debugLineNum = 66;BA.debugLine="JobDesc.Text = \"Consulting, Research, & Legal Se";
Debug.ShouldStop(2);
_jobdesc.runMethod(true,"setText",RemoteObject.createImmutable(("Consulting, Research, & Legal Services")));
 BA.debugLineNum = 67;BA.debugLine="JobDesc.TextColor = Colors.RGB(179,179,179)";
Debug.ShouldStop(4);
_jobdesc.runMethod(true,"setTextColor",test.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 179)),(Object)(BA.numberCast(int.class, 179)),(Object)(BA.numberCast(int.class, 179))));
 BA.debugLineNum = 68;BA.debugLine="Currency.Text = \"IDR 10.000.000\"";
Debug.ShouldStop(8);
_currency.runMethod(true,"setText",RemoteObject.createImmutable(("IDR 10.000.000")));
 BA.debugLineNum = 69;BA.debugLine="Currency.Typeface = Typeface.DEFAULT_BOLD";
Debug.ShouldStop(16);
_currency.runMethod(false,"setTypeface",test.mostCurrent.__c.getField(false,"Typeface").getField(false,"DEFAULT_BOLD"));
 BA.debugLineNum = 70;BA.debugLine="Commision.Text = \"Commision\"";
Debug.ShouldStop(32);
_commision.runMethod(true,"setText",RemoteObject.createImmutable(("Commision")));
 BA.debugLineNum = 71;BA.debugLine="Commision.TextColor = Colors.RGB(179,179,179)";
Debug.ShouldStop(64);
_commision.runMethod(true,"setTextColor",test.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 179)),(Object)(BA.numberCast(int.class, 179)),(Object)(BA.numberCast(int.class, 179))));
 BA.debugLineNum = 73;BA.debugLine="JoblistPanel.AddView(JobTitle,10,10,Container.Wi";
Debug.ShouldStop(256);
_joblistpanel.runVoidMethod ("AddView",(Object)((_jobtitle.getObject())),(Object)(BA.numberCast(int.class, 10)),(Object)(BA.numberCast(int.class, 10)),(Object)(_container.runMethod(true,"getWidth")),(Object)(BA.numberCast(int.class, 50)));
 BA.debugLineNum = 74;BA.debugLine="JoblistPanel.AddView(Location,10,65,Container.Wi";
Debug.ShouldStop(512);
_joblistpanel.runVoidMethod ("AddView",(Object)((_location.getObject())),(Object)(BA.numberCast(int.class, 10)),(Object)(BA.numberCast(int.class, 65)),(Object)(_container.runMethod(true,"getWidth")),(Object)(BA.numberCast(int.class, 30)));
 BA.debugLineNum = 75;BA.debugLine="JoblistPanel.AddView(JobDesc,10,95,Container.Wid";
Debug.ShouldStop(1024);
_joblistpanel.runVoidMethod ("AddView",(Object)((_jobdesc.getObject())),(Object)(BA.numberCast(int.class, 10)),(Object)(BA.numberCast(int.class, 95)),(Object)(_container.runMethod(true,"getWidth")),(Object)(BA.numberCast(int.class, 30)));
 BA.debugLineNum = 76;BA.debugLine="JoblistPanel.AddView(Currency,10,125,Container.W";
Debug.ShouldStop(2048);
_joblistpanel.runVoidMethod ("AddView",(Object)((_currency.getObject())),(Object)(BA.numberCast(int.class, 10)),(Object)(BA.numberCast(int.class, 125)),(Object)(_container.runMethod(true,"getWidth")),(Object)(BA.numberCast(int.class, 30)));
 BA.debugLineNum = 77;BA.debugLine="JoblistPanel.AddView(Commision,160,125,Container";
Debug.ShouldStop(4096);
_joblistpanel.runVoidMethod ("AddView",(Object)((_commision.getObject())),(Object)(BA.numberCast(int.class, 160)),(Object)(BA.numberCast(int.class, 125)),(Object)(_container.runMethod(true,"getWidth")),(Object)(BA.numberCast(int.class, 30)));
 BA.debugLineNum = 78;BA.debugLine="JoblistPanel.Color=Colors.RGB(255,255,255)";
Debug.ShouldStop(8192);
_joblistpanel.runVoidMethod ("setColor",test.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 255))));
 BA.debugLineNum = 81;BA.debugLine="ReferenceTop = 170";
Debug.ShouldStop(65536);
_referencetop = BA.numberCast(int.class, 170);Debug.locals.put("ReferenceTop", _referencetop);
 BA.debugLineNum = 83;BA.debugLine="ReferenceHeight = 200";
Debug.ShouldStop(262144);
_referenceheight = BA.numberCast(int.class, 200);Debug.locals.put("ReferenceHeight", _referenceheight);
 BA.debugLineNum = 86;BA.debugLine="Dim SizeOfRef As Int = reference.Size";
Debug.ShouldStop(2097152);
_sizeofref = _reference.runMethod(true,"getSize");Debug.locals.put("SizeOfRef", _sizeofref);Debug.locals.put("SizeOfRef", _sizeofref);
 BA.debugLineNum = 90;BA.debugLine="PanelHeight = PanelHeight+ReferenceHeight*SizeOf";
Debug.ShouldStop(33554432);
_panelheight = RemoteObject.solve(new RemoteObject[] {_panelheight,_referenceheight,_sizeofref,(RemoteObject.solve(new RemoteObject[] {_gap,_sizeofref}, "*",0, 1))}, "+*+",2, 1);Debug.locals.put("PanelHeight", _panelheight);
 BA.debugLineNum = 92;BA.debugLine="For Each colreference As Map In reference";
Debug.ShouldStop(134217728);
_colreference = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
final RemoteObject group41 = _reference;
final int groupLen41 = group41.runMethod(true,"getSize").<Integer>get();
for (int index41 = 0;index41 < groupLen41 ;index41++){
_colreference.setObject(group41.runMethod(false,"Get",index41));
Debug.locals.put("colreference", _colreference);
 BA.debugLineNum = 93;BA.debugLine="ReferencePanel.Initialize(\"\")";
Debug.ShouldStop(268435456);
_referencepanel.runVoidMethod ("Initialize",test.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 94;BA.debugLine="ReferencePanel.Color = Colors.Red";
Debug.ShouldStop(536870912);
_referencepanel.runVoidMethod ("setColor",test.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 95;BA.debugLine="JoblistPanel.AddView(ReferencePanel,40,Referenc";
Debug.ShouldStop(1073741824);
_joblistpanel.runVoidMethod ("AddView",(Object)((_referencepanel.getObject())),(Object)(BA.numberCast(int.class, 40)),(Object)(_referencetop),(Object)(RemoteObject.solve(new RemoteObject[] {test.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 90)),test.mostCurrent.activityBA),RemoteObject.createImmutable(10)}, "-",1, 1)),(Object)(_referenceheight));
 BA.debugLineNum = 96;BA.debugLine="ReferenceTop = ReferenceTop+ReferenceHeight+Gap";
Debug.ShouldStop(-2147483648);
_referencetop = RemoteObject.solve(new RemoteObject[] {_referencetop,_referenceheight,_gap}, "++",2, 1);Debug.locals.put("ReferenceTop", _referencetop);
 }
Debug.locals.put("colreference", _colreference);
;
 BA.debugLineNum = 99;BA.debugLine="Container.AddView(JoblistPanel,0,PanelTop,Contai";
Debug.ShouldStop(4);
_container.runVoidMethod ("AddView",(Object)((_joblistpanel.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(_paneltop),(Object)(_container.runMethod(true,"getWidth")),(Object)(_panelheight));
 BA.debugLineNum = 100;BA.debugLine="PanelTop = PanelTop+PanelHeight+Gap";
Debug.ShouldStop(8);
_paneltop = RemoteObject.solve(new RemoteObject[] {_paneltop,_panelheight,_gap}, "++",2, 1);Debug.locals.put("PanelTop", _paneltop);
 BA.debugLineNum = 101;BA.debugLine="PanelHeight = 170";
Debug.ShouldStop(16);
_panelheight = BA.numberCast(int.class, 170);Debug.locals.put("PanelHeight", _panelheight);
 }
Debug.locals.put("colroot", _colroot);
;
 BA.debugLineNum = 103;BA.debugLine="Container.Height = PanelTop";
Debug.ShouldStop(64);
_container.runMethod(true,"setHeight",_paneltop);
 BA.debugLineNum = 104;BA.debugLine="End Sub";
Debug.ShouldStop(128);
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