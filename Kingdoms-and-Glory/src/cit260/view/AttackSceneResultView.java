/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.view;

import cit260.control.MapControl;
import java.util.Scanner;

/**
 *
 * @author bradclegg
 */
public class AttackSceneResultView {
    
      public static void main(String[] args) {
          AttackSceneResultView attackSceneResultView = new AttackSceneResultView();
          attackSceneResultView.DisplayAttackSceneResultView();
      }
    
    public AttackSceneResultView() {
        
    }
    
    public void DisplayAttackSceneResultView() {
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
        if (MapControl.determineWinOrLose(5, 10, 1, 10, 4, 0).equals("Win")) {
            System.out.println("Congrdulations, YOU WIN");
        }
        else {
            System.out.println("Sorry you lose");
        }
        
        System.out.println("A - Loot Resources");
        System.out.println("S - Pillage");
        System.out.println("D - Loot and Pillage");
        System.out.println("E - Exit to game menu"); 

        Boolean valid = false;
        Scanner inFile;
        inFile = new Scanner(System.in);
        while (valid == false) {
            System.out.println("Select item from menu by entering the appropriate letter: ");
            String name = inFile.nextLine();
            name = name.trim();

            if (name.length() < 1 || !name.toUpperCase().equals("A")
                                  && !name.toUpperCase().equals("S")
                                  && !name.toUpperCase().equals("D")
                                  && !name.toUpperCase().equals("E")) {
                System.out.println("You must enter a valid letter");
                System.out.println("A - Loot Resources");
                System.out.println("S - Pillage");
                System.out.println("D - Loot and Pillage");
                System.out.println("B - Go Back"); 
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
                System.out.println("Looting City");
                break;
            case "S":
                System.out.println("Pillaging City");
                 break;
            case "D":
                System.out.println("Looting and Pillaging City");
                break;
            case "B":
                return true;
        }
        return false;
    }
}
