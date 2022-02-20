package io.github.lsj8367.demo.example.configuration;

import io.github.lsj8367.demo.example.factorybean.MessageFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConfiguration {

    @Bean
    public MessageFactoryBean messageFactoryBean() {
        return new MessageFactoryBean("test");
    }

}
