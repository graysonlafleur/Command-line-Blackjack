import java.util.ArrayList;

public class CardValue {
	
	public int hasAce;

	public CardValue() {
		this.hasAce = 0;
	}
	
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
	
	public boolean areSame(String v1, String v2) throws NullPointerException {
		return getValue(v1) == getValue(v2);
	}
	
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
