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
	Dim detailList As List
	Dim qAuth As Auth
	Dim font As Fonts
End Sub

Sub Activity_Create(FirstTime As Boolean)
	qAuth.Initialize(Activity)
	font.Initialize
	
	'Do not forget to load the layout file created with the visual designer. For example:
	'Activity.LoadLayout("Layout1")
	Activity.AddMenuItem3("SearchItem", "SearchItem", LoadBitmap(File.DirAssets, "search.png"), True)
	scrollView.Initialize(Activity.Height)
	scrollView.Color = Colors.RGB(219,219,219)
	Activity.AddView(scrollView,0,0,100%x,100%y)
	detailList.Initialize
	LoopPanel
End Sub


Sub LoopPanel
	Dim Bitmap1 As Bitmap
	Dim Container As Panel
	Dim JoblistPanel,ReferencePanel As Panel
	Dim PanelTop,PanelHeight,ReferenceTop,ReferenceHeight,Gap,TextHeight As Int
	Dim JobTitle,Location,JobDesc,Currency,Commision As Label
	Dim locationIcon,industryIcon,moneyIcon As ImageView
	
	'Default Panel Top position
	PanelTop = 10dip
	'Default Panel height
	PanelHeight = 140dip
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
		
		'Icon Initialize
		locationIcon.Initialize("")
		industryIcon.Initialize("")
		moneyIcon.Initialize("")
		
		'LocationIcon
		locationIcon.Bitmap = LoadBitmap(File.DirAssets,"location.png")
		industryIcon.Bitmap = LoadBitmap(File.DirAssets,"industry.png")
		moneyIcon.Bitmap = LoadBitmap(File.DirAssets,"money.png")
		
		'JobTitle Label
		JobTitle.Typeface = font.proximanovaSemiBold
		JobTitle.Text = job_title
'		JobTitle.TextSize = 14dip
		
		Location.Typeface = font.proximanovaRegular
		Location.Text = job_location
		Location.TextColor = Colors.RGB(179,179,179)
'		Location.TextSize = 12dip
		
		JobDesc.Typeface = font.proximanovaRegular
		JobDesc.Text = job_desc
		JobDesc.TextColor = Colors.RGB(179,179,179)
'		JobDesc.TextSize = 12dip
		
		Currency.Typeface = font.proximanovaSemiBold
		Currency.Text = "IDR "&NumberFormat(job_commision,0,2)
		Currency.Typeface = Typeface.DEFAULT_BOLD
		Currency.TextColor = Colors.RGB(74,74,74)
'		Currency.TextSize = 12dip
		Commision.Typeface = font.proximanovaSemiBold
		Commision.Text = "Commision"
		Commision.TextColor = Colors.RGB(179,179,179)
'		Commision.TextSize = 12dip
		
		'JobTitle Add View
		JoblistPanel.AddView(JobTitle,10dip,10dip,100%x-(10dip*2),50dip)
		TextHeight = su.MeasureMultilineTextHeight(JobTitle,JobTitle.Text)
		'Location Icon
		JoblistPanel.AddView(locationIcon,10dip,TextHeight+Gap+3dip,14dip,14dip)
		'Location Add View
		JoblistPanel.AddView(Location,30dip,TextHeight+Gap,100%x,50dip)
		TextHeight = TextHeight + su.MeasureMultilineTextHeight(Location,Location.Text)
		
		'Industry/Jobdesc Icon
		JoblistPanel.AddView(industryIcon,10dip,TextHeight+Gap+3dip,14dip,14dip)
		'Jobdesc Add View
		JoblistPanel.AddView(JobDesc,30dip,TextHeight+Gap,100%x,50dip)
		TextHeight = TextHeight + su.MeasureMultilineTextHeight(JobDesc,JobDesc.Text)
		
		'Moneyicon
		JoblistPanel.AddView(moneyIcon,10dip,TextHeight+Gap+5dip,14dip,14dip)
		'Currency & Commision Add View
		JoblistPanel.AddView(Currency,30dip,TextHeight+Gap,130dip,50dip)
		JoblistPanel.AddView(Commision,Currency.Width+Currency.Left,TextHeight+Gap+3dip,100%x,50dip)
		TextHeight = TextHeight + su.MeasureMultilineTextHeight(Currency,Currency.Text)
		
		JoblistPanel.Color=Colors.RGB(255,255,255)
		
		'Default Reference Panel Top Location
		ReferenceTop = TextHeight+Gap*2
		'Default Reference Panel Height
		ReferenceHeight = 110dip
		
		'Get Reference Size
		Dim SizeOfRef As Int = reference.Size
		
		'Set Autmatic Wrapper Height depend on Items
		
		PanelHeight = PanelHeight+(ReferenceHeight*SizeOfRef)+(Gap*SizeOfRef)
		
		For Each colreference As Map In reference
			Dim refName,refCompany,refStatus,detailBtn As Label
			Dim statusRef As String
			Dim rHeight,statusRefColor As Int
			Dim userIcon As ImageView
			
			'Json parsing
			Dim rName As String = colreference.Get("name") 
			Dim rCompany As String = colreference.Get("company") 
			Dim rStatus As String = colreference.Get("status") 
			Dim userId As Int = colreference.Get("userId") 
			
			'Icon
			userIcon.Initialize("")
			userIcon.Bitmap = LoadBitmap(File.DirAssets,"user.png")
			
			ReferencePanel.Initialize("")	
			ReferencePanel.Color = Colors.White
			JoblistPanel.AddView(ReferencePanel,25dip,ReferenceTop,100%x-(25dip*2),ReferenceHeight)
			DrawBorder(ReferencePanel,Colors.RGB(219,219,219),4)
			
			'refName
			ReferencePanel.AddView(userIcon,10dip,10dip,24dip,24dip)
			refName.Initialize("")
			refName.Text = rName
			refName.TextColor = Colors.RGB(74,74,74)
'			refName.TextSize = 14dip
			refName.Typeface = Typeface.DEFAULT_BOLD
			ReferencePanel.AddView(refName,38dip,8dip,ReferencePanel.Width-Gap,50dip)
			rHeight = su.MeasureMultilineTextHeight(refName,refName.Text)
			
			'refCompany
			refCompany.Initialize("")
			refCompany.Text = rCompany
			refCompany.TextColor = Colors.RGB(179,179,179)
'			refCompany.TextSize = 12dip
			ReferencePanel.AddView(refCompany,38dip,rHeight+Gap,ReferencePanel.Width-Gap,50dip)
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
'			refStatus.TextSize = 10dip
			refStatus.Color = statusRefColor
			refStatus.Gravity = Gravity.CENTER
			ReferencePanel.AddView(refStatus,38dip,rHeight+Gap+10dip,120dip,20dip)
			
			'detailBtn
			detailBtn.Initialize("detailBtn")
			detailBtn.Tag = userId
			detailBtn.Text = "Detail Progress"
'			detailBtn.TextSize = 10dip
			detailBtn.TextColor = Colors.RGB(22,176,221)
			detailBtn.Gravity = Gravity.CENTER
			'add to list
			detailList.Add(detailBtn)
			
			'Log(ReferencePanel.Width)
			ReferencePanel.AddView(detailBtn,(ReferencePanel.Width - 100dip - Gap),rHeight+Gap+10dip,100dip,20dip)
			
			ReferenceTop = ReferenceTop+ReferenceHeight+Gap
		Next
		
		Container.AddView(JoblistPanel,0,PanelTop,Container.Width,PanelHeight)
		PanelTop = PanelTop+PanelHeight+Gap
		PanelHeight = 140dip
	Next
	Container.Height = PanelTop
End Sub

Sub SearchItem_Click
	qAuth.Logout
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Sub detailBtn_Click
	For i = 0 To detailList.Size - 1
		Dim detailBtn As Label
		detailBtn = detailList.Get(i)
		detailBtn = Sender
	Next
	
	'Msgbox(detailBtn.Tag&" Was Clicked","Button Clicked")
	ReferringProgress.userId = detailBtn.Tag
	StartActivity(ReferringProgress)
		
End Sub

Public Sub DrawBorder(Target As View, aColor As Int, StrokeWidth As Int)
   Dim c As Canvas
   c.Initialize(Target)
   Dim r As Rect : r.Initialize(0, 0, Target.Width, Target.Height)
   c.DrawRect(r, aColor, False, StrokeWidth)
   Target.Invalidate
End Sub
