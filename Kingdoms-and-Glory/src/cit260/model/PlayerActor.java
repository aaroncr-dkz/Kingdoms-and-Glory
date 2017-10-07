/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.model;

import java.io.Serializable;

/**
 *
 * @author aaroncr-dkz
 */
public class PlayerActor extends Actor implements Serializable {
    
    private int charisma;
    private int diplomacy;
    private int strategy;
    
    public PlayerActor() {
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public int getDiplomacy() {
        return diplomacy;
    }

    public void setDiplomacy(int diplomacy) {
        this.diplomacy = diplomacy;
    }

    public int getStrategy() {
        return strategy;
    }

    public void setStrategy(int strategy) {
        this.strategy = strategy;
    }

    @Override
    public String toString() {
        return "PlayerActor{" + "charisma=" + charisma + ", diplomacy=" + diplomacy + ", strategy=" + strategy + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.charisma;
        hash = 53 * hash + this.diplomacy;
        hash = 53 * hash + this.strategy;
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
        final PlayerActor other = (PlayerActor) obj;
        if (this.charisma != other.charisma) {
            return false;
        }
        if (this.diplomacy != other.diplomacy) {
            return false;
        }
        if (this.strategy != other.strategy) {
            return false;
        }
        return true;
    }
}