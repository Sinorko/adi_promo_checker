import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MainClass {

  public static WebDriver driver;
  public static CartPage cartPage;
  public static EnterPage enterPage;


  public static void main(String[] args) {
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\sinor\\Downloads\\chromedriver.exe");
    init();
    try {
      System.out.println(getDiscount("U10-STK6-Q6VK-DLFL-VTWF4"));
    } catch (CouponApplyException e) {
      e.printStackTrace();
    }
    driver.close();
  }


  public static void init() {
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("https://www.adidas.ru/account-login");
    enterPage = new EnterPage(driver);
    enterPage.enterEmail("testtasknnv@gmail.com");
    enterPage.enterPassword("pUvQAb10");
    enterPage.clickButton();
    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class*=myaccount-page___]")));
    driver.get("https://www.adidas.ru/cart");
    cartPage = new CartPage(driver);
    if (cartPage.isApplied()) {
      cartPage.closeApplied();
    }
  }

  public static String getDiscount(String coupon) throws CouponApplyException {
    cartPage.inputCoupon(coupon);
    cartPage.clickApplyCouponButton();
    if (cartPage.isApplied()) {
      return cartPage.getDiscText();
    } else {
      if (cartPage.isError()) {
        return "Coupon no exist";
      } else {
        throw new CouponApplyException();
      }
    }
  }
}
