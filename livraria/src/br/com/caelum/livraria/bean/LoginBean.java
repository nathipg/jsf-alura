package br.com.caelum.livraria.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.caelum.livraria.dao.UsuarioDAO;
import br.com.caelum.livraria.modelo.Usuario;


@ManagedBean
@ViewScoped
public class LoginBean {

	private Usuario usuario = new Usuario();
	
	public String logar() {
		System.out.println("Logar " + this.usuario.getEmail());
		
		boolean existe = new UsuarioDAO().existe(this.usuario);
		
		if(existe) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.getExternalContext().getSessionMap().put("usuarioLogado", this.getUsuario());
			
			return "livro?faces-redirect=true";
		}
		
		return null;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
}
