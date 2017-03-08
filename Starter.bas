Type=Service
Version=5.8
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
#Region  Service Attributes 
	#StartAtBoot: True
	#ExcludeFromLibrary: True
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
	Private gHttpVersionJob,updateApp As HttpJob
    Public getVersion As String  = "https://bondan.biz/android/version.json"
    Public downloadAppUrl As String  = "https://bondan.biz/android/Qolega.apk"
End Sub

Sub Service_Create
	Dim manager As PreferenceManager
	'This is the program entry point.
	'This is a good place to load resources that are not specific to a single activity.
	Dim isLogin As Boolean = manager.GetBoolean("is_login")
	
	'Running version check before user login
	If AreEqual(isLogin,False) Then
		ToastMessageShow("Checking Version...",False)
		
		'Running version check
		gHttpVersionJob.Initialize("version_check", Me)
		gHttpVersionJob.Download(getVersion)
	End If
End Sub

Sub Service_Start (StartingIntent As Intent)

End Sub


Sub JobDone (Job As HttpJob)
	Dim version As String = Application.VersionName
	Log("JobName = " & Job.JobName & ", Success = " & Job.Success)
	If  Job.Success Then
		Select Job.JobName
			Case "version_check"
				Dim parser As JSONParser 
				parser.Initialize(Job.GetString) 
				Dim root As Map = parser.NextObject 
				Dim currentversion As String = root.Get("version") 
				
				If File.Exists(File.DirRootExternal , "/Qolega.apk") = True Then
                	File.Delete(File.DirRootExternal,"/Qolega.apk")
					Log("delete file")
            	End If
				
				If version < currentversion Then
					'Download new version
					Log("Download new Version")
					
					CallSubDelayed(Main,"showUpdateDialog")
'					updateApp.Initialize("download_app",Me)
'					updateApp.Download(downloadAppUrl)
				End If		
			Case "download_app"
				Dim OutStream As OutputStream
				OutStream = File.OpenOutput(File.DirRootExternal, "/Qolega.apk", False) 
				File.Copy2(Job.GetInputStream,OutStream)
				OutStream.Close
				
				ToastMessageShow("Download Complete, Now Installing.!", True)
				
				Dim iIntent As Intent
		        Dim k As String="file://" & File.DirRootExternal & "/Qolega.apk"
		        Log(k)
		        iIntent.Initialize(iIntent.ACTION_VIEW,k)
		        iIntent.SetType("application/vnd.android.package-archive")
		        StartActivity(iIntent)
		End Select
	End If          
End Sub

'Return true to allow the OS default exceptions handler to handle the uncaught exception.
Sub Application_Error (Error As Exception, StackTrace As String) As Boolean
	Return True
End Sub

Sub Service_Destroy

End Sub

Sub AreEqual(b1 As Boolean, b2 As Boolean) As Boolean
 If b1 <> b2 Then Return False
 Return True
End Sub
