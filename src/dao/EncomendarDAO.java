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

    public void addEncomendar(Encomendar by) throws Exception {
    	try {
    		entityManager.merge(by);
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
    }

    public void deleteEncomendar(Encomendar by) throws Exception {
        entityManager.remove(by);
    }

    public List<Encomendar> getEncomendars() throws Exception {

        CriteriaQuery<Encomendar> cq = entityManager.getCriteriaBuilder().createQuery(Encomendar.class);
        cq.select(cq.from(Encomendar.class));
        return entityManager.createQuery(cq).getResultList();
    }
    public Encomendar find(Long id) {
    	return entityManager.find(Encomendar.class, id);
    }
	
}

