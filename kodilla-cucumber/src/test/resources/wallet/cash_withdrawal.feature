Feature:  Cash withdrawal

  Scenario: Successful withdrawal from a wallet in credit
    Given I have deposited $200 in my wallet
    When I request $30
    Then $30 should be dispensed
    And the balance of my wallet should be $170

  Scenario: Withdrawal amount exceeds wallet balance
    Given I have deposited $50 in my wallet
    When I request $100
    Then $0 should be dispensed
    And I should be told that I have insufficient funds
    And the balance of my wallet should be $50


  Scenario: Withdrawal of exact wallet balance
    Given I have deposited $100 in my wallet
    When I request $100
    Then $100 should be dispensed
    And the balance of my wallet should be $0

  Scenario: Withdrawal of zero dollars
    Given I have deposited $100 in my wallet
    When I request $0
    Then $0 should be dispensed
    And I should be told that withdrawal amount must be greater than zero
    And the balance of my wallet should be $100

  Scenario: Withdrawal from empty wallet
    Given I have deposited $0 in my wallet
    When I request $50
    Then $0 should be dispensed
    And I should be told that I have insufficient funds
    And the balance of my wallet should be $0

  Scenario: Negative withdrawal amount
    Given I have deposited $100 in my wallet
    When I request $-20
    Then $0 should be dispensed
    And I should be told that withdrawal amount must be greater than zero
    And the balance of my wallet should be $100