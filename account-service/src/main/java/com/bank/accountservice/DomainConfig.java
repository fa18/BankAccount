package com.bank.accountservice;

import com.bank.accountservice.application.TransferApplication;
import com.bank.accountservice.domain.transfer.TransferApiImpl;
import com.bank.accountservice.domain.transfer.api.TransferAPI;
import com.bank.accountservice.domain.transfer.entity.Transfer;
import com.bank.accountservice.domain.transfer.spi.TransferSPI;
import com.bank.accountservice.infrastructure.mapper.TransferMapper;
import com.bank.accountservice.infrastructure.repository.TransferProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainConfig {

    @Bean
    TransferApplication transferApplication(
            TransferAPI transferAPI
    ){
        return new TransferApplication(transferAPI);
    }

    @Bean
    TransferAPI transferAPI(TransferSPI transferSPI){
        return new TransferApiImpl(transferSPI);
    }
}
