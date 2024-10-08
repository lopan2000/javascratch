package interview.deckofcards.other;

import java.util.ArrayList;
import java.util.Random;

public class DesignDeckOfCards {
    public static void main(String[] args) {
        Deck deck = new Deck();
        //System.out.println(deck);
        /*
        Card card = deck.drawCard();
        for (int i = 0; i < 10; i++) {
            Card currCard = deck.drawCard();
            System.out.println(currCard);
            System.out.println(card.beats(currCard));
        }
        */
        deck.shuffle();
        System.out.println(deck);
    }
}

enum Rank {
    ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5),
    SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10),
    JACK(11), QUEEN(12), KING(13);

    private final int value;

    Rank(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
enum Suit {
    HEART, DIAMOND, SPADE, CLUB
}

class Deck extends ArrayList<Card> {

    Random rand = new Random();

    public Deck() {
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                add(new Card(rank, suit));
            }
        }
    }
    public Card drawCard() {
        return remove(size()-1);
    }

    /**
     * Knuth-Fisher-Yates shuffle
     *
     * ex) [a,b,c]
     * i = 2
     * j = rand(3) -> 0..2
     *
     * i = 1
     * j = rand(2) -> 0..1
     */
    public void shuffle() {
        //Collections.shuffle(this);
        for (int i = size()-1; i > 0; i--) {
            int j = rand.nextInt(i+1); //(TODO) why i+1?
            swap(i, j);
        }

    }
    private void swap(int i, int j) {
        Card tempI = get(i);
        set(i, get(j));
        set(j, tempI);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Card card : this) {
            s.append(card).append("\n");
        }
        return s.toString();
    }
}

class Card {
    private Rank rank;
    private Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }
    public Suit getSuit() {
        return suit;
    }
    public boolean beats(Card aCard) {
        if (aCard == null) {
            throw new IllegalArgumentException("passed a null card");
        }
        return this.rank.getValue() > aCard.rank.getValue();
    }
    @Override
    public String toString() {
        return rank.name() + " of " + suit.name();
    }
}