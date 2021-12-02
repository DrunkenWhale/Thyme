name := "Thyme"

version := "0.1"

scalaVersion := "2.13.7"


val AkkaVersion = "2.6.17"
val AkkaHttpVersion = "10.2.7"
libraryDependencies ++= Seq(
    "com.typesafe.akka" %% "akka-actor-typed" % AkkaVersion,
    "com.typesafe.akka" %% "akka-stream" % AkkaVersion,
    "com.typesafe.akka" %% "akka-http" % AkkaHttpVersion,
    "com.typesafe.akka" %% "akka-slf4j" % AkkaVersion,
    "com.typesafe.akka" %% "akka-http-spray-json" % AkkaHttpVersion,
    "ch.qos.logback" % "logback-classic" % "1.2.7"
)