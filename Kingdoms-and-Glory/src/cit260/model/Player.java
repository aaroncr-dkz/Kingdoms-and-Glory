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
 * @author aaroncr-dkz
 */
public class Player implements Serializable {
    
    private String name;
    private String title;
    private Actor playerCharacter;
    private int leaderValue;
    
    public Player() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Actor getPlayerCharacter() {
        return playerCharacter;
    }

    public void setPlayerCharacter(Actor playerCharacter) {
        this.playerCharacter = playerCharacter;
    }
    
     public int getLeaderValue() {
        return leaderValue;
    }

    public void setLeaderValue(int leaderValue) {
        this.leaderValue = leaderValue;
    }

    @Override
    public String toString() {
        return "Player{" + "name=" + name + ", title=" + title + ", playerCharacter=" + playerCharacter + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.name);
        hash = 13 * hash + Objects.hashCode(this.title);
        hash = 13 * hash + Objects.hashCode(this.playerCharacter);
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
        final Player other = (Player) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.playerCharacter, other.playerCharacter)) {
            return false;
        }
        return true;
    }

    

    
    
    
    
    
}
