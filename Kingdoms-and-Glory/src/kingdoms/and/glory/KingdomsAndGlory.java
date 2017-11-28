/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdoms.and.glory;

import cit260.model.Game;
import cit260.model.Player;
import cit260.view.StartProgramView;

/**
 *
 * @author bradclegg
 */
public class KingdomsAndGlory {

    private static Game currentGame = null;
    private static Player player = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
        StartProgramView startProgramView = new StartProgramView();
        startProgramView.display();
        }
        catch(Throwable te) {
            System.out.println(te.getMessage());
            te.printStackTrace();
        }
    }

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        KingdomsAndGlory.currentGame = currentGame;
    }

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        KingdomsAndGlory.player = player;
    }
}
