package ui.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;
import ui.web.BaseWebPage;

import java.util.List;

public class ProductsPage extends BaseWebPage {
    WebElement title;
    List<WebElement> productsList;
    WebElement searchBox;

    WebElement searchBoxButton;

    public ProductsPage() {
        PageFactory.initElements(driver, this);
        waitUntilPageObjectIsLoaded();
    }
    @Override
    public void waitUntilPageObjectIsLoaded() throws WebDriverException {

    }

    public void clickOnCategory(String category) {
        String categoryLocator = String.format("//a[normalize-space()='%s']/parent::h4/descendant::span[@class=\"badge pull-right\"]", category);
        WebElement dropdownButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(categoryLocator)));
        dropdownButton.click();
    }

    public void clickOnSubcategory(String subcategory) {
        String subcategoryLocator = String.format("//a[normalize-space()='%s']", subcategory);
        WebElement subcategoryButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(subcategoryLocator)));
        subcategoryButton.click();
    }
    public void clickOnBrand(String brand) {
        String brandLocator = String.format("//a[text()='%s']", brand);
        WebElement brandButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(brandLocator)));
        brandButton.click();
    }


}
