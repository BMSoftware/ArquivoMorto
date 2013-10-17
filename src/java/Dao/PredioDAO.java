package Dao;

import Entidade.Predio;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Bruno
 */
public interface PredioDAO {

    public void setSession(Session session);

    public void salvar(Predio predio);

    public void atualizar(Predio predio);

    public void excluir(Predio predio);

    public Predio getPredio(Integer idPredio);

    public List<Predio> list();
}
