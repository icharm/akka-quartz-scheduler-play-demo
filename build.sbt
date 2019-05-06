name := "akka_quartz_scheduler_play_demo"
 
version := "1.0" 
      
lazy val `akka_quartz_scheduler_play_demo` = (project in file(".")).enablePlugins(PlayScala)

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"
      
resolvers += "Akka Snapshot Repository" at "http://repo.akka.io/snapshots/"
      
scalaVersion := "2.12.2"

libraryDependencies ++= Seq( jdbc , ehcache , ws , specs2 % Test , guice, "com.enragedginger" %% "akka-quartz-scheduler" % "1.8.0-akka-2.5.x")

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )  

      