package in.stackroute.myBank.controller;

import in.stackroute.myBank.model.Account;
import in.stackroute.myBank.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor

@RequestMapping("/api/account")
public class AccountsController {
    private  final AccountService accountService;

//    public AccountsController(AccountService accountService) {
//
//        this.accountService = accountService;
//    }

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account){
        if(accountService.exits(account)){
            return ResponseEntity.status(HttpStatusCode.valueOf(409)).build();
        }
        var savedAccount=accountService.save(account);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(savedAccount);
    }
    @GetMapping
    public ResponseEntity<List<Account>> getAccounts(){

        var accounts=accountService.findAll();
        if(accounts.isEmpty()){
            return ResponseEntity.status(HttpStatusCode.valueOf(404)).build();
        }
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(accounts);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReminder(@PathVariable int id) {

        if (!accountService.exitsById(id)) {
            return ResponseEntity.status(HttpStatusCode.valueOf(404)).build();
        }
        accountService.deleteById(id);
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).build();
    }

}
