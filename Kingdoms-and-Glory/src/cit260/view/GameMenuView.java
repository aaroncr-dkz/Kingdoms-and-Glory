/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.view;

import cit260.control.GameControl;
import cit260.model.Territory;
import java.io.PrintWriter;
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
        if (GameControl.isGameWon()) {
            String[] filler = {"Q"};
            return filler;
        } 
        
        String[] inputs = new String[1];
        
        // display menu
        this.console.println("\nA - Manage Army"
                           + "\nR - Manage Resources"
                           + "\nM - View Map"
                           + "\nH - Help Menu"
                           + "\nP - Print Report to File"
                           + "\nS - Save Game"
                           + "\nE - Exit without Saving");

        inputs[0] = this.getInput("Select item from menu by entering the appropriate letter: ");
        return inputs;
    }

    @Override
    public Boolean doAction(String[] inputs) {
        
        String command = inputs[0].toUpperCase();
        
        switch (command) {
            case "A":
                manageArmy();
                break;
            case "R":
                manageResources();
                break;
            case "M":
                viewMap();
                break;
            case "H":
                getHelp();
                break;
            case "P":
                getFileName();
                break;
            case "S":
                save();
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
       ManageArmyView manageArmyView = new ManageArmyView();
       manageArmyView.display();
    }

    private void manageResources() {
        ManageResourcesView manageResourcesView = new ManageResourcesView();
        manageResourcesView.display();
    }

    private void viewMap() {
       MapMenuView mapMenuView = new MapMenuView();
       mapMenuView.display();
    }

    private void save() {
        SaveGameView saveGameView = new SaveGameView();
        saveGameView.display();
    }

    private void getFileName() {
        Boolean valid = false;
        String input = "";

        // while a valid input has not been retireved
        try {
            while (valid == false) {
                this.console.println("Enter the path for the file where the report is to be saved: ");
                
                String name = this.keyboard.readLine();
                name = name.trim();

                if (name.length() < 1) { // blank value entered
                    ErrorView.display(this.getClass().getName(), "You must enter a value");
                    continue;
                }
                input = name;
                valid = true;
            }
        }
        catch (Exception e) {
            ErrorView.display(this.getClass().getName(), e.getMessage());
        }
        
        printReport(input);
    }

    private void printReport(String fileName) {
        try (PrintWriter out = new PrintWriter(fileName)){
            
            Territory[][] locations = KingdomsAndGlory.getCurrentGame().getMap().getTerritories();
            out.print("LOCATIONS IN ZENOBIA");
            out.printf("%n%-20s%-8s%-10s", "NAME", "CODE", "LOCATION");
            
            for(int i = 4; i > -1; i--) {
                
                for(int j = 4; j > -1; j--) {
                    String name = locations[i][j].getName();
                    String code = locations[i][j].getSymbol();
                    int row = locations[i][j].getRow();
                    int col = locations[i][j].getColumn();
                    String loc = row + ", " + col;
                    
                    out.printf("%n%-20s%-8s%-10s", name, "(" + code + ")", loc);
                }
            }
            
        }catch (Exception e) {
             ErrorView.display(this.getClass().getName(), e.getMessage());
        }
        
    }
}
