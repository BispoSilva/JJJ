package dao;


	import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import entity.Servico;

	@Stateless
	public class ServicoDAO {

		 @PersistenceContext(unitName = "movelaria")
		    private EntityManager entityManager;

		    public void addServico(Servico servico) throws Exception {
		        entityManager.persist(servico);
		    }

		    public void deleteMovie(Servico servico) throws Exception {
		        entityManager.remove(servico);
		    }

		    public List<Servico> getServicos() throws Exception {

	            CriteriaQuery<Servico> cq = entityManager.getCriteriaBuilder().createQuery(Servico.class);
	            cq.select(cq.from(Servico.class));
	            return entityManager.createQuery(cq).getResultList();
		    }

}
