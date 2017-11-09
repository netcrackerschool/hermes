package com.hermes.application.states;

import com.hermes.userinterface.ConsoleView;
import com.hermes.domain.users.AbstractUser;
import com.hermes.domain.users.RepresentedUser;
import com.hermes.userinterface.Controller;

/**
 *  02.10.15.
 */
public abstract class AbstractRepresentedUserState extends AbstractUserState {
    public AbstractRepresentedUserState() {
    }

    RepresentedUser getCurrentUser() {
        AbstractUser currentUser = super.getCurrentUser();
        if(currentUser instanceof RepresentedUser){
            return (RepresentedUser) currentUser;
        }else{
            throw new IllegalStateException();
        }
    }

    void setCurrentUser(RepresentedUser currentUser) {
        super.setCurrentUser(currentUser);
    }

    final void analyseCommandsRepresented(Controller controller, String[] command){

        ConsoleView consoleView = controller.getConsoleView();

        switch(command.length){
            case 1:
                switch (command[0].toLowerCase()) {
                    case "salary":
                        printSalary(controller);
                        return;
                }
        }

        analyseCommandsUserCommon(controller, command);
    }

    void printHelp(Controller controller){
        super.printHelp(controller);
        ConsoleView consoleView = controller.getConsoleView();
        consoleView.println("  salary: prints salary of current user;");
    }

    void printSalary(Controller controller){
        ConsoleView consoleView = controller.getConsoleView();
        int amount = getCurrentUser().getRepresentation().getSalary();
        consoleView.println("Salary = "+amount);
    }
}
