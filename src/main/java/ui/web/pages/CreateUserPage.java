package ui.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.web.BaseWebPage;

public class CreateUserPage extends BaseWebPage {
    @FindBy(id = "password")
    WebElement passwordField;
    @FindBy(id = "first_name")
    WebElement firstNameField;
    @FindBy(id = "last_name")
    WebElement lastNameField;
    @FindBy(id = "address1")
    WebElement addressField;
    @FindBy(id = "state")
    WebElement stateField;
    @FindBy(id = "city")
    WebElement cityField;
    @FindBy(id = "zipcode")
    WebElement zipCodeField;
    @FindBy(id = "mobile_number")
    WebElement mobileNumberField;

    @FindBy(xpath = "//button")
    WebElement createButton;

    public CreateUserPage() {
        PageFactory.initElements(driver, this);
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() throws WebDriverException {

    }
    public void clickTitle(String title) {
        String radioLocator = String.format("//input[@value='%s']", title);
        WebElement titleRadioButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(radioLocator)));
        titleRadioButton.click();
    }

    public void clickPassword(String password) {
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickFirstName(String firstname) {
        firstNameField.click();
        firstNameField.clear();
        firstNameField.sendKeys(firstname);
    }

    public void clickLastName(String lastname) {
        lastNameField.click();
        lastNameField.clear();
        lastNameField.sendKeys(lastname);
    }

    public void clickAddress(String address) {
        addressField.click();
        addressField.clear();
        addressField.sendKeys(address);
    }

    public void clickState(String state) {
        stateField.click();
        stateField.clear();
        stateField.sendKeys(state);
    }
    public void clickCity(String city) {
        cityField.click();
        cityField.clear();
        cityField.sendKeys(city);
    }

    public void clickZipCode(String zipCode) {
        zipCodeField.click();
        zipCodeField.clear();
        zipCodeField.sendKeys(zipCode);
    }

    public void clickMobileNumber(String mobileNumber) {
        mobileNumberField.click();
        mobileNumberField.clear();
        mobileNumberField.sendKeys(mobileNumber);
    }

    public CreatedConfirmationPage clickCreateButton() {
        createButton.click();
        return new CreatedConfirmationPage();
    }
}
