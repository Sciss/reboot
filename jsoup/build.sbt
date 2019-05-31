name := "dispatch-jsoup"

description :=
  "Dispatch module providing jsoup html parsing support"

libraryDependencies += "org.jsoup" % "jsoup" % Common.jsoupVersion

unmanagedSourceDirectories in Test := {
  val old = (unmanagedSourceDirectories in Test).value
  if (scalaVersion.value.startsWith("2.13.0-RC")) Nil else old
}
