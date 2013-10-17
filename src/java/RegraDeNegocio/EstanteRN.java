package RegraDeNegocio;

import Dao.DAOFactory;
import Dao.EstanteDAO;
import Entidade.Estante;
import java.util.List;

/**
 *
 * @author Bruno
 */
public class EstanteRN {

    private EstanteDAO estanteDAO;

    public EstanteRN() {
        this.estanteDAO = DAOFactory.criarEstanteDAO();
    }

    public Estante getEstante(Integer idEstante) {
        return this.estanteDAO.getEstante(idEstante);
    }

    public void salvar(Estante estante) {
        Integer idEstante = estante.getIdEstante();
        if (idEstante == null || idEstante == 0) {
            this.estanteDAO.salvar(estante);
        } else {
            this.estanteDAO.atualizar(estante);
        }
    }

    public void excluir(Estante estante) {
        this.estanteDAO.excluir(estante);
    }

    public List<Estante> list() {
        return this.estanteDAO.list();
    }
}
