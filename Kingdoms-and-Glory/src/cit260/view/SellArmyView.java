/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.view;

import cit260.control.ArmyControl;
import cit260.control.ResourceControl;
import cit260.model.ResourceEnum;

/**
 *
 * @author aaroncr-dkz
 */
public class SellArmyView extends View {

    public SellArmyView() {

    }

    @Override
    public String[] getInputs() {

        String[] inputs = new String[1];
        int gold = ResourceControl.getResourceValue(ResourceEnum.Gold.ordinal());
        
        // display menu
        this.console.println("\nTotal War Funds: " + gold);
        this.console.println("\nF - Dismiss Footmen");
        this.console.println("S - Dismiss Specialists");
        this.console.println("C - Dismiss Siege Engineers");

        inputs[0] = this.getInput("Select item from the menu by entering the appropriate letter: ");
        return inputs;
    }

    @Override
    public Boolean doAction(String[] inputs) {

        String command = inputs[0].toUpperCase();

        switch (command) {
            case "F":
                buying(4, 1, "footman");
                return true;
            case "S":
                buying(5, 2, "specialist");
                return true;
            case "C":
                buying(10, 4, "siege");
                return true;
        }
        return false;
    }

    private void buying(int saleValue, int power, String type) {
        int[] inputs = {0};
        String command = this.getInput("\nEnter the number you wish to dismiss: ");
        int gold = ResourceControl.getResourceValue(ResourceEnum.Gold.ordinal());
        
        
        String temp = type.substring(0, 1).toUpperCase() + type.substring(1);
        type = temp;
        int numberOf = ArmyControl.numberOf(type);

        try {
            inputs[0] = (Integer.parseInt(command));
        } 
        catch (NumberFormatException nfe) {
            ErrorView.display(this.getClass().getName(), "Value entered was not an integer");
        }

        int totalProfit = inputs[0] * saleValue;
        if (inputs[0] > numberOf) {
            System.out.println("Cannot dismiss more men than you have");
        }
        else {
            ResourceControl.addToResource(totalProfit, ResourceEnum.Gold.ordinal());
            
            ArmyControl.sellArmy(inputs[0], type);
            this.console.println("You recieved " + totalProfit + " gold");
        }
    }
}
