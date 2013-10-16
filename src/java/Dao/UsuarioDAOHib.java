package Dao;

import Entidade.Usuario;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Bruno
 */
public class UsuarioDAOHib implements UsuarioDAO {

    private Session session;

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public void salvar(Usuario usuario) {
        this.session.save(usuario);
    }

    @Override
    public void atualizar(Usuario usuario) {
        this.session.update(usuario);
    }

    @Override
    public void excluir(Usuario usuario) {
        this.session.delete(usuario);
    }

    @Override
    public Usuario getUsuario(int idUsuario) {
        return (Usuario) this.session.get(Usuario.class, idUsuario);
    }

    @Override
    public Usuario getUsuarioNome(String nomeUsuario) {
        Criteria criteria = this.session.createCriteria(Usuario.class);
        criteria.add(Restrictions.eq("nomeUsuario", nomeUsuario));
        return (Usuario)criteria.uniqueResult();
    }

    @Override
    public List<Usuario> list() {
        return this.session.createCriteria(Usuario.class).list();
    }
}
