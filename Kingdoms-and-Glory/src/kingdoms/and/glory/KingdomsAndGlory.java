/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdoms.and.glory;

import cit260.model.Game;
//import cit260.model.Map;
import cit260.model.Question;
import cit260.model.Player;
import cit260.model.Actor;
import cit260.model.PlayerActor;
import cit260.model.Territory;
import cit260.model.Resource;
import cit260.model.Questionnaire;

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
        Questionnaire quiz = new Questionnaire();
        
        //Map map = new Map();
        Territory territory = new Territory();
        Resource stone = new Resource();
        
        Player player = new Player();
        Actor actor = new Actor();
        PlayerActor pc = new PlayerActor();
        
        /********************
        * Set group 1
        ********************/
        gameOne.setEnemyCapitalCaptured(false);
        //gameOne.setMap(map);
        gameOne.setQuiz(quiz);
        
        /********************
        * Set group 2
        ********************/
        territory.setRow(0);
        territory.setColumn(0);
        territory.setVisited(false);
        
        stone.setName("stone");
        stone.setAmountOwned(50);
        
        /********************
        * Set group 3
        ********************/
        player.setName("Steve");
        player.setTitle("the Benevolent");
        
        actor.setName("Gilbert");
        actor.setDescription("An old and just ruler");
        actor.setLocation(territory);
        
        pc.setCharisma(3);
        pc.setDiplomacy(3);
        pc.setStrategy(3);
        

        
        Question.Emperor.getQuestion();
        
        //Boolean gameOver = gameOne.isEnemyCapitalCaptured;
        //System.out.println("did it work, " + gameOver);
        System.out.println(gameOne.toString());
       
        
        
        
    }
   
    
}
