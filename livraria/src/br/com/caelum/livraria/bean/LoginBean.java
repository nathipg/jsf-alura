package br.com.caelum.livraria.bean;

import javax.faces.application.FacesMessage;
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
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		if(existe) {
			context.getExternalContext().getSessionMap().put("usuarioLogado", this.getUsuario());
			
			return "livro?faces-redirect=true";
		}
		
		context.getExternalContext().getFlash().setKeepMessages(true); // Manter as mensagens por 2 requisições
		context.addMessage(null, new FacesMessage("Email e/ou senha incorreta"));
		
		return "login?faces-redirect=true";
	}
	
	public String deslogar() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap().remove("usuarioLogado");
		
		return "login?faces-redirect=true";
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
}
