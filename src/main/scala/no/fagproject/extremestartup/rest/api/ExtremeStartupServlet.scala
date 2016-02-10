package no.kf.gevinstrealisering.rest.api

import grizzled.slf4j.Logging
import no.fagproject.extremestartup.rest.support.JsonSupportWithJsonErrorHandling
import org.json4s.jackson.Serialization
import org.scalatra.ScalatraServlet

class ExtremeStartupServlet extends ScalatraServlet with JsonSupportWithJsonErrorHandling  with Logging {

  get("/?") {
    Console.println("get")
    contentType="text/html"
    <body>
      <h1>Hello World!!!</h1>
    </body>
  }

  post("/?") {
    //val receivedIds = Serialization.read[List[String]](request.body)
    Console.println(request.body);
    contentType = "application/json"
    status = 200
    Serialization.write("{hello}")
  }

  put("/"){
    Console.println(request.body);
    contentType = "application/json"
    status = 200
    Serialization.write("{hello}")
  }

  delete("/?") {
    status = 200
  }

}
