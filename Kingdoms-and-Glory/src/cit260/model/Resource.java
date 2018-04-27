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
public class Resource implements Serializable {
    
    private String name;
    private int amount;
    
    public Resource() {
    }
    
    public Resource(String name, int amount) {
        this.name = name;
        this.amount = amount; 
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    public void modifyAmount(int amount) {
        this.amount += amount;
        
        // prevent the resource from going below 0
        if (this.amount < 0) {
            this.amount = 0;
        }
    }
}
