package com.example.stateMachine;

public class Main {

    public static void main(String[] args) {
        //a(!+a)*(bc*(m+n+ñ+o+p+q))(!+(bc*(m+n+ñ+o+p+q)))*
        StateMachine st = new StateMachine("aaabcñbobcccpbcnbmbcmbccpbcqbqbcñbñbcccco");
        System.out.println(st.checkString());
    }
}
