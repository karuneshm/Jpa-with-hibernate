package com.karunesh.jpawithhibernate.databasedemo;


import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.karunesh.jpawithhibernate.databasedemo.entity.Person;

import com.karunesh.jpawithhibernate.databasedemo.jdbc.PersonJpaRepository;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PersonJpaRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All users - > {}" +repository.findAll());
		logger.info("User Id 10001- > {}" +repository.findById(10001));
		//logger.info("User name John- >" +dao.findByName("John"));
		//logger.info("User name Unknown- >" +dao.findByName("Unknown"));
		logger.info("deleting 10002- >{}" +repository.deleteById(10002));
		logger.info("Inserting 10004 ->{}" +
				repository.insert(new Person("Lokesh","Bangalore", new Date())));
		
		logger.info("updates 10003 ->{}" +
				repository.update(new Person(10003,"John","Dubai", new Date())));
	}

}
