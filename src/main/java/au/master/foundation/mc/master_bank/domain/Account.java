package au.master.foundation.mc.master_bank.domain;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class Account {

    Scanner scan = new Scanner(System.in);

    private Integer id;
    private String agency;
    private Double balance;
    private List<Customer> customers;

    public Account(Integer id, String agency, Double balance, List<Customer> customers) {
        this.id = id;
        this.agency = agency;
        this.balance = balance;
        this.customers = customers;
    }

    public void transfer(Integer accountId, String agency, Double value){
        if(balance <= 0){
            System.out.println("Insufficient funds!");
        } else {
            System.out.print("Enter the Account Number (ID): ");
            accountId = scan.nextInt();
            System.out.print("Enter the Agency Number: ");
            agency = scan.next();
            System.out.print("Amount to be transferred: ");
            value = scan.nextDouble();
        }
    }

    public void deposit(Double value){
    }

    public void withdraw(Long value){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomer(List<Customer> customers) {
        this.customers = customers;
    }
}
