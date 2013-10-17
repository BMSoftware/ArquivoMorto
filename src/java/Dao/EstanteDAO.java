package Dao;

import Entidade.Estante;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Bruno
 */
public interface EstanteDAO {

    public void setSession(Session session);

    public void salvar(Estante estante);

    public void atualizar(Estante estante);

    public void excluir(Estante estante);

    public Estante getEstante(Integer idEstante);

    public List<Estante> list();
}
