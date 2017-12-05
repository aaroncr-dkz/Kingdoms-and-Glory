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
        this.console.println("\nA - Learn about the Army");
        this.console.println("R - Learn about Resources");
        this.console.println("M - Learn about the map and movement");
        this.console.println("C - Learn about waging war and conquering cities");
        this.console.println("B - Go back");
        
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
