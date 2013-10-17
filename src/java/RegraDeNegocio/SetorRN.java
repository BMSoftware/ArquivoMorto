package RegraDeNegocio;

import Dao.DAOFactory;
import Dao.SetorDAO;
import Entidade.Setor;
import java.util.List;

/**
 *
 * @author Bruno
 */
public class SetorRN {

    private SetorDAO setorDAO;

    public SetorRN() {
        this.setorDAO = DAOFactory.criarSetorDAO();
    }

    public Setor getSetor(Integer idSetor) {
        return this.setorDAO.getSetor(idSetor);
    }

    public void salvar(Setor setor) {
        Integer idSetor = setor.getIdSetor();
        if (idSetor == null || idSetor == 0) {
            this.setorDAO.salvar(setor);
        } else {
            this.setorDAO.atualizar(setor);
        }
    }

    public void excluir(Setor setor) {
        this.setorDAO.excluir(setor);
    }

    public List<Setor> list() {
        return this.setorDAO.list();
    }
}
