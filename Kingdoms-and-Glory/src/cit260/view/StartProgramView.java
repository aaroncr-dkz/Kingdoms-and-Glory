/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.view;

import cit260.control.GameControl;
import cit260.model.Player;
import java.util.Scanner;

/**
 *
 * @author bradclegg
 */
public class StartProgramView {

    public StartProgramView() {

    }

    public void displayStartProgramView() {
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

    public String[] getInputs() {
        System.out.println("**** getInputs() called ***");

        String[] inputs = new String[1];
        // display Welcome

        Boolean valid = false;
        Scanner inFile;
        inFile = new Scanner(System.in);
        while (valid == false) {
            System.out.println("Enter the player's name: ");
            String name = inFile.nextLine();
            name = name.trim();

            if (name.length() < 1) {
                System.out.println("You must enter a value");
                continue;
            }
            inputs[0] = name;
            valid = true;
        }
        return inputs;

    }

    public Boolean doAction(String[] inputs) {
        System.out.println("**** doAction() called ***");
        System.out.println("\tinputs = " + inputs[0]);

        String playerName = inputs[0];
        Player player = GameControl.savePlayer(playerName);

        if (player == null) {
            System.out.println("Could not create the player. Enter a differnt name");
            return false;
        }
        System.out.println("Welcome to the game " + playerName + " We hope you have a lot of fun");

        MainMenuView mainMenuView = new MainMenuView();
        mainMenuView.displayMainMenuView();

        return true;

    }

}
