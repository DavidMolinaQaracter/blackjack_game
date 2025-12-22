package model;

import java.util.ArrayList;
import java.util.List;

public class Hand {

    private final List<Card> cards;
    private int handValue;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public void calculateValue() {
        int value = 0;
        int aceCount = 0;

        for (Card card : cards) {
            value += card.getValue();
            if (card.getRank() == Rank.ACE) { //Need to know how many ACEs we have
                aceCount++;
            }
        }

        // If the hand value is more than 21 then an ACE should count as 1 instead of 11
        while (value > 21 && aceCount > 0) {
            value -= 10;
            aceCount--;
        }

        this.handValue = value;
    }


    public boolean isBlackjack() {
        return cards.size() == 2 && this.handValue == 21;
    }

    public boolean hasLost() {
        return this.handValue > 21;
    }

    public int getHandValue(){
        return handValue;
    }


    public String showHand(boolean showFirstCard) {
        StringBuilder hand = new StringBuilder();
        //Depending if your the croupier or not
        if (!showFirstCard) {
            for (int i = 0; i < cards.size(); i++) {
                if(i == 0) {
                    hand.append("[X] "); //If isCroupier doesn't show the first card
                }else{
                    hand.append(cards.get(i)).append(" ");
                }
            }
        }else{
            for(Card card : cards){
                hand.append(card).append(" ");
            }
        }

        return hand.toString();
    }

    public void clear() {
        cards.clear();
    }
}
