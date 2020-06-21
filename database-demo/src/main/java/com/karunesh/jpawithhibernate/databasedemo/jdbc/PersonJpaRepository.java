package com.karunesh.jpawithhibernate.databasedemo.jdbc;




import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.karunesh.jpawithhibernate.databasedemo.entity.Person;

@Repository
@Transactional
public class PersonJpaRepository {
	
	
	@PersistenceContext
	private EntityManager entity;
		
//	//HQL 
//	public List<Person> findAll(){
//		List<Person> resultList = entity.createQuery("from Person").getResultList();
//		return resultList;
//		
//	}
	
	//nameQuery
	
	public List<Person> findAll() {
		TypedQuery<Person> personList = entity.
				createNamedQuery("find_all_persons", Person.class);
		return personList.getResultList();
	}
	
	public Person findById(int id){
		return entity.find(Person.class,id);
		
	}
	

	public Person insert(Person person) {
		return entity.merge(person);
	}
	
	public Person update(Person person) {
		return entity.merge(person);
	}
	
	public String deleteById(int id) {
		Person person = findById(id);
		entity.remove(person);
		return "The Person with Id "+id+" is deleted";
	}
	
}
