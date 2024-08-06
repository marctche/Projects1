/**
 *The Player class should be able to represent the set of cards a player has in hand.
 * The player class must allow to take a card from the deck and put it in the hand, 
 * count the points of the cards in hand...
 **/


import java.util.ArrayList;

public class Player {
     private ArrayList<Card>  hand;   // The cards in the plyaer's hand.
 
     /*Constructor*/
 Player(){
       hand = new ArrayList<Card>();

    }  
 
 /*Accessor*/
 public ArrayList<Card> getHand() {
     return this.hand;
    }
 
 /**
     * Remove all cards from the hand, leaving it empty.
  */
    public void clear() {
       hand = new ArrayList<Card>();
    }

    /**
     * Add a card to the hand.  It is added at the end of the current hand.
     * @param card the non-null card to be added.
     * @throws NullPointerException if the parameter card is null.
     */
    public void add(Card card) {
        if (card == null)
            throw new NullPointerException("La carte est nulle");
        hand.add(card);
    }

    /**
     * Remove a card from the hand, if present.
     * @param card the card to be removed.  If card is null or if the card is not in 
     * the hand, then nothing is done.
     */
    public void remove(Card card) {
        hand.remove(card);
    }

    /**
     * Remove the card in a specified position from the hand.
     * @param position the position of the card that is to be removed, where
     * positions are numbered starting from zero.
     * @throws IllegalArgumentException if the position does not exist in
     * the hand, that is if the position is less than 0 or greater than
     * or equal to the number of cards in the hand.
     */
    public void remove(int position) {
        if(position >= hand.size())
            throw new IllegalArgumentException("la position n'existe pas");
        hand.remove(position);
    }

    /**
     * Returns the number of cards in the hand.
     */
    public int totalCards() {
        return hand.size();
    }

    /**
     * Gets the card in a specified position in the hand.  (Note that this card
     * is not removed from the hand!)
     * @param position the position of the card that is to be returned
     * @throws IllegalArgumentException if position does not exist in the hand
     */
    public Card getCard(int position) {
        if(position >= hand.size())
            throw new IllegalArgumentException("la position n'existe pas");
        return hand.get(position);
    }

   /**
     * Computes and returns the total value of this hand in the game
     */
    public int getHandTotal() {
        int total = 0;
        int aceCount = 0;

        // Calculez le total initial et comptez le nombre d'As.

        for (Card card : hand) {
            total += card.getBlackjackValue();
            if (card.getValue() == Card.ACE) {
                aceCount++;
            }
        }

        // Pour chaque As dans la main, vérifiez si transformer cet As de 1 à 11 est avantageux.
        while (aceCount > 0 && total + 10 <= 21) {
            total += 10;
            aceCount--;
        }

        return total;
    }
    
    /**
     * Sorts the cards in the hand so that cards of the same color are
     * grouped together, and within a color the cards are sorted by value.
     * Note that aces are considered to have the lowest value, 1.
     */
    public void sortByColor() {
        for (int i = 0; i < hand.size() - 1; i++) {
            int indexBas = i;
            for (int j = i + 1; j < hand.size(); j++) {
                if (hand.get(j).getColor() < hand.get(indexBas).getColor() ||
                        (hand.get(j).getColor() == hand.get(indexBas).getColor() &&
                                hand.get(j).getValue() < hand.get(indexBas).getValue())) {
                    indexBas = j;
                }
            }
            Card actuelle = hand.get(i);
            hand.set(i, hand.get(indexBas));
            hand.set(indexBas, actuelle);
        }
    }

    /**
     * Sorts the cards in the hand so that cards of the same value are
     * grouped together.  Cards with the same value are sorted by color.
     * Note that aces are considered to have the lowest value, 1.
     */
    public void sortByValue() {
        for (int i = 0; i < hand.size() - 1; i++) {
            int indexBas = i;
            for (int j = i + 1; j < hand.size(); j++) {
                if (hand.get(j).getValue() < hand.get(indexBas).getValue() ||
                        (hand.get(j).getValue() == hand.get(indexBas).getValue() &&
                                hand.get(j).getColor() < hand.get(indexBas).getColor())) {
                    indexBas = j;
                }
            }
            Card actuelle = hand.get(i);
            hand.set(i, hand.get(indexBas));
            hand.set(indexBas, actuelle);
        }
    }
} 