package com.hermes.infrastructure.dataaccess.specifications;

import java.lang.reflect.ParameterizedType;

/**
 *  02.10.15.
 */
abstract public class AbstractSpecification<T> implements Specification<T> {
    public Class<T> getType() {
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        return (Class<T>) type.getActualTypeArguments()[0];
    }
}
