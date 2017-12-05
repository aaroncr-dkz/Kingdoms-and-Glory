/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.view;

import cit260.control.MapControl;
import cit260.exception.MapControlException;
import cit260.model.Actor;
import cit260.model.DefaultScene;
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
        System.out.println("\nW - Move Upwards");
        System.out.println("A - Move Left");
        System.out.println("S - Move Down");
        System.out.println("D - Move Right");
        System.out.println("B - Go back");
        
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
        Actor player = KingdomsAndGlory.getPlayer().getPlayerCharacter();
        
        try {
            DefaultScene scene = MapControl.movePlayerActor(player, newRow, newColumn);
        }
        catch(MapControlException e) {
            System.out.println(e.getMessage());
        }
    }
}
