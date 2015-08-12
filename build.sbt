// Turn this project into a Scala.js project by importing these settings
//import com.lihaoyi.workbench.Plugin._

lazy val root = (project in file(".")).enablePlugins(ScalaJSPlugin)
workbenchSettings

// Name is a prefix in the object code filename.
name := "Scala.JS Barebone"
scalaVersion := "2.11.7"

// Optional, necessary to sbt run, needs phantomJS to be installed.
jsDependencies += RuntimeDOM
scalaJSStage in Global := FastOptStage

libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % "0.8.1",
  "com.lihaoyi" %%% "scalatags" % "0.5.2",
  "be.doeraene" %%% "scalajs-jquery" % "0.8.0"
)
skip in packageJSDependencies := false // All JavaScript dependencies to be concatenated to a single file

// Workbench has to know how to restart your application.
bootSnippet := "example.ScalaJSExample().showDetail(document.getElementById('content'));"
// Update without refreshing the page every time fastOptJS completes
updateBrowsers <<= updateBrowsers.triggeredBy(fastOptJS in Compile)
