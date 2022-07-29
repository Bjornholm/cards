import java.awt.Color;
import java.awt.Graphics;
import java.util.Map;

public class Card {
	private int x, y;
	final int width = 35, height = 50;
	private boolean face = false;
	private int suit, rank;
	Map<Integer,String> suitString = Map.ofEntries(
			Map.entry(0, "Spades"),
			Map.entry(1, "Hearts"),
			Map.entry(2, "Diamonds"),
			Map.entry(3, "Clover")); 

//Constructors________________________________________________________________________________
	public Card(){
		suit = 0;
		rank = 0;
		x = 0;
		y = 0;
	}
	public Card(int in_suit, int in_rank) {
		suit = in_suit;
		rank = in_rank;
		x = 0;
		y = 0;
	}
	public Card(int in_suit, int in_rank, int xIn, int yIn) {
		suit = in_suit;
		rank = in_rank;
		x = xIn;
		y = yIn;
	}
//get/set______________________________________________________________________________________
	public String getStringSuit() {
		return suitString.get(this.suit);
	}
	public int getSuit() {
		return suit;
	}
	public int getRank() {
		return rank;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setX(int xIn) {
		x = xIn;
	}
	public void setY(int yIn) {
		y = yIn;
	}
//_________________________________________________________________________________________________
//Drawing and moving methods
	
	public void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, width, height);
		if(face) {			
			g.setColor(Color.black);		
			g.drawString(""+suit + " | "+rank, x+1, y+15);
		}
	}
	public void move(Graphics g, int x2, int y2) {
		x = x2;
		y = y2;
	}
	public void flip() {		
		face = !face;
		System.out.print(face);
	}
}
