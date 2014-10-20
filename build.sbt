name := """playaround"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.1"


fullResolvers := Seq(
  "Local Maven Repository" at "file://" + Path.userHome.absolutePath + "/.m2/repository",
  "Central Maven Repository" at "https://repo1.maven.org/maven2/"
)


libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  ws
)
