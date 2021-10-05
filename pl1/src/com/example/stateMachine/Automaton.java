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

    public Automaton() {
        alphabet = new ArrayList<Character>();
        states = new ArrayList<Integer>();
        finalStates = new ArrayList<Integer>();
        initialState = 0;
        matrix = new HashMap<Integer, HashMap<Character, Integer>>();

        //

        loadAlphabet();
        loadStates();
        initializeMatrix();
        loadMatrix();
        setInitialState();
        setFinalStates();
    }

    public void initializeMatrix() {
        for (int i = 0; i < states.size(); i++) {
            matrix.put(states.get(i), new HashMap<Character, Integer>());
        }
    }

    public void loadMatrix() {
        matrix.get(0).put('a', 1);
        matrix.get(1).put('a', 2);
        matrix.get(1).put('b', 3);
        matrix.get(2).put('a', 2);
        matrix.get(2).put('b', 3);
        matrix.get(3).put('c', 5);
        matrix.get(3).put('d', 8);
        matrix.get(3).put('m', 7);
        matrix.get(3).put('n', 6);
        matrix.get(3).put('o', 4);
        matrix.get(3).put('q', 9);
        matrix.get(4).put('b', 10);
        matrix.get(5).put('c', 5);
        matrix.get(5).put('m', 7);
        matrix.get(5).put('o', 7);
        matrix.get(5).put('p', 8);
        matrix.get(5).put('q', 9);
        matrix.get(6).put('b', 10);
        matrix.get(7).put('b', 10);
        matrix.get(8).put('b', 10);
        matrix.get(9).put('b', 10);
        matrix.get(10).put('c', 12);
        matrix.get(10).put('m', 14);
        matrix.get(10).put('n', 13);
        matrix.get(10).put('o', 11);
        matrix.get(10).put('p', 15);
        matrix.get(10).put('q', 16);
        matrix.get(11).put('b', 10);
        matrix.get(12).put('c', 12);
        matrix.get(12).put('m', 14);
        matrix.get(12).put('n', 13);
        matrix.get(12).put('o', 11);
        matrix.get(12).put('p', 15);
        matrix.get(12).put('q', 16);
        matrix.get(13).put('b', 10);
        matrix.get(14).put('b', 10);
        matrix.get(15).put('b', 10);
        matrix.get(16).put('b', 10);


    }

    public void loadAlphabet() {
        for (int i = 97; i < 123; i++) {
            alphabet.add((char)i);
        }
        alphabet.add('ñ');
    }

    public void loadStates() {
        for (int i=0; i < 17; i++) {
            states.add(i);
        }
    }

    public void setInitialState() {
        initialState = 0;
    }

    public Integer getInitialState() {
        return initialState;
    }

    public void setFinalStates() {
        finalStates.add(4);
        finalStates.add(6);
        finalStates.add(8);
        finalStates.add(9);
        finalStates.add(11);
        finalStates.add(13);
        finalStates.add(14);
        finalStates.add(15);
        finalStates.add(16);
    }

    public Integer getNextState(Integer state, Character character) {
        return matrix.get(state).get(character);
    }

    public boolean isFinalState(Integer state) {
        return finalStates.contains(state);
    }
}
