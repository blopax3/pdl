package com.example.stateMachine;

public class Main {

    public static void main(String[] args) {
        //a(!+a)*(bc*(m+n+o+p+q))(!+(bc*(m+n+ñ+o+p+q)))*
        StateMachine st = new StateMachine("aabcñ");
        System.out.println(st.checkString());
    }
}
