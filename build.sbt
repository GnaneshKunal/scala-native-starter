name := "scala-native-starter"

version := "0.1"

scalaVersion := "2.11.11"

lazy val make = taskKey[Unit]("Building native components")

make := {
  "make" !
}

resolvers += Resolver.sonatypeRepo("snapshots")

enablePlugins(ScalaNativePlugin)

nativeLinkingOptions := Seq("-L" ++ baseDirectory.value.getAbsolutePath() ++ "/target")

compile in Compile := (compile in Compile dependsOn make).value