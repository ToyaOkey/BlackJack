/**
 * 
 * @author coolt
 *
 */
public class Card {
	// INSTANCE FIELDS 
	private int value; 
	private String suit; 
	/**
	 * Method that sets the suit and value of the card 
	 * @param
	 * @param
	 */
	public Card(int value, String suit) {
		// this refers to field 
		this.setValue(value); 
		this.setSuit(suit); 
	} // end of Card constructor 
	
	
	/**
	 * Getter method for suit 
	 * @return String suit 
	 */
	public String getSuit() {
		return suit;
	}
	
	/**
	 * Getter method for the card value  
	 * @return int numerical value of the card 
	 */
	
	public int getValue() {
		return value;
	}
	
	
	// SETTER FOR SUIT 
	public void setSuit(String suit) {
		this.suit = suit;
	}

	/**
	 * Setter method for value of the card 
	 * @param value
	 */
	
	public void setValue(int value) {
		this.value = value;
	}
	/**
	 * Method to receive the value of the card 
	 * @param isBlackjack
	 * @return int value of card 
	 */
	public int getValue(boolean isBlackjack) {
		if(!isBlackjack)  {
			return value; 
		} else {
			if(value == 1) {
				if(11 + Main.cardAmount > 21) {
					return 1; // the ace should return 1 and not 11 if it will make you bust 
				}
				return 11; // change back to 11 
			} else {
				if (value > 10) {
					return 10; 
				} else {
					return value; 
				}
			}
		}
		
	}
	
	
	/**
	 * Method that declares the suit of card 
	 * @return String suit of card 
	 */
    public String declareCard() {

        String result = null; 
        if(this.value == 11) {
            result = "The Jack of " + this.suit; 
        } else if (this.value == 12) {
            result = "The Queen of " + this.suit; 
        } else if (this.value == 13) {
            result = "The King of " + this.suit; 
        } else if (this.value == 1) {
            result = "The Ace of " + this.suit; 
        } else {
            result = "The " + this.value + " of "+ this.suit;  

        } // end of conditions 
        return result; 
    } // end of method 
	
	
	

} // end of class 
