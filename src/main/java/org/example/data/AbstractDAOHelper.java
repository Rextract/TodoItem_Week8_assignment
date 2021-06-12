package org.example.data;

import org.example.model.Person;

import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class AbstractDAOHelper {

    protected void closeAll(AutoCloseable...closeables){
        if (closeables != null){
            for (AutoCloseable closeable : closeables){
                if (closeables != null){
                    try {
                        closeable.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    protected Person resultSetToPerson (ResultSet resultSet) throws SQLException{
        return new Person(
                resultSet.getInt("personId"),
                resultSet.getString("Firstname"),
                resultSet.getString("Lastname")
        );
    }




}
