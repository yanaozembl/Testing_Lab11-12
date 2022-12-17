package pageobject_model.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageobject_model.driver.DriverSingleton;
import pageobject_model.page.HomePage;
import pageobject_model.page.SearchPage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;
import static org.testng.AssertJUnit.assertFalse;

public class HelloWebDriver {
    
    private WebDriver driver;

    private static final String HOMEPAGE_URL = "https://hunkemoller.by/domashniaia-odejda";

    @Test
    public void commonSearchTermResultsAreNotEmpty(){
        driver = DriverSingleton.getDriver();

        HomePage homePage = new HomePage(driver, HOMEPAGE_URL);

        SearchPage pantsSearchPage = homePage.clickCheckBox();
        synchronized (pantsSearchPage){
            try{
                pantsSearchPage.wait(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        SearchPage pajamasSearchPage = pantsSearchPage.clickPajamasHref();
        synchronized (pajamasSearchPage){
            try{
                pajamasSearchPage.wait(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        pajamasSearchPage.getSelectedProduct().getNameOfPage();

        Assert.assertTrue(pajamasSearchPage.dataClass.getNameOfProduct().contains("Брюки") &&
                        pajamasSearchPage.dataClass.getNameOfPage().contains("Пижамы")
                        , "Different products!");

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
