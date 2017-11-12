/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.view;

import java.util.Scanner;

/**
 *
 * @author aaroncr-dkz
 */
public abstract class View implements ViewInterface {
    
    public View() {
        
    }
    
    @Override
    public void display() {
        Boolean endView = false;
        String[] inputs;
        do {
            
            inputs = getInputs();
            
            if (inputs.length < 1 || inputs[0].toUpperCase().equals("Q")) {
                return;
            }
            
            endView = doAction(inputs);
            
        } while (endView != true);
    }
    
    @Override
    public abstract String[] getInputs();
    
    @Override
    public String getInput(String promptMessage) {
        
        Boolean valid = false;
        Scanner inFile;
        String input = "";
        inFile = new Scanner(System.in);
        
        while (valid == false) {
            System.out.println(promptMessage);
            String name = inFile.nextLine();
            name = name.trim();

            if (name.length() < 1) {
                System.out.println("You must enter a value");
                continue;
            }
            input = name;
            valid = true;
        }
        
        return input;
    }
    
    @Override
    public abstract Boolean doAction(String[] inputs);
}
