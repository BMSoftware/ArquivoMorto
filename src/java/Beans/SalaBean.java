package Beans;

import Entidade.Predio;
import Entidade.Sala;
import RegraDeNegocio.SalaRN;
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
@ManagedBean(name = "salaBean")
@RequestScoped
public class SalaBean {

    private Sala sala = new Sala();
    @ManagedProperty(value = "#{predioBean}")
    private PredioBean predioBean;
    private Predio predio;

    public String novo() {
        sala = new Sala();
        return "sala";
    }

    public String salvar() {
        SalaRN salaRN = new SalaRN();
        salaRN.salvar(sala);
        sala = new Sala();
        return "sala";
    }

    public List<SelectItem> getSalas() {
        List<SelectItem> lista = new ArrayList<SelectItem>();
        for (Sala salaAtual : new SalaRN().list()) {
            lista.add(new SelectItem(salaAtual, String.valueOf(salaAtual.getNumeroSala())));
        }
        return lista;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public PredioBean getPredioBean() {
        return predioBean;
    }

    public void setPredioBean(PredioBean predioBean) {
        this.predioBean = predioBean;
    }

    public Predio getPredio() {
        if (predioBean != null) {
            predio = predioBean.getPredio();
        }
        return predio;
    }

    public void setPredio(Predio predio) {
        this.predio = predio;
    }

}
