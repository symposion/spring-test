package uk.co.symposion;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@ConfigurationProperties(prefix="test")
@RefreshScope
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
