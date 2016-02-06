package no.fagproject.extremestartup.rest.support

import no.fagprosjekt.extremestartup.rest.support.BackendErrorMessage
import org.apache.commons.httpclient.NoHttpResponseException
import org.joda.time.{DateTime, DateTimeZone}
import org.json4s.jackson.Serialization._
import org.json4s.{DefaultFormats, Formats}
import org.scalatra.json.JacksonJsonSupport



trait JsonSupportWithJsonErrorHandling extends  JacksonJsonSupport{

  protected implicit val jsonFormats: Formats = DefaultFormats.lossless ++ org.json4s.ext.JodaTimeSerializers.all

  before() {
    contentType = formats("json")
  }

  def extractRequiredParam(paramName: String): String = {
    val param = params.get(paramName)

    if (param.isEmpty) {
      throw new RuntimeException("Missing " + paramName + " parameter")
    }
    param.get
  }

  def extractRequiredParams(paramName: String): List[String] = {
    val param = multiParams.get(paramName)
    if (param.isEmpty) {
      throw new RuntimeException("Missing " + paramName + " parameter")
    }
    //Fix for reading of multiparam string, where it doesn't seem scalatra splits on comma.
    param.get.toList.map(_.split(",")).flatten
  }

  def parseDate(dateString: String): DateTime = {
    DateTime.parse(dateString).withZone(DateTimeZone.forID("Europe/Oslo"))
  }

  def toErrorMessage(exception: Exception): BackendErrorMessage = {
    val friendlyDescription = exception match {
      case userFriendly: RuntimeException => Option(userFriendly.getMessage)
      case _ => None
    }
    BackendErrorMessage(friendlyDescription, exception.getClass.getCanonicalName, exception.getMessage, "ExtremeStartup")
  }


  def failWith(statusCode: Int): Unit = {
    contentType = formats("json")
    status = statusCode
  }

  error {
    case e: NoHttpResponseException => {
      status = 500
      contentType = formats("json")
      write(e)
    }
    case e: RuntimeException => {
      //log.info("Error occured in extremeStartup: ", e)
      status = 400
      contentType = formats("json")
      write(toErrorMessage(e))
    }
    case e: Exception => {
      //log.error("Error occured in extremeStartup:", e)
      status = 500
      contentType = formats("json")
      write(toErrorMessage(e))
    }
  }
}
