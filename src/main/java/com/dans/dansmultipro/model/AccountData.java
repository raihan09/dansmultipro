package com.dans.dansmultipro.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "account")
public class AccountData {
    @Id
    private Character accountNumber;
    private Date accountDateCreated;
    private Float accountBalance;


//    private List<TransactionTransfer> transactionTransferList;

    public Character getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Character accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Date getAccountDateCreated() {
        return accountDateCreated;
    }

    public void setAccountDateCreated(Date accountDateCreated) {
        this.accountDateCreated = accountDateCreated;
    }

    public Float getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Float accountBalance) {
        this.accountBalance = accountBalance;
    }

//    @OneToMany
//    @JoinColumn(name = "trs_to_account")
//    public List<TransactionTransfer> getTransactionTransferList() {
//        return transactionTransferList;
//    }
//
//    public void setTransactionTransferList(List<TransactionTransfer> transactionTransferList) {
//        this.transactionTransferList = transactionTransferList;
//    }
}
