package actors

import akka.actor.{Actor, ActorLogging, ActorSystem}
import io.flow.akka.SafeReceive
import io.flow.akka.recurring.{ScheduleConfig, Scheduler}
import io.flow.log.RollbarLogger
import play.api.Configuration

class PeriodicActor @javax.inject.Inject() (
  config: Configuration,
  system: ActorSystem,
  implicit val logger: RollbarLogger,
) extends Actor with ActorLogging with Scheduler {

  private[this] implicit val ec = system.dispatchers.lookup("periodic-actor-context")

  private[this] case object VerifyJson

  scheduleRecurring(
    ScheduleConfig.fromConfig(config.underlying, "actors.verify_json"),
    VerifyJson
  )

  def receive = SafeReceive.withLogUnhandled {
    case VerifyJson => // no-op
  }
}