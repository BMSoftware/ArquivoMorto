package Dao;

import Entidade.Permissao;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Bruno
 */
public class PermissaoDAOHib implements PermissaoDAO {

    private Session session;

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public void salvar(Permissao permissao) {
        this.session.save(permissao);
    }

    @Override
    public void atualizar(Permissao permissao) {
        this.session.update(permissao);
    }

    @Override
    public void excluir(Permissao permissao) {
        this.session.delete(permissao);
    }

    @Override
    public Permissao getPermissao(Integer idPermissao) {
        return (Permissao) this.session.get(Permissao.class, idPermissao);
    }

    @Override
    public List<Permissao> list() {
        return this.session.createCriteria(Permissao.class).list();
    }
}
