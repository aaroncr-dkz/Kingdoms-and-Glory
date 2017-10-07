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
public class Questionnaire implements Serializable {
    
    private int numToAnswer = 6;
    private int quizResult;
    
    public Questionnaire() {
    }

    public int getNumToAnswer() {
        return numToAnswer;
    }

    public void setNumToAnswer(int numToAnswer) {
        this.numToAnswer = numToAnswer;
    }

    public int getQuizResult() {
        return quizResult;
    }

    public void setQuizResult(int quizResult) {
        this.quizResult = quizResult;
    }

    @Override
    public String toString() {
        return "Questionnaire{" + "numToAnswer=" + numToAnswer + ", quizResult=" + quizResult + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.numToAnswer;
        hash = 89 * hash + this.quizResult;
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
        final Questionnaire other = (Questionnaire) obj;
        if (this.numToAnswer != other.numToAnswer) {
            return false;
        }
        if (this.quizResult != other.quizResult) {
            return false;
        }
        return true;
    }

    
}
