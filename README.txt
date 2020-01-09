
Blackjack

To Run:
$ java BlackjackApp2

This is based on the classic blackjack game 
features:
the ability to bet an amount of the players choosing (limited by players available funds)
the ability to win or lose money
a bank which keeps track of the players funds and bets/wins/loses
a dealer with AI, who competes with the player
a Swing GUI interface utilized 
GUI popup windows and buttons with corresponding actionlisteners to allow the user to interact with the game
a library of card images with corresponding numerical values

Rules
This application has rules based on classic Blackjack.
7 decks of cards are utilized, typical to a casino. 
The goal is for the player to pull cards which sum to a number greater than the dealer and less than or equal to 21.
Obtaining a score over 21 disqualifies the player (The player "busts").
Acheiving a score of 21 ("Blackjack") results in the highest payout. 
The player cannot play if they have run out of money.

How to Play
Hit the "Hit" button to be dealt another card from the deck.
Hit the "Stay" button to keep your total where it is and allow the dealer to try to beat your sum.
Hit the "Play Again" button to play another hand, with your current bank.

Card Values
The suit does not impact card values.
Cards 2 through 10 equate to the value on the card.
Face cards (King, Queen, Jack) count for 10 points.
The Ace card may be played as an 11 or a 1, whichever allows the player to be closer to 21 without going over.

Payouts
A score of 21 ("Blackjack") yields a 3:2 payout
Beating the dealer, but not acheiving "Blackjack", the player recieves double their bet back.
A tie with the dealer returns the bet
losing to the dealer in any circumstance, the bet is not returned

Files contained in Zip:

Classes
BlackjackApp2.java - main App
CardImage.java - allows the appropriate image to be displayed for the card drawn
Deck.java - contains methods to give numerical vales to cards and shuffle the deck
PlayerMoney.java - keeps track of the player's money and contains bet() and win() methods

Images
These are the images which display cards to the user
This folder should be one underneath the Blackjack folder, for the images to be appropriately referenced
(This was created on a Windows OS, if it makes a difference)

(Just in case the files are not compiled)
To Run:
$ javac CardImage.java
$ javac Deck.java
$ javac PlayerMoney.java
$ javac BlackjackApp2.java
$ java BlackjackApp2