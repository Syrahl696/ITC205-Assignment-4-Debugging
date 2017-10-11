/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrownAndAnchor;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author Ryan Smith
 */
public class Bug2Replication {

    public Bug2Replication() {
    }

    /**
     * Test of playRound method, of class Game.
     */
    @Test
    public void testPlayRound() {
        System.out.println("Bug 2");
        int balance = 100;
        int expBalance = 0;
        int bet = 5;
        //Create a player and set his choice
        Player player = new Player("John", balance);
        System.out.printf("%s's balance is %d\n\n",
                    player.getName(), player.getBalance());
        DiceValue pick = DiceValue.SPADE;

        //Initialise mock dice that always give a predetermined result
        Dice d1 = mock(Dice.class);
        when(d1.getValue()).thenReturn(DiceValue.HEART);

        Dice d2 = mock(Dice.class);
        when(d2.getValue()).thenReturn(DiceValue.CROWN);

        Dice d3 = mock(Dice.class);
        when(d3.getValue()).thenReturn(DiceValue.ANCHOR);

        Game instance = new Game(d1, d2, d3);

        while (player.balanceExceedsLimitBy(bet) && player.getBalance() < 200) {
            System.out.printf("%s bet %d on %s\n",
                    player.getName(), bet, pick);

            System.out.printf("Rolled %s, %s, %s\n",
                    d1.getValue(), d2.getValue(), d3.getValue());

            int result = instance.playRound(player, pick, bet);

            if (result > 0) {
                System.out.printf("%s won %d, balance now %d\n\n",
                        player.getName(), result, player.getBalance());
            } else {
                System.out.printf("%s lost, balance now %d\n\n",
                        player.getName(), player.getBalance());
            }
        }
        System.out.println(String.format("%s now has balance %d\n", player.getName(), player.getBalance()));
        assertEquals(expBalance, player.getBalance());
    }

}
