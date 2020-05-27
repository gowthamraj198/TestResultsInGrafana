package tests

import helpers.LoggerHelper
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.scalatest.selenium.WebBrowser

abstract class BaseTest extends WebBrowser {

  var webDriver: ChromeDriver

  def initiateDriver(browser: String, LOGGER: LoggerHelper): ChromeDriver = {

    System.setProperty("webdriver.chrome.driver", "src/test/resources/" + getDriver());

    webDriver = new ChromeDriver()

    webDriver
  }

  def getDriver(): String = {

    System.getProperty("os.name").toLowerCase match {
      case x if x.contains("win") => "chromedriver-win.exe"
      case x if x.contains("mac") => "chromedriver"
      case _ => "chromedriver-linux"
    }
  }

  def maximizeWindow(webDriver: WebDriver) {

    webDriver.manage().window().maximize()
  }

}
