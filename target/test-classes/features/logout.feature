Feature: User should be able to log out
  Agile story:The user can log out using the log-out button inside
  the profile info and end up on the login page.
  @wip
  Scenario Outline: Logout as a "<userType>"

    Given "<userType>" is on the the login page by entering "<username>" and "<password>"
    When User go to profile menu and click the down arrow icon
    And User sees Logout button and click it
    Then User should see login page
    Examples:
      | userType      | username        | password    |
      | Driver        | user1           | UserUser123 |
      | Sales manager | salesmanager289 | UserUser123 |
      | Store Manager | storemanager55  | UserUser123 |