package ui.web.pages;

import framework.selenium.UIMethods;
import org.checkerframework.checker.guieffect.qual.UI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.web.BaseWebPage;
import utils.LoggerManager;

public class HomePage extends BaseWebPage {
    @FindBy(xpath = "//h2[text()='Features Items']")
    WebElement title;
    public HomePage() {
        PageFactory.initElements(driver, this);
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
    }

    public boolean isDisplayTitle() {
        return UIMethods.isWebElementVisibleJs(title);
    }
}
