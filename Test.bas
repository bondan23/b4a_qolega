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
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	'Activity.LoadLayout("Layout1")
	Activity.AddMenuItem3("SearchItem", "SearchItem", LoadBitmap(File.DirAssets, "search.png"), True)
	scrollView.Initialize(Activity.Height)
	Activity.AddView(scrollView,0,0,100%x,100%y)
	LoopPanel
End Sub


Sub LoopPanel
	Dim Bitmap1 As Bitmap
	Dim Container As Panel
	Dim JoblistPanel,ReferencePanel As Panel
	Dim PanelTop,PanelHeight,ReferenceTop,ReferenceHeight,Gap As Int
	Dim JobTitle,Location,JobDesc,Currency,Commision As Label
	
	'Default Panel Top position
	PanelTop = 10
	'Default Panel height
	PanelHeight = 170
	'Default Gap
	Gap = 10
	
	Bitmap1.Initialize(File.DirAssets,"logo.png")
	Container = scrollView.Panel
	Container.Color = Colors.RGB(219,219,219)
	
	'json
    JSON.Initialize(File.ReadString(File.DirAssets, "list.json"))
	Dim root As List = JSON.NextArray 
	For Each colroot As Map In root
		'Init Json Object
		Dim reference As List = colroot.Get("reference") 
		
		'Init
		JoblistPanel.Initialize("")	
		JobTitle.Initialize("JobTitle")
		Location.Initialize("Location")
		JobDesc.Initialize("JobDesc")
		Currency.Initialize("Currency")
		Commision.Initialize("Commision")
		
		'JobTitle Label
		JobTitle.Text = "Senior UX Architect(Content Planning, Interaction Design)"
		Location.Text = "Greater Jakarta Area, Indonesia"
		Location.TextColor = Colors.RGB(179,179,179)
		JobDesc.Text = "Consulting, Research, & Legal Services"
		JobDesc.TextColor = Colors.RGB(179,179,179)
		Currency.Text = "IDR 10.000.000"
		Currency.Typeface = Typeface.DEFAULT_BOLD
		Commision.Text = "Commision"
		Commision.TextColor = Colors.RGB(179,179,179)
		
		JoblistPanel.AddView(JobTitle,10,10,Container.Width,50)
		JoblistPanel.AddView(Location,10,65,Container.Width,30)
		JoblistPanel.AddView(JobDesc,10,95,Container.Width,30)
		JoblistPanel.AddView(Currency,10,125,Container.Width,30)
		JoblistPanel.AddView(Commision,160,125,Container.Width,30)
		JoblistPanel.Color=Colors.RGB(255,255,255)
		
		'Default Reference Panel Top Location
		ReferenceTop = 170
		'Default Reference Panel Height
		ReferenceHeight = 200
		
		'Get Reference Size
		Dim SizeOfRef As Int = reference.Size
		
		'Set Autmatic Wrapper Height depend on Items
		
		PanelHeight = PanelHeight+ReferenceHeight*SizeOfRef+(Gap*SizeOfRef)
		
		For Each colreference As Map In reference
			ReferencePanel.Initialize("")
			DrawBorder(ReferencePanel,
			ReferencePanel.Color = Colors.Red
			JoblistPanel.AddView(ReferencePanel,40,ReferenceTop,90%x-10,ReferenceHeight)
			ReferenceTop = ReferenceTop+ReferenceHeight+Gap
		Next
		
		Container.AddView(JoblistPanel,0,PanelTop,Container.Width,PanelHeight)
		PanelTop = PanelTop+PanelHeight+Gap
		PanelHeight = 170
	Next
	Container.Height = PanelTop
End Sub


Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Public Sub DrawBorder(Target As View, aColor As Int, StrokeWidth As Int)
   Dim c As Canvas
   c.Initialize(Target)
   Dim r As Rect : r.Initialize(0, 0, Target.Width - StrokeWidth, Target.Height - StrokeWidth)
   c.DrawRect(r, aColor, False, StrokeWidth)
   Target.Invalidate
End Sub
