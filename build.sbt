// Project info
name := "ColorLib"
homepage := Some(url("https://github.com/ScalaMath/ColorLib"))
version := "1.1"
description := "A Scala library for color math"
// Organization info
organization := "io.github.scalamath"
organizationName := "ScalaMath"
organizationHomepage := Some(url("https://github.com/ScalaMath"))
// Project scala version
scalaVersion := "2.13.12"

// Do not append the scala version to the generated artifact
crossPaths := false

// VecMatLib dependency
libraryDependencies += "io.github.scalamath" % "vecmatlib" % "3.0"

// Scala test dependency
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.18" % Test
// Junit test dependency
libraryDependencies += "com.github.sbt" % "junit-interface" % "0.13.3" % Test

// Show deprecation warnings
scalacOptions ++= Seq("-unchecked", "-deprecation")

// Publish info
scmInfo := Some(
  ScmInfo(
    url("https://github.com/ScalaMath/ColorLib"),
    "scm:git@github.com:ScalaMath/ColorLib.git"
  )
)

// Developer info
developers := List(
  Developer(
    id = "HexagonNico",
    name = "Nicholas Amigoni",
    email = "nico.hex6@gmail.com",
    url = url("https://hexagonnico.github.io")
  )
)

// Project license
licenses := List(
  "Apache 2" -> new URL("https://www.apache.org/licenses/LICENSE-2.0.txt")
)

// Publish to local repository
pomIncludeRepository := { _ => false }
publishTo := Some(Resolver.file("local-ivy", file(Path.userHome + "/.ivy2")))
publishMavenStyle := true
