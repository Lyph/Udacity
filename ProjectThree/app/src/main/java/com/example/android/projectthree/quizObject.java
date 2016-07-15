package com.example.android.projectthree;

/**
 * Created by lyphc on 7/12/2016.
 */
public class quizObject {

    String question;
    String A,B,C,D;
    String correct = ""; // tells what position is correct 0 = a etc.
    String input = "";
    int questionType;
    int point; //allocate points (0 or 1) needed for on click listener


    quizObject(){
        question = "test";
        A = "test";
        B = "test";
        C = "test";
        D = "test";
        point = -1000;

    }
    quizObject(String textQ, String textA, String textB, String textC, String textD, String cor){
        question = textQ;
        A = textA;
        B = textB;
        C = textC;
        D = textD;
        point = -1000;
        correct = cor;
        ;
    }



    public String getQuestion() {return question;}
    public String getA() {return A;}
    public String getB() {return B;}
    public String getC() {return C;}
    public String getD() {return D;}
    public void setPoint(int pt){point = pt;}           public int getPoint(){return point;}
    public void setCorrect(String cor){correct = cor;}  public String getCorrect() {return correct;}
    public void setInput(String in) {input = in;}       public String getInput() {return input;}


}
