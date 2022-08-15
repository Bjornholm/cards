import java.util.ArrayList;
import java.util.Random;

public class Deck {
	
	public final int suits = 4, ranks = 13, cards = 52;
	ArrayList<Card> deck = new ArrayList<>();
	
	public Deck(){
	}
	//______________________________________________________________________________________________
	public void fill(){
		//Create a 52 card deck
		for(int suit = 0;suit < suits; suit++) {
			for(int rank = 0;rank< ranks; rank++) {
				Card card = new Card(suit,rank);
				deck.add(card);
			}
		}
	}
	//______________________________________________________________________________________________
	public Card pop() {	
		return deck.remove(deck.size()-1);
	}
	//______________________________________________________________________________________________
	public Card pop(int i) {
		try{
			return deck.remove(i);
			}
			catch(StringIndexOutOfBoundsException e ){
				System.out.println("Trying to access wrong index from Deck.pop(int i)");
			}
			return null;	
	}
	//______________________________________________________________________________________________
	public void add(Card c) {
		deck.add(c);
	}
	//______________________________________________________________________________________________
	public Card get(int i) {
		return deck.get(i);
	}
	//______________________________________________________________________________________________
	public int size(){
		return deck.size();
	}
	//______________________________________________________________________________________________
	public void shuffle() {
		//copy deck, clear original deck, add random cards over to original deck
		ArrayList<Card> tempDeck = new ArrayList<>(deck);
		Random rnd = new Random();
		deck.clear();
		for(int c = 0; c < cards; c++ ) {
			int randIndex = rnd.nextInt(cards-c);
			deck.add(tempDeck.get(randIndex));
			tempDeck.remove(randIndex);
		}
	}
	//______________________________________________________________________________________________
	public void showTop() {
		deck.get(deck.size()-1).flip();
	}
}
