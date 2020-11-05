package uk.co.symposion.app;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="test")
public class MyRefreshBeanFour {

    public MyRefreshBeanFour() {
        System.out.println("Constructing my refresh bean four");
    }

    public void foo() {

    }

}
