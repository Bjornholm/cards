import java.awt.Color;
import java.awt.Graphics;
import java.util.Map;

public class Card {
	private boolean face = false;
	private int suit, rank;
	Map<Integer,String> suitString = Map.ofEntries(
			Map.entry(0, "Spades"),
			Map.entry(1, "Hearts"),
			Map.entry(2, "Diamonds"),
			Map.entry(3, "Clover")); 

	public Card(){
		suit = 0;
		rank = 0;
	}
	public Card(int in_suit, int in_rank) {
		suit = in_suit;
		rank = in_rank;
	}
	public String getStringSuit() {
		return suitString.get(this.suit);
	}
	public int getSuit() {
		return suit;
	}
	public int getRank() {
		return rank;
	}
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(10, 10, 20, 30);
		g.setColor(Color.black);
		g.drawString(suit + " "+rank, 15, 20);
	}
}
