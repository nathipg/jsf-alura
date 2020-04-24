package pissuti.nathalia.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class LivroBean {

	private Livro livro = new Livro();

	public void gravar() {
		System.out.println("Gravando livro: " + this.livro.getTitulo());
	}
	
	public Livro getLivro() {
		return livro;
	}

}
