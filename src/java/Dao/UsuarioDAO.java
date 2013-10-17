package Dao;

import Entidade.Usuario;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Bruno
 */
public interface UsuarioDAO {
    
    public void setSession(Session session);

    public void salvar(Usuario usuario);

    public void atualizar(Usuario usuario);

    public void excluir(Usuario usuario);

    public Usuario getUsuario(Integer idUsuario);

    public Usuario getUsuarioNome(String nomeUsuario);

    public List<Usuario> list();
}
