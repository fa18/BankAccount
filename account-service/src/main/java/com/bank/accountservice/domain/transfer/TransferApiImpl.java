package com.bank.accountservice.domain.transfer;

import com.bank.accountservice.domain.transfer.api.TransferAPI;
import com.bank.accountservice.domain.transfer.entity.Transfer;
import com.bank.accountservice.domain.transfer.spi.TransferSPI;
import com.bank.accountservice.infrastructure.dto.TransferRequest;

public class TransferApiImpl implements TransferAPI {

    private final TransferSPI transferSPI;

    public TransferApiImpl(TransferSPI transferSPI) {
        this.transferSPI = transferSPI;
    }

    @Override
    public Transfer transfer(TransferRequest transferRequest) {
        return transferSPI.transfer(transferRequest);
    }
}
