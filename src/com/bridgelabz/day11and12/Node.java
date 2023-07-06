package com.bridgelabz.day11and12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Node {

        Player player;
        Node next;

        public Node(Player player) {
            this.player = player;
            this.next = null;
        }
    }

    class Queue {
        Node front, rear;

        public Queue() {
            this.front = this.rear = null;
        }

        public void enqueue(Player player) {
            Node newNode = new Node(player);

            if (rear == null) {
                front = rear = newNode;
            } else {
                rear.next = newNode;
                rear = newNode;
            }
        }

        public Player dequeue() {
            if (front == null)
                return null;

            Node temp = front;
            front = front.next;

            if (front == null)
                rear = null;

            return temp.player;
        }

        public boolean isEmpty() {
            return front == null;
        }
    }

    class Card {
        private String suit;
        private String rank;

        public Card(String suit, String rank) {
            this.suit = suit;
            this.rank = rank;
        }

        public String getSuit() {
            return suit;
        }

        public String getRank() {
            return rank;
        }

        public String toString() {
            return rank + " of " + suit;
        }
    }

    class Deck {
        public Object shuffle;
        private List<Card> cards;

        public Deck() {
            cards = new ArrayList<>();
        }

        public void addCard(Card card) {
            cards.add(card);
        }

        public void shuffle() {
            Collections.shuffle(cards);
        }

        public void sortByRank() {
            cards.sort(Comparator.comparing(Card::getRank));
        }

        public Card drawCard() {
            if (cards.isEmpty()) {
                return null;
            }
            return cards.remove(0);
        }

        public boolean isEmpty() {
            return cards.isEmpty();
        }
    }

    class Player {
        private String name;
        private Deck deck;

        public Player(String name) {
            this.name = name;
            deck = new Deck();
        }

        public void addCardToDeck(Card card) {
            deck.addCard(card);
        }

        public void shuffleDeck() {
            deck.shuffle();
        }

        public void sortDeckByRank() {
            deck.sortByRank();
        }

        public Card drawCardFromDeck() {
            return deck.drawCard();
        }

        public boolean isDeckEmpty() {
            return deck.isEmpty();
        }

        public String toString() {
            return name;
        }
    }

