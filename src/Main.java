//import javax.swing.*;
/**
 * 
 * @author coolt
 *
 */
public class Main {
	static int houseTotal; 
	static int playerTotal;
	static double playerBetAmount; 
	static double houseBetAmount; 
	static int cardAmount; // temporary variable 
	//static double houseBet;
	
	@SuppressWarnings("unused")
	/**
	 * Main method 
	 * @param args
	 */
	public static void main(String[] args) {
		// INSTANCE VARIABLES
		
		int playerWins; 
		int houseWins; 
		int ties; 
			// betting 
		//double playerBet; 
		
		//card # 
		Deck deckOne = new Deck();
		
		// sets default house amount to 1000 
		Accounts.setHouseAmount(1000); 
		//System.out.println("The house amount is $" + Accounts.getHouseAmount());
		// receiving the initial deck for both the player and house by drawing two cards 
//        houseTotal = deckOne.drawCard().getValue(true) + deckOne.drawCard().getValue(true); 
//        playerTotal = deckOne.drawCard().getValue(true) + deckOne.drawCard().getValue(true); 
        //playerBetAmount = 0; //TODO calculate bet amount
        // sets house bet amount as a random number between their amount and 0 

        //houseBetAmount; // TODO - set to random number in between their money and 0 
		//sets player amount to 1000
		Accounts.setPlayerAmount(1000);
		// creates a new instance of the frame allowing to see a visual of the game 
		new MyFrame();
		


        
        //System.out.println("the house total is " + houseTotal);
        //System.out.println("the player total is " + playerTotal);
        
//        System.out.println(Accounts.getHouseAmount());
//        System.out.println(Accounts.getPlayerAmount());
       
      
       
      /* TODO - work on visuals of the actual deck and logic of making the correct  card match up
       * Set up labels for everything - done
       * Work on the RNG Side - as in working on the logic of the house --  done 
       * after everything has been completed make visuals look better -- TODO 
       * work on the system telling you what card you drew -- done 
       * visual display of the cards  -- optional 
       * make label displaying status of everything -- very mostly done 
       * wrap everything into a while loop -- TODO 
       * format numbers to have two decimal places -- BIG TODO
       * try and  catch block for the textfield -- BIG TODO
       * possible tweak make the house be in a range between player bet
        */ 
		 
		
		
		
		
		

	}

}
