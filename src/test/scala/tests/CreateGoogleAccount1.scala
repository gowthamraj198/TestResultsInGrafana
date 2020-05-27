package tests

import helpers.{LoggerHelper, Utils}
import org.openqa.selenium.chrome.ChromeDriver
import org.testng.annotations.{AfterTest, BeforeTest, Test}
import pages.{GooglePage, SignupPage}

class CreateGoogleAccount1 extends BaseTest {

  lazy val googlePage = new GooglePage(webDriver)
  lazy val signupPage = new SignupPage(webDriver)
  val LOGGER = new LoggerHelper("Create Google Account")
  val utils = new Utils
  val url = "https://www.google.com"
  val url1 = "https://receive-smss.com/sms/917428730894/"

  @BeforeTest
  def setup: Unit = {
    println ("Before test")
  }

  @AfterTest
  def tearDown: Unit = {
    println ("after test")
  }

//  override protected def beforeAll: Unit = {
//
//    webDriver = initiateDriver("chrome",LOGGER)
//    maximizeWindow(webDriver)
//  }
//
//  override protected def afterAll: Unit = {
//    quit()
//  }

  @Test(description = "testing")
  def verifyName: Unit = {
    println ("hello")
  }

//  "New account " should "be created" in {
//    val name = "trsil"
//    go to url
//    click on linkText("Gmail")
//    click on cssSelector(".header__nav--ltr .h-c-header__cta-li--primary a")
//    switch to window(windowHandles.last.toString())
//
//    textField("firstName").value = name
//    textField("lastName").value = name
//    textField("username").value= name + "." + name + utils.randomNumber(101,999).toString
//    webDriver.findElementByName("Passwd").sendKeys("1x9yqwerty")
//    webDriver.findElementByName("ConfirmPasswd").sendKeys("1x9yqwerty")
//    click on id("accountDetailsNext")
//    Thread.sleep(2000)
//    click on ("phoneNumberId")
//    webDriver.findElementById("phoneNumberId").sendKeys("87272017")
//    click on cssSelector("div[role='button'] span span")
//    Thread.sleep(20000)
//    click on ("phoneNumberId")
//    webDriver.findElementById("phoneNumberId").clear
//    println(utils.randomNumber(1,30).toString)
//    webDriver.findElementById("day").sendKeys(utils.randomNumber(1,30).toString)
//    println(utils.randomNumber(1980,1999).toString)
//    webDriver.findElementById("year").sendKeys((1980+utils.randomNumber(1980,1999)).toString)
//    singleSel("month").value = utils.randomNumber(1,12).toString
//    singleSel("gender").value = utils.randomNumber(1,2).toString
//    click on id("personalDetailsNext")
//    click on id("termsofserviceNext")
//    click on cssSelector("a[title='Google apps']")
//    switch to frame(0)
//    click on cssSelector("a[href='https://www.youtube.com/?gl=SG&tab=w1&authuser=1']")
//    go to "https://www.youtube.com/watch?v=GTj2gI4c8wQ"
//    click on cssSelector("#info #button yt-icon.ytd-toggle-button-renderer")
//
//    webDriver.executeScript("window.open('about:blank','_blank');")
//    switch to window(windowHandles.last.toString())
//    go to url1
//
//  }

  override implicit var webDriver: ChromeDriver = _
}
