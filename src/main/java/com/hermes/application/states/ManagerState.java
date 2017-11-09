package com.hermes.application.states;

import com.hermes.domain.orders.AbstractOrder;
import com.hermes.domain.orders.OrderBuilder;
import com.hermes.infrastructure.dataaccess.services.OrderService;
import com.hermes.userinterface.ConsoleView;
import com.hermes.userinterface.Controller;

import java.util.InputMismatchException;
import java.util.List;

/**
 *  31.10.15.
 */
public class ManagerState extends AbstractUserState {

    private final OrderService orderService;

    public ManagerState(OrderService orderService) {
        this.orderService = orderService;
    }

    public void analyseCommands(Controller controller){

        ConsoleView consoleView = controller.getConsoleView();
        consoleView.print("Manager: ");
        String[] command = consoleView.readLine();

        if(match(command, "add", "order")){
            addOrder(controller);
        }

        if(match(command, "view", "orders")){
            printAllOrders(controller);
        }

        if(match(command, "view", "orders", "with", "cargo")){
            printAllOrdersWithCargo(controller);
        }

        analyseCommandsUserCommon(controller, command);
    }

    void printHelp(Controller controller){
        super.printHelp(controller);
        ConsoleView consoleView = controller.getConsoleView();
        consoleView.println("  \"add order\": opens dialog for adding new order");
        consoleView.println("  \"view orders\": prints list of all currently active orders");
        consoleView.println("  \"view orders with cargo\": same, but all with a list of cargo for each order");
    }

    private void printAllOrders(Controller controller){
        ConsoleView consoleView = controller.getConsoleView();

        consoleView.println("All currently active orders:");

        List<? extends AbstractOrder> allOrders = this.orderService.getAll();
        for(AbstractOrder order : allOrders){
            printOrderInfo(controller, order);
        }
    }

    private void printAllOrdersWithCargo(Controller controller){
        ConsoleView consoleView = controller.getConsoleView();

        consoleView.println("Not ready yet!");
//        consoleView.println("All currently active orders:");
//        List<? extends Order> allOrders = this.orderService().getAll();
//        for(Order order : allOrders){
//            printOrderInfo(controller, order);
//        }
    }

    private void printOrderInfo(Controller controller, AbstractOrder order){
        ConsoleView consoleView = controller.getConsoleView();

        consoleView.println("//======================");
        consoleView.println("Order "+order.getBusinessId()+":");
        consoleView.println("   client:"+order.getClientName()+":");
    }

//    private void printCargo(Controller controller, Cargo cargo){
//        ConsoleView consoleView = controller.getConsoleView();
//    }

    private void addOrder(Controller controller){
        ConsoleView consoleView = controller.getConsoleView();
        consoleView.println("Adding new order...");

        OrderBuilder ob = OrderBuilder.newOrderBuilder();

        while(true) {
            consoleView.print("Clients name: ");
            String clientName = consoleView.readWholeLine();
            if (isAbort(clientName)) {
                return;
            }
            if (isValidName(clientName)) {
                ob.setClientName(clientName);
                break;
            }
            consoleView.println("Bad client name, please enter again");
        }

        consoleView.println("Now please specify cargo items: type, weight, volume and amount");
        addCargo(controller, ob);

        outer:
        while(true) {
            consoleView.print("Add or finish?: ");
            String choice = consoleView.readWholeLine();
            switch(choice.toLowerCase()) {
                case "add":
                    addCargo(controller, ob);
                    break;
                case "finish":
                    consoleView.println("No more cargo will be accepted!");
                    break outer;
                default:
                    consoleView.println("Incorrect answer. Please, write \"add\" or \"finish\"");
            }
        }

        this.orderService.add(ob.getOrder());
        consoleView.println("New order was successfuly added!");
    }

    private void addCargo(Controller controller, OrderBuilder ob){
        ConsoleView consoleView = controller.getConsoleView();

        String type = null;
        double weight = 0.0;
        double volume = 0.0;
        int amount = 0;

        while(true){
            consoleView.print("Type: ");
            type = consoleView.readWholeLine();
            break;
        }
        while(true){
            consoleView.print("Weight: ");
            try {
                weight = consoleView.readDouble();
            }catch (InputMismatchException e){
                consoleView.println("Invalid value, try again");
                continue;
            }
            break;
        }
        while(true){
            consoleView.print("Volume: ");
            try {
                volume = consoleView.readDouble();
            }catch (InputMismatchException e){
                consoleView.println("Invalid value, try again");
                continue;
            }
            break;
        }
        while(true){
            consoleView.print("Amount: ");
            try {
                amount = consoleView.readInt();
            }catch (InputMismatchException e){
                consoleView.println("Invalid value, try again");
                continue;
            }
            break;
        }
        ob.addCargo(type, weight, volume, amount);
    }
}
