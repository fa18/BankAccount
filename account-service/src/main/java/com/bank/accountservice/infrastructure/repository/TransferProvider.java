package com.bank.accountservice.infrastructure.repository;

import com.bank.accountservice.infrastructure.dto.TransferDTO;
import org.springframework.stereotype.Component;

@Component
public class TransferProvider {

    //private final String transferUrl;

    //TODO: to complete
    public TransferDTO transfer(){
        //update in bdd
        return new TransferDTO("test","test2","15");
    }
}
