package au.master.foundation.mc.master_bank.controllers;

import au.master.foundation.mc.master_bank.domain.Account;
import au.master.foundation.mc.master_bank.domain.Transfer;
import au.master.foundation.mc.master_bank.dto.AccountNewDTO;
import au.master.foundation.mc.master_bank.services.AccountService;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/accounts")
public class AccountController {

    @Autowired
    private AccountService service;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Account> insertAccount(@Valid @RequestBody AccountNewDTO newObj){
        Account obj = service.fromDTO(newObj);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Account>> getAccount(){
        List<Account> accountList = service.getAccount();
        //List<AccountDTO> dtoList = accountList.stream().map(obj -> new AccountDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(accountList);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Account> getAccount(@PathVariable Integer id){
        Account account = service.getAccount(id);
        return ResponseEntity.ok().body(account);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateAccount(@RequestBody AccountNewDTO newObj, @PathVariable Integer id) throws IllegalAccessException {
        Account obj = service.fromDTO(newObj);
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @JsonFormat
    @RequestMapping(value = "/transferFund", method = RequestMethod.PUT, consumes = "application/json")
    public ResponseEntity<Void> transferFund(@RequestBody Transfer transfer){
        service.transferFund(transfer);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteAccount(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
