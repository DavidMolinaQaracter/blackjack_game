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


    public void showPrettyHand(boolean showFirstCard) {
        StringBuilder[] cardsString = new StringBuilder[5]; //Height of a card print
        for (int i = 0; i < 5; i++) {
            cardsString[i] = new StringBuilder();
        }

        //Depending if your the croupier or not
        if (!showFirstCard) {
            for (int i = 0; i < cards.size(); i++) {
                if(i == 0) {
                    cardsString[0].append("┌───────┐ ");
                    cardsString[1].append("│░░░░░░░│ ");
                    cardsString[2].append("│░░░░░░░│ ");
                    cardsString[3].append("│░░░░░░░│ ");
                    cardsString[4].append("└───────┘ ");
                }else{
                    addCardString(cardsString, cards.get(i));
                }
            }
        }else{
            for(Card card : cards){
                addCardString(cardsString, card);
            }
        }

        for(StringBuilder card : cardsString){
            System.out.println(card);
        }
    }

    public String showSimpleHand(boolean showFirstCard) {
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

    public void addCardString(StringBuilder[] cardsString, Card card) {
        String rank = card.getRankString();
        String suit = card.getSuitString();

        cardsString[0].append("┌───────┐ ");
        cardsString[1].append(String.format("│%-2s     │ ", rank));
        cardsString[2].append(String.format("│   %s   │ ", suit));
        cardsString[3].append(String.format("│     %2s│ ", rank));
        cardsString[4].append("└───────┘ ");
    }


    public void clear() {
        cards.clear();
    }
}
