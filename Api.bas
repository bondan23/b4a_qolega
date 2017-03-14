Type=Class
Version=5.8
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
'Class Api module
Sub Class_Globals
	Dim apiUrl = "http://gandalf.x.testing.jobs.id" As String
	Dim result As String
	Dim Job As HttpJob
End Sub

'Initializes the object. You can add parameters to this method if needed.
Public Sub Initialize(name As String,this As Object)
	Job.Initialize(name,this)
End Sub

Public Sub Get(Endpoint As String)
	Job.Download(apiUrl&Endpoint)
End Sub

Public Sub Post(EndPoint As String)
	
End Sub