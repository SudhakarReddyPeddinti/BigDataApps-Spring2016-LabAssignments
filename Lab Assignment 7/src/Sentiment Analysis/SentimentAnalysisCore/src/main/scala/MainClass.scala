/**
 * Created by Sudhakar on 09-Mar-16.
 */
object MainClass {

  def main(args: Array[String]) {
    val sentimentAnalyzer: SentimentAnalyzer = new SentimentAnalyzer
    val tweetWithSentiment: TweetWithSentiment = sentimentAnalyzer.findSentiment("My Project is all about Images and there is no Text data to process. So i am unable to perform this task using project data.")
    System.out.println(tweetWithSentiment)
  }
}
