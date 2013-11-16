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
import org.hibernate.envers.Audited;

/**
 * @author Bruno
 */
@Audited
@Entity
@Table(name = "arquivo", catalog = "arquivomorto_db")
public class Arquivo implements java.io.Serializable {

    private Integer idArquivo;
    private String conteudoArquivo;
    private Caixa caixa;
    private TipoArquivo tipoArquivo;
    private Usuario usuarioResponsavel;

    public Arquivo() {
    }

    public Arquivo(String conteudoArquivo) {
        this.conteudoArquivo = conteudoArquivo;
    }

    public Arquivo(String conteudoArquivo, Caixa caixa, TipoArquivo tipoArquivo, Usuario usuarioResponsavel) {
        this.conteudoArquivo = conteudoArquivo;
        this.caixa = caixa;
        this.tipoArquivo = tipoArquivo;
        this.usuarioResponsavel = usuarioResponsavel;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_arquivo", nullable = false)
    public TipoArquivo getTipoArquivo() {
        return tipoArquivo;
    }

    public void setTipoArquivo(TipoArquivo tipoArquivo) {
        this.tipoArquivo = tipoArquivo;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario_responsavel", nullable = false)
    public Usuario getUsuarioResponsavel() {
        return usuarioResponsavel;
    }

    public void setUsuarioResponsavel(Usuario usuarioResponsavel) {
        this.usuarioResponsavel = usuarioResponsavel;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (this.idArquivo != null ? this.idArquivo.hashCode() : 0);
        hash = 97 * hash + (this.conteudoArquivo != null ? this.conteudoArquivo.hashCode() : 0);
        hash = 97 * hash + (this.caixa != null ? this.caixa.hashCode() : 0);
        hash = 97 * hash + (this.tipoArquivo != null ? this.tipoArquivo.hashCode() : 0);
        hash = 97 * hash + (this.usuarioResponsavel != null ? this.usuarioResponsavel.hashCode() : 0);
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
        if (this.tipoArquivo != other.tipoArquivo && (this.tipoArquivo == null || !this.tipoArquivo.equals(other.tipoArquivo))) {
            return false;
        }
        if (this.usuarioResponsavel != other.usuarioResponsavel && (this.usuarioResponsavel == null || !this.usuarioResponsavel.equals(other.usuarioResponsavel))) {
            return false;
        }
        return true;
    }

}
