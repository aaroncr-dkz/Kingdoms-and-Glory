/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.view;

import cit260.model.DefaultScene;
import cit260.model.Map;
import cit260.model.SceneArrayEnum;
import cit260.model.Territory;
import kingdoms.and.glory.KingdomsAndGlory;

/**
 *
 * @author bradclegg
 */
public class MapTerritoryView extends View {

    public MapTerritoryView() {

    }

    @Override
    public String[] getInputs() {

        String[] inputs = new String[1];

        // display menu
        System.out.println("\nE - Examine Territory");
        System.out.println("B - Go Back");

        inputs[0] = this.getInput("Select an item from the menu by entering the appropriate letter: ");
        return inputs;
    }

    @Override
    public Boolean doAction(String[] inputs) {
        String command = inputs[0].toUpperCase();

        switch (command) {
            case "E":
                examine();
                break;
            case "B":
                return true;
        }
        return false;
    }
    
    private void examine() {
        int[] inputs = {-1, -1};
        String command;
        int playerRow = KingdomsAndGlory.getPlayer().getPlayerCharacter().getLocation().getRow();
        int playerCol = KingdomsAndGlory.getPlayer().getPlayerCharacter().getLocation().getColumn();
        Territory[][] territories = KingdomsAndGlory.getCurrentGame().getMap().getTerritories();
        
        // get the row number for the territory
        while((inputs[0] < 0 || inputs[0] > 4) 
           || (inputs[0] < (playerRow - 1) || inputs[0] > (playerRow + 1))) {
            command = this.getInput("\nEnter the row number for the territory you wish to examine: ");
            inputs[0] = (Integer.parseInt(command) - 1);
            
            if(inputs[0] < 0 || inputs[0] > 4) {
                System.out.println("\nThat value is outside the allowed range. Pick a number between 1 and 5");
            }
            
            else if(inputs[0] < (playerRow - 1) || inputs[0] > (playerRow + 1)) {
                System.out.println("\nThat territory is not adjacent to you currently. Please pick an adjacent territory.");
                System.out.println("Current Location: " + (playerRow + 1) + ":" + (playerCol + 1));
            }
        }
        
        // get the column number for the territory
        while((inputs[1] < 0 || inputs[1] > 4) 
           || (inputs[1] < (playerCol - 1) || inputs[1] > (playerCol + 1))) {
            command = this.getInput("\nEnter the column number for the territory you wish to examine: ");
            inputs[1] = (Integer.parseInt(command) - 1);
            
            if(inputs[1] < 0 || inputs[1] > 4) {
                System.out.println("\nThat value is outside the allowed range. Pick a number between 1 and 5");
            }
            
            else if(inputs[1] < (playerCol - 1) || inputs[1] > (playerCol + 1)) {
                System.out.println("\nThat territory is not adjacent to you currently. Please pick an adjacent territory.");
                System.out.println("Current Location: " + (playerRow + 1) + ":" + (playerCol + 1));
            }
        }
        
        Territory locationToExamine = territories[inputs[0]][inputs[1]];
        DefaultScene[] locationScenes = locationToExamine.getScenes();
        
        String description;
        if(locationScenes[SceneArrayEnum.CapturedScene.ordinal()] != null) {
            if(locationToExamine.getVisited()) {
                description = locationScenes[SceneArrayEnum.CapturedScene.ordinal()].getDescription();
                System.out.println(description);
            }
            else {
                description = locationScenes[SceneArrayEnum.ExamineScene.ordinal()].getDescription();
                System.out.println(description);
            }
        }
        else {
            description = locationScenes[SceneArrayEnum.ExamineScene.ordinal()].getDescription();
            System.out.println(description);
        }
        
    }
}
