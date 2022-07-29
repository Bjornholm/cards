import java.util.ArrayList;
import java.util.Random;

public class Deck {
	
	private final int suits = 4, ranks = 13, cards = 52;
	ArrayList<Card> deck = new ArrayList<>();
	
	public Deck(){
		//Create a 52 card deck
		for(int suit = 0;suit < suits; suit++) {
			for(int rank = 0;rank< ranks; rank++) {
				Card card = new Card(suit,rank);
				deck.add(card);
			}
		}
	}
	public Card Pop() {	
		return deck.remove(deck.size()-1);
	}
	public void Add(Card c) {
		deck.add(c);
	}
	public Card get(int i) {
		return deck.get(i);
	}
	
	public void Shuffle() {
		//copy deck, clear original deck, add random cards over to original deck
		ArrayList<Card> tempDeck = new ArrayList<>(deck);
		Random rnd = new Random();
		deck.clear();
		for(int c = 0; c < cards; c++ ) {
			int randIndex = rnd.nextInt(cards-c);
			//System.out.println("randindex: "+randIndex+" c: "+c+" cards: "+cards);
			deck.add(tempDeck.get(randIndex));
			tempDeck.remove(randIndex);
		}
	}
	public void showTop() {
		deck.get(deck.size()-1).flip();
	}
}
