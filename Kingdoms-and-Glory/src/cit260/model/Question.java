/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.model;

/**
 *
 * @author bradclegg
 */
public enum Question {
    
    Emperor("The people of your kingdom rise against you. What course of action fo you take?",
              "Abdicate my throne","Treat for peace","Rally my armies"),
    
    Chariot("How do you define victory?",
            "Ending the conflict","Preserving my allies","Vanquishing my foes"),
    
    Fortune("You stand at the end of a hard-fought battle. Why have you lost?",
            "Poor leadership","Ill luck","Inadequate troops"),
    
    Justice("How would you bring together and rule two greatly different peoples?",
            "By religion","By diplomacy","By force"),
    
    Death("Among your most trusted followers, a traitor is found. What is his punishment?",
          "Banish him forever","Permanently disfigure him","Kill the traitor"),
    
    Star("Stars shoot across the night sky, for what do you wish?",
         "Happiness for myself","Peace for the world","Success for my friends");
    
    private String question;
    private String answerCharisma;
    private String answerDiplomacy;
    private String answerStratagy;
    
    Question(String question, String answerCharisma, String answerDiplomacy, String answerStratagy) {
        this.question = question;
        this.answerCharisma = answerCharisma;
        this.answerDiplomacy = answerDiplomacy;
        this.answerStratagy = answerStratagy;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswerCharisma() {
        return answerCharisma;
    }

    public void setAnswerCharisma(String answerCharisma) {
        this.answerCharisma = answerCharisma;
    }

    public String getAnswerDiplomacy() {
        return answerDiplomacy;
    }

    public void setAnswerDiplomacy(String answerDiplomacy) {
        this.answerDiplomacy = answerDiplomacy;
    }

    public String getAnswerStratagy() {
        return answerStratagy;
    }

    public void setAnswerStratagy(String answerStratagy) {
        this.answerStratagy = answerStratagy;
    }

    @Override
    public String toString() {
        return "Question{" + "question=" + question + ", answerCharisma=" + answerCharisma + ", answerDiplomacy=" + answerDiplomacy + ", answerStratagy=" + answerStratagy + '}';
    }



}
