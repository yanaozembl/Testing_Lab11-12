package pageobject_model.page;

import com.epam.automation.CustomConditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class SearchPage {

    private WebDriver driver;
    @FindBy(xpath ="(//div[@class='h5 card-title m-0 pt-1 pb-0 h-100 product-name']/descendant::span)[1]")
    private WebElement nameOfProduct;


    public SearchPage(WebDriver driver){
        this.driver = driver;

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(CustomConditions.jQueryAJAXsCompleted());

        PageFactory.initElements(driver, this);
    }

    public String getSelectedProduct(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(visibilityOf(nameOfProduct));

        String name = nameOfProduct.getText();

        return name;
    }
}
