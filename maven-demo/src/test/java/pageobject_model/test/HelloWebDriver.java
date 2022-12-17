package pageobject_model.test;

import com.epam.automation.CustomConditions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageobject_model.driver.DriverSingleton;
import pageobject_model.page.HomePage;

import java.time.Duration;

public class HelloWebDriver {
    
    private WebDriver driver;


    @Test
    public void commonSearchTermResultsAreNotEmpty(){
        driver = DriverSingleton.getDriver();

        int expectedSearchResultsNumber = new HomePage(driver)
                .openPage()
                .searchForTerms("бюстгалтер")
                .countGeneralNumbersOfSearchResult();
        Assert.assertTrue(expectedSearchResultsNumber > 0, "Empty strings!");

    }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser(){
        DriverSingleton.closeDriver();
    }


    private static WebElement waitForElementLocatedBy(WebDriver driver, By by){
        return new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.presenceOfElementLocated(by));

    }
}
