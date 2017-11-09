package com.hermes.application.states;

import com.hermes.domain.users.AbstractUser;
import com.hermes.domain.users.InvalidPasswordException;
import com.hermes.domain.users.RepresentedUser;
import com.hermes.infrastructure.dataaccess.services.UserService;
import com.hermes.infrastructure.dataaccess.specifications.users.UserWhich;

import javax.persistence.NoResultException;

/**
 *  01.10.15.
 */
class UserStateFactory {

    private final UserService userService;

    private final AdminState adminState;
    private final DriverState driverState;
    private final ManagerState managerState;
    private final InformerState informerState;
    private final PlannerState plannerState;

    private final UserWhich userWhich;

    public UserStateFactory(UserService userService,
                            AdminState adminState,
                            DriverState driverState,
                            ManagerState managerState,
                            InformerState informerState,
                            PlannerState plannerState,
                            UserWhich userWhich) {
        this.userService = userService;
        this.adminState = adminState;
        this.driverState = driverState;
        this.managerState = managerState;
        this.informerState = informerState;
        this.plannerState = plannerState;
        this.userWhich = userWhich;
    }

    AbstractUserState createUserState(String login, String password) throws NoSuchLoginException, InvalidPasswordException{
        try {
            AbstractUser user = userService.getOne(userWhich.hasLogin(login));
            user.checkPassword(password);
            switch(user.getRole()){
                case ADMIN:
                    adminState.setCurrentUser(user);
                    return adminState;
                case DRIVER:
                    if(user instanceof RepresentedUser){
                        driverState.setCurrentUser(user);
                        return driverState;
                    }else{
                        throw new IllegalStateException();
                    }
                case MANAGER:
                    managerState.setCurrentUser(user);
                    return managerState;
                case PLANNER:
                    plannerState.setCurrentUser(user);
                    return plannerState;
                case INFORMER:
                    informerState.setCurrentUser(user);
                    return informerState;
                default:
                    throw new IllegalStateException();
            }
        }catch (NoResultException nre){
            throw new NoSuchLoginException();
        }
    }
}
