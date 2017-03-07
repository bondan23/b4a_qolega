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
	
	Private bar As StdActionBar
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	'Activity.LoadLayout("Layout1")
	Activity.Title = "Candidate Progress"
	
	Container.Initialize("")
	Container.Color = Colors.RGB(219,219,219)
	Activity.AddView(Container,0,0,100%x,100%y)
	
	bar.Initialize("bar")
	bar.ShowUpIndicator = True
	LoopPanel
End Sub

Sub LoopPanel
	Dim jobTitlePanel,detailPanel,referencePanel,progressBox As Panel
	Dim PanelTop,IconTop,PanelHeight,ReferenceTop,ReferenceHeight,Gap,TextHeight As Int
	Dim jobTitle,utilText,refName,refCompany,refStatus,refText,detailBtn As Label
	
	
	'json
    JSON.Initialize(File.ReadString(File.DirAssets, "status_reference.json"))
	Dim root As Map = JSON.NextObject
	
	Dim dataName As String = root.Get("name")
	Dim dataCompany As String = root.Get("company")
	Dim dataJobtitle As String = root.Get("jobtitle")
	
	'Default Panel Top position
	PanelTop = 10dip
	'Default Panel height
	PanelHeight = 110dip
	'Default Gap
	Gap = 10dip
	
	detailPanel.Initialize("")
	detailPanel.Color = Colors.White
	Container.AddView(detailPanel,0,10dip,100%x,75dip)
	
	refName.Initialize("")
	refName.Text = dataName
	refName.TextColor = Colors.RGB(74,74,74)
	refName.Typeface = Typeface.DEFAULT_BOLD
	detailPanel.AddView(refName,10dip,10dip,detailPanel.Width-(Gap*2),50dip)
	TextHeight = su.MeasureMultilineTextHeight(refName,refName.Text)
	
	'refCompany
	refCompany.Initialize("")
	refCompany.Text = dataCompany
	refCompany.TextColor = Colors.RGB(179,179,179)
	detailPanel.AddView(refCompany,10dip,TextHeight+Gap,detailPanel.Width-(Gap*2),50dip)
	
	Dim utilTextW As Int = 100dip
	
	'show Candidate details text
	utilText.Initialize("")
	Container.AddView(utilText,0,detailPanel.Height,100%x,50dip)
	utilText.Text = "Show Candidate Text"
	utilText.Gravity = Gravity.CENTER
	
	jobTitlePanel.Initialize("")
	Container.AddView(jobTitlePanel,0,(detailPanel.Height+utilText.Height)-Gap,100%x,50dip)
	jobTitlePanel.Color = Colors.White

	jobTitle.Initialize("")
	jobTitle.Text = "Referal Progress for "&dataJobtitle
	jobTitle.TextColor = Colors.RGB(74,74,74)
	jobTitlePanel.AddView(jobTitle,10dip,6dip,jobTitlePanel.Width - (10dip*2),jobTitlePanel.Height)
	
	scrollView.Initialize(Activity.Height)
	scrollView.Color = Colors.White
	Container.AddView(scrollView,0,(detailPanel.Height+utilText.Height+jobTitlePanel.Height-10dip),100%x,100%y)
	detailPanel = scrollView.Panel
	
	PanelTop = 0
	IconTop = 12dip
	
	Dim journeys As List = root.Get("journeys") 
	Dim iterator As Int = 1
	
	For Each coljourneys As Map In journeys
		Dim journeyText As String = coljourneys.Get("text")
		
		progressBox.Initialize("")
		detailPanel.AddView(progressBox,30dip,PanelTop,100%x-(30dip*2),40dip)
		If iterator < journeys.size Then
			DrawLeftBorder(progressBox,Colors.RGB(151,151,151),2dip,False)
		Else 
			DrawLeftBorder(progressBox,Colors.RGB(151,151,151),2dip,True)
		End If
		
		'Icon
		Dim statusIcon As ImageView
		statusIcon.Initialize("")
		statusIcon.Bitmap = LoadBitmap(File.DirAssets,"checked.png")
		detailPanel.AddView(statusIcon,24dip,IconTop,16dip,16dip)
		
		refStatus.Initialize("")
		refStatus.Text = "Qualifying"
		refStatus.Color =  Colors.RGB(249,191,55)
		refStatus.TextColor = Colors.White
		refStatus.Gravity = Gravity.CENTER
		progressBox.AddView(refStatus,15dip,10dip,100dip,20dip)
		
		refText.Initialize("")
		refText.Text = journeyText
		refText.TextSize = 12
		progressBox.AddView(refText,refStatus.Width+(Gap*2)+5,10dip,progressBox.Width/2,100%y)
		Dim tHeight As Int
		
		tHeight =  su.MeasureMultilineTextHeight(refText,refText.Text)
		
		'Update Height to make it fit
		If progressBox.Height < tHeight Then
			progressBox.Height = tHeight
			PanelTop = PanelTop + tHeight
			IconTop = IconTop + tHeight
		Else
			PanelTop = PanelTop + progressBox.Height
			IconTop = IconTop + progressBox.Height
		End If
		iterator = iterator + 1
		
		Log(PanelTop)
	Next
	'Modifying scrollview height
	detailPanel.Height = PanelTop+(PanelTop/journeys.size)+(Gap*2)+(Gap*journeys.size)
	
'	progressBox.Initialize("")
'	detailPanel.AddView(progressBox,30dip,0,100%x-(30dip*2),80dip)
'	DrawLeftBorder(progressBox,Colors.RGB(151,151,151),2dip)
'	
'	'Icon
'	Dim statusIcon As ImageView
'	statusIcon.Initialize("")
'	statusIcon.Bitmap = LoadBitmap(File.DirAssets,"checked.png")
'	detailPanel.AddView(statusIcon,24dip,12dip,16dip,16dip)
'	
'	refStatus.Initialize("")
'	refStatus.Text = "Qualifying"
'	refStatus.Color =  Colors.RGB(249,191,55)
'	refStatus.TextColor = Colors.White
'	refStatus.Gravity = Gravity.CENTER
'	progressBox.AddView(refStatus,15dip,10dip,100dip,20dip)
'	
'	refText.Initialize("")
'	refText.Text = "Nam dapibus nisl vitae elit fringilla rutrum. Aenean sollicitudin, erat a elementum rutrum.Nam dapibus nisl vitae elit fringilla rutrum. Aenean sollicitudin, erat a elementum rutrum"
'	refText.TextSize = 12
'	progressBox.AddView(refText,refStatus.Width+(Gap*2)+5,10dip,progressBox.Width/2,100%y)
'	Dim tHeight As Int
'	tHeight =  su.MeasureMultilineTextHeight(refText,refText.Text)
'	'Update Height to make it fit
'	progressBox.Height = tHeight
	
	
End Sub

Sub Activity_ActionBarHomeClick
	Activity.Finish
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Public Sub DrawLeftBorder(Target As View, aColor As Int, StrokeWidth As Int,Last As Boolean)
   Dim c As Canvas
   c.Initialize(Target)
   Dim Path1 As Path
   Path1.Initialize(0,0)
   
   If Last == True Then
    Path1.LineTo(0,Target.Top)
   Else
   	Path1.LineTo(0,Target.Height)
   End If
   
   c.DrawPath(Path1, aColor, False, StrokeWidth)
   Target.Invalidate
End Sub

Sub AreEqual(b1 As Int, b2 As Int) As Boolean
 If b1 <> b2 Then Return False
 Return True
End Sub
