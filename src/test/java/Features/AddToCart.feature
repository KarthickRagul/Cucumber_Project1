Feature: Add to Cart

Scenario: Adding single product to  the cart and verify 
Given The user is in the home page
When The user clicks on the product
And The user clicks on the add to cart button
Then The product should be added to cart

Scenario: Adding multiple products to the cart and checking if the count increases
Given The user is in the home page
When The user clicks on the first product
And  The user clicks on Add to cart on the Second product
Then The cart count should be increased to "2"