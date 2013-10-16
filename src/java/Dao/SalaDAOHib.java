package Dao;

import Entidade.Sala;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Bruno
 */
public class SalaDAOHib implements SalaDAO {

    private Session session;

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public void salvar(Sala sala) {
        this.session.save(sala);
    }

    @Override
    public void atualizar(Sala sala) {
        this.session.update(sala);
    }

    @Override
    public void excluir(Sala sala) {
        this.session.delete(sala);
    }

    @Override
    public Sala getSala(int idSala) {
        return (Sala) this.session.get(Sala.class, idSala);
    }

    @Override
    public List<Sala> list() {
        return this.session.createCriteria(Sala.class).list();
    }
}
