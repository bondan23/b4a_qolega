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
	PanelTop = 10dip
	'Default Panel height
	PanelHeight = 110dip
	'Default Gap
	Gap = 10dip
	
	'Bitmap1.Initialize(File.DirAssets,"logo.png")
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
		JoblistPanel.AddView(JobTitle,10dip,10dip,100%x,50dip)
		TextHeight = su.MeasureMultilineTextHeight(JobTitle,JobTitle.Text)
		'Location Add View
		JoblistPanel.AddView(Location,10dip,TextHeight+Gap,100%x,50dip)
		TextHeight = TextHeight + su.MeasureMultilineTextHeight(Location,Location.Text)
		'Jobdesc Add View
		JoblistPanel.AddView(JobDesc,10dip,TextHeight+Gap,100%x,50dip)
		TextHeight = TextHeight + su.MeasureMultilineTextHeight(JobDesc,JobDesc.Text)
		'Currency & Commision Add View
		JoblistPanel.AddView(Currency,10dip,TextHeight+Gap,100%x,50dip)
		JoblistPanel.AddView(Commision,110dip,TextHeight+Gap,100%x,50dip)
		TextHeight = TextHeight + su.MeasureMultilineTextHeight(Currency,JobDesc.Text)
		
		JoblistPanel.Color=Colors.RGB(255,255,255)
		
		'Default Reference Panel Top Location
		ReferenceTop = TextHeight+Gap*2
		'Default Reference Panel Height
		ReferenceHeight = 89dip
		
		'Get Reference Size
		Dim SizeOfRef As Int = reference.Size
		
		'Set Autmatic Wrapper Height depend on Items
		
		PanelHeight = PanelHeight+(ReferenceHeight*SizeOfRef)+(Gap*SizeOfRef)
		
		For Each colreference As Map In reference
			Dim refName,refCompany,refStatus As Label
			Dim statusRef As String
			Dim rHeight,statusRefColor As Int
			Dim detailBtn As Button
			
			'Json parsing
			Dim rName As String = colreference.Get("name") 
			Dim rCompany As String = colreference.Get("company") 
			Dim rStatus As String = colreference.Get("status") 
			
			
			ReferencePanel.Initialize("")	
			ReferencePanel.Color = Colors.White
			JoblistPanel.AddView(ReferencePanel,40,ReferenceTop,90%x-10,ReferenceHeight)
			DrawBorder(ReferencePanel,Colors.RGB(219,219,219),4)
			
			'refName
			refName.Initialize("")
			refName.Text = rName
			refName.TextColor = Colors.RGB(74,74,74)
			refName.Typeface = Typeface.DEFAULT_BOLD
			ReferencePanel.AddView(refName,10,10,ReferencePanel.Width-Gap,50)
			rHeight = su.MeasureMultilineTextHeight(refName,refName.Text)
			
			'refCompany
			refCompany.Initialize("")
			refCompany.Text = rCompany
			refCompany.TextColor = Colors.RGB(219,219,219)
			ReferencePanel.AddView(refCompany,10,rHeight+Gap,ReferencePanel.Width-Gap,50)
			rHeight = rHeight + su.MeasureMultilineTextHeight(refCompany,refCompany.Text)
			
			'refStatus
			Select rStatus
				Case 0
					statusRef = "Qualifying"
					statusRefColor = Colors.RGB(249,191,55)
				Case 1
					statusRef = "1st Interview"
					statusRefColor = Colors.RGB(102,195,67)
				Case Else
					statusRef = "Completed"
					statusRefColor = Colors.RGB(22,176,221)
			End Select
			
			refStatus.Initialize("")
			refStatus.Text = statusRef
			refStatus.TextColor = Colors.White
			refStatus.Color = statusRefColor
			refStatus.Gravity = Gravity.CENTER
			ReferencePanel.AddView(refStatus,10,rHeight+Gap+10,(ReferencePanel.Width-Gap)/2,50)
			
			'detailBtn
			detailBtn.Initialize("detailBtn")
			detailBtn.Text = "Detail Progress"
			detailBtn.Gravity = Gravity.CENTER
			detailBtn.TextSize = 10
			ReferencePanel.AddView(detailBtn,((ReferencePanel.Width-Gap)/2)+10,rHeight+Gap,(ReferencePanel.Width-Gap)/2,65)
			
			
			ReferenceTop = ReferenceTop+ReferenceHeight+Gap
		Next
		
		Container.AddView(JoblistPanel,0,PanelTop,Container.Width,PanelHeight)
		PanelTop = PanelTop+PanelHeight+Gap
		PanelHeight = 110dip
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
