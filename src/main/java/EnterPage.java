import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnterPage {

  public WebDriver driver;

  public EnterPage(WebDriver driver) {
    PageFactory.initElements(driver, this);
    this.driver = driver;
  }

  @FindBy(xpath = "//*[@id=\"login-email\"]")
  private WebElement email;

  @FindBy(xpath = "//*[@id=\"login-password\"]")
  private WebElement password;

  @FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div/div[2]/div[1]/form/div[5]/button")
  private WebElement enterButton;

  public void enterEmail(String text) {
    email.sendKeys(text);
  }

  public void enterPassword(String text) {
    password.sendKeys(text);
  }

  public void clickButton() {
    enterButton.click();
  }
}
