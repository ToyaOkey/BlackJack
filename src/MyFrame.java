import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
/**
 * 
 * @author Toya OkeyNwamara
 * 
 */
public class MyFrame extends JFrame implements ActionListener {
	
	/*
	 * Instance variables 
	 * All set to private because variables do not need to be accessed outside of MyFrame Class 
	 */
	private JButton playGameButton;
	private JButton enterButton; 
	private JButton hitButton; 
	private JButton standButton; 
	private JButton exitButton;
	private JButton restartButton; 
	private JLabel playerAmountLabel;
	private JLabel houseAmountLabel; 
	private JLabel announcementLabel;
	private JLabel houseAccountLabel; 
	private JLabel playerAccountLabel; 
	private JLabel betAmountsLabel; //TODO -- mostly done 
	private JLabel cardStatusLabel; 
	private JLabel standingLabel; 
	private JLabel houseWinsLabel; 
	private JLabel playerWinsLabel; 
	private JLabel tiesLabel; 
	private JLabel cardLabel; 
	private JTextField textfield;
	
	private boolean ifBusted = false; 
	private boolean endOfGame = false; 
	
	// POSSIBLE - could do a while then have the action listener listen for the restart button then after that set all amounts to zero 
	// new class of myFrame
	/**
	 * Default constructor 
	 */
	MyFrame(){ 
		 
		// TEXTFIELD - FOR BETTING 
		// TODO - change color and font 
		// TODO - cast string into double 
		textfield = new JTextField("Enter bet amount");  // new textfield object with text of bet amount 
		textfield.setBounds(400, 100, 200, 50); // sets the size and position of the textfield 
		textfield.setVisible(false); // the visibility will be set false until later when the play button is hit  
		//textfield.setEditable(false);
		//System.out.println(textfield.getText()); // - FOR TESTING 
		
		
		
		//LABELS 
		
		//Player amount label 
		playerAmountLabel = new JLabel("Player Amount: " + String.valueOf(Main.playerTotal));  // displays the current player amount in card deck
		playerAmountLabel.setBounds(25, 500, 200, 50); // sets the size and position of the label 
		playerAmountLabel.setVisible(false); // will initially have the visibility as false until enter/play button has been hit  
		
		// Announcement Display label 
		announcementLabel = new JLabel(); // creates new instance of announcement label which will display the results of the game 
		announcementLabel.setBounds(200, -450, 1000, 1000); // sets the size and position of the label
		announcementLabel.setVisible(false); // visibility will be set to false and true in some instances  
		announcementLabel.setFont(new Font("Courier New",Font.BOLD,18));
		
		
		// House amount display label 
		houseAmountLabel = new JLabel("House Amount: " + String.valueOf(Main.houseTotal)); // Will display the total house amount from the card deck 
		houseAmountLabel.setBounds(25, 550, 200, 50); // sets the size and position of label 
		houseAmountLabel.setVisible(false); // will set visibility as false until bet amount is displayed 
		
		// House wins display label 
		houseWinsLabel = new JLabel("House Wins: " + String.valueOf(Accounts.getHouseWins()));
		houseWinsLabel.setBounds(30, -75, 200, 500);
		houseWinsLabel.setVisible(false);
		houseWinsLabel.setFont(new Font("Helvetica", Font.BOLD, 24));
		
		playerWinsLabel = new JLabel("Player Wins: " + String.valueOf(Accounts.getPlayerWins()));
		playerWinsLabel.setBounds(30, -50, 200, 500);
		playerWinsLabel.setVisible(false);
		playerWinsLabel.setFont(new Font("Helvetica", Font.BOLD, 24));
		
		tiesLabel = new JLabel("Ties: " + String.valueOf(Accounts.getTies()));
		tiesLabel.setBounds(30, -25, 200, 500);
		tiesLabel.setVisible(false);
		tiesLabel.setFont(new Font("Helvetica", Font.BOLD, 24));
		
		// House Account label - displays how much money the house has 
		houseAccountLabel = new JLabel("House amount: $" + String.format("%.2f",Accounts.getHouseAmount())); 
		houseAccountLabel.setBounds(400, 600, 200, 50);
		houseAccountLabel.setVisible(false);
		houseAccountLabel.setFont(new Font("Average", Font.BOLD, 14));
		houseAccountLabel.setForeground(new Color(205, 0, 0));
		
		// player  Account label displays the $ the player has 
		playerAccountLabel = new JLabel("Your amount: $" + String.format("%.2f",Accounts.getPlayerAmount()));
		playerAccountLabel.setBounds(400, 650, 200, 50);
		playerAccountLabel.setVisible(false);
		playerAccountLabel.setFont(new Font("Average", Font.BOLD, 14));
		playerAccountLabel.setForeground(new Color(0,0,205));
		
		// Displays the card that is picked up 
		cardStatusLabel = new JLabel();
		cardStatusLabel.setBounds(250, -70, 500, 500);
		cardStatusLabel.setVisible(false);
		cardStatusLabel.setFont(new Font("Sans Serif",Font.BOLD,24));
		//System.out.println(cardStatusLabel.isVisible());
		
		//displays card
		cardLabel = new JLabel();
		cardLabel.setBounds(100,650,5,5);
		cardLabel.setSize(400,400);
//		cardLabel.setText("card Label");
		cardLabel.setVisible(true);
		
		
		
		//displays whether the play decides to hit 
		standingLabel = new JLabel();
		standingLabel.setBounds(370, 100, 500, 500);
		standingLabel.setFont(new Font("Courier New",Font.BOLD,18));
		standingLabel.setVisible(false);
		
		//displays how much the player has bet 
		betAmountsLabel = new JLabel();
		betAmountsLabel.setBounds(210, -80, 1000, 1000);
		betAmountsLabel.setVisible(false);
		betAmountsLabel.setFont(new Font("Monospaced", Font.BOLD, 18));
		

		
		//PLAY GAME BUTTON 
		playGameButton = new JButton("Play Game!"); 
		playGameButton.setBounds(400, 250, 200, 50);
		playGameButton.setBorderPainted(false);
		playGameButton.setFocusable(false);
		playGameButton.setVisible(true);
		playGameButton.addActionListener(this); 
		
		//HIT BUTTON 
		hitButton = new JButton("Hit"); 
		hitButton.setBounds(700, 500, 200, 50);
		hitButton.setBorderPainted(false);
		hitButton.setFocusable(false);
		hitButton.setVisible(false);
		hitButton.addActionListener(this);
		
		// STANDBUTTON 
		standButton = new JButton("Stand"); 
		standButton.setBounds(700, 550, 200, 50);
		standButton.setBorderPainted(false);
		standButton.setFocusable(false);
		standButton.setVisible(false);
		standButton.addActionListener(this);
		
		//ENTER BUTTON 
		
		enterButton = new JButton("Enter"); 
		enterButton.setBounds(400, 250, 200, 50);
		enterButton.setBorderPainted(false);
		//enterButton.setEnabled(false);
		enterButton.setFocusable(false);
		enterButton.setVisible(false);
		enterButton.addActionListener(this);
		
		// EXIT BUTTON 
		exitButton = new JButton("Exit"); 
		exitButton.setBounds(700, 700, 200, 50);
		exitButton.setBorderPainted(false);
		exitButton.setFocusable(false);
		exitButton.setVisible(false);
		exitButton.addActionListener(this);
		
		// RESTART BUTTON -- restart button could be used to restart game 
		restartButton = new JButton("Restart"); 
		restartButton.setBounds(400, 700, 200, 50);
		restartButton.setBorderPainted(false);
		restartButton.setFocusable(false);
		restartButton.setVisible(false);
		restartButton.addActionListener(this);
		
		this.setTitle("BLACKJACK!!!!");
		ImageIcon icon = new ImageIcon("A-D.png");
		this.setIconImage(icon.getImage());
		this.getContentPane().setBackground(new Color(50,205,50));
		this.setResizable(false); // disallows the frame to be resizable 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // allows the frame to be excited on close 
		this.setLayout(null);  // shows no layout 
		this.pack();  
		this.setVisible(true); // sets visibility 
		this.setBounds(EXIT_ON_CLOSE, ABORT, 1000, 1000); // sets size 
		
		
		// adding all instances to the frame
		this.add(playerAmountLabel);
		this.add(houseAmountLabel);
		this.add(announcementLabel);
		this.add(houseAccountLabel);
		this.add(playerAccountLabel);
		this.add(cardStatusLabel);
		this.add(standingLabel);
		this.add(betAmountsLabel);
		this.add(houseWinsLabel);
		this.add(playerWinsLabel);
		this.add(tiesLabel);
		this.add(cardLabel);
		
		this.add(restartButton);
		this.add(standButton);
		this.add(enterButton);
		this.add(hitButton);
		this.add(exitButton);
		this.add(playGameButton);
		
		 
		
		this.add(textfield);
	}
	

	@Override
	/**
	 * Action performed method 
	 */
	public void actionPerformed (ActionEvent e) {
		endOfGame = false; 
		ifBusted = false; 
		
		// creates an instance of a new Deck
		Deck deckOne = new Deck();
		
		// if the button has been clicked it will make the play game  button disappear and allows the game to start by having other frames visible 
		if(e.getSource() == playGameButton) {
			houseWinsLabel.setVisible(true);
			tiesLabel.setVisible(true);
			playerWinsLabel.setVisible(true);
			
	        Main.houseBetAmount = (int)((Math.random()*Accounts.getHouseAmount())+0);
	        
	        System.out.println("The house has bet $" + Main.houseBetAmount);

			System.out.println("the play button has been disabled");
			//makes enter button visible 
			enterButton.setVisible(true);
			//make bet amount text field visible 
			textfield.setVisible(true);
			//System.out.println(Double.valueOf(textfield.getText())); //TODO 
			// sets the house and player amount displayed so you can see how much you have to bet 
			houseAccountLabel.setVisible(true);
			playerAccountLabel.setVisible(true);
			playGameButton.setVisible(false); // COULD MAKE PLAY GAME BUTTON VISIBLE AT THE END OF THE CODE TO RESTART GAME? would have to reaarange code tho 
			exitButton.setVisible(true); // displays the exit button 
	        Main.houseTotal = deckOne.drawCard().getValue(true) + deckOne.drawCard().getValue(true); 
	        Main.playerTotal = deckOne.drawCard().getValue(true) + deckOne.drawCard().getValue(true); 
		}
		// when the enter button gets clicked it allows  you to see your amounts and allows you to hit/stand 
		if(e.getSource() == enterButton) {
			//enterButton.setEnabled(false); OPTIONAL - make button grayed out instead 
//		    System.out.println(Accounts.getHouseAmount());
//		    System.out.println(Accounts.getPlayerAmount());
			// this is a try and catch block which will catch the "NumberFormatException" so that way when the player enters a non number it will
			// make them continually going until they add a number essentially preventing an error in the compilation
			try {
				  Main.playerBetAmount = Double.valueOf(textfield.getText()); 
				  double amountBet = Main.playerBetAmount;
				  if(amountBet <= Accounts.getPlayerAmount() && amountBet > 0) {
					hitButton.setEnabled(true);
					standButton.setEnabled(true); 
					
					//TODO if the amount that the player is betting is less than what they have then they should be prompted again
					// set the bet amount to be a what was entered within the text field
					enterButton.setVisible(false);  // sets enter to not visible since it will not be used anymore 
					
					//playGameButton.setVisible(false); // sets play game to false? 
					hitButton.setVisible(true); // shows the hit button 
					standButton.setVisible(true); // shows the stand button 
					//exitButton.setVisible(true); 
					
					playerAmountLabel.setText("Player Amount: " + String.valueOf(Main.playerTotal)); // sets the text of the player amount deck 
					playerAmountLabel.setVisible(true); // sets the card deck amount to visible for the player 
					//playerAmountLabel.setText("Player Amount: " + String.valueOf(Main.playerTotal)); //displays the 
					houseAmountLabel.setText("House Amount: " + String.valueOf(Main.houseTotal)); // sets the text of the house amount deck 
					houseAmountLabel.setVisible(true); // sets the card deck amount to visible for the house
					textfield.setVisible(false); // disables textfield when button is pressed 
					Accounts.setPlayerAmount(Accounts.getPlayerAmount() - Main.playerBetAmount); // removes the amount of money that the player  betted from their account
					Accounts.setHouseAmount(Accounts.getHouseAmount() - Main.houseBetAmount); // removes the amount of money that the house  betted from their account 
					//System.out.println(" The player amount is  " + Accounts.getPlayerAmount()); 
					//System.out.println("The house amount is $" + Accounts.getHouseAmount());
					//textfield.setEnabled(false); OPTION grey out textfield
					
					houseAccountLabel.setText("House Amount: $" + String.format("%.2f",Accounts.getHouseAmount())); // sets new text for the house amount label 
					playerAccountLabel.setText("Player Amount: $" + String.format("%.2f",Accounts.getPlayerAmount())); // sets new text for the player amount label 
					//displays the amount that the player + house bets 
					betAmountsLabel.setText("The player has bet $" + String.format("%.2f",Main.playerBetAmount) + 
					" and the house has bet $"  + String.format("%.2f",Main.houseBetAmount)); 
					betAmountsLabel.setVisible(true); // makes house bet visible 
					announcementLabel.setVisible(false); // makes announcement label visible 
				} else {
					announcementLabel.setBounds(200, -450, 1000, 1000);
					announcementLabel.setText("Your bet amount has to be less than your $ and greater than $0");
					announcementLabel.setVisible(true);
				}
				// WILL  RUN ALL THIS CODE AFTER THE THE ERROR AS BEEN CATCHED IF IT HAS NOT BEEN CATCHED THEN IT WILL RUN THIS CODE STILL!
				// will run the try after the catch
				
			} 
			catch(NumberFormatException exception) {
				announcementLabel.setBounds(350, -450, 1000, 1000);
				announcementLabel.setText("You have to enter a number");
				announcementLabel.setVisible(true);
			} 

			//announcementLabel.setText("thanks");
			
			
			

			
			

			 
			//System.out.println(Main.playerBetAmount);
			
			

			
//			announcementLabel.setVisible(true);
//			announcementLabel.setText("The house has bet $" + Main.houseBetAmount + " and the player has bet $" + Main.playerBetAmount); -- make a new  label 
		} // end of enter button 
		
		// allows the player to press the hit button and draw their card and add value to their deck 
		if(e.getSource() == hitButton) {
			

			System.out.println("You pressed the hitButton");
			Main.cardAmount = Main.playerTotal; // used for the ace or 11; 
			//System.out.println(Main.cardAmount);
			Card nextCard = deckOne.drawCard(); // draws a new card from the deck 
			Main.playerTotal += nextCard.getValue(true); // adds the new card to the player total; 
			//System.out.println("The player total is " + Main.playerTotal);
			playerAmountLabel.setText("Player Amount: " + String.valueOf(Main.playerTotal)); // displays the new amount 
			cardStatusLabel.setText("The player will draw " + nextCard.declareCard()); // displays the card the player drew 
			cardStatusLabel.setVisible(true); // sets the visibility of the the display of the card drawn true 
			ImageIcon imageIcon = new ImageIcon(new ImageIcon(deckOne.getCardID()).getImage().getScaledInstance(180, 180, Image.SCALE_DEFAULT));
			System.out.println(deckOne.getCardID());
			cardLabel.setIcon(imageIcon);
			cardLabel.setVisible(true);
		}
		
		
		
		if(Main.playerTotal > 21) {
			//  house wins 
			//restartButton.setVisible(true); // TO FIX 
			System.out.println("Hit has been disabled"); 
			// if the player busted do not allow the player to hit or stand
			hitButton.setEnabled(false);
			standButton.setEnabled(false);
			
			//System.out.println("The player has busted; house WINS"); // make into a label + house wins 
	
			ifBusted = true; 
			Accounts.setHouseWins(Accounts.getHouseWins()+1);
			houseWinsLabel.setText("House Wins: " + String.valueOf(Accounts.getHouseWins()));
			announcementLabel.setText("The player has busted; house WINS!"); 
			announcementLabel.setVisible(true);
			// adds money to the house account since house wins 
			Accounts.setHouseAmount(Accounts.getHouseAmount() + Main.playerBetAmount + Main.houseBetAmount); 
			//displays new labels of house + player amounts 
			houseAccountLabel.setText("House Amount: $" + String.format("%.2f",Accounts.getHouseAmount()));;
			playerAccountLabel.setText("Player Amount: $" + String.format("%.2f",Accounts.getPlayerAmount()));
			
			//System.out.println(Accounts.getHouseAmount());
			
		}

		
		
		if(e.getSource() == standButton) {
			
			System.out.println("You have chosen to stand"); // make into a label 
			// if the player chose stand once then disable the button since they do not need to stand more then once 
			standButton.setEnabled(false);
			hitButton.setEnabled(false); //  they also cannot have the option to hit since they have chosen to stand 
			
			standingLabel.setVisible(true); // standing label will display if the player has chosen to stand
			standingLabel.setText("The player will stand"); // the house can override this label by standing 
			//cardStatusLabel.setVisible(true);
			
			// while the house does not bust 
			while(Main.houseTotal < 21)  { 
				// if the house has reached blackjack no need to draw they automatically won 
				if(Main.playerTotal == 21) {
					break; 
				}
				// house will draw a card if value is under or equal 17 
				if(Main.houseTotal <= 17) {
					Main.cardAmount = Main.houseTotal; 
					//System.out.println(Main.cardAmount);
					
					Card nextCard = deckOne.drawCard(); // draws a new card from the deck 
					Main.houseTotal += nextCard.getValue(true); // adds new value of the card to the house total
//					cardLabel.setText("card Label");
					houseAmountLabel.setText("House Amount: " + String.valueOf(Main.houseTotal)); // sets the text of the label to new amount 
					
					//displays what the house will play 
					cardStatusLabel.setText("The house will play the " + nextCard.declareCard());
					cardStatusLabel.setVisible(true);
					ImageIcon imageIcon = new ImageIcon(new ImageIcon(deckOne.getCardID()).getImage().getScaledInstance(180, 180, Image.SCALE_DEFAULT));
					System.out.println(deckOne.getCardID());
					cardLabel.setIcon(imageIcon);
					cardLabel.setVisible(true);
					// house will stand for value in between 18-21
				} else if (Main.houseTotal > 17 && Main.houseTotal  < 21) {
					//Main.houseTotal = Main.houseTotal; 
					houseAmountLabel.setText("House Amount: " + String.valueOf(Main.houseTotal)); // sets text to the house amount just incase they drew before
					announcementLabel.setVisible(true);
					//announcementLabel.setText("The house has decided to stand.");
					//cardStatusLabel.setText("The house will stand "); -- FIX MAKE INTO NEW LABEL 
					//cardStatusLabel.setVisible(true);
					endOfGame = true;
					standingLabel.setVisible(true); 
					standingLabel.setText("The house will stand"); 
					break; // breaks if the house is standing 
				}
			}  // end of while loop 
			if (Main.houseTotal > 21)  {
				// player wins 
				Accounts.setPlayerWins(Accounts.getPlayerWins()+1);
				playerWinsLabel.setText("Player Wins: " + Accounts.getPlayerWins());
				announcementLabel.setText("The house has busted! player WINS"); // sets label to status 
				announcementLabel.setVisible(true);
				// adds money to player amount since player won
				Accounts.setPlayerAmount(Accounts.getPlayerAmount() + Main.playerBetAmount + Main.houseBetAmount);  
				//System.out.println("The house has busted! player WINS"); // TODO - insert the amount that is won 
				ifBusted = true; 
				//displays the value of the new amounts 
				houseAccountLabel.setText("House Amount: $" + String.format("%.2f",Accounts.getHouseAmount()));
				playerAccountLabel.setText("Player Amount: $" + String.format("%.2f",Accounts.getPlayerAmount()));
				
				restartButton.setVisible(true); 
			} else {
				announcementLabel.setVisible(false);
				endOfGame = true; 	
			}
			
		}

		// if the player hits exit they leave the game / closes the frame 
		if (e.getSource() == exitButton) {
			System.out.println("You have left the game");
			this.setVisible(false);
			System.exit(0);
		}
		
		//WINNERS 
		

		
		//TODO -- add bet results including wins 
		//TODO -- add label to show what the player have gained? - optional
		// ^mostly done 
		if(endOfGame) {
			// if a breakeven both accounts will get their  money back
			if(Main.playerTotal == Main.houseTotal) {
				endOfGame = false; 
				//sets the amount of player  and house to what they originally were equal to if they tie 
				Accounts.setHouseAmount(Accounts.getHouseAmount() + Main.houseBetAmount);
				Accounts.setPlayerAmount(Accounts.getPlayerAmount() + Main.playerBetAmount);
				Accounts.setTies(Accounts.getTies()+1); // will increment tie amount if tied 
				tiesLabel.setText("Ties: " + Accounts.getTies());
				announcementLabel.setVisible(true);
				announcementLabel.setText("It is a breakeven. "); //TODO - insert amounts you get back 
				System.out.println("It is a breakeven");// add to label no one wins 
				
				houseAccountLabel.setText("House Amount: $" + String.format("%.2f",Accounts.getHouseAmount()));
				playerAccountLabel.setText("Player Amount: $" + String.format("%.2f",Accounts.getPlayerAmount()));
				endOfGame = true; 
				// if player reaches blackjack play wins and gains money
			} else if (Main.playerTotal == 21) {
				Accounts.setPlayerAmount(Accounts.getPlayerAmount() + Main.playerBetAmount + Main.houseBetAmount);
				announcementLabel.setVisible(true);
				announcementLabel.setText("The player has reached Blackjack. PLAYER WINS ");
				System.out.println("Player has reached blackjack"); // player wins + add to label \
				Accounts.setPlayerWins(Accounts.getPlayerWins()+1);
				playerWinsLabel.setText("Player Wins: " + Accounts.getPlayerWins());
				standButton.setEnabled(false);
				hitButton.setEnabled(false);
				
				houseAccountLabel.setText("House Amount: $" + String.format("%.2f",Accounts.getHouseAmount()));
				playerAccountLabel.setText("Player Amount: $" + String.format("%.2f",Accounts.getPlayerAmount()));
				// if house has reached blackjack then it wins and gains $
			}  else if (Main.houseTotal == 21) {
				Accounts.setHouseAmount(Accounts.getHouseAmount() + Main.playerBetAmount + Main.houseBetAmount);
				announcementLabel.setVisible(true);
				Accounts.setHouseWins(Accounts.getHouseWins()+1);
				announcementLabel.setText("The house has reached Blackjack. HOUSE WINS ");
				houseWinsLabel.setText("House Wins: " + Accounts.getHouseWins());
				houseAccountLabel.setText("House Amount: $" + String.format("%.2f",Accounts.getHouseAmount()));
				playerAccountLabel.setText("Player Amount: $" + String.format("%.2f",Accounts.getPlayerAmount()));
				
				System.out.println("house has reached blackjack"); // house wins + add to label 
			} else if (Main.houseTotal > Main.playerTotal && !ifBusted) {
				// if house total is greater and did not bust then house wins and gains $ 
				Accounts.setHouseAmount(Accounts.getHouseAmount() + Main.playerBetAmount + Main.houseBetAmount);
				announcementLabel.setVisible(true);
				Accounts.setHouseWins(Accounts.getHouseWins()+1);
				announcementLabel.setText("House total is greater than player total; House wins!");
				System.out.println("House total is greater than player total; House wins "); //  house wins + add to label
				houseWinsLabel.setText("House Wins: " + Accounts.getHouseWins());
				houseAccountLabel.setText("House Amount: $" + String.format("%.2f",Accounts.getHouseAmount()));
				playerAccountLabel.setText("Player Amount: $" + String.format("%.2f",Accounts.getPlayerAmount()));
				// if player total is greater and did not bust then player wins and gains $ 
			} else if (Main.playerTotal > Main.houseTotal && !ifBusted) {
				// in this situation player has won 
				Accounts.setPlayerAmount(Accounts.getPlayerAmount() + Main.playerBetAmount + Main.houseBetAmount); // 950 +  
				announcementLabel.setVisible(true);
				announcementLabel.setText("Player total is greater than house total; player wins!");
				
				System.out.println("Player total is greater than house total; player wins!"); 
				Accounts.setPlayerWins(Accounts.getPlayerWins()+1);
				playerWinsLabel.setText("Player Wins: " + Accounts.getPlayerWins());
				houseAccountLabel.setText("House Amount: $" + String.format("%.2f",Accounts.getHouseAmount()));
				playerAccountLabel.setText("Player Amount: $" + String.format("%.2f",Accounts.getPlayerAmount()));
			} 
		} // end of outer if statement 
		if(endOfGame || ifBusted) {
			restartButton.setVisible(true);
			Main.playerTotal = 0; 
			Main.houseTotal = 0; 
		}
		
		
		 // TO  FIX - this should not be displayed until after the game ends! 
		if(e.getSource() == restartButton)  {
			cardLabel.setVisible(false);
			//restart the game from the amount the player has
			restartButton.setVisible(false);
			playGameButton.setVisible(true);
			textfield.setText("Enter bet amount");
//			standButton.setEnabled(true);
//			hitButton.setEnabled(true);
			endOfGame = false; 
			ifBusted = false; 
			

		}
			
			
		
		
	} // end of action performed method 
	
	
	

} // end of class 
