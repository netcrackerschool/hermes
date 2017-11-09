package com.hermes.infrastructure.dataaccess.specifications.users;

import com.hermes.domain.users.AbstractUser;
import com.hermes.domain.users.Role;
import com.hermes.infrastructure.dataaccess.specifications.AbstractSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

/**
 *  02.10.15.
 */
public class hasRole extends AbstractSpecification<AbstractUser> {

    private Role role;

    hasRole(Role role) {
        this.role = role;
    }

    public boolean isSatisfiedBy(AbstractUser user) {
        return user.getRole() == this.role;
    }

    public Criterion toCriterion() {
        return Restrictions.eq("role", this.role);
    }
}
