package com.bridgelabz.day11and12;

    import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

    public class DeckOfCards {
        public List<String> suits;
       public List<String> ranks;
        public List<String> deck;
       public Random random;

        public DeckOfCards() {
            suits = Arrays.asList("Clubs", "Diamonds", "Hearts", "Spades");
            ranks = Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace");
            deck = new ArrayList<>();
            random = new Random();
        }

        public void initializeDeck() {
            for (String suit : suits) {
                for (String rank : ranks) {
                    deck.add(rank + " of " + suit);
                }
            }
        }

        public void shuffleDeck() {
            Collections.shuffle(deck, random);
        }

        public void distributeCards(int numPlayers, int numCards) {
            if (numPlayers * numCards > deck.size()) {
                System.out.println("Insufficient cards in the deck.");
                return;
            }

            String[][] playerCards = new String[numPlayers][numCards];
            int cardIndex = 0;

            for (int player = 0; player < numPlayers; player++) {
                for (int card = 0; card < numCards; card++) {
                    playerCards[player][card] = deck.get(cardIndex);
                    cardIndex++;
                }
            }

            printPlayerCards(playerCards);
        }

        private void printPlayerCards(String[][] playerCards) {
            for (int player = 0; player < playerCards.length; player++) {
                System.out.println("Player " + (player + 1) + " Cards:");
                for (int card = 0; card < playerCards[player].length; card++) {
                    System.out.println(playerCards[player][card]);
                }
                System.out.println();
            }
        }

        public static void main(String[] args) {
            DeckOfCards deckOfCards = new DeckOfCards();
            deckOfCards.initializeDeck();
            deckOfCards.shuffleDeck();
            deckOfCards.distributeCards(4, 9);
        }
    }


