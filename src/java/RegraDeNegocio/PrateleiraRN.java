package RegraDeNegocio;

import Dao.DAOFactory;
import Dao.PrateleiraDAO;
import Entidade.Prateleira;
import java.util.List;

/**
 *
 * @author Bruno
 */
public class PrateleiraRN {

    private PrateleiraDAO prateleiraDAO;

    public PrateleiraRN() {
        this.prateleiraDAO = DAOFactory.criarPrateleiraDAO();
    }

    public Prateleira getPrateleira(Integer idPrateleira) {
        return this.prateleiraDAO.getPrateleira(idPrateleira);
    }

    public void salvar(Prateleira prateleira) {
        Integer idPrateleira = prateleira.getIdPrateleira();
        if (idPrateleira == null || idPrateleira == 0) {
            this.prateleiraDAO.salvar(prateleira);
        } else {
            this.prateleiraDAO.atualizar(prateleira);
        }
    }

    public void excluir(Prateleira prateleira) {
        this.prateleiraDAO.excluir(prateleira);
    }

    public List<Prateleira> list() {
        return this.prateleiraDAO.list();
    }
}
