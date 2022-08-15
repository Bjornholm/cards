import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Color;

public class Stack extends Deck {
    ArrayList<Card> stack = new ArrayList<>();
    public final int width = 45, height = 65;
    int x, y;
    //______________________________________________________________________________________________
    public Stack(int xPos, int yPos){
        x = xPos;
        y = yPos;
    }
    //______________________________________________________________________________________________
    public Stack(){
        x = 0;
        y = 0;
    }
    //______________________________________________________________________________________________
    public void setXY(int xIn, int yIn){
		x = xIn;
		y = yIn;
	}
    //______________________________________________________________________________________________
    public int getX(){
        return x;
    }
    //______________________________________________________________________________________________
    public int getY(){
        return y;
    }
    //______________________________________________________________________________________________
    public Card contains(int x, int y ){
        Card c = null;
        //for(int i = this.size() - 1; i > -1;i--){
        //Check topmost card
        	if(this.size() == 0) {
        		//
        	}else if(this.get(this.size() - 1).clicked(x,y)){
                    c = this.get(this.size() - 1);
        	}
        return c;
    }
    //______________________________________________________________________________________________
    public void draw(Graphics g){
        for(int i = 0; i < this.size(); i++){
            this.get(i).draw(g);
        }
        g.setColor(Color.gray);
		g.drawRect(this.x, this.y, width, height);
    }
    //______________________________________________________________________________________________
    public boolean clicked(int xClick, int yClick) {
		if(((xClick < (x + width)) && (xClick > x)) &&
		   ((yClick < (y + height)) && (yClick > y))){
			//System.out.print("clicked on the card");
			return true;
		}	
		return false;
	}
}