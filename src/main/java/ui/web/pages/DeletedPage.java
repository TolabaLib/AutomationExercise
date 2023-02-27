package ui.web.pages;

import framework.selenium.UIMethods;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;
import ui.web.BaseWebPage;

public class DeletedPage extends BaseWebPage {

    @Override
    public void waitUntilPageObjectIsLoaded() throws WebDriverException {
        //deleteTitle = wait.until(ExpectedConditions.visibilityOf());
    }

    public boolean isDeleteTitleIsPresent() {
        return UIMethods.isWebElementPresentJs("h2[class='title text-center']");
    }

    public HomePage clickContinueButton() {
        UIMethods.clickWebElementJs("a[class='btn btn-primary']");
        return new HomePage();
    }
}
