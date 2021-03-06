Feature: TC_ Product Owner AdressBook

	@TEST_DFQA-64
		
					Scenario Outline: PO should be able to Send Money with AdressBook
				
						Given serge sign in with a valid credentials
						When serge set Language: "<Lang>" and navigates to "<Screen>" screen
						And he add new contact with "<Payment Method>" as Payment method and for "<Profile>"
						And he sends money to "<Profile>" contact "<Lang>" version
						Then he verify transaction is recorded with "<Lang>" : "<Transaction Type>" as transaction type in the list of history
						And he delete the added contact "<Profile>"
						
						Examples:
						  | Lang | Payment Method | Transaction Type  | Screen   | Profile |
#						  | EN   | Diool          | Internal Transfer | Contacts | Cashier |
#						  | FR   | Diool          | Internal Transfer | Contacts | Cashier |
						  | EN   | Diool          | Diool Transfer    | Contacts | Agent   |
						  | FR   | Diool          | Diool Transfer    | Contacts | Agent   |
  #					      | EN   | Bank Account   | Internal Transfer | Contacts |
#						  | FR   | Bank Account   | Internal Transfer | Contacts |
