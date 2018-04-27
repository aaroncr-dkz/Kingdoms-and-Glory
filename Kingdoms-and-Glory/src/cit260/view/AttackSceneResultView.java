/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.view;

import cit260.control.GameControl;
import cit260.control.MapControl;
import cit260.control.ResourceControl;
import cit260.model.Resource;
import cit260.model.ResourceEnum;
import cit260.model.Territory;
import kingdoms.and.glory.KingdomsAndGlory;

/**
 *
 * @author bradclegg
 */
public class AttackSceneResultView extends View {
    
    public AttackSceneResultView() {
        
    }

    @Override
    public String[] getInputs() {
        
        Territory templeShalina = MapControl.acquireGameTerritories()[0][0];
        if (templeShalina.getVisited() == true) {
            KingdomsAndGlory.getCurrentGame().setEnemyCapitalCaptured(true);
            VictoryScreenView vsv = new VictoryScreenView();
            vsv.display();
            
            String[] filler = {"Q"};
            return filler;
        } 
        else {
            String[] inputs = new String[1];
            // display menu
        
            System.out.println("\nA - Congratulations, YOU WIN. Take your loot.");
            System.out.println("B - Back"); 

            inputs[0] = this.getInput("Select item from menu by entering the appropriate letter: ");
            return inputs;
        }
    }

    @Override
    public Boolean doAction(String[] inputs) {

        String command = inputs[0].toUpperCase();

        switch (command) {
            case "A":
                loot();
                return true;
            case "B":
                return true;
        }
        return false;
    }

    private void loot() {
        int row = MapControl.acquirePlayerCurrentRow();
        int col = MapControl.acquirePlayerCurrentColumn();
        
        Territory toLoot = MapControl.acquireGameTerritories()[row][col];
        int reward = toLoot.getSceneAttack().getResource().getAmount();
        
        ResourceControl.acquireResourceArray().get(ResourceEnum.Gold.ordinal()).modifyAmount(reward);
        
        
    }
}
