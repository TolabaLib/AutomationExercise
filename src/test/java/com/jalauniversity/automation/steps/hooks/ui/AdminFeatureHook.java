package com.jalauniversity.automation.steps.hooks.ui;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import ui.methods.CommonMethods;
import ui.web.components.HeaderMenu;
import ui.web.pages.DeletedPage;
import utils.LoggerManager;

public class AdminFeatureHook {
    private static final LoggerManager log = LoggerManager.getInstance();

    public AdminFeatureHook() {
    }

    @Before("@LoginCorrectly")
    public void createAUser() {
        CommonMethods.createUser();
    }
    @After("@LoginCorrectly")
    public void afterLoginAdmin() {
        CommonMethods.logout();
    }

    @After("@RegisterNewUser")
    public void afterRegisterNewUser() {
        HeaderMenu headerMenu = new HeaderMenu();
        DeletedPage deletedPage = headerMenu.deleteAccount();
        deletedPage.clickContinueButton();
    }
}
