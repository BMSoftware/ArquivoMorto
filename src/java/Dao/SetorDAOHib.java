package Dao;

import Entidade.Setor;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Bruno
 */
public class SetorDAOHib implements SetorDAO {

    private Session session;

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public void salvar(Setor setor) {
        this.session.save(setor);
    }

    @Override
    public void atualizar(Setor setor) {
        this.session.update(setor);
    }

    @Override
    public void excluir(Setor setor) {
        this.session.delete(setor);
    }

    @Override
    public Setor getSetor(int idSetor) {
        return (Setor) this.session.get(Setor.class, idSetor);
    }

    @Override
    public List<Setor> list() {
        return this.session.createCriteria(Setor.class).list();
    }
}
