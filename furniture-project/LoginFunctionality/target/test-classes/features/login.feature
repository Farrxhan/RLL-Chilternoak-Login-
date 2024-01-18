Feature: Login functionality

  Scenario Outline: User login with different credentials
    Given user navigates to the login page
    When user enters '<username>' and '<password>'
    And clicks the login button
    Then Message Should Be Displayed '<loginResult>'

  Examples:
    | username                         | password       			| loginResult           			|
    | farhanbelgaumi1@gmail.com				 | farhan@123		   			| logged_in_successfully			|
    | far@gmail.com            		 		 | farhan@123			 			| incorrect email or Password |
    | farhanbelgaumi1@gmail.com    		 | far123       				| incorrect email or Password |
    | far@gmail.com  				       		 | far123								| incorrect email or Password |
    |                              		 |               			  | incorrect email or Password |
