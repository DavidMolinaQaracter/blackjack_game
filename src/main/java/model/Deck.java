package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private final List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        createDeck();
        shuffle();
    }

    /**
     * Creates a standard deck of 52 cards
     */
    private void createDeck() {
        cards.clear();

        for (Suit suit : Suit.values()) { //Create one card of each suit and rank
            for (Rank rank : Rank.values()) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    /**
     * Shuffles the deck.
     */
    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * Deals (removes and returns) the top card of the deck.
     */
    public Card removeCard() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("The deck is empty");
        }
        return cards.remove(0);
    }

    /**
     * Returns the number of remaining cards.
     */
    public int getDeckSize() {
        return cards.size();
    }
}
