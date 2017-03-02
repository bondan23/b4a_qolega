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
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	'Activity.LoadLayout("Layout1")
	Activity.AddMenuItem3("SearchItem", "SearchItem", LoadBitmap(File.DirAssets, "search.png"), True)
	scrollView.Initialize(Activity.Height)
	scrollView.Color = Colors.RGB(219,219,219)
	Activity.AddView(scrollView,0,0,100%x,100%y)
	LoopPanel
End Sub


Sub LoopPanel
	Dim Bitmap1 As Bitmap
	Dim Container As Panel
	Dim JoblistPanel,ReferencePanel As Panel
	Dim PanelTop,PanelHeight,ReferenceTop,ReferenceHeight,Gap,TextHeight As Int
	Dim JobTitle,Location,JobDesc,Currency,Commision As Label
	
	'Default Panel Top position
	PanelTop = 10
	'Default Panel height
	PanelHeight = 100
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
		Dim job_title As String = colroot.Get("jobtitle")
		Dim job_location As String = colroot.Get("location")
		Dim job_desc As String = colroot.Get("jobdesc")
		Dim job_commision As Double = colroot.Get("commision")
		
		'Init
		JoblistPanel.Initialize("")	
		JobTitle.Initialize("JobTitle")
		Location.Initialize("Location")
		JobDesc.Initialize("JobDesc")
		Currency.Initialize("Currency")
		Commision.Initialize("Commision")
		
		'JobTitle Label
		JobTitle.Text = job_title
		Location.Text = job_location
		Location.TextColor = Colors.RGB(179,179,179)
		JobDesc.Text = job_desc
		JobDesc.TextColor = Colors.RGB(179,179,179)
		Currency.Text = "IDR "&NumberFormat(job_commision,0,2)
		Currency.Typeface = Typeface.DEFAULT_BOLD
		Currency.TextColor = Colors.RGB(74,74,74)
		Commision.Text = "Commision"
		Commision.TextColor = Colors.RGB(179,179,179)
		
		'JobTitle Add View
		JoblistPanel.AddView(JobTitle,10,10,100%x,50)
		TextHeight = su.MeasureMultilineTextHeight(JobTitle,JobTitle.Text)
		'Location Add View
		JoblistPanel.AddView(Location,10,TextHeight+Gap,100%x,50)
		TextHeight = TextHeight + su.MeasureMultilineTextHeight(Location,Location.Text)
		'Jobdesc Add View
		JoblistPanel.AddView(JobDesc,10,TextHeight+Gap,100%x,50)
		TextHeight = TextHeight + su.MeasureMultilineTextHeight(JobDesc,JobDesc.Text)
		'Currency & Commision Add View
		JoblistPanel.AddView(Currency,10,TextHeight+Gap,100,50)
		JoblistPanel.AddView(Commision,110,TextHeight+Gap,100,50)
		TextHeight = TextHeight + su.MeasureMultilineTextHeight(Currency,JobDesc.Text)
		
		JoblistPanel.Color=Colors.RGB(255,255,255)
		
		'Default Reference Panel Top Location
		ReferenceTop = TextHeight-Gap
		'Default Reference Panel Height
		ReferenceHeight = 89dip
		
		'Get Reference Size
		Dim SizeOfRef As Int = reference.Size
		
		'Set Autmatic Wrapper Height depend on Items
		
		PanelHeight = PanelHeight+(ReferenceHeight*SizeOfRef)+(Gap*SizeOfRef)
		
		For Each colreference As Map In reference
			Dim refName,refCompany,refStatus As Label
			'Json parsing
			Dim rName As String = colreference.Get("name") 
			
			ReferencePanel.Initialize("")	
			ReferencePanel.Color = Colors.White
			JoblistPanel.AddView(ReferencePanel,40,ReferenceTop,90%x-10,ReferenceHeight)
			DrawBorder(ReferencePanel,Colors.RGB(219,219,219),4)
			
			'refName
			refName.Initialize("")
			refName.Text = rName
			refName.TextColor = Colors.RGB(74,74,74)
			refName.Typeface = Typeface.DEFAULT_BOLD
			ReferencePanel.AddView(refName,10,10,200,50)
			
			'refCompany
			refCompany.Initialize("")
			
			ReferenceTop = ReferenceTop+ReferenceHeight+Gap
		Next
		
		Container.AddView(JoblistPanel,0,PanelTop,Container.Width,PanelHeight)
		PanelTop = PanelTop+PanelHeight+Gap
		PanelHeight = 100
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
   Dim r As Rect : r.Initialize(0, 0, Target.Width, Target.Height)
   c.DrawRect(r, aColor, False, StrokeWidth)
   Target.Invalidate
End Sub
