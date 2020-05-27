package pages

import org.openqa.selenium.support.{FindBy, PageFactory}
import org.openqa.selenium.{WebDriver, WebElement}

class SignupPage(driver: WebDriver) {

  PageFactory.initElements(driver, this)

  @FindBy(css = "body pre")
  var email: WebElement = _


  def getEmailContent(): String = {
    email.getText
  }

}
