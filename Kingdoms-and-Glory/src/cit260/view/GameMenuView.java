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
public class GameMenuView {
    
    public GameMenuView() {
        
    }
    
    public void displayGameMenuView() {
        
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
        String[] inputs = new String[1];
        
        // display menu
        System.out.println("\nA - Manage Army");
        System.out.println("R - Manage Resources");
        System.out.println("M - View Map");
        System.out.println("H - Help Menu");
        System.out.println("S - Save Game");
        System.out.println("E - Exit without Saving");

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
        return true;
    }
    
    
}
