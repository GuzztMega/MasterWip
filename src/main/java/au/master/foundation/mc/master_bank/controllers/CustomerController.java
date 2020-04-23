package au.master.foundation.mc.master_bank.controllers;

import au.master.foundation.mc.master_bank.domain.Customer;
import au.master.foundation.mc.master_bank.dto.CustomerDTO;
import au.master.foundation.mc.master_bank.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Customer>> getCustomers(){
        List<Customer> customerList = service.getCustomers();
        //List<CustomerDTO> dtoList = customerList.stream().map(obj -> new CustomerDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(customerList);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Customer> getCustomer(@PathVariable Integer id){
        Customer customer = service.getCustomer(id);
        return ResponseEntity.ok().body(customer);
    }


}
