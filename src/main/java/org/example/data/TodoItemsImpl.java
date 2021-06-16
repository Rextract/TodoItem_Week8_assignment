package org.example.data;

import org.example.model.Person;
import org.example.model.Todo;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TodoItemsImpl extends AbstractDAOHelper implements TodoItems {


    private static final TodoItemsImpl INSTANCE = new TodoItemsImpl();

    private TodoItemsImpl() {
    }

    static TodoItemsImpl getInstance() {
        return INSTANCE;
    }


    @Override
    public Todo create(Todo todo) {
        if (todo == null) throw new IllegalArgumentException("Todo todo was null");
        if (todo.getToDoId() != 0) throw new IllegalArgumentException("its already created");
        if (todo.getTitle() != null) {
            if (todo.getDescription() != null) {
                if (todo.getDeadline() != null) {
                    if (todo.getDone() != 0)
                        if (todo.getAssigneeId() != 0) {
                        }
                }
            }
                    } else {
                        throw new IllegalArgumentException("it was null");
                    }

                    Todo created = null;
                    Connection connection = null;
                    PreparedStatement statement = null;
                    ResultSet resultSet = null;
                    try {
                        connection = ConnectionFactory.getConnection();
                        statement = connection.prepareStatement("INSERT INTO todo_item(todo_id, title, description, deadline, done, assignee_id) VALUES (?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
                        statement.setInt(1, todo.getToDoId());
                        statement.setString(2, todo.getTitle());
                        statement.setString(3, todo.getDescription());
                        statement.setObject(4, todo.getDeadline());
                        statement.setInt(5, todo.getDone());
                        statement.setInt(6, todo.getAssigneeId());
                        statement.execute();

                        resultSet = statement.getGeneratedKeys();
                        while (resultSet.next()) {
                            created = new Todo(
                                    todo.getToDoId(),
                                    todo.getTitle(),
                                    todo.getDescription(),
                                    todo.getDeadline(),
                                    todo.getDone(),
                                    todo.getAssigneeId()
                            );
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    } finally {
                        closeAll(resultSet, statement, connection);
                    }
                    return created;

    }




    @Override
    public Collection<Todo> findAll() {
        List<Todo> personList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT todo_item.todo_id AS todoId, title, description, deadline, done, person.person_id AS first_name, last_name " +
                    "FROM todo_item INNER JOIN person ON todo_item.todo_id = person.person_id");

            while (resultSet.next()) {
                personList.add(resultSetToPerson(resultSet));
            }

        } catch (SQLException ex){
            ex.printStackTrace();
        }finally {
            closeAll(resultSet, statement, connection);
        }
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
