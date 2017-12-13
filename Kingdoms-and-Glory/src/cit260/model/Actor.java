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
public class Actor implements Serializable {
    
    protected String name;
    protected String description;
    protected Territory location;
    
    public Actor() {
    }
    
    public Actor(String name, String description) {
        this.name = name;
        this.description = description;
        this.location = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Territory getLocation() {
        return location;
    }

    public void setLocation(Territory location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Actor{" + "name=" + name + ", description=" + description + ", location=" + location + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.name);
        hash = 67 * hash + Objects.hashCode(this.description);
        hash = 67 * hash + Objects.hashCode(this.location);
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
        final Actor other = (Actor) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.location, other.location)) {
            return false;
        }
        return true;
    }

    
}
