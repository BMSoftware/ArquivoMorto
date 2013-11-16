package RegraDeNegocio;

import Dao.DAOFactory;
import Dao.TipoArquivoDAO;
import Entidade.TipoArquivo;
import java.util.List;

/**
 *
 * @author Bruno
 */
public class TipoArquivoRN {

    private TipoArquivoDAO tipoArquivoDAO;

    public TipoArquivoRN() {
        this.tipoArquivoDAO = DAOFactory.criarTipoArquivoDAO();
    }

    public void salvar(TipoArquivo tipoArquivo) {
        Integer idTipoArquivo = tipoArquivo.getIdTipoArquivo();
        if (idTipoArquivo == null || idTipoArquivo == 0) {
            this.tipoArquivoDAO.salvar(tipoArquivo);
        } else {
            this.tipoArquivoDAO.atualizar(tipoArquivo);
        }
    }

    public void excluir(TipoArquivo tipoArquivo) {
        this.tipoArquivoDAO.excluir(tipoArquivo);
    }

    public TipoArquivo getTipoArquivo(Integer idTipoArquivo){
        return this.tipoArquivoDAO.getTipoArquivo(idTipoArquivo);
    }
    
    public List<TipoArquivo> list() {
        return this.tipoArquivoDAO.list();
    }
}
