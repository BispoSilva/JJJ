package dao;


	import java.util.List;

	import javax.ejb.Stateless;
	import javax.persistence.EntityManager;
	import javax.persistence.PersistenceContext;
	import javax.persistence.criteria.CriteriaQuery;

	import entity.Estoque;

	@Stateless
	public class EstoqueDAO {

		@PersistenceContext(unitName = "movelaria")
	    private EntityManager entityManager;

	    public void addEstoque(Estoque estoque) throws Exception {
	    	try {
	    		entityManager.persist(estoque);
	    	}
	    	catch(Exception e){
	    		e.printStackTrace();
	    	}
	    }

	    public void deleteEncomendar(Estoque estoque) throws Exception {
	        entityManager.remove(estoque);
	    }

	    public List<Estoque> getEstoques() throws Exception {

	        CriteriaQuery<Estoque> cq = entityManager.getCriteriaBuilder().createQuery(Estoque.class);
	        cq.select(cq.from(Estoque.class));
	        return entityManager.createQuery(cq).getResultList();
	    }

		

}
