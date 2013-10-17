package Dao;

import Entidade.Permissao;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Bruno
 */
public interface PermissaoDAO {

    public void setSession(Session session);

    public void salvar(Permissao permissao);

    public void atualizar(Permissao permissao);

    public void excluir(Permissao permissao);

    public Permissao getPermissao(Integer idPermissao);

    public List<Permissao> list();
}
