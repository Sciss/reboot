libraryDependencies ++= Seq(
  "org.slf4j"      %  "slf4j-simple" % Common.slf4jVersion      % Test
)
libraryDependencies ++= {
  if (scalaVersion.value == "2.13.0") {
    Nil
    // Seq(
    //   "org.scalacheck" % "scalacheck_2.13.0-RC1" % Common.scalacheckVersion % Test
    // )
  } else {
    Seq(
      "ws.unfiltered"  %% "unfiltered-netty-server" % Common.unfilteredNettyVersion % Test excludeAll ExclusionRule(organization = "io.netty"),
      "org.scalacheck" %% "scalacheck"   % Common.scalacheckVersion % Test
    )
  }
}

excludeFilter in unmanagedSources := {
  val default = (excludeFilter in unmanagedSources).value
  if (scalaVersion.value == "2.13.0") default || "*.scala" else default
}

publishArtifact := {
  scalaVersion.value != "2.13.0"
}
