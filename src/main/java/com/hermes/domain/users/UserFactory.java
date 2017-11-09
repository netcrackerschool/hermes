package com.hermes.domain.users;

/**
 *  05.10.15.
 */
public interface UserFactory {
    AbstractUser createUser(String login, String password, String name, Role role);
}
