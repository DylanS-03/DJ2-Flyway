package org.example.models;

public class Project {
    private int id;
    private String name;
    private double value;
    private int clientID;
    private boolean completed;

    public Project(final int id, final String name,
                            final double value, final int clientID,
                            final boolean completed) {
        this.setId(id);
        this.setName(name);
        this.setValue(value);
        this.setClientID(clientID);
        this.setCompleted(completed);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
