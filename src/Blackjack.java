import java.io.BufferedReader;
import java.io.IOException;

public class Blackjack {
	
	//6 decks shuffled together as per casino standard
	public static Shuffle NewDeck;
	
	//Deals with the remaining cards not in either hands
	public static CardsInDeck Remaining;
	
	//Player's and Dealer's hands
	public static Hand PlayersHand;
	public static Hand DealersHand;
	
	//Resets all values for playing again
	public static Reset r;
	
	//Checks to see if you want to play again
	public static boolean playAgain;
	
	public static BufferedReader br;

	public static void main(String[] args) throws IOException, InterruptedException {
		while(true){
			r = new Reset();
			
			for(int i = 0; i<4; i++) {
				if(i%2==0) PlayersHand.Hand.add(Remaining.hit());
				else DealersHand.Hand.add(Remaining.dealerHit(i));
			}
			Thread.sleep(1000);
			System.out.println("Dealer value: " + (DealersHand.Value.getHandValue(DealersHand.Hand)-DealersHand.Value.getValue(DealersHand.Hand.get(1))));
			System.out.println("Hand value: " + PlayersHand.Value.getHandValue(PlayersHand.Hand));
			
			PlayersHand.playHandPreSplit();
			
			if(!PlayersHand.lost) {
				DealersHand.dealerHand();
				
				if(DealersHand.dealerLost) System.out.println("You win!");
				else if(DealersHand.Value.getHandValue(DealersHand.Hand) > PlayersHand.Value.getHandValue(PlayersHand.Hand)) {
					System.out.println("The dealer won with a value of " + DealersHand.Value.getHandValue(DealersHand.Hand) + 
							" verses your " + PlayersHand.Value.getHandValue(PlayersHand.Hand));
				}
				else if(DealersHand.Value.getHandValue(DealersHand.Hand) < PlayersHand.Value.getHandValue(PlayersHand.Hand)) {
					System.out.println("You won with a value of " + PlayersHand.Value.getHandValue(PlayersHand.Hand) + 
							" verses their " + DealersHand.Value.getHandValue(DealersHand.Hand));
				}
				else System.out.println("You tied with a value of " + PlayersHand.Value.getHandValue(PlayersHand.Hand));
			}
			
			String Response;
			while(true) {
				System.out.println("Would you like to play again? Y/N");
				Response = br.readLine();
				if(Response.toLowerCase().equals("n") || Response.toLowerCase().equals("y")) break;
			}
			if(Response.toLowerCase()=="n") break;
		}
	}

}
