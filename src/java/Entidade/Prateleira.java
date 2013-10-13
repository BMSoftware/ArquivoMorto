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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Bruno
 */
@Entity
@Table(name = "prateleira", catalog = "arquivomorto_db")
public class Prateleira implements java.io.Serializable {

    private Integer idPrateleira;
    private Estante estante;
    private String nomePrateleira;
    private List<Caixa> caixas = new ArrayList<Caixa>();

    public Prateleira() {
    }

    public Prateleira(Estante estante, String nomePrateleira) {
        this.estante = estante;
        this.nomePrateleira = nomePrateleira;
    }

    public Prateleira(Estante estante, String nomePrateleira, List<Caixa> caixas) {
        this.estante = estante;
        this.nomePrateleira = nomePrateleira;
        this.caixas = caixas;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_prateleira", unique = true, nullable = false)
    public Integer getIdPrateleira() {
        return this.idPrateleira;
    }

    public void setIdPrateleira(Integer idPrateleira) {
        this.idPrateleira = idPrateleira;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estante", nullable = false)
    public Estante getEstante() {
        return this.estante;
    }

    public void setEstante(Estante estante) {
        this.estante = estante;
    }

    @Column(name = "nome_prateleira", nullable = false, length = 150)
    public String getNomePrateleira() {
        return this.nomePrateleira;
    }

    public void setNomePrateleira(String nomePrateleira) {
        this.nomePrateleira = nomePrateleira;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "prateleira")
    public List<Caixa> getCaixas() {
        return this.caixas;
    }

    public void setCaixas(List<Caixa> caixas) {
        this.caixas = caixas;
    }
}
