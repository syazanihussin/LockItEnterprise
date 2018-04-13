package com.lockit.ejb;


import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import com.lockit.entity.House;


@Stateless
@LocalBean
public class HouseBean implements HouseBeanRemote, HouseBeanLocal {

    
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("LockItORM");
	EntityManager entityManager = emf.createEntityManager();
	
    public HouseBean() {
        
    }
    
    
    //@PersistenceContext(unitName="LockItORM")
    //private EntityManager entityManager;

    
    @Override
    public void addHouse(House house) {
    	entityManager.persist(house);
     } 
    
 
    @Override
    public  House getHouseById(int id) {
       return (House) entityManager.find(House.class, id);
    }

    
    @Override
    public void deleteHouse(int id) {
       House lecturer = this.entityManager.find(House.class, id);
       this.entityManager.remove(lecturer);
    }

    
    @Override
    public void updateHouse(House house) {
    	entityManager.merge(house);
    }
   

	@Override
	@SuppressWarnings("unchecked")
     public List<House> getAllHouses() {
        return entityManager.createQuery("From House").getResultList();
     }

}
