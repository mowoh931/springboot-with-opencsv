package com.baar.springbootwithopencsv.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeneralConfig {
    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
