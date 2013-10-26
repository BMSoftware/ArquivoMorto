package Beans;

import Entidade.Predio;
import RegraDeNegocio.PredioRN;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author Bruno
 */
@ManagedBean(name = "predioBean")
@RequestScoped
public class PredioBean {

    private Predio predio = new Predio();

    public String novo() {
        predio = new Predio();
        return "publico/predio";
    }

    public String salvar() {
        PredioRN predioRN = new PredioRN();
        predioRN.salvar(predio);
        return "predio";
    }

    public List<SelectItem> getSetores() {
        List<SelectItem> lista = new ArrayList<SelectItem>();
        for (Predio predioAtual : new PredioRN().list()) {
            lista.add(new SelectItem(predioAtual, predioAtual.getNomePredio()));
        }
        return lista;
    }

    public Predio getPredio() {
        return predio;
    }

    public void setPredio(Predio predio) {
        this.predio = predio;
    }

}
