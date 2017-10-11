/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit_test;



import CrownAndAnchor.Player;
import CrownAndAnchor.Game;
import CrownAndAnchor.DiceValue;
import CrownAndAnchor.Dice;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author Ryan Smith
 */
public class GameTest {
    
    public GameTest() {
    }
    
    /**
     * Test of playRound method, of class Game.
     */
    @Test
    public void testPlayRound() {
        System.out.println("playRound");
        Player player = new Player("John", 100);
        DiceValue pick = DiceValue.HEART;
        
        Dice d1 = mock(Dice.class);
        when(d1.getValue()).thenReturn(DiceValue.HEART);
        
        Dice d2 = mock(Dice.class);
        when(d2.getValue()).thenReturn(DiceValue.ANCHOR);
        
        Dice d3 = mock(Dice.class);
        when(d3.getValue()).thenReturn(DiceValue.CROWN);
        
        Game instance = new Game(d1, d2, d3);
        
        int bet = 5;
        
        int expResult = 105;
        System.out.println(String.format("%s starts with balance %d, limit %d", 
                		player.getName(), player.getBalance(), player.getLimit()));
        System.out.printf("%s bet %d on %s\n", player.getName(), bet, pick); 
        
        int result = instance.playRound(player, pick, bet);
        
        
        List<DiceValue>cdv =instance.getDiceValues();
        System.out.printf("Rolled %s, %s, %s\n",
                    		cdv.get(0), cdv.get(1), cdv.get(2));
        
        if (result > 0) {
	                    System.out.printf("%s won %d, balance now %d\n\n",
	                    		player.getName(), result, player.getBalance()); 
                    }
                    else {
	                    System.out.printf("%s lost, balance now %d\n\n",
	                    		player.getName(), player.getBalance());
                    }
                    
        assertEquals(bet, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
