package au.master.foundation.mc.master_bank.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@type")
public abstract class Account {

    //Scanner scan = new Scanner(System.in);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String agency;
    private Double balance;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "CUSTOMER_ACCOUNT",
            joinColumns = @JoinColumn(name = "account_number"),
            inverseJoinColumns = @JoinColumn(name = "customer_id")
    )
    private List<Customer> customers = new ArrayList<>();

    public Account(){}

    public Account(Integer id, String agency, Double balance) {
        this.id = id;
        this.agency = agency;
        this.balance = balance;
    }

    public void transfer(Integer accountId, String agency, Double value){
//        if(balance <= 0){
//            System.out.println("Insufficient funds!");
//        } else {
//            System.out.print("Enter the Account Number (ID): ");
//            accountId = scan.nextInt();
//            System.out.print("Enter the Agency Number: ");
//            agency = scan.next();
//            System.out.print("Amount to be transferred: ");
//            value = scan.nextDouble();
//        }
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
