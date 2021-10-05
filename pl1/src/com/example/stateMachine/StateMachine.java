package com.example.stateMachine;

public class StateMachine {

    private Integer actualState;
    private Automaton dfa = new Automaton();
    private String s;

    public StateMachine(String s) {
        this.s = s;
        inicialize();
    }

    public void inicialize() {
        actualState = dfa.getInitialState();
    }

    public boolean accept(Character character){
        Integer tempState = dfa.getNextState(actualState, character);
        if (tempState != null) {
            actualState = tempState;
            return true;
        }
        return false;
    }

    public boolean isFinal() {
        return dfa.isFinalState(actualState);
    }

    public boolean checkString(){
        int i = 0;
        boolean stop = false;
        while(i < s.length() && !stop) {
            if (accept(s.charAt(i))) {
                i++;
            }
            else {
                stop = true;
            }
        }
        if(stop || !isFinal()) {
            return false;
        }
        return true;
        }
    }
