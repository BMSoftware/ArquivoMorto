package Beans;

import Entidade.Arquivo;
import RegraDeNegocio.ArquivoRN;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Bruno
 */
@ManagedBean(name = "arquivoBean")
@RequestScoped
public class ArquivoBean {

    private Arquivo arquivo = new Arquivo();

    public String novo() {
        arquivo = new Arquivo();
        return "publico/arquivo";
    }

    public String salvar() {
        ArquivoRN arquivoRN = new ArquivoRN();
        arquivoRN.salvar(arquivo);
        arquivo = new Arquivo();
        return "arquivo";
    }

    public Arquivo getArquivo() {
        return arquivo;
    }

    public void setArquivo(Arquivo arquivo) {
        this.arquivo = arquivo;
    }
}
