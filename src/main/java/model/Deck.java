package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private final List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        createDeck();
        Collections.shuffle(cards);
    }

    private void createDeck() {
        cards.clear();

        for (Suit suit : Suit.values()) { //Create one card of each suit and rank
            for (Rank rank : Rank.values()) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    public Card removeCard() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("The deck is empty");
        }
        return cards.remove(0);
    }

    public int getDeckSize() {
        return cards.size();
    }
}
