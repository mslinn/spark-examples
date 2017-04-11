organization := "com.micronautics"

name := "spark-examples"

version := "2.1.0"

scalaVersion := "2.11.8"

scalacOptions ++= Seq(
//  "-deprecation",     // the Spark sample code is poor quality, disable the checks
  "-encoding", "UTF-8",
  //"-feature",
  "-target:jvm-1.8"
  //"-unchecked",
  //"-Ywarn-adapted-args",
  //"-Ywarn-dead-code",
  //"-Ywarn-numeric-widen",
  //"-Ywarn-unused",
  //"-Ywarn-value-discard",
  //"-Xfuture",
  //"-Xlint"
)

scalacOptions in (Compile, doc) ++= baseDirectory.map {
  (bd: File) => Seq[String](
     "-sourcepath", bd.getAbsolutePath,
     "-doc-source-url", "https://github.com/mslinn/spark-examples/tree/master€{FILE_PATH}.scala"
  )
}.value

javacOptions ++= Seq(
  "-Xlint:deprecation",
  "-Xlint:unchecked",
  "-source", "1.8",
  "-target", "1.8",
  "-g:vars"
)

resolvers ++= Seq()

val sparkVer = "2.1.0"

libraryDependencies ++= Seq(
  "com.github.scopt"  %% "scopt"                     % "3.5.0"   withSources(),
  "org.apache.kafka"  %% "kafka"                     % "0.8.2.2" withSources(),
  "org.apache.spark"  %% "spark-mllib"               % sparkVer  withSources(),
  "org.apache.spark"  %% "spark-sql"                 % sparkVer  withSources(),
  "org.apache.spark"  %% "spark-streaming"           % sparkVer  withSources(),
  "org.apache.spark"  %% "spark-streaming-flume"     % sparkVer  withSources(),
  "org.apache.spark"  %% "spark-streaming-kafka-0-8" % sparkVer  withSources(),
  //
  "org.scalatest"     %% "scalatest" % "3.0.1"   % "test" withSources(),
  "junit"             %  "junit"     % "4.12"    % "test"
)

// define the statements initially evaluated when entering 'console', 'console-quick', but not 'console-project'
initialCommands in console := """
                                |""".stripMargin

cancelable := true
