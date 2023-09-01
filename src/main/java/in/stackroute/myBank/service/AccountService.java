package in.stackroute.myBank.service;

import in.stackroute.myBank.model.Account;

import java.util.List;

public interface AccountService {

    Account save(Account account);
    void deleteById(int accountID);
    List<Account> findAll();
    boolean exitsById(int id);
    boolean exits(Account account);


}
