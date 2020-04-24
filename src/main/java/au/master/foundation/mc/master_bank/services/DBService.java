package au.master.foundation.mc.master_bank.services;

import au.master.foundation.mc.master_bank.domain.Account;
import au.master.foundation.mc.master_bank.domain.Customer;
import au.master.foundation.mc.master_bank.domain.enums.AccountType;
import au.master.foundation.mc.master_bank.repositories.AccountRepository;
import au.master.foundation.mc.master_bank.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import java.text.ParseException;
import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AccountRepository accountRepository;

    public void instantiateDataBase() throws ParseException {

        Customer cust1 = new Customer(null, "Augusto Longo", "guzzdev2020@gmail.com", "9999-0123");
        Customer cust2 = new Customer(null, "Johny Bravo", "jbravo@gmail.com", "9999-8765");
        customerRepository.saveAll(Arrays.asList(cust1, cust2));

        Account acc1 = new Account(null, "5800-5", 589.20, AccountType.CURRENT);
        Account acc2 = new Account(null, "8123-1", 49000.00, AccountType.SAVINGS);
        accountRepository.saveAll(Arrays.asList(acc1, acc2));

    }
}
