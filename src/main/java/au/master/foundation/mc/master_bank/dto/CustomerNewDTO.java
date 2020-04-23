package au.master.foundation.mc.master_bank.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class CustomerNewDTO {

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 5, max = 120, message = "O nome deve ter entre 5 e 120 caracteres")
    private String fullName;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Email(message = "Insira um email válido")
    private String email;

    @NotEmpty(message = "Preenchimento obrigatório")
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
