package Entidade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Bruno
 */
@Entity
@Table(name = "caixa", catalog = "arquivomorto_db")
public class Caixa implements java.io.Serializable {

    private Integer idCaixa;
    private Prateleira prateleira;
    private Setor setor;
    private String nomeCaixa;
    private Date prazoArquivamentoCaixa;
    private Date dataArquivamentoCaixa;
    private List<Arquivo> arquivos = new ArrayList<Arquivo>();

    public Caixa() {
    }

    public Caixa(Prateleira prateleira, Setor setor, String nomeCaixa, Date prazoArquivamentoCaixa, Date dataArquivamentoCaixa) {
        this.prateleira = prateleira;
        this.setor = setor;
        this.nomeCaixa = nomeCaixa;
        this.prazoArquivamentoCaixa = prazoArquivamentoCaixa;
        this.dataArquivamentoCaixa = dataArquivamentoCaixa;
    }

    public Caixa(Prateleira prateleira, Setor setor, String nomeCaixa, Date prazoArquivamentoCaixa, Date dataArquivamentoCaixa, List<Arquivo> arquivos) {
        this.prateleira = prateleira;
        this.setor = setor;
        this.nomeCaixa = nomeCaixa;
        this.prazoArquivamentoCaixa = prazoArquivamentoCaixa;
        this.dataArquivamentoCaixa = dataArquivamentoCaixa;
        this.arquivos = arquivos;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_caixa", unique = true, nullable = false)
    public Integer getIdCaixa() {
        return this.idCaixa;
    }

    public void setIdCaixa(Integer idCaixa) {
        this.idCaixa = idCaixa;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_prateleira", nullable = false)
    public Prateleira getPrateleira() {
        return this.prateleira;
    }

    public void setPrateleira(Prateleira prateleira) {
        this.prateleira = prateleira;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_setor", nullable = false)
    public Setor getSetor() {
        return this.setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    @Column(name = "nome_caixa", nullable = false, length = 150)
    public String getNomeCaixa() {
        return this.nomeCaixa;
    }

    public void setNomeCaixa(String nomeCaixa) {
        this.nomeCaixa = nomeCaixa;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "prazo_arquivamento_caixa", nullable = false, length = 10)
    public Date getPrazoArquivamentoCaixa() {
        return this.prazoArquivamentoCaixa;
    }

    public void setPrazoArquivamentoCaixa(Date prazoArquivamentoCaixa) {
        this.prazoArquivamentoCaixa = prazoArquivamentoCaixa;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "data_arquivamento_caixa", nullable = false, length = 10)
    public Date getDataArquivamentoCaixa() {
        return this.dataArquivamentoCaixa;
    }

    public void setDataArquivamentoCaixa(Date dataArquivamentoCaixa) {
        this.dataArquivamentoCaixa = dataArquivamentoCaixa;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "caixa")
    public List<Arquivo> getArquivos() {
        return this.arquivos;
    }

    public void setArquivos(List<Arquivo> arquivos) {
        this.arquivos = arquivos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.idCaixa != null ? this.idCaixa.hashCode() : 0);
        hash = 97 * hash + (this.prateleira != null ? this.prateleira.hashCode() : 0);
        hash = 97 * hash + (this.setor != null ? this.setor.hashCode() : 0);
        hash = 97 * hash + (this.nomeCaixa != null ? this.nomeCaixa.hashCode() : 0);
        hash = 97 * hash + (this.prazoArquivamentoCaixa != null ? this.prazoArquivamentoCaixa.hashCode() : 0);
        hash = 97 * hash + (this.dataArquivamentoCaixa != null ? this.dataArquivamentoCaixa.hashCode() : 0);
        hash = 97 * hash + (this.arquivos != null ? this.arquivos.hashCode() : 0);
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
        final Caixa other = (Caixa) obj;
        if (this.idCaixa != other.idCaixa && (this.idCaixa == null || !this.idCaixa.equals(other.idCaixa))) {
            return false;
        }
        if (this.prateleira != other.prateleira && (this.prateleira == null || !this.prateleira.equals(other.prateleira))) {
            return false;
        }
        if (this.setor != other.setor && (this.setor == null || !this.setor.equals(other.setor))) {
            return false;
        }
        if ((this.nomeCaixa == null) ? (other.nomeCaixa != null) : !this.nomeCaixa.equals(other.nomeCaixa)) {
            return false;
        }
        if (this.prazoArquivamentoCaixa != other.prazoArquivamentoCaixa && (this.prazoArquivamentoCaixa == null || !this.prazoArquivamentoCaixa.equals(other.prazoArquivamentoCaixa))) {
            return false;
        }
        if (this.dataArquivamentoCaixa != other.dataArquivamentoCaixa && (this.dataArquivamentoCaixa == null || !this.dataArquivamentoCaixa.equals(other.dataArquivamentoCaixa))) {
            return false;
        }
        if (this.arquivos != other.arquivos && (this.arquivos == null || !this.arquivos.equals(other.arquivos))) {
            return false;
        }
        return true;
    }

}
