package com.bank.accountservice.application.rest;

import com.bank.accountservice.application.TransferApplication;
import com.bank.accountservice.domain.transfer.entity.Transfer;
import com.bank.accountservice.infrastructure.dto.TransferDTO;
import com.bank.accountservice.infrastructure.dto.TransferRequest;
import com.bank.accountservice.infrastructure.mapper.TransferMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class TransferController {

    private final TransferMapper transferMapper;
    private final TransferApplication transferApplication;

    public TransferController(TransferMapper transferMapper, TransferApplication transferApplication) {
        this.transferMapper = transferMapper;
        this.transferApplication = transferApplication;
    }

    @PostMapping(path = "transfer")
    public TransferDTO transfer(
            @RequestBody TransferRequest transferRequest
    ){
        Transfer transfer = transferApplication.transfer(transferRequest);
        TransferDTO transferDTO = transferMapper.toDTO(transfer);
        return transferDTO;
    }
}
