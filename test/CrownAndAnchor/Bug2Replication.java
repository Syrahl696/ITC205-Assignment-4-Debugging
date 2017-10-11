/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrownAndAnchor;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

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
        System.out.println("playRound");
        Player player = null;
        DiceValue pick = null;
        int bet = 0;
        Game instance = null;
        int expResult = 0;
        int result = instance.playRound(player, pick, bet);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
