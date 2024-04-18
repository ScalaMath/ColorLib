// Project info
name := "ColorLib"
organization := "io.github.scalamath"
version := "1.0"
description := "A Scala library for color math"
// Project scala version
scalaVersion := "2.13.12"

// VecMatLib dependency
libraryDependencies += "io.github.scalamath" % "vecmatlib" % "3.0"
// Scala test dependency
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.18" % Test
// Junit test dependency
libraryDependencies += "com.github.sbt" % "junit-interface" % "0.13.3" % Test

// Needed to run Java Junit tests
crossPaths := true

// Show deprecation warnings
scalacOptions ++= Seq("-unchecked", "-deprecation")