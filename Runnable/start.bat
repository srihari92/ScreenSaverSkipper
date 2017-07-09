@echo off
if not DEFINED IS_MINIMIZED set IS_MINIMIZED=1 && start "" /min "%~dpnx0" %* && exit
echo close this window to exit ScreenSaverSkipper app
java -jar ScreenSaverSkipper.jar
exit
