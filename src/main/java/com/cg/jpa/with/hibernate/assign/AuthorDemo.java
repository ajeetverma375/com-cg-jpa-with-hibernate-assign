package com.cg.jpa.with.hibernate.assign;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cg.jpa.with.hibernate.assign.entities.Author;


public interface AuthorDemo {
public static void main(String[] args) {
		
		System.out.println("Start");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("abcd");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tr = em.getTransaction();
		
		tr.begin();
		Author aut1 = new Author(101,"Akash","kumar","Singh",9989745612l);
		Author emp2 = new Author(102,"Nikhil","null","sharma",7894562186l);
		Author emp3 = new Author(103,"Chetan",null,"tambe",8523697413l);
		
		// Inserting record  ---> After insertion we cannot again insert that record
		em.persist(aut1);  //insert
		em.persist(emp2);
		em.persist(emp3);
		
//		em.remove(emp2);
		
		// Updating record
//		emp1.setFirstName("Akhilesh");
//		em.merge(emp1);    //Update
		
		// Displaying record
		Author aut = em.find(Author.class, 101);   //Select
		System.out.println(aut.toString());
		
		tr.commit();
		System.out.println("End");
}
}
