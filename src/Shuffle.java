import java.util.ArrayList;
import java.util.Collections;

public class Shuffle{
	
	final int DECK_SIZE = 52;
	final static String[] newDeckOrder = {"Ace of Hearts", "Two of Hearts", "Three of Hearts", "Four of Hearts", "Five of Hearts", "Six of Hearts", "Seven of Hearts", 
			"Eight of Hearts", "Nine of Hearts", "Ten of Hearts", "Jack of Hearts", "Queen of Hearts", "King of Hearts", "Ace of Clubs", "Two of Clubs",
			"Three of Clubs", "Four of Clubs","Five of Clubs", "Six of Clubs", "Seven of Clubs", "Eight of Clubs", "Nine of Clubs", "Ten of Clubs",
			"Jack of Clubs", "Queen of Clubs", "King of Clubs", "King of Diamonds", "Queen of Diamonds", "Jack of Diamonds", "Ten of Diamonds", "Nine of Diamonds",
			"Eight of Diamonds", "Seven of Diamonds", "Six of Diamonds", "Five of Diamonds", "Four of Diamonds", "Three of Diamonds", "Two of Diamonds",
			"Ace of Diamonds", "King of Diamonds", "Queen of Diamonds", "Jack of Diamonds", "Ten of Diamonds", "Nine of Diamonds", "Eight of Diamonds",
			"Seven of Diamonds", "Six of Diamonds", "Five of Diamonds", "Four of Diamonds", "Three of Diamonds", "Two of Diamonds", "Ace of Diamonds"}; 
	
	public ArrayList<String> Deck;
	
	public Shuffle() {
		this.Deck = new ArrayList<String>();
		shuffleDeck();
	}

	private ArrayList<String> shuffleDeck() {
		arrangeDecks(Deck);
		Collections.shuffle(Deck);
		return Deck;
	}

	private void arrangeDecks(ArrayList<String> deck2) {
		for(int i = 0; i<6; i++)
		{
			for(int j = 0; j<DECK_SIZE; j++)
			{
				Deck.add(newDeckOrder[j]);
			}
		}
	}
	
	
}
