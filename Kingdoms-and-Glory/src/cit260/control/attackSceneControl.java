/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.control;

/**
 *
 * @author bradclegg
 */
public class attackSceneControl {
    
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
