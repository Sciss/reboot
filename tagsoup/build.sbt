name := "dispatch-tagsoup"

description :=
  "Dispatch module providing tagsoup xml and html parsing support"

libraryDependencies += "org.ccil.cowan.tagsoup" % "tagsoup" % Common.tagsoupVersion

unmanagedSourceDirectories in Test := {
  val old = (unmanagedSourceDirectories in Test).value
  if (scalaVersion.value == "2.13.0-RC2") Nil else old
}