package Beans;

import Entidade.Caixa;
import Entidade.Prateleira;
import Entidade.Setor;
import RegraDeNegocio.CaixaRN;
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
@ManagedBean(name = "caixaBean")
@RequestScoped
public class CaixaBean {

    private Caixa caixa = new Caixa();
    @ManagedProperty(value = "#{prateleiraBean}")
    private PrateleiraBean prateleiraBean;
    private Prateleira prateleira;
    @ManagedProperty(value = "#{setorBean}")
    private SetorBean setorBean;
    private Setor setor;
    private DataModel listaCaixas;
    private String filtro = "";
    private String valorFiltro = "";

    public String novo() {
        caixa = new Caixa();
        return "caixa";
    }

    public String salvar() {
        CaixaRN caixaRN = new CaixaRN();
        caixaRN.salvar(caixa);
        caixa = new Caixa();
        return "caixa";
    }

    public String listarCaixas() {
        return "listar_caixa";
    }

    public List<SelectItem> getCaixas() {
        List<SelectItem> lista = new ArrayList<SelectItem>();
        for (Caixa caixaAtual : new CaixaRN().list()) {
            lista.add(new SelectItem(caixaAtual, caixaAtual.getNomeCaixa()));
        }
        return lista;
    }

    public DataModel getListarCaixas() {
        List<Caixa> lista = getListaFiltrada();
        listaCaixas = new ListDataModel(lista);
        return listaCaixas;
    }

    private List<Caixa> getListaFiltrada() {
        if (filtro.equals("predio")) {
            return new CaixaRN().listPredio(valorFiltro);
        }
        if (filtro.equals("setor")) {
            return new CaixaRN().listSetor(valorFiltro);
        }
        if (filtro.equals("usuario")) {
            return new CaixaRN().listUsuario(valorFiltro);
        }
        return new CaixaRN().list();
    }

    public Caixa getCaixa() {
        return caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }

    public PrateleiraBean getPrateleiraBean() {
        return prateleiraBean;
    }

    public void setPrateleiraBean(PrateleiraBean prateleiraBean) {
        this.prateleiraBean = prateleiraBean;
    }

    public Prateleira getPrateleira() {
        if (prateleiraBean != null) {
            prateleira = prateleiraBean.getPrateleira();
        }
        return prateleira;
    }

    public void setPrateleira(Prateleira prateleira) {
        this.prateleira = prateleira;
    }

    public SetorBean getSetorBean() {
        return setorBean;
    }

    public void setSetorBean(SetorBean setorBean) {
        this.setorBean = setorBean;
    }

    public Setor getSetor() {
        if (setorBean != null) {
            setor = setorBean.getSetor();
        }
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
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
