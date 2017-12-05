/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingdoms.and.glory;

import cit260.model.Game;
import cit260.model.Player;
import cit260.view.StartProgramView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bradclegg
 */
public class KingdomsAndGlory {

    private static Game currentGame = null;
    private static Player player = null;

    private static PrintWriter outFile = null;
    private static BufferedReader inFile = null;
    
    private static PrintWriter logFile = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            inFile = new BufferedReader(new InputStreamReader(System.in));
            outFile = new PrintWriter(System.out, true);
            
            // open log file
            String filePath = "log.txt";
            logFile = new PrintWriter(filePath);

            StartProgramView startProgramView = new StartProgramView();
            startProgramView.display();
        } 
        catch (Throwable te) {
            System.out.println(te.getMessage());
            te.printStackTrace();
        } 
        finally {
            try {
                if(inFile != null) {
                    inFile.close();
                }
                if (outFile != null) {
                    outFile.close();
                }
                
                if (logFile != null) {
                    logFile.close();
                }
            } 
            catch (IOException ex) {
                Logger.getLogger(KingdomsAndGlory.class.getName()).log(Level.SEVERE, null, ex);
            }

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

    public static PrintWriter getOutFile() {
        return outFile;
    }

    public static void setOutFile(PrintWriter outFile) {
        KingdomsAndGlory.outFile = outFile;
    }

    public static BufferedReader getInFile() {
        return inFile;
    }

    public static void setInFile(BufferedReader inFile) {
        KingdomsAndGlory.inFile = inFile;
    }

    public static PrintWriter getLogFile() {
        return logFile;
    }

    public static void setLogFile(PrintWriter logFile) {
        KingdomsAndGlory.logFile = logFile;
    }

    
}
