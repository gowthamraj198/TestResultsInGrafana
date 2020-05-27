package helpers

import scala.collection.mutable.Queue

class LoggerHelper(testName: String){
  var logs = new Queue[String]()

  def log(x: String): Unit ={
    logs.enqueue(x)
  }

  def printLog(): Unit ={
    var i: Int = 1
    for(log:String <- logs){
      println(s"$testName -- $log")
      i += 1
    }
  }

  def clear(): Unit = {
    logs.clear()
  }

  def clearAndPrintLogs(logs: String): Unit = {
    clear()
    log(logs)
    printLog()
  }
}