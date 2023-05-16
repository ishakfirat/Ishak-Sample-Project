
Feature: User should be able to login

  Background:
    Given The user is on the login page

  Scenario Outline: Log in as a <userType>
    When Log in as a "<userType>"
    And  The user enter "<username>" username field
    And  The user enter "<password>" password field
    And  The user click LOG IN button
    Then The user is on the "<page>" page
    Examples:
      | userType      | username        | password    | page            |
      | Driver        | user1           | UserUser123 | Quick Launchpad |
      | Sales Manager | salesmanager289 | UserUser123 | Dashboard       |
      | Store Manager | storemanager55  | UserUser123 | Dashboard       |






