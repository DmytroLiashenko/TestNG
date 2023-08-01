package ConfigurationWebDriver;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BaseClass {
   public static WebDriver driver;
   @BeforeClass
   public static void BeforParent(){
      driver= ConfigurationWebDriver.createDriver(WebDrivers.CHROME);

   }
   @AfterClass
   public static void afterParent() throws InterruptedException {
      Thread.sleep(3000);
      driver.quit();
   }

}
