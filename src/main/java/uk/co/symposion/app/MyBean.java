package uk.co.symposion.app;


import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.endpoint.event.RefreshEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
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

}
