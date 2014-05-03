package com.rt.rt;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



/**
 * Bean do wykonywania operacji CRUD na encji Employee
 * 
 * @author rafal
 *
 */
@Repository
public class EmpDAO {
	@PersistenceContext(unitName= "entityManager")
	private EntityManager entityManager;
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	private static final Logger log = LoggerFactory.getLogger(EmpDAO.class);
	
	public Employee find(long employeeId){
	
		return 	entityManager.find(Employee.class,employeeId );
	}
	
	
	/**
	 * kazdy upadate na bazie wymaga anotacji Transactional
	 * dodatkowo zeby to zadzialalo potrzebny jest cglib
	 * @param emp
	 */
	@Transactional 
	public void create(Employee emp){
		entityManager.persist(emp);
	}
	
	
	@Transactional 
	public void deteleById(long employeeId){
		delete(find(employeeId));
	}
	
	
	@Transactional 
	public void delete(Employee emp){
		entityManager.remove(emp);
		
	}
	
}
