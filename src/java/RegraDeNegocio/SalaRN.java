package RegraDeNegocio;

import Dao.DAOFactory;
import Dao.SalaDAO;
import Entidade.Sala;
import java.util.List;

/**
 *
 * @author Bruno
 */
public class SalaRN {

    private SalaDAO salaDAO;

    public SalaRN() {
        this.salaDAO = DAOFactory.criarSalaDAO();
    }

    public Sala getSala(Integer idSala) {
        return this.salaDAO.getSala(idSala);
    }

    public void salvar(Sala sala) {
        Integer idSala = sala.getIdSala();
        if (idSala == null || idSala == 0) {
            this.salaDAO.salvar(sala);
        } else {
            this.salaDAO.atualizar(sala);
        }
    }

    public void excluir(Sala sala) {
        this.salaDAO.excluir(sala);
    }

    public List<Sala> list() {
        return this.salaDAO.list();
    }
}
