package com.hermes.domain.employees;

import com.hermes.domain.AbstractPersistentObject;
import com.hermes.domain.users.RepresentedUser;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;


/**
 *  26.10.15.
 */
@Entity
@Table(name="EMPLOYEES")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="ENTITY_TYPE", discriminatorType= DiscriminatorType.STRING, length = 20)
@DiscriminatorValue("ABSTRACT_EMPLOYEE")
public abstract class AbstractEmployee extends AbstractPersistentObject {

    private final static int DEFAULT_SALARY = 5000;

    @Column(name="NAME", nullable = false)
    protected String name;

    @Column(name="SALARY", nullable = false)
    protected int salary;

    @Cascade({CascadeType.ALL})
    @OneToOne(mappedBy = "representation", fetch = FetchType.EAGER)
    RepresentedUser representedUser;

    AbstractEmployee() {
    }

    AbstractEmployee(String name) {
        this.name = name;
        this.salary = DEFAULT_SALARY;
    }

    AbstractEmployee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
