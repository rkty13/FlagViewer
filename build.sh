#!/bin/sh
rm -f *.class *.jar
javac -sourcepath src -d bin src/FlagViewer.java
jar -cfm FlagViewer.jar MainClass resources -C bin/ .