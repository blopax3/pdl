package com.example.stateMachine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Dada una cadena de texto de entrada, analizarla para determinar si esa cadena de texto
        // cumple con la ER original de los ejemplos del enunciado.
        // a(!+a)*(bc*(m+n+ñ+o+p+q))(!+(bc*(m+n+ñ+o+p+q)))*


        // Dada una palabra reservada del lenguaje PSeInt, debe saber reconocerla como válida
        // (elija 3 palabras reservadas) o como errónea. Indique cuáles son las ER que ha elegido.
        // Escribir --> (E+e)(S+s)(C+c)(R+r)(I+i)(B+b)(I+i)(R+r)
        // Leer --> (L+l)(E+e)(E+e)(R+r)
        // Asignar --> (A+a)(S+s)(I+i)(G+g)(N+n)(A+a)(R+r)

        // Dados los tipos básicos de datos de PSEInt, debe saber reconocer a qué tipo de datos
        // corresponde una entrada. Indique cuáles son las ER que ha diseñado.
        // #TIPOS DE DATOS
        // ### Numérico(enteros, reales)
        // ENTEROS --> (-|+)?[0-9]+ ### ('-'+'+'+!)(0+1+2+3+4+5+6+7+8+9)(0+1+2+3+4+5+6+7+8+9)*
        // REALES --> (-|+)?[0-9]*.[0-9]* ### ('-'+'+'+!)(0+1+2+3+4+5+6+7+8+9)*.(0+1+2+3+4+5+6+7+8+9)*
        // ### Lógico (VERDADERO, FALSO)
        // VERDADERO --> (V|v)(E|e)(R|r)(D|d)(A|a)(D|d)(E|e)(R|r)(O|o) -> (V+v)(E+e)(R+r)(D+d)(A+a)(D+d)(E+e)(R+r)(O+o)
        // FALSO --> (F|f)(A|a)(L|l)(S|s)(O|o) -> (F+f)(A+a)(L+l)(S+s)(O+o)
        // ### Carácter --> ('|")[a-zA-z0-9@#$%,-./:;?¿"' ]*('|") -> ('+")(a+b+c+d+e+f+g+h+i+j+k+l+m+n+ñ+o+p+q+r+s+t+u+v+w+x+y+z+A+B+C+D+E+F+G+H+I+J+K+L+M+N+Ñ+O+P+Q+R+S+T+U+V+W+X+Y+Z+0+1+2+3+4+5+6+7+8+9+@+#+$+%+,+-+.+/+:+;+?+¿+ +"+')*('+")



        // Alfabetos

        List<Character> lowerCaseAlphabet = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');
        List<Character> capitalCaseAlphabet = Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');
        List<Character> numberAlphabet = Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
        List<Character> specialCharactersAlphabet = Arrays.asList(' ', '!', '"', '#', '$', '%', '&', '(', ')', '*', '+', ',', '-', '.', '/', ':', ';', '?', '¿', '\'');

        // Alfabeto pseint
        List<Character> pseintAlphabet = new ArrayList<>();
        pseintAlphabet.addAll(lowerCaseAlphabet);
        pseintAlphabet.addAll(capitalCaseAlphabet);
        pseintAlphabet.addAll(numberAlphabet);
        pseintAlphabet.addAll(specialCharactersAlphabet);

        // Ejercicio 1
        Automaton exampleAutomaton = new Automaton("exampleAutomaton", lowerCaseAlphabet);
        // Ejercicio 2
        Automaton writeAutomaton = new Automaton("writeAutomaton", pseintAlphabet);
        Automaton readAutomaton = new Automaton("readAutomaton", pseintAlphabet);
        Automaton assignAutomaton = new Automaton("assignAutomaton", pseintAlphabet);
        Automaton[] reservedWords = {writeAutomaton, readAutomaton, assignAutomaton};
        // Ejercicio 3
        Automaton integerAutomaton = new Automaton("integerAutomaton", pseintAlphabet);
        Automaton floatAutomaton = new Automaton("floatAutomaton", pseintAlphabet);
        Automaton[] numeric = {integerAutomaton, floatAutomaton};
        Automaton trueAutomaton = new Automaton("trueAutomaton", pseintAlphabet);
        Automaton falseAutomaton = new Automaton("falseAutomaton", pseintAlphabet);
        Automaton[] logic = {trueAutomaton, falseAutomaton};
        Automaton charAutomaton = new Automaton("charAutomaton", pseintAlphabet);



        // COMPROBACIONES ENUNCIADO

        // Ejercicio 1
        StateMachine strExample = new StateMachine(exampleAutomaton, "abcccñ");
        System.out.println(strExample.checkString());

        // Ejercicio 2
        StateMachine reservedWord = new StateMachine(reservedWords, "AsignaR");
        System.out.println(reservedWord.reservedWord());

        // Ejercicio 3
        StateMachine dataType = new StateMachine(numeric, logic, charAutomaton, "-4.8");
        System.out.println(dataType.basicDataType());

        dataType.setS("verDadeRo");
        System.out.println(dataType.basicDataType());

        dataType.setS("\"Es esto un dato tipo char?\"");
        System.out.println(dataType.basicDataType());
    }
}
