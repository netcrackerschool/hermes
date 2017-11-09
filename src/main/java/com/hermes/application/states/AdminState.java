package com.hermes.application.states;

import com.hermes.domain.users.AbstractUser;
import com.hermes.domain.users.Role;
import com.hermes.domain.users.UserFactory;
import com.hermes.infrastructure.dataaccess.services.UserService;
import com.hermes.infrastructure.dataaccess.specifications.users.UserWhich;
import com.hermes.userinterface.ConsoleView;
import com.hermes.userinterface.Controller;

import java.util.List;

public class AdminState extends AbstractUserState {

    private final UserService userService;
    private final UserFactory userFactory;
    private final UserWhich userWhich;

    public AdminState(UserService userService, UserFactory userFactory, UserWhich userWhich) {
        this.userService = userService;
        this.userFactory = userFactory;
        this.userWhich = userWhich;
    }

    public void analyseCommands(Controller controller){

        ConsoleView consoleView = controller.getConsoleView();
        consoleView.print("Admin: ");
        String[] command = consoleView.readLine();

        if(command.length == 1) {
            switch (command[0].toLowerCase()) {
                case "admins":
                    printAllAdmins(controller);
                    return;
                case "drivers":
                    printAllDrivers(controller);
                    return;
                case "managers":
                    printAllManagers(controller);
                    return;
                case "planners":
                    printAllPlanners(controller);
                    return;
                case "informers":
                    printAllInformers(controller);
                    return;
            }
        }

        if(match(command, "all", "users")) {
            printAllUsers(controller);
            return;
        }

        if(match(command, "add", "user")) {
            addUser(controller);
            return;
        }

        analyseCommandsUserCommon(controller, command);
    }

    void printHelp(Controller controller){
        super.printHelp(controller);
        ConsoleView consoleView = controller.getConsoleView();
        consoleView.println("  admins: prints info about all admins");
        consoleView.println("  drivers: prints info about all drivers");
        consoleView.println("  managers: prints info about all managers");
        consoleView.println("  planners: prints info about all planners");
        consoleView.println("  informers: prints info about all informers");
        consoleView.println("  \"all users\": prints info about all users");
        consoleView.println("  \"add user\": adds new user");
    }

    private void printAllUsers(Controller controller){
        ConsoleView consoleView = controller.getConsoleView();

        List<? extends AbstractUser> allUsers = this.userService.getAll();

        if(allUsers.isEmpty()){
            throw new IllegalStateException("There should be at least one admin account!");
        }

        consoleView.println("All registered users:");
        for(AbstractUser user : allUsers){
            if(user.equals(getCurrentUser())){
                consoleView.println("(your current account)");
            }
            printUser(controller, user);
        }
    }

    private void printAllAdmins(Controller controller){
        ConsoleView consoleView = controller.getConsoleView();

        List<? extends AbstractUser> allAdmins = this.userService.getEvery(userWhich.isAdmin());

        if(allAdmins.isEmpty()){
            throw new IllegalStateException("There should be at least one admin account!");
        }

        consoleView.println("All registered admins:");
        for(AbstractUser user : allAdmins){
            if(user.equals(getCurrentUser())){
                consoleView.println("(your current account)");
            }
            printUser(controller, user);
        }
    }

    private void printAllDrivers(Controller controller){
        ConsoleView consoleView = controller.getConsoleView();

        List<? extends AbstractUser> allDrivers = this.userService.getEvery(userWhich.isDriver());

        if(allDrivers.isEmpty()){
            consoleView.println("No drivers have been registered yet :(");
        }

        consoleView.println("All registered drivers:");
        for(AbstractUser user : allDrivers){
            printUser(controller, user);
        }
    }

    private void printAllPlanners(Controller controller){
        ConsoleView consoleView = controller.getConsoleView();

        List<? extends AbstractUser> allPlanners = this.userService.getEvery(userWhich.isPlanner());

        if(allPlanners.isEmpty()){
            consoleView.println("No drivers have been registered yet :(");
        }

        consoleView.println("All registered planners:");
        for(AbstractUser user : allPlanners){
            printUser(controller, user);
        }
    }

    private void printAllManagers(Controller controller){
        ConsoleView consoleView = controller.getConsoleView();

        List<? extends AbstractUser> allManagers = this.userService.getEvery(userWhich.isManager());

        if(allManagers.isEmpty()){
            consoleView.println("No managers have been registered yet :(");
        }

        consoleView.println("All registered managers:");
        for(AbstractUser user : allManagers){
            printUser(controller, user);
        }
    }

    private void printAllInformers(Controller controller){
        ConsoleView consoleView = controller.getConsoleView();

        List<? extends AbstractUser> allInformers = this.userService.getEvery(userWhich.isInformer());

        if(allInformers.isEmpty()){
            consoleView.println("No informers have been registered yet :(");
        }

        consoleView.println("All registered informers:");
        for(AbstractUser user : allInformers){
            printUser(controller, user);
        }
    }

    private void addUser(Controller controller){

        ConsoleView consoleView = controller.getConsoleView();
        consoleView.println("Please, enter required user information: ");

        String name = null;
        String login = null;
        String password = null;
        Role role = null;

        while(true){
            consoleView.print("Name: ");
            name = consoleView.readWholeLine();
            if(isValidName(name)){
                break;
            }else{
                consoleView.println("Invalid name, try again");
            }
        }

        outer:
        while(true){
            consoleView.print("Role: ");
            String roleName = consoleView.readWholeLine();
            switch(roleName.toLowerCase()){
                case "admin":
                    role = Role.ADMIN;
                    break outer;
                case "manager":
                    role = Role.MANAGER;
                    break outer;
                case "driver":
                    role = Role.DRIVER;
                    break outer;
                case "planner":
                    role = Role.PLANNER;
                    break outer;
                case "informer":
                    role = Role.INFORMER;
                    break outer;
                default:
                    consoleView.println("Such role does not exist, try again");
            }
        }

        List<? extends AbstractUser> allUsers = this.userService.getAll();

        outer:
        while(true){
            consoleView.print("Login: ");
            login = consoleView.readLogin();
            if(login != null){
                for(AbstractUser user : allUsers){
                    if(login.equals(user.getLogin())){
                        consoleView.println("Such login already exists");
                        continue outer;
                    }
                }
                break;
            }else{
                consoleView.println("Invalid login, try again");
            }
        }

        while(true){
            consoleView.print("Password: ");
            password = consoleView.readPassword();
            if(isValidName(name)){
                break;
            }else{
                consoleView.println("Invalid password, try again");
            }
        }

        if(name == null || login == null || password == null || role == null){
            throw new IllegalStateException();
        }

        this.userService.add(this.userFactory.createUser(login, password, name, role));
        consoleView.println("New user was successfully created!");
    }

    private void printUser(Controller controller, AbstractUser user){
        ConsoleView consoleView = controller.getConsoleView();

        consoleView.println(user.getRole()+" "+user.getName()+":");
        consoleView.println("   login: "+user.getLogin());
        consoleView.println("   password: "+user.getPassword());
    }
}
