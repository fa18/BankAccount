package com.bank.accountservice.domain.transfer.spi;

import com.bank.accountservice.domain.transfer.entity.Transfer;
import com.bank.accountservice.infrastructure.dto.TransferRequest;

public interface TransferSPI {

    Transfer transfer(TransferRequest transferRequest);
}
