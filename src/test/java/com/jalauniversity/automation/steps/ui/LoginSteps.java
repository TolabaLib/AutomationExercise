package com.jalauniversity.automation.steps.ui;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import ui.PageTransporter;
import ui.web.pages.*;

import java.util.List;
import java.util.Map;

public class LoginSteps {

    private final PageTransporter pageTransporter;
    private SignUpLoginPage loginPage;
    private HomePage homeAdminPage;
    private CreateUserPage createUserPage;
    private CreatedConfirmationPage createdConfirmationPage;
    private DeletedPage deletedPage;
    public LoginSteps() {
        this.pageTransporter = PageTransporter.getInstance();
    }

    @Given("^the user navigates to Login page$")
    public void navigateToAdminLoginPage() {
        loginPage = pageTransporter.navigateToAdminLoginPage();
    }

    @Given("^the user login to the page as a user$")
    public void loginToAdmin() {
        homeAdminPage = loginPage.loginWithUser();
    }
    @Given("^the user login in with invalid account with the following values$")
    public void loginWithInvalidAccount(DataTable table) {
        List<Map<String, String>> queryParamsList = table.asMaps(String.class, String.class);
        Map<String, String> params = queryParamsList.get(0);
        loginPage.setEmailTextBox(params.get("email"));
        loginPage.setPasswordTextBox(params.get("password"));
        loginPage.clickLoginButton();
    }
    @Given("the user login in without email and password field")
    public void loginWithoutCredentials() {
        loginPage.clickLoginButton();
    }
    @Given("the user logs out using the header menu item of logout")
    public void logoutWithTheHeaderItem() {
        loginPage = homeAdminPage.headerMenu.logout();
    }

    @Given("^the user makes signup with the following values|the user signs up with the existing email$")
    public void signupNewUser(DataTable table) {
        List<Map<String, String>> queryParamsList = table.asMaps(String.class, String.class);
        Map<String, String> params = queryParamsList.get(0);
        loginPage.setUsernameTextBox(params.get("username"));
        loginPage.setNewEmailTextBox(params.get("email"));
        createUserPage = loginPage.clickSignupButton();
    }

    @Given("the user fills in the form with the corresponding values")
    public void fillTheFormOfNewUser(DataTable table) {
        List<Map<String, String>> queryParamsList = table.asMaps(String.class, String.class);
        Map<String, String> params = queryParamsList.get(0);
        createUserPage.clickPassword(params.get("password"));
        createUserPage.clickFirstName(params.get("first name"));
        createUserPage.clickLastName(params.get("last name"));
        createUserPage.clickAddress(params.get("address"));
        createUserPage.clickState(params.get("state"));
        createUserPage.clickCity(params.get("city"));
        createUserPage.clickZipCode(params.get("zip code"));
        createUserPage.clickMobileNumber(params.get("mobile number"));
        createdConfirmationPage = createUserPage.clickCreateButton();
    }
    @Given("the user signs up in without email and password field")
    public void signupWithoutCredentials() {
        loginPage.clickLoginButton();
    }

    @Given("the user deletes his account using the header menu item of delete")
    public void clickDeleteItem() {
        deletedPage = homeAdminPage.headerMenu.deleteAccount();
    }
    @Then("^the user should login into the page successfully$")
    public void verifyLoginToAdminPage() {
        boolean isLogoutButtonDisplayed = homeAdminPage.headerMenu.isLogoutButtonDisplayed();
        boolean isLoggedItem = homeAdminPage.headerMenu.isLoggedItemDisplayed();
        Assert.assertTrue(isLogoutButtonDisplayed, "Logout was not displayed");
        Assert.assertTrue(isLoggedItem, "Logged item was not displayed");
    }

    @Then("^the user should stay on the login page and not login|the user should stay on the signup page$")
    public void verifyThatGetWarning() {
        boolean isOnLoginPage = loginPage.isDisplayedLoginTitle();
        Assert.assertTrue(isOnLoginPage, "The user was not in the login page");
    }

    @Then("the user should have a error message into the page")
    public void verifyThatGetErrorMessage() {
        boolean isErrorMessageDisplayed = loginPage.isDisplayedError();
        Assert.assertTrue(isErrorMessageDisplayed, "The error message was not displayed");
    }

    @Then("the user should logout into the page successfully")
    public void verifyLogoutSuccessfully() {
        boolean isLogged = homeAdminPage.headerMenu.isLogoutButtonDisplayed();
        Assert.assertFalse(isLogged, "The logout was not successfully");
    }
    @Then("the user should redirect to the new page of account created")
    public void verifyDisplayTheCreatePage() {
        boolean isCreated = createdConfirmationPage.isDisplayedTitle();
        homeAdminPage = createdConfirmationPage.clickContinueButton();
        Assert.assertTrue(isCreated, "The user was not created successfully");
    }

    @Then("the user should be logged into the page")
    public void verifyLoggedOfUser() {
        boolean isInHome = homeAdminPage.headerMenu.isLoggedItemDisplayed();
        Assert.assertTrue(isInHome, "The user was not created successfully");
    }

    @Then("the user should have warning messages in the fields")
    public void verifyGetErrorMessage() {
        boolean isCreated = createdConfirmationPage.isDisplayedTitle();
        Assert.assertFalse(isCreated, "The user was created with incorrect data");
    }

    @Then("the user should get an error message into the page")
    public void verifyGetSignupErrorMessage() {
        boolean isErrorMessageDisplayed = loginPage.isDisplayedSignupError();
        Assert.assertTrue(isErrorMessageDisplayed, "The error message was not displayed");
    }

    @Then("the user should be in the login page")
    public void verifyLogout() {
        boolean isOnLoginPage = loginPage.isDisplayedLoginTitle();
        Assert.assertTrue(isOnLoginPage, "The user was not in the login page");
    }

    @Then("the user should be in the deleted page")
    public void verifyDeleteAccount() {
        boolean isOnDeletedPage = deletedPage.isDeleteTitleIsPresent();
        Assert.assertTrue(isOnDeletedPage, "The user was not in the deleted page");
    }
    @Then("the user should redirect in the home page")
    public void verifyIsInHomePage() {
        homeAdminPage = deletedPage.clickContinueButton();
        boolean isOnHomePage = homeAdminPage.isDisplayTitle();
        Assert.assertTrue(isOnHomePage, "The user was not in the home page");
    }
}
