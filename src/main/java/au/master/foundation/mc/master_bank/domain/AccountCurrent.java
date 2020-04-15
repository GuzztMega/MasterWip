package au.master.foundation.mc.master_bank.domain;

import java.util.List;

public class AccountCurrent extends Account {

    public AccountCurrent(Integer id, String agency, Double balance, List<Customer> customers) {
        super(id, agency, balance, customers);
    }
}
