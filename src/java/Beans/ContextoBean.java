package Beans;

import Entidade.Usuario;
import RegraDeNegocio.UsuarioRN;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author Bruno
 */
@ManagedBean(name = "contextoBean")
@SessionScoped
public class ContextoBean {

    private Usuario usuarioLogado = null;

    public Usuario getUsuarioLogado() {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext external = context.getExternalContext();
        String nomeUsuario = external.getRemoteUser();
        if (this.usuarioLogado == null || !nomeUsuario.equals(this.usuarioLogado.getNomeUsuario())) {
            if (nomeUsuario != null) {
                UsuarioRN usuarioRN = new UsuarioRN();
                this.usuarioLogado = usuarioRN.buscarPorNome(nomeUsuario);
            }
        }
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

}
