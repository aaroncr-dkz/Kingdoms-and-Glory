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
public class armyMember implements Serializable{
    
    private int power;
    private String classification;
    private Army army;
    
    public armyMember() {
        
    }

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

    public Army getArmy() {
        return army;
    }

    public void setArmy(Army army) {
        this.army = army;
    }

    @Override
    public String toString() {
        return "armyMember{" + "power=" + power + ", classification=" + classification + ", army=" + army + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.power;
        hash = 79 * hash + Objects.hashCode(this.classification);
        hash = 79 * hash + Objects.hashCode(this.army);
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
        final armyMember other = (armyMember) obj;
        if (this.power != other.power) {
            return false;
        }
        if (!Objects.equals(this.classification, other.classification)) {
            return false;
        }
        if (!Objects.equals(this.army, other.army)) {
            return false;
        }
        return true;
    }
    
    
}
