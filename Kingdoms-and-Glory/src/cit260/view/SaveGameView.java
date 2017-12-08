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
public class SaveGameView extends View {
    
    public SaveGameView() {
        
    }

    @Override
    public String[] getInputs() {

        String[] inputs = new String[1];
        
        inputs[0] = this.getInput("Enter the path for the file where the game is to be saved: ");
        return inputs;
    }

    @Override
    public Boolean doAction(String[] inputs) {

        String filePath = inputs[0];

        try {
            GameControl.saveGame(KingdomsAndGlory.getCurrentGame(), filePath);
        }
        catch (Exception e) {
            ErrorView.display(this.getClass().getName(), e.getMessage());
        }
        
        
        return true;
    }
}
