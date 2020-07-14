package controllers

import akka.actor.ActorSystem
import io.flow.play.controllers.{FlowController, FlowControllerComponents}
import javax.inject.{Inject, Singleton}
import play.api.libs.ws.WSClient
import play.api.mvc.ControllerComponents

@Singleton
class BenTests @Inject()(
  system: ActorSystem,
  val controllerComponents: ControllerComponents,
  val flowControllerComponents: FlowControllerComponents,
  ws: WSClient,
) extends FlowController with FlowAssertions {

  private[this] implicit val ec = system.dispatchers.lookup("ben-test-controller")

  def call(url: String) = Action.async { _ =>
    ws.url(url).get().map(_ => Ok)
  }

}
