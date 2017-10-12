/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrownAndAnchor;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ryan Smith
 */
public class Bug3Replication {

    public Bug3Replication() {
    }

    /**
     * Test of main method, of class Main.
     */
    @Test
    public void testBug3() throws Exception {
        System.out.println("Bug 3");
        Dice d1 = new Dice();
        Dice d2 = new Dice();
        Dice d3 = new Dice();

        Player player = new Player("Fred", 100);
        Game game = new Game(d1, d2, d3);

        int totalWins = 0;
        int totalLosses = 0;

        for (int h = 0; h < 10; h++) {
            int winCount = 0;
            int loseCount = 0;

            for (int i = 0; i < 1000; i++) {
                String name = "Fred";
                int balance = 100;
                int limit = 0;
                player = new Player(name, balance);
                player.setLimit(limit);
                int bet = 5;

                System.out.println(String.format("Start Game %d: ", i));
                //System.out.println(String.format("%s starts with balance %d, limit %d", 
                //player.getName(), player.getBalance(), player.getLimit()));

                int turn = 0;
                while (player.balanceExceedsLimitBy(bet) && player.getBalance() < 200) {
                    turn++;
                    DiceValue pick = DiceValue.getRandom();

                    //System.out.printf("Turn %d: %s bet %d on %s\n",
                    //turn, player.getName(), bet, pick); 
                    int winnings = game.playRound(player, pick, bet);

                    //System.out.printf("Rolled %s, %s, %s\n",
                            //cdv.get(0), cdv.get(1), cdv.get(2));

                    if (winnings > 0) {
                        //System.out.printf("%s won %d, balance now %d\n\n",
                                //player.getName(), winnings, player.getBalance());
                        winCount++;
                    } else {
                        //System.out.printf("%s lost, balance now %d\n\n",
                                //player.getName(), player.getBalance());
                        loseCount++;
                    }

                } //while

                System.out.print(String.format("%d turns later.\nEnd Game %d: ", turn, i));
                System.out.println(String.format("%s now has balance %d\n", player.getName(), player.getBalance()));

            } //for

            System.out.println(String.format("Win count = %d, Lose Count = %d, %.2f", winCount, loseCount, (float) winCount / (winCount + loseCount)));
            totalWins += winCount;
            totalLosses += loseCount;

            assertEquals(0.4213, (float) winCount / (winCount + loseCount), 0.005);
        } //while true

        
    }
}


