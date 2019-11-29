package jcms.ssad.mb;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import jcms.ssad.modelo.Produto;
import jcms.ssad.sessao.IProdutoDAO;

@ViewScoped
@ManagedBean
public class ProdutoBean {
	@EJB
	private IProdutoDAO dao;
	private Produto produto = new Produto();
	private List<Produto> produtos;
	
	public List<Produto> getProdutos(){
		if(produtos == null) {
			produtos = dao.getProdutos();
		}
		
		return produtos;
	}
	
	
	public void saveProduct() {
		if(produto.getId() == null)
			dao.adicionar(produto);
		else
			dao.atualizar(produto);

		produto = new Produto();
		produtos = dao.getProdutos();
	}
	
	public void remover(Produto produto) {
		dao.apagar(produto);
		produtos=dao.getProdutos();
	}

	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	
	
	
	
	
}
