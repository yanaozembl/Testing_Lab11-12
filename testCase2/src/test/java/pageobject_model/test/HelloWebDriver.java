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
import pageobject_model.model.DataClass;
import pageobject_model.page.FavouritesPage;
import pageobject_model.page.HomePage;

import java.time.Duration;

public class HelloWebDriver {
    
    private WebDriver driver;
    private DataClass dataClass = new DataClass();

    private static final String HOMEPAGE_URL = "https://hunkemoller.by/domashniaia-odejda";

    @Test
    public void commonSearchTermResultsAreNotEmpty(){
        driver = DriverSingleton.getDriver();

        HomePage homePage = new HomePage(driver).openPage();
        String selectedProductHomePage = homePage.getSelectedProduct();

        FavouritesPage favouritesPage = homePage.addProductToFavourites();

        dataClass.setSelectedProductFavouritesPage(favouritesPage.getSelectedProduct()) ;

        Assert.assertTrue(dataClass.getSelectedProductFavouritesPage().equals(selectedProductHomePage), "Different products!");

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
