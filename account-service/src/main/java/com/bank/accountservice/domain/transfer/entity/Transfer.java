package com.bank.accountservice.domain.transfer.entity;

public class Transfer {

    private String IbanSource;

    private String IbanDestination;

    private String Amount;

    public Transfer(String ibanSource, String ibanDestination, String amount) {
        IbanSource = ibanSource;
        IbanDestination = ibanDestination;
        Amount = amount;
    }

    public String getIbanSource() {
        return IbanSource;
    }

    public String getIbanDestination() {
        return IbanDestination;
    }

    public String getAmount() {
        return Amount;
    }
}
