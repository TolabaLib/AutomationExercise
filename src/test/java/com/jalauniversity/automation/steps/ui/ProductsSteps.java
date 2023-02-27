package com.jalauniversity.automation.steps.ui;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import ui.PageTransporter;
import ui.web.pages.ProductsPage;

public class ProductsSteps {
    private final PageTransporter pageTransporter;
    private ProductsPage productsPage;

    public ProductsSteps() {
        pageTransporter = PageTransporter.getInstance();;
    }

    @Given("the user navigates to Products page")
    public void navigateProductsPage() {
        productsPage = pageTransporter.navigateToProductsPage();
    }
    @Given("the user goes to the product details of one selected product")
    public void clickOnOneProduct() {

    }

    @Given("the user selects a subcategory with the following values")
    public void selectSubcategory(DataTable dataTable) {

    }
    @Given("the user selects a brand with the following value")
    public void selectBrand(DataTable dataTable) {

    }
    @Then("the product information should be displayed")
    public void verifyProductInformation() {

    }
    @Then("the user should see the list of the products of the subcategory that was selected")
    public void verifyDisplayTheSubcategory() {

    }
    @Then("the user should see the list of the products of the brand that was selected")
    public void verifyDisplayTheBrand() {
    }
}
