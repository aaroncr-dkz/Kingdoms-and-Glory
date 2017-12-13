/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.view;

import cit260.control.ArmyControl;
import cit260.control.GameControl;
import cit260.control.ResourceControl;
import cit260.model.ResourceEnum;

/**
 *
 * @author aaroncr-dkz
 */
public class BuyArmyView extends View {

    public BuyArmyView() {

    }

    @Override
    public String[] getInputs() {

        String[] inputs = new String[1];
        int gold = ResourceControl.getResourceValue(ResourceEnum.Gold.ordinal());
        
        // display menu
        this.console.println("\nTotal War Funds: " + gold);
        this.console.println("\nF - Recruit Footmen - 8 Gold each");
        this.console.println("S - Recruit Specialists - 10 Gold each");
        this.console.println("C - Recruit Siege Engineers - 20 gold each");

        inputs[0] = this.getInput("Select item from the menu by entering the appropriate letter: ");
        return inputs;
    }

    @Override
    public Boolean doAction(String[] inputs) {

        String command = inputs[0].toUpperCase();

        switch (command) {
            case "F":
                buying(8, 1, "footman");
                return true;
            case "S":
                buying(10, 2, "specialist");
                return true;
            case "C":
                buying(20, 4, "siege");
                return true;
        }
        return false;
    }

    private void buying(int cost, int power, String type) {
        int[] inputs = {0};
        String command = this.getInput("\nEnter the number you wish to hire: ");
        int gold = ResourceControl.getResourceValue(ResourceEnum.Gold.ordinal());
        int totalCost;

        try {
            inputs[0] = (Integer.parseInt(command));
        } 
        catch (NumberFormatException nfe) {
            ErrorView.display(this.getClass().getName(), "Value entered was not an integer");
        }

        totalCost = inputs[0] * cost;
        if (gold < totalCost) {
            System.out.println("Insufficient gold to hire that many");
        }
        else {
            ResourceControl.reduceResource(totalCost, ResourceEnum.Gold.ordinal());
            
            // convert the first letter to capital and reassign it back
            String temp = type.substring(0, 1).toUpperCase() + type.substring(1);
            type = temp;
            
            ArmyControl.buyArmy(inputs[0], power, type);
            this.console.println("You spent " + totalCost + " gold");
        }
    }
}
