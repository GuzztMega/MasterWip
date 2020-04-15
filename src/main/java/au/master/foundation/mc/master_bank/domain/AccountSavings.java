package au.master.foundation.mc.master_bank.domain;

import java.util.List;

public class AccountSavings extends Account {

    public AccountSavings(Integer id, String agency, Double balance, List<Customer> customers) {
        super(id, agency, balance, customers);
    }
}
