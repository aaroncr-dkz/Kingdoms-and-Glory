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
public class Army implements Serializable{
    
    private long numSoldiers;
    private int militaryPower;
    
    public Army() {
    }

    public long getNumSoldiers() {
        return numSoldiers;
    }

    public void setNumSoldiers(long numSoldiers) {
        this.numSoldiers = numSoldiers;
    }

    public int getMilitaryPower() {
        return militaryPower;
    }

    public void setMilitaryPower(int militaryPower) {
        this.militaryPower = militaryPower;
    }

    @Override
    public String toString() {
        return "Army{" + "numSoldiers=" + numSoldiers + ", militaryPower=" + militaryPower + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + (int) (this.numSoldiers ^ (this.numSoldiers >>> 32));
        hash = 37 * hash + this.militaryPower;
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
        final Army other = (Army) obj;
        if (this.numSoldiers != other.numSoldiers) {
            return false;
        }
        if (this.militaryPower != other.militaryPower) {
            return false;
        }
        return true;
    }
    
    
    
}
