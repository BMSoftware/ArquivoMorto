package Beans;

import Entidade.Caixa;
import Entidade.Prateleira;
import Entidade.Setor;
import RegraDeNegocio.CaixaRN;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

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

    public String novo() {
        caixa = new Caixa();
        return "caixa";
    }

    public String salvar() {
        CaixaRN caixaRN = new CaixaRN();
        caixaRN.salvar(caixa);
        caixa = new Caixa();
        return "arquivo";
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
}
