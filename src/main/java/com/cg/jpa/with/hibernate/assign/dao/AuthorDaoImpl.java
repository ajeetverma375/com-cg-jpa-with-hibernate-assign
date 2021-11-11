package com.cg.jpa.with.hibernate.assign.dao;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;

import com.cg.jpa.with.hibernate.assign.entities.Author;


public class AuthorDaoImpl implements AuthorDao 
{
	private EntityManager entityManager;
	public AuthorDaoImpl()
	{
		entityManager = JPAUtil.getEntityManager();
	}

	@Override
	public Author getAuthorByAuthorId(int id) 
	{
		Author author = entityManager.find(Author.class, id);
		System.out.println("getEmployeeById in EmployeeDaoImpl");
		return author;
	}

	@Override
	public void addAuthor(Author author) throws EntityExistsException
	{
		entityManager.persist(author);
		// entityManager.
		// CRUD - insert - persist(), select - find(), update - merge(), delete - remove() 
		// select * from students where first_name = "Sachin";
	}

	@Override
	public void removeAuthor(Author author) {
		entityManager.remove(author);
	}

	@Override
	public void updateAuthor(Author author) {
		entityManager.merge(author);
	}

	@Override
	public void beginTransaction() {
		entityManager.getTransaction().begin();
	}

	@Override
	public void commitTransaction() {
		entityManager.getTransaction().commit();
	}
}
