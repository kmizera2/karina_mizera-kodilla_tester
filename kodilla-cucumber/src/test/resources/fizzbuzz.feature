Feature:  FizzBuzz generator

  Scenario Outline: Return correct value based on divisibility rules
    Given a number <input>
    When I ask for the FizzBuzz result
    Then the result should be "<expected>"

    Examples:
      | input | expected |
      | 3 | Fizz |
      | 5 | Buzz |
      | 15 | FizzBuzz |
      | 7 | None |
      | 0 | FizzBuzz |
      | -3 | Fizz |
      | -5 | Buzz |
      | -15 | FizzBuzz |
      | 1 | None |