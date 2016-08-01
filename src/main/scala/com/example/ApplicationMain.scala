package com.example

import akka.actor.ActorSystem

object ApplicationMain extends App {
  val system = ActorSystem("MyActorSystem")
  val pingActor = system.actorOf(PingActor.props, "pingActor")
  pingActor ! PingActor.Initialize

  readLine(after = () => system.terminate())

  def readLine(action: (String) => Unit = (line) => println(line),
               quit: List[String] = List(""),
               after: () => Unit = () => {}
              ): Unit = {

    Iterator
      .continually(scala.io.StdIn.readLine())
      .takeWhile(line => !quit.contains(line))
      .foreach(line => action(s"$line"))

    after()

  }

}