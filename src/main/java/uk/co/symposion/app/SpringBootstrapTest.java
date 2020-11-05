package uk.co.symposion.app;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
@EnableConfigurationProperties({TestProperties.class, TestPropertiesTwo.class})
public class SpringBootstrapTest {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootstrapTest.class, args);
    }

    @Bean
    public MyBean getMyBean(TestProperties props, TestPropertiesTwo testPropsTwo, TestPropertiesThree testPropsThree, ApplicationEventPublisher publisher, ConfigurableEnvironment environment, DefaultListableBeanFactory beanFactory){
        return new MyBean(props, testPropsTwo, testPropsThree, publisher, environment,beanFactory);
    }

    @Bean
    @RefreshScope
    public TestPropertiesThree TestPropertiesThree() {
        return new TestPropertiesThree();
    }

}
