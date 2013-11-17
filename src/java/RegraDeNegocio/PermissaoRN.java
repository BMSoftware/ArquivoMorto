package RegraDeNegocio;

import Dao.DAOFactory;
import Dao.PermissaoDAO;
import Entidade.Permissao;
import java.util.List;

/**
 *
 * @author Bruno
 */
public class PermissaoRN {

    private PermissaoDAO permissaoDAO;

    public PermissaoRN() {
        this.permissaoDAO = DAOFactory.criarPermissaoDAO();
    }

    public Permissao getPermissao(String nomePermissao) {
        return this.permissaoDAO.getPermissao(nomePermissao);
    }

    public void salvar(Permissao permissao) {
        this.permissaoDAO.salvar(permissao);
    }

    public void atualizar(Permissao permissao) {
        this.permissaoDAO.atualizar(permissao);
    }

    public void excluir(Permissao permissao) {
        this.permissaoDAO.excluir(permissao);
    }

    public List<Permissao> list() {
        return this.permissaoDAO.list();
    }
}
