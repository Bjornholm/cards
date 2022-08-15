import java.awt.Color;
import java.awt.Graphics;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Card {
	private int x, y;
	final public int width = 35, height = 50;
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
	public void setXY(int xIn, int yIn){
		x = xIn;
		y = yIn;
	}
//_________________________________________________________________________________________________
//Drawing and moving methods
	
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, width, height);
		g.setColor(Color.red);
		g.drawRect(x, y, width, height);
		
		if(face) {			
			g.setColor(Color.red);		
			g.drawString(""+suit + " | "+rank, x+1, y+15);
		}
	}
	//______________________________________________________________________________________________
	public void move(int xStop, int yStop) {
		x = xStop;
		y = yStop;
	}
	//______________________________________________________________________________________________
	public void flip() {		
		face = !face;
	}
	//______________________________________________________________________________________________
	public boolean face() {		
			return face;
	}
	//______________________________________________________________________________________________
	public boolean clicked(int xClick, int yClick) {
		if(((xClick <= (x + width)) && (xClick >= x)) &&
		   ((yClick <=( y + height)) && (yClick >= y))){
			//System.out.print("clicked on the card");
			return true;
		}	
		return false;
	}
	//______________________________________________________________________________________________
	//Can this be dropped on card c?
	public boolean drop(Card c){
		if((this.getSuit() == 0 || this.getSuit() == 3) && (c.getSuit() == 1 || c.getSuit() == 2) ){
			if(this.getRank() == (c.getRank()+1)){
				return true;
			}
		}
		if((this.getSuit() == 1 || this.getSuit() == 2) && (c.getSuit() == 0 || c.getSuit() == 3) ){
			if(this.getRank() == (c.getRank()+1)){
				return true;
			}
		}
		return false;
	}
}
