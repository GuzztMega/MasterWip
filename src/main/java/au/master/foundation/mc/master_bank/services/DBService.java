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

    public void instantiateDataBase() throws ParseException {

        Customer cust1 = new Customer(null, "Augusto", "Longo", "augusto.longo@wipro.com");
        Customer cust2 = new Customer(null, "Johny", "Bravo", "jbravo@gmail.com");

        customerRepository.saveAll(Arrays.asList(cust1, cust2));
    }
}
