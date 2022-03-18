Feature: TC_ Product Owner AdressBook

	@TEST_DFQA-64
		
					Scenario Outline: PO should be able to Send Money with AdressBook
				
						Given serge sign in with a valid credentials
						When serge set Language: "<Lang>" and navigates to "<Screen>" screen
						And he add new contact with "<Payment Method>" as Payment method
						And he sends money to "<Payment Method>" contact "<Lang>" version
						Then he verify transaction is recorded with "<Lang>" : "<Transaction Type>" as transaction type in the list of history
						
						Examples:
						  | Lang | Payment Method | Transaction Type  | Screen   |
#						  | EN   | Diool          | Internal Transfer | Contacts |
#						  | EN   | Bank Account   | Internal Transfer | Contacts |
						  | FR   | Diool          | Internal Transfer | Contacts |
#						  | FR   | Bank Account   | Internal Transfer | Contacts |