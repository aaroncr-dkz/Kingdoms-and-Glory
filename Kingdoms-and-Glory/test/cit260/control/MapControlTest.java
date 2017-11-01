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
public class MapControlTest {
    
    public MapControlTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of determineExploreResult method, of class MapControl.
     */
    @Test
    public void testDetermineExploreResult() {
        System.out.println("determineExploreResult");
        
        // Test case 1
        System.out.println("\tTest case 1");
        
        // define the input varibles 
        int charisma = 3;
        int diplomacy = 2;
        Boolean isGood = true;
        int randAmount = 27;
        int expResult = 33; // define the expected output variable
        
        // call the method
        int result = MapControl.determineExploreResult(charisma, diplomacy, isGood, randAmount);
        
        // test to see if the result returned equals the expected result
        assertEquals(expResult, result);
        
        // Test case 2
        System.out.println("\tTest case 2");
        
        // define the input varibles 
        charisma = -1;
        diplomacy = 4;
        isGood = false;
        randAmount = 33;
        expResult = -100; // define the expected output variable
        
        // call the method
        result = MapControl.determineExploreResult(charisma, diplomacy, isGood, randAmount);
        
        // test to see if the result returned equals the expected result
        assertEquals(expResult, result);
        
        // Test case 3
        System.out.println("\tTest case 3");
        
        // define the input varibles 
        charisma = 5;
        diplomacy = -1;
        isGood = false;
        randAmount = 43;
        expResult = -100; // define the expected output variable
        
        // call the method
        result = MapControl.determineExploreResult(charisma, diplomacy, isGood, randAmount);
        
        // test to see if the result returned equals the expected result
        assertEquals(expResult, result);
        
        // Test case 4
        System.out.println("\tTest case 4");
        
        // define the input varibles 
        charisma = 8;
        diplomacy = 2;
        isGood = true;
        randAmount = 40;
        expResult = -100; // define the expected output variable
        
        // call the method
        result = MapControl.determineExploreResult(charisma, diplomacy, isGood, randAmount);
        
        // test to see if the result returned equals the expected result
        assertEquals(expResult, result);
 
        // Test case 5
        System.out.println("\tTest case 5");
        
        // define the input varibles 
        charisma = 2;
        diplomacy = 8;
        isGood = true;
        randAmount = 40;
        expResult = -100; // define the expected output variable
        
        // call the method
        result = MapControl.determineExploreResult(charisma, diplomacy, isGood, randAmount);
        
        // test to see if the result returned equals the expected result
        assertEquals(expResult, result);
        
        // Test case 6
        System.out.println("\tTest case 6");
        
        // define the input varibles 
        charisma = 4;
        diplomacy = 1;
        isGood = false;
        randAmount = 5;
        expResult = -100; // define the expected output variable
        
        // call the method
        result = MapControl.determineExploreResult(charisma, diplomacy, isGood, randAmount);
        
        // test to see if the result returned equals the expected result
        assertEquals(expResult, result);
        
        // Test case 7
        System.out.println("\tTest case 7");
        
        // define the input varibles 
        charisma = 0;
        diplomacy = 1;
        isGood = true;
        randAmount = 60;
        expResult = -100; // define the expected output variable
        
        // call the method
        result = MapControl.determineExploreResult(charisma, diplomacy, isGood, randAmount);
        
        // test to see if the result returned equals the expected result
        assertEquals(expResult, result);
        
        // Test case 8
        System.out.println("\tTest case 8");
        
        // define the input varibles 
        charisma = 0;
        diplomacy = 6;
        isGood = false;
        randAmount = 37;
        expResult = -19; // define the expected output variable
        
        // call the method
        result = MapControl.determineExploreResult(charisma, diplomacy, isGood, randAmount);
        
        // test to see if the result returned equals the expected result
        assertEquals(expResult, result);
        
        // Test case 9
        System.out.println("\tTest case 9");
        
        // define the input varibles 
        charisma = 6;
        diplomacy = 0;
        isGood = true;
        randAmount = 39;
        expResult = 51; // define the expected output variable
        
        // call the method
        result = MapControl.determineExploreResult(charisma, diplomacy, isGood, randAmount);
        
        // test to see if the result returned equals the expected result
        assertEquals(expResult, result);
        
        // Test case 10
        System.out.println("\tTest case 10");
        
        // define the input varibles 
        charisma = 0;
        diplomacy = 3;
        isGood = true;
        randAmount = 39;
        expResult = 39; // define the expected output variable
        
        // call the method
        result = MapControl.determineExploreResult(charisma, diplomacy, isGood, randAmount);
        
        // test to see if the result returned equals the expected result
        assertEquals(expResult, result);
        
        // Test case 11
        System.out.println("\tTest case 11");
        
        // define the input varibles 
        charisma = 3;
        diplomacy = 0;
        isGood = false;
        randAmount = 29;
        expResult = -29; // define the expected output variable
        
        // call the method
        result = MapControl.determineExploreResult(charisma, diplomacy, isGood, randAmount);
        
        // test to see if the result returned equals the expected result
        assertEquals(expResult, result);
        
       // Test case 12
        System.out.println("\tTest case 12");
        
        // define the input varibles 
        charisma = 1;
        diplomacy = 1;
        isGood = false;
        randAmount = 20;
        expResult = -17; // define the expected output variable
        
        // call the method
        result = MapControl.determineExploreResult(charisma, diplomacy, isGood, randAmount);
        
        // test to see if the result returned equals the expected result
        assertEquals(expResult, result);
        
        // Test case 13
        System.out.println("\tTest case 13");
        
        // define the input varibles 
        charisma = 2;
        diplomacy = 2;
        isGood = false;
        randAmount = 50;
        expResult = -44; // define the expected output variable
        
        // call the method
        result = MapControl.determineExploreResult(charisma, diplomacy, isGood, randAmount);
        
        // test to see if the result returned equals the expected result
        assertEquals(expResult, result);          
    }

    /**
     * Test of determineWinOrLose method, of class MapControl.
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
        
        String result = MapControl.determineWinOrLose(leaderValue, armyValue, resourceBonus, cityValue, enemyLeaderValue, enemyResourceBonus);
        
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
        
        result = MapControl.determineWinOrLose(leaderValue, armyValue, resourceBonus, cityValue, enemyLeaderValue, enemyResourceBonus);
        
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
        
        result = MapControl.determineWinOrLose(leaderValue, armyValue, resourceBonus, cityValue, enemyLeaderValue, enemyResourceBonus);
        
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
        
        result = MapControl.determineWinOrLose(leaderValue, armyValue, resourceBonus, cityValue, enemyLeaderValue, enemyResourceBonus);
        
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
        
        result = MapControl.determineWinOrLose(leaderValue, armyValue, resourceBonus, cityValue, enemyLeaderValue, enemyResourceBonus);
        
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
        
        result = MapControl.determineWinOrLose(leaderValue, armyValue, resourceBonus, cityValue, enemyLeaderValue, enemyResourceBonus);
        
        assertEquals(expResult, result);
    }
}

