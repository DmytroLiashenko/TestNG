package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pages {
    @FindBy (xpath = "//button[@data-dropdown-trigger='coursesMenu']")
   WebElement course;

    public Pages(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    static WebDriver driver;

    @FindBy(name = "certificate")
    WebElement searchField;
    @FindBy(id = "certificateCheckForm")
    WebElement formCert;

    public void sendCert(String certNumber){
        searchField.sendKeys(certNumber);
        searchField.sendKeys(Keys.ENTER);
    }

    public Boolean CheckCert() throws Exception {
        boolean result;
        int i=0;
        while (true){
            if(driver.getCurrentUrl().contains("view")) {
                result=true;
                break;
            }
            if (formCert.getAttribute("class").contains("invalid")){
                result=false;
                break;
            }
            Thread.sleep(1000);
            i++;
            if (i>10){
                throw new Exception("Out of time check cert");
            }
        }
        return result;
    }
}