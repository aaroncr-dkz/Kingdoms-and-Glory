/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.control;

import cit260.exception.GameControlException;
import cit260.model.Actor;
import cit260.model.Army;
import cit260.model.ArmyMember;
import cit260.model.Game;
import cit260.model.Map;
import cit260.model.Player;
import cit260.model.PlayerActor;
import cit260.model.Question;
import cit260.model.TerritoryEnum;
import cit260.model.Resource;
import cit260.model.ResourceEnum;
import java.util.ArrayList;
import kingdoms.and.glory.KingdomsAndGlory;

/**
 *
 * @author aaroncr-dkz
 */
public class GameControl {
    
    public static void createNewGame(Player player) throws GameControlException 
    {
        if (player == null) {
            throw new GameControlException("ERROR: An object failed to create. "
                                         + "Try restarting the program.");
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
            throw new GameControlException("ERROR: An object failed to create. "
                                         + "Try restarting the program.");
        }
        
        // set the player's starting location
        player.getPlayerCharacter().setLocation(map.getTerritories()
                                   [TerritoryEnum.Castle_of_Warren.getX()]
                                   [TerritoryEnum.Castle_of_Warren.getY()]);
        
        // set the map to the game
        game.setMap(map);
    }
    
    public static Player savePlayer(String name) throws GameControlException 
    {
        if (name == null || name.length() < 1) {
            throw new GameControlException("ERROR: The name you entered was not "
                                         + "saved. Try restarting the program.");
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

    public static String determineTitle(int charisma, int diplomacy, int strategy) throws GameControlException
    {
        String title = "";
        int attitude;

        if (charisma + diplomacy + strategy > 6) {
            throw new GameControlException("ERROR: A value is outside of its "
                                         + "allowed bounds. Try restarting the program.");
            
        } else if (charisma < 0 || diplomacy < 0 || strategy < 0) {
            throw new GameControlException("ERROR: A value is outside of its "
                                         + "allowed bounds. Try restarting the program.");
            
        } else if (charisma > 6 || diplomacy > 6 || strategy > 6) {
            throw new GameControlException("ERROR: A value is outside of its "
                                         + "allowed bounds. Try restarting the program.");
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
    
    public static String retriveResourceData() throws GameControlException 
    {
        ArrayList<Resource> resource = KingdomsAndGlory.getCurrentGame().getResources();
        if (resource == null) {
              throw new GameControlException("ERROR: An object failed to create. "
                                           + "Try restarting the program.");
          }
        
        String cloth = "Cloth: ";
        String wood = "Wood: ";
        String stone = "Stone: ";
        String metal = "Metal: ";
        String gold = "Gold: ";
        
        int numCloth = 0;
        int numWood = 0;
        int numStone = 0;
        int numMetal = 0;
        int numGold = 0;
        
        
        
        for (Resource resourceType : resource) {
            switch(resourceType.toString()) {
                case "Cloth":
                    numCloth += 1;
                    break;
                case "Wood":
                    numWood += 1;
                    break;
                case "Stone":
                    numStone += 1;
                    break;
                case "Metal":
                    numMetal += 1;
                    break;
                case "Gold":
                    numGold += 1;
                    break;   
            }
        }
        
         KingdomsAndGlory.getCurrentGame().setResources(resource);
         
         ArrayList<Resource> totalResources = KingdomsAndGlory.getCurrentGame().getResources();
         
         cloth += (": " + numCloth);
         wood += (": " + numWood);
         stone += (": " + numStone);
         metal += (": " + numMetal);
         gold += (": " + numGold);
         
         String returnString = (cloth + "\n" + wood + "\n" + stone + "\n" + metal + "\n" + gold);
         
         return returnString;
    }
}
