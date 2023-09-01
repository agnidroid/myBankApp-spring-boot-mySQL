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
        var savedAccount=accountService.save(account);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(savedAccount);
    }
    @GetMapping
    public ResponseEntity<List<Account>> getAccounts(){

        var accounts=accountService.findAll();
        if(accounts.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(accounts);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReminder(@PathVariable int id) {

        if (!accountService.exitsById(id)) {
            return ResponseEntity.notFound().build();
        }
        accountService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
