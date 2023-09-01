package in.stackroute.myBank.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_accounts")
public class Account {


    @Id
    @GeneratedValue
    private int  accountID;
    private String accountHolderName;
    private String address;
    private String accountType;
    private String accountStatus;

}
