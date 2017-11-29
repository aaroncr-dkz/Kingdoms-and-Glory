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
}
