Feature: Webstaurant Search and Cart Functionality

  Scenario: User searches for 'stainless work table' on Webstaurantstore
    Given User is on the Webstaurantstore website
    When User searches for 'stainless work table'
    Then Search results should contain products with the word 'Table' in the title

  Scenario: User adds the last found item to the Cart and empties it
    Given User is on the Webstaurantstore website
    When User searches for 'stainless work table'
    And Search results should contain products with the word 'Table' in the title
    Then User adds the last found item to the Cart
    And User empties the Cart
