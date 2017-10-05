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
public class Game implements Serializable {
    
    private Boolean enemyCapitalCaptured;
    private Map map = new Map();
    
    public Game() {
    
}

    public Boolean isEnemyCapitalCaptured() {
        return enemyCapitalCaptured;
    }

    public void setEnemyCapitalCaptured(Boolean enemyCapitalCaptured) {
        this.enemyCapitalCaptured = enemyCapitalCaptured;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }
    
    

    @Override
    public String toString() {
        return "Game{" + "enemyCapitalCaptured=" + enemyCapitalCaptured + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.enemyCapitalCaptured);
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
        final Game other = (Game) obj;
        if (!Objects.equals(this.enemyCapitalCaptured, other.enemyCapitalCaptured)) {
            return false;
        }
        return true;
    }
    
    
    
}
