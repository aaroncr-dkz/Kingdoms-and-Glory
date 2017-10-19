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
public class GameControlTest {
    
    public GameControlTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of determineTitle method, of class GameControl.
     */
    @Test
    public void testDetermineTitle() {
        System.out.println("determineTitle");
        // Test case 1
        System.out.println("\tTest case 1");
        
        // define the input varibles 
        int charisma = 3;
        int diplomacy = 2;
        int strategy = 1;
        String expResult = "Benevolent"; // define the expected output variable
        
        // call the method
        String result = GameControl.determineTitle(charisma, diplomacy, strategy);
        
        // test to see if the result returned equals the expected result
        assertEquals(expResult, result);
        
             // Test case 2
        System.out.println("\tTest case 2");
        
        // define the input varibles 
        charisma = 0;
        diplomacy = 3;
        strategy = 3;
        expResult = "Balanced"; // define the expected output variable
        
        // call the method
        result = GameControl.determineTitle(charisma, diplomacy, strategy);
        
        // test to see if the result returned equals the expected result
        assertEquals(expResult, result);
        
               // Test case 3
        System.out.println("\tTest case 3");
        
        // define the input varibles 
        charisma = -1;
        diplomacy = 4;
        strategy = 1;
        expResult = "error"; // define the expected output variable
        
        // call the method
        result = GameControl.determineTitle(charisma, diplomacy, strategy);
        
        // test to see if the result returned equals the expected result
        assertEquals(expResult, result);
        
               // Test case 4
        System.out.println("\tTest case 4");
        
        // define the input varibles 
        charisma = 1;
        diplomacy = -2;
        strategy = -3;
        expResult = "error"; // define the expected output variable
        
        // call the method
        result = GameControl.determineTitle(charisma, diplomacy, strategy);
        
        // test to see if the result returned equals the expected result
        assertEquals(expResult, result);
 
               // Test case 5
        System.out.println("\tTest case 5");
        
        // define the input varibles 
        charisma = 2;
        diplomacy = 1;
        strategy = -3;
        expResult = "error"; // define the expected output variable
        
        // call the method
        result = GameControl.determineTitle(charisma, diplomacy, strategy);
        
        // test to see if the result returned equals the expected result
        assertEquals(expResult, result);
        
               // Test case 6
        System.out.println("\tTest case 6");
        
        // define the input varibles 
        charisma = 7;
        diplomacy = -3;
        strategy = -3;
        expResult = "error"; // define the expected output variable
        
        // call the method
        result = GameControl.determineTitle(charisma, diplomacy, strategy);
        
        // test to see if the result returned equals the expected result
        assertEquals(expResult, result);
        
               // Test case 7
        System.out.println("\tTest case 7");
        
        // define the input varibles 
        charisma = 4;
        diplomacy = 8;
        strategy = 2;
        expResult = "error"; // define the expected output variable
        
        // call the method
        result = GameControl.determineTitle(charisma, diplomacy, strategy);
        
        // test to see if the result returned equals the expected result
        assertEquals(expResult, result);
        
               // Test case 8
        System.out.println("\tTest case 8");
        
        // define the input varibles 
        charisma = 3;
        diplomacy = 3;
        strategy = 9;
        expResult = "error"; // define the expected output variable
        
        // call the method
        result = GameControl.determineTitle(charisma, diplomacy, strategy);
        
        // test to see if the result returned equals the expected result
        assertEquals(expResult, result);
        
               // Test case 9
        System.out.println("\tTest case 9");
        
        // define the input varibles 
        charisma = 4;
        diplomacy = 3;
        strategy = 0;
        expResult = "error"; // define the expected output variable
        
        // call the method
        result = GameControl.determineTitle(charisma, diplomacy, strategy);
        
        // test to see if the result returned equals the expected result
        assertEquals(expResult, result);
        
               // Test case 10
        System.out.println("\tTest case 10");
        
        // define the input varibles 
        charisma = 6;
        diplomacy = 0;
        strategy = 0;
        expResult = "Silver Tongued"; // define the expected output variable
        
        // call the method
        result = GameControl.determineTitle(charisma, diplomacy, strategy);
        
        // test to see if the result returned equals the expected result
        assertEquals(expResult, result);
        
               // Test case 11
        System.out.println("\tTest case 11");
        
        // define the input varibles 
        charisma = 0;
        diplomacy = 6;
        strategy = 0;
        expResult = "Peace Walker"; // define the expected output variable
        
        // call the method
        result = GameControl.determineTitle(charisma, diplomacy, strategy);
        
        // test to see if the result returned equals the expected result
        assertEquals(expResult, result);
        
               // Test case 12
        System.out.println("\tTest case 12");
        
        // define the input varibles 
        charisma = 0;
        diplomacy = 0;
        strategy = 6;
        expResult = "Iron Monger"; // define the expected output variable
        
        // call the method
        result = GameControl.determineTitle(charisma, diplomacy, strategy);
        
        // test to see if the result returned equals the expected result
        assertEquals(expResult, result);
        
               // Test case 13
        System.out.println("\tTest case 13");
        
        // define the input varibles 
        charisma = 0;
        diplomacy = 4;
        strategy = 2;
        expResult = "Peace Walker"; // define the expected output variable
        
        // call the method
        result = GameControl.determineTitle(charisma, diplomacy, strategy);
        
        // test to see if the result returned equals the expected result
        assertEquals(expResult, result);
        
               // Test case 14
        System.out.println("\tTest case 14");
        
        // define the input varibles 
        charisma = 3;
        diplomacy = 0;
        strategy = 3;
        expResult = "Justifier"; // define the expected output variable
        
        // call the method
        result = GameControl.determineTitle(charisma, diplomacy, strategy);
        
        // test to see if the result returned equals the expected result
        assertEquals(expResult, result);
        
               // Test case 15
        System.out.println("\tTest case 15");
        
        // define the input varibles 
        charisma = 1;
        diplomacy = 5;
        strategy = 0;
        expResult = "Benevolent"; // define the expected output variable
        
        // call the method
        result = GameControl.determineTitle(charisma, diplomacy, strategy);
        
        // test to see if the result returned equals the expected result
        assertEquals(expResult, result);
    }
    
}
