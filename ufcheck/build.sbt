libraryDependencies ++= Seq(
  "org.slf4j"      %  "slf4j-simple" % Common.slf4jVersion      % Test,
  "org.scalacheck" %% "scalacheck"   % Common.scalacheckVersion % Test
)
libraryDependencies ++= {
  if (scalaVersion.value.startsWith("2.13.0-RC")) {
    Nil
    // Seq(
    //   "org.scalacheck" % "scalacheck_2.13.0-RC1" % Common.scalacheckVersion % Test
    // )
  } else {
    Seq(
      "ws.unfiltered"  %% "unfiltered-netty-server" % Common.unfilteredNettyVersion % Test excludeAll ExclusionRule(organization = "io.netty")
    )
  }
}

excludeFilter in unmanagedSources := {
  val default = (excludeFilter in unmanagedSources).value
  if (scalaVersion.value.startsWith("2.13.0-RC")) default || "*.scala" else default
}

publishArtifact := {
  !scalaVersion.value.startsWith("2.13.0-RC")
}
