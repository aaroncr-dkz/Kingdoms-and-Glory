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
public class Game implements Serializable {
    
    private Boolean enemyCapitalCaptured = false;
    private Map map;
    private Questionnaire quiz;
    private Player player;
    private Army army;
    private ArrayList<Resource> resources = new ArrayList<>();
    
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

    public Questionnaire getQuiz() {
        return quiz;
    }

    public void setQuiz(Questionnaire quiz) {
        this.quiz = quiz;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Army getArmy() {
        return army;
    }

    public void setArmy(Army army) {
        this.army = army;
    }

    public ArrayList<Resource> getResources() {
        return resources;
    }

    public void setResources(ArrayList<Resource> resources) {
        this.resources = resources;
    }
    
    
    @Override
    public String toString() {
        return "Game{" + "enemyCapitalCaptured=" + enemyCapitalCaptured + ", map=" + map + ", quiz=" + quiz + ", player=" + player + ", army=" + army + ", resources=" + resources + '}';
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.enemyCapitalCaptured);
        hash = 97 * hash + Objects.hashCode(this.map);
        hash = 97 * hash + Objects.hashCode(this.quiz);
        hash = 97 * hash + Objects.hashCode(this.player);
        hash = 97 * hash + Objects.hashCode(this.army);
        hash = 97 * hash + Objects.hashCode(this.resources);
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
        if (!Objects.equals(this.map, other.map)) {
            return false;
        }
        if (!Objects.equals(this.quiz, other.quiz)) {
            return false;
        }
        if (!Objects.equals(this.player, other.player)) {
            return false;
        }
        if (!Objects.equals(this.army, other.army)) {
            return false;
        }
        if (!Objects.equals(this.resources, other.resources)) {
            return false;
        }
        return true;
    }

    
    
}
