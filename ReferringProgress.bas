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
	'Id From referringList
	Public userId As Int
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
	Dim scrollView As ScrollView
	Dim JSON As JSONParser
	Dim su As StringUtils
	Dim Container As Panel
	Dim font As Fonts
	Private bar As StdActionBar
	Dim detailList As List
	
	Type RowCol (Row As Int, Col As Int)
	Dim showIcon,closeIcon As ImageView
End Sub

Sub Activity_Create(FirstTime As Boolean)
	font.Initialize
	'Do not forget to load the layout file created with the visual designer. For example:
	'Activity.LoadLayout("Layout1")
	Activity.Title = "Candidate Progress"
	
	Container.Initialize("")
	Container.Color = Colors.RGB(245,245,245)
	Activity.AddView(Container,0,0,100%x,100%y)
	
	bar.Initialize("bar")
	bar.ShowUpIndicator = True
	
	detailList.Initialize
	LoopPanel
End Sub

Sub LoopPanel
	Dim jobTitlePanel,detailPanel,journeyPanel,referencePanel,progressBox As Panel
	Dim PanelTop,IconTop,PanelHeight,ReferenceTop,ReferenceHeight,Gap,TextHeight As Int
	Dim jobTitle,utilText,refName,refCompany,refStatus,refText,detailBtn As Label
	
	Dim refDetWrapper As Panel
	
	Dim userIcon As ImageView
	
	'json
    JSON.Initialize(File.ReadString(File.DirAssets, "status_reference.json"))
	Dim roots As List = JSON.NextArray
	Dim root As Map = roots.Get(userId)
	
	Dim dataName As String = root.Get("name")
	Dim dataCompany As String = root.Get("company")
	Dim dataLatestPos As String = root.Get("latest_position")
	Dim dataPhoneNum As String = root.Get("phone_number")
	Dim dataUrl As String = root.Get("linkedin_url")
	Dim dataEmail As String = root.Get("email")
	Dim dataNote As String = root.Get("note")
	Dim dataJobtitle As String = root.Get("job_title")
	
	'Default Panel Top position
	PanelTop = 10dip
	'Default Panel height
	PanelHeight = 110dip
	'Default Gap
	Gap = 10dip
	
	detailPanel.Initialize("")
	detailPanel.Color = Colors.White
	Container.AddView(detailPanel,0,10dip,100%x,70dip)
	
	
	'Icon
	userIcon.Initialize("")
	userIcon.Bitmap = LoadBitmap(File.DirAssets,"user.png")
	userIcon.Gravity = Gravity.FILL
	refName.Initialize("")
	refName.Text = dataName
	refName.TextColor = Colors.RGB(74,74,74)
'	refName.TextSize = 14dip
	refName.Typeface = font.proximanovaSemiBold
	

	detailPanel.AddView(userIcon,10dip,10dip,24dip,24dip)
	detailPanel.AddView(refName,38dip,12dip,detailPanel.Width-(38dip*2),20dip)
	
	'refCompany
	refCompany.Initialize("")
	refCompany.Text = dataCompany
	refCompany.TextColor = Colors.RGB(179,179,179)
'	refCompany.TextSize = 12dip
	refCompany.Typeface = font.proximanovaRegular
	detailPanel.AddView(refCompany,38dip,refName.Top+refName.Height,detailPanel.Width-(38*2),20dip)
	
	
	'detailWrapper
	refDetWrapper.Initialize("")
	detailPanel.AddView(refDetWrapper,10dip,refCompany.Top+refCompany.Height+Gap*2,detailPanel.Width-20dip,100%y)
	DrawBorderTop(refDetWrapper,Colors.RGB(219,219,219),2dip)
	
	'detailContent
	Dim detEmail,detPhoneNumber,detLatestComp,detLastPos,detLinkedInUrl,detNote As Label
	
'	detEmail.Initialize("")
'	detEmail.Text = dataEmail
'	refDetWrapper.AddView(detEmail,0,0,100dip,20dip)
	
	Dim textList,valueList As List
	textList.Initialize
	textList.AddAll(Array As String("Email", "Phone Number", "Latest Company", "Latest Position", "LinkedIn URL","Note"))
	valueList.Initialize
	valueList.AddAll(Array As String(dataEmail,dataPhoneNum,dataCompany,dataLatestPos,dataUrl,dataNote))
	Dim topPos As Int
	topPos = 20dip
	
	For i=0 To textList.Size -1 
		Dim l,ll,lll As Label
		l.Initialize("cell")
		l.Text = textList.Get(i)
		l.Typeface = font.proximanovaRegular
		l.TextColor = Colors.RGB(179,179,179)
		'add text
		refDetWrapper.AddView(l,0,topPos,120dip,20dip)
		'add :
		ll.Initialize("cell2")
		ll.Text = ":"
		ll.Typeface = font.proximanovaRegular
		ll.TextColor = Colors.RGB(179,179,179)
		refDetWrapper.AddView(ll,l.Width,topPos,10dip,20dip)
		'add val
		lll.Initialize("cell3")
		
		If i > 0 Then
			lll.TextColor = Colors.RGB(74,74,74)
		Else	
			lll.TextColor = Colors.RGB(179,179,179)
		End If
		
		lll.Typeface = font.proximanovaRegular
		If valueList.Get(i) = "" Then
			lll.Text = "-"
		Else
			lll.Text = valueList.Get(i)
		End If
		refDetWrapper.AddView(lll,l.Width+ll.Width+Gap,topPos,100%x/2,-2)
		Dim x As Int
		x = su.MeasureMultilineTextHeight(lll,lll.Text)
		
		topPos = topPos + x + Gap
	Next
	
	
	'Add Object detailPanel
	detailList.Add(detailPanel)
	
	'showIcon(Open)
	showIcon.Initialize("showIcon")
	showIcon.Bitmap = LoadBitmap(File.DirAssets,"Show.png")
	showIcon.Gravity = Gravity.FILL
	Container.AddView(showIcon,(detailPanel.Width/2)-15dip,detailPanel.Height-5dip,30dip,30dip)
	
	'closeIcon(Close)
	closeIcon.Initialize("closeIcon")
	closeIcon.Bitmap = LoadBitmap(File.DirAssets,"Close.png")
	closeIcon.Visible = False
	closeIcon.Gravity = Gravity.FILL
	Container.AddView(closeIcon,(detailPanel.Width/2)-15dip,detailPanel.Height-5dip,30dip,30dip)
	
	Dim utilTextW As Int = 100dip
	
	'show Candidate details text
	utilText.Initialize("")
	Container.AddView(utilText,0,detailPanel.Height,100%x,70dip)
	utilText.TextColor = Colors.RGB(179,179,179)
	utilText.Text = "Show candidate details"
	utilText.Gravity = Gravity.CENTER
	
	'Add Object JobtitlePanel
	detailList.Add(utilText)
	
	
	'JobtitlePanel
	jobTitlePanel.Initialize("")
	Container.AddView(jobTitlePanel,0,(detailPanel.Height+utilText.Height)-Gap,100%x,100dip)
	jobTitlePanel.Color = Colors.White
	
	'Add Object JobtitlePanel
	detailList.Add(jobTitlePanel)

	jobTitle.Initialize("")
	jobTitle.Text = "Referal Progress for "&dataJobtitle
'	jobTitle.TextSize = 14dip
	jobTitle.TextColor = Colors.RGB(74,74,74)
	jobTitlePanel.AddView(jobTitle,10dip,6dip,jobTitlePanel.Width - (10dip*2),jobTitlePanel.Height)
	Dim titleHeight As Int
	titleHeight = su.MeasureMultilineTextHeight(jobTitle,jobTitle.Text)
	'Reload height
	jobTitlePanel.Height = titleHeight + 20dip
	
	scrollView.Initialize(Activity.Height)
	scrollView.Color = Colors.White
	Container.AddView(scrollView,0,(detailPanel.Height+utilText.Height+jobTitlePanel.Height-10dip),100%x,100%y)
	journeyPanel = scrollView.Panel
	
	'Add Object journeyPanel
	detailList.Add(journeyPanel)
	
	Dim referenceWrapper As Panel
	referenceWrapper.Initialize("")

	PanelTop = 0
	IconTop = 12dip
	
	Dim journeys As List = root.Get("journeys") 
	Dim iterator As Int = 1
	Dim LastIconTop As Int
	Dim IncrementBoxHeight As Int
	Dim BoxHeight As Int = 40dip
	
	journeyPanel.AddView(referenceWrapper,30dip,PanelTop,100%x-(30dip*2),BoxHeight)
	
	For Each coljourneys As Map In journeys
		Dim journeyText As String = coljourneys.Get("text")
		Dim rStatus As Int = coljourneys.Get("status")
		Dim rStatusText As String = coljourneys.Get("status_text")
		Dim rState As Int = coljourneys.Get("state")
		
		progressBox.Initialize("")
		'progressBox.Color = Colors.Cyan
		journeyPanel.AddView(progressBox,30dip,PanelTop,100%x-(30dip*2),BoxHeight)
		
		Dim iconName As String
		Select rState
			Case 0
				iconName = "Progress.png"
			Case 1
				iconName = "Done.png"
			Case 2
				iconName = "Fail.png"
		End Select
		
		'Icon
		Dim statusIcon As ImageView
		statusIcon.Initialize("")
		statusIcon.Bitmap = LoadBitmap(File.DirAssets,iconName)
		statusIcon.Gravity = Gravity.FILL
		journeyPanel.AddView(statusIcon,30dip-7.5dip,IconTop,16dip,16dip)
		
		'refStatus
		If rStatus <> 0 Then
			Dim cd As ColorDrawable
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
			
			refStatus.TextColor = Colors.White
	'		refStatus.TextSize = 10dip
			refStatus.Text = rStatusText
			refStatus.Typeface = font.proximanovaSemiBold
			refStatus.Gravity = Gravity.CENTER
			progressBox.AddView(refStatus,15dip,10dip,100dip,20dip)
			Dim refStatusHeight As Int
			refStatusHeight =  su.MeasureMultilineTextHeight(refStatus,refStatus.Text)
			
			If refStatusHeight > refStatus.Height Then
			refStatus.Height = refStatusHeight
			End If
		End If
		
		'refText
		refText.Initialize("")
		refText.Text = journeyText
		refText.Typeface = font.proximanovaRegular
		
		If rStatus = 0 Then
			progressBox.AddView(refText,15dip,13.5dip,progressBox.Width-30dip,20dip)
		Else
			progressBox.AddView(refText,refStatus.Left+refStatus.Width+Gap,10dip,progressBox.Width/2,20dip)
		End If
		
		'measure text height, get value, and update to progressBox
		Dim TextHeight As Int
		TextHeight =  su.MeasureMultilineTextHeight(refText,refText.Text)
		
		If refText.Height < TextHeight Then
			'progressBox.Height = progressBox.Height + TextHeight
			refText.Height = TextHeight
			If progressBox.Height < TextHeight+refText.Top Then
				Dim addHeight As Int = (TextHeight+refText.Top)-progressBox.Height
				progressBox.Height = progressBox.Height + addHeight + refText.Top
			End If
		End If
		
		'Utility
		IconTop = IconTop + progressBox.Height + Gap
		PanelTop = PanelTop + progressBox.Height + Gap
		LastIconTop = statusIcon.Top
	Next
	
	journeyPanel.Height = PanelTop + scrollView.Top
	
	referenceWrapper.Height = LastIconTop
	DrawDashLine(referenceWrapper,0,0,0,referenceWrapper.Height,Colors.RGB(177,177,177),4dip)
	
End Sub

Sub Activity_ActionBarHomeClick
	Activity.Finish
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Public Sub DrawLeftBorder(Target As View, aColor As Int, StrokeWidth As Int,Last As Boolean,Single As Boolean)
   Dim c As Canvas
   c.Initialize(Target)
   Dim Path1 As Path
   Path1.Initialize(0,0)
   
   If Last == True Then
    'Path1.LineTo(0,Target.Height)
   Else
   	If Single == True Then
		'Todo Make Line if Single
	Else
   		Path1.LineTo(0,Target.Height)
	End If
   End If
   
   c.DrawPath(Path1, aColor, False, StrokeWidth)
   Target.Invalidate
End Sub

Sub showIcon_Click
	Dim detailPanel,jobTitlePanel,journeyPanel As Panel
	Dim utilTextLabel As Label
	
	detailPanel = detailList.Get(0)
	utilTextLabel = detailList.Get(1)
	jobTitlePanel = detailList.Get(2)
	journeyPanel = detailList.Get(3)
	
	detailPanel.Height = detailPanel.Height + 200dip
	utilTextLabel.Top = detailPanel.Height
	utilTextLabel.Text = "Hide candidate details"
	jobTitlePanel.Top = utilTextLabel.Top + utilTextLabel.Height
	scrollView.Top = jobTitlePanel.Top + jobTitlePanel.Height
	journeyPanel.Height = journeyPanel.Height + jobTitlePanel.Top + jobTitlePanel.Height
	
	showIcon.Visible = False
	
	closeIcon.Top = detailPanel.Height - 5dip
	closeIcon.Visible = True
End Sub

Sub closeIcon_Click
	Dim detailPanel,jobTitlePanel,journeyPanel As Panel
	Dim utilTextLabel As Label
	
	detailPanel = detailList.Get(0)
	utilTextLabel = detailList.Get(1)
	jobTitlePanel = detailList.Get(2)
	journeyPanel = detailList.Get(3)
	
	detailPanel.Height = detailPanel.Height - 200dip
	utilTextLabel.Top = detailPanel.Height
	utilTextLabel.Text = "Show candidate details"
	jobTitlePanel.Top = utilTextLabel.Top + utilTextLabel.Height
	scrollView.Top = jobTitlePanel.Top + jobTitlePanel.Height
	journeyPanel.Height = journeyPanel.Height - jobTitlePanel.Top + jobTitlePanel.Height
	
	'detailPanel.Height = detailPanel.Height
	'utilTextLabel.Top = detailPanel.Height
	
	showIcon.Visible = True
	closeIcon.Visible = False
End Sub


Sub DrawDashLine(Target As View,x1 As Float, y1 As Float, x2 As Float, y2 As Float, col As Int, Stroke As Float)
    Dim p As ABPaint
	Dim ExtDrawing As ABExtDrawing
	Dim cvsMain As Canvas
	
	cvsMain.Initialize(Target)
	
    p.Initialize
    p.SetStrokeWidth(Stroke)
    p.SetStyle(p.Style_STROKE)
    p.SetColor(col)
    p.SetDashPathEffect(1, Array As Float(2dip, 2dip), 0)
    p.DoPathEffectSingle(1)
    ExtDrawing.DrawLine(cvsMain, x1, y1, x2, y2, p)
End Sub

Sub DrawBorderTop(Target As View,aColor As Int,StrokeWidth As Int)
	Dim c As Canvas
	c.Initialize(Target)
	Dim Path As Path
	Path.Initialize(0,0)
	Path.LineTo(Target.Width,0)
	c.DrawPath(Path,aColor,False,StrokeWidth)
	Target.Invalidate
End Sub

Sub AreEqual(b1 As Int, b2 As Int) As Boolean
 If b1 <> b2 Then Return False
 Return True
End Sub
