package uk.co.symposion.app;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@RefreshScope
@Component
public class MyRefreshBeanThree {

    public MyRefreshBeanThree() {
        System.out.println("Constructing my refresh bean three");
    }

    public void foo() {

    }

}
