package Dao;

import Entidade.Sala;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Bruno
 */
public interface SalaDAO {

    public void setSession(Session session);

    public void salvar(Sala sala);

    public void atualizar(Sala sala);

    public void excluir(Sala sala);

    public Sala getSala(int idSala);

    public List<Sala> list();
}
