public class Deck {
	
	// INSTANCE FIELDS 
	private int valueNumber; 
	private int suitNumber; 
	private String cardID;
	
	/**
	 * Method that simulates drawing a card 
	 * @return Card object 
	 */
	public Card drawCard() {
		
		// variable that sets the card value number "1-13"
		valueNumber = (int)((Math.random()*13)+1);
		// variable that sets the suit number "1-4" 
		suitNumber = (int)((Math.random()*4)+1);
		
		String suit = null; 
		
		// this if statement take the number from the suit and use it for the suit name 
		if(suitNumber == 1) {
			suit = "Spades"; 
		} else if (suitNumber == 2) {
			suit = "Clubs";
		} else if (suitNumber == 3) {
			suit = "Hearts"; 
		} else if (suitNumber == 4) {
			suit = "Diamonds";
		} // end of conditions 
		
		
		switch(valueNumber) {
		case 1: 
			if(suit.equals("Spades")) {
				this.cardID = "A-S.png";
			} else if(suit.equals("Clubs")){
				this.cardID = "A-C.png";
			} else if(suit.equals("Hearts")) {
				this.cardID = "A-H.png";
			} else if(suit.equals("Diamonds")) {
				this.cardID = "A-D.png";
			}
			break; 
		case 2: 
			if(suit.equals("Spades")) {
				this.cardID = "2-S.png";
			} else if(suit.equals("Clubs")){
				this.cardID = "2-C.png";
			} else if(suit.equals("Hearts")) {
				this.cardID = "2-H.png";
			} else if(suit.equals("Diamonds")) {
				this.cardID = "2-D.png";
			}
			break; 
		case 3: 
			if(suit.equals("Spades")) {
				this.cardID = "3-S.png";
			} else if(suit.equals("Clubs")){
				this.cardID = "3-C.png";
			} else if(suit.equals("Hearts")) {
				this.cardID = "3-H.png";
			} else if(suit.equals("Diamonds")) {
				this.cardID = "3-D.png";
			}
			break; 
		case 4: 
			if(suit.equals("Spades")) {
				this.cardID = "4-S.png";
			} else if(suit.equals("Clubs")){
				this.cardID = "4-C.png";
			} else if(suit.equals("Hearts")) {
				this.cardID = "4-H.png";
			} else if(suit.equals("Diamonds")) {
				this.cardID = "4-D.png";
			}
			break;  
		case 5:  
			if(suit.equals("Spades")) {
				this.cardID = "5-S.png";
			} else if(suit.equals("Clubs")){
				this.cardID = "5-C.png";
			} else if(suit.equals("Hearts")) {
				this.cardID = "5-H.png";
			} else if(suit.equals("Diamonds")) {
				this.cardID = "5-D.png";
			}
			break;  
		case 6: 
			if(suit.equals("Spades")) {
				this.cardID = "6-S.png";
			} else if(suit.equals("Clubs")){
				this.cardID = "6-C.png";
			} else if(suit.equals("Hearts")) {
				this.cardID = "6-H.png";
			} else if(suit.equals("Diamonds")) {
				this.cardID = "6-D.png";
			}
			break;  
		case 7: 
			if(suit.equals("Spades")) {
				this.cardID = "7-S.png";
			} else if(suit.equals("Clubs")){
				this.cardID = "7-C.png";
			} else if(suit.equals("Hearts")) {
				this.cardID = "7-H.png";
			} else if(suit.equals("Diamonds")) {
				this.cardID = "7-D.png";
			}
			break;  
		case 8: 
			if(suit.equals("Spades")) {
				this.cardID = "8-S.png";
			} else if(suit.equals("Clubs")){
				this.cardID = "8-C.png";
			} else if(suit.equals("Hearts")) {
				this.cardID = "8-H.png";
			} else if(suit.equals("Diamonds")) {
				this.cardID = "8-D.png";
			}
			break;  
		case 9: 
			if(suit.equals("Spades")) {
				this.cardID = "9-S.png";
			} else if(suit.equals("Clubs")){
				this.cardID = "9-C.png";
			} else if(suit.equals("Hearts")) {
				this.cardID = "9-H.png";
			} else if(suit.equals("Diamonds")) {
				this.cardID = "9-D.png";
			}
			break;  
		case 10: 
			if(suit.equals("Spades")) {
				this.cardID = "10-S.png";
			} else if(suit.equals("Clubs")){
				this.cardID = "10-C.png";
			} else if(suit.equals("Hearts")) {
				this.cardID = "10-H.png";
			} else if(suit.equals("Diamonds")) {
				this.cardID = "10-D.png";
			}
			break;  
		case 11: 
			if(suit.equals("Spades")) {
				this.cardID = "J-S.png";
			} else if(suit.equals("Clubs")){
				this.cardID = "J-C.png";
			} else if(suit.equals("Hearts")) {
				this.cardID = "J-H.png";
			} else if(suit.equals("Diamonds")) {
				this.cardID = "J-D.png";
			}
			break;  
		case 12: 
			if(suit.equals("Spades")) {
				this.cardID = "Q-S.png";
			} else if(suit.equals("Clubs")){
				this.cardID = "Q-C.png";
			} else if(suit.equals("Hearts")) {
				this.cardID = "Q-H.png";
			} else if(suit.equals("Diamonds")) {
				this.cardID = "Q-D.png";
			}
			break;
		case 13: 
			if(suit.equals("Spades")) {
				this.cardID = "K-S.png";
			} else if(suit.equals("Clubs")){
				this.cardID = "K-C.png";
			} else if(suit.equals("Hearts")) {
				this.cardID = "K-H.png";
			} else if(suit.equals("Diamonds")) {
				this.cardID = "K-D.png";
			}
			break;  
		}  // end of cases 
		
		// returning the card 
		return new Card(valueNumber, suit);
				
		
	} // end of drawCard method 

	public String getCardID() {
		return cardID;
	}

	public void setCardID(String cardID) {
		this.cardID = cardID;
	}
	
	

} // end of class 
