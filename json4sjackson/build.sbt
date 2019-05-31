name := "dispatch-json4s-jackson"

description :=
  "Dispatch module providing json4s support"

libraryDependencies ++= Seq(
  "org.json4s" %% "json4s-jackson" % Common.json4sVersion
)

libraryDependencies ++= {
  if (scalaVersion.value.startsWith("2.13.0-RC")) Nil else Seq(
    "ws.unfiltered" %% "unfiltered-netty-server" % Common.unfilteredNettyVersion % Test excludeAll ExclusionRule(organization = "io.netty")
  )
}

unmanagedSourceDirectories in Test := {
  val old = (unmanagedSourceDirectories in Test).value
  if (scalaVersion.value.startsWith("2.13.0-RC")) Nil else old
}
