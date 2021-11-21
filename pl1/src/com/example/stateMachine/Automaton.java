package com.example.stateMachine;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class Automaton {

    // Alfabeto
    private List<Character> alphabet;
    // Estados
    private List<Integer> states;
    // Estados finales
    private List<Integer> finalStates;
    // Estado inicial
    private int initialState;
    // Matriz de transición de estados
    private HashMap<Integer, HashMap<Character, Integer>> matrix;
    // Generador de las estructuras de datos
    private ReadJflap rj;

    public Automaton(String name, List<Character> alphabet) {
        this.rj = new ReadJflap(name);
        this.alphabet = alphabet;
        rj.generateData();
        this.states = rj.getStates();
        this.finalStates = rj.getFinalStates();
        this.matrix = rj.getMatrix();
        //
        setInitialState();
    }


    // Inicializa el estado inicial a 0
    public void setInitialState() {
        initialState = 0;
    }

    // Devuelve el estado inicial
    public Integer getInitialState() {
        return initialState;
    }

    // Devuelve el siguiente estado a partir del carácter pasado y la matriz de transición de estados
    public Integer getNextState(Integer state, Character character) {
        return matrix.get(state).get(character);
    }

    // Devuelve si un estado es final
    public boolean isFinalState(Integer state) {
        return finalStates.contains(state);
    }

    // Comprueba si un carácter dado se encuentra en el alfabeto
    public boolean charInAlphabet(Character character) {
        return alphabet.contains(character);
    }
}
