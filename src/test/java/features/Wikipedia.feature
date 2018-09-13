
Feature: Test Wikipedia
    
    Scenario Outline: Test Wikipedia in english
    Given I open <browser>
    And I open the page <URL>
    When I search <keyword>
    Then I should witness the magnificent <title>

    Examples:
    | browser     | URL                         | keyword     | title  |
    | "chrome"    | "http://www.wikipedia.org"  | "france"    | "France" |
    | "firefox"   | "http://www.wikipedia.org"  | "france"    | "France" |
    | "chrome"    | "http://www.wikipedia.org"  | "messi"     | "Lionel Messi" |
    | "firefox"   | "http://www.wikipedia.org"  | "messi"     | "Lionel Messi" |*
    | "chrome"    | "http://www.wikipedia.org"  | "bonobo"    | "Bonobo" |
    | "firefox"   | "http://www.wikipedia.org"  | "bonobo"    | "Bonobo" |
    | "chrome"    | "http://www.wikipedia.org"  | "hitler"    | "Adolf Hitler" |
    | "firefox"   | "http://www.wikipedia.org"  | "hitler"    | "Adolf Hitler" |