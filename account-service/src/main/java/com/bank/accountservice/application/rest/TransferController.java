package com.bank.accountservice.application.rest;

import com.bank.accountservice.application.TransferApplication;
import com.bank.accountservice.domain.transfer.entity.Transfer;
import com.bank.accountservice.infrastructure.dto.TransferDTO;
import com.bank.accountservice.infrastructure.dto.TransferRequest;
import com.bank.accountservice.infrastructure.mapper.TransferMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class TransferController {

    private final TransferMapper transferMapper;
    private final TransferApplication transferApplication;

    public TransferController(TransferMapper transferMapper, TransferApplication transferApplication) {
        this.transferMapper = transferMapper;
        this.transferApplication = transferApplication;
    }

    @PostMapping(path = "{contract_id}/transfer")
    public TransferDTO transfer(
            @RequestBody TransferRequest transferRequest,
            @PathVariable(name = "contract_id") Integer contractId
    ){
        Transfer transfer = transferApplication.transfer(transferRequest,contractId);
        return transferMapper.toDTO(transfer);
    }
}
