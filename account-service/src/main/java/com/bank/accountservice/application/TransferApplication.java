package com.bank.accountservice.application;

import com.bank.accountservice.domain.transfer.api.TransferAPI;
import com.bank.accountservice.domain.transfer.entity.Transfer;
import com.bank.accountservice.infrastructure.dto.TransferRequest;

public class TransferApplication {

    private final TransferAPI transferAPI;

    public TransferApplication(TransferAPI transferAPI) {
        this.transferAPI = transferAPI;
    }

    public Transfer transfer(TransferRequest transferRequest){
        return transferAPI.transfer(transferRequest);
    }
}
