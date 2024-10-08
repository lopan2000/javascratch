package interview.deckofcards.algomonster;

import java.util.*;

public class Solution {

    public static class Game {

        private Deck deck;
        private static List<Hand> hands = new ArrayList<>();

        public Game() {
            deck = new Deck();
        }

        public void addCard(String suit, String value) {
            deck.add(new Card(suit, value));
        }

        public void addJoker(String color) {
            deck.add(new Card(color, Card.VALUE_JOKER));
        }

        public void addHand(List<Integer> cardIndices) {
            hands.add(new Hand(cardIndices, deck));
        }

        public String handString(int hand) {
            return hands.get(hand).toString();
        }

        public String cardString(int card) {
            return deck.get(card).toString();
        }

        public boolean cardBeats(int cardA, int cardB) {
            return deck.get(cardA).beats(deck.get(cardB));
        }

        public static boolean handBeats(int handA, int handB) {
            return hands.get(handA).beats(hands.get(handB));
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.addCard("Spades", "3");
        game.addCard("Hearts", "K");
        boolean beats = game.cardBeats(0, 1);
        System.out.println(beats);
    }

    public static class Card {

        public static final String VALUE_JOKER = "Joker";
        private static final Map<String, Integer> ORDINAL_MAP = new HashMap<>();
        private String suit;
        private String value;

        static {
            ORDINAL_MAP.put("A", 1);
            for (int i = 2; i < 11; i++) {
                ORDINAL_MAP.put(String.valueOf(i), i);
            }
            ORDINAL_MAP.put("J", 11);
            ORDINAL_MAP.put("Q", 12);
            ORDINAL_MAP.put("K", 13);
        }

        public Card(String suit, String value) {
            this.suit = suit;
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public int getOrdinal() {
            return ORDINAL_MAP.get(value);
        }

        public boolean beats(Card otherCard) {
            if (this.value.equals(VALUE_JOKER)) {
                return !otherCard.getValue().equals(VALUE_JOKER);
            } else {
                return this.getOrdinal() > otherCard.getOrdinal();
            }
        }

        @Override
        public String toString() {
            if (value.equals(VALUE_JOKER)) {
                return suit + " " + value;
            } else {
                return value + " of " + suit;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Card card = (Card) o;
            return Objects.equals(suit, card.suit) && Objects.equals(value, card.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(suit, value);
        }
    }

    public static class Deck extends ArrayList<Card> {}

    public static class Hand extends ArrayList<Integer>{

        private Deck deck;

        public Hand(List<Integer> cardIndices, Deck deck) {
            this.addAll(cardIndices);
            this.deck = deck;
        }

        public boolean beats(Hand otherHand) {
            Collections.sort(this, Collections.reverseOrder());
            Collections.sort(otherHand, Collections.reverseOrder());
            int n = Math.min(this.size(), otherHand.size());
            for (int i = 0; i < n; i++) {
                int thisCardIndex = this.get(i);
                int otherCardIndex = otherHand.get(i);
                if (deck.get(thisCardIndex).beats(deck.get(otherCardIndex))) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public String toString() {
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < this.size(); i++) {
                int cardIndex = get(i);
                s.append(deck.get(cardIndex));
                if (i != this.size()-1) {
                    s.append(", ");
                }
            }
            return s.toString();
        }
    }
}
