import java.util.Random;

/**
 *  Deck represents a deck of playing cards and contains 52 regular cards.
 */
public class Deck {

    private final Card[] deck = new Card[52];  // an array of 52 cards.
    private int number = 0;  //the number of cards that have been dealt from the deck

    /**
     * Constructs a regular 52-card poker deck.  Initially, the cards
     * are in a sorted order.  
     */

    public Deck() {
        for (int c = 0; c < 4; c++ ) {
            for(int v = 1; v <= 13; v++){

                    deck[number] = new Card(v,c);
                    number++;
            }
        }
        number = 0;
 }


    /**
     * Put all the used cards back into the deck (if any), and
     * shuffle the deck into a random order.
     */
    public void shuffle() {
        number = 0;
        Random rand = new Random();

        for (int i = deck.length - 1; i > 0; i--){

            int j = rand.nextInt(i+1);

            Card actuelle = deck[i];
            deck[i] = deck[j];
            deck[j] = actuelle;
        }
    }

    /**
     * Returns the number of cards left in the deck.  
     */
    public int numberLeft() {
        return 52-number;
    }

    /**
     * Removes the next card from the deck and return it.  It is illegal
     * to call this method if there are no more cards in the deck.  You can
     * check the number of cards remaining by calling the numberLeft() function.
     * @return the card which is removed from the deck.
     * @throws IllegalStateException if there are no cards left in the deck
     */
    public Card take() {
        if (number >= deck.length) {
            throw new IllegalStateException("Le tableau na pas de taille");
        }

        Card carteASortir = deck[number];
        number++;
        return carteASortir;
    }
} // end class Deck
