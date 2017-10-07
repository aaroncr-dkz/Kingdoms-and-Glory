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
public class ExamineWildernesScene extends ExamineScene implements Serializable{
    
    private Boolean exploreRisk;
    private Boolean exploreResult;
    
    public ExamineWildernesScene() {
    }

    public Boolean getExploreRisk() {
        return exploreRisk;
    }

    public void setExploreRisk(Boolean exploreRisk) {
        this.exploreRisk = exploreRisk;
    }

    public Boolean getExploreResult() {
        return exploreResult;
    }

    public void setExploreResult(Boolean exploreResult) {
        this.exploreResult = exploreResult;
    }

    @Override
    public String toString() {
        return "ExamineWildernesScene{" + "exploreRisk=" + exploreRisk + ", exploreResult=" + exploreResult + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.exploreRisk);
        hash = 23 * hash + Objects.hashCode(this.exploreResult);
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
        final ExamineWildernesScene other = (ExamineWildernesScene) obj;
        if (!Objects.equals(this.exploreRisk, other.exploreRisk)) {
            return false;
        }
        if (!Objects.equals(this.exploreResult, other.exploreResult)) {
            return false;
        }
        return true;
    }
    
    
}
