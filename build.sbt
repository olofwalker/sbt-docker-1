val ScalaVersion = "2.12"

lazy val root = (project in file("."))
  .enablePlugins(SbtPlugin, BintrayPlugin)
  .settings(
    name := "sbt-docker",
    scriptedLaunchOpts := {
      scriptedLaunchOpts.value ++
        Seq("-Xmx1024M", "-Dplugin.version=" + version.value)
    },
    scriptedBufferLog := false,
    sbtPlugin := true,
    crossScalaVersions := Vector(scalaVersion.value),
    publishMavenStyle := false,
    organization := "com.lightbend.cloudflow",
    bintrayOrganization := Some("lightbend"),
    bintrayRepository := "cloudflow",
    publishConfiguration := publishConfiguration.value.withOverwrite(true),
    libraryDependencies ++=
      Seq(
        "org.scalatest" %% "scalatest" % "3.2.0" % "test",
        "org.apache.commons" % "commons-lang3" % "3.10"
      ),
    scalacOptions := Seq("-deprecation", "-unchecked", "-feature"),
    licenses := Seq("MIT License" -> url("https://github.com/marcuslonnberg/sbt-docker/blob/master/LICENSE")),
    homepage := Some(url("https://github.com/marcuslonnberg/sbt-docker")),
    scmInfo := Some(ScmInfo(url("https://github.com/marcuslonnberg/sbt-docker"), "scm:git:git://github.com:marcuslonnberg/sbt-docker.git"))
  )
