/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author bradclegg
 */
public class ArmyMember implements Serializable {
    
    public ArmyMember() {
        
    }
    
    private int power;
    private String classification; 
   
    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }


    @Override
    public String toString() {
        return "ArmyMember{" + "power=" + power + ", classification=" + classification + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.power;
        hash = 13 * hash + Objects.hashCode(this.classification);;
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
        final ArmyMember other = (ArmyMember) obj;
        if (this.power != other.power) {
            return false;
        }
        if (!Objects.equals(this.classification, other.classification)) {
            return false;
        }
        return true;
    }
} 