package org.example.data;

import org.example.model.Person;

import java.util.Collection;

public interface People {

    static People getInstance(){
        return PeopleImpl.getInstance();
    }

    Person create(Person person);
    Collection<Person> findAll();
    Collection<Person> findById(int id);
    Collection<Person> findByName(String name);
    Person update(Person person);
    boolean deleteById(int id);

}
