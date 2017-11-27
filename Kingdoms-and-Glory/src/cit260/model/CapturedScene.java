/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.model;

import java.io.Serializable;

/**
 *
 * @author bradclegg
 */
public class CapturedScene extends DefaultScene implements Serializable {
    
    private Boolean captured;
    
    public CapturedScene() {
        
    }

    public Boolean isCaptured() {
        return captured;
    }

    public void setCaptured(Boolean captured) {
        this.captured = captured;
    }
    
    

    
}
