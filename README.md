# BlackJack
## Project Structure

* **`Main.java`**: Entry point. Handles the main menu loop.
* **`BlackJack.java`**: Game controller. Manages the flow (dealing, turns, winner determination).
* **`Deck.java`**: Manages the 52 cards and shuffling logic.
* **`Hand.java`**: Manages a collection of cards, calculates scores, and renders the ASCII art.
* **`Card.java`**: Represents a single card with Rank and Suit.
* **`Rank.java` and `Suit.java`**: Enums defining card properties.

## How to Run

Clone this repository:

```bash
  git clone https://github.com/DavidMolinaQaracter/blackjack_game.git
```

Open the maven project con intelliJ and run the Main.java class.

## Execution Example

Execution of all program functionalities:

```text
=== BLACKJACK ===
1. Play
2. Show game rules
3. Show game history
4. Exit
Choose an option: 1

Croupier's hand:
┌───────┐ ┌───────┐ 
│░░░░░░░│ │9      │ 
│░░░░░░░│ │   ♣︎   │ 
│░░░░░░░│ │      9│ 
└───────┘ └───────┘ 

Your hand:
┌───────┐ ┌───────┐ 
│K      │ │J      │ 
│   ♠︎   │ │   ♠︎   │ 
│      K│ │      J│ 
└───────┘ └───────┘ 

Do you want to (h)it or (s)tand? s

--- Croupier's turn ---
┌───────┐ ┌───────┐ 
│2      │ │9      │ 
│   ♥︎   │ │   ♣︎   │ 
│      2│ │      9│ 
└───────┘ └───────┘ 

Croupier hits...
┌───────┐ ┌───────┐ ┌───────┐ 
│2      │ │9      │ │10     │ 
│   ♥︎   │ │   ♣︎   │ │   ♣︎   │ 
│      2│ │      9│ │     10│ 
└───────┘ └───────┘ └───────┘ 

Croupier stands...

GAME OVER!

--- Final Hands ---
Croupier's hand:
┌───────┐ ┌───────┐ ┌───────┐ 
│2      │ │9      │ │10     │ 
│   ♥︎   │ │   ♣︎   │ │   ♣︎   │ 
│      2│ │      9│ │     10│ 
└───────┘ └───────┘ └───────┘ 

Player's hand:
┌───────┐ ┌───────┐ 
│K      │ │J      │ 
│   ♠︎   │ │   ♠︎   │ 
│      K│ │      J│ 
└───────┘ └───────┘ 

You LOSE!

Do you want to play again? (y/n): y

Croupier's hand:
┌───────┐ ┌───────┐ 
│░░░░░░░│ │Q      │ 
│░░░░░░░│ │   ♥︎   │ 
│░░░░░░░│ │      Q│ 
└───────┘ └───────┘ 

Your hand:
┌───────┐ ┌───────┐ 
│K      │ │5      │ 
│   ♠︎   │ │   ♣︎   │ 
│      K│ │      5│ 
└───────┘ └───────┘ 

Do you want to (h)it or (s)tand? h

Your hand:
┌───────┐ ┌───────┐ ┌───────┐ 
│K      │ │5      │ │2      │ 
│   ♠︎   │ │   ♣︎   │ │   ♣︎   │ 
│      K│ │      5│ │      2│ 
└───────┘ └───────┘ └───────┘ 

Do you want to (h)it or (s)tand? s

--- Croupier's turn ---
┌───────┐ ┌───────┐ 
│3      │ │Q      │ 
│   ♠︎   │ │   ♥︎   │ 
│      3│ │      Q│ 
└───────┘ └───────┘ 

Croupier hits...
┌───────┐ ┌───────┐ ┌───────┐ 
│3      │ │Q      │ │7      │ 
│   ♠︎   │ │   ♥︎   │ │   ♣︎   │ 
│      3│ │      Q│ │      7│ 
└───────┘ └───────┘ └───────┘ 

Croupier stands...

GAME OVER!

--- Final Hands ---
Croupier's hand:
┌───────┐ ┌───────┐ ┌───────┐ 
│3      │ │Q      │ │7      │ 
│   ♠︎   │ │   ♥︎   │ │   ♣︎   │ 
│      3│ │      Q│ │      7│ 
└───────┘ └───────┘ └───────┘ 

Player's hand:
┌───────┐ ┌───────┐ ┌───────┐ 
│K      │ │5      │ │2      │ 
│   ♠︎   │ │   ♣︎   │ │   ♣︎   │ 
│      K│ │      5│ │      2│ 
└───────┘ └───────┘ └───────┘ 

You LOSE!

Do you want to play again? (y/n): y

Croupier's hand:
┌───────┐ ┌───────┐ 
│░░░░░░░│ │J      │ 
│░░░░░░░│ │   ♥︎   │ 
│░░░░░░░│ │      J│ 
└───────┘ └───────┘ 

Your hand:
┌───────┐ ┌───────┐ 
│3      │ │3      │ 
│   ♣︎   │ │   ♦︎   │ 
│      3│ │      3│ 
└───────┘ └───────┘ 

Do you want to (h)it or (s)tand? h

Your hand:
┌───────┐ ┌───────┐ ┌───────┐ 
│3      │ │3      │ │8      │ 
│   ♣︎   │ │   ♦︎   │ │   ♠︎   │ 
│      3│ │      3│ │      8│ 
└───────┘ └───────┘ └───────┘ 

Do you want to (h)it or (s)tand? h

Your hand:
┌───────┐ ┌───────┐ ┌───────┐ ┌───────┐ 
│3      │ │3      │ │8      │ │7      │ 
│   ♣︎   │ │   ♦︎   │ │   ♠︎   │ │   ♣︎   │ 
│      3│ │      3│ │      8│ │      7│ 
└───────┘ └───────┘ └───────┘ └───────┘ 

Do you want to (h)it or (s)tand? s

--- Croupier's turn ---
┌───────┐ ┌───────┐ 
│7      │ │J      │ 
│   ♦︎   │ │   ♥︎   │ 
│      7│ │      J│ 
└───────┘ └───────┘ 

Croupier stands...

GAME OVER!

--- Final Hands ---
Croupier's hand:
┌───────┐ ┌───────┐ 
│7      │ │J      │ 
│   ♦︎   │ │   ♥︎   │ 
│      7│ │      J│ 
└───────┘ └───────┘ 

Player's hand:
┌───────┐ ┌───────┐ ┌───────┐ ┌───────┐ 
│3      │ │3      │ │8      │ │7      │ 
│   ♣︎   │ │   ♦︎   │ │   ♠︎   │ │   ♣︎   │ 
│      3│ │      3│ │      8│ │      7│ 
└───────┘ └───────┘ └───────┘ └───────┘ 

You WIN!

Do you want to play again? (y/n): n

Press enter to continue...


=== BLACKJACK ===
1. Play
2. Show game rules
3. Show game history
4. Exit
Choose an option: 2

--- BLACKJACK RULES ---
1. GOAL: Get a hand value closer to 21 than the Croupier without exceeding 21.
2. CARD VALUES:
   - 2 through 10: Face value.
   - J, Q, K: 10 points.
   - Ace: 1 or 11 points.
3. THE DEAL: You get two cards. The Croupier gets two cards, but one is hidden.
4. YOUR TURN: Choose 'h' to Hit (take a card) or 's' to Stand (keep your hand).
5. CROUPIER'S TURN: The Croupier must hit until their hand is 17 or higher.
6. WINNING: You win if your total is higher than the Croupier's (without busting) or if the Croupier busts.

Press enter to continue...


=== BLACKJACK ===
1. Play
2. Show game rules
3. Show game history
4. Exit
Choose an option: 3

--- Game History ---
23/12/2025 00:39:18 | Player's Hand: [K♠︎] [J♠︎]  | Croupier's Hand: [2♥︎] [9♣︎] [10♣︎]  | RESULT: Player LOSE
23/12/2025 00:39:36 | Player's Hand: [K♠︎] [5♣︎] [2♣︎]  | Croupier's Hand: [3♠︎] [Q♥︎] [7♣︎]  | RESULT: Player LOSE
23/12/2025 00:39:49 | Player's Hand: [3♣︎] [3♦︎] [8♠︎] [7♣︎]  | Croupier's Hand: [7♦︎] [J♥︎]  | RESULT: Player WIN

Press enter to continue...


=== BLACKJACK ===
1. Play
2. Show game rules
3. Show game history
4. Exit
Choose an option: 4

Byee!

```
