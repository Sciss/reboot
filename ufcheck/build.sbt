libraryDependencies ++= Seq(
  "org.slf4j" % "slf4j-simple" % Common.slf4jVersion % Test
)
libraryDependencies ++= {
  if (scalaVersion.value == "2.13.0-RC2") {
    Seq(
      "org.scalacheck" % "scalacheck_2.13.0-RC1" % Common.scalacheckVersion % Test
    )
  } else {
    Seq(
      "org.scalacheck" %% "scalacheck" % Common.scalacheckVersion % Test,
      "ws.unfiltered"  %% "unfiltered-netty-server" % Common.unfilteredNettyVersion % Test excludeAll ExclusionRule(organization = "io.netty")
    )
  }
}

excludeFilter in unmanagedSources := {
  val default = (excludeFilter in unmanagedSources).value
  if (scalaVersion.value == "2.13.0-RC2") default || "*.scala" else default
}

publishArtifact := {
  scalaVersion.value != "2.13.0-RC2"
}
