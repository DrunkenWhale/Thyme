import thyme.Thyme

object Test {
    def main(args: Array[String]): Unit = {
        Thyme()
            .POST("test")
            .run()
    }
}
