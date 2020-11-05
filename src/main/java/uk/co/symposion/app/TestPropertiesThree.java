package uk.co.symposion.app;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@ConfigurationProperties(prefix="test")
public class TestPropertiesThree {

    public TestPropertiesThree() {
        System.out.println("Constructing TestPropertiesThree");
    }

    private String myProperty;

    public String getMyProperty() {
        return myProperty;
    }

    public void setMyProperty(String myProperty) {
        this.myProperty = myProperty;
    }

}