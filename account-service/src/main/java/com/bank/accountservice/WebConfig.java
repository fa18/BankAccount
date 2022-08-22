package com.bank.accountservice;

import com.bank.accountservice.application.TransferApplication;
import com.bank.accountservice.domain.transfer.TransferApiImpl;
import com.bank.accountservice.domain.transfer.api.TransferAPI;
import com.bank.accountservice.domain.transfer.spi.TransferSPI;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.time.Duration.ofMillis;

@Configuration
public class WebConfig {

    private final Integer POOL_MAX = 10;
    private final Integer TIMEOUT = 1000;
    private final Integer CONNECTION_TIMEOUT = 10000;
    private final Integer KEEP_ALIVE_DURATION = 10000;

    @Bean
    public RestTemplate restTemplate(){
        OkHttpClient okhttpClient = new OkHttpClient
                .Builder()
                .connectionPool(new ConnectionPool(POOL_MAX,KEEP_ALIVE_DURATION, TimeUnit.MILLISECONDS))
                .connectTimeout(ofMillis(CONNECTION_TIMEOUT))
                .callTimeout(ofMillis(TIMEOUT))
                .build()
        ;

        RestTemplate restTemplate = new RestTemplate(new OkHttp3ClientHttpRequestFactory(okhttpClient));

        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);
        restTemplate.setMessageConverters(messageConverters);

        return restTemplate;
    }

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer(){
        return builder -> {
            builder.propertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        };
    }
}
