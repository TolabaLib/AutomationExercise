@Products
Feature: Products

  Scenario: The user is able to access to the product page
    Given the user navigates to Products page
    When the user goes to the product details of one selected product
    Then the product information should be displayed


  Scenario Outline: The user is able to see the products according one subcategory
    Given the user navigates to Products page
    When the user selects a subcategory with the following values
      | category | subcategory |
      |<Category>|<Subcategory>|
    Then the user should see the list of the products of the subcategory that was selected
    Examples:
      | Category | Subcategory |
      | Women    | Tops        |
      | Kids     | Dress       |

  Scenario Outline: The user is able to see the products according one brand
    Given the user navigates to Products page
    When the user selects a brand with the following value
      | brand |
      |<Brand>|
    Then the user should see the list of the products of the brand that was selected
    Examples:
      | Brand          |
      | Polo           |
      | Mast & Harbour |