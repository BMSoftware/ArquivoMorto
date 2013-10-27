package Beans;

import Entidade.Setor;
import RegraDeNegocio.SetorRN;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author Bruno
 */
@ManagedBean(name = "setorBean")
@RequestScoped
public class SetorBean {

    private Setor setor = new Setor();

    public String novo() {
        setor = new Setor();
        return "setor";
    }

    public String salvar() {
        SetorRN setorRN = new SetorRN();
        setorRN.salvar(setor);
        setor = new Setor();
        return "setor";
    }

    public List<SelectItem> getSetores() {
        List<SelectItem> lista = new ArrayList<SelectItem>();
        for (Setor setorAtual : new SetorRN().list()) {
            lista.add(new SelectItem(setorAtual, setorAtual.getNomeSetor()));
        }
        return lista;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }
}
