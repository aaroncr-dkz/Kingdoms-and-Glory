/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.view;

import cit260.control.ArmyControl;
import cit260.exception.ArmyControlException;

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
            armyData = ArmyControl.retrieveArmyData();
        }
        catch(ArmyControlException e) {
           ErrorView.display(this.getClass().getName(), e.getMessage());
        }

        String[] inputs = new String[1];
        // display menu
        this.console.println("\nG - Gain Recruits"
                           + "\nS - Sell Army"
                           + "\nB - Go Back"
                           + "\n" + armyData);

        inputs[0] = this.getInput("Select item from the menu by entering the appropriate letter: ");
        return inputs;
    }

    @Override
    public Boolean doAction(String[] inputs) {

        String command = inputs[0].toUpperCase();

        switch (command) {
            case "G":
                BuyArmyView buyArmyView = new BuyArmyView();
                buyArmyView.display();
                break;
            case "S":
                SellArmyView sellArmyView = new SellArmyView();
                sellArmyView.display();
                break;
            case "B":
                return true;
        }
        return false;
    }
    
   
}
