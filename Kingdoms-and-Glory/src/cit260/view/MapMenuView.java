/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.view;

import cit260.control.MapControl;
import cit260.model.DefaultScene;
import cit260.model.Map;
import cit260.model.SceneArrayEnum;
import cit260.model.Territory;
import kingdoms.and.glory.KingdomsAndGlory;

/**
 *
 * @author bradclegg
 */
public class MapMenuView extends View {

    public MapMenuView() {

    }

    @Override
    public String[] getInputs() {

        String[] inputs = new String[1];

        // display map
        System.out.println("              Zenobia");
        System.out.println("===================================");
        System.out.println("*      1     2     3     4     5  *");
        System.out.println("*   ------------------------------*");

        int i;
        Map map = KingdomsAndGlory.getCurrentGame().getMap();
        Territory[][] territories = map.getTerritories();

        for (i = 0; i < territories.length; i++) {
            System.out.print("* " + (i + 1) + " ");

            for (int j = 0; j < territories[i].length; j++) {
                System.out.print("|");
                if (territories[i][j].getVisited()) {
                    System.out.print(" " + territories[i][j].getSymbol() + " ");
                } else {
                    System.out.print(" ??? ");
                }
            }
            System.out.print("*\n");

            if (i < 4) {
                System.out.print("*   |-----|-----|-----|-----|-----*\n");
            }

        }
        System.out.print("*   ------------------------------*\n");
        System.out.print("===================================\n");

        // display menu     
        System.out.println("\nV - View Territtory");
        System.out.println("C - Attack Territory");
        System.out.println("X - Move");
        System.out.println("B - Go Back");

        inputs[0] = this.getInput("Select item from menu by entering the appropriate letter: ");
        return inputs;
    }

    @Override
    public Boolean doAction(String[] inputs) {
        String command = inputs[0].toUpperCase();

        switch (command) {
            case "V":
                examine();
                break;
            case "C":
                System.out.println("You are attacking a territory");
                break;
            case "X":
                MoveActorView moveActorView = new MoveActorView();
                moveActorView.display();
                break;
            case "B":
                return true;
        }
        return false;
    }
    
    private void examine() {
        
        // create some method variables
        int[] inputs = {-1, -1};
        String command;
        
        // acquire the player's current row and column
        int playerRow = MapControl.acquirePlayerCurrentRow();
        int playerCol = MapControl.acquirePlayerCurrentColumn();
        
        // acquie the two-dimensional array of territories
        Territory[][] territories = MapControl.acquireGameTerritories();
        
        
        // get the row number for the territory
        while((inputs[0] < 0 || inputs[0] > 4) 
           || (inputs[0] < (playerRow - 1) || inputs[0] > (playerRow + 1))) {
            command = this.getInput("\nEnter the row number for the territory you wish to examine: ");
            
            try {
                inputs[0] = (Integer.parseInt(command) - 1);
            }
            catch (NumberFormatException nfe) {
                System.out.println("Value entered was not an integer");
            }
            
            
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
            
            try {
                inputs[1] = (Integer.parseInt(command) - 1);
            }
            catch (NumberFormatException nfe) {
                System.out.println("Value entered was not an integer");
            }
            
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
                //int opposition = locationScenes[SceneArrayEnum.ExamineScene.ordinal()].getEstimatedOpposition();
                System.out.println("\n"
                             + "================================================\n"
                             + "* " + description + "\n"
                             + "* \n"
                             + "* Estimated Oppisition: \n"
                             + "*     ");
            }
        }
        else {
            description = locationScenes[SceneArrayEnum.ExamineScene.ordinal()].getDescription();
            System.out.println("\n"
                             + "================================================\n"
                             + "* " + description + "\n"
                             + "* \n"
                             + "*");
        }
    }
}
