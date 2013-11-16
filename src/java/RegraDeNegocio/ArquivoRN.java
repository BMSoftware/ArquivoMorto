package RegraDeNegocio;

import Beans.ContextoBean;
import Dao.ArquivoDAO;
import Dao.DAOFactory;
import Entidade.Arquivo;
import Util.ContextoUtil;
import java.util.List;

/**
 *
 * @author Bruno
 */
public class ArquivoRN {

    private ArquivoDAO arquivoDAO;

    public ArquivoRN() {
        this.arquivoDAO = DAOFactory.criarArquivoDAO();
    }

    public Arquivo getArquivo(Integer idArquivo) {
        return this.arquivoDAO.getArquivo(idArquivo);
    }

    public void salvar(Arquivo arquivo) {
        Integer idArquivo = arquivo.getIdArquivo();
        if (idArquivo == null || idArquivo == 0) {
            ContextoBean contextoBean = ContextoUtil.getContextoBean();
            arquivo.setUsuarioResponsavel(contextoBean.getUsuarioLogado());
            this.arquivoDAO.salvar(arquivo);
        } else {
            this.arquivoDAO.atualizar(arquivo);
        }
    }

    public void excluir(Arquivo arquivo) {
        this.arquivoDAO.excluir(arquivo);
    }

    public List<Arquivo> list() {
        return this.arquivoDAO.list();
    }
}
