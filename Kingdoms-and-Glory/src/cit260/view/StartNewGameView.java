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
        int i = 0;
        
        // display Warren's introduction
        System.out.println("===================================================\n"
                         + "* My name is Warren. I am a great seer who can    *\n"
                         + "* understand the destiny the stars have placed    *\n"
                         + "* upon you. I will use my power to see what type  *\n"
                         + "* of leader you are destined to be for this army. *\n"
                         + "===================================================\n");
        
        do {
            inputs = getInputs(i);
            
            if (inputs.length < 1 || !inputs[0].toUpperCase().equals("A")
                    && !inputs[0].toUpperCase().equals("B")
                    && !inputs[0].toUpperCase().equals("C")) {
                System.out.println("Please choose a valid respone...\n");
                continue;
            }
            
            endView = doAction(inputs, i);
            i++;
            
        } while (endView != true);
        
    }

    private String[] getInputs(int i) {
        String[] inputs = new String[1];

        // prompt
        System.out.println("Please choose a respone...\n");
        

        Boolean valid = false;
        Scanner inFile;
        inFile = new Scanner(System.in);
        String[] text = new String[4];

            text = GameControl.acquireQuestion(i);

            while (valid == false) {
                System.out.println(text[0]);
                System.out.println("A. " + text[1]);
                System.out.println("B. " + text[2]);
                System.out.println("C. " + text[3]);
                
                String answer = inFile.nextLine();
                answer = answer.trim();

                if (answer.length() < 1) {
                    System.out.println("You must enter an answer");
                    continue;
                }
                inputs[0] = answer;
                valid = true;
            }
        

        return inputs;
    }

    private Boolean doAction(String[] inputs, int i) {

        String command = inputs[0].toUpperCase();

        switch (command) {
            case "A":
                System.out.println("Charisma");
                break;
            case "B":
                System.out.println("Diplomacy");
                break;
            case "C":
                System.out.println("Strategy");
                break;
        }
        
        if (i < 5) {
            return false;
        }
        else {
            return true;
        }
    }
}
