package com.hermes.application.states;

import com.hermes.domain.places.AbstractBase;
import com.hermes.domain.places.AbstractPlace;
import com.hermes.domain.places.PlaceFactory;
import com.hermes.infrastructure.dataaccess.services.PlaceService;
import com.hermes.userinterface.ConsoleView;
import com.hermes.userinterface.Controller;

/**
 *  02.10.15.
 */
public class InformerState extends AbstractUserState {

    private final PlaceService placeService;
    private final PlaceFactory placeFactory;

    public InformerState(PlaceService placeService, PlaceFactory placeFactory) {
        this.placeService = placeService;
        this.placeFactory = placeFactory;
    }

    public void analyseCommands(Controller controller){

        ConsoleView consoleView = controller.getConsoleView();
        consoleView.print("Informer: ");
        String[] command = consoleView.readLine();

        switch(command.length){
            case 2:
                if(command[0].toLowerCase().equals("add")){
                    if(command[1].toLowerCase().equals("place")){
                        addPlace(controller);
                        return;
                    }
                }
        }

        analyseCommandsUserCommon(controller, command);
    }

    void printHelp(Controller controller){
        super.printHelp(controller);
        ConsoleView consoleView = controller.getConsoleView();
        consoleView.println("  \"add place\": adds new place into the database");
    }

    private void addPlace(Controller controller) {
        ConsoleView consoleView = controller.getConsoleView();
        consoleView.println("Adding new place...");

        AbstractPlace place = null;
        String placeName = null;

        while(true) {
            consoleView.print("Place name: ");
            placeName = consoleView.readLogin();
            if (isAbort(placeName)) {
                return;
            }
            if (isValid(placeName)) {
                break;
            }
            consoleView.println("Bad place name, please enter again");
        }

        outer:
        while(true) {
            consoleView.print("Base or fix: ");
            String choice = consoleView.readWholeLine();
            switch(choice.toLowerCase()) {
                case "base":
                    place = createBase(controller, placeName);
                    break outer;
                case "fix":
                    place = this.placeFactory.createBasicFix(placeName);
                    break outer;
                default:
                    consoleView.println("Incorrect answer. Please, write \"base\" or \"fix\"");
            }
        }

        this.placeService.add(place);
        consoleView.println("New place was created successfuly");
    }

    private AbstractBase createBase(Controller controller, String placeName){
        ConsoleView consoleView = controller.getConsoleView();
        while(true) {
            consoleView.print("Company or client base: ");
            String choice = consoleView.readWholeLine();
            switch(choice.toLowerCase()) {
                case "company":
                    return this.placeFactory.createBasicCompanyBase(placeName);
                case "client":
                    return this.placeFactory.createBasicClientBase(placeName);
                default:
                    consoleView.println("Incorrect answer. Please, write \"company\" or \"client\"");
            }
        }
    }

    private boolean isValid(String clientName){
        return ((clientName != null) && (clientName.length() > 0));
    }
}