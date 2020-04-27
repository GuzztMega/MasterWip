package au.master.foundation.mc.master_bank.domain;

import au.master.foundation.mc.master_bank.domain.enums.AccountType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


//@Inheritance(strategy = InheritanceType.JOINED)
//@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@type")
@Entity
public class Account {

    //Scanner scan = new Scanner(System.in);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String agency;
    private Double balance;
    private Integer type;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "CUSTOMER_ACCOUNT",
            joinColumns = @JoinColumn(name = "account_number"),
            inverseJoinColumns = @JoinColumn(name = "customer_id")
    )
    private List<Customer> customers = new ArrayList<>();

    public Account(){}

    public Account(Integer id, String agency, Double balance, AccountType type) {
        this.id = id;
        this.agency = agency;
        this.balance = balance;
        this.type = (type==null) ? null : type.getCod();
    }

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

    public void setType(AccountType type){ this.type = type.getCod(); }

    public AccountType getType() throws IllegalAccessException{
        return AccountType.toEnum(type);
    }
}
