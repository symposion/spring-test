package uk.co.symposion.app;


import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.endpoint.event.RefreshEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import uk.co.symposion.TestProperties;

import java.util.Map;

public class MyBean {

    private final TestProperties testProperties;
    private final ApplicationEventPublisher publisher;
    private final ConfigurableEnvironment environment;

    public MyBean(TestProperties testProperties, ApplicationEventPublisher publisher, ConfigurableEnvironment environment){
        this.testProperties = testProperties;
        this.publisher = publisher;
        this.environment = environment;
    }

    @EventListener(ApplicationReadyEvent.class)
    @Order()
    public void doSomethingAfterStartup() {
        System.out.println("hello world, I have just started up, bean message is: " + testProperties.getMyProperty());
        environment.getPropertySources().addFirst(new MapPropertySource("TestPropertySource", Map.of("test.myProperty", "Override")));
        publisher.publishEvent(new RefreshEvent(this, "Foo", "Bar"));
        System.out.println("Post refresh, bean message is: " + testProperties.getMyProperty());
    }

}
