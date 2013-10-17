package Dao;

import Entidade.Caixa;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Bruno
 */
public class CaixaDAOHib implements CaixaDAO {

    private Session session;

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public void salvar(Caixa caixa) {
        this.session.save(caixa);
    }

    @Override
    public void atualizar(Caixa caixa) {
        this.session.update(caixa);
    }

    @Override
    public void excluir(Caixa caixa) {
        this.session.delete(caixa);
    }

    @Override
    public Caixa getCaixa(Integer idCaixa) {
        return (Caixa) this.session.get(Caixa.class, idCaixa);
    }

    @Override
    public List<Caixa> list() {
        return this.session.createCriteria(Caixa.class).list();
    }
}
