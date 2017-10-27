/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.view;

import cit260.control.GameControl;
import cit260.model.Game;
import cit260.model.Player;
import java.util.Scanner;
import kingdoms.and.glory.KingdomsAndGlory;

/**
 *
 * @author bradclegg
 */
public class MainMenuView {

    public void displayMainMenuView() {
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
        System.out.println("G - Start New Game");
        System.out.println("L - Load Saved Game");
        System.out.println("B - Background Story");
        System.out.println("H - Get help on how to play the game");
        System.out.println("E - Exit");

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
            case "G":
                startNewGame();
                System.out.println("Starting new game");
                break;
            case "L":
                loadGame();
                System.out.println("loading game");
                break;
            case "B":
                displayStory();
                System.out.println("loading story");
                break;
            case "H":
                getHelp();
                System.out.println("getting help");
                break;
            case "E":
                return true;
        }

        //  MainMenuView mainMenuView = new MainMenuView();
        //  mainMenuView.displayMainMenuView();
        System.out.println("not valid");
        return false;
    }

    private void startNewGame() {
        GameControl.createNewGame(KingdomsAndGlory.getPlayer());
        
        GameMenuView gameMenuView = new GameMenuView();
        gameMenuView.displayGameMenuView();
    }

    private void loadGame() {
        StartExistingGameView startExistingGameView = new StartExistingGameView();
        startExistingGameView.displayStartExisitingGameView();
    }

    private void displayStory() {
      
    }

    private void getHelp() {
        HelpMenuView helpMenuView = new HelpMenuView();
        helpMenuView.displayHelpMenuView();
    }

}
