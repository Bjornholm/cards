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
	
	public void mousePressed(MouseEvent e) {
		xClick = e.getX();
		yClick = e.getY();
		System.out.println(xClick+" "+yClick);
		//check jPanel if we clicked an object
		c = jp.findCard(xClick, yClick);
		if(c != null) {
			xStart = c.getX();
			yStart = c.getY();
			System.out.print(xClick+" "+yClick);
		}
	}
	public void mouseDragged(MouseEvent e) {
		xStop = e.getX() - xClick;
		yStop = e.getY() - yClick;
		//Redraw clicked object
		c.move(xStop, yStop);
		xClick = e.getX();
		yClick = e.getY();
	}
	public void mouseReleased(MouseEvent e) {
		xStop = e.getX() - xClick;
		yStop = e.getY() - yClick;
		//see if we can drop object here	
			c.move(xStop, yStop);
		
	}
}
