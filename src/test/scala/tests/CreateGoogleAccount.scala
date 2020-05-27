package tests

import helpers.{LoggerHelper, Utils}
import org.openqa.selenium.chrome.ChromeDriver
import org.testng.annotations.{AfterTest, BeforeTest, Test}
import pages.{GooglePage, SignupPage}

class CreateGoogleAccount extends BaseTest {

  lazy val googlePage = new GooglePage(webDriver)
  lazy val signupPage = new SignupPage(webDriver)
  val LOGGER = new LoggerHelper("Create Google Account")
  val utils = new Utils
  val url = "https://www.google.com"

  @BeforeTest
  def setup: Unit = {
    println ("Before test")
  }

  @AfterTest
  def tearDown: Unit = {
    println ("after test")
  }

  @Test (description = "independent test")
  def pass(): Unit = {
    Thread.sleep(1000)
    println ("hello")
  }

  @Test (description = "failing test")
  def fail(): Unit = {
    Thread.sleep(1000)
    println ("hello")
    throw new Exception()
  }

  @Test (description = "dependent test", dependsOnMethods = Array("fail"))
  def skip(): Unit = {
    Thread.sleep(1000)
    println ("hello")
  }

  override implicit var webDriver: ChromeDriver = _
}
