package com.example.mathquiz;

import java.util.Random;

public class Question {

    private int number1;
    private int number2;

    private int answer;

    private int [] answerArray;

    private int answerPosition;

    private int upperLimit;

    private String questionPhrase;

    public Question(int upperLimit){
        this.upperLimit = upperLimit;

        Random randomNumber = new Random();

        this.number1 = randomNumber.nextInt(upperLimit);
        this.number2 = randomNumber.nextInt(upperLimit);
        this.answer = this.number1 + this.number2;
        this.questionPhrase = number1 + " + " + number2 + " = ";

        this.answerPosition = randomNumber.nextInt(4);
        this.answerArray = new int[] {0, 1, 2, 3};

        this.answerArray[0] = answer + 1;
        this.answerArray[1] = answer + 5;
        this.answerArray[2] = answer - 3;
        this.answerArray[3] = answer - 1;

        this.answerArray = shuffleArray(this.answerArray);

        answerArray[answerPosition] = answer;
    }

    private int [] shuffleArray(int [] array){
        int index, temp;

        Random randomNumber = new Random();

        for(int i = array.length -1; i > 0; i-- ){
            index = randomNumber.nextInt(i + 1);
            temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
        return array;
    }


    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }


    public int getNumber1() {
        return number1;
    }

    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public int getNumber2() {
        return number2;
    }

    public void setNumber2(int number2) {
        this.number2 = number2;
    }

    public int[] getAnswerArray() {
        return answerArray;
    }

    public void setAnswerArray(int[] answerArray) {
        this.answerArray = answerArray;
    }

    public int getAnswerPosition() {
        return answerPosition;
    }

    public void setAnswerPosition(int answerPosition) {
        this.answerPosition = answerPosition;
    }

    public int getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(int upperLimit) {
        this.upperLimit = upperLimit;
    }

    public String getQuestionPhrase() {
        return questionPhrase;
    }

    public void setQuestionPhrase(String questionPhrase) {
        this.questionPhrase = questionPhrase;
    }
}
