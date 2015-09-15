package deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import deck.Card.Rank;
import deck.Card.Suit;


/** 
 * This class the handles the creation and storing of an Deck.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 17:27, September 10, 2015.
 */
public class Deck {

	// Define and initialize member variables.
	private static final int FULL_DECK = 52;
    private List<Card> deck = new ArrayList<Card>();
	
	/**
	 * Constructor which gives us a new unshuffled Deck of Cards.
	 */
	public Deck() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                deck.add(new Card(rank, suit));
            }
        }
	}
	
	/**
	 * Shuffle the Deck with Collections.
	 */
	public void shuffle() {
		if (deckSize() == FULL_DECK) {
		    Collections.shuffle(deck);
		} else {
			System.out.println("No shuffle was made. You need 52 cards in the Deck!");
		}
	}
	
	/**
	 * Draws the next Card in the Deck and remove it from the Deck.
	 * 
	 * @return the drawn Card
	 */
	public Card handOutNextCard() {
		Card drawnCard = deck.get(0);
		deck.remove(drawnCard);
		return drawnCard;
	}
	
	/**
	 * Returns the decks size.
	 * 
	 * @return the size of the deck
	 */
	public int deckSize() {
		return deck.size();
	}
}
