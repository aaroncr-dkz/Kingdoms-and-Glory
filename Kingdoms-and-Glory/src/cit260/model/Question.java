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
    
    Question1("What is your favorite color?","red","green","blue"),
    Question2("","","",""),
    Question3("","","",""),
    Question4("","","",""),
    Question5("","","",""),
    Question6("","","","");
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
