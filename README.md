# Thyme


This project based on Akka Http(at least for now) and use the scala,
It's humble , and lack of basic function. 

In a word, I want to get a web framework and its style likes `Flask`

emm..

you can try to use

```scala
Thyme()
    .POST("/",
        x=>ThymeResponse("Hello World"))
    .run()
```

to listen address `http://localhost/` (default)   
and you will get `"Hello World!"` if you use `GET` method to
visit this url