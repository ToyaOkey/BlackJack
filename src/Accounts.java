/**
 * 
 * @author coolt
 *
 */
public class Accounts {
	/**
	 * Instance variables  
	 */
	
	private static double houseAmount; 
	private static double playerAmount;
	private static int  playerWins; 
	private static int  houseWins; 
	private static int  ties; 
	
	/**
	 * Default constructor 
	 */
	public Accounts() {
		
	}
	/**
	 * Constructor for setting the house and player amount 
	 * @param houseAmount
	 * @param playerAmount
	 */
	public Accounts(double houseAmount, double  playerAmount) {
		Accounts.houseAmount = houseAmount; 
		Accounts.playerAmount = playerAmount; 
	}
	
	
	/**
	 * Getter method for House amount
	 * @return double house amount  
	 */
	public static double getHouseAmount() {
		return Accounts.houseAmount;
	}
	/**
	 * Method for receiving the players amount 
	 * @return double player amount 
	 */
	public static double getPlayerAmount() {
		return Accounts.playerAmount;
	}
	/**
	 * Getter method for player wins 
	 * @return int amount of player wins 
	 */
	public static int getPlayerWins() {
		return Accounts.playerWins;
	}
	/**
	 * Getter method for house wins 
	 * @return int amount of house wins 
	 */
	public static int getHouseWins() {
		return Accounts.houseWins;
	}
	/**
	 * Method that returns the amount of ties 
	 * @return int amount of ties 
	 */
	public static int getTies() {
		return Accounts.ties;
	}
	/**
	 * Method that sets the house amount 
	 * @param houseAmount
	 */
	public static void setHouseAmount(double houseAmount) {
		Accounts.houseAmount = houseAmount;
	}
	/**
	 * Method that sets the player amount 
	 * @param playerAmount
	 */
	public static void setPlayerAmount(double playerAmount) {
		Accounts.playerAmount = playerAmount;
	}
	/**
	 * Method that sets the amount of player wins 
	 * @param playerWins
	 */
	public static void setPlayerWins(int playerWins) {
		Accounts.playerWins = playerWins;
	} 
	/**
	 * Method that sets the amount of house wins  
	 * @param houseWins
	 */
	public static void setHouseWins(int houseWins) {
		Accounts.houseWins = houseWins;
	} 
	/**
	 * Method that sets the amount of ties  
	 * @param ties
	 */
	public static void setTies(int ties) {
		Accounts.ties = ties;
	} 
	
	
	
	
	
	
	

}
