/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author bradclegg
 */
public class Army implements Serializable{
    
    private long numSoldiers;
    private int militaryPower;
    private ArrayList<ArmyMember> armyMembers;
    
    public Army() {
        this.armyMembers = new ArrayList<>();
        ArmyMember[] uniques = new ArmyMember[25];
        
        
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

    public ArrayList<ArmyMember> getArmyMembers() {
        return armyMembers;
    }

    public void setArmyMembers(ArrayList<ArmyMember> armyMembers) {
        this.armyMembers = armyMembers;
    }

    @Override
    public String toString() {
        return "Army{" + "numSoldiers=" + numSoldiers + ", militaryPower=" + militaryPower + ", armyMembers=" + armyMembers + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (int) (this.numSoldiers ^ (this.numSoldiers >>> 32));
        hash = 97 * hash + this.militaryPower;
        hash = 97 * hash + Objects.hashCode(this.armyMembers);
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
        if (!Objects.equals(this.armyMembers, other.armyMembers)) {
            return false;
        }
        return true;
    }

    
}
