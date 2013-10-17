package Dao;

import Entidade.Predio;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Bruno
 */
public class PredioDAOHib implements PredioDAO {

    private Session session;

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public void salvar(Predio predio) {
        this.session.save(predio);
    }

    @Override
    public void atualizar(Predio predio) {
        this.session.update(predio);
    }

    @Override
    public void excluir(Predio predio) {
        this.session.delete(predio);
    }

    @Override
    public Predio getPredio(Integer idPredio) {
        return (Predio) this.session.get(Predio.class, idPredio);
    }

    @Override
    public List<Predio> list() {
        return this.session.createCriteria(Predio.class).list();
    }
}
