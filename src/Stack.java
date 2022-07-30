import java.util.ArrayList;
import java.awt.Graphics;

public class Stack extends Deck {
    ArrayList<Card> stack = new ArrayList<>();

    public Stack(){
    }

    public Card contains(int x, int y ){
        Card c = null;
        for(int i = this.size() - 1; i > 0;i--){
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
    }
}
