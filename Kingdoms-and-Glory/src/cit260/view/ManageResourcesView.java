/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.view;

import cit260.control.ResourceControl;
import cit260.exception.GameControlException;

/**
 *
 * @author bradclegg
 */
public class ManageResourcesView extends View {
    
    public ManageResourcesView() {
        
    }
    
    @Override
    public String[] getInputs() {

        
        String resourceData = "";
        
        try {
            resourceData = ResourceControl.retriveResourceData();
        }
        catch(GameControlException e) {
           ErrorView.display(this.getClass().getName(), e.getMessage());
        }
        
        String[] inputs = new String[1];
        // display menu
        this.console.println("\nA - Buy Resource"
                           + "\nS - Sell Resource"
                           + "\nB - Go Back"
                           + "\n\n" + resourceData);
        
        
        inputs[0] = this.getInput("Select item from menu by entering the appropriate letter: ");
        return inputs;
    }
    
      @Override
    public Boolean doAction(String[] inputs) {

        String command = inputs[0].toUpperCase();

        switch (command) {
            case "A":
                buyResouce();
                System.out.println("Buying Resources");
                break;
            case "S":
                sellResource();
                System.out.println("Selling Resources");
                break;
            case "B":
                return true;
        }

        return false;
    }

    private void buyResouce() {
        BuyResourceView buyResourceView = new BuyResourceView();
        buyResourceView.display();
    }

    private void sellResource() {
       SellResourceView SellResourceView = new SellResourceView();
        SellResourceView.display(); 
    }
    
}
