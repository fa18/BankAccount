package com.bank.accountservice.infrastructure.adapter;

import com.bank.accountservice.domain.transfer.entity.Transfer;
import com.bank.accountservice.domain.transfer.spi.TransferSPI;
import com.bank.accountservice.infrastructure.dto.TransferDTO;
import com.bank.accountservice.infrastructure.dto.TransferRequest;
import com.bank.accountservice.infrastructure.mapper.TransferMapper;
import com.bank.accountservice.infrastructure.repository.TransferProvider;
import org.springframework.stereotype.Component;

@Component
public class TransferAdapter implements TransferSPI {

    private final TransferProvider transferProvider;
    private final TransferMapper transferMapper;

    public TransferAdapter(TransferProvider transferProvider, TransferMapper transferMapper) {
        this.transferProvider = transferProvider;
        this.transferMapper = transferMapper;
    }

    @Override
    public Transfer transfer(TransferRequest transferRequest) {
        TransferDTO transferDTO = transferProvider.transfer();
        return transferMapper.toDomain(transferDTO);
    }
}
