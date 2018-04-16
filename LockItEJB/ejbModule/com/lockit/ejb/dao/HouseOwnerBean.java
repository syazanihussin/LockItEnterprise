package com.lockit.ejb.dao;


import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.lockit.entity.HouseOwner;


@Stateless(mappedName="HouseOwnerBean")
@LocalBean
public class HouseOwnerBean implements HouseOwnerBeanRemote, HouseOwnerBeanLocal {

    
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("LockItORM");
	EntityManager entityManager = emf.createEntityManager();
	
	
	public HouseOwnerBean() {
		
	}
	
	
	@Override
	public void insertHouseOwner(HouseOwner houseOwner) {
		entityManager.getTransaction().begin();
		entityManager.persist(houseOwner); 
		entityManager.getTransaction().commit();
	}
	
	
	@Override
	public HouseOwner getHouseOwnerById(int id) {
		return (HouseOwner) entityManager.find(HouseOwner.class, id);
    }

    
	@Override
	@SuppressWarnings("unchecked")
	public List<HouseOwner> getAllHouseOwners() {
		return entityManager.createQuery("From HouseOwner").getResultList();
    }

 
	@Override
    public void updateHouseOwner(HouseOwner houseOwner) {
		entityManager.getTransaction().begin();
		entityManager.merge(houseOwner); 
		entityManager.getTransaction().commit();
    }
	
	
	@Override
	public void deleteHouseOwner(int id) {
		HouseOwner houseOwner = (HouseOwner) entityManager.find(HouseOwner.class, id);
		entityManager.getTransaction().begin();
		entityManager.remove(houseOwner); 
		entityManager.getTransaction().commit();
    }
    
	
	@Override
	public void deleteAllHouseOwners() {
		entityManager.getTransaction().begin();
		entityManager.createQuery("DELETE * From HouseOwner").executeUpdate();
		entityManager.getTransaction().commit();
    }
}
