package jcms.ssad.sessao;

import java.util.List;

import jcms.ssad.modelo.Produto;

public interface IProdutoDAO {
	void adicionar(Produto produto);
	void apagar(Produto produto);
	List<Produto> getProdutos();
	void atualizar(Produto produto);
}
