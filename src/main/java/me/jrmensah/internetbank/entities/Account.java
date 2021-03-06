package me.jrmensah.internetbank.entities;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @NotEmpty
    private String firstName;

    @NotNull
    @NotEmpty
    private String lastName;

    @NotNull
    @NotEmpty
    @Digits(integer=9, fraction=0)
    private int accountNumber;

    @NotNull
    @NotEmpty
    @Digits(integer =15, fraction=2)
    private double amount;

    @NotNull
    @NotEmpty
    @DateTimeFormat(pattern="MMM/dd/YYYY")
    private String date;


 // Many to Many relationship
    @ManyToMany(mappedBy = "accounts")
    private Set<Transaction> transactions;

    public Account() {
    }

    public Account(String firstName, String lastName, int accountNumber, double amount, String date, Set<Transaction> transactions) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.date = date;
        this.transactions = transactions;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }



    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }
}
