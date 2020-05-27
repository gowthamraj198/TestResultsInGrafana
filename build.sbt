name := "TestReportsInGrafana"

version := "0.1"

scalaVersion := "2.11.11"

enablePlugins(TestNGPlugin)


libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.5"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % "test->*"
libraryDependencies += "org.seleniumhq.selenium" % "selenium-java" % "3.141.59"
libraryDependencies += "org.seleniumhq.selenium" % "selenium-server" % "3.141.59"
libraryDependencies += "org.slf4j" % "slf4j-log4j12" % "1.2"
libraryDependencies += "net.sourceforge.jtds" % "jtds" % "1.3.1"
libraryDependencies += "com.typesafe" % "config" % "1.2.1"
libraryDependencies += "org.scala-lang" % "scala-library" % "2.11.1"
libraryDependencies += "org.scala-lang" % "scala-xml" % "2.11.0-M4"
libraryDependencies += "org.apache.spark" %% "spark-core" % "2.4.5"
libraryDependencies += "org.apache.httpcomponents.client5" % "httpclient5" % "5.0"
libraryDependencies += "org.influxdb" % "influxdb-java" % "2.18"
//libraryDependencies += "org.testng" % "testng" % "7.1.0" % Test

libraryDependencies ++= Seq(
  "org.pegdown" % "pegdown" % "1.6.0" % Test
)

testNGSuites ++= Seq("src/test/resources/testng.xml")

//parallelExecution in Test := false

testOptions in Test ++= Seq(
  Tests.Argument(TestFrameworks.ScalaTest, "-h", "target/test-reports")
)






