name := "scala-native-starter"

version := "0.1"

scalaVersion := "2.11.11"

libraryDependencies += "com.lihaoyi" %%% "utest" % "0.5.3" % "test"

testFrameworks += new TestFramework("utest.runner.Framework")

lazy val make = taskKey[Unit]("Building native components")

make := {
  "make" !
}

resolvers += Resolver.sonatypeRepo("snapshots")

enablePlugins(ScalaNativePlugin)

nativeLinkingOptions := Seq("-L" ++ baseDirectory.value.getAbsolutePath() ++ "/target")

nativeLinkStubs := true

compile in Compile := (compile in Compile dependsOn make).value