package uk.co.symposion.app;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@RefreshScope
@ConfigurationProperties(prefix="test")
public class MyRefreshBeanTwo {


    public MyRefreshBeanTwo() {
        System.out.println("Constructing my refresh bean two");
    }

    public void foo() {

    }

}
