/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.view;

import cit260.control.GameControl;
import cit260.control.MapControl;
import cit260.exception.MapControlException;
import cit260.model.Actor;
import cit260.model.AttackScene;
import cit260.model.Player;
import cit260.model.PlayerActor;
import cit260.model.Territory;
import java.util.Scanner;
import kingdoms.and.glory.KingdomsAndGlory;

/**
 *
 * @author bradclegg
 */
public class AttackSceneView {
    
    public AttackSceneView() {
        
    }

    public void display(int attackRow, int attackCol) {
        Boolean endView = false;
        String[] inputs;
        do {

            inputs = getInputs();

            if (inputs.length < 1 || inputs[0].toUpperCase().equals("Q")) {
                return;
            }

            endView = doAction(inputs, attackRow, attackCol);

        } while (endView != true);
    }
    
    public String[] getInputs() {
        String[] inputs = new String[1];
        
        Boolean valid = false; 
        Scanner inFile;
        inFile = new Scanner(System.in);
        
        while (valid == false) {
                // display menu
                System.out.println("\nA - Do you want to attack?"
                                 + "\nB - Retreat");
                
                String answer = inFile.nextLine();
                answer = answer.trim();

                if (answer.length() < 1) {
                    System.out.println("You must enter an answer");
                    continue;
                }
                inputs[0] = answer;
                valid = true;
            }
        
        return inputs;
    }

    public Boolean doAction(String[] inputs, int attackRow, int attackCol) {

        String command = inputs[0].toUpperCase();

        switch (command) {
            case "A":
                attack(attackRow, attackCol);
                return true;
            case "B":
                return true;
        }
        return false;
    }

    private void attack(int attackRow, int attackCol) {
        AttackScene attackScene = new AttackScene();
        attackScene.setEnemyStrength(1);
        int enemyValue = attackScene.getEnemyStrength();
        
        Player player = KingdomsAndGlory.getPlayer();
        player.setLeaderValue(2);  
        int leaderValue = player.getLeaderValue();
        PlayerActor actor = KingdomsAndGlory.getPlayer().getPlayerCharacter();
        
        if(MapControl.determineWinOrLose(leaderValue, enemyValue).equals(true))
        {
            try {
                String resultString = MapControl.movePlayerActor(actor, attackRow, attackCol, true);
            }
            catch (MapControlException mce) {
                ErrorView.display(this.getClass().getName(), mce.getMessage());
            }
            AttackSceneResultView attackSceneResultView = new AttackSceneResultView();
            attackSceneResultView.display();
        }
        else {
            System.out.println("Sorry, better luck next time");
        }
    }
}
