@reqresin
Feature: Reqresin

  @positive @getusers
  Scenario: Success GET users
    When user send GET Users request to reqresin
    Then response status code should be 200
    And response structure should match json schema "users.json"

  @positive @postlogin
  Scenario: Success POST login
    When user send POST login request to reqresin
    Then response status code should be 200
    And response structure should match json schema "login.json"

  @positive @getsingle
  Scenario: Success GET single resource
    When user send GET Single request to reqresin with body json "success-get.json"
    Then response status code should be 201

  @positive @putupdate
  Scenario: Success PUT update
    When user send PUT Update request to reqresin
    Then response status code should be 200
    And response structure should match json schema "update-user.json"

  @negative @postlogin
  Scenario: Failed POST login
    When user send POST login request to reqresin with body json "failed-login.json"
    Then response status code should be 400



