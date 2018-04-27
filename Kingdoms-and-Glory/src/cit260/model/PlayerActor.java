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
    
    private int charisma = 0;
    private int diplomacy = 0;
    private int strategy = 0;
    
    
    public PlayerActor() {
    }

    /*--------------------------------------------------------------------------
    * getter, setter, and modify for Charisma
    --------------------------------------------------------------------------*/
    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public void modifyCharisma(int change) {
        this.charisma += change;
    }
    /*--------------------------------------------------------------------------
    * getter, setter, and modify for Diplomacy
    --------------------------------------------------------------------------*/
    public int getDiplomacy() {
        return diplomacy;
    }

    public void setDiplomacy(int diplomacy) {
        this.diplomacy = diplomacy;
    }

    public void modifyDiplomacy(int change) {
        this.diplomacy += change;
    }
    /*--------------------------------------------------------------------------
    * getter, setter, and modify for Strategy
    --------------------------------------------------------------------------*/
    public int getStrategy() {
        return strategy;
    }

    public void setStrategy(int strategy) {
        this.strategy = strategy;
    }
    
    public void modifyStrategy(int change) {
        this.strategy += change;
    }
}
