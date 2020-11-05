package uk.co.symposion.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(MyRefreshBeanTwo.class)
public class SpringBootstrapTest {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootstrapTest.class, args);
    }

    @Bean
    public MyBean getMyBean(ApplicationEventPublisher publisher, MyRefreshBean myRefreshBean, MyRefreshBeanTwo myRefreshBeanTwo, MyRefreshBeanThree three, MyRefreshBeanFour four){
        return new MyBean(publisher, myRefreshBean, myRefreshBeanTwo, three, four);
    }

    @Bean
    @RefreshScope
    public MyRefreshBeanFour myRefreshBeanFour() {
        return new MyRefreshBeanFour();
    }


    @Bean
    @RefreshScope
    public MyRefreshBean myRefreshBean() {
        return new MyRefreshBean();
    }

}
