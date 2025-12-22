package model;

import javax.management.MBeanRegistration;

public class Card {

    private final Suit suit;
    private final Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    public int getValue() {
        return rank.getValue();
    }

    @Override
    public String toString() {
        StringBuilder card = new StringBuilder();
        card.append("[");
        switch (rank) {
            case ACE:
                card.append("A");
                break;
            case JACK:
                card.append("J");
                break;
            case QUEEN:
                card.append("Q");
                break;
            case KING:
                card.append("K");
                break;
            default:
                card.append(rank.getValue());
                break;

        }


        switch (suit) {
            case CLUBS:
                card.append("♣");
                break;
            case DIAMONDS:
                card.append("♦");
                break;
            case HEARTS:
                card.append("♥");
                break;
            case SPADES:
                card.append("♠");
                break;
        }

        card.append("]");

        return card.toString();
    }
}
