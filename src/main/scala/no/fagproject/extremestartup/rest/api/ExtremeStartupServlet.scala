package no.kf.gevinstrealisering.rest.api

import grizzled.slf4j.Logging
import no.fagproject.extremestartup.rest.support.JsonSupportWithJsonErrorHandling
import org.json4s.jackson.Serialization
import org.scalatra.ScalatraServlet

class ExtremeStartupServlet extends ScalatraServlet with JsonSupportWithJsonErrorHandling  with Logging {

  get("/?") {

    print(request.header(request.getHeader("Accept-Encoding)")))
    params.map(s => println(s))
    val question = extractRequiredParam("q")
    println(question)
    contentType = "application/json"
    val p = "\\w+: what is (\\d+) plus (\\d+)".r
    question match {
      case p(c1, c2) => Serialization.write((c1.toInt + c2.toInt).toString())
      case _ => println("we suck")
    }
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
