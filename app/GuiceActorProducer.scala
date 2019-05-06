import akka.actor.{Actor, IndirectActorProducer}

class GuiceActorProducer(val injector: play.inject.Injector, val cls: Class[_ <: Actor]) extends IndirectActorProducer {

  override def actorClass = classOf[Actor]

  override def produce() = {
    injector.instanceOf(cls)
  }

}