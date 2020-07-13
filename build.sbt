name := "ben-test"

organization := "io.flow"

scalaVersion in ThisBuild := "2.13.1"

resolvers += Resolver.sbtPluginRepo("releases")

lazy val api = project
  .in(file("api"))
  .enablePlugins(PlayScala)
  .enablePlugins(NewRelic)
  .settings(commonSettings: _*)
  .settings(
    testOptions += Tests.Argument("-oF"),
    javaOptions in Test += "-Dlogger.resource=logback-test.xml",
    routesGenerator := InjectedRoutesGenerator,
    flowGeneratedFiles ++= Seq(
      "app/generated/.*".r,
      "target/.*".r,
    ),
    libraryDependencies ++= Seq(
      guice,
      ws,
      "io.flow"                %% "lib-play-play28"            % "0.6.1",
      "io.flow"                %% "lib-usage-play28"           % "0.1.27",
      "io.flow"                %% "lib-event-sync-play28"      % "0.4.87",
      "io.flow"                %% "lib-test-utils-play28"      % "0.0.94" % Test,
      "org.mockito"             % "mockito-core"               % "3.3.3" % Test,
      compilerPlugin("com.github.ghik" % "silencer-plugin" % "1.6.0" cross CrossVersion.full),
      "com.github.ghik" % "silencer-lib" % "1.6.0" % Provided cross CrossVersion.full
    )
  )

lazy val commonSettings: Seq[Setting[_]] = Seq(
  name ~= ("ben-test-" + _),
  scalacOptions += "-feature",
  sources in (Compile, doc) := Seq.empty,
  publishArtifact in (Compile, packageDoc) := false,
  resolvers += Resolver.bintrayRepo("scalaz", "releases"),
  resolvers += "Artifactory" at "https://flow.jfrog.io/flow/libs-release/",
  credentials += Credentials(
    "Artifactory Realm",
    "flow.jfrog.io",
    System.getenv("ARTIFACTORY_USERNAME"),
    System.getenv("ARTIFACTORY_PASSWORD")
  )
)

version := "0.0.1"
