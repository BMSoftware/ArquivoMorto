package Dao;

import Entidade.Prateleira;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Bruno
 */
public interface PrateleiraDAO {

    public void setSession(Session session);

    public void salvar(Prateleira prateleira);

    public void atualizar(Prateleira prateleira);

    public void excluir(Prateleira prateleira);

    public Prateleira getPrateleira(Integer idPrateleira);

    public List<Prateleira> list();
}
