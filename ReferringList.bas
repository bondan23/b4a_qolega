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
	Dim loadMore As Button
End Sub

Sub Activity_Create(FirstTime As Boolean)
	qAuth.Initialize(Activity)
	font.Initialize
	
	'Do not forget to load the layout file created with the visual designer. For example:
	'Activity.LoadLayout("Layout1")
	Activity.AddMenuItem3("SearchItem", "SearchItem", LoadBitmap(File.DirAssets, "Logout.png"), True)
	scrollView.Initialize(Activity.Height)
	scrollView.Color = Colors.RGB(246,246,246)
	Activity.AddView(scrollView,0,0,100%x,100%y)
	detailList.Initialize
	LoopPanel(10dip)
End Sub


Sub LoopPanel(StartTop As Int)
	Dim Bitmap1 As Bitmap
	Dim Container As Panel
	Dim JoblistPanel,ReferencePanel As Panel
	Dim PanelTop,defaultPanelHeight,PanelHeight,ReferenceTop,ReferenceHeight,Gap,TextHeight As Int
	Dim JobTitle,Location,JobDesc,Currency,Commision As Label
	Dim locationIcon,industryIcon,moneyIcon As ImageView
	
	'Default Panel Top position
	PanelTop = StartTop
	
	'Default Panel height
	PanelHeight = 110dip
	defaultPanelHeight = PanelHeight
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
		
		locationIcon.Gravity = Gravity.FILL
		moneyIcon.Gravity = Gravity.FILL
		industryIcon.Gravity = Gravity.FILL
		
		
		'JobTitle Label
		JobTitle.Typeface = font.proximanovaSemiBold
		JobTitle.Text = job_title
'		JobTitle.TextSize = 14dip
		JobTitle.TextColor = Colors.RGB(74,74,74)
		
		
		Location.Typeface = font.proximanovaRegular
		Location.Text = job_location
		Location.TextColor = Colors.RGB(179,179,179)
		Location.TextSize = JobTitle.TextSize / 1.25
		
		JobDesc.Typeface = font.proximanovaRegular
		JobDesc.Text = job_desc
		JobDesc.TextColor = Colors.RGB(179,179,179)
		JobDesc.TextSize = JobTitle.TextSize / 1.25
		
		Currency.Typeface = font.proximanovaSemiBold
		Currency.Text = "IDR "&NumberFormat(job_commision,0,2)
		Currency.TextColor = Colors.RGB(74,74,74)
'		Currency.TextSize = 12dip
		Commision.Typeface = font.proximanovaRegular
		Commision.Text = "Commision"
		Commision.TextColor = Colors.RGB(179,179,179)
		Commision.TextSize = JobTitle.TextSize / 1.25
		
		'JobTitle Add View
		JoblistPanel.AddView(JobTitle,10dip,10dip,100%x-(10dip*2),50dip)
		TextHeight = su.MeasureMultilineTextHeight(JobTitle,JobTitle.Text)
		
		'Location Icon
		JoblistPanel.AddView(locationIcon,12dip,TextHeight+Gap*1.5,9.6dip,12dip)
		
		'Location Add View
		JoblistPanel.AddView(Location,30dip,TextHeight+Gap*1.5,100%x,50dip)
		TextHeight = TextHeight + su.MeasureMultilineTextHeight(Location,Location.Text)
		
		'Industry/Jobdesc Icon
		JoblistPanel.AddView(industryIcon,11dip,TextHeight+Gap*1.8,12dip,12dip)
		'Jobdesc Add View
		JoblistPanel.AddView(JobDesc,30dip,TextHeight+Gap*1.8,100%x,50dip)
		TextHeight = TextHeight + su.MeasureMultilineTextHeight(JobDesc,JobDesc.Text)
		
		'Moneyicon
		JoblistPanel.AddView(moneyIcon,10dip,TextHeight+Gap*2.2,14dip,11.2dip)
		'Currency & Commision Add View
		JoblistPanel.AddView(Currency,30.9dip,TextHeight+Gap*2,105dip,50dip)
		
		Dim Canv As Canvas
		Canv.Initialize(Currency)
		Dim newCurrencyWidth = Canv.MeasureStringWidth(Currency.Text,font.proximanovaRegular,Currency.TextSize) As Int
		Currency.Width = newCurrencyWidth+Gap/2
		
		JoblistPanel.AddView(Commision,Currency.Width+Currency.Left,TextHeight+Gap*2.2,100%x,50dip)
		TextHeight = TextHeight + su.MeasureMultilineTextHeight(Currency,Currency.Text)
		
		JoblistPanel.Color=Colors.RGB(255,255,255)
		
		'Default Reference Panel Top Location
		ReferenceTop = TextHeight+Gap*3
		'Default Reference Panel Height
		ReferenceHeight = 92dip
		
		'Get Reference Size
		Dim SizeOfRef As Int = reference.Size
		
		'Set Autmatic Wrapper Height depend on Items
		
		PanelHeight = PanelHeight+(ReferenceHeight*SizeOfRef)+(Gap*SizeOfRef)
		
		For Each colreference As Map In reference
			Dim refName,refCompany,refStatus,detailBtn,refDay As Label
			Dim detailButton As Button
			Dim statusRef As String
			Dim rHeight,statusRefColor As Int
			Dim userIcon As ImageView
			
			'Json parsing
			Dim rName As String = colreference.Get("name") 
			Dim rCompany As String = colreference.Get("company") 
			Dim rStatus As String = colreference.Get("status") 
			Dim rStatusText As String = colreference.Get("status_text") 
			Dim userId As Int = colreference.Get("userId") 
			
			'Icon
			userIcon.Initialize("")
			userIcon.Bitmap = LoadBitmap(File.DirAssets,"user.png")
			userIcon.Gravity = Gravity.FILL
			ReferencePanel.Initialize("")	
'			ReferencePanel.Color = Colors.White
			JoblistPanel.AddView(ReferencePanel,25dip,ReferenceTop,100%x-(25dip*2),ReferenceHeight)

			Dim cd As ColorDrawable
   			'cd.Initialize(Colors.Red, 10dip)
			cd.Initialize2(Colors.White, 3dip, 1.9dip, Colors.RGB(218,218,218))
			ReferencePanel.Background = cd
'			DrawBorder(ReferencePanel,Colors.RGB(219,219,219),4)	
			'DrawDashLine(ReferencePanel,0,0,0,ReferencePanel.Height,Colors.Red,2dip)
			
			'refName
			ReferencePanel.AddView(userIcon,10dip,10dip,24dip,24dip)
			refName.Initialize("")
			refName.Text = rName
			refName.TextColor = Colors.RGB(74,74,74)
'			refName.TextSize = 14dip
			refName.Typeface = font.proximanovaSemiBold
			refName.Gravity = Gravity.CENTER_VERTICAL
			ReferencePanel.AddView(refName,38dip,12dip,ReferencePanel.Width-38dip*2,20dip)
			
			'refDay
			refDay.Initialize("")
			refDay.Text = "2d"
			refDay.Typeface = font.proximanovaRegular
			refDay.TextColor = Colors.RGB(179,179,179)
			refDay.Gravity = Gravity.CENTER
			refDay.TextSize = refName.TextSize / 1.25
			ReferencePanel.AddView(refDay,ReferencePanel.Width-20dip-Gap,refName.Top,20dip,refName.Height)
			
			
			'refCompany
			refCompany.Initialize("")
			refCompany.Text = rCompany
			refCompany.TextColor = Colors.RGB(179,179,179)
			refCompany.TextSize = JobTitle.TextSize / 1.25
			refCompany.Gravity = Gravity.CENTER_VERTICAL
			ReferencePanel.AddView(refCompany,38dip,refName.Height+refName.Top,ReferencePanel.Width-38dip*2,20dip)
			
			'refStatus
			refStatus.Initialize("")
			Select rStatus
				Case 1
					cd.Initialize(Colors.RGB(249,128,55), 2dip)
					refStatus.Background = cd
				Case 2
					cd.Initialize(Colors.RGB(248,190,56), 2dip)
					refStatus.Background = cd
				Case 3
					cd.Initialize(Colors.RGB(186,220,63), 2dip)
					refStatus.Background = cd
				Case 4
					cd.Initialize(Colors.RGB(103,195,68), 2dip)
					refStatus.Background = cd
				Case 5
					cd.Initialize(Colors.RGB(62,222,176), 2dip)
					refStatus.Background = cd
				Case 6
					cd.Initialize(Colors.RGB(21,176,220), 2dip)
					refStatus.Background = cd
				Case 7
					cd.Initialize(Colors.RGB(38,143,235), 2dip)
					refStatus.Background = cd
				Case Else
					cd.Initialize(Colors.RGB(3,117,216), 2dip)
					refStatus.Background = cd
			End Select
			
			refStatus.Text = rStatusText
			refStatus.TextColor = Colors.White
			'refStatus.TextSize =JobTitle.TextSize / 1.4
'			refStatus.Color = statusRefColor
			refStatus.Gravity = Gravity.CENTER

			ReferencePanel.AddView(refStatus,38dip,refCompany.Top+refCompany.Height+Gap,100dip,20dip)
			Dim refStatusHeight As Int
			refStatusHeight =  su.MeasureMultilineTextHeight(refStatus,refStatus.Text)
			
			If refStatusHeight > refStatus.Height Then
				refStatus.Height = refStatusHeight
				ReferencePanel.Height = ReferenceHeight + Gap
			End If
			
'			Dim gd1 As GradientDrawable 
'			Dim cols(2) As Int 
'			cols(0) = statusRefColor
'			cols(1) = statusRefColor
'			
'			gd1.Initialize("TOP_BOTTOM", cols)
'			gd1.CornerRadius = 2dip
'			refStatus.Background = gd1
			
			
			'detailButton
			Dim sld As StateListDrawable
			Dim pressed As ColorDrawable
    		pressed.Initialize(Colors.RGB(255, 255, 255), 2dip)
			
			sld.Initialize
			sld.AddState(sld.State_Pressed,pressed)
			
			
			detailButton.Initialize("detailBtn") 
			detailButton.Typeface = font.awesome.FontAwesomeTypeface
			detailButton.Tag = userId
			detailButton.Text = "Detail Progress "&font.awesome.GetFontAwesomeIconByName("fa-arrow-right")
			detailButton.TextSize = JobTitle.TextSize / 1.4
			detailButton.TextColor = Colors.RGB(22,176,221)
			detailButton.Gravity = Gravity.CENTER
			detailButton.Background = sld
			
			'detailBtn
'			detailBtn.Initialize("detailBtn")
'			detailBtn.Typeface = FA.FontAwesomeTypeface
'			detailBtn.Tag = userId
'			detailBtn.Text = "Detail Progress "&FA.GetFontAwesomeIconByName("fa-arrow-right")
'			detailBtn.TextSize = JobTitle.TextSize / 1.4
'			detailBtn.TextColor = Colors.RGB(22,176,221)
'			detailBtn.Gravity = Gravity.CENTER
			'add to list
			detailList.Add(detailButton)
			
			'Log(ReferencePanel.Width)
			ReferencePanel.AddView(detailButton,(ReferencePanel.Width - 125dip)-Gap,refCompany.Top+refCompany.Height+5dip,125dip,35dip)
			
			ReferenceTop = ReferenceTop+ReferenceHeight+Gap
		Next
		
		Container.AddView(JoblistPanel,0,PanelTop,Container.Width,PanelHeight)
		PanelTop = PanelTop+PanelHeight+Gap
		PanelHeight = defaultPanelHeight
	Next
	
	'loadMoreColorDrawable
	Dim sld As StateListDrawable
	Dim pressed,enabled As ColorDrawable
	pressed.Initialize(Colors.RGB(105, 203, 231), 2dip)
	enabled.Initialize(Colors.RGB(22,176,221), 2dip)
	
	sld.Initialize
	sld.AddState(sld.State_Pressed,pressed)
	sld.AddState(sld.State_Enabled,enabled)
	
	loadMore.Initialize("loadMore")
	loadMore.Text = "Load More"
	loadMore.Background = sld
	loadMore.TextColor = Colors.White
	loadMore.Gravity = Gravity.CENTER
	loadMore.Tag = PanelTop
	Container.AddView(loadMore,(100%x-100dip)/2,PanelTop,100dip,40dip)
	
	Container.Height = PanelTop + 50dip
End Sub

Sub SearchItem_Click
	qAuth.Logout
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Sub loadMore_Click
	loadMore = Sender
	loadMore.Text = "Loading..."
	loadMore.Color = Colors.Gray
	Sleep(1200)
	loadMore.Visible = False
	LoopPanel(loadMore.Tag)
End Sub

Sub Sleep(ms As Long)
Dim now As Long
   If ms > 1000 Then ms =1000   'avoid application not responding error
   now=DateTime.Now
   Do Until (DateTime.Now>now+ms)
     DoEvents
   Loop
End Sub

Sub detailBtn_Click
	For i = 0 To detailList.Size - 1
		Dim detailBtn As Button
		detailBtn = detailList.Get(i)
		detailBtn = Sender
	Next
	
	'Msgbox(detailBtn.Tag&" Was Clicked","Button Clicked")
	ReferringProgress.userId = detailBtn.Tag
	StartActivity(ReferringProgress)
		
End Sub

Sub detailBtn_Down
	For i = 0 To detailList.Size - 1
		Dim detailBtn As Button
		detailBtn = detailList.Get(i)
		detailBtn = Sender
	Next
	
	detailBtn.TextColor = Colors.RGB(105, 203, 231)
End Sub

Sub detailBtn_Up
	For i = 0 To detailList.Size - 1
		Dim detailBtn As Button
		detailBtn = detailList.Get(i)
		detailBtn = Sender
	Next
	
	detailBtn.TextColor = Colors.RGB(22,176,221)
End Sub
