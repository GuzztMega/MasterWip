package au.master.foundation.mc.master_bank.domain;

import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.persistence.Entity;
import java.util.List;

@Entity
@JsonTypeName("currentAccount")
public class AccountCurrent extends Account {

    public AccountCurrent(){}

    public AccountCurrent(Integer id, String agency, Double balance) {
        super(id, agency, balance);
    }
}
