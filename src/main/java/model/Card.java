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
        card.append(getRankString());
        card.append(getSuitString());
        card.append("]");

        return card.toString();
    }


    public String getSuitString() {
        String suitString = "";
        switch (this.suit) {
            case CLUBS:
                suitString = "♣";
                break;
            case DIAMONDS:
                suitString = "♦";
                break;
            case HEARTS:
                suitString = "♥";
                break;
            case SPADES:
                suitString = "♠";
                break;
        }

        //\uFE0E forces the symbol ♣, ♦, ♥, ♠ to be 1 character in size
        return suitString + "\uFE0E";

    }

    public String getRankString() {
        String rankString = "";
        switch (this.rank) {
            case ACE:
                rankString = "A";
                break;
            case JACK:
                rankString = "J";
                break;
            case QUEEN:
                rankString = "Q";
                break;
            case KING:
                rankString = "K";
                break;
            default:
                rankString = String.valueOf(rank.getValue());
                break;
        }

        return rankString;
    }
}
