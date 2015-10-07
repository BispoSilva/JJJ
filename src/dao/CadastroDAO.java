package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import entity.Cadastro;

@Stateless
public class CadastroDAO {

	 @PersistenceContext(unitName = "movelaria")
	    private EntityManager entityManager;

	    public void addCadastro(Cadastro cadastro) throws Exception {
	        entityManager.persist(cadastro);
	    }

	    public void deleteMovie(Cadastro cadastro) throws Exception {
	        entityManager.remove(cadastro);
	    }

	    public List<Cadastro> getCadastros() throws Exception {

            CriteriaQuery<Cadastro> cq = entityManager.getCriteriaBuilder().createQuery(Cadastro.class);
            cq.select(cq.from(Cadastro.class));
            return entityManager.createQuery(cq).getResultList();
	    }
}
