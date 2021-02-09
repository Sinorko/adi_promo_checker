 import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

  public WebDriver driver;

  public CartPage(WebDriver driver) {
    PageFactory.initElements(driver, this);
    this.driver = driver;
  }

  @FindBy(css = "input[data-auto-id=glass-coupon-input]")
  private WebElement couponField;

  @FindBy(css = "button[class*=coupon-form__submit___]")
  private WebElement applyCouponButton;

  @FindBy(css = "div[data-auto-id=cart-coupon-error]")
  private WebElement couponError;

  @FindBy(css = "div[data-auto-id=cart-coupon-applied]")
  private WebElement couponApplied;

  @FindBy(css = "button[data-auto-id=glass-coupon-button-delete]")
  private WebElement closeAppliedCouponButton;

  @FindBy(css = "div[class*=order-summary-discount___]")
  private WebElement discountTextValue;

  public void inputCoupon(String couponText) {
    couponField.sendKeys(couponText);
  }

  public void clickApplyCouponButton() {
    applyCouponButton.click();
  }

  public boolean isApplied() {
    try {
      couponApplied.getText();
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  public void closeApplied() {
    closeAppliedCouponButton.click();
  }

  public boolean isError() {
    try {
      couponError.getText();
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  public String getCouponErrorText() {
    return couponError.getText();
  }

  public String getDiscText() {
    return discountTextValue.getText();
  }


}
