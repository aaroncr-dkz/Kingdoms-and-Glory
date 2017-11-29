/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.view;

import cit260.control.GameControl;
import cit260.exception.GameControlException;

/**
 *
 * @author aaroncr-dkz
 */
public class ManageArmyView extends View {
    
    public ManageArmyView() {
        
    }

    @Override
    public String[] getInputs() {
        
        String armyData = "";
        
        try {
            armyData = GameControl.retrieveArmyData();
        }
        catch(GameControlException e) {
           System.out.println(e.getMessage()); 
        }

        String[] inputs = new String[1];
        // display menu
        System.out.println("\nG - Gain Recruits");
        System.out.println("S - Sell Army");
        System.out.println("B - Go Back");
        
        System.out.println(armyData);

        inputs[0] = this.getInput("Select item from the menu by entering the appropriate letter: ");
        return inputs;
    }

    @Override
    public Boolean doAction(String[] inputs) {

        String command = inputs[0].toUpperCase();

        switch (command) {
            case "G":
                System.out.println("buying army");
                break;
            case "S":
                System.out.println("selling army");
                break;
            case "B":
                return true;
        }
        return false;
    }
}
