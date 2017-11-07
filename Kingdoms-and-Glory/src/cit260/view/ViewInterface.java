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
public interface ViewInterface {
    
    public void display();
    public String[] getInputs();
    public String getInput(String promptMessage);
    public Boolean doAction(String[] inputs);
}
