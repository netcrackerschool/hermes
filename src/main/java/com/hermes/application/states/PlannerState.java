package com.hermes.application.states;

import com.hermes.userinterface.ConsoleView;
import com.hermes.userinterface.Controller;

/**
 *  31.10.15.
 */
public class PlannerState extends AbstractUserState {

    public PlannerState() {
    }

    public void analyseCommands(Controller controller){

        ConsoleView consoleView = controller.getConsoleView();
        consoleView.print("Planner: ");
        String[] command = consoleView.readLine();

        switch(command.length){
            case 1:
                switch (command[0].toLowerCase()){
                    case "new":
                        consoleView.println("Creating haul!");
                        return;
                }
        }

        analyseCommandsUserCommon(controller, command);
    }

    void printHelp(Controller controller){
        super.printHelp(controller);
        ConsoleView consoleView = controller.getConsoleView();
        consoleView.println("  new: creates new haul");
    }
}
