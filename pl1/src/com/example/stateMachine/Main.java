package com.example.stateMachine;

public class Main {

    public static void main(String[] args) {
        //a(!+a)*(bc*(m+n+ñ+o+p+q))(!+(bc*(m+n+ñ+o+p+q)))*
        // Escribir Leer Asignar

        // Pregunta 1

        int[][] matrix = {{0, 'a', 1}, {1, 'a', 2}, {1, 'b', 3},
                {2, 'a', 2}, {2, 'b', 3}, {3, 'c', 8},
                {3, 'm', 4}, {3, 'n', 6}, {3, 'ñ', 9},
                {3, 'o', 7}, {3, 'p', 10}, {3, 'q', 5},
                {4, 'b', 11}, {5, 'b', 11}, {6, 'b', 11},
                {7, 'b', 11}, {8, 'c', 8}, {8, 'm', 4},
                {8, 'n', 6}, {8, 'ñ', 9}, {8, 'o', 7},
                {8, 'p', 10}, {8, 'q', 5}, {9, 'b', 11},
                {10, 'b', 11}, {11, 'c', 16}, {11, 'm', 12},
                {11, 'n', 14}, {11, 'ñ', 17}, {11, 'o', 15},
                {11, 'p', 18}, {11, 'q', 13}, {12, 'b', 11},
                {13, 'b', 11}, {14, 'b', 11}, {15, 'b', 11},
                {16, 'c', 16}, {16, 'm', 12}, {16, 'n', 14},
                {16, 'ñ', 17}, {16, 'o', 15}, {16, 'p', 18},
                {16, 'q', 13}, {17, 'b', 11}, {18, 'b', 11}};
        int[] finalStates = {4, 5, 6, 7, 9, 10, 12, 13, 14, 15, 17, 18};
        int statesNumb = 19;

        // Escribir

        int[][] writeMatrix = {{0, 'E', 1}, {1, 's', 2}, {2, 'c', 3},
                {3, 'r', 4}, {4, 'i', 5}, {5, 'b', 6},
                {6, 'i', 7}, {7, 'r', 8}};
        int[] writeFinalStates = {8};
        int writeStatesNumb = 9;

        // Leer

        int[][] readMatrix = {{0, 'L', 1}, {1, 'e', 2}, {2, 'e', 3}, {3, 'r', 4}};
        int[] readFinalStates = {4};
        int readStatesNumb = 5;

        // Asignar

        int[][] assignMatrix = {{0, 'A', 1}, {1, 's', 2}, {2, 'i', 3},
                {3, 'g', 4}, {4, 'n', 5}, {5, 'a', 6}, {6, 'r', 7}};
        int[] assignFinalStates = {7};
        int assignStatesNumb = 8;


        // TIPOS DE DATOS

        // Numerico(enteros, reales) -> -?[0-9]* // -?[0-9]*.[0-9]
        // Logico (VERDADERO, FALSO)
        // Carácter -> "[a-9]*" // '[a-9*]'

        Automaton dfa = new Automaton(matrix, finalStates, statesNumb);
        Automaton write = new Automaton(writeMatrix, writeFinalStates, writeStatesNumb);
        Automaton read = new Automaton(readMatrix, readFinalStates, readStatesNumb);
        Automaton assign = new Automaton(assignMatrix, assignFinalStates, assignStatesNumb);
        StateMachine st = new StateMachine(assign, "Asignar");
        System.out.println(st.checkString());


    }
}
