@tag
Feature: Error validation
	I want to use this template for my feature file
	
	@tag2
	Scenario Outline: Positive Test of Sumitting the order
	Given I landed on Ecommerce Page
	When Logged in with username <name> and password <password>
	Then "Incorrect email or password." message is displayed
	
	Examples:
	| name  		 	 | password 	|
	| vbnm@hmail.com 	 | Nightity2077 |
	| vbasdfnm@hmail.com | NigtCity2077 |