package com.bank.accountservice.infrastructure.dto;

public class TransferDTO {

    private String ibanSource;

    private String ibanDestination;

    private String amount;

    public TransferDTO(String ibanSource, String ibanDestination, String amount) {
        this.ibanSource = ibanSource;
        this.ibanDestination = ibanDestination;
        this.amount = amount;
    }

    public TransferDTO() {

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
