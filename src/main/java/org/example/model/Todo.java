package org.example.model;

import java.time.LocalDate;
import java.util.Collection;

public class Todo {

    private int ToDoId;
    private String title;
    private String description;
    private LocalDate deadline;
    private int done;
    private int assigneeId;


    public Todo(int toDoId, String title, String description, LocalDate deadline, int done, int assigneeId) {
        ToDoId = toDoId;
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.done = done;
        this.assigneeId = assigneeId;
    }

    Todo(){}

    public int getToDoId() {
        return ToDoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public int getDone() {
        return done;
    }

    public void setDone(int done) {
        this.done = done;
    }

    public int getAssigneeId() {
        return assigneeId;
    }

    public void setAssigneeId(int assigneeId) {
        this.assigneeId = assigneeId;
    }


    @Override
    public String toString() {
        return "ToDoItem{" +
                "ToDoId=" + ToDoId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", deadline=" + deadline +
                ", done=" + done +
                ", assigneeId=" + assigneeId +
                '}';
    }
}
