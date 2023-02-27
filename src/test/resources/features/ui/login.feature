@SignupLogin @UI
Feature: Signup/Login User

  @LoginCorrectly
  Scenario: A user should be able to login into the page
    Given the user navigates to Login page
    When the user login to the page as a user
    Then the user should login into the page successfully

  @LoginWithoutCredentials @Problem
  Scenario: The user gets a warning message when login without credentials
    Given the user navigates to Login page
    When the user login in without email and password field
    Then the user should stay on the login page and not login

  @LoginWithInvalidCredentials
  Scenario: The user gets an error message when login with incorrect email and password
    Given the user navigates to Login page
    When the user login in with invalid account with the following values
      | email                   | password |
      | administrator2@gmail.com| 1234     |
      | user@gmail.com          | 123456   |
    Then the user should have a error message into the page

  @LogoutUser
  Scenario: A user should be able to logout into the page
    Given the user navigates to Login page
    And the user login to the page as a user
    When the user logs out using the header menu item of logout
    Then the user should be in the login page

  @RegisterNewUser
  Scenario Outline: The user is able to register into the page
    Given the user navigates to Login page
    When the user makes signup with the following values
      | username | email |
      |<Username>|<Email>|
    And the user fills in the form with the corresponding values
      | password | first name | last name | address | state | city | zip code | mobile number |
      |<Password>|<First Name>|<Last Name>|<Address>|<State>|<City>|<Zip Code>|<Mobile Number>|
    Then the user should redirect to the new page of account created
    And the user should be logged into the page
    Examples:
        | Username | Email             | Password  | First Name | Last Name | Address   | State  | City    | Zip Code | Mobile Number |
        | test     | test1@outlook.com | 123456    | Test       | Test      | Av. Sucre | La Paz | Alto    | 999      | 6077777       |
        | vivi     | vivi1@gmail.com   | 12345     | Vivi       | Tolaba    | Av. Pando | Cbba   | Cercado | 000      | 7111111       |

  @RegisterUser @Bug
  Scenario Outline: The user is not able to register with incorrect information
    Given the user navigates to Login page
    When the user makes signup with the following values
      | username | email |
      |<Username>|<Email>|
    And the user fills in the form with the corresponding values
      | password | first name | last name | address | state | city | zip code | mobile number |
      |<Password>|<First Name>|<Last Name>|<Address>|<State>|<City>|<Zip Code>|<Mobile Number>|
    Then the user should have warning messages in the fields
    Examples:
      | Username | Email             | Password  | First Name | Last Name | Address   | State  | City    | Zip Code | Mobile Number |
      | test     | testE@outlook.com | .         | %^         | ))        | ---       | ____   | &&&     | rrrr     | 0             |
      | vivi     | viviE@gmail.com   | 1         |    .       | (     (   | +         |    >   |       . | s        | 1             |

  @RegisterWithExistingEmail
  Scenario Outline: The user gets an error when register user with existing email
    Given the user navigates to Login page
    When the user signs up with the existing email
      | username | email |
      |<Username>|<Email>|
    Then the user should get an error message into the page
    Examples:
      | Username | Email                    |
      | Andre    | administrator12@gmail.com |

  @RegisterWithoutCredentials @Problem
  Scenario: The user gets a warning message when signup without credentials
    Given the user navigates to Login page
    When the user signs up in without email and password field
    Then the user should stay on the signup page

  @DeleteAUser
  Scenario: A user should be able to delete his account
    Given the user navigates to Login page
    And the user login to the page as a user
    When the user deletes his account using the header menu item of delete
    Then the user should be in the deleted page
    And the user should redirect in the home page