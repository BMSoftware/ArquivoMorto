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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Bruno
 */
@Entity
@Table(name = "predio", catalog = "arquivomorto_db")
public class Predio implements java.io.Serializable {

    private Integer idPredio;
    private String nomePredio;
    private List<Sala> salas = new ArrayList<Sala>();

    public Predio() {
    }

    public Predio(String nomePredio) {
        this.nomePredio = nomePredio;
    }

    public Predio(String nomePredio, List<Sala> salas) {
        this.nomePredio = nomePredio;
        this.salas = salas;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_predio", unique = true, nullable = false)
    public Integer getIdPredio() {
        return this.idPredio;
    }

    public void setIdPredio(Integer idPredio) {
        this.idPredio = idPredio;
    }

    @Column(name = "nome_predio", nullable = false, length = 450)
    public String getNomePredio() {
        return this.nomePredio;
    }

    public void setNomePredio(String nomePredio) {
        this.nomePredio = nomePredio;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "predio")
    public List<Sala> getSalas() {
        return this.salas;
    }

    public void setSalas(List<Sala> salas) {
        this.salas = salas;
    }
}
