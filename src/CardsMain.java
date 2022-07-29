import javax.swing.*;

public class CardsMain extends JFrame{
	
	public CardsMain() {
		setTitle("Solitaire");
		JPanel jp = new JP();
		add(jp);
		setVisible(true);
		setSize(500, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
	}
	public static void main(String[] args) {
		new CardsMain();
	}
}