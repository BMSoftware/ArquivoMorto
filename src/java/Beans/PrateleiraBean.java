package Beans;

import Entidade.Estante;
import Entidade.Prateleira;
import RegraDeNegocio.PrateleiraRN;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author Bruno
 */
@ManagedBean(name = "prateleiraBean")
@RequestScoped
public class PrateleiraBean {

    private Prateleira prateleira = new Prateleira();
    @ManagedProperty(value = "#{estanteBean}")
    private EstanteBean estanteBean;
    private Estante estante;

    public String novo() {
        prateleira = new Prateleira();
        return "prateleira";
    }

    public String salvar() {
        PrateleiraRN prateleiraRN = new PrateleiraRN();
        prateleiraRN.salvar(prateleira);
        prateleira = new Prateleira();
        return "prateleira";
    }

    public List<SelectItem> getPrateleiras() {
        List<SelectItem> lista = new ArrayList<SelectItem>();
        for (Prateleira prateleiraAtual : new PrateleiraRN().list()) {
            lista.add(new SelectItem(prateleiraAtual, prateleiraAtual.getNomePrateleira()));
        }
        return lista;
    }

    public Prateleira getPrateleira() {
        return prateleira;
    }

    public void setPrateleira(Prateleira prateleira) {
        this.prateleira = prateleira;
    }

    public EstanteBean getEstanteBean() {
        return estanteBean;
    }

    public void setEstanteBean(EstanteBean estanteBean) {
        this.estanteBean = estanteBean;
    }

    public Estante getEstante() {
        if (estanteBean != null) {
            estante = estanteBean.getEstante();
        }
        return estante;
    }

    public void setEstante(Estante estante) {
        this.estante = estante;
    }
}
