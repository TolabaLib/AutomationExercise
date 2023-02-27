package ui.web;

import org.openqa.selenium.WebDriverException;
import ui.BasePageObject;
import ui.web.components.HeaderMenu;

public abstract class BaseWebPage extends BasePageObject {
    public HeaderMenu headerMenu;

    public BaseWebPage() {
        headerMenu = new HeaderMenu();
    }
}
