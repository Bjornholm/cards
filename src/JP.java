import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class JP extends JPanel{

	Card c = new Card(1,2,80,80);
	Deck deck = new Deck();
	Stack source = new Stack();
	Stack waste = new Stack();
	Stack[] pile = new Stack[7];
	Stack[] sorted = new Stack[4];

	Card selectedCard = null;

	public JP() {
		Listener listener = new Listener(this);
        addMouseListener(listener);
        addMouseMotionListener(listener);
		setBackground(Color.black);
		boardSetup();
	}
	public void paintComponent(Graphics g) {
        super.paintComponent(g);	
        c.draw(g);
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
	public Card findCard(int xClick, int yClick) {
		//search all cards on the panel if they contain x,y
		if(c.clicked(xClick, yClick)) {
			System.out.println("c clicked");
			return c;
		}
		else if(source.contains(xClick, yClick) != null){
			System.out.println("stack clicked");
			return source.contains(xClick, yClick);
		}
		else if(waste.contains(xClick, yClick) != null){
			System.out.println("waste clicked");
			return source.contains(xClick, yClick);
		}
		for (Stack s : pile) {
			if(s.contains(xClick,yClick) != null){
				System.out.println("pile clicked");
				return s.contains(xClick, yClick);
			};
		}
		/*
		for(int i = 0; i <7; i++){;
			if(pile[i].contains(xClick,yClick) != null){
				System.out.println("pile  of "+ i+" clicked");
				return pile[i].contains(xClick, yClick);
			};
		}
		 */
		for (Stack s : sorted) {
			if(s.contains(xClick,yClick) != null){
				System.out.println("sorted clicked");
				return s.contains(xClick, yClick);
			};
		}
		return null;
	}
	private void boardSetup(){
		
		int startX = 50;
		int startY = 50;
		
		c.flip();
		deck.fill();
		deck.shuffle();

		//Position all stacks on the board
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
			deck.get(deck.size()-1).setXY(pile[i].x, pile[i].y+i);
			deck.get(deck.size()-1).flip();
			pile[i].add(deck.pop());
		}
		while(deck.size() > 0){
			deck.get(0).setXY(50, 50);
			deck.get(0).flip();
			source.add(deck.pop(0));
		}
	}
}