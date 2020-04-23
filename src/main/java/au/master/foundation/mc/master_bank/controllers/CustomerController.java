package au.master.foundation.mc.master_bank.controllers;

import au.master.foundation.mc.master_bank.domain.Customer;
import au.master.foundation.mc.master_bank.dto.CustomerDTO;
import au.master.foundation.mc.master_bank.dto.CustomerNewDTO;
import au.master.foundation.mc.master_bank.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Customer> insertCustomer(@Valid @RequestBody CustomerNewDTO newObj){
        Customer obj = service.fromDTO(newObj);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

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

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateCustomer(@RequestBody CustomerNewDTO newObj, @PathVariable Integer id){
        Customer obj = service.fromDTO(newObj);
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteCustomer(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
