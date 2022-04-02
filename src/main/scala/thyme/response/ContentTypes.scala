package thyme.response

enum ContentTypes(private val contentType: String) {

  override def toString: String = this.contentType

  case `application/xml` extends ContentTypes("application/xml")

  case `application/json` extends ContentTypes("application/json")

  case `text/plain` extends ContentTypes("text/plain")

  case `text/html` extends ContentTypes("text/html")

  case `text/xml` extends ContentTypes("text/xml")
  // MORE
}
