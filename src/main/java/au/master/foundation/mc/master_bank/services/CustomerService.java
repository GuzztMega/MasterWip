package au.master.foundation.mc.master_bank.services;

import au.master.foundation.mc.master_bank.domain.Account;
import au.master.foundation.mc.master_bank.domain.Customer;
import au.master.foundation.mc.master_bank.domain.enums.AccountType;
import au.master.foundation.mc.master_bank.dto.AccountNewDTO;
import au.master.foundation.mc.master_bank.dto.CustomerNewDTO;
import au.master.foundation.mc.master_bank.repositories.CustomerRepository;
import au.master.foundation.mc.master_bank.services.exceptions.ObjectNotFoundException;
import org.apache.catalina.filters.ExpiresFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Arrays;
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
        Optional<Customer> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Customer doesn't exists"));
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

    public Account createAccount(Integer id, AccountNewDTO objDto){
        Customer obj = getCustomer(id);
        Account newAccount = new Account(null, objDto.newAgency(),
                objDto.getBalance(), AccountType.toEnum(objDto.getType()));
        obj.getAccounts().addAll(Arrays.asList(newAccount));
        newAccount.getCustomers().addAll(Arrays.asList(obj));

        return newAccount;
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
