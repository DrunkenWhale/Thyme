name := "Thyme"

version := "0.0.2"

scalaVersion := "2.13.7"

exportJars:= true

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

val AkkaVersion = "2.6.17"
val AkkaHttpVersion = "10.2.7"


libraryDependencies ++= Seq(
    "org.scala-lang" % "scala-library" % "2.13.6",
    "org.scala-lang" % "scala-reflect" % "2.13.6",
    "com.typesafe.akka" %% "akka-actor-typed" % AkkaVersion,
    "com.typesafe.akka" %% "akka-stream" % AkkaVersion,
    "com.typesafe.akka" %% "akka-http" % AkkaHttpVersion,
    "com.typesafe.akka" %% "akka-slf4j" % AkkaVersion,
    "com.typesafe.akka" %% "akka-http-spray-json" % AkkaHttpVersion,
    //    "org.squeryl" %% "squeryl" % "0.9.16",
    "ch.qos.logback" % "logback-classic" % "1.2.7"
)


