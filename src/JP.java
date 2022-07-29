import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class JP extends JPanel{
	Card c = new Card(1,2,50,50);
	public JP() {
		setBackground(Color.black);
		c.flip();
	}
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        c.draw(g);
	}
	public Card findCard(int xClick, int yClick) {
		Card c = new Card();
		//
		return c;
	}
}
