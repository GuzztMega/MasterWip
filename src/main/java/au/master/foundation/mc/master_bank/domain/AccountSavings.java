package au.master.foundation.mc.master_bank.domain;

import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.persistence.Entity;
import java.util.List;

@Entity
@JsonTypeName("savingsAccount")
public class AccountSavings extends Account {

    public AccountSavings(){}

    public AccountSavings(Integer id, String agency, Double balance) {
        super(id, agency, balance);
    }
}
