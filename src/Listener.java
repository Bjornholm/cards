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
		c = jp.findCard(xClick, yClick, jp.getGraphics());
		if(c != null) {
			//System.out.println("mousePressed found");
			xStart = c.getX();
			yStart = c.getY();
		}
		jp.repaint();
	}
	public void mouseDragged(MouseEvent e) {
		xStop = e.getX() - xClick;
		yStop = e.getY() - yClick;
		
		xMoved = xStart + xStop;
		yMoved = yStart + yStop;
		
		//Redraw clicked object
		if(c != null) {			
			c.move(xMoved, yMoved);
		}
		jp.repaint();
	}
	public void mouseReleased(MouseEvent e) {
		xStop = e.getX() - xClick + xStart;
		yStop = e.getY() - yClick + yStart;
		//see if we can drop object here
		//TODO - object needs to move back to it's original coordinates if it's not allowed to be dropped at current location	
		if(c != null) {					
			if(jp.dropCard(xClick, yClick,c)){
			}else{
				System.out.println("Xstart: "+xStart);
				System.out.println("Ystart: "+yStart);

				jp.returnCard(xStart, yStart, c);
			}		
		}
		xMoved = 0;
		yMoved = 0;
		c = null;
		jp.repaint();
	}
}
