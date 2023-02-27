package ui.web.pages;

import framework.CredentialsManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.web.BaseWebPage;
import utils.LoggerManager;

public class SignUpLoginPage extends BaseWebPage {
    private static final LoggerManager log = LoggerManager.getInstance();

    @FindBy(xpath = "//h2")
    WebElement loginTitle;
    @FindBy(xpath = "//input[@name='email']")
    WebElement emailTextBox;

    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordTextBox;

    @FindBy(xpath = "//button[@class='btn btn-default']")
    WebElement loginSubmitButton;

    @FindBy(xpath = "//div[@class='login-form']/descendant::p")
    WebElement errorLoginMessage;

    @FindBy(xpath = "//input[@name='name']")
    WebElement usernameTextBox;

    @FindBy(xpath = "//div[@class='signup-form']/descendant::input[@name='email']")
    WebElement newEmailTextBox;

    @FindBy(xpath = "//button[text()='Signup']")
    WebElement signupSubmitButton;

    @FindBy(xpath = "//div[@class='signup-form']/descendant::p")
    WebElement errorSignupMessage;

    public SignUpLoginPage() {
        PageFactory.initElements(driver, this);
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        emailTextBox = wait.until(ExpectedConditions.elementToBeClickable(emailTextBox));
        passwordTextBox = wait.until(ExpectedConditions.elementToBeClickable(passwordTextBox));
        loginSubmitButton = wait.until(ExpectedConditions.elementToBeClickable(loginSubmitButton));
    }

    public void setEmailTextBox(String email) {
        emailTextBox.click();
        emailTextBox.clear();
        emailTextBox.sendKeys(email);
    }

    public void setPasswordTextBox(String password) {
        passwordTextBox.click();
        passwordTextBox.clear();
        passwordTextBox.sendKeys(password);
    }

    public void clickLoginButton() {
        loginSubmitButton.submit();
    }

    public HomePage loginWithUser() {
        setEmailTextBox(CredentialsManager.getInstance().getEmail());
        setPasswordTextBox(CredentialsManager.getInstance().getPassword());
        clickLoginButton();
        return new HomePage();
    }

    public boolean isDisplayedError(){
        return errorLoginMessage.isDisplayed();
    }

    public void setNewEmailTextBox(String newEmail) {
        newEmailTextBox.click();
        newEmailTextBox.clear();
        newEmailTextBox.sendKeys(newEmail);
    }

    public void setUsernameTextBox(String username) {
        usernameTextBox.click();
        usernameTextBox.clear();
        usernameTextBox.sendKeys(username);
    }

    public CreateUserPage clickSignupButton() {
        signupSubmitButton.click();
        return new CreateUserPage();
    }

    public boolean isDisplayedSignupError(){
        return errorSignupMessage.isDisplayed();
    }

    public boolean isDisplayedLoginTitle() {
        return loginTitle.isDisplayed();
    }
}
