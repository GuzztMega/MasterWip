package au.master.foundation.mc.master_bank.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class CustomerNewDTO {

    @NotEmpty(message = "Required field")
    @Length(min = 5, max = 120, message = "The name must be between 5 and 120 characters long")
    private String fullName;

    @NotEmpty(message = "Required field")
    @Email(message = "Invalid Email")
    private String email;

    @NotEmpty(message = "Required field")
    private String phone;

    private Integer accountId;

    CustomerNewDTO(){}

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

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }
}
