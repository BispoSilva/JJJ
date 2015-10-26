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


import entity.Estoque;

@Stateful
public class EstoqueDAO {

	@PersistenceContext(unitName = "movelaria")
	 EntityManager entityManager;

	 public EstoqueDAO(){
	 }
	 
	 public Estoque findEstoque(Long id) throws Exception {
	           return entityManager.find(Estoque.class, id);
	  }
	 
	 public List<Estoque> cloneEstoques(List<Estoque> estoques) throws Exception {
		 List<Estoque> temp = new LinkedList<Estoque>();
		 
		 for(Estoque b: estoques) {
	
			 Estoque b1 = this.findEstoque(b.getId());
			temp.add(b1);
		 }
		 return temp;
}
	 public void addEstoque(Estoque estoque) throws Exception {
	        entityManager.merge(estoque);
	    }

	    public void deleteEstoque(Estoque estoque) throws Exception {
	        entityManager.remove(estoque);
	    }

	    
	    public List<Estoque> getEstoques() throws Exception {
	    	System.out.print(entityManager == null);
         CriteriaQuery<Estoque> cq = entityManager.getCriteriaBuilder().createQuery(Estoque.class);
         cq.select(cq.from(Estoque.class));
         return entityManager.createQuery(cq).getResultList();
	    }
}