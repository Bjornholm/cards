import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

class Listener extends MouseAdapter 
implements MouseMotionListener{
	
	JP jp;
	Card c;	
	int xClick = 0, yClick = 0, 
		xStart = 0 , yStart = 0,
		xStop = 0 , yStop = 0;
	
	public Listener(JP j) {
		jp = j;
	}
	
	public void clicked(MouseEvent e) {
		xClick = e.getX();
		yClick = e.getY();
		//check if we clicked object
		c = jp.findCard(xClick, yClick);
	}
	public void drag(MouseEvent e) {
		xStop = e.getX() - xClick;
		yStop = e.getY() - yClick;
		//Redraw clicked object
		xClick = e.getX();
		yClick = e.getY();
	}
	public void drop(MouseEvent e) {
		xStop = e.getX() - xClick;
		yStop = e.getY() - yClick;
		//see if we can drop object here
		
	}
}
