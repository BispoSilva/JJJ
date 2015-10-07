package dao;

	import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import entity.Montagem;

	@Stateless
	public class MontagemDAO {

		 @PersistenceContext(unitName = "movelaria")
		    private EntityManager entityManager;

		    public void addMontagem(Montagem montagem) throws Exception {
		        entityManager.persist(montagem);
		    }

		    public void deleteMovie(Montagem montagem) throws Exception {
		        entityManager.remove(montagem);
		    }

		    public List<Montagem> getMontagems() throws Exception {

	            CriteriaQuery<Montagem> cq = entityManager.getCriteriaBuilder().createQuery(Montagem.class);
	            cq.select(cq.from(Montagem.class));
	            return entityManager.createQuery(cq).getResultList();
		    }

}
