package RegraDeNegocio;

import Dao.DAOFactory;
import Dao.UsuarioDAO;
import Entidade.Usuario;
import java.util.List;

/**
 *
 * @author Bruno
 */
public class UsuarioRN {

    private UsuarioDAO usuarioDAO;

    public UsuarioRN() {
        this.usuarioDAO = DAOFactory.criarUsuarioDAO();
    }

    public Usuario getUsuario(Integer idUsuario) {
        return this.usuarioDAO.getUsuario(idUsuario);
    }

    public Usuario buscarPorNome(String nome) {
        return this.usuarioDAO.getUsuarioNome(nome);
    }

    public void salvar(Usuario usuario) {
        Integer idUsuario = usuario.getIdUsuario();
        if (idUsuario == null || idUsuario == 0) {
            usuario.getPermissaos().add(new PermissaoRN().getPermissao("ROLE_USER"));
            this.usuarioDAO.salvar(usuario);
        } else {
            this.usuarioDAO.atualizar(usuario);
        }
    }

    public void excluir(Usuario usuario) {
        this.usuarioDAO.excluir(usuario);
    }

    public List<Usuario> list() {
        return this.usuarioDAO.list();
    }
}
