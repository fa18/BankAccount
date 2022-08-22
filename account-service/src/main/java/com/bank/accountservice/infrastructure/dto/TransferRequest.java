package com.bank.accountservice.infrastructure.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TransferRequest {

    @JsonProperty("iban_source")
    private String ibanSource;

    @JsonProperty("iban_destination")
    private String ibanDestination;

    private String amount;

    @JsonCreator
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
