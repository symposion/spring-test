package uk.co.symposion.app;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.endpoint.event.RefreshEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

import java.util.HashMap;
import java.util.Map;

public class MyBean {

    private final TestProperties testProperties;
    private final TestPropertiesTwo testPropertiesTwo;
    private final TestPropertiesThree testPropsThree;
    private final ApplicationEventPublisher publisher;
    private final ConfigurableEnvironment environment;
    private final DefaultListableBeanFactory beanFactory;

    public MyBean(TestProperties testProperties, TestPropertiesTwo testPropertiesTwo, TestPropertiesThree testPropsThree, ApplicationEventPublisher publisher, ConfigurableEnvironment environment, DefaultListableBeanFactory beanFactory){
        this.testProperties = testProperties;
        this.testPropertiesTwo = testPropertiesTwo;
        this.testPropsThree = testPropsThree;
        this.publisher = publisher;
        this.environment = environment;
        this.beanFactory = beanFactory;
    }

    @EventListener(ApplicationReadyEvent.class)
    @Order()
    public void doSomethingAfterStartup() {
        System.out.println("hello world, I have just started up, bean message is: " + testProperties.getMyProperty());
        System.out.println("hello world, I have just started up, bean message is: " + testPropertiesTwo.getMyProperty());
        System.out.println("hello world, I have just started up, bean message is: " + testPropsThree.getMyProperty());
        Map<String, Object> overrides = new HashMap<>();
        environment.getPropertySources().addFirst(new MapPropertySource("TestPropertySource", overrides));
        overrides.put("test.myProperty", "Override");
        System.out.println("JaveBeanBinding bean scope: " + beanFactory.getBeanDefinition("test-uk.co.symposion.app.TestProperties").getScope());
        System.out.println("ConstructorBinding bean scope: " + beanFactory.getBeanDefinition("test-uk.co.symposion.app.TestPropertiesTwo").getScope());
        System.out.println("Explictly defined bean scope: " + beanFactory.getBeanDefinition("TestPropertiesThree").getScope());
        publisher.publishEvent(new RefreshEvent(this, "Foo", "Bar"));
        System.out.println("Post refresh, java bean binding bean message is: " + testProperties.getMyProperty());
        System.out.println("Post refresh, constructor binding bean message is: " + testPropertiesTwo.getMyProperty());
        System.out.println("Post refresh, explicitly defined bean message is: " + testPropsThree.getMyProperty());
    }

}
