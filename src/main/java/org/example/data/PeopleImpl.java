package org.example.data;

import org.example.model.Person;

import java.sql.*;
import java.util.*;

public class PeopleImpl extends AbstractDAOHelper implements People {

    private static final PeopleImpl INSTANCE = new PeopleImpl();

    private PeopleImpl(){}

    protected static PeopleImpl getInstance(){
        return INSTANCE;
    }


    @Override
    public Person create(Person person) {
        if (person == null) throw new IllegalArgumentException("Person person was null");
        if (person.getPersonId() != 0) throw new IllegalArgumentException("Person person is already created");
        if (person.getFirstname() != null) {
            if (person.getLastname() != null) {
            }
        } else {
            throw new IllegalArgumentException("It was null");
        }

        Person created = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement("INSERT INTO person(person_id, first_name, last_name) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, person.getFirstname());
            statement.setString(2, person.getLastname());
            statement.setInt(3, person.getPersonId());
            statement.execute();

            resultSet = statement.getGeneratedKeys();
            while (resultSet.next()) {
                created = new Person(

                        person.getPersonId(),
                        person.getFirstname(),
                        person.getLastname()
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
    public Collection<Person> findAll() {
        List<Person> personList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT person.person_id AS personId, first_name, last_name, todo_item.todo_id AS title, description, deadline, done, assignee_id " +
                    "FROM person INNER JOIN todo_item ON person.person_id = todo_item.todo_id");

            while (resultSet.next()){
                personList.add(resultSetToPerson(resultSet));
            }

        } catch (SQLException ex){
            ex.printStackTrace();
        }finally {
            closeAll(resultSet, statement, connection);
        }


        return personList;
    }

    @Override
    public Collection<Person> findById(int id) {
        Person person = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement("SELECT person.person_id AS personId, first_name, last_name, todo_item.todo_id " +
                    "AS todoId, title, description, deadline, done, assignee_id " +
                    "FROM person INNER JOIN todo_item ON person.person_id = person.person_id WHERE person.person_id = ?");

            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                person = resultSetToPerson(resultSet);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }finally {
            closeAll(resultSet, statement, connection);
        }

        return Collections.singleton(person);
    }

    @Override
    public Collection<Person> findByName(String name) {
        Collection<Person> people = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement("SELECT person.person_id AS personId, first_name, last_name, todo_item.todo_id AS title, description, deadline, done, assignee_id " +
                    "FROM person INNER JOIN todo_item ON person.person_id = todo_item.todo_id " +
                    "WHERE UPPER (first_name) LIKE UPPER(CONCAT('%', ?, '%'))");
            statement.setString(1, name);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                people.add(resultSetToPerson(resultSet));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally {
            closeAll(resultSet, statement, connection);
        }

        return people;
    }

    @Override
    public Person update(Person person) {
        if (person == null) throw new IllegalArgumentException("Person person was null");
        if (person.getPersonId() == 0) throw new IllegalArgumentException("Person person was not yet created");
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement("UPDATE person SET first_name = ?, last_name = ? WHERE person_id = ?");
            statement.setString(1, person.getFirstname().trim());
            statement.setString(2, person.getLastname().trim());
            statement.setString(3, String.valueOf(person.getPersonId()));
            statement.execute();
        }catch (SQLException ex) {
            ex.printStackTrace();
        }finally {
            closeAll(statement, connection);
        }

        return person;
    }

    @Override
    public boolean deleteById(int id) {
        int rowsAffected = 0;
        try (
                Connection connection = ConnectionFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement("DELETE FROM person WHERE person_id = ?")
                ) {
            rowsAffected = statement.executeUpdate();
        } catch (SQLException ex){
            ex.printStackTrace();
        }

        return rowsAffected > 0;
    }

}
