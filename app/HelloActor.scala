import akka.actor.{Actor, Props}

object HelloActor {
  def props = Props[HelloActor]

  case class SayHello(name: String)
}

class HelloActor extends Actor {
  import HelloActor._

  override def receive: Receive = {
    case SayHello(name: String) => {
      println("hello, " + name)
    }
  }
}