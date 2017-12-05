/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.view;

import cit260.model.Game;
import cit260.model.Map;
import cit260.model.Territory;
import kingdoms.and.glory.KingdomsAndGlory;

/**
 *
 * @author bradclegg
 */
public class GameMenuView extends View {
    
    public GameMenuView() {
        
    }

    @Override
    public String[] getInputs() {
        String[] inputs = new String[1];
        
        // display menu
        this.console.println("\nA - Manage Army");
        this.console.println("R - Manage Resources");
        this.console.println("M - View Map");
        this.console.println("H - Help Menu");
        this.console.println("S - Save Game");
        this.console.println("E - Exit without Saving");

        inputs[0] = this.getInput("Select item from menu by entering the appropriate letter: ");
        return inputs;
    }

    @Override
    public Boolean doAction(String[] inputs) {
        
        String command = inputs[0].toUpperCase();
        
        switch (command) {
            case "A":
                manageArmy();
                break;
            case "R":
                manageResources();
                break;
            case "M":
                viewMap();
                break;
            case "H":
                getHelp();
                break;
            case "S":
                break;
            case "E":
                return true;
        }
        
        return false;
    }
    
    private void getHelp() {
        HelpMenuView helpMenuView = new HelpMenuView();
        helpMenuView.display();
    }

    private void manageArmy() {
       ManageArmyView manageArmyView = new ManageArmyView();
       manageArmyView.display();
    }

    private void manageResources() {
        
    }

    private void viewMap() {
       MapMenuView mapMenuView = new MapMenuView();
       mapMenuView.display();
    }
}
