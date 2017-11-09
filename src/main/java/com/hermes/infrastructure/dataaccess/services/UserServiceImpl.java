package com.hermes.infrastructure.dataaccess.services;

import com.hermes.domain.users.AbstractUser;

public class UserServiceImpl extends GenericServiceImpl<AbstractUser> implements UserService{
    public UserServiceImpl(GenericRepository<AbstractUser> repository) {
        super(repository);
    }
}
