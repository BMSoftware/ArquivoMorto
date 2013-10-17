package RegraDeNegocio;

import Dao.DAOFactory;
import Dao.PredioDAO;
import Entidade.Predio;
import java.util.List;

/**
 *
 * @author Bruno
 */
public class PredioRN {

    private PredioDAO predioDAO;

    public PredioRN() {
        this.predioDAO = DAOFactory.criarPredioDAO();
    }

    public Predio getPredio(Integer idPredio) {
        return this.predioDAO.getPredio(idPredio);
    }

    public void salvar(Predio predio) {
        Integer idPredio = predio.getIdPredio();
        if (idPredio == null || idPredio == 0) {
            this.predioDAO.salvar(predio);
        } else {
            this.predioDAO.atualizar(predio);
        }
    }

    public void excluir(Predio predio) {
        this.predioDAO.excluir(predio);
    }

    public List<Predio> list() {
        return this.predioDAO.list();
    }
}
