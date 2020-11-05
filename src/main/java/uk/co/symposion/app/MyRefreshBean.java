package uk.co.symposion.app;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

public class MyRefreshBean {
    public MyRefreshBean() {
        System.out.println("Constructing my refresh bean");
    }

    public void foo() {

    }

}
