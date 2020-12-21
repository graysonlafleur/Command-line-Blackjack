import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Hand {
	
	public ArrayList<String> Hand;
	public ArrayList<Hand> SplitHands;
	public CardsInDeck Remaining;
	public CardValue Value;
	public String splitCard;
	public BufferedReader br;
	public boolean canSplit;
	public boolean hasSplit;
	public boolean lost;
	public boolean dealerLost;
	
	public Hand(CardsInDeck Remaining) {
		this.Hand = new ArrayList<String>();
		this.Remaining = Remaining;
		this.br = new BufferedReader(new InputStreamReader(System.in));
		this.canSplit = false;
		this.lost = false;
		this.Value = new CardValue();
		this.hasSplit = false;
		this.dealerLost = false;
	}
	
	public Hand(String splitCard, CardsInDeck Remaining) {
		this.Hand = new ArrayList<String>();
		this.splitCard = splitCard;
		this.Remaining = Remaining;
		this.br = new BufferedReader(new InputStreamReader(System.in));
		this.canSplit = false;
		this.lost = false;
		this.Value = new CardValue();
		Hand.add(splitCard);
	}
	
	public void startingCards() throws InterruptedException {
		Hand.add(Remaining.hit());
	}
	
	public void playHandPreSplit() throws IOException, InterruptedException {
		if(Value.areSame(Hand.get(0), Hand.get(1))) canSplit=true;
		while(true) {
			String Response = br.readLine();
			if(Response.toLowerCase().equals("hit")) {
				Hand.add(Remaining.hit());
				System.out.println("Hand value: " + Value.getHandValue(Hand));
			}
			else if(Response.toLowerCase().equals("stand")) break;
			else if(Response.toLowerCase().equals("split") && canSplit) {
				hasSplit = true;
				SplitHands = new ArrayList<Hand>();
				for(int i = 0; i<2; i++) {
					SplitHands.add(new Hand(Hand.get(i), Remaining));
					System.out.println("Hand: " + (i+1));
					System.out.println("Card: " + Hand.get(i));
					SplitHands.get(i).playHandPostSplit();
				}
				break;
			}
			else if(Response.toLowerCase().equals("double")) {
				Hand.add(Remaining.hit());
				System.out.println("Hand value: " + Value.getHandValue(Hand));
				break;
			}
			else if(Response.toLowerCase().equals("surrender")) {
				lost = true;
				break;
			}
			else System.out.println("Incorrect input");
			
			if(Value.getHandValue(Hand) > 21 && !hasSplit) {
				System.out.println("You busted!");
				lost = true;
				break;
			}
		}
	}
	
	private void playHandPostSplit() throws IOException, InterruptedException {
		while(true) {
			String Response = br.readLine();
			if(Response.toLowerCase().equals("hit")) {
				Hand.add(Remaining.hit());
				System.out.println("Hand value: " + Value.getHandValue(Hand));
			}
			else if(Response.toLowerCase().equals("stand")) break;
			else if(Response.toLowerCase().equals("double")) {
				Hand.add(Remaining.hit());
				System.out.println("Hand value: " + Value.getHandValue(Hand));
				break;
			}
			else if(Response.toLowerCase().equals("surrender")) {
				lost = true;
				break;
			}
			else System.out.println("Incorrect input");
			
			if(Value.getHandValue(Hand) > 21) {
				System.out.println("This hand busted!");
				lost = true;
				break;
			}
		}
	}
	
	public void dealerHand() throws InterruptedException {
		System.out.println("The dealer flipped a " + Hand.get(1));
		while(true)
		{
			if(Value.getHandValue(Hand) > 21) {
				Thread.sleep(1000);
				System.out.println("The dealer busted!");
				dealerLost = true;
				break;
			}
			else if(Value.getHandValue(Hand) > 16 &&  Value.getHandValue(Hand) < 22) {
				Thread.sleep(1000);
				break;
			}
			else Hand.add(Remaining.dealerHit(1));
		}
	}

}
