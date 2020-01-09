import java.util.*;
import java.util.logging.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.io.IOException;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public abstract class BlackjackApp2 implements ActionListener
{

  static ArrayList<String> deck = new ArrayList<String>(); //initializes the deck as an ArrayList

  //Variables
  static String hs = "";
  static double mn = 0;
  static double playersum = 0;
  static double dealersum = 0;
  static int q = 0; // flag, 0 for player has not yet won or lost
  static int playerace = 0; //flag, 0 if there is not an Ace in the hand
  static int dealerace = 0;
  static PlayerMoney playermoney = new PlayerMoney(1000.00);
  static int x = 55;
  static int n = 3; //player card aspect
  static int dn = 2; //dealer card aspect
  static int dx = 35;

  //GUI
  static JFrame frame = new JFrame("Blackjack");
  static JPanel panel = new JPanel(new BorderLayout()); //by default it will have a FlowLayout
  static JLabel label = new JLabel("");
  static JButton Hit;
  static JButton Stay;
  static JButton playagn;
  static JOptionPane Popup;
  static JOptionPane Winner;

  static JLabel ls = new JLabel();
  static JLabel ps = new JLabel();
  static JLabel YourFunds = new JLabel("Your Money: $");

  //Creates new objects for new cards pulled
  static JLabel playerspace = new JLabel();
  static JLabel playerspace2 = new JLabel();
  static JLabel playerspace3 = new JLabel();
  static JLabel playerspace4 = new JLabel();
  static JLabel playerspace5 = new JLabel();
  static JLabel playerspace6 = new JLabel();
  static JLabel playerspace7 = new JLabel();
  static JLabel playerspace8 = new JLabel();
  static JLabel playerspace9 = new JLabel();

  //dealer cards Pulled
  static JLabel dealerspace = new JLabel();
  static JLabel dealerspace2 = new JLabel();
  static JLabel dealerspace3 = new JLabel();
  static JLabel dealerspace4 = new JLabel();
  static JLabel dealerspace5 = new JLabel();
  static JLabel dealerspace6 = new JLabel();
  static JLabel dealerspace7 = new JLabel();
  static JLabel dealerspace8 = new JLabel();
  static JLabel dealerspace9 = new JLabel();

  static String yourhand = "";
  static String dealershand = "";
  static String xa;

  static JLayeredPane layeredPane = new JLayeredPane(); //layered pane for your hand/adding cards when hitting
  static JLayeredPane dlayeredPane = new JLayeredPane(); //dealer layered pane



   //hit() method: Pull a card and add to total
    public static void hit(){
    if (q==0){ //game not yet won or lost
    if (BlackjackApp2.playersum<21 || BlackjackApp2.playerace>=1) {

    while (true){
    String c = Deck.shuffleGetCard(BlackjackApp2.deck);  // pull card
    ImageIcon icon3 = new ImageIcon(CardImage.cardImage(c)); //find corresponding image for card


  //n is how many cards have been pulled.
  //this appropriately orients new cards to be layered ontop of each other and still visible
    if (n==3){
      playerspace3.setIcon(icon3);
      playerspace3.setBounds(x, 25,
                          icon3.getIconWidth(),
                          icon3.getIconHeight());
      BlackjackApp2.layeredPane.add(playerspace3, new Integer(2), 0);
    }
    if (n==4){
      playerspace4.setIcon(icon3);
      playerspace4.setBounds(x, 25,
                          icon3.getIconWidth(),
                          icon3.getIconHeight());
      BlackjackApp2.layeredPane.add(playerspace4, new Integer(2), 0);
    }
    if (n==5){
      playerspace5.setIcon(icon3);
      playerspace5.setBounds(x, 25,
                          icon3.getIconWidth(),
                          icon3.getIconHeight());
      BlackjackApp2.layeredPane.add(playerspace5, new Integer(2), 0);
    }
    if (n==6){
      playerspace6.setIcon(icon3);
      playerspace6.setBounds(x, 25,
                          icon3.getIconWidth(),
                          icon3.getIconHeight());
      BlackjackApp2.layeredPane.add(playerspace6, new Integer(2), 0);
    }
    if (n==7){
      playerspace7.setIcon(icon3);
      playerspace7.setBounds(x, 25,
                          icon3.getIconWidth(),
                          icon3.getIconHeight());
      BlackjackApp2.layeredPane.add(playerspace7, new Integer(2), 0);
    }
    if (n==8){
      playerspace8.setIcon(icon3);
      playerspace8.setBounds(x, 25,
                          icon3.getIconWidth(),
                          icon3.getIconHeight());
      BlackjackApp2.layeredPane.add(playerspace8, new Integer(2), 0);
    }
    if (n==9){
      playerspace9.setIcon(icon3);
      playerspace9.setBounds(x, 25,
                          icon3.getIconWidth(),
                          icon3.getIconHeight());
      BlackjackApp2.layeredPane.add(playerspace9, new Integer(2), 0);
    }

    n++; //increment how many cards have been pulled
    x+=20; //moves card aspect to the right for each new card



    //Displays player money (after betting) available
    YourFunds.setFont(YourFunds.getFont().deriveFont(20.0F));
    YourFunds.setForeground(Color.black);
    frame.getContentPane().add(YourFunds, BorderLayout.LINE_END);
    YourFunds.setText("Your Money: $" + playermoney.moneyavail);


    BlackjackApp2.playersum += Deck.cardValue(c); //adds numerical value of card to player sum

    //flag the Ace
    if (c.substring(0,c.length()-1).equals("Ace")){
      BlackjackApp2.playerace++;
    }

    //if player busts
    if (BlackjackApp2.playersum>21 && BlackjackApp2.playerace==0){
    Popup.showMessageDialog(null, "BUST! You Lose.","Message", JOptionPane.ERROR_MESSAGE);
    q = 1; //end game flag
    break;
    }

    //if player busts, but they still have the Ace's alternate value available
    if (BlackjackApp2.playersum>21 && BlackjackApp2.playerace>=1){
    BlackjackApp2.playersum -= 10;
    BlackjackApp2.playerace--;
    break;
    }

    //Blackjack
    if (BlackjackApp2.playersum==21){
    playermoney.win(mn + (1.5 * mn));
    //update money
    YourFunds.setText("Your Money: $" + playermoney.moneyavail);
    Winner.showMessageDialog(null, "BLACKJACK! Money paid out at 3:2","WINNER", JOptionPane.PLAIN_MESSAGE);
    q = 1; //game flag on
    break;
    }
    break;
    }
    }
    }
    else{
    Popup.showMessageDialog(null, "This game has ended. Press Play Again to start a new game.","Invalid Entry", JOptionPane.ERROR_MESSAGE);
  }
  }

  public static void stay(){

  if (q==0){ //game not yet won or lost

    //Updates player funds and prints to screen
    YourFunds.setFont(YourFunds.getFont().deriveFont(20.0F));
    YourFunds.setForeground(Color.black);
    frame.getContentPane().add(YourFunds, BorderLayout.LINE_END);
    YourFunds.setText("Your Money: $" + playermoney.moneyavail);


    //Dealer AI
    while (dealersum<17 || dealerace>=1){

    String d = Deck.shuffleGetCard(deck); //pull card
    dealersum += Deck.cardValue(d); //update sum

    ImageIcon dicon3 = new ImageIcon(CardImage.cardImage(d)); //finds card image

//dn keeps track of how many cards have been Pulled
//this makes it possible to add each new card 20 units to the right of the previous card (with dx)
if (dn==2){
  dealerspace2.setIcon(dicon3);
  dealerspace2.setBounds(dx, 25,
                      dicon3.getIconWidth(),
                      dicon3.getIconHeight());
  BlackjackApp2.dlayeredPane.add(dealerspace2, new Integer(2), 0);
}
if (dn==3){
  dealerspace3.setIcon(dicon3);
  dealerspace3.setBounds(dx, 25,
                      dicon3.getIconWidth(),
                      dicon3.getIconHeight());
  BlackjackApp2.dlayeredPane.add(dealerspace3, new Integer(2), 0);
}
if (dn==4){
  dealerspace4.setIcon(dicon3);
  dealerspace4.setBounds(dx, 25,
                      dicon3.getIconWidth(),
                      dicon3.getIconHeight());
  BlackjackApp2.dlayeredPane.add(dealerspace4, new Integer(2), 0);
}
if (dn==5){
  dealerspace5.setIcon(dicon3);
  dealerspace5.setBounds(dx, 25,
                      dicon3.getIconWidth(),
                      dicon3.getIconHeight());
  BlackjackApp2.dlayeredPane.add(dealerspace5, new Integer(2), 0);
}
if (dn==6){
  dealerspace6.setIcon(dicon3);
  dealerspace6.setBounds(dx, 25,
                      dicon3.getIconWidth(),
                      dicon3.getIconHeight());
  BlackjackApp2.dlayeredPane.add(dealerspace6, new Integer(2), 0);
}
if (dn==7){
  dealerspace7.setIcon(dicon3);
  dealerspace7.setBounds(dx, 25,
                      dicon3.getIconWidth(),
                      dicon3.getIconHeight());
  BlackjackApp2.dlayeredPane.add(dealerspace7, new Integer(2), 0);
}
if (dn==8){
  dealerspace8.setIcon(dicon3);
  dealerspace8.setBounds(dx, 25,
                      dicon3.getIconWidth(),
                      dicon3.getIconHeight());
  BlackjackApp2.dlayeredPane.add(dealerspace8, new Integer(2), 0);
}
if (dn==9){
  dealerspace9.setIcon(dicon3);
  dealerspace9.setBounds(dx, 25,
                      dicon3.getIconWidth(),
                      dicon3.getIconHeight());
  BlackjackApp2.dlayeredPane.add(dealerspace9, new Integer(2), 0);
}

dn++;
dx+=20; //moves card aspect to the left for each new card



  //flag Ace if it is pulled
  if (d.substring(0,d.length()-1).equals("Ace")){
    dealerace++;
  }

    //Dealer hits blackjack
    if (dealersum==21) {
      Popup.showMessageDialog(null, "The Dealer hit Blackjack. You Lose.","Message", JOptionPane.ERROR_MESSAGE);
      q=1;
      break;
    }

    //Dealer busts and does not have the alternate value of the Ace available
    if (dealersum>21 && dealerace==0){
      Winner.showMessageDialog(null, "The Dealer Busted. You Win!","WINNER", JOptionPane.PLAIN_MESSAGE);
      playermoney.win(mn *2);
      YourFunds.setText("Your Money: $" + playermoney.moneyavail); //update playermoney
      q=1; //game flag
      break;
    }
    //Dealer is over 21, but can utilize the alternate value for the Ace
    if (dealersum>21 && dealerace>=1){
      dealersum -= 10;
      dealerace -=1; //decrement ace


    //Dealer can stop pulling cards once it has a higher sum than the player
    if (dealersum<21 && dealersum>playersum){
    break;
    }

    }
    }


    // Determines who wins if no busts and no blackjack
    if (playersum<21 && dealersum<21){

      //Player had the highest sum, player wins double what it bet
      if (playersum>dealersum){
        Winner.showMessageDialog(null, "You had the highest sum. You Win!","WINNER", JOptionPane.PLAIN_MESSAGE);
        playermoney.win(mn * 2); //money increments
      }
      //Tie, bet returned
      else if (playersum==dealersum){
        playermoney.win(mn);
        Winner.showMessageDialog(null, "You tied with the dealer. Bet is returned.","Tie", JOptionPane.PLAIN_MESSAGE);
      }

      //Dealer wins with the highest sum, the bet is kept and player money remains the same
      else {
      Popup.showMessageDialog(null, "The dealer had a higher sum. You Lose.","Message", JOptionPane.ERROR_MESSAGE);
      }

      YourFunds.setText("Your Money: $" + playermoney.moneyavail); //updated player money displayed
      q=1;
    }


  }
    //if game flag is on, prevent player from pressing stay again
    else{
      Popup.showMessageDialog(null, "This game has ended. Press Play Again to start a new game.","Invalid Entry", JOptionPane.ERROR_MESSAGE);
    }
 }



public static void playagain(){
  ArrayList<String> deck = new ArrayList<String>(); //initializes the deck as an ArrayList

  //clears cards from panel
 playerspace.setIcon(null);
 playerspace2.setIcon(null);
 playerspace3.setIcon(null);
 playerspace4.setIcon(null);
 playerspace5.setIcon(null);
 playerspace6.setIcon(null);
 playerspace7.setIcon(null);
 playerspace8.setIcon(null);
 playerspace9.setIcon(null);

 dealerspace.setIcon(null);
 dealerspace2.setIcon(null);
 dealerspace3.setIcon(null);
 dealerspace4.setIcon(null);
 dealerspace5.setIcon(null);
 dealerspace6.setIcon(null);
 dealerspace7.setIcon(null);
 dealerspace8.setIcon(null);
 dealerspace9.setIcon(null);

 //resets card orientations to beginning position
  x = 55;
  n = 3;
  dn = 2;
  dx = 35;

  YourFunds.setFont(YourFunds.getFont().deriveFont(20.0F));
  YourFunds.setForeground(Color.black);
  frame.getContentPane().add(YourFunds, BorderLayout.LINE_END);
  YourFunds.setText("Your Money: $" + playermoney.moneyavail);


  //Does not allow player to play if there is no money left
  if (playermoney.moneyavail<=0){
    Popup.showMessageDialog(null, "You are out of money. Reopen the app after you go to the ATM.","Message", JOptionPane.ERROR_MESSAGE);
  }
  else{
    // resets Variables
      double mn = 0;
       q = 0; // flag, 0 for player has not yet won or lost
      BlackjackApp2.playersum = 0; //resets sums
      BlackjackApp2.dealersum = 0;
      BlackjackApp2.playerace = 0; //resets ace flag
      BlackjackApp2.dealerace = 0;
  }

}




public static void main(String[] args)
{
{

 // Creating the Deck
  deck.addAll(Arrays.asList("TwoC", "ThreeC", "FourC", "FiveC", "SixC", "SevenC", "EightC", "NineC", "TenC", "JackC", "QueenC", "KingC", "AceC")); //Clubs
  deck.addAll(Arrays.asList("TwoD", "ThreeD", "FourD", "FiveD", "SixD", "SevenD", "EightD", "NineD", "TenD", "JackD", "QueenD", "KingD", "AceD")); //Diamonds
  deck.addAll(Arrays.asList("TwoH", "ThreeH", "FourH", "FiveH", "SixH", "SevenH", "EightH", "NineH", "TenH", "JackH", "QueenH", "KingH", "AceH")); //Hearts
  deck.addAll(Arrays.asList("TwoS", "ThreeS", "FourS", "FiveS", "SixS", "SevenS", "EightS", "NineS", "TenS", "JackS", "QueenS", "KingS", "AceS")); //Spades
  deck.addAll(Arrays.asList("TwoC", "ThreeC", "FourC", "FiveC", "SixC", "SevenC", "EightC", "NineC", "TenC", "JackC", "QueenC", "KingC", "AceC")); //Clubs
  deck.addAll(Arrays.asList("TwoD", "ThreeD", "FourD", "FiveD", "SixD", "SevenD", "EightD", "NineD", "TenD", "JackD", "QueenD", "KingD", "AceD")); //Diamonds
  deck.addAll(Arrays.asList("TwoH", "ThreeH", "FourH", "FiveH", "SixH", "SevenH", "EightH", "NineH", "TenH", "JackH", "QueenH", "KingH", "AceH")); //Hearts
  deck.addAll(Arrays.asList("TwoS", "ThreeS", "FourS", "FiveS", "SixS", "SevenS", "EightS", "NineS", "TenS", "JackS", "QueenS", "KingS", "AceS")); //Spades
  deck.addAll(Arrays.asList("TwoC", "ThreeC", "FourC", "FiveC", "SixC", "SevenC", "EightC", "NineC", "TenC", "JackC", "QueenC", "KingC", "AceC")); //Clubs
  deck.addAll(Arrays.asList("TwoD", "ThreeD", "FourD", "FiveD", "SixD", "SevenD", "EightD", "NineD", "TenD", "JackD", "QueenD", "KingD", "AceD")); //Diamonds
  deck.addAll(Arrays.asList("TwoH", "ThreeH", "FourH", "FiveH", "SixH", "SevenH", "EightH", "NineH", "TenH", "JackH", "QueenH", "KingH", "AceH")); //Hearts
  deck.addAll(Arrays.asList("TwoS", "ThreeS", "FourS", "FiveS", "SixS", "SevenS", "EightS", "NineS", "TenS", "JackS", "QueenS", "KingS", "AceS")); //Spades
  deck.addAll(Arrays.asList("TwoC", "ThreeC", "FourC", "FiveC", "SixC", "SevenC", "EightC", "NineC", "TenC", "JackC", "QueenC", "KingC", "AceC")); //Clubs
  deck.addAll(Arrays.asList("TwoD", "ThreeD", "FourD", "FiveD", "SixD", "SevenD", "EightD", "NineD", "TenD", "JackD", "QueenD", "KingD", "AceD")); //Diamonds
  deck.addAll(Arrays.asList("TwoH", "ThreeH", "FourH", "FiveH", "SixH", "SevenH", "EightH", "NineH", "TenH", "JackH", "QueenH", "KingH", "AceH")); //Hearts
  deck.addAll(Arrays.asList("TwoS", "ThreeS", "FourS", "FiveS", "SixS", "SevenS", "EightS", "NineS", "TenS", "JackS", "QueenS", "KingS", "AceS")); //Spades
  deck.addAll(Arrays.asList("TwoC", "ThreeC", "FourC", "FiveC", "SixC", "SevenC", "EightC", "NineC", "TenC", "JackC", "QueenC", "KingC", "AceC")); //Clubs
  deck.addAll(Arrays.asList("TwoD", "ThreeD", "FourD", "FiveD", "SixD", "SevenD", "EightD", "NineD", "TenD", "JackD", "QueenD", "KingD", "AceD")); //Diamonds
  deck.addAll(Arrays.asList("TwoH", "ThreeH", "FourH", "FiveH", "SixH", "SevenH", "EightH", "NineH", "TenH", "JackH", "QueenH", "KingH", "AceH")); //Hearts
  deck.addAll(Arrays.asList("TwoS", "ThreeS", "FourS", "FiveS", "SixS", "SevenS", "EightS", "NineS", "TenS", "JackS", "QueenS", "KingS", "AceS")); //Spades
  deck.addAll(Arrays.asList("TwoC", "ThreeC", "FourC", "FiveC", "SixC", "SevenC", "EightC", "NineC", "TenC", "JackC", "QueenC", "KingC", "AceC")); //Clubs
  deck.addAll(Arrays.asList("TwoD", "ThreeD", "FourD", "FiveD", "SixD", "SevenD", "EightD", "NineD", "TenD", "JackD", "QueenD", "KingD", "AceD")); //Diamonds
  deck.addAll(Arrays.asList("TwoH", "ThreeH", "FourH", "FiveH", "SixH", "SevenH", "EightH", "NineH", "TenH", "JackH", "QueenH", "KingH", "AceH")); //Hearts
  deck.addAll(Arrays.asList("TwoS", "ThreeS", "FourS", "FiveS", "SixS", "SevenS", "EightS", "NineS", "TenS", "JackS", "QueenS", "KingS", "AceS")); //Spades
  deck.addAll(Arrays.asList("TwoC", "ThreeC", "FourC", "FiveC", "SixC", "SevenC", "EightC", "NineC", "TenC", "JackC", "QueenC", "KingC", "AceC")); //Clubs
  deck.addAll(Arrays.asList("TwoD", "ThreeD", "FourD", "FiveD", "SixD", "SevenD", "EightD", "NineD", "TenD", "JackD", "QueenD", "KingD", "AceD")); //Diamonds
  deck.addAll(Arrays.asList("TwoH", "ThreeH", "FourH", "FiveH", "SixH", "SevenH", "EightH", "NineH", "TenH", "JackH", "QueenH", "KingH", "AceH")); //Hearts
  deck.addAll(Arrays.asList("TwoS", "ThreeS", "FourS", "FiveS", "SixS", "SevenS", "EightS", "NineS", "TenS", "JackS", "QueenS", "KingS", "AceS")); //Spades

  // GUI
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //closes window
  frame.setVisible(true);
  frame.add(panel, BorderLayout.SOUTH);

  JLabel label = new JLabel();
  label.setFont(label.getFont().deriveFont(20.0F));
  label.setForeground(Color.black);
  frame.getContentPane().add(label, BorderLayout.CENTER);

  JLabel YourFunds = new JLabel("Your Money: $");
  YourFunds.setFont(YourFunds.getFont().deriveFont(20.0F));
  YourFunds.setForeground(Color.black);
  frame.getContentPane().add(YourFunds, BorderLayout.LINE_END);
  YourFunds.setText("");

  JLabel ps = new JLabel();
  ps.setFont(ps.getFont().deriveFont(20.0F));
  ps.setForeground(Color.black);
  frame.getContentPane().add(ps, BorderLayout.PAGE_START);
  ps.setText("");


  //frame.pack(); //Causes this Window to be sized to fit the preferred size and layouts of its subcomponents.
  frame.setVisible(true); //Displays window
  frame.setSize(600,600); // sets a fixed window size

  frame.getContentPane().setBackground(Color.LIGHT_GRAY);
  panel.setBackground(Color.LIGHT_GRAY); //where cards are
  //label.setBackground(Color.LIGHT_GRAY);

  //Adds buttons for hit, stay and play again
  JButton Hit = new JButton("Hit");
  panel.add(Hit, BorderLayout.LINE_START);

  JButton Stay = new JButton("Stay");
  panel.add(Stay, BorderLayout.LINE_END);

  JButton Playagn = new JButton("Play Again");
  panel.add(Playagn, BorderLayout.PAGE_END);


  //Action listeners for buttons hit, stay and playagain which lead to associated methods
  Hit.addActionListener(new ActionListener(){
 @Override
 public void actionPerformed(ActionEvent e)
 {
     hit();
 }
  });

  Stay.addActionListener(new ActionListener(){
  @Override
  public void actionPerformed(ActionEvent e)
  {
   stay();
 }
  });

  Playagn.addActionListener(new ActionListener(){
  @Override
  public void actionPerformed(ActionEvent e)
  {

  //if game hasnt been flagged with a winner or loser yet, do not allow the start of a new game
  if (q==0){
      Popup.showMessageDialog(null, "You are already in a game!","Message", JOptionPane.ERROR_MESSAGE);
  }

  else{
   playagain();
   if (q==0){
   JOptionPane Wager = new JOptionPane();

   //obtain wager amount
   String bet = Wager.showInputDialog(null, "Your Funds: " + Double.toString(playermoney.moneyavail) + "\n" +  "How much would you like to wager? Enter a number.","Place Your Bet", JOptionPane.QUESTION_MESSAGE);
   mn = Double.parseDouble(bet);

   if (playermoney.moneyavail>= mn){
     playermoney.bet(mn);
   }

   //if player tries to bet more money than they have, only allow them to bet all of their available money
   else {
     mn = playermoney.moneyavail;
     playermoney.bet(playermoney.moneyavail);
     Popup.showMessageDialog(null, "You do not have the funds for that bet. All-In.","Message", JOptionPane.ERROR_MESSAGE);
   }


   String dcard1 = Deck.shuffleGetCard(deck); // dealer starting card
   if (dcard1.substring(0,dcard1.length()-1).equals("Ace")){
     dealerace=1;
   }

   dealersum += Deck.cardValue(dcard1); //add card to dealer sum

   ImageIcon dicon = new ImageIcon(CardImage.cardImage(dcard1)); //create appropriate image for card
   dealerspace.setIcon(dicon);
   dealerspace.setBounds(15, 25,
                       dicon.getIconWidth(),
                       dicon.getIconHeight());
   dlayeredPane.add(dealerspace, new Integer(2), 0);


 ls.setFont(ls.getFont().deriveFont(20.0F));
 ls.setForeground(Color.black);
 frame.getContentPane().add(ls, BorderLayout.LINE_START);


  String pcard1 = Deck.shuffleGetCard(deck);
  String pcard2 = Deck.shuffleGetCard(deck);


  layeredPane.setPreferredSize(new Dimension(200, 200));
  layeredPane.setBorder(BorderFactory.createTitledBorder("Your Hand"));
  panel.add(layeredPane, 0);


  ///// these ones work for players hand
  ImageIcon icon = new ImageIcon(CardImage.cardImage(pcard1));

  playerspace.setIcon(icon);
  playerspace.setBounds(15, 25,
                      icon.getIconWidth(),
                      icon.getIconHeight());
  layeredPane.add(playerspace, new Integer(2), 0);

  ImageIcon icon2 = new ImageIcon(CardImage.cardImage(pcard2));

  playerspace2.setIcon(icon2);
  playerspace2.setBounds(35, 25,
                      icon2.getIconWidth(),
                      icon2.getIconHeight());
  layeredPane.add(playerspace2, new Integer(2), 0);



  playersum += Deck.cardValue(pcard1) + Deck.cardValue(pcard2);


  if ((pcard1.substring(0,pcard1.length()-1).equals("Ace")) || (pcard2.substring(0,pcard2.length()-1).equals("Ace"))){
    playerace=1;
  }


  if (playersum == 21){
    playermoney.win(mn + (1.5 * mn));

    YourFunds.setText("Your Money: $" + playermoney.moneyavail);
    Winner.showMessageDialog(null, "BLACKJACK! Money paid out at 3:2","WINNER", JOptionPane.PLAIN_MESSAGE);
    q = 1;
  }



 }
}
}
  });

  // Game Begins
  JOptionPane Wager = new JOptionPane();
  String bet = Wager.showInputDialog(null, "Your Funds: " + Double.toString(playermoney.moneyavail) + "\n" +  "How much would you like to wager? Enter a number.","Place Your Bet", JOptionPane.QUESTION_MESSAGE);
  mn = Double.parseDouble(bet);

  if (playermoney.moneyavail>= mn){
    playermoney.bet(mn);
  }
  else {
    mn = playermoney.moneyavail;
    playermoney.bet(playermoney.moneyavail);
    Popup.showMessageDialog(null, "You do not have the funds for that bet. All-In.","Message", JOptionPane.ERROR_MESSAGE);
  }


  String dcard1 = Deck.shuffleGetCard(deck);

  dlayeredPane.setPreferredSize(new Dimension(200, 200));
  dlayeredPane.setBorder(BorderFactory.createTitledBorder("Dealer's Hand"));
  frame.add(dlayeredPane, 0);

  ImageIcon dicon = new ImageIcon(CardImage.cardImage(dcard1));

  dealerspace.setIcon(dicon);
  dealerspace.setBounds(15, 25,
                      dicon.getIconWidth(),
                      dicon.getIconHeight());
  dlayeredPane.add(dealerspace, new Integer(2), 0);


  if (dcard1.substring(0,dcard1.length()-1).equals("Ace")) {
    dealerace=1;
  }

  dealersum += Deck.cardValue(dcard1);

ls.setFont(ls.getFont().deriveFont(20.0F));
ls.setForeground(Color.black);
frame.getContentPane().add(ls, BorderLayout.LINE_START);


 String pcard1 = Deck.shuffleGetCard(deck);
 String pcard2 = Deck.shuffleGetCard(deck);



 layeredPane.setPreferredSize(new Dimension(200, 200));
 layeredPane.setBorder(BorderFactory.createTitledBorder("Your Hand"));
 panel.add(layeredPane, 0);

 ///// these ones work for players hand
 ImageIcon icon = new ImageIcon(CardImage.cardImage(pcard1));
 //ImageIcon icon = new ImageIcon("images/middle.gif","this is a caption");
 playerspace.setIcon(icon);
 playerspace.setBounds(15, 25,
                     icon.getIconWidth(),
                     icon.getIconHeight());
 layeredPane.add(playerspace, new Integer(2), 0);

 ImageIcon icon2 = new ImageIcon(CardImage.cardImage(pcard2));
 //ImageIcon icon = new ImageIcon("images/middle.gif","this is a caption");
 playerspace2.setIcon(icon2);
 playerspace2.setBounds(35, 25,
                     icon2.getIconWidth(),
                     icon2.getIconHeight());
 layeredPane.add(playerspace2, new Integer(2), 0);


 ls.setText("<html>" + "" + "<br/>" + "" + "<br/>" +  "" + "</html>");
 playersum += Deck.cardValue(pcard1) + Deck.cardValue(pcard2);

 if (pcard1.substring(0,pcard1.length()-1).equals("Ace")){
   playerace++;
 }

 if (pcard2.substring(0,pcard2.length()-1).equals("Ace")) {
   playerace++;
 }


 if (playersum == 21){
   playermoney.win(mn + (1.5 * mn));
   YourFunds.setText("Your Money: $" + playermoney.moneyavail);
   Winner.showMessageDialog(null, "BLACKJACK! Money paid out at 3:2","WINNER", JOptionPane.PLAIN_MESSAGE);
   q = 1;
 }


}


}

}
