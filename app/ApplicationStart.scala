
import akka.actor.{ActorSystem, Props}
import com.google.inject.Inject
import com.typesafe.akka.extension.quartz.QuartzSchedulerExtension
import play.api.inject.ApplicationLifecycle
import play.inject.Injector

import scala.concurrent.Future

class ApplicationStart @Inject()(
                                   lifecycle: ApplicationLifecycle,
                                   system: ActorSystem,
                                   injector: Injector
                                 ) {
  val name = "ApplicationStart"

  // Shut-down hook
  lifecycle.addStopHook { () =>
    Future.successful()
  }

  // Start scheduling
  val scheduler = QuartzSchedulerExtension(system)
  val receiver = system.actorOf(Props.create(classOf[GuiceActorProducer], injector, classOf[HelloActor]))
  scheduler.schedule("every15seconds", receiver, HelloActor.SayHello("Peter"), None)

}