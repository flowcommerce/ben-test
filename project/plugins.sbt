// The Typesafe repository
resolvers += Resolver.typesafeRepo("releases")

// Use the Play sbt plugin for Play projects
addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.8.2")

addSbtPlugin("com.gilt.sbt" % "sbt-newrelic" % "0.3.0")

addSbtPlugin("io.github.davidgregory084" % "sbt-tpolecat" % "0.1.11")

resolvers += "Flow Plugins" at "https://flow.jfrog.io/flow/plugins-release/"
addSbtPlugin("io.flow" % "sbt-flow-linter" % "0.0.19")
