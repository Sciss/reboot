scalacOptions += "-Xfatal-warnings"

addSbtPlugin("com.eed3si9n" % "sbt-buildinfo"   % "0.10.0")  // provides version information to copy into main class
addSbtPlugin("com.typesafe" % "sbt-mima-plugin" % "0.8.1")   // compatibility testing
addSbtPlugin("ch.epfl.lamp" % "sbt-dotty"       % "0.4.6")   // cross-compile for dotty

