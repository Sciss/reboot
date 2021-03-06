package unfiltered.spec

trait Cleanup {
  Cleanup.dirties += (this -> (()))
  def cleanup(): Unit
}

trait ServerCleanup extends Cleanup {
  def server: unfiltered.util.StartableServer
  def cleanup(): Unit = { server.stop() }
}

object Cleanup {
  import scala.collection.concurrent.TrieMap
  private val dirties = TrieMap.empty[Cleanup, Unit]

  def cleanup(): Unit = {
    try {
      dirties.foreach { _._1.cleanup() }
    } catch {
      case e: Exception =>
        println("Error on cleanup")
        e.printStackTrace
    }
  }
}
