Type=Class
Version=5.8
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
'Class Auth module
Sub Class_Globals
	Dim manager As PreferenceManager
	Dim Act As Activity	
End Sub

'Initializes the object. You can add parameters to this method if needed.
Public Sub Initialize(aActivity As Activity)
	Act = aActivity
End Sub

Public Sub Login(email As EditText,password As EditText)
	Dim Job As HttpJob,bAuth As String
	
	bAuth = EncodeBasicAuth(email.Text,password.Text)
	
	'reset text
	email.Text = ""
	password.Text = ""
	
	Job.Initialize("Job1", Me)
    'Send a GET request
    Job.PostString("http://phalcon.puma.mylits.com/users/authenticate",Null)
	Job.Username = email.Text
	Job.Password = password.Text
	Job.GetRequest.SetContentType("application/json; charset=UTF-8")
	Job.GetRequest.SetHeader("Authorization", "Basic "&bAuth)
End Sub

Public Sub Logout()
	manager.SetBoolean("is_login", False)
	StartActivity(Main)	
	Act.Finish
	ToastMessageShow("Logout berhasil", False)
End Sub


Sub JobDone (Job As HttpJob)
   Dim JSON As JSONParser
   Log("JobName = " & Job.JobName & ", Success = " & Job.Success)
   
   If Job.Success = True Then
      Select Job.JobName
         Case "Job1"
            'print the result to the logs
			JSON.Initialize(Job.GetString)
			Dim root As Map = JSON.NextObject
			Dim data As Map = root.Get("data")
			Dim token As String = data.Get("token") 
			SetLoginSession(token)
            Log(token)
      End Select
   Else
      Log("Error: " & Job.ErrorMessage)
      ToastMessageShow("Error: " & Job.ErrorMessage, True)
   End If
   Job.Release
End Sub

Public Sub CheckLoginSession()
	Dim isLogin As Boolean
	isLogin = manager.GetBoolean("is_login")
	
	If isLogin Then
		StartActivity(ReferringList)
		Act.Finish
	End If
End Sub

Public Sub SetLoginSession(Token As String)
	manager.SetBoolean("is_login", True)
	manager.SetString("token",Token)
	StartActivity(ReferringList)
	Act.Finish
End Sub

Public Sub GetAccessToken()
	Return manager.GetString("token")
End Sub

Private Sub EncodeBasicAuth(username As String, password As String) As String
    Dim su As StringUtils,tempstr As String,bc As ByteConverter
	tempstr = username&":"&password
	Return su.EncodeBase64(bc.StringToBytes(tempstr,"utf-8"))
End Sub