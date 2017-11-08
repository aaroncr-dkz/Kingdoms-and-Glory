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
public class MapMenuView extends View {
    
    public static void main(String[] args) {
          MapMenuView mapMenuView = new MapMenuView();
          mapMenuView.display();
      }
    
    public MapMenuView() {
        
    }

    @Override
    public String[] getInputs() {

        String[] inputs = new String[1];
        // display menu     
        System.out.println("\nV - View Territtory");
        System.out.println("C - Attack Territory");
        System.out.println("X - Move");
        System.out.println("B - Go Back"); 
        
        inputs[0] = this.getInput("Select item from menu by entering the appropriate letter: ");
        return inputs;
    }

    @Override
    public Boolean doAction(String[] inputs) {
          String command = inputs[0].toUpperCase();

        switch (command) {
            case "V":
                System.out.println("You are viewing a territory");
                break;
            case "C":
                System.out.println("You are attacking a territory");
                break;
            case "X":
                System.out.println("Moving");
                break;
            case "B":
                return true;
        }
        return false;
    }
}
