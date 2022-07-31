import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class Listener extends MouseAdapter {
	
	JP jp;
	Card c;	
	int xClick = 0, yClick = 0, 
		xStart = 0 , yStart = 0,
		xStop = 0 , yStop = 0,
		xMoved = 0, yMoved =0;
	
	public Listener(JP j) {
		jp = j;
	}
	
	public void mousePressed(MouseEvent e) {
		xClick = e.getX();
		yClick = e.getY();
		//check jPanel if we clicked an object
		c = jp.findCard(xClick, yClick);
		//TODO - need alternate way to handle deal piles, should be able to move a card with stacked cards on top of it if they are flipped
		//TODO some objects aren't allowed to move even if selected, i.e. they have unflipped cards above them
		if(c != null) {
			//System.out.println("mousePressed found");
			xStart = c.getX();
			yStart = c.getY();
		}
	}
	public void mouseDragged(MouseEvent e) {
		xStop = e.getX() - xClick;
		yStop = e.getY() - yClick;
		
		xMoved = xStart + xStop;
		yMoved = yStart + yStop;
		
		//Redraw clicked object
		if(c != null) {			
			c.move(xMoved, yMoved);
			jp.repaint();
		}
		//xClick = e.getX();
		//yClick = e.getY();
	}
	public void mouseReleased(MouseEvent e) {
		xStop = e.getX() - xClick + xStart;
		yStop = e.getY() - yClick + yStart;
		//see if we can drop object here
		//TODO - object needs to move back to it's original coordinates if it's not allowed to be dropped at current location	
		if(c != null) {			
			c.move(xStop, yStop);
			jp.repaint();
		}
		xMoved = 0;
		yMoved = 0;
		c = null;
	}
}
