package com.example.jpa_hibernate.BeanCheck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SingletonBean {
    private final PrototypeBean prototypeBean;

    @Autowired
    public SingletonBean(PrototypeBean prototypeBean) {
        this.prototypeBean = prototypeBean;
    }

    public void showPrototype() {
        System.out.println("Using PrototypeBean in SingletonBean: " + prototypeBean);
    }
}