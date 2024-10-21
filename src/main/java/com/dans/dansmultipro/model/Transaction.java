package com.dans.dansmultipro.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    private Long trsId;
    @OneToOne
    @JoinColumn(name = "trs_from_account")
    private AccountData trsFromAccount;

    private Date trsDate;

    private Float trsAmount;
    private Character trsType;

    public Long getTrsId() {
        return trsId;
    }

    public void setTrsId(Long trsId) {
        this.trsId = trsId;
    }

    public AccountData getTrsFromAccount() {
        return trsFromAccount;
    }

    public void setTrsFromAccount(AccountData trsFromAccount) {
        this.trsFromAccount = trsFromAccount;
    }

    public Date getTrsDate() {
        return trsDate;
    }

    public void setTrsDate(Date trsDate) {
        this.trsDate = trsDate;
    }

    public Float getTrsAmount() {
        return trsAmount;
    }

    public void setTrsAmount(Float trsAmount) {
        this.trsAmount = trsAmount;
    }

    public Character getTrsType() {
        return trsType;
    }

    public void setTrsType(Character trsType) {
        this.trsType = trsType;
    }
}
