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
        if (MapControl.determineWinOrLose(5, 10, 1, 10, 4, 0).equals("Win")) {
            System.out.println("Congratulations, YOU WIN");
        }
        else {
            System.out.println("Sorry you lose");
        }
        
        System.out.println("\nA - Loot Resources");
        System.out.println("S - Pillage");
        System.out.println("D - Loot and Pillage");
        System.out.println("E - Exit to game menu"); 

        inputs[0] = this.getInput("Select item from menu by entering the appropriate letter: ");
        return inputs;
    }

    @Override
    public Boolean doAction(String[] inputs) {

        String command = inputs[0].toUpperCase();

        switch (command) {
            case "A":
                System.out.println("Looting City");
                break;
            case "S":
                System.out.println("Pillaging City");
                 break;
            case "D":
                System.out.println("Looting and Pillaging City");
                break;
            case "E":
                return true;
        }
        return false;
    }
}
