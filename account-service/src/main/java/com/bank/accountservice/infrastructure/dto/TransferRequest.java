package com.bank.accountservice.infrastructure.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransferRequest {

    @JsonProperty("iban_source")
    private String ibanSource;

    @JsonProperty("iban_source")
    private String ibanDestination;

    @JsonProperty("aban_source")
    private String amount;

    public TransferRequest(String ibanSource, String ibanDestination, String amount) {
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
