package com.dans.dansmultipro.model;

import javax.persistence.*;

@Entity
@Table(name = "transaction_transfer")
public class TransactionTransfer {
    @Id
    private Long trsId;
    private String trsStatus;
    @OneToOne
    @JoinColumn(name = "trs_to_account")
    private AccountData account;

    public Long getTrsId() {
        return trsId;
    }

    public void setTrsId(Long trsId) {
        this.trsId = trsId;
    }

    public String getTrsStatus() {
        return trsStatus;
    }

    public void setTrsStatus(String trsStatus) {
        this.trsStatus = trsStatus;
    }


    public AccountData getAccount() {
        return account;
    }

    public void setAccount(AccountData account) {
        this.account = account;
    }
}
