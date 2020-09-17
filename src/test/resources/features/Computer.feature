@computer_data
Feature: Computer Data Base Create, Update, Read and Delete Operations

  Background:
    Given user go to main page

  @title_check
  Scenario: User successfully landing main page
    Then user verify that title "Computers database"


  @create
  Scenario: User should be able to successfully create computer
    When user click Add new computer button
    And Verify add computer page title "Computers database"
    When user enter computer name "Asus 3446W", Introduced "2020-07-01", Discontinued "2020-09-01", Company "ASUS" and click Create computer button
    And user enter computer name "Asus 3446W" Filter by name input box and click search button
    Then verify that computer name "Asus 3446W" in the result table

  @read
  Scenario: User should be able to check a computer name details in the result table
    And user enter computer name "Acer Extensa" Filter by name input box and click search button
    When user click computer name "Acer Extensa"
    Then verify that computer name "Acer Extensa" in the result table

  @update
  Scenario: User should be able to update a computer name
    When user click computer name "Acer Extensa"
    And user enter "name", "Acer XRT" value
    And user click Save this computer button
    And user enter computer name "Acer XRT" Filter by name input box and click search button
    Then user verify computer name "Acer XRT" update in the table

  @delete
  Scenario: User should be able to delete a computer data
    When user click computer name "Acer Extensa"
    And user click delete this computer button
    And user enter computer name "Acer Extensa" Filter by name input box and click search button
    Then verify that computer name "Acer Extensa" not in the result table

  @duplicate
  Scenario: User not should be able to create same computer as a duplicate
    When user click Add new computer button
    And Verify add computer page title "Computers database"
    When user enter computer name "Huwai 1001", Introduced "2016-01-01", Discontinued "2019-09-01", Company "Sanyo" and click Create computer button
    When user click Add new computer button
    When user enter computer name "Huwai 1001", Introduced "2016-01-01", Discontinued "2019-09-01", Company "Sanyo" and click Create computer button
    Then verify user shouldn't second duplicate computer name as a "Huwai 1001"


  @negative_ddt
  Scenario Outline: User not able to create computer with invalid data <type>
    When user click Add new computer button
    When user enter computer name "<computer name>", Introduced "<introduced date>", Discontinued "<discontinued date>", Company "<company>" and click Create computer button
    Then verify "<error message>"
    Examples:
      | computer name | introduced date | discontinued date | company | error message         | type                  |
      |               | 2016-01-01      | 2019-09-01        | IBM     | Failed to refine type | blank computer name   |
      | !@#$%^145^%#  | 2016-01-01      | 2019-09-01        | IBM     | Failed to refine type | invalid computer name |
      | Acer 5667POL  | invalid date    | invalid date      | IBM     | Failed to decode date | invalid date          |

  @cancel
  Scenario: User should be able to cancel option during the create a computer
    When user click Add new computer button
    And Verify add computer page title "Computers database"
    When user enter computer name "ZlmC 3445F", Introduced "2015-07-24", Discontinued "2020-02-01", Company "Canon" and click Cancel button
    And user enter computer name "ZlmC 3445F" Filter by name input box and click search button
    Then verify that computer name "ZlmC 3445F" not display in the result table

  @cancel
  Scenario: User should be able to cancel update a computer name
    When user click computer name "ACE"
    And user enter "name", "Acer MLM" value
    And user click Cancel this computer button
    And user enter computer name "Acer MLM" Filter by name input box and click search button
    Then verify that computer name "Acer MLM" not display in the result table

  @asc_desc
  Scenario: User should be able to check all order by ascending
    When user click "Computer name" link
    Then verify "name" result should be ascending "asc"
    When user click "Introduced" link
    Then verify "introduced" result should be ascending "asc"
    When user click "Discontinued" link
    Then verify "discontinued" result should be ascending "asc"
    When user click "Company" link
    Then verify "companyName" result should be ascending "asc"




