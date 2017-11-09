package com.hermes.application.states;

import com.hermes.userinterface.ConsoleView;
import com.hermes.userinterface.Controller;

public abstract class AbstractState {

    //Template method pattern;
    final void analyseCommandsGlobal(Controller controller, String[] command){

        ConsoleView consoleView = controller.getConsoleView();

        switch(command.length){
            case 1:
                switch (command[0].toLowerCase()){
                    case "help":
                        printHelp(controller);
                        return;
                    case "close":
                        consoleView.println("Program has been closed");
                        System.exit(0);
                }
        }

        consoleView.println("Invalid command, type \"help\" to get list of commands");
    }

    void printHelp(Controller controller){
        ConsoleView consoleView = controller.getConsoleView();
        consoleView.println("Possible commands: ");
        consoleView.println("  help: prints list of current available commands");
        consoleView.println("  close: closes whole application");
    }

    boolean matches(boolean caseSensitive, String[] command, String...expectedCommand){
        if(command.length != expectedCommand.length){
            return false;
        }
        if(caseSensitive == true){
            for(int i = 0; i < expectedCommand.length; i++){
                if((command[i]).equals(expectedCommand[i]) == false){
                    return false;
                }
            }
            return true;
        }else{
            for(int i = 0; i < expectedCommand.length; i++){
                if((command[i].toLowerCase()).equals(expectedCommand[i].toLowerCase()) == false){
                    return false;
                }
            }
            return true;
        }
    }

    boolean match(String[] command, String...expectedCommand){
        return matches(false, command, expectedCommand);
    }

    public abstract void analyseCommands(Controller controller);
}
