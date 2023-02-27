package ui;

import framework.CredentialsManager;
import framework.selenium.DriverManager;
import org.openqa.selenium.WebDriver;
import ui.web.pages.ProductsPage;
import ui.web.pages.SignUpLoginPage;
import utils.LoggerManager;

public class PageTransporter {
    private static final LoggerManager log = LoggerManager.getInstance();
    private static final CredentialsManager credentialsManager = CredentialsManager.getInstance();

    private WebDriver driver;
    private String loginURL;
    private String productsURL;
    private static PageTransporter instance;

    protected PageTransporter() {
        initialize();
    }

    public static PageTransporter getInstance() {
        if (instance == null) {
            instance = new PageTransporter();
        }
        return instance;
    }

    private void initialize() {
        log.info("Initializing Page Transporter");
        loginURL = credentialsManager.getLoginURL();
        productsURL = credentialsManager.getProductsURL();
        driver = DriverManager.getInstance().getWebDriver();
    }

    private void goToURL(String url) {
        driver.navigate().to(url);
    }

    public boolean isOnLoginAdminPage() {
        return driver.getCurrentUrl().contains(loginURL);
    }

    public SignUpLoginPage navigateToAdminLoginPage() {
        if (!isOnLoginAdminPage()) {
            goToURL(loginURL);
        }
        return new SignUpLoginPage();
    }

    public boolean isOnProductsPage() {
        return driver.getCurrentUrl().contains(productsURL);
    }
    public ProductsPage navigateToProductsPage() {
        if (!isOnProductsPage()) {
            goToURL(productsURL);
        }
        return new ProductsPage();
    }
}
