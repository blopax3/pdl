package com.example.stateMachine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Automaton {

    private List<Character> alphabet;
    private List<Integer> states;
    private List<Integer> finalStates;
    private int initialState;
    private HashMap<Integer, HashMap<Character, Integer>> matrix;
    private String name;
    private ReadJflap rj;

    public Automaton(String name, List<Character> alphabet) {
        this.name = name;
        this.rj = new ReadJflap(name);
        this.alphabet = alphabet;
        rj.generateData();
        this.states = rj.getStates();
        this.finalStates = rj.getFinalStates();
        this.matrix = rj.getMatrix();


        for (int i = 0; i < this.states.size(); i++) {
            states.get(i);
        }

        //

        setInitialState();
    }


    public void setInitialState() {
        initialState = 0;
    }

    public Integer getInitialState() {
        return initialState;
    }

    public Integer getNextState(Integer state, Character character) {
        return matrix.get(state).get(character);
    }

    public boolean isFinalState(Integer state) {
        return finalStates.contains(state);
    }

    public boolean charInAlphabet(Character character) {
        return alphabet.contains(character);
    }
}
