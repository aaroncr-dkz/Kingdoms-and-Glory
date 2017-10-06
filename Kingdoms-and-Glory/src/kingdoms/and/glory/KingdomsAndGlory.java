/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdoms.and.glory;

import cit260.model.Game;
import cit260.model.Map;
import cit260.model.Question;

/**
 *
 * @author bradclegg
 */
public class KingdomsAndGlory {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Game gameOne = new Game();
        Map map = new Map();
        Question.Question1.getQuestion();
        gameOne.setEnemyCapitalCaptured(false);
        gameOne.setMap(map);
        Boolean gameOver = gameOne.isEnemyCapitalCaptured();
        System.out.println("did it work, " + gameOver);
        System.out.println(gameOne.toString());
       
        
        
        
    }
   
    
}
