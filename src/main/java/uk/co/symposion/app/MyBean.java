package uk.co.symposion.app;


import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.endpoint.event.RefreshEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;

public class MyBean {


    private final ApplicationEventPublisher publisher;
    private final MyRefreshBean myRefresh;
    private final MyRefreshBeanTwo myRefreshTwo;
    private final MyRefreshBeanThree myRefreshThree;
    private final MyRefreshBeanFour myRefreshFour;

    public MyBean(ApplicationEventPublisher publisher, MyRefreshBean myRefresh, MyRefreshBeanTwo myRefreshTwo, MyRefreshBeanThree myRefreshThree, MyRefreshBeanFour myRefreshFour){
        this.publisher = publisher;
        this.myRefresh = myRefresh;
        this.myRefreshTwo = myRefreshTwo;
        this.myRefreshThree = myRefreshThree;
        this.myRefreshFour = myRefreshFour;
    }

    @EventListener(ApplicationReadyEvent.class)
    @Order()
    public void doSomethingAfterStartup() {
        System.out.println("hello world, I have just started up");
        myRefresh.foo();
        myRefreshTwo.foo();
        myRefreshThree.foo();
        myRefreshFour.foo();
        publisher.publishEvent(new RefreshEvent(this, "Foo", "Bar"));
        System.out.println("Post refresh");
        myRefresh.foo();
        myRefreshTwo.foo();
        myRefreshThree.foo();
        myRefreshFour.foo();

    }

}
