package au.master.foundation.mc.master_bank.services;

import au.master.foundation.mc.master_bank.domain.Account;
import au.master.foundation.mc.master_bank.domain.Transfer;
import au.master.foundation.mc.master_bank.domain.enums.AccountType;
import au.master.foundation.mc.master_bank.dto.AccountNewDTO;
import au.master.foundation.mc.master_bank.repositories.AccountRepository;
import au.master.foundation.mc.master_bank.services.exceptions.NotEnoughFundsException;
import au.master.foundation.mc.master_bank.services.exceptions.ObjectNotFoundException;
import au.master.foundation.mc.master_bank.services.exceptions.SameAccountsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    public Account update(Account obj) throws IllegalAccessException {
        Account newObj = getAccount(obj.getId());
        updateData(newObj, obj);
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

    public Account fromDTO(AccountNewDTO objDto){
        return new Account(null, objDto.newAgency(),objDto.getBalance(), AccountType.toEnum(objDto.getType()));
    }

    public void updateData(Account newObj, Account obj) throws IllegalAccessException {
        newObj.setBalance(obj.getBalance());
        newObj.setType(obj.getType());
    }

    @Transactional
    public void transferFund(Transfer transfer){
        Integer fromAccount = transfer.getFromAccount();
        Integer toAccount = transfer.getToAccount();
        Double amount = transfer.getAmount();

        if(!fromAccount.equals(toAccount)){
            Optional<Account> sAccounts = repo.findById(fromAccount);
            Account sAccount = sAccounts.get();
            if(sAccount.getBalance() >= amount){
                sAccount.setBalance(sAccount.getBalance() - amount);

                Optional<Account> rAccounts = repo.findById(toAccount);
                Account rAccount = rAccounts.get();
                rAccount.setBalance(rAccount.getBalance() + amount);
            } else if(sAccount.getBalance() < amount){
                throw new NotEnoughFundsException("You don't have enough funds to make this transfer.");
            }
        } else{
            throw new SameAccountsException("Account number can't be the same.");
        }
    }
}
