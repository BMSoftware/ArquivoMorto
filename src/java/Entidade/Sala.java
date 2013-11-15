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
@Table(name = "sala", catalog = "arquivomorto_db")
public class Sala implements java.io.Serializable {

    private Integer idSala;
    private Predio predio;
    private int numeroSala;
    private String andarSala;
    private List<Estante> estantes = new ArrayList<Estante>();

    public Sala() {
    }

    public Sala(Predio predio, int numeroSala) {
        this.predio = predio;
        this.numeroSala = numeroSala;
    }

    public Sala(Predio predio, int numeroSala, String andarSala, List<Estante> estantes) {
        this.predio = predio;
        this.numeroSala = numeroSala;
        this.andarSala = andarSala;
        this.estantes = estantes;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_sala", unique = true, nullable = false)
    public Integer getIdSala() {
        return this.idSala;
    }

    public void setIdSala(Integer idSala) {
        this.idSala = idSala;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_predio", nullable = false)
    public Predio getPredio() {
        return this.predio;
    }

    public void setPredio(Predio predio) {
        this.predio = predio;
    }

    @Column(name = "numero_sala", nullable = false)
    public int getNumeroSala() {
        return this.numeroSala;
    }

    public void setNumeroSala(int numeroSala) {
        this.numeroSala = numeroSala;
    }

    @Column(name = "andar_sala", length = 150)
    public String getAndarSala() {
        return this.andarSala;
    }

    public void setAndarSala(String andarSala) {
        this.andarSala = andarSala;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sala")
    public List<Estante> getEstantes() {
        return this.estantes;
    }

    public void setEstantes(List<Estante> estantes) {
        this.estantes = estantes;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (this.idSala != null ? this.idSala.hashCode() : 0);
        hash = 17 * hash + (this.predio != null ? this.predio.hashCode() : 0);
        hash = 17 * hash + this.numeroSala;
        hash = 17 * hash + (this.andarSala != null ? this.andarSala.hashCode() : 0);
        hash = 17 * hash + (this.estantes != null ? this.estantes.hashCode() : 0);
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
        final Sala other = (Sala) obj;
        if (this.idSala != other.idSala && (this.idSala == null || !this.idSala.equals(other.idSala))) {
            return false;
        }
        if (this.predio != other.predio && (this.predio == null || !this.predio.equals(other.predio))) {
            return false;
        }
        if (this.numeroSala != other.numeroSala) {
            return false;
        }
        if ((this.andarSala == null) ? (other.andarSala != null) : !this.andarSala.equals(other.andarSala)) {
            return false;
        }
        if (this.estantes != other.estantes && (this.estantes == null || !this.estantes.equals(other.estantes))) {
            return false;
        }
        return true;
    }
}
