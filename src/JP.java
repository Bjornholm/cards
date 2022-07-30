import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class JP extends JPanel{

	Card c = new Card(1,2,80,80);
	Deck deck = new Deck();
	Stack stack = new Stack();
	Card selectedCard = null;

	public JP() {
		Listener listener = new Listener(this);
        addMouseListener(listener);
        addMouseMotionListener(listener);
		setBackground(Color.black);
		c.flip();
		deck.shuffle();
		for (int i = 0; i < deck.size(); i++ ){
			deck.get(i).setXY(50+i, 50);
			stack.add(deck.pop(i));
			System.out.println("Stack size: "+stack.size());
		}
	}
	public void paintComponent(Graphics g) {
        super.paintComponent(g);	
        c.draw(g);
		stack.draw(g);
		if (selectedCard != null){
			selectedCard.draw(g);
		}
		System.out.println("Stack size: "+stack.size());
	}
	public Card findCard(int xClick, int yClick) {
		//search all cards on the panel if they contain the x,y
		if(c.clicked(xClick, yClick)) {
			System.out.println("c clicked");
			return c;
		}
		else if(stack.contains(xClick, yClick) != null){
			System.out.println("stack clicked");
			return stack.contains(xClick, yClick);
		}
		else{
			return null;
		}
	}
}
