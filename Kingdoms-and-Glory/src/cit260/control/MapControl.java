/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.control;

import cit260.model.Map;
import cit260.model.Territory;

/**
 *
 * @author aaroncr-dkz
 */
public class MapControl {

    public static Map createMap(int numOfRows, int numOfColumns) {
        if (numOfRows < 0 || numOfColumns < 0) {
            return null;
        }
        
        Map map = new Map();
        //save rows
        //save columns
        
        Territory[][] locations = createLocations(numOfRows, numOfColumns);
        map.setMap(locations);
        return map;
    }
    
    // create all the territories in the game
    private static Territory[][] createLocations(int numOfRows, int numOfColumns) {
        if (numOfRows < 0 || numOfColumns < 0) {
            return null;
        }
        
        Territory[][] locations = new Territory[numOfRows][numOfColumns];
        for (int i = 0; i < numOfRows; i++) {
            for (int j = 0; j <numOfColumns; j++) {
                Territory location = new Territory(i, j);
                locations[i][j] = location;
            }
        }
        return locations;
    }
    
    public static int determineExploreResult(int charisma, int diplomacy, Boolean isGood, int randAmount) {

        if (charisma < 0 || diplomacy < 0) {
            return -100;
        } 
        else if (charisma > 6 || diplomacy > 6) {
            return -100;
        } 
        else if (randAmount < 20 || randAmount > 50) {
            return -100;
        }

        int finalAmount = 0;

        if (isGood) {
            finalAmount = randAmount + (charisma * 2);
        } 
        else {
            finalAmount = (randAmount * -1) + (diplomacy * 3);
        }

        return finalAmount;
    }
    
    public static String determineWinOrLose(int leaderValue, int armyValue, int resourceBonus, int cityValue, int enemyLeaderValue, int enemyResourceBonus) {
        
        if (leaderValue > 5 || leaderValue < 1) {

            return "error";
        }
        else if (armyValue > 10 || armyValue < 1) {
	
            return "error";
        }

        else if (resourceBonus > 1 || resourceBonus < 0) {
            
            return "error";
        }   

        else if (cityValue > 10 || cityValue < 1) {
	
            return "error";
        }
        

        else if (enemyLeaderValue > 5 || enemyLeaderValue < 1) {

            return "error";
        
        }
        
        int attackValue = (leaderValue + armyValue) + (resourceBonus); 
        int cityDefenseValue = (cityValue + enemyLeaderValue) + (enemyResourceBonus);

        if (attackValue > cityDefenseValue) {
            
            return "Win";
        }
        else {

            return "Lose";
        }
    }

   
}
