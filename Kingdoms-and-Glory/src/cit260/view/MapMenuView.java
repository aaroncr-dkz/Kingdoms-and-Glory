/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.view;

import cit260.model.Map;
import cit260.model.Territory;
import kingdoms.and.glory.KingdomsAndGlory;

/**
 *
 * @author bradclegg
 */
public class MapMenuView extends View {

//    public static void main(String[] args) {
//          MapMenuView mapMenuView = new MapMenuView();
//          mapMenuView.display();
//      }
    public MapMenuView() {

    }

    @Override
    public String[] getInputs() {

        String[] inputs = new String[1];

        // display map
        System.out.println("              Zenobia");
        System.out.println("===================================");
        System.out.println("*      1     2     3     4     5  *");
        System.out.println("*   ------------------------------*");

        int numOfRows = 5;
        int numOfColumns = 5;
        int i;
        Map map = KingdomsAndGlory.getCurrentGame().getMap();
        Territory[][] territories = map.getTerritories();

        for (i = 0; i < territories.length; i++) {
            System.out.print("* " + (i + 1) + " ");

            for (int j = 0; j < territories[i].length; j++) {
                System.out.print("|");
                if (territories[i][j].getVisited()) {
                    System.out.print(" XXX ");
                } else {
                    System.out.print(" ??? ");
                }
            }
            System.out.print("*\n");

            if (i < 4) {
                System.out.print("*   |-----|-----|-----|-----|-----*\n");
            }

        }
        System.out.print("*   ------------------------------*\n");
        System.out.print("===================================\n");

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
