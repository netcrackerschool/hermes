package com.hermes.userinterface;

import com.hermes.application.states.AbstractState;
import com.hermes.application.states.StartState;

public class Controller {

    private final ConsoleView consoleView;
    private final StartState startState;
    private AbstractState currentState;

    public Controller(ConsoleView consoleView, StartState startState) {
        this.consoleView = consoleView;
        this.startState = startState;
        this.currentState = startState;
    }

    public ConsoleView getConsoleView() {
        return consoleView;
    }

    public void setStartState() {
        this.currentState = this.startState;
    }

    public AbstractState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(AbstractState currentState) {
        this.currentState = currentState;
    }

    public void parseCommand() {
        this.currentState.analyseCommands(this);
    }

    void launch() {
        while (true) {
            parseCommand();
        }
    }
}
