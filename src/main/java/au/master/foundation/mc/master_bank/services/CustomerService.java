package au.master.foundation.mc.master_bank.services;

import au.master.foundation.mc.master_bank.domain.Account;
import au.master.foundation.mc.master_bank.domain.Customer;
import au.master.foundation.mc.master_bank.domain.enums.AccountType;
import au.master.foundation.mc.master_bank.dto.AccountNewDTO;
import au.master.foundation.mc.master_bank.dto.CustomerDTO;
import au.master.foundation.mc.master_bank.dto.CustomerNewDTO;
import au.master.foundation.mc.master_bank.repositories.CustomerRepository;
import au.master.foundation.mc.master_bank.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
        Optional<Customer> account = repo.findById(id);
        return account.orElseThrow(() -> new ObjectNotFoundException(
                "Customer Not Found! Id: " +id));
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

    public Customer fromNewDTO(CustomerNewDTO objDto){
        return new Customer(null, objDto.getFirstName(), objDto.getLastName(), objDto.getEmail());
    }

    public CustomerDTO fromDTO(Customer obj){
        return new CustomerDTO(obj);
    }

    public void updateData(Customer newObj, Customer obj){
        newObj.setFirstName(obj.getfirstName());
        newObj.setLastName(obj.getLastName());
        newObj.setEmail(obj.getEmail());
    }


}
