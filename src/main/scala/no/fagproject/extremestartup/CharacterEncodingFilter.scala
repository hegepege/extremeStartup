package no.kf.gevinstrealisering

import javax.servlet._
import javax.servlet.http.{HttpServletRequest, HttpServletResponse}

/**
 *
 */

class CharacterEncodingFilter extends Filter{
  def init(filterConfig: FilterConfig) {}

  def doFilter(request: ServletRequest, response: ServletResponse, chain: FilterChain) {
    request.asInstanceOf[HttpServletRequest].setCharacterEncoding("UTF-8")
    response.asInstanceOf[HttpServletResponse].setCharacterEncoding("UTF-8")
    chain.doFilter(request, response)
  }

  def destroy() {}
}
