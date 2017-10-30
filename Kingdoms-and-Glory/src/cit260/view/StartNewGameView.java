/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.view;

import java.util.Scanner;
import cit260.control.GameControl;

/**
 *
 * @author bradclegg
 */
public class StartNewGameView {
    
    public StartNewGameView() {
        
    }
    
    public void displayStartNewGameView() {
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
        
        // display introduction
        System.out.println("");
        

        Boolean valid = false;
        Scanner inFile;
        inFile = new Scanner(System.in);
        
        for (int i = 0; i < 6; i++) {
            askQuestions(i);
        }
        
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

    private void askQuestions(int question) {
        GameControl.acquireQuestion(question);
    }
    
    
}
