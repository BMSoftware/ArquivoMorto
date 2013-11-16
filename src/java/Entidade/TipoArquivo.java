package Entidade;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.envers.Audited;

/**
 *
 * @author Bruno
 */
@Audited
@Entity
@Table(name = "tipo_arquivo", catalog = "arquivomorto_db")
public class TipoArquivo implements Serializable {

    private Integer idTipoArquivo;
    private String descricao;
    private List<Arquivo> arquivos;

    public TipoArquivo() {
    }

    public TipoArquivo(String descricao) {
        this.descricao = descricao;
    }

    public TipoArquivo(String descricao, List<Arquivo> arquivos) {
        this.descricao = descricao;
        this.arquivos = arquivos;
    }

    @Id
    @GeneratedValue
    @Column(name = "id_tipo_arquivo", unique = true, nullable = false)
    public Integer getIdTipoArquivo() {
        return idTipoArquivo;
    }

    public void setIdTipoArquivo(Integer idTipoArquivo) {
        this.idTipoArquivo = idTipoArquivo;
    }

    @Column(name = "descricao_tipo_arquivo", nullable = false, length = 150)
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tipoArquivo")
    public List<Arquivo> getArquivos() {
        return arquivos;
    }

    public void setArquivos(List<Arquivo> arquivos) {
        this.arquivos = arquivos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (this.idTipoArquivo != null ? this.idTipoArquivo.hashCode() : 0);
        hash = 37 * hash + (this.descricao != null ? this.descricao.hashCode() : 0);
        hash = 37 * hash + (this.arquivos != null ? this.arquivos.hashCode() : 0);
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
        final TipoArquivo other = (TipoArquivo) obj;
        if (this.idTipoArquivo != other.idTipoArquivo && (this.idTipoArquivo == null || !this.idTipoArquivo.equals(other.idTipoArquivo))) {
            return false;
        }
        if ((this.descricao == null) ? (other.descricao != null) : !this.descricao.equals(other.descricao)) {
            return false;
        }
        if (this.arquivos != other.arquivos && (this.arquivos == null || !this.arquivos.equals(other.arquivos))) {
            return false;
        }
        return true;
    }

}
