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
public class ExamineScene extends DefaultScene implements Serializable{
    
    private long potentialGains;
    
    public ExamineScene() {
        
    }

    public long getPotentialGains() {
        return potentialGains;
    }

    public void setPotentialGains(long potentialGains) {
        this.potentialGains = potentialGains;
    }

    @Override
    public String toString() {
        return "ExamineScene{" + "potentialGains=" + potentialGains + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + (int) (this.potentialGains ^ (this.potentialGains >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ExamineScene other = (ExamineScene) obj;
        if (this.potentialGains != other.potentialGains) {
            return false;
        }
        return true;
    }
    
    
}
