package pages


import org.openqa.selenium.support.{FindBy, PageFactory}
import org.openqa.selenium.{WebDriver, WebElement}

class GooglePage(driver: WebDriver) {

  PageFactory.initElements(driver, this)

  @FindBy(linkText = "Gmail")
  var email: WebElement = _


  def goToGMail(): String = {
    email.getText
  }

}
