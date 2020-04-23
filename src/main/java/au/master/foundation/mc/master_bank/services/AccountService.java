package au.master.foundation.mc.master_bank.services;

import au.master.foundation.mc.master_bank.domain.Account;
import au.master.foundation.mc.master_bank.dto.CustomerNewDTO;
import au.master.foundation.mc.master_bank.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository  repo;

    public Account insert(Account obj){
        obj.setId(null);
        return repo.save(obj);
    }

    public List<Account> getAccount(){
        List<Account> accounts = repo.findAll();
        return accounts;
    }

    public Account getAccount(Integer id){
        Optional<Account> accounts = repo.findById(id);
        Account account = accounts.get();
        return account;
    }

    public Account update(Account obj){
        Account newObj = getAccount(obj.getId());
        //updateData(newObj, obj);
        return repo.save(newObj);
    }

    public void delete(Integer id){
        getAccount(id);
        try{
            repo.deleteById(id);
        } catch (DataIntegrityViolationException dive){
            throw new DataIntegrityViolationException("An erro has occured by deleting this Account");
        }
    }

//    public Account fromDTO(CustomerNewDTO objDto){
//        return new Account(null, objDto.getFullName(), objDto.getEmail(), objDto.getPhone());
//    }
//
//    public void updateData(Account newObj, Account obj){
//        newObj.setFullName(obj.getFullName());
//        newObj.setPhone(obj.getPhone());
//        newObj.setEmail(obj.getEmail());
//    }
}
