import java.util.ArrayList;

public class CardsInDeck {
	
	//The deck being initialized
	ArrayList<String> Deck;
	
	public CardsInDeck(ArrayList<String> Deck) {
		this.Deck = Deck;
	}
	
	/**
	 * Gives the top card of the deck and gives it to the player
	 * 
	 * @return card at the top of the deck
	 * @throws InterruptedException
	 */
	
	public String hit() throws InterruptedException {
		String lastVal = Deck.get(0);
		Deck.remove(0);
		Thread.sleep(1000);
		System.out.println("You got a " + lastVal);
		return lastVal;
	}
	
	/**
	 * Gives the top card of the deck and gives it to the dealer.
	 * 
	 * Takes in the parameter "hideSecondCard" to figure out if
	 * the card will be told to the player.
	 * 
	 * @param hideSecondCard
	 * @return card at the top of the deck
	 * @throws InterruptedException
	 */
	
	public String dealerHit(int hideSecondCard) throws InterruptedException {
		String lastVal = Deck.get(0);
		Deck.remove(0);
		Thread.sleep(1000);
		if(hideSecondCard==1) System.out.println("Dealer got a " + lastVal);
		else System.out.println("This card is flipped");
		return lastVal;
	}

}
