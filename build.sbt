// *****************************************************************************
// Build settings
// *****************************************************************************

inThisBuild(
  Seq(
    organization     := "rocks.heikoseeberger",
    organizationName := "Heiko Seeberger",
    startYear        := Some(2021),
    licenses += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0")),
    homepage := Some(url("https://github.com/hseeberger/log4scala")),
    developers := List(
      Developer(
        "hseeberger",
        "Heiko Seeberger",
        "mail@heikoseeberger.rocks",
        url("https://github.com/hseeberger")
      )
    ),
    scalaVersion := "3.1.0",
    scalacOptions ++= Seq(
      "-unchecked",
      "-deprecation",
      "-Xfatal-warnings",
      "-rewrite",
      "-new-syntax",
    ),
    testFrameworks += new TestFramework("munit.Framework"),
    scalafmtOnCompile := true,
    dynverSeparator   := "_", // the default `+` is not compatible with docker tags
  )
)

// *****************************************************************************
// Projects
// *****************************************************************************

lazy val slf4s =
  project
    .in(file("."))
    .enablePlugins(AutomateHeaderPlugin)
    .settings(commonSettings)
    .settings(
      libraryDependencies ++= Seq(
        // Logging
        library.slf4jApi,
        // Testing
        library.logback         % Test,
        library.mockitoCore     % Test,
        library.munit           % Test,
        library.munitScalaCheck % Test,
      ),
    )

// *****************************************************************************
// Project settings
// *****************************************************************************

lazy val commonSettings =
  Seq(
    // Also (automatically) format build definition together with sources
    Compile / scalafmt := {
      val _ = (Compile / scalafmtSbt).value
      (Compile / scalafmt).value
    },
  )

// *****************************************************************************
// Library dependencies
// *****************************************************************************

lazy val library =
  new {
    object Version {
      val log4j   = "2.14.0"
      val logback = "1.2.10"
      val mockito = "4.3.0"
      val munit   = "0.7.29"
      val slf4j   = "1.7.33"
    }
    // Logging
    val slf4jApi = "org.slf4j" % "slf4j-api" % Version.slf4j
    // Testing
    val logback         = "ch.qos.logback" % "logback-classic"  % Version.logback
    val mockitoCore     = "org.mockito"    % "mockito-core"     % Version.mockito
    val munit           = "org.scalameta" %% "munit"            % Version.munit
    val munitScalaCheck = "org.scalameta" %% "munit-scalacheck" % Version.munit
  }
