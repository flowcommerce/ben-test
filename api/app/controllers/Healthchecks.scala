package controllers

import javax.inject.{Inject, Singleton}

import io.flow.error.v0.models.json._
import io.flow.healthcheck.v0.models.Healthcheck
import io.flow.healthcheck.v0.models.json._
import io.flow.play.util.Validation
import play.api.libs.json._
import play.api.mvc._

@Singleton
class Healthchecks @Inject()(
  val controllerComponents: ControllerComponents
) extends BaseController {

  private[this] val HealthyJson = Json.toJson(Healthcheck(status = "healthy"))

  def getHealthcheck() = Action { _ =>
    // TODO: Make sure we can read from the db
    if (true) {
      Ok(HealthyJson)
    } else {
      UnprocessableEntity(Json.toJson(Validation.error("could not read from db")))
    }
  }

}
