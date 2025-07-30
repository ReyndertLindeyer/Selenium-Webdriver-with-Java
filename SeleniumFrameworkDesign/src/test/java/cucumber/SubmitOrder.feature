@tag
Feature: Purchase the order from Ecommerce Website
	I want to use this template for my feature file
	
	Background:
	Given I landed on Ecommerce Page
	
	@tag2
	Scenario Outline: Positive Test of Sumitting the order
	Given Logged in with username <name> and password <password>
	When I add product <productName> to Cart
	And Checkout <productName>
	Then "thankyou for the order." message is displayed on ConfirmationPage
	
	Examples:
	| name  		 	 | password 	 | productName 	   | 
	| vbnm@hmail.com 	 | NightCity2077 | ZARA COAT 3	   |
	| vbasdfnm@hmail.com | NightCity2077 | ADIDAS ORIGINAL |