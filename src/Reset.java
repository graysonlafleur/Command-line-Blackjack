import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Reset extends Blackjack{
	
	/**
	 * Resets all necessary values for a new game.
	 */
	
	public Reset() {
		NewDeck = new Shuffle();
		Remaining = new CardsInDeck(NewDeck.Deck);
		PlayersHand = new Hand(Remaining);
		DealersHand = new Hand(Remaining);
		playAgain = false;
		br = new BufferedReader(new InputStreamReader(System.in));
	}
	
}
