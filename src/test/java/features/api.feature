Feature: Automation Rest API

  @api
  Scenario: Get list data
    Given prepare url for "GET_LIST_USERS"
    And hit API get list users
    Then validation response status code equals to 200
    Then validation response body get list users
    Then validation response json with JSONSchema "get_list_users_normal.json"

  @api
  Scenario: Create new user
    Given prepare url for "CREATE_USER"
    And hit API post create user
    Then validation response status code equals to 201
    Then validation response body post create new user
    Then validation response json with JSONSchema "post_create_new_user_normal.json"

  @api
  Scenario: Delete user
    Given prepare url for "DELETE_USER"
    And hit API post create user
    Then validation response status code equals to 201
    Then validation response body post create new user
    And hit API delete user
    Then validation response status code equals to 204

  @api
  Scenario: Update user
    Given prepare url for "CREATE_USER"
    And hit API post create user
    Then validation response status code equals to 201
    Then validation response body post create new user
    And hit API update user
    Then validation response status code equals to 200
    Then validation response body update user

  @api
  Scenario: Get user details
    Given prepare url for "CREATE_USER"
    And hit API post create user
    Then validation response status code equals to 201
    Then validation response body post create new user
    And hit API get user details
    Then validation response status code equals to 200
    Then validation response body get user details

  @api
  Scenario: Get user posts
    Given prepare url for "CREATE_USER"
    And hit API post create user
    Then validation response status code equals to 201
    Then validation response body post create new user
    And hit API get user posts
    Then validation response status code equals to 200
    Then validation response body get user posts

  @api
  Scenario: Post user posts
    Given prepare url for "CREATE_USER"
    And hit API post create user
    Then validation response status code equals to 201
    Then validation response body post create new user
    And hit API post user posts
    Then validation response status code equals to 201
    Then validation response body post user posts

  @api
  Scenario: Get user todo
    Given prepare url for "CREATE_USER"
    And hit API post create user
    Then validation response status code equals to 201
    Then validation response body post create new user
    And hit API get user todo
    Then validation response status code equals to 200
    Then validation response body get user todo

  @api
  Scenario: Post user todo
    Given prepare url for "CREATE_USER"
    And hit API post create user
    Then validation response status code equals to 201
    Then validation response body post create new user
    And hit API post user todo
    Then validation response status code equals to 201
    Then validation response body post user todo


  @api
  Scenario: Get user comment
    Given prepare url for "CREATE_USER"
    And hit API post create user
    Then validation response status code equals to 201
    Then validation response body post create new user
    And hit API post user posts
    Then validation response status code equals to 201
    Then validation response body post user posts
    And prepare url for "CREATE_POST_COMMENT"
    Then hit API get user comment
    Then validation response status code equals to 200
    Then validation response body get user comment

  @api
  Scenario: Post user comment
    Given prepare url for "CREATE_USER"
    And hit API post create user
    Then validation response status code equals to 201
    Then validation response body post create new user
    And hit API post user posts
    Then validation response status code equals to 201
    Then validation response body post user posts
    And prepare url for "CREATE_POST_COMMENT"
    Then hit API post user comment
    Then validation response status code equals to 201
    Then validation response body post user comment
