package com.bank.accountservice.domain.transfer.api;

import com.bank.accountservice.domain.transfer.entity.Transfer;
import com.bank.accountservice.infrastructure.dto.TransferRequest;

public interface TransferAPI {

    Transfer transfer(TransferRequest transferRequest);


}
