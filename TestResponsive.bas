Type=Activity
Version=5.8
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: False
	#IncludeTitle: True
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.

End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
	Dim scrollView As ScrollView
	Dim JSON As JSONParser
	Dim su As StringUtils
	Private FirstContainer As Panel
	Private Label1 As Label
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	'Activity.LoadLayout("Layout1")
	Activity.AddMenuItem3("SearchItem", "SearchItem", LoadBitmap(File.DirAssets, "search.png"), True)
	scrollView.Initialize(Activity.Height)
	scrollView.Color = Colors.RGB(219,219,219)
	Activity.AddView(scrollView,0,0,100%x,100%y)
	LoopView
End Sub

Sub LoopView
	Dim Container As Panel
	
	Container = scrollView.Panel
	Container.LoadLayout("testResponsive")
	Container.Height = 2000
	
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub
