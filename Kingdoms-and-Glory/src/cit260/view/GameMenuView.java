/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.view;

import cit260.model.Game;
import cit260.model.Map;
import cit260.model.Territory;
import kingdoms.and.glory.KingdomsAndGlory;

/**
 *
 * @author bradclegg
 */
public class GameMenuView extends View {
    
    public GameMenuView() {
        
    }

    @Override
    public String[] getInputs() {
        String[] inputs = new String[1];
        
        // display menu
        System.out.println("\nA - Manage Army");
        System.out.println("R - Manage Resources");
        System.out.println("M - View Map");
        System.out.println("H - Help Menu");
        System.out.println("S - Save Game");
        System.out.println("E - Exit without Saving");

        inputs[0] = this.getInput("Select item from menu by entering the appropriate letter: ");
        return inputs;
    }

    @Override
    public Boolean doAction(String[] inputs) {
        
        String command = inputs[0].toUpperCase();
        
        switch (command) {
            case "A":
                manageArmy();
                System.out.println("manage army");
                break;
            case "R":
                manageResources();
                System.out.println("manage resources");
                break;
            case "M":
                viewMap();
                System.out.println("view map");
                break;
            case "H":
                getHelp();
                break;
            case "S":
                System.out.println("saving game");
                break;
            case "E":
                return true;
        }
        
        return false;
    }
    
    private void getHelp() {
        HelpMenuView helpMenuView = new HelpMenuView();
        helpMenuView.display();
    }

    private void manageArmy() {
       
    }

    private void manageResources() {
        
    }

    private void viewMap() {
       Game game = new Game();
       
       KingdomsAndGlory.getCurrentGame();
       
       game.getMap();
       
       Map map = new Map();
       map.getMap();
       
       System.out.println("-----Zenobia-----");
       System.out.println("1   2   3   4   5");
       
       int numOfRows = 5;
       int numOfColumns = 5;
       int k = 1;
       int row = k++;
       Territory[][] territorysInMap = new Territory[numOfRows][numOfColumns];
       
               
       for (int i = 0; i < territorysInMap.length; i++) {
           System.out.println("-----------------");
           System.out.println("\n" + row);
           
           for (int j = 0; j < territorysInMap[i].length; j++) {
               System.out.println("|");
               if (territorysInMap.equals(true)) {
                   System.out.print(" XX ");
               }
               else {
                   System.out.print(" ?? ");
               }
            }
           System.out.print("|");
        }
       System.out.print("-----------------");
    }
}
