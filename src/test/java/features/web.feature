Feature: Test web automation SauceDemo

  @web
  Scenario: Test Login Web
    Given Open web page
    And click link for "Login"
    And Pop up is displayed for "Login"
    And User input username "standard_user"
    And User input password "secret_sauce"
    When click "Login" button
    Then User will see "Welcome" text

  @web
  Scenario: Test Login Web Standard User Invalid Password
    Given Open web page
    And click link for "Login"
    And Pop up is displayed for "Login"
    And User input username "standard_user"
    And User input password "invalid"
    When click "Login" button
    Then Message alert is displayed "Wrong password."

  @web
  Scenario: Test Login Web Non-existent User
    Given Open web page
    And click link for "Login"
    And Pop up is displayed for "Login"
    And User input username "standar"
    And User input password "invalid"
    When click "Login" button
    Then Message alert is displayed "User does not exist."

  @web
  Scenario: Test Sign Up Valid User
    Given Open web page
    And click link for "Sign Up"
    And Pop up is displayed for "Sign Up"
    And User input username "new_user"
    And User input password "password"
    When click "Sign Up" button
    Then Message alert is displayed "Sign up successful."

  @web
  Scenario: Test Sign Up Existing User
    Given Open web page
    And click link for "Sign Up"
    And Pop up is displayed for "Sign Up"
    And User input username "existing_user"
    And User input password "password"
    When click "Sign Up" button
    Then Message alert is displayed "This user already exist."

  @web
  Scenario: Test Send Contact Message
    Given Open web page
    And click link for "Contact"
    And Pop up is displayed for "Contact"
    And User input contact "email"
    And User input contact "name"
    And User input contact "message"
    When click "Send message" button
    Then Message alert is displayed "Thanks for the message!!"

  @web
  Scenario: Test Open About Popup
    Given Open web page
    When click link for "About"
    Then Pop up is displayed for "About"
    And click "Close About" button

  @web
  Scenario: Test Open Cart Page
    Given Open web page
    When click link for "Cart"
    Then User will see "Products" text

  @web
  Scenario: Test Add Item to Cart (Not Logged In)
    Given Open web page
    And click product link for Samsung Galaxy S6
    And click Add to Cart button
    And click link for "Cart"
    And verify product is in cart
    When click Place Order button
    Then fill order form
    And verify order is successful


