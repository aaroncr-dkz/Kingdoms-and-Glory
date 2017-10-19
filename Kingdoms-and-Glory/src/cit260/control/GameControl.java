/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.control;

/**
 *
 * @author aaroncr-dkz
 */
public class GameControl {

    public static String determineTitle(int charisma, int diplomacy, int strategy) {
        String title = "";
        int attitude;

        if (charisma + diplomacy + strategy > 6) {
            return "Error";
        } else if (charisma < 0 || diplomacy < 0 || strategy < 0) {
            return "Error";
        } else if (charisma > 6 || diplomacy > 6 || strategy > 6) {
            return "Error";
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