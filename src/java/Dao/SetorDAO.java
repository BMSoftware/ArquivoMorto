package Dao;

import Entidade.Setor;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Bruno
 */
public interface SetorDAO {

    public void setSession(Session session);

    public void salvar(Setor setor);

    public void atualizar(Setor setor);

    public void excluir(Setor setor);

    public Setor getSetor(Integer idSetor);

    public List<Setor> list();
}
