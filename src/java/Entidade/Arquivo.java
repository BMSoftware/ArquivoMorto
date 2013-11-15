package Entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Bruno
 */
@Entity
@Table(name = "arquivo", catalog = "arquivomorto_db")
public class Arquivo implements java.io.Serializable {

    private Integer idArquivo;
    private String conteudoArquivo;
    private Caixa caixa;

    public Arquivo() {
    }

    public Arquivo(String conteudoArquivo) {
        this.conteudoArquivo = conteudoArquivo;
    }

    public Arquivo(String conteudoArquivo, Caixa caixa) {
        this.conteudoArquivo = conteudoArquivo;
        this.caixa = caixa;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_caixa", nullable = false)
    public Caixa getCaixa() {
        return this.caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + (this.idArquivo != null ? this.idArquivo.hashCode() : 0);
        hash = 11 * hash + (this.conteudoArquivo != null ? this.conteudoArquivo.hashCode() : 0);
        hash = 11 * hash + (this.caixa != null ? this.caixa.hashCode() : 0);
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
        if (this.caixa != other.caixa && (this.caixa == null || !this.caixa.equals(other.caixa))) {
            return false;
        }
        return true;
    }

}
