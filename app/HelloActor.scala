import akka.actor.{Actor, Props}
import com.google.inject.{Inject, Singleton}
import com.typesafe.config.ConfigFactory
import play.api.libs.mailer.{Email, MailerClient}

object HelloActor {
  def props = Props[HelloActor]

  case class SayHello(name: String)
}

@Singleton
class HelloActor @Inject()(mailerClient: MailerClient) extends Actor {
  import HelloActor._

  private val mailConfig = ConfigFactory.load

  override def receive: Receive = {
    case SayHello(name: String) => {
      val email = Email(
        "subject",
        mailConfig.getString("mailSender"),
        Seq("receiver@icharm.me").filterNot(_.equals("")),
        bodyText = Some("mail body")
      )
      println("hello, " + name)
    }
  }
}