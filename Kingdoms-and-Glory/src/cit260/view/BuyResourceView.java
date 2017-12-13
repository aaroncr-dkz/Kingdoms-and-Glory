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
public class BuyResourceView extends View {
    
    public BuyResourceView() {
        
    }

   @Override
    public String[] getInputs() {

        String[] inputs = new String[1];
        
        // display menu
        this.console.println("\nW - Buy Wood: 10 gold each");
        this.console.println("M - Buy Metal: 35 gold each");
        this.console.println("S - Buy Stone: 20 gold each");
        this.console.println("C - Buy Cloth: 5 gold each");
        this.console.println("B - Back");
        
        
        inputs[0] = this.getInput("Select item from menu by entering the appropriate letter: ");
        return inputs;
    }

    
  @Override
    public Boolean doAction(String[] inputs) {

        String command = inputs[0].toUpperCase();

        switch (command) {
            case "W":
                buying(10, ResourceEnum.Wood.ordinal());
                break;
            case "M":
                buying(35, ResourceEnum.Metal.ordinal());
                break;
                case "S":
                buying(20, ResourceEnum.Stone.ordinal());
                break;
                case "C":
                buying(5, ResourceEnum.Cloth.ordinal());
                break;
            case "B":
                return true;
        }

        return false;
    }
    
    private void buying(int cost, int type) {
        int[] inputs = {0};
        String command = this.getInput("\nEnter the amount you wish to purchase: ");
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
            System.out.println("Insufficient gold to buy that amount");
        }
        else {
            ResourceControl.reduceResource(totalCost, ResourceEnum.Gold.ordinal());
            ResourceControl.addToResource(inputs[0], type);
            
            this.console.println("You spent " + totalCost + " gold");
        }
    }
}
