package Beans;

import Entidade.Estante;
import Entidade.Sala;
import RegraDeNegocio.EstanteRN;
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
@ManagedBean(name = "estanteBean")
@RequestScoped
public class EstanteBean {

    private Estante estante = new Estante();
    @ManagedProperty(value = "#{salaBean}")
    private SalaBean salaBean;
    private Sala sala;

    public String novo() {
        estante = new Estante();
        return "estante";
    }

    public String salvar() {
        EstanteRN estanteRN = new EstanteRN();
        estanteRN.salvar(estante);
        estante = new Estante();
        return "estante";
    }

    public List<SelectItem> getEstantes() {
        List<SelectItem> lista = new ArrayList<SelectItem>();
        for (Estante estanteAtual : new EstanteRN().list()) {
            lista.add(new SelectItem(estanteAtual, estanteAtual.getNomeEstante()));
        }
        return lista;
    }

    public Estante getEstante() {
        return estante;
    }

    public void setEstante(Estante estante) {
        this.estante = estante;
    }

    public SalaBean getSalaBean() {
        return salaBean;
    }

    public void setSalaBean(SalaBean salaBean) {
        this.salaBean = salaBean;
    }

    public Sala getSala() {
        if (salaBean != null) {
            sala = salaBean.getSala();
        }
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }
}
