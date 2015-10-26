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


import entity.Produto;

@Stateful
public class ProdutoDAO {

	@PersistenceContext(unitName = "movelaria")
	 EntityManager entityManager;

	 public ProdutoDAO(){
	 }
	 
	 public Produto findProduto(Long id) throws Exception {
	           return entityManager.find(Produto.class, id);
	  }
	 
	 public List<Produto> cloneProdutos(List<Produto> produtos) throws Exception {
		 List<Produto> temp = new LinkedList<Produto>();
		 
		 for(Produto b: produtos) {
	
	Produto b1 = this.findProduto(b.getId());
			temp.add(b1);
		 }
		 return temp;
}
	 public void addProduto(Produto produto) throws Exception {
	        entityManager.merge(produto);
	    }

	    public void deleteProduto(Produto produto) throws Exception {
	        entityManager.remove(produto);
	    }

	    
	    public List<Produto> getProdutos() throws Exception {
	    	System.out.print(entityManager == null);
         CriteriaQuery<Produto> cq = entityManager.getCriteriaBuilder().createQuery(Produto.class);
         cq.select(cq.from(Produto.class));
         return entityManager.createQuery(cq).getResultList();
	    }
}