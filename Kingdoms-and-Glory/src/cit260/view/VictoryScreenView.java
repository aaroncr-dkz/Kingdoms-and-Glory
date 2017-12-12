/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.view;

/**
 *
 * @author bradclegg
 */
public class VictoryScreenView extends View {
    
    public VictoryScreenView() {
        
    }

    @Override
    public String[] getInputs() {

        String[] inputs = new String[1];
        
        // display menu
        
        
        inputs[0] = this.getInput("Select item from menu by entering the appropriate letter: ");
        return inputs;
    }

    @Override
    public Boolean doAction(String[] inputs) {

        String command = inputs[0].toUpperCase();

        switch (command) {
           
        }
        return false;
    }
}
