import java.util.*;

public class Deck{



public static String shuffleGetCard(ArrayList<String> deck){
  //System.out.println("Deck \n" + deck); Prints pre shuffled deck
  Collections.shuffle(deck); //randomly shuffles the deck
  // System.out.println("\nShuffled Deck \n" + deck); prints out shuffled deck before taking a card off the top
  String card = deck.get(0); //retrieves first index (ie first card) after shuffling
  deck.remove(0); //removes card from deck
//  System.out.println("\nShuffled Deck \n" + deck); //prints out shuffled deck after the top card has been taken
  //System.out.println("\nNumber of Cards in Deck: " + deck.size()); //prints number of cards in the deck remaining
return card;
}



public static int cardValue(String card){
  if (card.substring(0,card.length()-1).equals("Two")) return 2;
  if (card.substring(0,card.length()-1).equals("Three")) return 3;
  if (card.substring(0,card.length()-1).equals("Four")) return 4;
  if (card.substring(0,card.length()-1).equals("Five")) return 5;
  if (card.substring(0,card.length()-1).equals("Six")) return 6;
  if (card.substring(0,card.length()-1).equals("Seven")) return 7;
  if (card.substring(0,card.length()-1).equals("Eight")) return 8;
  if (card.substring(0,card.length()-1).equals("Nine")) return 9;
  if (card.substring(0,card.length()-1).equals("Ten")) return 10;
  if (card.substring(0,card.length()-1).equals("Jack")) return 10;
  if (card.substring(0,card.length()-1).equals("Queen")) return 10;
  if (card.substring(0,card.length()-1).equals("King")) return 10;
  if (card.substring(0,card.length()-1).equals("Ace")) return 11;
  else return -1;
}



}
