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
public class ExamineCityScene extends ExamineScene implements Serializable {
    
    private int estimatedOpposition;
    private String resourcesNeeded;
    private Resource resource;
    
    public ExamineCityScene() {
        
    }

    public int getEstimatedOpposition() {
        return estimatedOpposition;
    }

    public void setEstimatedOpposition(int estimatedOpposition) {
        this.estimatedOpposition = estimatedOpposition;
    }

    public String getResourcesNeeded() {
        return resourcesNeeded;
    }

    public void setResourcesNeeded(String resourcesNeeded) {
        this.resourcesNeeded = resourcesNeeded;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }
    
    

    @Override
    public String toString() {
        return "ExamineCityScene{" + "estimatedOpposition=" + estimatedOpposition + ", resourcesNeeded=" + resourcesNeeded + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.estimatedOpposition;
        hash = 29 * hash + Objects.hashCode(this.resourcesNeeded);
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
        final ExamineCityScene other = (ExamineCityScene) obj;
        if (this.estimatedOpposition != other.estimatedOpposition) {
            return false;
        }
        if (!Objects.equals(this.resourcesNeeded, other.resourcesNeeded)) {
            return false;
        }
        return true;
    }
    
    
}
