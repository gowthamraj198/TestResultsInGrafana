package helpers

import java.io.File
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

import scala.reflect.io.Directory

class Utils(){

  def deleteDownloadDir(LOGGER: LoggerHelper,downloadPath: String): Unit = {
    val directory = new Directory(new File(downloadPath))
    directory.deleteRecursively()
    LOGGER.clearAndPrintLogs("downloads folder deleted")
  }

  def getCurrentDateTime(): String = {
    DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm:ss").format(LocalDateTime.now)
  }

  def randomNumber(start: Int, end: Int): Int = {
    scala.util.Random.nextInt((end-start)+1)
  }

}