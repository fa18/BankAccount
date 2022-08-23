package com.bank.accountservice.application.rest;

import com.bank.accountservice.application.TransferApplication;
import com.bank.accountservice.domain.transfer.entity.Transfer;
import com.bank.accountservice.infrastructure.dto.TransferDTO;
import com.bank.accountservice.infrastructure.dto.TransferRequest;
import com.bank.accountservice.infrastructure.mapper.TransferMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.web.util.UriComponentsBuilder;

import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;

public class TransferControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    @Qualifier("transferApplication")
    private TransferApplication transferApplication;

    @MockBean
    private TransferMapper transferMapper;

    private final static TransferRequest TRANSFER_REQUEST = new TransferRequest("XXX","YYY","12");

    private final static Integer CONTRACT_ID = 123456789;

    private final static Transfer TRANSFER = new Transfer("XXX","YYY","12");

    private final static String TRANSFER_URL = "/account/"+CONTRACT_ID+"/transfer";

    @Test
    void should_execute_transfer_with_ok_http_status() throws Exception {
        given(transferApplication.transfer(TRANSFER_REQUEST,CONTRACT_ID)).willReturn(TRANSFER);

        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(TRANSFER_URL)
                .queryParam("contract_id")
        ;

        mvc.perform(MockMvcRequestBuilders.get(builder.build().toUri())
                .contentType(APPLICATION_JSON)
                .accept(APPLICATION_JSON)
                .param("contract_id", String.valueOf(CONTRACT_ID))
        ).andExpect(MockMvcResultMatchers.status().is(200));


    }
}
