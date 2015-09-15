package deck;


/** 
 * This class handles creation and storing of a Card.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 17:27, September 10, 2015.
 */
public class Card {

    public enum Rank {DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE}

    public enum Suit {CLUBS, DIAMONDS, HEARTS, SPADES}

    // Member variables.
    private final Rank rank;
    private final Suit suit;
    
	/**
	 * Constructor which sets the suit and rank of an Card.
	 * 
	 * @param rank
	 * @param suit
	 */
    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }
    
	/**
	 * Gets the rank.
	 * 
	 * @return rank
	 */
    public Rank getRank() {
    	return this.rank;
    }
    
	/**
	 * Gets the Suit.
	 * 
	 * @return suit
	 */
    public Suit getSuit() {
    	return this.suit;
    }
    
	/**
	 * Returns a string which, if printed, provides a nice looking print out of the Card content.
	 * 
	 * @return	a pretty String
	 */
    public String toString() { 
    	return rank + " of " + suit; 
	}
}