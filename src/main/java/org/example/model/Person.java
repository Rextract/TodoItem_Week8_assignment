package org.example.model;

public class Person {

    private int personId;
    private String firstname;
    private String lastname;

    public Person(int personId, String firstname, String lastname) {
        this.personId = personId;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Person (String firstname, String lastname){
        this(0, firstname, lastname);
    }

    Person(){}

    public int getPersonId() {
        return personId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
