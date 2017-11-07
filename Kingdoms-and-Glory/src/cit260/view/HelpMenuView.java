/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.view;

/**
 *
 * @author bradclegg
 */
public class HelpMenuView extends View {
    
    public HelpMenuView() {
        
    }

    @Override
    public String[] getInputs() {

        String[] inputs = new String[1];
        // display menu
        System.out.println("\nA - Learn about the Army");
        System.out.println("R - Learn about Resources");
        System.out.println("M - Learn about the map and movement");
        System.out.println("C - Learn about waging war and conquering cities");
        System.out.println("B - Go back");
        
        inputs[0] = this.getInput("Select item from menu by entering the appropriate letter: ");
        return inputs;
    }

    @Override
    public Boolean doAction(String[] inputs) {

        String command = inputs[0].toUpperCase();

        switch (command) {
            case "A":
                System.out.println("Learning army");
                break;
            case "R":
                System.out.println("learning resources");
                break;
            case "M":
                System.out.println("learning map");
                break;
            case "C":
                System.out.println("Learning war");
                break;
            case "B":
                return true;
        }
        return false;
    }
}
