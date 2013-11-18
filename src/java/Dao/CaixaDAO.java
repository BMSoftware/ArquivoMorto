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

    public Caixa getCaixa(Integer idCaixa);

    public List<Caixa> list();
    
    public List<Caixa> listPredio(String nomePredio);
    
    public List<Caixa> listSetor(String nomeSetor);
    
    public List<Caixa> listUsuario(String nomeUsuario);
}
