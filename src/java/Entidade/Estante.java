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
import org.hibernate.envers.Audited;

/**
 * @autor Bruno
 */
@Audited
@Entity
@Table(name = "estante", catalog = "arquivomorto_db")
public class Estante implements java.io.Serializable {

    private Integer idEstante;
    private Sala sala;
    private String nomeEstante;
    private List<Prateleira> prateleiras = new ArrayList<Prateleira>();

    public Estante() {
    }

    public Estante(Sala sala, String nomeEstante) {
        this.sala = sala;
        this.nomeEstante = nomeEstante;
    }

    public Estante(Sala sala, String nomeEstante, List<Prateleira> prateleiras) {
        this.sala = sala;
        this.nomeEstante = nomeEstante;
        this.prateleiras = prateleiras;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_estante", unique = true, nullable = false)
    public Integer getIdEstante() {
        return this.idEstante;
    }

    public void setIdEstante(Integer idEstante) {
        this.idEstante = idEstante;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sala", nullable = false)
    public Sala getSala() {
        return this.sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    @Column(name = "nome_estante", nullable = false, length = 150)
    public String getNomeEstante() {
        return this.nomeEstante;
    }

    public void setNomeEstante(String nomeEstante) {
        this.nomeEstante = nomeEstante;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "estante")
    public List<Prateleira> getPrateleiras() {
        return this.prateleiras;
    }

    public void setPrateleiras(List<Prateleira> prateleiras) {
        this.prateleiras = prateleiras;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + (this.idEstante != null ? this.idEstante.hashCode() : 0);
        hash = 41 * hash + (this.sala != null ? this.sala.hashCode() : 0);
        hash = 41 * hash + (this.nomeEstante != null ? this.nomeEstante.hashCode() : 0);
        hash = 41 * hash + (this.prateleiras != null ? this.prateleiras.hashCode() : 0);
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
        final Estante other = (Estante) obj;
        if (this.idEstante != other.idEstante && (this.idEstante == null || !this.idEstante.equals(other.idEstante))) {
            return false;
        }
        if (this.sala != other.sala && (this.sala == null || !this.sala.equals(other.sala))) {
            return false;
        }
        if ((this.nomeEstante == null) ? (other.nomeEstante != null) : !this.nomeEstante.equals(other.nomeEstante)) {
            return false;
        }
        if (this.prateleiras != other.prateleiras && (this.prateleiras == null || !this.prateleiras.equals(other.prateleiras))) {
            return false;
        }
        return true;
    }
}
