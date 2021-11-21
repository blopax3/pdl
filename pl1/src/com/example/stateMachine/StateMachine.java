package com.example.stateMachine;

import java.sql.SQLOutput;

public class StateMachine {

    private Integer actualState;
    private Automaton dfa;
    private String s;

    // Palabras reservadas

    private Automaton[] reservedWords;

    // Tipos de datos básicos

    private Automaton[] numeric;
    private Automaton[] logic;
    private Automaton character;

    // Ejercicio 1
    public StateMachine(Automaton dfa, String s) {
        this.dfa = dfa;
        this.s = s;
        initialize();
    }

    // Ejercicio 2
    public StateMachine(Automaton[] reservedWords, String s) {
        this.reservedWords = reservedWords;
        //
        this.s = s;
    }

    // Ejercicio 3
    public StateMachine(Automaton[] numeric, Automaton[] logic, Automaton character, String s) {
        this.numeric = numeric;
        this.logic = logic;
        this.character = character;
        //
        this.s = s;
    }

    public void setS(String s) {
        this.s = s;
    }

    // Inicializar estado inicial
    public void initialize() {
        actualState = dfa.getInitialState();
    }

    // Comprueba si con el carácter pasado se puede pasar a un estado
    // En ese caso, retorna verdadero cambiando el estado actual al siguiente estado
    // En caso contrario, retorna falso
    public boolean accept(Character character) {
        if (dfa.charInAlphabet(character)) { // El carácter se encuentra en el alfabeto
            Integer tempState = dfa.getNextState(actualState, character); // obtener el siguiente estado a partir de la matriz de transición de estados
            if (tempState != null) { // comprobar si existe el siguiente estado
                actualState = tempState;
                return true;
            }
        }
        return false;
    }

    // Comprobar si un estado es final
    public boolean isFinal() {
        return dfa.isFinalState(actualState);
    }

    // Comprueba una cadena de caracteres carácter a carácter para ver si cumple con la expresión regular
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

    // Comprueba si un string dado se encuentra entre las palabras reservadas
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

    // Comprueba si un string dado corresponde con algún tipo de dato básico
    public String basicDataType() {
        // numeric
        dfa = numeric[0]; // integer
        initialize();
        if (checkString()) {
            return "La entrada se corresponde con un tipo de dato numérico";
        }
        dfa = numeric[1]; // float
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
