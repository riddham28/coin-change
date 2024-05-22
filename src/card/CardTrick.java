/**
 * CardTrick class
 * Modifier: RIDDHAM MAVANI
 * Student Number: 991716133
 */

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package card;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author srinivsi
 */
import java.util.Random;
import java.util.Scanner;


public class CardTrick {

    public static void main(String[] args) {
        // Create an array of 7 cards
        Card[] magicHand = new Card[7];
        Random rand = new Random();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};

        for (int i = 0; i < magicHand.length; i++) {
            int value = rand.nextInt(13) + 1; // Card values 1-13
            String suit = suits[rand.nextInt(4)]; // Random suit
            magicHand[i] = new Card(value, suit);
        }

        // Print magic hand for debugging purposes
        for (Card card : magicHand) {
            System.out.println(card);
        }

        // Ask user to pick a card
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pick a card value (1-13): ");
        int userValue = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Pick a suit (Hearts, Diamonds, Clubs, Spades): ");
        String userSuit = scanner.nextLine();

        // Search for the card
        boolean found = false;
        for (Card card : magicHand) {
            if (card.getValue() == userValue && card.getSuit().equalsIgnoreCase(userSuit)) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Your card is in the magic hand!");
        } else {
            System.out.println("Your card is not in the magic hand.");
        }
    }
}

class Card {
    private int value;
    private String suit;

    public Card(int value, String suit) {
        this.value = value;
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public String getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return value + " of " + suit;
    }
}
// Hard-coded lucky card
Card luckyCard = new Card(7, "Hearts");

// Search for the lucky card
boolean found = false;
for (Card card : magicHand) {
    if (card.getValue() == luckyCard.getValue() && card.getSuit().equalsIgnoreCase(luckyCard.getSuit())) {
        found = true;
        break;
    }
}

if (found) {
    System.out.println("Your lucky card is in the magic hand! You win!");
} else {
    System.out.println("Your lucky card is not in the magic hand. You lose.");
}
