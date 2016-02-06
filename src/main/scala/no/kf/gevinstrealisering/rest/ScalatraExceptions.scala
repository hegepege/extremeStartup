package no.fagprosjekt.extremestartup.rest

import org.scalatra.halt

object ScalatraExceptions {
  def forbiddenException(explanation: String) = halt(status=403, reason="Forbidden", body=explanation)
  def unauthorizedException(explanation: String) = halt(status=401, reason="Unauthorized", body=explanation)
}
