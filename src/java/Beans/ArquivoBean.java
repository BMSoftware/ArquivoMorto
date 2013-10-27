package Beans;

import Entidade.Arquivo;
import RegraDeNegocio.ArquivoRN;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;

/**
 *
 * @author Bruno
 */
@ManagedBean(name = "arquivoBean")
@RequestScoped
public class ArquivoBean {

    private Arquivo arquivo = new Arquivo();
    private List<Arquivo> listarArquivos;
    private Arquivo arquivoSelecionado;

    public void prepararAdicionarArquivo(ActionEvent actionEvent) {
        this.arquivo = new Arquivo();
    }

//    public void prepararAlterarArquivo(ActionEvent actionEvent) {
//        arquivo = (Arquivo) (listarArquivos.getRowData());
//    }
//
//    public String excluirArquivos() {
//        Arquivo arquivoTemp = (Arquivo) (listarArquivos.getRowData());
//        ArquivoRN arquivoRN = new ArquivoRN();
//        arquivoRN.excluir(arquivoTemp);
//        return "arquivo";
//    }
    public void adicionarArquivo(ActionEvent actionEvent) {
        ArquivoRN arquivoRN = new ArquivoRN();
        arquivoRN.salvar(arquivo);
    }

    public void alterarArquivo(ActionEvent actionEvent) {
        ArquivoRN arquivoRN = new ArquivoRN();
        arquivoRN.salvar(arquivo);
    }

    public Arquivo getArquivo() {
        return arquivo;
    }

    public void setArquivo(Arquivo arquivo) {
        this.arquivo = arquivo;
    }

    public List<Arquivo> getListarArquivos() {
        listarArquivos = new ArrayList<Arquivo>(new ArquivoRN().list());
        return listarArquivos;
    }

    public Arquivo getArquivoSelecionado() {
        return arquivoSelecionado;
    }

    public void setArquivoSelecionado(Arquivo arquivoSelecionado) {
        this.arquivoSelecionado = arquivoSelecionado;
    }

}
