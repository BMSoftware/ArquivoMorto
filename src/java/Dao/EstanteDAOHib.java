package Dao;

import Entidade.Estante;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Bruno
 */
public class EstanteDAOHib implements EstanteDAO {

    private Session session;

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public void salvar(Estante estante) {
        this.session.save(estante);
    }

    @Override
    public void atualizar(Estante estante) {
        this.session.update(estante);
    }

    @Override
    public void excluir(Estante estante) {
        this.session.delete(estante);
    }

    @Override
    public Estante getEstante(int idEstante) {
        return (Estante) this.session.get(Estante.class, idEstante);
    }

    @Override
    public List<Estante> list() {
        return this.session.createCriteria(Estante.class).list();
    }
}
