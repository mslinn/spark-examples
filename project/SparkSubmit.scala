import sbtsparksubmit.SparkSubmitPlugin.autoImport._

object SparkSubmit {
  lazy val settings =
    SparkSubmitSetting("wordCount",
      Seq("--class", "KafkaWordCount"),
      Seq("localhost my-consumer-group topic1,topic2 1")
    )
}
