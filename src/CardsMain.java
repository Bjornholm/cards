import javax.swing.*;

public class CardsMain extends JFrame{
	
	public CardsMain() {
		JPanel jp = new JP();
		add(jp);
		Deck deck = new Deck();
		setSize(500, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
	}
	public static void main(String[] args) {
		new CardsMain();
		Deck d = new Deck();
		for(int i = 0; i < 52;i++) {
			System.out.println(d.get(i).getStringSuit()+" "
							+d.get(i).getRank());			
		}
		d.Shuffle();
		for(int i = 0; i < 52;i++) {
			System.out.println(d.get(i).getStringSuit()+" "
							+d.get(i).getRank());			
		}
	}
}