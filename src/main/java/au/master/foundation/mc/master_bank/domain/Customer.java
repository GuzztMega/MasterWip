package au.master.foundation.mc.master_bank.domain;

import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import java.util.List;

public class Customer {

    private Integer id;
    private String fullName;
    private String email;
    private String phone;

    @ManyToMany(cascade= CascadeType.ALL)
    private List<Account> accounts;

    public Customer(){}

    public Customer(Integer id, String fullName, String email, String phone) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}

