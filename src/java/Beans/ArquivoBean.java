package Beans;

import Entidade.Arquivo;
import Entidade.Caixa;
import RegraDeNegocio.ArquivoRN;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

/**
 *
 * @author Bruno
 */
@ManagedBean(name = "arquivoBean")
@RequestScoped
public class ArquivoBean {

    private Arquivo arquivo = new Arquivo();
    @ManagedProperty(value = "#{caixaBean}")
    private CaixaBean caixaBean;
    private Caixa caixa;

    public String novo() {
        arquivo = new Arquivo();
        return "arquivo";
    }

    public String salvar() {
        ArquivoRN arquivoRN = new ArquivoRN();
        arquivoRN.salvar(arquivo);
        arquivo = new Arquivo();
        return "arquivo";
    }

    public List<SelectItem> getArquivos() {
        List<SelectItem> lista = new ArrayList<SelectItem>();
        for (Arquivo arquivoAtual : new ArquivoRN().list()) {
            lista.add(new SelectItem(arquivoAtual, arquivoAtual.getConteudoArquivo()));
        }
        return lista;
    }

    public Arquivo getArquivo() {
        return arquivo;
    }

    public void setArquivo(Arquivo arquivo) {
        this.arquivo = arquivo;
    }

    public CaixaBean getCaixaBean() {
        return caixaBean;
    }

    public void setCaixaBean(CaixaBean caixaBean) {
        this.caixaBean = caixaBean;
    }

    public Caixa getCaixa() {
        if (caixaBean != null) {
            caixa = caixaBean.getCaixa();
        }
        return caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }

}
