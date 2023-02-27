package ui.methods;

import framework.CredentialsManager;
import ui.PageTransporter;
import ui.web.components.HeaderMenu;
import ui.web.pages.CreateUserPage;
import ui.web.pages.CreatedConfirmationPage;
import ui.web.pages.HomePage;
import ui.web.pages.SignUpLoginPage;
import utils.LoggerManager;

public class CommonMethods {
    private static final LoggerManager log = LoggerManager.getInstance();
    private static final PageTransporter pageTransporter = PageTransporter.getInstance();
    private static HeaderMenu headerMenu;

    public static void logout() {
        if (pageTransporter.isOnLoginAdminPage()) {
            headerMenu = new HeaderMenu();
            headerMenu.logout();
        }
    }

    public static void createUser() {
        SignUpLoginPage loginPage = pageTransporter.navigateToAdminLoginPage();
        loginPage.setUsernameTextBox(CredentialsManager.getInstance().getUsername());
        loginPage.setNewEmailTextBox(CredentialsManager.getInstance().getEmail());
        CreateUserPage createUserPage = loginPage.clickSignupButton();
        createUserPage.clickPassword(CredentialsManager.getInstance().getPassword());
        createUserPage.clickFirstName("first name");
        createUserPage.clickLastName("last name");
        createUserPage.clickAddress("address");
        createUserPage.clickState("state");
        createUserPage.clickCity("city");
        createUserPage.clickZipCode("zip code");
        createUserPage.clickMobileNumber("mobile number");
        CreatedConfirmationPage createdConfirmationPage = createUserPage.clickCreateButton();
        HomePage homePage = createdConfirmationPage.clickContinueButton();
        homePage.headerMenu.logout();
    }
}
