Type=Class
Version=5.8
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@

Sub Class_Globals
	Dim semiBold As Typeface
	Dim regular As Typeface
	Dim light As Typeface
End Sub

'Initializes the object. You can add parameters to this method if needed.
Public Sub Initialize
	semiBold = Typeface.LoadFromAssets("fonts/proximanova-semibold.ttf")
	regular = Typeface.LoadFromAssets("fonts/proximanova-regular.ttf")
	light = Typeface.LoadFromAssets("fonts/proximanova-light.ttf")
End Sub

Public Sub proximanovaSemiBold() As Typeface
	Return semiBold
End Sub

Public Sub proximanovaRegular() As Typeface
	Return regular
End Sub

Public Sub proximanovaLight() As Typeface
	Return light
End Sub