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
public class Map implements Serializable{
    
    private int currentRow;
    private int currentColumn;
    
    public Map() {
        
    }

    public int getCurrentRow() {
        return currentRow;
    }

    public void setCurrentRow(int currentRow) {
        this.currentRow = currentRow;
    }

    public int getCurrentColumn() {
        return currentColumn;
    }

    public void setCurrentColumn(int currentColumn) {
        this.currentColumn = currentColumn;
    }

    @Override
    public String toString() {
        return "Map{" + "currentRow=" + currentRow + ", currentColumn=" + currentColumn + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + this.currentRow;
        hash = 23 * hash + this.currentColumn;
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
        final Map other = (Map) obj;
        if (this.currentRow != other.currentRow) {
            return false;
        }
        if (this.currentColumn != other.currentColumn) {
            return false;
        }
        return true;
    }
    
    
           
}

