import javax.servlet.ServletContext

import no.fagprosjekt.extremestartup.rest.MainScalatraServlet

import org.scalatra.LifeCycle

class ScalatraBootstrap extends LifeCycle {

  override def init(context: ServletContext) {

    context mount(new MainScalatraServlet, "/*")

  }
}
