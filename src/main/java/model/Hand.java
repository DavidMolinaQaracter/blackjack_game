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


    public void showHand(boolean showFirstCard) {
        //Depending if your the croupier or not
        if (!showFirstCard) {
            for (int i = 0; i < cards.size(); i++) {
                if(i == 0) {
                    System.out.println("Hidden card"); //If isCroupier doesnt show the first card
                }else{
                    System.out.println(cards.get(i));
                }
            }
        }else{
            for(Card card : cards){
                System.out.println(card);
            }
        }
    }

    public void clear() {
        cards.clear();
    }
}
