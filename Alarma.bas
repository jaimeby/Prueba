B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Service
Version=9.801
@EndOfDesignText@
#Region  Service Attributes 
	#StartAtBoot: False
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
	'nueva linea de comentario
	Dim mp As MediaPlayer
End Sub

Sub Service_Create

End Sub

Sub Service_Start (StartingIntent As Intent)
	mp.Initialize()
	PlayAlarm
	ToastMessageShow("Tienes Restricción vehicular",True)
End Sub

Sub Service_Destroy
	StopService("")
	CancelScheduledService("")
End Sub

Sub PlayAlarm
	mp.Load(File.DirAssets, "alarma.mp3")
	mp.Play
End Sub