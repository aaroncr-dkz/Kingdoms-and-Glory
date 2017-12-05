/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.view;

import java.io.PrintWriter;
import kingdoms.and.glory.KingdomsAndGlory;

/**
 *
 * @author bradclegg
 */
public class ErrorView {
    
    private static final PrintWriter errorFile = KingdomsAndGlory.getOutFile();
    private static final PrintWriter logFile = KingdomsAndGlory.getLogFile();
    
    public ErrorView() {
        
    }
    
    public static void display(String className, String errorMessage) {
        errorFile.println("----------------------------------------------------"
                        + "\n- ERROR - " + errorMessage
                        + "\n----------------------------------------------------");
        
        // log error
        logFile.println(className + " - " + errorMessage);
    }
}
