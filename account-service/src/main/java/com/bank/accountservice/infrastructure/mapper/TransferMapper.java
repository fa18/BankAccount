package com.bank.accountservice.infrastructure.mapper;

import com.bank.accountservice.domain.transfer.entity.Transfer;
import com.bank.accountservice.infrastructure.dto.TransferDTO;
import org.springframework.stereotype.Component;

@Component
public class TransferMapper {

    public Transfer toDomain(TransferDTO  transferDTO){
        return new Transfer(
                transferDTO.getIbanSource(),
                transferDTO.getIbanDestination(),
                transferDTO.getAmount()
        );
    }

    public TransferDTO toDTO(Transfer  transfer){
        return new TransferDTO(
                transfer.getIbanSource(),
                transfer.getIbanDestination(),
                transfer.getAmount()
        );
    }
}
