## CGI Core Track WebAPI - Coding Challenge - I

## Objective

In this case study, we will create a simple WebApi where you should be able to add account,view all accounts and also delete a particular acccount by its id. List should be used to store the accounts details. The APIs should be tested through Postman

## Following are the steps:
	
- Define the model class Accounts with the following Properties

			- accountsId : int
			- name : String
			- address : String
			- accounttype : String
                             ( savings / fd / current)
                        - status : String
                             ( active / inactive)

- Define the AccountRepository class, use Spring data jpa to perform CRUD operations


- Define AccountService interface with methods for the following actions

        - add account 
        - get all accounts
        - delete account by id

-  Define AccountServiceImpl implementing all the methods of AccountService

        - add account
        - get all accounts
        - delete account by id

- Define the Accountcontroller class and implement methods to create REST web service APIs based on 
        the methods defined in Account Service interface

        HttpStatuses for 
            - add account
                - code : 201 for successful addition
                - code : 409 if the account already exists
            - get all accounts
                - code : 200 for successful
            - delete account by id
                - code : 200 for successful deletion

- Use Dependency Injection Mechanism to create Repository and Service class instances.

- Test the REST APIs using postman and share the screenshots of them
