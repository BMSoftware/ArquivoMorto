package Beans;

import Entidade.TipoArquivo;
import RegraDeNegocio.TipoArquivoRN;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author Bruno
 */
@ManagedBean(name = "tipoArquivoBean")
@RequestScoped
public class TipoArquivoBean {

    private TipoArquivo tipoArquivo = new TipoArquivo();

    public String Novo() {
        tipoArquivo = new TipoArquivo();
        return "tipo_arquivo";
    }

    public String salvar() {
        TipoArquivoRN tipoArquivoRN = new TipoArquivoRN();
        tipoArquivoRN.salvar(tipoArquivo);
        tipoArquivo = new TipoArquivo();
        return "tipo_arquivo";
    }

    public List<SelectItem> getTipoArquivos() {
        List<SelectItem> lista = new ArrayList<SelectItem>();
        for (TipoArquivo tipoArquivoAtual : new TipoArquivoRN().list()) {
            lista.add(new SelectItem(tipoArquivoAtual, tipoArquivoAtual.getDescricao()));
        }
        return lista;
    }

    public TipoArquivo getTipoArquivo() {
        return tipoArquivo;
    }

    public void setTipoArquivo(TipoArquivo tipoArquivo) {
        this.tipoArquivo = tipoArquivo;
    }

}
