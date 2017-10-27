/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.view;

import java.util.Scanner;

/**
 *
 * @author bradclegg
 */
public class HelpMenuView {

    public void displayHelpMenuView() {
        Boolean endView = false;
        String[] inputs;
        do {
            inputs = getInputs();
            if (inputs.length < 1 || inputs[0].toUpperCase().equals("E")) {
                return;
            }
            endView = doAction(inputs);
        } while (endView != true);

    }

    private String[] getInputs() {
        System.out.println("**** getInputs() called ***");

        String[] inputs = new String[1];
        // display menu
        System.out.println("A - Learn aout the Army");
        System.out.println("R - Learn about Resources");
        System.out.println("M - Learn about the map and movement");
        System.out.println("C - Learn about waging war and conquering cities");
        System.out.println("B - Go back");

        Boolean valid = false;
        Scanner inFile;
        inFile = new Scanner(System.in);
        while (valid == false) {
            System.out.println("Select item from menu by entering the appropriate letter: ");
            String name = inFile.nextLine();
            name = name.trim();

            if (name.length() < 1) {
                System.out.println("You must enter a valid letter");
                continue;
            }
            inputs[0] = name;
            valid = true;
        }
        return inputs;
    }

    private Boolean doAction(String[] inputs) {
        System.out.println("**** doAction() called ***");
        System.out.println("\tinputs = " + inputs[0]);

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
