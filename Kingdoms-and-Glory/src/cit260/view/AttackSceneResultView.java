/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.view;

import cit260.control.MapControl;

/**
 *
 * @author bradclegg
 */
public class AttackSceneResultView extends View {
    
    public AttackSceneResultView() {
        
    }

    @Override
    public String[] getInputs() {

        String[] inputs = new String[1];
        // display menu
        
        System.out.println("\nA - Congratulations, YOU WIN. Take your loot.");
        System.out.println("B - Back"); 

        inputs[0] = this.getInput("Select item from menu by entering the appropriate letter: ");
        return inputs;
    }

    @Override
    public Boolean doAction(String[] inputs) {

        String command = inputs[0].toUpperCase();

        switch (command) {
            case "A":
                loot();
                break;
            case "B":
                return true;
        }
        return false;
    }

    private void loot() {
        
    }
}
