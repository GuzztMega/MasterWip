package au.master.foundation.mc.master_bank.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class CustomerNewDTO {

    @NotEmpty(message = "Required field")
    @Length(min = 5, max = 50, message = "The name must be between 5 and 50 characters long")
    private String firstName;

    @NotEmpty(message = "Required field")
    @Length(min = 5, max = 120, message = "The name must be between 5 and 120 characters long")
    private String lastName;

    @NotEmpty(message = "Required field")
    @Email(message = "Invalid Email")
    private String email;

    private Integer accountId;

    CustomerNewDTO(){}

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }
}
