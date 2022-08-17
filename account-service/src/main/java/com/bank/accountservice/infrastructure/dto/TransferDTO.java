package com.bank.accountservice.infrastructure.dto;

public class TransferDTO {

    private String IbanSource;

    private String IbanDestination;

    private String Amount;

    public TransferDTO(String ibanSource, String ibanDestination, String amount) {
        IbanSource = ibanSource;
        IbanDestination = ibanDestination;
        Amount = amount;
    }

    public TransferDTO() {

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
