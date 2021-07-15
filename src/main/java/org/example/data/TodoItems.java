package org.example.data;

import org.example.model.Person;
import org.example.model.ToDo;


import java.util.Collection;

public interface TodoItems {
    static TodoItems getInstance(){
        return getInstance();
    }

    ToDo create(ToDo toDo);
    Collection<ToDo> findAll();
    ToDo findById(int id);
    Collection<ToDo> findByDoneStatus(boolean done);
    Collection<ToDo> findByAssignee(int id);
    Collection<ToDo> findByAssignee(Person person);
    Collection<ToDo> findByUnassignedToDoItems();
    ToDo update(ToDo toDo);
    boolean deleteById(int id);
}
