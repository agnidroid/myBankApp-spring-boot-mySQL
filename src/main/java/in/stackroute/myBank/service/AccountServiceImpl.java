package in.stackroute.myBank.service;

import in.stackroute.myBank.model.Account;
import in.stackroute.myBank.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{

    private final AccountRepository repository;


    @Override
    public Account save(Account account){
        return repository.save(account);
    }

    @Override
    public void deleteById(int accountID){
        repository.deleteById(accountID);
    }

    @Override
    public List<Account> findAll(){
        return repository.findAll();
    }

    @Override
    public boolean exitsById(int id){
        if(!repository.existsById(id)){
            return false;
        }
        return  true;
    }

    @Override
    public boolean exits(Account account){
        if(repository.existsById(account.getAccountID())){
            return true;
        }
        return false;
    }

}
