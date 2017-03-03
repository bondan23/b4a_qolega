Type=Class
Version=5.8
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
Sub Class_Globals
	Dim hc As HttpClient
	Dim hr As HttpRequest
End Sub


Public Sub Initialize(data As String) 
	
		
		hr.InitializePost2("https://onesignal.com/api/v1/players",data.GetBytes("UTF8"))

		hr.Timeout = 10000 
		hc.Initialize("hc")
		hc.Execute(hr, 1)

		
End Sub

Sub opened(nfid As String)
	Dim a As String
	a = "opened=true&app_id="&Main.applicationId
	hr.InitializePut2("https://onesignal.com/api/v1/notifications/"&nfid,a.GetBytes("UTF8"))
	hr.SetContentType("application/x-www-form-urlencoded")

		hr.Timeout = 10000 
		hc.Initialize("hc")
		hc.Execute(hr, 5)

End Sub



Sub hc_ResponseSuccess (Response As HttpResponse, TaskId As Int)
	Log("Token uploaded successfully.")
End Sub
Sub hc_ResponseError (Response As HttpResponse, Reason As String, StatusCode As Int, TaskId As Int)
	 Log("Error uploading token")
	 Log(Response.GetString)
End Sub
