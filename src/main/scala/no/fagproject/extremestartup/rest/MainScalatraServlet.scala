package no.fagprosjekt.extremestartup.rest

import javax.servlet.ServletConfig

import org.scalatra.{SessionSupport, ScalatraServlet}
import org.scalatra.scalate.ScalateSupport


class MainScalatraServlet extends ScalatraServlet with ScalateSupport with SessionSupport {

  override def init(config: ServletConfig) {
    super.init(config)
  }

  get("/?") {
    contentType = "text/html"
    new java.io.File(servletContext.getResource("/index.html").toURI)
  }

  // Generic error handling, also pretty simple
  error {
    case e: Exception => {
      //log.warn("Generic error handler", e)
      <body>
        <h1>An unexpected error occurred!</h1>
        <p>Exception message:
          {e.getMessage}
        </p>
      </body>
    }
  }
}
