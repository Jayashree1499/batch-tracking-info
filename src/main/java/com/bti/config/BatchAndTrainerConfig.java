package com.bti.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.bti.controller","com.bti.dao","com.bti.dto"})
public class BatchAndTrainerConfig {

}
