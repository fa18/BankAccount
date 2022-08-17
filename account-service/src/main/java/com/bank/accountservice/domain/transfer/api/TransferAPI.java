package com.bank.accountservice.domain.transfer.api;

import com.bank.accountservice.domain.transfer.entity.Transfer;

public interface TransferAPI {

    Transfer transfer(String ibanSource,String IbanDestination,String amount);


}
