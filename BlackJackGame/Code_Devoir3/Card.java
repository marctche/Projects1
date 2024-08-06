/**
 * Card class represents a playing card from a deck.  A card has a color and a value
 */

public class Card {
  
    private final int color;   // Card's color
    private final int value;     //Card's value (1 - 13, with 1 representing ACE).

   /***
     * Codes for the colors and non-numeric cards. Cards 2 through 10 have their numerical values for their codes.
     * */
   
    public final static int CLUBS = 0;   
    public final static int DIAMONDS = 1;
    public final static int HEARTS = 2;
    public final static int SPADES = 3; 
  
    public final static int ACE = 1;     
    public final static int JACK = 11;
    public final static int QUEEN = 12;
    public final static int KING = 13;


    /**
     * Constrcutor, that creates a card with a specified color and value.
     * @throws IllegalArgumentException if the parameter values are not in the ranges
     */
    public Card(int value, int color) {
        if (color < CLUBS || color > SPADES || value < ACE || value > KING) {
            throw new IllegalArgumentException("La valeur ou la couleur de la carte est hors des limites autorisées.");
        }
        this.value = value;
        this.color = color;
    }

    /**
     * Returns the color of this card.
     */
    public int getColor() {
        return this.color;
    }

    /**
     * Returns the value of this card.
     * @return the value, which is one of the numbers 1 through 13, inclusive for
     * a regular card.
     */
    public int getValue() {
       return this.value;
    }

    /**
     * Returns a String representation of the card's color.
     * @return one of the strings "Spades", "Hearts", "Diamonds", or "Clubs"
     */
    public String ColorToString() {
        return switch (this.color) {
            case SPADES -> "Spades";
            case DIAMONDS -> "Diamond";
            case CLUBS -> "Clubs";
            case HEARTS -> "Hearts";
            default -> "Mauvaise couleur";
        };
    }

    /**
     * Returns a String representation of the card's value.
     * @return for a regular card, one of the strings "Ace", "2",
     * "3", ..., "10", "Jack", "Queen", or "King".  
     */
    public String ValueToString() {
        return switch(this.value){
            case ACE -> "Ace";
            case QUEEN -> "Queen";
            case KING -> "King";
            case JACK -> "Jack";
            default -> String.valueOf(this.value);
        };
   }

    /**
     * Returns a string representation of this card, including both
     * its color and its value.  Sample return values is: "Ace of Diamonds", 
     */
    public String toString() {
            return ValueToString() + " of " + ColorToString();
    }

    // AJout de methode pour s'assurer que les cartes faciale deviennent des 10
    public int getBlackjackValue() {
        if (value == ACE) {
            return 1; //
        } else if (value >= JACK && value <= KING) {
            return 10; // Jack, Queen, King valent 10
        } else {
            return value;
        }
    }

} // end class Card

//Card[] newDeck = new Card[deck.length - 1];
  //      System.arraycopy(deck,1,newDeck,0,deck.length- 1);
//deck = newDeck;