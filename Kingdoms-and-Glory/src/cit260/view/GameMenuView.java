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
        System.out.println("\nA - Manage Army");
        System.out.println("R - Manage Resources");
        System.out.println("M - View Map");
        System.out.println("H - Help Menu");
        System.out.println("S - Save Game");
        System.out.println("E - Exit without Saving");

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
                System.out.println("manage resources");
                break;
            case "M":
                viewMap();
                break;
            case "H":
                getHelp();
                break;
            case "S":
                System.out.println("saving game");
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
