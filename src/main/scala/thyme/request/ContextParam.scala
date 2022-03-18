package thyme.request

import thyme.extarctor.{Context, Extractor}

import scala.reflect.{ClassTag, classTag}

object ContextParam {

  def parameter(name: String): Context => String = {
    (context: Context) =>
      context.parameter.getOrElse(name, "")
  }
  
  def form(name: String): Context => String = {
    (context: Context) =>
      context.form.getOrElse(name, "")
  }

  def header(name: String): Context => String = {
    (context: Context) =>
      context.header.getOrElse(name, "")
  }

  def parameters: Context => Map[String, String] = {
    (context: Context) => context.parameter
  }

  def forms: Context => Map[String, String] = {
    (context: Context) => context.form
  }

  def headers: Context => Map[String, String] = {
    (context: Context) => context.header
  }

  extension (self: Context => String) {

    def as[T](implicit classTag: ClassTag[T]): Context => T = {

      (context: Context) => {

        val valueString: String = self(context)

        (if (classTag == classTagString) {
          valueString
        } else if (classTag == classTagInt) {
          java.lang.Integer.parseInt(valueString)
        } else if (classTag == classTagLong) {
          java.lang.Long.parseLong(valueString)
        } else if (classTag == classTagFloat) {
          java.lang.Float.parseFloat(valueString)
        } else if (classTag == classTagDouble) {
          java.lang.Double.parseDouble(valueString)
        } else if (classTag == classTagBoolean) {
          java.lang.Boolean.parseBoolean(valueString)
        } else {
          throw new IllegalArgumentException("Unknown Support Param Type")
        }).asInstanceOf[T]
        
      }
    }

  }

  private val classTagInt: ClassTag[Int] = classTag[Int]
  private val classTagLong: ClassTag[Long] = classTag[Long]
  private val classTagFloat: ClassTag[Float] = classTag[Float]
  private val classTagDouble: ClassTag[Double] = classTag[Double]
  private val classTagString: ClassTag[String] = classTag[String]
  private val classTagBoolean: ClassTag[Boolean] = classTag[Boolean]

}
