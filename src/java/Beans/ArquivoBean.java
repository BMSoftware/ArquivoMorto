package Beans;

import Entidade.Arquivo;
import Entidade.Caixa;
import RegraDeNegocio.ArquivoRN;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
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
    private DataModel listaArquivos;
    private String filtro = "";
    private String valorFiltro = "";

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
    
    public String excluir(){
        Arquivo arquivoTemp = (Arquivo)(listaArquivos.getRowData());
        ArquivoRN arquivoRN = new ArquivoRN();
        arquivoRN.excluir(arquivoTemp);
        return "listar_arquivo";
    }

    public String listarArquivos() {
        return "listar_arquivo";
    }

    public List<SelectItem> getArquivos() {
        List<SelectItem> lista = new ArrayList<SelectItem>();
        for (Arquivo arquivoAtual : new ArquivoRN().list()) {
            lista.add(new SelectItem(arquivoAtual, arquivoAtual.getConteudoArquivo()));
        }
        return lista;
    }

    public DataModel getListarArquivos() {
        List<Arquivo> lista = getListaFiltrada();
        listaArquivos = new ListDataModel(lista);
        return listaArquivos;
    }

    private List<Arquivo> getListaFiltrada() {
        if (filtro.equals("caixa")) {
            return new ArquivoRN().listCaixa(valorFiltro);
        }
        if (filtro.equals("tipoArquivo")) {
            return new ArquivoRN().listTipoArquivo(valorFiltro);
        }
        if (filtro.equals("usuario")) {
            return new ArquivoRN().listUsuario(valorFiltro);
        }
        return new ArquivoRN().list();
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

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }

    public String getValorFiltro() {
        return valorFiltro;
    }

    public void setValorFiltro(String valorFiltro) {
        this.valorFiltro = valorFiltro;
    }

}
