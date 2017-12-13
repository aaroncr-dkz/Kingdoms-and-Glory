/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.view;

import cit260.control.MapControl;
import cit260.exception.MapControlException;
import cit260.model.Actor;
import cit260.model.PlayerActor;
import kingdoms.and.glory.KingdomsAndGlory;

/**
 *
 * @author bradclegg
 */
public class MoveActorView extends View {
    
    public MoveActorView() {
        
    }
    
     @Override
    public String[] getInputs() {

        String[] inputs = new String[1];
        // display menu
        this.console.println("\nW - Move Upwards");
        this.console.println("A - Move Left");
        this.console.println("S - Move Down");
        this.console.println("D - Move Right");
        this.console.println("B - Go back");
        
        inputs[0] = this.getInput("Select item from menu by entering the appropriate letter: ");
        return inputs;
    }
    
    
    @Override
    public Boolean doAction(String[] inputs) {

        String command = inputs[0].toUpperCase();

        switch (command) {
            case "W":
                getMoveCoordinates(-1, 0);
                return true;
            case "A":
                getMoveCoordinates(0, -1);
                return true;
            case "S":
                getMoveCoordinates(1, 0);
                return true;
            case "D":
                getMoveCoordinates(0, 1);
                return true;
            case "B":
                return true;
        }
        return false;
    }
    
    public void getMoveCoordinates(int deltaRow, int deltaColumn) {
        int currentRow = MapControl.acquirePlayerCurrentRow();
        int currentColumn = MapControl.acquirePlayerCurrentColumn();
        
        int newRow = currentRow + deltaRow;
        int newColumn = currentColumn + deltaColumn;
        PlayerActor player = KingdomsAndGlory.getPlayer().getPlayerCharacter();
        
        try {
            String resultString = MapControl.movePlayerActor(player, newRow, newColumn, false);
            this.console.println(resultString);
        }
        catch(MapControlException e) {
            ErrorView.display(this.getClass().getName(), e.getMessage());
        }
    }
}
