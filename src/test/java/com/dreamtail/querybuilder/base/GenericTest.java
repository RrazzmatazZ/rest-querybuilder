package com.dreamtail.querybuilder.base;

import com.dreamtail.querybuilder.examples.User;

import java.lang.reflect.ParameterizedType;

public class GenericTest<T> extends GenericParent<T> {


    public GenericTest(Class<T> clazz) {
        setEntityClass(clazz);
    }


    public static void main(String[] args) {
        GenericTest<User> test = new GenericTest<>(User.class);
        System.out.println(test.getEntityClass());
    }
}


class GenericParent<T> {
    private Class<T> entityClass;

    @SuppressWarnings("unchecked")
    public GenericParent() {
    }

    public Class<T> getEntityClass() {
        return entityClass;
    }

    public void setEntityClass(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
}
