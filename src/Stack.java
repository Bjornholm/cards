import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Color;

public class Stack extends Deck {
    ArrayList<Card> stack = new ArrayList<>();
    public final int width = 45, height = 65;
    int x, y;

    public Stack(int xPos, int yPos){
        x = xPos;
        y = yPos;
    }
    public Stack(){
        x = 0;
        y = 0;
    }
    public void setXY(int xIn, int yIn){
		x = xIn;
		y = yIn;
	}
/*
    public void add(Card c) {
		//c.setXY(x+5,y+5);
        stack.add(c);
	}
  */
    public Card contains(int x, int y ){
        Card c = null;
        for(int i = this.size() - 1; i > -1;i--){
            if(this.get(i).clicked(x,y)){
                c = this.get(i);
                //this.pop(i);
                break;
            };
        }
        return c;
    }
    public void draw(Graphics g){
        for(int i = 0; i < this.size(); i++){
            this.get(i).draw(g);
        }
        g.setColor(Color.gray);
		g.drawRect(this.x, this.y, width, height);
    }
}
//TODO
//unique stack and rules for; draw and drawn pile, 4 piles for each suit, 7 piles for initial deal
//new class for each?
