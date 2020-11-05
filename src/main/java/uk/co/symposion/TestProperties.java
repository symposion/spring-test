package uk.co.symposion;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConfigurationProperties(prefix="test")
public class TestProperties {

    private final String myProperty;

    @ConstructorBinding
    public TestProperties(String myProperty) {

        this.myProperty = myProperty;
    }

    public String getMyProperty() {
        return myProperty;
    }

}
