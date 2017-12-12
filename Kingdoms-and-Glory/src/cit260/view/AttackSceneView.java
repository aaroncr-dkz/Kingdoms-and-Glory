/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.view;

import cit260.control.MapControl;
import cit260.exception.MapControlException;
import cit260.model.Actor;
import cit260.model.AttackScene;
import cit260.model.Player;
import cit260.model.Territory;
import kingdoms.and.glory.KingdomsAndGlory;

/**
 *
 * @author bradclegg
 */
public class AttackSceneView extends View{
    
    public AttackSceneView() {
        
    }

    @Override
    public String[] getInputs() {

        String[] inputs = new String[1];
        // display menu
        this.console.println("\nA - Do you want to attack?");
        this.console.println("B - Go back");
        
        inputs[0] = this.getInput("Select item from menu by entering the appropriate letter: ");
        return inputs;
    }

    @Override
    public Boolean doAction(String[] inputs) {

        String command = inputs[0].toUpperCase();

        switch (command) {
            case "A":
                attack();
                return true;
            case "B":
                return true;
        }
        return false;
    }

    private void attack() {
        
        // create some method variables
        int[] inputs = {-1, -1};
        String command;
        
        // acquire the player's current row and column
        int playerRow = MapControl.acquirePlayerCurrentRow();
        int playerCol = MapControl.acquirePlayerCurrentColumn();
        
        // acquire the two-dimensional array of territories
        Territory[][] territories = MapControl.acquireGameTerritories();
        
        
        // get the row number for the territory
        while((inputs[0] < 0 || inputs[0] > 4) 
           || (inputs[0] < (playerRow - 1) || inputs[0] > (playerRow + 1))) {
            command = this.getInput("\nEnter the row number for the territory you wish to attack: ");
            
            try {
                inputs[0] = (Integer.parseInt(command) - 1);
            }
            catch (NumberFormatException nfe) {
                ErrorView.display(this.getClass().getName(), "Value entered was not an integer");
            }
            
            // check if the row entered is within the map size
            if(inputs[0] < 0 || inputs[0] > 4) {
                this.console.println("\nThat value is outside the allowed range. Pick a number between 1 and 5");
            }
            
            // check to see if the user entered column they are on or adjacent to
            else if(inputs[0] < (playerRow - 1) || inputs[0] > (playerRow + 1)) {
                this.console.println("\nThat territory is not adjacent to you currently. Please pick an adjacent territory.");
                this.console.println("Current Location: " + (playerRow + 1) + ":" + (playerCol + 1));
            }
        }
        
        // get the column number for the territory
        while((inputs[1] < 0 || inputs[1] > 4) 
           || (inputs[1] < (playerCol - 1) || inputs[1] > (playerCol + 1))) {
            command = this.getInput("\nEnter the column number for the territory you wish to attack: ");
            
            try {
                inputs[1] = (Integer.parseInt(command) - 1);
            }
            catch (NumberFormatException nfe) {
                ErrorView.display(this.getClass().getName(), "Value entered was not an integer");
            }
            
            // check if the column entered is within the map size
            if(inputs[1] < 0 || inputs[1] > 4) {
                this.console.println("\nThat value is outside the allowed range. Pick a number between 1 and 5");
            }
            
            // check to see if the user entered column they are on or adjacent to
            else if(inputs[1] < (playerCol - 1) || inputs[1] > (playerCol + 1)) {
                this.console.println("\nThat territory is not adjacent to you currently. Please pick an adjacent territory.");
                this.console.println("Current Location: " + (playerRow + 1) + ":" + (playerCol + 1));
            }
        }
        
        
        AttackScene attackScene = new AttackScene();
        attackScene.setEnemyStrength(1);
        int enemyValue = attackScene.getEnemyStrength();
        

        Player player = new Player();
        player.setLeaderValue(2);  
        int leaderValue = player.getLeaderValue();
        Actor actor = KingdomsAndGlory.getPlayer().getPlayerCharacter();
        
        if(MapControl.determineWinOrLose(leaderValue, enemyValue).equals(true))
        {
            try {
                MapControl.movePlayerActor(actor, inputs[0], inputs[1], true);
            }
            catch (MapControlException mce) {
                ErrorView.display(this.getClass().getName(), mce.getMessage());
            }
            AttackSceneResultView attackSceneResultView = new AttackSceneResultView();
            attackSceneResultView.display();
        }
        else {
            this.console.println("Sorry, better luck next time");
        }
    }
}
