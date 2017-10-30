/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.control;

import cit260.model.Player;
import cit260.model.Question;
import kingdoms.and.glory.KingdomsAndGlory;

/**
 *
 * @author aaroncr-dkz
 */
public class GameControl {
    
    public static void createNewGame(Player player) {
        
    }
    
    public static Player savePlayer(String name) {
        if (name == null || name.length() < 1) {
            return null;
        }
        
        Player player = new Player();
        player.setName(name);
        
        KingdomsAndGlory.setPlayer(player);
        
        System.out.println("*** savePlayer() called ***");
                return player;
    }
    
    public static String acquireQuestion(int questionNum) {
        
        String questionText;
        
        switch (questionNum) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
        }
        
        
        return "hello";
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

}
