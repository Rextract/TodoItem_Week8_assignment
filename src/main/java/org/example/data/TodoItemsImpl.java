package org.example.data;

import org.example.model.Person;
import org.example.model.Todo;

import java.util.Collection;

public class TodoItemsImpl extends AbstractDAOHelper implements TodoItems {

    private static final TodoItemsImpl INSTANCE = new TodoItemsImpl();

    private TodoItemsImpl(){}

    static TodoItemsImpl getInstance(){
        return INSTANCE;
    }

    @Override
    public Todo create(Todo todo) {
        

        return null;
    }

    @Override
    public Collection<Todo> findAll() {
        return null;
    }

    @Override
    public Todo findById(int id) {
        return null;
    }

    @Override
    public Collection<Todo> findByDoneStatus(Boolean status) {
        return null;
    }

    @Override
    public Collection<Todo> findByAssignee(int assignee) {
        return null;
    }

    @Override
    public Collection<Todo> findByAssignee(Person assignee) {
        return null;
    }

    @Override
    public Collection<Todo> findByUnassignedTodoItems() {
        return null;
    }

    @Override
    public Todo update(Todo update) {
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

}
