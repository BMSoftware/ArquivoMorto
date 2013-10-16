package Dao;

import Entidade.Caixa;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Bruno
 */
public interface CaixaDAO {

    public void setSession(Session session);

    public void salvar(Caixa caixa);

    public void atualizar(Caixa caixa);

    public void excluir(Caixa caixa);

    public Caixa getCaixa(int idCaixa);

    public List<Caixa> list();
}
