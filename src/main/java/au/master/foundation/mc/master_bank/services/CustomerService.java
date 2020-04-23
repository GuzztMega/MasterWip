package au.master.foundation.mc.master_bank.services;

import au.master.foundation.mc.master_bank.domain.Customer;
import au.master.foundation.mc.master_bank.dto.CustomerNewDTO;
import au.master.foundation.mc.master_bank.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repo;

    public Customer insert(Customer obj){
        obj.setId(null);
        return repo.save(obj);
    }

    public List<Customer> getCustomers(){
        List<Customer> customers = repo.findAll();
        return customers;
    }

    public Customer getCustomer(Integer id){
        Optional<Customer> customers = repo.findById(id);
        Customer customer = customers.get();
        return customer;
    }

    public Customer update(Customer obj){
        Customer newObj = getCustomer(obj.getId());
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    public void delete(Integer id){
        getCustomer(id);
        try{
            repo.deleteById(id);
        } catch (DataIntegrityViolationException dive){
            throw new DataIntegrityViolationException("An erro has occured by deleting this customer");
        }
    }

    public Customer fromDTO(CustomerNewDTO objDto){
        return new Customer(null, objDto.getFullName(), objDto.getEmail(), objDto.getPhone());
    }

    public void updateData(Customer newObj, Customer obj){
        newObj.setFullName(obj.getFullName());
        newObj.setPhone(obj.getPhone());
        newObj.setEmail(obj.getEmail());
    }


}
