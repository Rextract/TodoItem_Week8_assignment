package org.example.data;

import org.example.model.Person;
import org.example.model.Todo;

import java.util.Collection;

public interface TodoItems {
    static TodoItems getInstance(){
        return TodoItemsImpl.getInstance();
    }

    Todo create (Todo todo);
    Collection<Todo> findAll ();
    Todo findById (int id);
    Collection<Todo> findByDoneStatus(Boolean status);
    Collection<Todo> findByAssignee(int assignee);
    Collection<Todo> findByAssignee(Person assignee);
    Collection<Todo> findByUnassignedTodoItems();
    Todo update(Todo update);
    boolean deleteById(int id);
}
