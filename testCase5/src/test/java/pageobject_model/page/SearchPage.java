package pageobject_model.page;

import com.epam.automation.CustomConditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject_model.model.DataClass;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class SearchPage {

    private WebDriver driver;

    public DataClass dataClass = new DataClass();

    @FindBy(xpath ="(//div[@class='h5 card-title m-0 pt-1 pb-0 h-100 product-name']/descendant::span)[1]")
    private WebElement nameOfProduct;

    @FindBy(xpath = "(//span[@class='icons icons-top-arrow text-hkm-darkgray'])[1]")
    private WebElement iconOfArrow;

    @FindBy(xpath = "(//span[@class='font-body'])[1]")
    private WebElement pajamasHref;

    @FindBy(xpath = "//div[@class='mb-2']/descendant::h1")
    private WebElement nameOfPage;

    public SearchPage(WebDriver driver){
        this.driver = driver;

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(CustomConditions.jQueryAJAXsCompleted());

        PageFactory.initElements(driver, this);
    }

    public SearchPage getSelectedProduct(){
        this.dataClass.setNameOfProduct(nameOfProduct.getText());
        return this;
    }

    public void getNameOfPage(){
        this.dataClass.setNameOfPage(nameOfPage.getText());
    }

    public SearchPage clickPajamasHref(){

        iconOfArrow.click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(elementToBeClickable(pajamasHref));
        pajamasHref.click();

        return new SearchPage(driver);
    }
}
