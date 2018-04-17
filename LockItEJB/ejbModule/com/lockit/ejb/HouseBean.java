package com.lockit.ejb;


import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.lockit.entity.House;


@Stateless(mappedName="HouseBean")
@LocalBean
public class HouseBean implements HouseBeanRemote, HouseBeanLocal {

	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("LockItORM");
	EntityManager entityManager = emf.createEntityManager();
	

	public HouseBean() {
		
	}
	
	
	@Override
	public void insertHouse(House house) {
		entityManager.getTransaction().begin();
		entityManager.persist(house); 
		entityManager.getTransaction().commit();
	}
	
	
	@Override
	public House getHouseById(int id) {
		return (House) entityManager.find(House.class, id);
    }

    
	@Override
	@SuppressWarnings("unchecked")
	public List<House> getAllHouses() {
		return entityManager.createQuery("From House").getResultList();
    }

 
	@Override
    public void updateHouse(House house) {
		entityManager.getTransaction().begin();
		entityManager.merge(house); 
		entityManager.getTransaction().commit();
    }
	
	
	@Override
	public void deleteHouse(int id) {
		House house = (House) entityManager.find(House.class, id);
		entityManager.getTransaction().begin();
		entityManager.remove(house); 
		entityManager.getTransaction().commit();
    }
    
	
	@Override
	public void deleteAllHouses() {
		entityManager.getTransaction().begin();
		entityManager.createQuery("DELETE * From House").executeUpdate();
		entityManager.getTransaction().commit();
    }
}
