import java.util.ArrayList;

public class CardsInDeck {
	
	ArrayList<String> Deck;
	
	public CardsInDeck(ArrayList<String> Deck) {
		this.Deck = Deck;
	}
	
	public String hit() throws InterruptedException {
		String lastVal = Deck.get(0);
		Deck.remove(0);
		Thread.sleep(1000);
		System.out.println("You got a " + lastVal);
		return lastVal;
	}
	
	public String dealerHit(int hideSecondCard) throws InterruptedException {
		String lastVal = Deck.get(0);
		Deck.remove(0);
		Thread.sleep(1000);
		if(hideSecondCard==1) System.out.println("Dealer got a " + lastVal);
		else System.out.println("This card is flipped");
		return lastVal;
	}

}
