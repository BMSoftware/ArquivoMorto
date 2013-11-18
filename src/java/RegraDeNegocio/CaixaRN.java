package RegraDeNegocio;

import Beans.ContextoBean;
import Dao.CaixaDAO;
import Dao.DAOFactory;
import Entidade.Caixa;
import Util.ContextoUtil;
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
            ContextoBean contextoBean = ContextoUtil.getContextoBean();
            caixa.setUsuarioArquivou(contextoBean.getUsuarioLogado());
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

    public List<Caixa> listPredio(String nomePredio) {
        return this.caixaDAO.listPredio(nomePredio);
    }

    public List<Caixa> listSetor(String nomeSetor) {
        return this.caixaDAO.listSetor(nomeSetor);
    }

    public List<Caixa> listUsuario(String nomeUsuario) {
        return this.caixaDAO.listUsuario(nomeUsuario);
    }
}
