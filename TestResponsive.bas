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
	
End Sub

Sub Globals
    Dim ScrollView1 As ScrollView
    Dim lstChecks As List
    Dim height As Int
    height = 50dip
End Sub
Sub Activity_Create(FirstTime As Boolean)
    ScrollView1.Initialize(0)
    Dim pnl As Panel
    pnl = ScrollView1.Panel
    Activity.AddView(ScrollView1, 0, 0, 100%x, 100%y)
    lstChecks.Initialize
    
    For i = 1 To 100
        Dim chk As CheckBox
        chk.Initialize("mnuChecked")
        chk.Text = "Item #" & i
        lstChecks.Add(chk)
        Dim lbl1 As Label
        lbl1.Initialize("")
        lbl1.Text = "Value #" & i
        lbl1.Gravity = Gravity.CENTER_VERTICAL
        pnl.AddView(chk, 0, height * (i - 1), 120dip, height)
        pnl.AddView(lbl1, 125dip, height * (i - 1), 120dip, height)
    Next
    pnl.Height = lstChecks.Size * height
    Activity.AddMenuItem("Display checked", "mnuChecked")
End Sub

Sub mnuChecked_Click
    Dim sb As StringBuilder
    sb.Initialize
    For i = 0 To lstChecks.Size - 1
        Dim chk As CheckBox
        chk = lstChecks.Get(i)
        If chk.Checked Then
            sb.Append(i).Append(CRLF)
        End If
    Next
	Log(sb)
    Msgbox(sb.ToString, "Checked indices")
End Sub
