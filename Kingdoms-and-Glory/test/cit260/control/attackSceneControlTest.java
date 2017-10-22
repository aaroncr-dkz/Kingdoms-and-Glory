/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.control;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bradclegg
 */
public class attackSceneControlTest {
    
    public attackSceneControlTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of determineWinOrLose method, of class attackSceneControl.
     */
    @Test
    public void testDetermineWinOrLose() {
        
        System.out.println("determineWinOrLose");
        
        // Test case 1
        System.out.println("\tTest case 1");
        
        int leaderValue = 3;
        int armyValue = 6;
        int resourceBonus = 1;
        int cityValue = 8;
        int enemyLeaderValue = 1;
        int enemyResourceBonus = 0;
        String expResult = "Win";
        
        String result = attackSceneControl.determineWinOrLose(leaderValue, armyValue, resourceBonus, cityValue, enemyLeaderValue, enemyResourceBonus);
        
        assertEquals(expResult, result);
        
         // Test case 2
        System.out.println("\tTest case 2");
        
        leaderValue = 6;
        armyValue = 3;
        resourceBonus = 1;
        cityValue = 5;
        enemyLeaderValue = 4;
        enemyResourceBonus = 0;
        expResult = "error";
        
        result = attackSceneControl.determineWinOrLose(leaderValue, armyValue, resourceBonus, cityValue, enemyLeaderValue, enemyResourceBonus);
        
        assertEquals(expResult, result);
        
         // Test case 3
        System.out.println("\tTest case 3");
        
        leaderValue = -1;
        armyValue = 3;
        resourceBonus = 1;
        cityValue = 5;
        enemyLeaderValue = -1;
        enemyResourceBonus = 0;
        expResult = "error";
        
        result = attackSceneControl.determineWinOrLose(leaderValue, armyValue, resourceBonus, cityValue, enemyLeaderValue, enemyResourceBonus);
        
        assertEquals(expResult, result);
        
         // Test case 4
        System.out.println("\tTest case 4");
        
        leaderValue = 2;
        armyValue = 11;
        resourceBonus = 1;
        cityValue = 8;
        enemyLeaderValue = 2;
        enemyResourceBonus = 0;
        expResult = "error";
        
        result = attackSceneControl.determineWinOrLose(leaderValue, armyValue, resourceBonus, cityValue, enemyLeaderValue, enemyResourceBonus);
        
        assertEquals(expResult, result);
        
         // Test case 5
        System.out.println("\tTest case 5");
        
        leaderValue = 3;
        armyValue = 10;
        resourceBonus = 1;
        cityValue = 1;
        enemyLeaderValue = 1;
        enemyResourceBonus = 0;
        expResult = "Win";
        
        result = attackSceneControl.determineWinOrLose(leaderValue, armyValue, resourceBonus, cityValue, enemyLeaderValue, enemyResourceBonus);
        
        assertEquals(expResult, result);
        
         // Test case 6
        System.out.println("\tTest case 6");
        
        leaderValue = 1;
        armyValue = 1;
        resourceBonus = 0;
        cityValue = 10;
        enemyLeaderValue = 3;
        enemyResourceBonus = 1;
        expResult = "Lose";
        
        result = attackSceneControl.determineWinOrLose(leaderValue, armyValue, resourceBonus, cityValue, enemyLeaderValue, enemyResourceBonus);
        
        assertEquals(expResult, result);
      
    }
    
    
    
}

    
