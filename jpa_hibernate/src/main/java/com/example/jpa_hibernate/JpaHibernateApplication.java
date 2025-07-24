package com.example.jpa_hibernate;

import com.example.jpa_hibernate.BeanCheck.SingletonBean;
import com.example.jpa_hibernate.BeanCheck.SolutionPrototypeBeanInSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@SpringBootApplication
@EnableTransactionManagement
public class JpaHibernateApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(JpaHibernateApplication.class, args);
	}

	@Autowired
	SingletonBean singletonBean1;

	@Autowired
	SingletonBean singletonBean2;
	@Autowired
	SolutionPrototypeBeanInSingleton solutionPrototypeBeanInSingleton1;
	@Autowired
	SolutionPrototypeBeanInSingleton solutionPrototypeBeanInSingleton2;


	@Override
	public void run(String... args) {
		//SolutionPrototypeBeanInSingleton bean = new SolutionPrototypeBeanInSingleton();
		//bean.showPrototype();
		singletonBean1.showPrototype();
		singletonBean2.showPrototype();
		solutionPrototypeBeanInSingleton1.showPrototype();
		solutionPrototypeBeanInSingleton2.showPrototype();


	}

}
