import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class JP extends JPanel{

	//Card c = new Card(1,2,80,80);
	Deck deck = new Deck();
	Stack source = new Stack();
	Stack waste = new Stack();
	Stack[] pile = new Stack[7];
	Stack[] sorted = new Stack[4];

	Card selectedCard = null;
	//______________________________________________________________________________________________
	public JP() {
		Listener listener = new Listener(this);
        addMouseListener(listener);
        addMouseMotionListener(listener);
		setBackground(Color.black);
		boardSetup();
	}
	//______________________________________________________________________________________________
	public void paintComponent(Graphics g) {
        super.paintComponent(g);	
        //c.draw(g);
		source.draw(g);
		waste.draw(g);
		for (Stack s : pile) {
			s.draw(g);
		}
		for (Stack s : sorted) {
			s.draw(g);
		}
		if (selectedCard != null){
			selectedCard.draw(g);
		}
	}
	//______________________________________________________________________________________________
	public Card findCard(int xClick, int yClick, Graphics g) {
		//search all cards on the panel if they contain x,y
		
		//Special behavior for source - card goes to waste or reshuffles waste if empty!
		if(source.contains(xClick, yClick) != null){
			//return source.contains(xClick, yClick);
			waste.add(source.pop());
			waste.get(waste.size()-1).setXY(waste.getX(),waste.getY());
			paintComponent(g);
			return null;
		}else if (source.clicked(xClick, yClick) && source.size() == 0){
			sourceFill(waste);
			paintComponent(g);
			return null;
		}else if(waste.contains(xClick, yClick) != null){
			return selectedCard = waste.pop();
		}

		for (Stack s : pile) {
			if(s.contains(xClick,yClick) != null){
				return selectedCard = s.pop();
			};
		}
		for (Stack s : sorted) {
			if(s.contains(xClick,yClick) != null){
				return selectedCard = s.pop();
			};
		}
		return null;
	}
	//______________________________________________________________________________________________
	private void boardSetup(){
		
		int startX = 50;
		int startY = 50;
		
		deck.fill();
		deck.shuffle();

		//Position all empty stacks on the board
		source.setXY(startX, startY);
		waste.setXY(startX + waste.width, startY);

		for(int i = 0; i < 7;i++){
			pile[i] = new Stack(startX*(i+1), startY*4 );
		}
		for(int i = 0; i < 4;i++){
			sorted[i] = new Stack(startX*(i+1)+startX*4, startY);
		}

		//Deal correct amount of cards to all stacks
		for(int i = 0; i <7; i++){
			for(int j = i; j <7;j++ ){
				deck.get(deck.size()-1).setXY(pile[j].x, pile[j].y);
				deck.get(deck.size()-1).flip();
				pile[j].add(deck.pop());
			}
		}
		sourceFill(deck);
	}
	//______________________________________________________________________________________________
	private void sourceFill(Deck st){
		while(st.size() > 0){
			st.get(0).setXY(50, 50);
			if(!st.get(0).face()){
				st.get(0).flip();
			}
			source.add(st.pop(0));
		}
	}
	//______________________________________________________________________________________________
	public boolean dropCard(int xDrop, int yDrop, Card c) {
		//drops card on sorted cell or piles
		
		for (Stack s : pile) {
			if(s.contains(xDrop,yDrop) != null){
				Card t = s.contains(xDrop, yDrop);
				if(c.drop(t)){
					s.add(c);
				}
			}
			if(s.size() == 0  && c.getRank() == 12){
				s.add(c);
			}
		}
		for (Stack s : sorted) {
			if(s.contains(xDrop,yDrop) != null){
				Card t = s.contains(xDrop, yDrop);
				if((c.getRank() == (t.getRank()+1)) && (c.getSuit() == t.getSuit())){
					s.add(c);
					return true;
				}
			};
			if(s.size() == 0 && c.getRank() == 0){
				s.add(c);
				return true;
			}
		}
		return false;
	}
	//______________________________________________________________________________________________
	public void returnCard(int x, int y, Card c) {
		//returns card to original stack if card cannot be dropped

		if((x >= source.getX() && x <= (source.getX() + source.width))){
			if((y >= source.getY() && y <= (source.getY() + source.height))){
				c.setXY(source.getX(), source.getY());
				source.add(c);
			}
		}
		if((x >= waste.getX() && x <= (waste.getX() + source.width))){
			if((y >= waste.getY() && y <= (waste.getY() + waste.height))){
				c.setXY(waste.getX(), waste.getY());
				waste.add(c);
			}
		}
		for (Stack s : pile) {
			System.out.println("test 1"+(x >= s.getX() && x <= (s.getX() + s.width)));
			System.out.println("test 2"+ (y >= s.getY() && y <= (s.getY() + s.height)));
			if((x >= s.getX() && x <= (s.getX() + s.width))){
				if((y >= s.getY() && y <= (s.getY() + s.height))){
					c.setXY(s.getX(), s.getY());
					s.add(c);
					break;
				}
			};
		}
		for (Stack s : sorted) {
			if((x >= s.getX() && x <= (s.getX() + s.width))){
				if((y >= s.getY() && y <= (s.getY() + s.height))){
					c.setXY(s.getX(), s.getY());
					s.add(c);
					break;
				}
			};
		}
	}
}