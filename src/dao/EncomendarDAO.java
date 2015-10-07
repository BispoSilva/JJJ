package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import entity.Encomendar;

@Stateless
public class EncomendarDAO {

	@PersistenceContext(unitName = "movelaria")
    private EntityManager entityManager;

    public void addEncomendar(Encomendar encomendar) throws Exception {
    	try {
    		entityManager.persist(encomendar);
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
    }

    public void deleteEncomendar(Encomendar encomendar) throws Exception {
        entityManager.remove(encomendar);
    }

    public List<Encomendar> getEncomendars() throws Exception {

        CriteriaQuery<Encomendar> cq = entityManager.getCriteriaBuilder().createQuery(Encomendar.class);
        cq.select(cq.from(Encomendar.class));
        return entityManager.createQuery(cq).getResultList();
    }

	
}

