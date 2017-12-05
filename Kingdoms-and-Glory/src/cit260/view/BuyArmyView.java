/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.view;

import cit260.control.ArmyControl;

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
        // display menu
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
                buying(8, 1, "footmen");
                break;
            case "S":
                System.out.println("selling army");
                break;
            case "C":
                return true;
        }
        return false;
    }

    private void buying(int cost, int power, String type) {
        int[] inputs = {0};
        String command = this.getInput("\nEnter the number of " + type + " you wish to hire: ");

        //while(gold < totalCost) {
            try {
                inputs[0] = (Integer.parseInt(command));
            } 
            catch (NumberFormatException nfe) {
                ErrorView.display(this.getClass().getName(), "Value entered was not an integer");
            }

            int totalCost = inputs[0] * cost;
            //if (gold < totalCost) {
            //   System.out.println("Insufficient gold to hire that many " + type);
            //}
        //}
        
        // convert the first letter to capital and reassign it back
        String temp = type.substring(0, 1).toUpperCase() + type.substring(1);
        type = temp;
        
        ArmyControl.buyArmy(inputs[0], power, type);

    }

}
