/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.control;

import cit260.model.Actor;
import cit260.model.Army;
import cit260.model.ArmyMember;
import cit260.model.Game;
import cit260.model.Map;
import cit260.model.Player;
import cit260.model.PlayerActor;
import cit260.model.Question;
import cit260.model.TerritoryEnum;
import java.util.ArrayList;
import kingdoms.and.glory.KingdomsAndGlory;

/**
 *
 * @author aaroncr-dkz
 */
public class GameControl {
    
    public static int createNewGame(Player player) {
        if (player == null) {
            return -1;
        }
        
        // create a game object
        Game game = new Game();
        game.setPlayer(player);
        KingdomsAndGlory.setCurrentGame(game);
        

        // create the player's actor
        Actor opinionLeader = new PlayerActor();
        player.setPlayerCharacter(opinionLeader);
        
        // create an empty army and assign it
        Army army = new Army();
        game.setArmy(army);
        
        // create the map, pass it the resource array
        Map map = MapControl.createMap(5, 5);
        if (map == null) {
            return -1;
        }
        
        // set the player's starting location
        player.getPlayerCharacter().setLocation(map.getTerritories()
                                   [TerritoryEnum.Castle_of_Warren.getX()]
                                   [TerritoryEnum.Castle_of_Warren.getY()]);
        
        // set the map to the game
        game.setMap(map);
        
        return 1;
        
        
    }
    
    public static Player savePlayer(String name) {
        if (name == null || name.length() < 1) {
            return null;
        }
        
        Player player = new Player();
        player.setName(name);
        
        KingdomsAndGlory.setPlayer(player);
        
        return player;
    }
    
    public static String[] acquireQuestion(int questionNum) {
        
        String[] text = new String[4];
        
        switch (questionNum) {
            case 0:
                text[0] = Question.Emperor.getQuestion();
                text[1] = Question.Emperor.getAnswerCharisma();
                text[2] = Question.Emperor.getAnswerDiplomacy();
                text[3] = Question.Emperor.getAnswerStratagy();
                break;
            case 1:
                text[0] = Question.Chariot.getQuestion();
                text[1] = Question.Chariot.getAnswerCharisma();
                text[2] = Question.Chariot.getAnswerDiplomacy();
                text[3] = Question.Chariot.getAnswerStratagy();
                break;
            case 2:
                text[0] = Question.Fortune.getQuestion();
                text[1] = Question.Fortune.getAnswerCharisma();
                text[2] = Question.Fortune.getAnswerDiplomacy();
                text[3] = Question.Fortune.getAnswerStratagy();
                break;
            case 3:
                text[0] = Question.Justice.getQuestion();
                text[1] = Question.Justice.getAnswerCharisma();
                text[2] = Question.Justice.getAnswerDiplomacy();
                text[3] = Question.Justice.getAnswerStratagy();
                break;
            case 4:
                text[0] = Question.Death.getQuestion();
                text[1] = Question.Death.getAnswerCharisma();
                text[2] = Question.Death.getAnswerDiplomacy();
                text[3] = Question.Death.getAnswerStratagy();
                break;
            case 5:
                text[0] = Question.Star.getQuestion();
                text[1] = Question.Star.getAnswerCharisma();
                text[2] = Question.Star.getAnswerDiplomacy();
                text[3] = Question.Emperor.getAnswerStratagy();
                break;
        }
        
        
        return text;
    }

    public static String determineTitle(int charisma, int diplomacy, int strategy) {
        String title = "";
        int attitude;

        if (charisma + diplomacy + strategy > 6) {
            return "error";
        } else if (charisma < 0 || diplomacy < 0 || strategy < 0) {
            return "error";
        } else if (charisma > 6 || diplomacy > 6 || strategy > 6) {
            return "error";
        }

        attitude = (diplomacy - strategy) + charisma * 2;

        if (attitude >= 11) {
            title = "Silver Tongued";
        } else if (attitude >= 7 && attitude <= 10) {
            title = "Benevolent";
        } else if (attitude >= 1 && attitude <= 6) {
            if (diplomacy > (charisma + 1) && diplomacy > (strategy + 1)) {
                title = "Peace Walker";
            } else if (charisma == strategy) {
                title = "Justifier";

            }
        } else if (attitude == 0) {
            title = "Balanced";
        } else if (attitude >= -4 && attitude <= -1) {
            title = "Disciplined";
        } else if (attitude <= -5) {
            title = "Iron Monger";
        }

        return title;
    }

    public static String retrieveArmyData() {
          ArrayList<ArmyMember> army = KingdomsAndGlory.getCurrentGame().getArmy().getArmyMembers();
          if (army == null) {
              return "error";
          }
          
          String returnString = "\n";
          
          String footmen = "Footmen: ";
          String siege = "Siege: ";
          String specialists = "Specialists: ";
          
          int numFootmen = 0;
          int numSiege = 0;
          int numSpecialist = 0;
          
          int powFootmen = 0;
          int powSiege = 0;
          int powSpecialist = 0;
                  
        
        for (ArmyMember member : army) {
            switch(member.getClassification()) {
                case "Footman":
                    numFootmen += 1;
                    powFootmen += member.getPower();
                    break;
                case "Siege":
                    numSiege += 1;
                    powSiege += member.getPower();
                    break;
                case "Specialist":
                    numSpecialist += 1;
                    powSpecialist += member.getPower();
                    break;
                case "Unique":
                    
                    break;
                    
            }
        }
        
        KingdomsAndGlory.getCurrentGame().getArmy().setNumSoldiers(numFootmen + numSiege + numSpecialist);
        KingdomsAndGlory.getCurrentGame().getArmy().setMilitaryPower(powFootmen + powSiege + powSpecialist);
        
        long totalNum = KingdomsAndGlory.getCurrentGame().getArmy().getNumSoldiers();
        int totalPow = KingdomsAndGlory.getCurrentGame().getArmy().getMilitaryPower();
        
        footmen += (numFootmen + "\n  Power: " + powFootmen);
        siege += (numSiege  + "\nPower: " + powSiege);
        specialists += (numSpecialist  + "\n      Power: " + powSpecialist);
        
        returnString += (footmen + "\n\n" + siege + "\n\n" + specialists + "\n\n" + "Total Army Size: "
                        + totalNum + "\nTotal Militray Power: " + totalPow + "\n");
        
        return returnString;
    }
}
