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
public class SellResourceView extends View {

    public SellResourceView() {
        
    }

   @Override
    public String[] getInputs() {

        String[] inputs = new String[1];
        
        // display menu
        System.out.println("\nW - Wood: 20$");
        System.out.println("M - Metal: 175$");
        System.out.println("S - Stone: 100$");
        System.out.println("C - Cloth: 15$");
        System.out.println("B - Back");
        
        
        inputs[0] = this.getInput("Select item from menu by entering the appropriate letter: ");
        return inputs;
    }

 @Override
    public Boolean doAction(String[] inputs) {

        String command = inputs[0].toUpperCase();

        switch (command) {
            case "W":
                System.out.println("Selling Wood");
                break;
            case "M":
                System.out.println("Selling Metal");
                break;
                case "S":
                System.out.println("Selling Stone");
                break;
                case "C":
                System.out.println("Selling Cloth");
                break;
            case "B":
                return true;
        }

        return false;
    }
}

