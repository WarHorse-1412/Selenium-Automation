Feature: User Login Functionality
  As a registered user
  I want to be able to log in to the application
  So that I can access my personalized content
# 

  Scenario: Successful login with valid credentials
    And User navigates to loginpage
    And User validates all fields in the UI
    And User prints the list of usernames
    And User enters "<username>" and "<password>"
    Then User lands in homepage
  # 

    @LoginPage
    Examples:
      | username        | password     |
      | standard_user   | secret_sauce |
      | visual_user     | secret_sauce |
