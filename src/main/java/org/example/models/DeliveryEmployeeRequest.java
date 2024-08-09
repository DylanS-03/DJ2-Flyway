package org.example.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DeliveryEmployeeRequest {
    private String name;
    private double salary;
    private String bankAccount;
    private String nI;

    @JsonCreator
    public DeliveryEmployeeRequest(
            final @JsonProperty("name") String name,
            final @JsonProperty("salary") double salary,
            final @JsonProperty("bankAccount") String bankAccount,
            final @JsonProperty("nI") String nI) {

        this.name = name;
        this.salary = salary;
        this.bankAccount = bankAccount;
        this.nI = nI;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(final double salary) {
        this.salary = salary;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(final String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getnI() {
        return nI;
    }

    public void setnI(final String nI) {
        this.nI = nI;
    }
}
