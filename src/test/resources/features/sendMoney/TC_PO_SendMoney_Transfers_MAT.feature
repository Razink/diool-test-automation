Feature: TC_Product Owner Send Money Transfers

	@TEST_DFQA-60

			Scenario Outline: PO should be able to Send Money
		
				Given Serge sign in with a valid credentials
				When he set Language: "<Lang>" and navigates to "<Screen>" screen
				And he sends money to : "<Profile>" with "<Lang>"
				Then Serge verify transaction is recorded with "<Lang>" : "<Transaction Type>" as transaction type in the list of history
				
				Examples:
				  | Lang | Profile | Transaction Type  | Screen    |
				  | EN   | Agent   | Diool Transfer    | Transfers |
				  | EN   | Cashier | Internal Transfer | Transfers |
				  | FR   | Agent   | Diool Transfer    | Transfers |
				  | FR   | Cashier | Internal Transfer | Transfers |
