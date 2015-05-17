import play.PlayScala
import sbt.Keys._
import sbt._
import net.yefremov.sleipnir.sbt.SleipnirPlugin._

object Build extends Build {

  lazy val commonSettings = Seq(
    name := "sleipnir-sample",
    version := "1.0-SNAPSHOT",
    scalaVersion := "2.11.1"
  )

  lazy val root = (project in file("."))
    .settings(commonSettings: _*)
    .settings(sleipnirSettings: _*)
    .settings(
      sleipnirSourceDirectory := baseDirectory.value / "data" / "src" / "main" / "pegasus",
      sleipnirDestinationDirectory := baseDirectory.value / "data" / "src" / "main" / "codegen"
    )
    .enablePlugins(PlayScala)

}
