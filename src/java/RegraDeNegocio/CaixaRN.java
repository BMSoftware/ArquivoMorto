package RegraDeNegocio;

import Dao.CaixaDAO;
import Dao.DAOFactory;
import Entidade.Caixa;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Bruno
 */
public class CaixaRN {

    private CaixaDAO caixaDAO;

    public CaixaRN() {
        this.caixaDAO = DAOFactory.criarCaixaDAO();
    }

    public Caixa getCaixa(Integer idCaixa) {
        return this.caixaDAO.getCaixa(idCaixa);
    }

    public void salvar(Caixa caixa) {
        Integer idCaixa = caixa.getIdCaixa();
        if (idCaixa == null || idCaixa == 0) {
            caixa.setDataArquivamentoCaixa(new Date(System.currentTimeMillis()));
            this.caixaDAO.salvar(caixa);
        } else {
            this.caixaDAO.atualizar(caixa);
        }
    }

    public void excluir(Caixa caixa) {
        this.caixaDAO.excluir(caixa);
    }

    public List<Caixa> list() {
        return this.caixaDAO.list();
    }
}
