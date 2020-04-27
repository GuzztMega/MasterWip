package au.master.foundation.mc.master_bank.dto;

import au.master.foundation.mc.master_bank.domain.Account;
import au.master.foundation.mc.master_bank.domain.Customer;

import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

public class CustomerDTO {

    private Integer id;
    private String fullName;
    private String email;
    private String phone;

    public CustomerDTO(){}

    public CustomerDTO(Customer obj) {
        this.id = obj.getId();
        this.fullName = obj.getFullName();
        this.email = obj.getEmail();
        this.phone = obj.getPhone();
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
}
