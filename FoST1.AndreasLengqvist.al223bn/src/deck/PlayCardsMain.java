package deck;

/** 
 * This class tests the Deck and Card classes.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 17:27, September 10, 2015.
 */
public class PlayCardsMain {

	/**
	 * Main method which executes when the program starts.
	 * 
	 * @param args  array of strings arguments
	 */
	public static void main(String[] args) {

		Deck deck = new Deck();
		
		System.out.println("Shuffling deck.");
		deck.shuffle();
		
		for (int i = 0; i < 5; i++)
			if (deck.deckSize() > 0) {
				System.out.printf("%nCard Drawn: %s %nCards left: %d%n", deck.handOutNextCard(), deck.deckSize());				
			}
	}
}