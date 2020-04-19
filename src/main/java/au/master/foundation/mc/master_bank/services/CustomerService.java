package au.master.foundation.mc.master_bank.services;

import au.master.foundation.mc.master_bank.domain.Customer;
import au.master.foundation.mc.master_bank.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repo;

    public List<Customer> getCustomers(){
        List<Customer> customers = repo.findAll();
        return customers;
    }

    public Customer getCustomer(Integer id){
        Optional<Customer> customers = repo.findById(id);
        Customer customer = customers.get();
        return customer;
    }
}
