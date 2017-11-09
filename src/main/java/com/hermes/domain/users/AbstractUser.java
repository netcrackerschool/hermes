package com.hermes.domain.users;

import com.hermes.domain.AbstractPersistentObject;

import javax.persistence.*;

/**
 *  02.10.15.
 */
@Entity
@Table(name="USERS", uniqueConstraints = {@UniqueConstraint(columnNames = "LOGIN"),})
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="ENTITY_TYPE", discriminatorType=DiscriminatorType.STRING, length = 20)
@DiscriminatorValue("ABSTRACT_USER")
public abstract class AbstractUser extends AbstractPersistentObject {

    @Column(name="LOGIN", nullable = false, insertable = false, updatable = false)
    private String login;

    @Column(name="PASSWORD", nullable = false, insertable = false, updatable = false)
    private String password;

    @Column(name="NAME", nullable = false, insertable = false, updatable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name="ROLE", nullable = false, insertable = false, updatable = false)
    private Role role;

    AbstractUser() {
    }

    AbstractUser(String login, String password, String name, Role role) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        if(login == null){
            throw new IllegalArgumentException("Can't be null");
        }
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if(password == null){
            throw new IllegalArgumentException("Can't be null");
        }
        this.password = password;
    }

    public void checkPassword(String password) throws InvalidPasswordException{
        if(this.getPassword().equals(password) == false){
            throw new InvalidPasswordException();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null){
            throw new IllegalArgumentException("Can't be null");
        }
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        if(role == null){
            throw new IllegalArgumentException("Can't be null");
        }
        this.role = role;
    }
}
