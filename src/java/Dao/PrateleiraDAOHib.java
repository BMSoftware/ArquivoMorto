package Dao;

import Entidade.Prateleira;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Bruno
 */
public class PrateleiraDAOHib implements PrateleiraDAO {

    private Session session;

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public void salvar(Prateleira prateleira) {
        this.session.save(prateleira);
    }

    @Override
    public void atualizar(Prateleira prateleira) {
        this.session.update(prateleira);
    }

    @Override
    public void excluir(Prateleira prateleira) {
        this.session.delete(prateleira);
    }

    @Override
    public Prateleira getPrateleira(Integer idPrateleira) {
        return (Prateleira) this.session.get(Prateleira.class, idPrateleira);
    }

    @Override
    public List<Prateleira> list() {
        return this.session.createCriteria(Prateleira.class).list();
    }
}
