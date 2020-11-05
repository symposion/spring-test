package uk.co.symposion;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(TestProperties.class)
public class BootstrapAutoconfiguration {

    @Bean
    public String myTestBean(TestProperties properties) {
        String message = "Constructing test message in bootstrap context, property value: " + properties.getMyProperty();
        System.out.println(message);
        return message;
    }

}
