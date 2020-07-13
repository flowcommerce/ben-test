package controllers

import akka.actor.ActorSystem
import com.github.ghik.silencer.silent
import io.flow.play.controllers.{FlowController, FlowControllerComponents}
import javax.inject.{Inject, Singleton}
import play.api.mvc.ControllerComponents

@Singleton
class BenTests @Inject()(
  system: ActorSystem,
  val controllerComponents: ControllerComponents,
  val flowControllerComponents: FlowControllerComponents
) extends FlowController with FlowAssertions {

  @silent private[this] implicit val ec = system.dispatchers.lookup("ben-test-controller")

}
