package ui.web.pages;

import framework.selenium.UIMethods;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.web.BaseWebPage;

public class CreatedConfirmationPage extends BaseWebPage {
    @FindBy(xpath = "//h2[@class='title text-center']")
    WebElement title;
    public CreatedConfirmationPage() {
        PageFactory.initElements(driver, this);
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() throws WebDriverException {

    }

    public boolean isDisplayedTitle() {
        return title.isDisplayed();
    }

    public HomePage clickContinueButton() {
        UIMethods.clickWebElementJs("a[class='btn btn-primary']");
        return new HomePage();
    }
}
