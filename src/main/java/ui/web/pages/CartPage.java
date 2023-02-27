package ui.web.pages;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import ui.BasePageObject;
import ui.web.BaseWebPage;

public class CartPage extends BaseWebPage {
    WebElement deleteButton;
    WebElement checkoutButton;
    WebElement quantity;

    WebElement message;
    @Override
    public void waitUntilPageObjectIsLoaded() throws WebDriverException {

    }
}
