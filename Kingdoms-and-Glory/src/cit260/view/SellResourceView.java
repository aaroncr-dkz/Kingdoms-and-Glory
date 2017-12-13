/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.view;

import cit260.control.ResourceControl;
import cit260.model.ResourceEnum;

/**
 *
 * @author bradclegg
 */
public class SellResourceView extends View {

    public SellResourceView() {
        
    }

   @Override
    public String[] getInputs() {

        String[] inputs = new String[1];
        
        // display menu
        this.console.println("\nW - Sell Wood: 5 gold each");
        this.console.println("M - Sell Metal: 15 gold each");
        this.console.println("S - Sell Stone: 10 gold each");
        this.console.println("C - Sell Cloth: 2 gold each");
        this.console.println("B - Back");
        
        
        inputs[0] = this.getInput("Select item from menu by entering the appropriate letter: ");
        return inputs;
    }

 @Override
    public Boolean doAction(String[] inputs) {

        String command = inputs[0].toUpperCase();

        switch (command) {
            case "W":
                selling(5, ResourceEnum.Wood.ordinal());
                break;
            case "M":
                selling(15, ResourceEnum.Metal.ordinal());
                break;
                case "S":
                selling(10, ResourceEnum.Stone.ordinal());
                break;
                case "C":
                selling(2, ResourceEnum.Cloth.ordinal());
                break;
            case "B":
                return true;
        }

        return false;
    }
    
    private void selling(int saleValue, int type) {
        int[] inputs = {0};
        String command = this.getInput("\nEnter the amount you wish to sell: ");
        int amountOwned = ResourceControl.getResourceValue(type);

        try {
            inputs[0] = (Integer.parseInt(command));
        } 
        catch (NumberFormatException nfe) {
            ErrorView.display(this.getClass().getName(), "Value entered was not an integer");
        }

        int totalProfit = inputs[0] * saleValue;
        if (inputs[0] > amountOwned) {
            System.out.println("Cannot sell more than you have");
        }
        else {
            ResourceControl.addToResource(totalProfit, ResourceEnum.Gold.ordinal());
            ResourceControl.reduceResource(inputs[0], type);
            
            this.console.println("You gained " + totalProfit + " gold");
        }
    }
}

