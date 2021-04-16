package LINTCODE8;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE714 {
    /*Description
    *Every player has 1000 casino token to start
    * The dealer has10000 casino token
    * If the player wins，that one get double token
    * If the dealer wins，deal will take the token from player
    * If the points are the same, then the dealer wins
    * A could be considered as 1 or 11
    * */

    public class BlackJack {

        private List<NormalPlayer> players;
        private Dealer dealer;

        private List<Card> cards;

        public BlackJack() {
            players = new ArrayList<>();
            dealer = new Dealer();
        }

        public void initCards(List<Card> cards){
            this.cards=cards;
        }

        public void addPlayer(NormalPlayer p) {
            players.add(p);
            // write your code here
        }

        public void dealInitialCards() {
            for(NormalPlayer player:players){
                player.insertCard(dealNextCard());
            }
            dealer.insertCard(dealNextCard());

            for(NormalPlayer player:players){
                player.insertCard(dealNextCard());
            }

            dealer.insertCard(dealNextCard());
            // write your code here
        }

        public Card dealNextCard() {
            Card next= cards.remove(0);
            return next;
            // write your code here
        }

        public void compareResult() {
            for(NormalPlayer player:players){
                if(dealer.largerThan(player)){
                    dealer.updateBets(player.getBets());
                    player.lose();
                }else{
                    dealer.updateBets(-player.getBets());
                    player.win();
                }
            }

        }

        public String print() {
            String s = "";
            for (NormalPlayer player : players) {
                s += "playerid: " + (player.getId() + 1) + " ;" + player.printPlayer();
            }
            return s;
        }


        // getter and setter
        public List<NormalPlayer> getPlayers() {
            return players;
        }

        public void setPlayers(List<NormalPlayer> players) {
            this.players = players;
        }

        public Dealer getDealer() {
            return dealer;
        }

        public void setDealer(Dealer dealer) {
            this.dealer = dealer;
        }

        public List<Card> getCards() {
            return cards;
        }

        public void setCards(List<Card> cards) {
            this.cards = cards;
        }

    }

    class NormalPlayer {
        private BlackJack game;
        private int id;
        private Hand hand;
        private int totalBets;
        private int bets;
        private boolean stopDealing;

        public void insertCard(Card card) {
            hand.insertCard(card);
            //
        }

        public int getBestValue() {
            return hand.getBestValue();
            //
        }

        public NormalPlayer(int id, int bets) {
            this.id = id;
            hand = new Hand();
            totalBets = 1000;
            try {
                placeBets(bets);
            } catch (Exception e) {
                e.printStackTrace();
            }
            stopDealing = false;
        }

        public String printPlayer() {
            return hand.printHand() + ", current bets: " + bets + ", total bets: " + totalBets + "\n";
        }

        // getter and setter
        public BlackJack getGame() {
            return game;
        }

        public void setGame(BlackJack game) {
            this.game = game;
        }

        public int getId() {
            return this.id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Hand getHand() {
            return hand;
        }

        public void placeBets(int amount) throws Exception {
            if (totalBets < amount) {
                throw new Exception("No enough money.");
            }
            bets = amount;
            totalBets -= bets;
        }

        public void setHand(Hand hand) {
            this.hand = hand;
        }

        public int getTotalBets() {
            return totalBets;
        }

        public void setTotalBets(int totalBets) {
            this.totalBets = totalBets;
        }

        public int getBets() {
            return bets;
        }

        public void setBets(int bets) {
            this.bets = bets;
        }

        public boolean isStopDealing() {
            return stopDealing;
        }

        public void setStopDealing(boolean stopDealing) {
            this.stopDealing = stopDealing;
        }

        public void win() {
            totalBets += (bets * 2);
            bets = 0;
        }

        public void lose() {
            bets = 0;
        }

    }

    class Hand {
        private List<Card> cards;

        public void setCards(List<Card> cards) {
            this.cards = cards;
        }

        public List<Card> getCards() {
            return cards;
        }

        public Hand() {
            cards = new ArrayList<>();
        }

        // Get a list of possible results from hand
        private List<Integer> getPossibleValues() {
            List<Integer> result=new ArrayList<>();
            int sum=0;
            boolean hasAce=false;
            for(Card cur:cards){
                int curVal=cur.getValue();
                if(curVal>=10)
                    sum+=10;
                else
                    sum+=curVal;
                if(curVal==1)
                    hasAce=true;
            }
            result.add(sum);
            if(hasAce)
                result.add(sum+10);
            return result;
            // write your code here
        }

        public String printHand() {
            String res = "Cards: ";
            for (int i = 0; i < cards.size(); i++){
                res += (cards.get(i).getValue());
                if(i != cards.size() - 1){
                    res+=" , ";
                }
                else res+=';';
            }

            res += " Current best value is: " + getBestValue();
            return res;
        }

        // -1 means went over 21, otherwise means the best value of this hand
        public int getBestValue() {
            int max=0;
            for(int cur:getPossibleValues()){
                if(cur<=21)
                    max=Math.max(cur,max);
            }
            return max;
        }

        public void insertCard(Card card) {
            this.cards.add(card);
        }
    }

    class Dealer {
        private BlackJack game;
        private Hand hand;
        private int bets;

        public Dealer() {
            hand = new Hand();
            bets = 10000;
        }

        // getter and setter
        public void insertCard(Card card) {
            hand.insertCard(card);
        }

        public boolean largerThan(NormalPlayer p) {
            return hand.getBestValue() >= p.getBestValue();
        }

        public void updateBets(int amount) {
            bets += amount;
        }

        public void setGame(BlackJack game) {
            this.game = game;
        }

        public String printDealer() {
            return "Dealer " + hand.printHand() + ", total bets: " + bets + "\n";
        }

        public void dealNextCard() {
            insertCard(game.dealNextCard());
        }

        public BlackJack getGame() {
            return game;
        }

        public Hand getHand() {
            return hand;
        }

        public void setHand(Hand hand) {
            this.hand = hand;
        }

        public int getBets() {
            return bets;
        }

        public void setBets(int bets) {
            this.bets = bets;
        }
    }

    class Card {
        private int value;

        public Card(int value) {
            this.value = value;
        }

        // getter and setter
        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
