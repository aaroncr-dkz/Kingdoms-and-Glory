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
public class AttackScene extends DefaultScene implements Serializable{
    
    private int enemyStrength;
    private String enemyLeader;
    private long victoryReward;
    
    public AttackScene() {
    }
    
    public AttackScene(Resource resource) {
        
    }

    public int getEnemyStrength() {
        return enemyStrength;
    }

    public void setEnemyStrength(int enemyStrength) {
        this.enemyStrength = enemyStrength;
    }

    public String getEnemyLeader() {
        return enemyLeader;
    }

    public void setEnemyLeader(String enemyLeader) {
        this.enemyLeader = enemyLeader;
    }

    public long getVictoryReward() {
        return victoryReward;
    }

    public void setVictoryReward(long victoryReward) {
        this.victoryReward = victoryReward;
    }

    @Override
    public String toString() {
        return "AttackScene{" + "enemyStrength=" + enemyStrength + ", enemyLeader=" + enemyLeader + ", victoryReward=" + victoryReward + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.enemyStrength;
        hash = 29 * hash + Objects.hashCode(this.enemyLeader);
        hash = 29 * hash + (int) (this.victoryReward ^ (this.victoryReward >>> 32));
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
        final AttackScene other = (AttackScene) obj;
        if (this.enemyStrength != other.enemyStrength) {
            return false;
        }
        if (this.victoryReward != other.victoryReward) {
            return false;
        }
        if (!Objects.equals(this.enemyLeader, other.enemyLeader)) {
            return false;
        }
        return true;
    }
    
    
}
