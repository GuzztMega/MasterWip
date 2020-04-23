package au.master.foundation.mc.master_bank.services;

import au.master.foundation.mc.master_bank.domain.Customer;
import au.master.foundation.mc.master_bank.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private CustomerRepository customerRepository;

    public void instantiateDataBase() throws ParseException {

        Customer cust1 = new Customer(null, "Augusto Longo", "guzzdev2020@gmail.com", "9999-9999");
        Customer cust2 = new Customer(null, "Johny Bravo", "jbravo@gmail.com", "6666-9999");
        customerRepository.saveAll(Arrays.asList(cust1, cust2));

    }
}
