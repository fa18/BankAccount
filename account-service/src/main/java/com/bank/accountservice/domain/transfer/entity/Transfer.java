package com.bank.accountservice.domain.transfer.entity;

public class Transfer {

    private String ibanSource;

    private String ibanDestination;

    private String amount;

    public Transfer(String ibanSource, String ibanDestination, String amount) {
        this.ibanSource = ibanSource;
        this.ibanDestination = ibanDestination;
        this.amount = amount;
    }

    public String getIbanSource() {
        return ibanSource;
    }

    public String getIbanDestination() {
        return ibanDestination;
    }

    public String getAmount() {
        return amount;
    }
}
