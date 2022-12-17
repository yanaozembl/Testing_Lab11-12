package pageobject_model.page;

import com.epam.automation.CustomConditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {
    private final int WAIT_TIME_IN_SECONDS = 5;

    private WebDriver driver;

    @FindBy(xpath = "(//div[@class='filter-checkbox-img'])[1]")
    private WebElement checkBox;

    public HomePage(WebDriver driver, String url) {
        this.driver = driver;
        driver.get(url);


        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(CustomConditions.jQueryAJAXsCompleted());

        PageFactory.initElements(driver, this);

    }

    public SearchPage clickCheckBox() throws InterruptedException {
        checkBox.click();
        return new SearchPage(driver);
    }




}
