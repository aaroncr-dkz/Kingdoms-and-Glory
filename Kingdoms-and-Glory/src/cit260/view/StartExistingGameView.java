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
public class StartExistingGameView extends View {
    
    public StartExistingGameView() {
        
    }

    @Override
    public String[] getInputs() {
        String[] inputs = new String[1];

        inputs[0] = this.getInput("");
        return inputs;
    }

    @Override
    public Boolean doAction(String[] inputs) {
        return true;
    }
    
}
