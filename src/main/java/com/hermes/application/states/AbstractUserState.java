package com.hermes.application.states;

import com.hermes.userinterface.ConsoleView;
import com.hermes.domain.users.AbstractUser;
import com.hermes.userinterface.Controller;

public abstract class AbstractUserState extends AbstractState {

    private AbstractUser currentUser;

    AbstractUserState() {
    }

    AbstractUser getCurrentUser() {
        if(currentUser == null){
            throw new IllegalStateException("User was not set");
        }
        return currentUser;
    }

    void setCurrentUser(AbstractUser currentUser) {
        this.currentUser = currentUser;
    }

    //Template method pattern
    final void analyseCommandsUserCommon(Controller controller, String[] command){

        switch(command.length){
            case 1:
                switch (command[0].toLowerCase()){
                    case "info":
                        printInfo(controller);
                        return;
                    case "exit":
                        exitCurrentState(controller);
                        return;
                }
        }

        analyseCommandsGlobal(controller, command);
    }

    void printHelp(Controller controller){
        super.printHelp(controller);
        ConsoleView consoleView = controller.getConsoleView();
        consoleView.println("  info: prints information about current account;");
        consoleView.println("  exit: exits current account;");
    }

    void printInfo(Controller controller){
        controller.getConsoleView().println(currentUser.getName());
    }

    void exitCurrentState(Controller controller){
        controller.setStartState();
    }

    boolean isAbort(String line){
        return line.toLowerCase().equals("abort");
    }

    boolean isValidName(String name){
        return ((name != null) && (name.length() > 0));
    }
}
