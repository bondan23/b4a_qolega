Type=Class
Version=5.8
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
'Class Auth module
Sub Class_Globals
	Dim manager As PreferenceManager
	Dim Act As Activity	
	Private urlApi,clientSecret,clientId As String
End Sub

'Initializes the object. You can add parameters to this method if needed.
Public Sub Initialize(aActivity As Activity)
	Act = aActivity
	urlApi = "http://gandalf.x.testing.jobs.id/oauth/token"
	clientSecret = "88HWC8Pjv8UmTcWmnlruBCaTLdnkD2"
	clientId = "ZA87YCXLY5"
End Sub

Public Sub Login(email As EditText,password As EditText)
	Dim Job As HttpJob,bAuth,parameter As String
	
	'bAuth = EncodeBasicAuth(email.Text,password.Text)
	
	parameter = "grant_type=password&client_id="&clientId&"&client_secret="&clientSecret&"&username="&email.Text&"&password="&password.Text
	
	'reset text
	email.Text = ""
	password.Text = ""
	
	ProgressDialogShow2("Logged In",False)	
	Job.Initialize("Job1", Me)
    'Send a Post request
	Job.PostString(urlApi,parameter)
'    Job.PostString("http://phalcon.puma.mylits.com/users/authenticate",Null)
'	Job.Username = email.Text
'	Job.Password = password.Text
'	Job.GetRequest.SetContentType("application/json; charset=UTF-8")
'	Job.GetRequest.SetHeader("Authorization", "Basic "&bAuth)
End Sub

Public Sub Logout()
	manager.ClearAll
	StartActivity(Main)	
	Act.Finish
	ToastMessageShow("Logout berhasil", False)
End Sub

Sub JobDone (Job As HttpJob)
   Dim JSON As JSONParser
   Log("JobName = " & Job.JobName & ", Success = " & Job.Success)
   ProgressDialogHide
   If Job.Success = True Then
      Select Job.JobName
         Case "Job1"
            'print the result to the logs
			Log(Job.GetString)
			JSON.Initialize(Job.GetString)
			Dim root As Map = JSON.NextObject 
			Dim access_token As String = root.Get("access_token") 
			Dim refresh_token As String = root.Get("refresh_token") 
			Dim headhunter As Map = root.Get("headhunter") 
			Dim name As String = headhunter.Get("name") 
			Dim email As String = headhunter.Get("email") 
			Dim id As Int = headhunter.Get("id") 
			SetLoginSession(access_token,id,name,email)
      End Select
   Else
   	  Try
	  	 JSON.Initialize(Job.ErrorMessage)
		  Dim root As Map = JSON.NextObject
		  Dim error_description As String = root.Get("error_description") 
		  Dim error As String = root.Get("error") 	
	      ToastMessageShow(error_description,True)
	  Catch
	  	  Log(LastException)
	  End Try
   End If
   Job.Release
End Sub

Public Sub CheckLoginSession()
	Dim isLogin As Boolean
	isLogin = manager.GetBoolean("is_login")
	
	If isLogin = True Then
		StartActivity(ReferringList)
		Act.Finish
	End If
End Sub

Public Sub SetLoginSession(Token As String,id As Int,name As String,email As String)
	manager.SetBoolean("is_login", True)
	manager.SetString("token",Token)
	manager.SetString("name",name)
	manager.SetString("email",email)
	manager.SetString("id",id)
	StartActivity(ReferringList)
End Sub

Public Sub GetAccessToken()
	Return manager.GetString("token")
End Sub

Public Sub GetStore(Index As String)
	Return manager.GetString(Index)
End Sub

Private Sub EncodeBasicAuth(username As String, password As String) As String
    Dim su As StringUtils,tempstr As String,bc As ByteConverter
	tempstr = username&":"&password
	Return su.EncodeBase64(bc.StringToBytes(tempstr,"utf-8"))
End Sub