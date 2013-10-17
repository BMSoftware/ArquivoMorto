package Beans;

import Entidade.Setor;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import Entidade.Usuario;
import RegraDeNegocio.UsuarioRN;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

/**
 *
 * @author Bruno
 */
@ManagedBean(name = "usuarioBean")
@RequestScoped
public class UsuarioBean {

    private Usuario usuario = new Usuario();
    private String confirmaSenha;
    @ManagedProperty(value = "#{setorBean}")
    private SetorBean setorBean;
    private Setor setor;

    public String novo() {
        this.usuario = new Usuario();
        this.usuario.setStatusUsuario(true);
        return "publico/usuario";
    }

    public String salvar() {
        FacesContext context = FacesContext.getCurrentInstance();
        
        String senha = this.usuario.getSenhaUsuario();
        if (!senha.equals(this.confirmaSenha)) {
            FacesMessage facesMessage = new FacesMessage("A senha não foi confirmada corretamente");
            context.addMessage(null, facesMessage);
            return null;
        }
        UsuarioRN usuarioRN = new UsuarioRN();
        usuarioRN.salvar(this.usuario);

        return "usuario";
    }

    public SetorBean getSetorBean() {
        return setorBean;
    }

    public void setSetorBean(SetorBean setorBean) {
        this.setorBean = setorBean;
    }

    public Setor getSetor() {
        if (setorBean != null) {
            setor = setorBean.getSetor();
        }
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getConfirmaSenha() {
        return confirmaSenha;
    }

    public void setConfirmaSenha(String confirmaSenha) {
        this.confirmaSenha = confirmaSenha;
    }
}
