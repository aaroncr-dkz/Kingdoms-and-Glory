/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.view;

import java.io.BufferedReader;
import java.io.PrintWriter;
import kingdoms.and.glory.KingdomsAndGlory;

/**
 *
 * @author aaroncr-dkz
 */
public abstract class View implements ViewInterface {

    private String message;

    protected final BufferedReader keyboard = KingdomsAndGlory.getInFile();
    protected final PrintWriter console = KingdomsAndGlory.getOutFile();

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
        String input = "";

        // while a valid input has not been retireved
        try {
            while (valid == false) {
                this.console.println(promptMessage);
                
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

        return input; //return the input
    }

    @Override
    public abstract Boolean doAction(String[] inputs);
}
