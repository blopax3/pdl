package com.example.stateMachine;

import java.lang.reflect.AnnotatedType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //a(!+a)*(bc*(m+n+ñ+o+p+q))(!+(bc*(m+n+ñ+o+p+q)))*
        // Escribir Leer Asignar

        // Alphabets

        List<Character> lowerCaseAlphabet = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');
        List<Character> capitalCaseAlphabet = Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');
        List<Character> accentsAlphabet = Arrays.asList('á', 'Á', 'é', 'É', 'í', 'Í', 'ó', 'Ó', 'ú', 'Ú');
        List<Character> numberAlphabet = Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
        List<Character> specialCharactersAlphabet = Arrays.asList(' ', '!', '"', '#', '$', '%', '&', '(', ')', '*', '+', ',', '-', '.', '/', ':', ';', '?', '¿', '\'');

        // pseint alphabet
        List<Character> pseintAlphabet = new ArrayList<>();
        pseintAlphabet.addAll(lowerCaseAlphabet);
        pseintAlphabet.addAll(capitalCaseAlphabet);
        pseintAlphabet.addAll(accentsAlphabet);
        pseintAlphabet.addAll(numberAlphabet);
        pseintAlphabet.addAll(specialCharactersAlphabet);


        // lower and Capital Case Letters (reserves words)
        List<Character> lowerCapitalAlphabet = new ArrayList<>();
        lowerCapitalAlphabet.addAll(lowerCaseAlphabet);
        lowerCapitalAlphabet.addAll(capitalCaseAlphabet);

        // numbers (numerics data type)
        List<Character> numericAlphabet = new ArrayList<>();
        numericAlphabet.addAll(numberAlphabet);
        numericAlphabet.add('-');
        numericAlphabet.add('.');

        // String (Character data type)
        List<Character> characterAlphabet = new ArrayList<>();
        characterAlphabet.addAll(lowerCapitalAlphabet);
        characterAlphabet.addAll(numberAlphabet);
        characterAlphabet.addAll(specialCharactersAlphabet);


        // Dada una cadena de texto de entrada, analizarla para determinar si esa cadena de texto
        // cumple con la ER original de los ejemplos del enunciado.


        // Escribir --> (E+e)(S+s)(C+c)(R+r)(I+i)(B+b)(I+i)(R+r)

        // Leer --> (L+l)(E+e)(E+e)(R+r)

        // Asignar --> (A+a)(S+s)(I+i)(G+g)(N+n)(A+a)(R+r)


        // ######## TIPOS DE DATOS

        // ### Numerico(enteros, reales) -> -?[0-9]* // -?[0-9]*(.[0-9]*)? --> (!+-)(0+1+2+3+4+5+6+7+8+9)(0+1+2+3+4+5+6+7+8+9)*(!+.(0+1+2+3+4+5+6+7+8+9)(0+1+2+3+4+5+6+7+8+9)*)

        // ### Logico (VERDADERO, FALSO)

        // VERDADERO --> (V+v)(E+e)(R+r)(D+d)(A+a)(D+d)(E+e)(R+r)(O+o)

        // FALSO --> (F+f)(A+a)(L+l)(S+s)(O+o)


        // ### Carácter -> "[a-9]*" // '[a-9*]' -> "(a+b+c+d+e+f+g+h+i+j+k+l+m+n+ñ+o+p+q+r+s+t+u+v+w+x+y+z+A+B+C+D+E+F+G+H+I+J+K+L+M+N+Ñ+O+P+Q+R+S+T+U+V+W+X+Y+Z+0+1+2+3+4+5+6+7+8+9+@+#+$+%+,+-+.+/+:+;+?+¿+ +"+')*"


        Automaton exampleAutomaton = new Automaton("exampleAutomaton", lowerCaseAlphabet);
        //
        Automaton writeAutomaton = new Automaton("writeAutomaton", pseintAlphabet);
        Automaton readAutomaton = new Automaton("readAutomaton", pseintAlphabet);
        Automaton assignAutomaton = new Automaton("assignAutomaton", pseintAlphabet);
        Automaton[] reservedWords = {writeAutomaton, readAutomaton, assignAutomaton};
        //
        Automaton numericAutomaton = new Automaton("numericAutomaton", pseintAlphabet);
        Automaton trueAutomaton = new Automaton("trueAutomaton", pseintAlphabet);
        Automaton falseAutomaton = new Automaton("falseAutomaton", pseintAlphabet);
        Automaton[] logic = {trueAutomaton, falseAutomaton};
        Automaton charAutomaton = new Automaton("charAutomaton", pseintAlphabet);



        // COMPROBACIONES ENUNCIADO
        //
        StateMachine strExample = new StateMachine(exampleAutomaton, "abcccñ");
        System.out.println(strExample.checkString());
        //
        StateMachine reservedWord = new StateMachine(reservedWords, "AsignaR");
        System.out.println(reservedWord.reservedWord());
        //
        StateMachine dataType = new StateMachine(numericAutomaton, logic, charAutomaton, "\"Hola, ¿Que tal estas?. 'a' es diferente de \"a\"\"");
        System.out.println(dataType.basicDataType());
    }
}
