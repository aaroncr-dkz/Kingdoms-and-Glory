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
public class MapMenuView {
    
    public static void main(String[] args) {
          MapMenuView mapMenuView = new MapMenuView();
          mapMenuView.DisplayMapMenuView();
      }
    
    public MapMenuView() {
        
    }
    
    public void DisplayMapMenuView() {
         Boolean endView = false;
        String[] inputs;
        do {
            inputs = getInputs();
            if (inputs.length < 1 || inputs[0].toUpperCase().equals("B")) {
                return;
            }
            endView = doAction(inputs);
        } while (endView != true);
    }

    private String[] getInputs() {
        System.out.println("**** getInputs() called ***");

        String[] inputs = new String[1];
        // display menu     
        System.out.println("V - View Territtory");
        System.out.println("C - Attack Territory");
        System.out.println("X - Move");
        System.out.println("B - Go Back"); 

        Boolean valid = false;
        Scanner inFile;
        inFile = new Scanner(System.in);
        while (valid == false) {
            System.out.println("Select item from menu by entering the appropriate letter: ");
            String name = inFile.nextLine();
            name = name.trim();

            if (name.length() < 1 || !name.toUpperCase().equals("V")
                                  && !name.toUpperCase().equals("C")
                                  && !name.toUpperCase().equals("X")
                                  && !name.toUpperCase().equals("B")) {
                System.out.println("You must enter a valid letter");
                System.out.println("V - View Territtory");
                System.out.println("C - Attack Territory");
                System.out.println("X - Move");
                System.out.println("B - Go Back"); 
                continue;
            }
            inputs[0] = name;
            valid = true;
        }
        return inputs;
    }

    private Boolean doAction(String[] inputs) {
          String command = inputs[0].toUpperCase();

        switch (command) {
            case "V":
                System.out.println("You are viewing a territory");
                break;
            case "C":
                System.out.println("You are attacking a territory");
                break;
            case "X":
                System.out.println("Moving");
                break;
            case "B":
                return true;
        }
        return false;
    }
}
