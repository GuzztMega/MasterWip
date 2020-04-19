package au.master.foundation.mc.master_bank.controllers;

import au.master.foundation.mc.master_bank.domain.Customer;
import au.master.foundation.mc.master_bank.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping(value = "/customers")
    public List<Customer> getCustomers(){
        return service.getCustomers();
    }
}
