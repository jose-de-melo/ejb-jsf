package jcms.ssad.ejb;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import jcms.ssad.modelo.Produto;
import jcms.ssad.sessao.IProdutoDAO;

@Remote(IProdutoDAO.class)
@Stateless
public class ProdutoDAOBean implements IProdutoDAO {

	
	@PersistenceContext
	private EntityManager em;
	
	public void adicionar(Produto produto) {
		em.persist(produto);
	}

	public void apagar(Produto produto) {
		System.out.println(produto);
		em.remove(em.getReference(Produto.class, produto.getId()));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Produto> getProdutos() {
		Query q = em.createQuery("select p from Produto p");
		
		return q.getResultList();
	}

	@Override
	public void atualizar(Produto produto) {
		em.merge(produto);
	}

}
