/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.view;

import cit260.control.MapControl;
import cit260.model.Actor;
import cit260.model.ActorEnum;
import cit260.model.AttackScene;
import cit260.model.Map;
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
        this.console.println("              Zenobia");
        this.console.println("===================================");
        this.console.println("*      1     2     3     4     5  *");
        this.console.println("*   ------------------------------*");

        int i;
        Map map = KingdomsAndGlory.getCurrentGame().getMap();
        Territory[][] territories = map.getTerritories();

        for (i = 0; i < territories.length; i++) {
            this.console.print("* " + (i + 1) + " ");

            for (int j = 0; j < territories[i].length; j++) {
                this.console.print("|");
                if (territories[i][j].getVisited()) {
                    this.console.print(" " + territories[i][j].getSymbol() + " ");
                } else {
                    this.console.print(" ??? ");
                }
            }
            this.console.print("*\n");

            if (i < 4) {
                this.console.print("*   |-----|-----|-----|-----|-----*\n");
            }

        }
        this.console.print("*   ------------------------------*\n");
        this.console.print("===================================\n");
        
        // acquire the player's current row and column
        int playerRow = MapControl.acquirePlayerCurrentRow();
        int playerCol = MapControl.acquirePlayerCurrentColumn();
        
        String currLocSymb = territories[playerRow][playerCol].getSymbol();
        String currLocName = territories[playerRow][playerCol].getName();
        
        this.console.println("Current Location: " + currLocName + " ("+ currLocSymb + ")");

        // display menu     
        this.console.println("\nV - View Territtory");
        this.console.println("C - Attack Territory");
        this.console.println("X - Move");
        this.console.println("B - Go Back");

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
                AttackSceneView attackSceneView = new AttackSceneView();
                attackSceneView.display();
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
        
        // acquire the two-dimensional array of territories
        Territory[][] territories = MapControl.acquireGameTerritories();
        
        
        // get the row number for the territory
        while((inputs[0] < 0 || inputs[0] > 4) 
           || (inputs[0] < (playerRow - 1) || inputs[0] > (playerRow + 1))) {
            command = this.getInput("\nEnter the row number for the territory you wish to examine: ");
            
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
            command = this.getInput("\nEnter the column number for the territory you wish to examine: ");
            
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
        
        Territory locationToExamine = territories[inputs[0]][inputs[1]];
        
        
        String description;
        
        if(locationToExamine.getSceneExamineCity() != null) {
            if(locationToExamine.getVisited()) {
                description = locationToExamine.getSceneCaptured().getDescription();
                this.console.println(description);
            }
            else {
                description = locationToExamine.getSceneExamineCity().getDescription();
                int opposition = locationToExamine.getSceneExamineCity().getEstimatedOpposition();
                this.console.println("\n"
                             + "================================================\n"
                             + "* " + description + " *\n"
                             + "*                                              *\n"
                             + "* Estimated Oppisition: " + opposition + "                     *\n"
                             + "================================================\n");
            }
        }
        else {
            description = locationToExamine.getSceneExamineWilderness().getDescription();
            this.console.println("\n"
                             + "================================================\n"
                             + "* " + description + "*\n"
                             + "* \n"
                             + "* \n"
                             + "================================================\n");
        }
        
    }
}

