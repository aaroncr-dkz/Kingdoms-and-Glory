/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.exception;

/**
 *
 * @author bradclegg
 */
public class ArmyControlException extends Exception {
    
    public ArmyControlException() {
        
    } 
    
    public ArmyControlException(String message) {
        super(message);
    }
    
    public ArmyControlException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public ArmyControlException(Throwable cause) {
        super(cause);
    }
    
    public ArmyControlException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
