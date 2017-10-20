/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdoms.and.glory;


import cit260.model.Game;
import cit260.model.Questionnaire;
import cit260.model.Question;
import cit260.model.Player;
import cit260.model.Actor;
import cit260.model.PlayerActor;
import cit260.model.Map;
import cit260.model.Territory;
import cit260.model.Resource;
import cit260.model.Army;
import cit260.model.ArmyMember;
import cit260.model.AttackScene;
import cit260.model.DefaultScene;
import cit260.model.ExamineCityScene;
import cit260.model.ExamineScene;
import cit260.model.ExamineWildernesScene;


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
        Map map = new Map();
        Territory territory = new Territory();
        Resource stone = new Resource();
        ArmyMember armyMember = new ArmyMember();
        Player player = new Player();
        Actor actor = new Actor();
        PlayerActor pc = new PlayerActor();
        Army army = new Army();
        ExamineCityScene examineCityScene = new ExamineCityScene();
        ExamineScene examineScene = new ExamineScene();
        ExamineWildernesScene examineWildernesScene = new ExamineWildernesScene();
        DefaultScene defaultScene = new DefaultScene();
        AttackScene attackScene = new AttackScene();
        
        
        //army test
        army.setNumSoldiers(10);
        army.setMilitaryPower(5);
        
        //ArmyMember test
        armyMember.setPower(5);
        armyMember.setClassification("a class");
        armyMember.setArmy(army);
        
        //AttackScene test
        attackScene.setEnemyStrength(5);
        attackScene.setEnemyLeader("Bob");
        attackScene.setVictoryReward(500);
        attackScene.setDescription("bad guy");
        
        //defaultScene test
        defaultScene.setDescription("description");
        
        //ExamineCityScene test
        examineCityScene.setDescription("not a nice city");
        examineCityScene.setEstimatedOpposition(5);
        examineCityScene.setPotentialGains(600);
        examineCityScene.setResource(stone);
        examineCityScene.setResourcesNeeded("500 stone");
        
        //ExamineScene test
        examineScene.setDescription("you know ");
        examineScene.setPotentialGains(500);
        
        //ExamineWildernesScene test
        examineWildernesScene.setDescription("hot");
        examineWildernesScene.setExploreResult(Boolean.TRUE);
        examineWildernesScene.setExploreRisk(Boolean.FALSE);
        examineWildernesScene.setPotentialGains(500);
        
        /********************
        * Set group 1
        ********************/
        gameOne.setEnemyCapitalCaptured(false);
        //gameOne.setMap(map);
        gameOne.setMap(map);
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
        System.out.println(army.toString());
        System.out.println(armyMember.toString());
        System.out.println(attackScene.toString());
        System.out.println(defaultScene.toString());
        System.out.println(examineCityScene.toString());
        System.out.println(examineScene.toString());
        System.out.println(examineWildernesScene.toString());
        
        
        
        }
    }
