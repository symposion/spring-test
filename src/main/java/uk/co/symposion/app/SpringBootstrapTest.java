package uk.co.symposion.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.ConfigurableEnvironment;
import uk.co.symposion.TestProperties;

@SpringBootApplication
@EnableConfigurationProperties(TestProperties.class)
public class SpringBootstrapTest {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootstrapTest.class, args);
    }

    @Bean
    public MyBean getMyBean(TestProperties props, ApplicationEventPublisher publisher, ConfigurableEnvironment environment){
        return new MyBean(props, publisher, environment);
    }

}
