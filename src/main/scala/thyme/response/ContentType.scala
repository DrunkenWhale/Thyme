package thyme.response

enum ContentType(private val contentType: String) {

  override def toString: String = this.contentType

  case `application/xml` extends ContentType("application/xml")

  case `application/json` extends ContentType("application/json")

  case `text/plain` extends ContentType("text/plain")

  case `text/html` extends ContentType("text/html")

  case `text/xml` extends ContentType("text/xml")
  // MORE
}
