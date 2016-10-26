/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trial;


import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author jay
 */
public class Trial {

    /**
     * @param args the command line arguments
     */

 




    public static void main(String[] args) {

        

        //52 Cards, Aces = 11, Picture cards = 10, Ace's cannot be reduced to 1.
        int[] newCard = {2,2,2,2,3,3,3,3,4,4,4,4,5,5,5,5,6,6,6,6,7,7,7,7,8,8,8,8,9,9,9,9,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,11,11,11,11};

        //Shuffle. Once per game.
        shuffleArray(newCard);

        //Start BlackJack.
        String Intro = "Welcome to the table";
     
        JOptionPane.showMessageDialog(null, Intro);
        String YourHand = "You get a " + newCard[0] + "and a " + newCard[1];
        JOptionPane.showMessageDialog(null, YourHand);
        int playerTotal = newCard[0] + newCard[1];
        String YourTotal ="Your total is " + playerTotal;
        JOptionPane.showMessageDialog(null, YourTotal);

        //Player can get blackjack/bust in the 1st deal. - awaiting betting system (enhanced bets for blackjack in first round)
        if (playerTotal == 21){
            JOptionPane.showMessageDialog(null,"Black Jack you win");
            System.exit(0);
        }
        if (playerTotal > 21){
            JOptionPane.showMessageDialog(null, "You busted, You lose, Try again");
            System.exit(0);
        }
        // Dealer cards
        JOptionPane.showMessageDialog(null, "The dealer has a " + newCard[2] + " showing, and a hidden card.");
        int dealerTotal = newCard[2] + newCard[3];
        if (dealerTotal > 21){     //Dealer bust check.
            JOptionPane.showMessageDialog(null, "Dealers total is " + dealerTotal + ".");
            JOptionPane.showMessageDialog(null, "Dealer is bust, you win!");
            System.exit(0);
        }
        if (dealerTotal == 21){    //Dealer blackjack check.
            JOptionPane.showMessageDialog(null, "Dealer reveals his second card: " + newCard[3] + ".");
            JOptionPane.showMessageDialog(null, "Dealers total is " + dealerTotal + ".");
            JOptionPane.showMessageDialog(null, "Dealer has BlackJack, you lose.");
            System.exit(0);
        }
        JOptionPane.showMessageDialog(null, "His total is hidden.");
        


        // Hit or Stay for player.
        JOptionPane.showMessageDialog(null, "Would you like to \"hit\" or \"stay\"? ");
        String hitStay = JOptionPane.showInputDialog("hit or stay");
       

        //cc = card count
        int cc = 4; 
        if (hitStay.equalsIgnoreCase("hit")){
            // While loop to ensure different cards & multiple "hits".
            while (playerTotal < 21 && hitStay.equalsIgnoreCase("hit")){
                if (hitStay.equalsIgnoreCase("hit")){
                    JOptionPane.showMessageDialog(null, "You drew a " + newCard[cc] + ".");
                    playerTotal = playerTotal + newCard[cc];
                    JOptionPane.showMessageDialog(null, "Your total is " + playerTotal + ".");
                    
                    cc++;        //Adds 1 to ensure next card is different.
                    // Bust & Blackjack check.
                    if (playerTotal > 21){
                        JOptionPane.showMessageDialog(null, "Busted, You lose.");
                        System.exit(0);
                    }
                    if (playerTotal == 21){
                        JOptionPane.showMessageDialog(null, "Blackjack, you win.");
                        System.exit(0);
                    }
                    JOptionPane.showMessageDialog(null, "Would you like to \"hit\" or \"stay\"? ");
                    hitStay = JOptionPane.showInputDialog("hit or stay");
                    
                }
            }        
        }

        // Dealers turn, only if Round 1 didn't end in bust/blackjack.
        
        JOptionPane.showMessageDialog(null, "Ok dealers turn.");
        JOptionPane.showMessageDialog(null, "His hidden card was a " + newCard[3] + "."); // reveal hidden from round one.

        cc++; 
        while (dealerTotal < 16){ // Dealer will stay on 16+ and hit if below.
            JOptionPane.showMessageDialog(null, "Dealer chooses to hit.");
            JOptionPane.showMessageDialog(null, "He draws a " + newCard[cc] + ".");
            cc++;
            dealerTotal = dealerTotal + newCard[cc];
            JOptionPane.showMessageDialog(null, "His total is " + dealerTotal);
            // bust check - no need for blackjack check due to final win sequence
            if (dealerTotal > 21){
                JOptionPane.showMessageDialog(null, "Dealer is bust, YOU WIN!");
                System.exit(0);
            }
            // stay condition.
            if (dealerTotal < 21 && dealerTotal > 16){
                JOptionPane.showMessageDialog(null, "Dealer Stays.");
            }
        }

        // final win sequence.
        JOptionPane.showMessageDialog(null, "Dealer total is " + dealerTotal);
        JOptionPane.showMessageDialog(null, "Your total is " + playerTotal);
        

        if (dealerTotal > playerTotal){
            JOptionPane.showMessageDialog(null, "Dealer wins.");
        } 
        if (dealerTotal == playerTotal){
            JOptionPane.showMessageDialog(null, "You both draw.");
        }
        if (dealerTotal < playerTotal){
            JOptionPane.showMessageDialog(null, "You win.");
        }
    }

    static void shuffleArray(int[] deckCards){

    

        Random rnd = new Random();
        for (int i = deckCards.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            // Swap
            int a = deckCards[index];
            deckCards[index] = deckCards[i];
            deckCards[i] = a;
        }
        
  
    }
}