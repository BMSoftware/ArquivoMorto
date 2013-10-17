package Entidade;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author Bruno
 */
@Entity
@Table(name = "arquivo", catalog = "arquivomorto_db")
public class Arquivo implements java.io.Serializable {

    private Integer idArquivo;
    private String conteudoArquivo;
    private List<Caixa> caixas = new ArrayList<Caixa>();

    public Arquivo() {
    }

    public Arquivo(String conteudoArquivo) {
        this.conteudoArquivo = conteudoArquivo;
    }

    public Arquivo(String conteudoArquivo, List<Caixa> caixas) {
        this.conteudoArquivo = conteudoArquivo;
        this.caixas = caixas;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_arquivo", unique = true, nullable = false)
    public Integer getIdArquivo() {
        return this.idArquivo;
    }

    public void setIdArquivo(Integer idArquivo) {
        this.idArquivo = idArquivo;
    }

    @Column(name = "conteudo_arquivo", nullable = false, length = 150)
    public String getConteudoArquivo() {
        return this.conteudoArquivo;
    }

    public void setConteudoArquivo(String conteudoArquivo) {
        this.conteudoArquivo = conteudoArquivo;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "arquivos")
    public List<Caixa> getCaixas() {
        return this.caixas;
    }

    public void setCaixas(List<Caixa> caixas) {
        this.caixas = caixas;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (this.idArquivo != null ? this.idArquivo.hashCode() : 0);
        hash = 97 * hash + (this.conteudoArquivo != null ? this.conteudoArquivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Arquivo other = (Arquivo) obj;
        if (this.idArquivo != other.idArquivo && (this.idArquivo == null || !this.idArquivo.equals(other.idArquivo))) {
            return false;
        }
        if ((this.conteudoArquivo == null) ? (other.conteudoArquivo != null) : !this.conteudoArquivo.equals(other.conteudoArquivo)) {
            return false;
        }
        return true;
    }
}
