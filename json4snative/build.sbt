name := "dispatch-json4s-native"

description :=
  "Dispatch module providing json4s native support"

libraryDependencies ++= Seq(
  "org.json4s"    %% "json4s-core"              % Common.json4sVersion,
  "org.json4s"    %% "json4s-native"            % Common.json4sVersion
)

libraryDependencies ++= {
  if (scalaVersion.value == "2.13.0") Nil else Seq(
    "ws.unfiltered" %% "unfiltered-netty-server" % Common.unfilteredNettyVersion % Test
  )
}

unmanagedSourceDirectories in Test := {
  val old = (unmanagedSourceDirectories in Test).value
  if (scalaVersion.value == "2.13.0") Nil else old
}
