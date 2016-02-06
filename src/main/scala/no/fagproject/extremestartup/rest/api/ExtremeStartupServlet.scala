package no.kf.gevinstrealisering.rest.api

import grizzled.slf4j.Logging
import no.fagproject.extremestartup.rest.support.JsonSupportWithJsonErrorHandling
import org.json4s.jackson.Serialization
import org.scalatra.ScalatraServlet

class ExtremeStartupServlet extends ScalatraServlet with JsonSupportWithJsonErrorHandling  with Logging {

  post("post1/?") {
    val title = extractRequiredParam("param1")
    val externalId = extractRequiredParam("param2")
    status = 200
    //Serialization.write()
  }

  get("/?") {
    contentType="text/html"
    <body>
      <h1>Hello World!!!</h1>
    </body>
  }

  post("/post2/?") {
    val receivedIds = Serialization.read[List[String]](request.body)
    contentType = "application/json"
    status = 200
    //Serialization.write()
  }

  delete("/:id/?") {
    status = 204
  }

}
