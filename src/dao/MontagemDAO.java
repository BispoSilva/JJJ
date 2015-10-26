package dao;

import java.util.LinkedList;
import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;


import entity.Montagem;

@Stateful
public class MontagemDAO {

	@PersistenceContext(unitName = "movelaria")
	 EntityManager entityManager;

	 public MontagemDAO(){
	 }
	 
	 public Montagem findMontagem(Long id) throws Exception {
	           return entityManager.find(Montagem.class, id);
	  }
	 
	 public List<Montagem> cloneMontagems(List<Montagem> montagems) throws Exception {
		 List<Montagem> temp = new LinkedList<Montagem>();
		 
		 for(Montagem b: montagems) {
	
			 Montagem b1 = this.findMontagem(b.getId());
			temp.add(b1);
		 }
		 return temp;
}
	 public void addMontagem(Montagem montagem) throws Exception {
	        entityManager.merge(montagem);
	    }

	    public void deleteMontagem(Montagem montagem) throws Exception {
	        entityManager.remove(montagem);
	    }

	    
	    public List<Montagem> getMontagems() throws Exception {
	    	System.out.print(entityManager == null);
         CriteriaQuery<Montagem> cq = entityManager.getCriteriaBuilder().createQuery(Montagem.class);
         cq.select(cq.from(Montagem.class));
         return entityManager.createQuery(cq).getResultList();
	    }
}