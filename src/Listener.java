import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

class Listener extends MouseAdapter 
implements MouseMotionListener{
	
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
		if(c != null) {
			System.out.println("xstart");
			xStart = c.getX();
			yStart = c.getY();
		}
	}
	public void mouseDragged(MouseEvent e) {
		xStop = e.getX() - xClick;
		yStop = e.getY() - yClick;
		
		xMoved = xStart + xStop;
		yMoved = yStart + yStop;
		
		//System.out.println(xMoved + " "+yMoved );
		//Redraw clicked object
		if(c != null) {			
			c.move(xMoved, yMoved);
			jp.repaint();
		}
		//xClick = e.getX();
		//yClick = e.getY();
	}
	public void mouseReleased(MouseEvent e) {
		xStop = e.getX() - xClick;
		yStop = e.getY() - yClick;
		//see if we can drop object here	
		if(c != null) {			
			c.move(xMoved, yMoved);
			jp.repaint();
		}
		xMoved = 0;
		yMoved = 0;
		c = null;
	}
}
