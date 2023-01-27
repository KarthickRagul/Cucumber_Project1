Feature: Product Checkout

Scenario: Validating the checkout feature
  Given  The user is  on the cart page and the product is the cart
  When  The user clicks on checkout
  And The user enters the first name "Karthick Ragul" second name "N" ,postal code "12345" and clicks continue
  Then Checkout Page is displayed with pricing details
  And After clicking Finish ,"CHECKOUT: COMPLETE!"  message should  be displayed