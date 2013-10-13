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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "caixa_arquivo", catalog = "arquivomorto_db", joinColumns = {
        @JoinColumn(name = "id_caixa", nullable = false, updatable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "id_arquivo", nullable = false, updatable = false)})
    public List<Arquivo> getArquivos() {
        return this.arquivos;
    }

    public void setArquivos(List<Arquivo> arquivos) {
        this.arquivos = arquivos;
    }
}
