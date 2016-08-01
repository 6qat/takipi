name := """takipi-app"""

version := "1.0"

scalaVersion := "2.11.8"

val akkaVersion = "2.4.2"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-testkit" % akkaVersion % "test",
  "org.scalatest" %% "scalatest" % "2.2.4" % "test")

enablePlugins(JavaAppPackaging)

enablePlugins(DockerPlugin)

// The Dockerfile in this current directory generates this image, which contains TakipiAgent
dockerBaseImage := "takipi-base-image:latest"

bashScriptExtraDefines += """addJava "-agentlib:TakipiAgent""""
bashScriptExtraDefines += """addJava "-Dtakipi.sources.path=/home/guiga/tapechart/server/src/main/scala""""

