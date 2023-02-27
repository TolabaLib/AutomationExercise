package ui.web.components;

import framework.selenium.UIMethods;
import io.restassured.http.Header;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;
import ui.web.pages.*;

public class HeaderMenu extends BasePageObject {
    @FindBy(xpath = "//a[href='/products']")
    WebElement productsItem;
    @FindBy(xpath = "//a[href='/view_cart']")
    WebElement cartItem;
    @FindBy(xpath = "//a[href='/login']")
    WebElement signupLoginItem;

    @FindBy(xpath = "//a[@href='/logout']")
    WebElement logoutItem;

    @FindBy(xpath = "//a[@href='/delete_account']")
    WebElement deleteItem;

    @FindBy(xpath = "//i[@class='fa fa-user']/ancestor::li")
    WebElement loggedItem;

    public HeaderMenu(){
        PageFactory.initElements(driver, this);
        waitUntilPageObjectIsLoaded();
    }
    @Override
    public void waitUntilPageObjectIsLoaded() {
        //myAccountButton = wait.until(ExpectedConditions.elementToBeClickable(myAccountButton));
    }

    public boolean isLogoutButtonDisplayed() {
        logoutItem = wait.until(ExpectedConditions.visibilityOf(logoutItem));
        return logoutItem.isDisplayed();
    }

    public boolean isLoggedItemDisplayed() {
        loggedItem = wait.until(ExpectedConditions.visibilityOf(loggedItem));
        return loggedItem.isDisplayed();
    }
    public ProductsPage goToProductsPage() {
        productsItem = wait.until(ExpectedConditions.visibilityOf(productsItem));
        productsItem.click();
        return new ProductsPage();
    }

    public CartPage goToCartPage() {
        cartItem.click();
        return new CartPage();
    }

    public SignUpLoginPage goToSignUpLoginPage() {
        signupLoginItem.click();
        return new SignUpLoginPage();
    }

    public SignUpLoginPage logout() {
        logoutItem.click();
        return new SignUpLoginPage();
    }

    public DeletedPage deleteAccount() {
        deleteItem.click();
        return new DeletedPage();
    }
}
