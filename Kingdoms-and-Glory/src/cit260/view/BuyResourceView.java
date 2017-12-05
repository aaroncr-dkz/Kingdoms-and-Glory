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
public class BuyResourceView extends View {
    
    public BuyResourceView() {
        
    }

   @Override
    public String[] getInputs() {

        String[] inputs = new String[1];
        
        // display menu
        this.console.println("\nW - Wood: 100$");
        this.console.println("M - Buy Metal: 350$");
        this.console.println("S - Buy Stone 200$");
        this.console.println("C - Buy Cloth: 25$");
        this.console.println("B - Back");
        
        
        inputs[0] = this.getInput("Select item from menu by entering the appropriate letter: ");
        return inputs;
    }

    
  @Override
    public Boolean doAction(String[] inputs) {

        String command = inputs[0].toUpperCase();

        switch (command) {
            case "W":
                System.out.println("Buying Wood");
                break;
            case "M":
                System.out.println("Buying Metal");
                break;
                case "S":
                System.out.println("Buying Stone");
                break;
                case "C":
                System.out.println("Buying Cloth");
                break;
            case "B":
                return true;
        }

        return false;
    }
}
