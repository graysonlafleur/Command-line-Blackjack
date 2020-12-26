import java.util.ArrayList;

public class CardValue {
	
	//Checks how many aces the hand has to accurately value the hand
	public int hasAce;

	public CardValue() {
		this.hasAce = 0;
	}
	
	/**
	 * Gives the numerical value of the inputed card
	 * 
	 * @param v1
	 * @return numerical value of inputed card
	 */
	
	public int getValue(String v1) {
		String[] value = v1.split(" ");
		if(value[0].equals("Two")) return 2;
		else if(value[0].equals("Three")) return 3;
		else if(value[0].equals("Four")) return 4;
		else if(value[0].equals("Five")) return 5;
		else if(value[0].equals("Six")) return 6;
		else if(value[0].equals("Seven")) return 7;
		else if(value[0].equals("Eight")) return 8;
		else if(value[0].equals("Nine")) return 9;
		else if(value[0].equals("Ace")) {
			hasAce++;
			return 11;
		}
		else return 10;
	}
	
	/**
	 * Takes two cards and says if they're values are the same.
	 * 
	 * @param v1
	 * @param v2
	 * @return If the two card values are the same
	 * @throws NullPointerException
	 */
	
	public boolean areSame(String v1, String v2) throws NullPointerException {
		return getValue(v1) == getValue(v2);
	}
	
	/**
	 * Gives the numerical value of a hand.
	 * 
	 * @param hand
	 * @return numerical value of given hand
	 */
	
	public int getHandValue(ArrayList<String> hand) {
		int size = 0;
		for(int i = 0; i<hand.size(); i++) {
			size += getValue(hand.get(i));
			if(hasAce > 0 && size > 21) {
				hasAce--;
				size -= 10;
			}
		}
		return size;
	}
	
}
