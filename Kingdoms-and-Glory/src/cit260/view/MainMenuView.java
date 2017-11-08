/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.view;

import cit260.control.GameControl;
import kingdoms.and.glory.KingdomsAndGlory;

/**
 *
 * @author bradclegg
 */
public class MainMenuView extends View {
    
    public MainMenuView() {
        
    }

    @Override
    public String[] getInputs() {

        String[] inputs = new String[1];
        
        // display menu
        System.out.println("\nG - Start New Game");
        System.out.println("L - Load Saved Game");
        System.out.println("B - Background Story");
        System.out.println("H - Get help on how to play the game");
        System.out.println("E - Exit Program");
        
        inputs[0] = this.getInput("Select item from menu by entering the appropriate letter: ");
        return inputs;
    }

    @Override
    public Boolean doAction(String[] inputs) {

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

        return false;
    }

    private void startNewGame() {
        GameControl.createNewGame(KingdomsAndGlory.getPlayer());
        
        StartNewGameView startNewGameView = new StartNewGameView();
        startNewGameView.displayStartNewGameView();
        
        GameMenuView gameMenuView = new GameMenuView();
        gameMenuView.display();
    }

    private void loadGame() {
        StartExistingGameView startExistingGameView = new StartExistingGameView();
        startExistingGameView.display();
    }

    private void displayStory() {
      
    }

    private void getHelp() {
        HelpMenuView helpMenuView = new HelpMenuView();
        helpMenuView.display();
    }

}
