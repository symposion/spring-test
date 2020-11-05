package uk.co.symposion.app;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@ConfigurationProperties(prefix = "test")
@RefreshScope
public class TestPropertiesTwo {

    private final String myProperty;

    @ConstructorBinding
    public TestPropertiesTwo(String myProperty) {
        this.myProperty = myProperty;
        System.out.println("Constructoring TestPropertiesTwo");
    }


    public String getMyProperty() {
        return myProperty;
    }

}