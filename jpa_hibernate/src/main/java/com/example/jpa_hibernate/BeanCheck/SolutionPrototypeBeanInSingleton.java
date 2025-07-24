package com.example.jpa_hibernate.BeanCheck;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SolutionPrototypeBeanInSingleton {

    @Autowired
    private ObjectFactory<PrototypeBean> prototypeFactory;

    public void showPrototype() {
        PrototypeBean pb = prototypeFactory.getObject();
        System.out.println("Solution of PrototypeBean in SolutionPrototypeBeanInSingleton: " + pb);
    }
}
