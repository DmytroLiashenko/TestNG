import page.Pages;
import ConfigurationWebDriver.BaseClass;
import data.DataTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNG_DZ20 extends BaseClass {

    public static Pages pages;
    By courseMenu = By.xpath("//button[@data-dropdown-trigger='coursesMenu']");

    @BeforeClass
    public void beftest() {
        driver.get("https://ithillel.ua/");
        pages = new Pages(driver);
    }
    @Test
    public void test() {
        driver.findElement(courseMenu).getText();
    }

    @Test(dataProvider = "getCert", dataProviderClass = DataTest.class)
    public void Test2CheckCert(String certificateNumber, String expected) throws Exception {
        driver.get("https://certificate.ithillel.ua/");
        pages.sendCert(certificateNumber);
        Assert.assertEquals(Boolean.valueOf(expected), pages.CheckCert());

    }
}