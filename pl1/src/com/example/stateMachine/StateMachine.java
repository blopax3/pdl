package com.example.stateMachine;

import java.sql.SQLOutput;

public class StateMachine {

    private Integer actualState;
    private Automaton dfa;
    private String s;

    // Reserved word

    private Automaton[] reservedWords;

    // Data types

    private Automaton numeric;
    private Automaton[] logic;
    private Automaton character;


    public StateMachine(Automaton dfa, String s) {
        this.dfa = dfa;
        this.s = s;
        initialize();
    }

    public StateMachine(Automaton numeric, Automaton[] logic, Automaton character, String s) {
        this.numeric = numeric;
        this.logic = logic;
        this.character = character;
        //
        this.s = s;
    }
    public StateMachine(Automaton[] reservedWords, String s) {
        this.reservedWords = reservedWords;
        //
        this.s = s;
    }

    public void initialize() {
        actualState = dfa.getInitialState();
    }

    public boolean accept(Character character) {
        if (dfa.charInAlphabet(character)) { // character in the alphabet
            Integer tempState = dfa.getNextState(actualState, character);
            if (tempState != null) {
                actualState = tempState;
                return true;
            }
        }
        return false;
    }

    public boolean isFinal() {
        return dfa.isFinalState(actualState);
    }

    public boolean checkString() {
        int i = 0;
        boolean stop = false;
        while (i < s.length() && !stop) {
            if (accept(s.charAt(i))) {
                i++;
            } else {
                stop = true;
            }
        }
        if (stop || !isFinal()) {
            return false;
        }
        return true;
    }

    public boolean reservedWord() {
        for (int i = 0; i < reservedWords.length; i++) {
            dfa = reservedWords[i];
            initialize();
            if (checkString()) {
                return true;
            }
        }
        return false;
    }

    public String basicDataType() {
        // numeric
        dfa = numeric;
        initialize();
        if (checkString()) {
            return "La entrada se corresponde con un tipo de dato numérico";
        }
        // logic
        dfa = logic[0]; // true
        initialize();
        if (checkString()) {
            return "La entrada se corresponde con un tipo de dato lógico";
        }
        dfa = logic[1]; // false
        initialize();
        if (checkString()) {
            return "La entrada se corresponde con un tipo de dato lógico";
        }
        // character
        dfa = character;
        initialize();
        if (checkString()) {
            return "La entrada se corresponde con un tipo de dato carácter";
        }
        return "La entrada no se corresponde con ningún tipo de dato básico";
    }

}
