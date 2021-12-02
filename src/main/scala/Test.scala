import spray.json.DefaultJsonProtocol.{StringJsonFormat, jsonFormat3}
import spray.json.{JsValue, RootJsonFormat, enrichAny}
import thyme.Thyme

object Test {
    def main(args: Array[String]): Unit = {
        Thyme()
            .POST(test,"test")
            .GET(test,"test")
            .run()
    }

    val test: Map[String, String] => JsValue = (x:Map[String,String]) => {
        case class temp(name: String, age: String, grade: String)
        implicit val tempFormat: RootJsonFormat[temp] = jsonFormat3(temp)
        temp(x("name"),x("age"),x("grade")).toJson
    }
}
