package uk.co.symposion.app;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@ConfigurationProperties(prefix="test")
@RefreshScope
public class TestProperties {

    public TestProperties() {
        System.out.println("Constructing TestProperties");
    }

    private String myProperty;

    public String getMyProperty() {
        return myProperty;
    }

    public void setMyProperty(String myProperty) {
        this.myProperty = myProperty;
    }

}