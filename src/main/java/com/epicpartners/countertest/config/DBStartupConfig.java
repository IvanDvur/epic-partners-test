package com.epicpartners.countertest.config;

import com.epicpartners.countertest.model.Counter;
import com.epicpartners.countertest.repositories.CounterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class DBStartupConfig {

    private final CounterRepository counterRepository;

    @Bean
    public CommandLineRunner commandLineRunner(){
        return (args) ->{
            counterRepository.save(new Counter("a",120));
            counterRepository.save(new Counter("b",41241));
            counterRepository.save(new Counter("c",1));
            counterRepository.save(new Counter("123",532));
            counterRepository.save(new Counter("321",420));
            counterRepository.save(new Counter("bla-bla",0));
        };
    }
}
