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
public class ExamineWildernesScene extends ExamineScene implements Serializable{
    
    private Boolean exploreRisk;
    private String exploreEventBad;
    private String exploreEventGood;
    
    public ExamineWildernesScene() {
    }

    public Boolean getExploreRisk() {
        return exploreRisk;
    }

    public void setExploreRisk(Boolean exploreRisk) {
        this.exploreRisk = exploreRisk;
    }

    /*--------------------------------------------------------------------------
    * Explore Events Getter and Setters
    ---------------------------------------------------------------------------*/
    public String getExploreEventBad() {
        return exploreEventBad;
    }

    public void setExploreEventBad(String exploreEventBad) {
        this.exploreEventBad = exploreEventBad;
    }

    public String getExploreEventGood() {
        return exploreEventGood;
    }

    public void setExploreEventGood(String exploreEventGood) {
        this.exploreEventGood = exploreEventGood;
    }

    
}
