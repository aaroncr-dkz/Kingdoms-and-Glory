/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.model;

import java.io.Serializable;

/**
 *
 * @author aaroncr-dkz
 */
public class Territory implements Serializable {
    
    private int row;
    private int column;
    private String name;
    private String symbol;
    private Boolean visited;
    private ExamineCityScene sceneExamineCity;
    private ExamineWildernesScene sceneExamineWilderness;
    private AttackScene sceneAttack;
    private CapturedScene sceneCaptured;
    
    public Territory() {
    }
    
    public Territory(int row, int column) {
        this.row = row;
        this.column = column;
        this.visited = false;
    }
    
    /*--------------------------------------------------------------------------
    * Row and Column Getters and Setters
    *-------------------------------------------------------------------------*/

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    /*--------------------------------------------------------------------------
    * Name, Symbol, and Visited Getters and Setters
    *-------------------------------------------------------------------------*/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Boolean getVisited() {
        return visited;
    }

    public void setVisited(Boolean visited) {
        this.visited = visited;
    }

    /*--------------------------------------------------------------------------
    * Scene Getter and Setters
    *-------------------------------------------------------------------------*/
    public ExamineCityScene getSceneExamineCity() {
        return sceneExamineCity;
    }

    public void setSceneExamineCity(ExamineCityScene sceneExamineCity) {
        this.sceneExamineCity = sceneExamineCity;
    }

    public ExamineWildernesScene getSceneExamineWilderness() {
        return sceneExamineWilderness;
    }

    public void setSceneExamineWilderness(ExamineWildernesScene sceneExamineWilderness) {
        this.sceneExamineWilderness = sceneExamineWilderness;
    }

    public AttackScene getSceneAttack() {
        return sceneAttack;
    }

    public void setSceneAttack(AttackScene sceneAttack) {
        this.sceneAttack = sceneAttack;
    }

    public CapturedScene getSceneCaptured() {
        return sceneCaptured;
    }

    public void setSceneCaptured(CapturedScene sceneCaptured) {
        this.sceneCaptured = sceneCaptured;
    }

    

}
