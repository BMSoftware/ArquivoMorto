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
import org.hibernate.envers.Audited;

/**
 * @author Bruno
 */
@Audited
@Entity
@Table(name = "setor", catalog = "arquivomorto_db")
public class Setor implements java.io.Serializable {

    private Integer idSetor;
    private String nomeSetor;
    private List<Caixa> caixas = new ArrayList<Caixa>();
    private List<Usuario> usuarios = new ArrayList<Usuario>();

    public Setor() {
    }

    public Setor(String nomeSetor) {
        this.nomeSetor = nomeSetor;
    }

    public Setor(String nomeSetor, List<Caixa> caixas, List<Usuario> usuarios) {
        this.nomeSetor = nomeSetor;
        this.caixas = caixas;
        this.usuarios = usuarios;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_setor", unique = true, nullable = false)
    public Integer getIdSetor() {
        return this.idSetor;
    }

    public void setIdSetor(Integer idSetor) {
        this.idSetor = idSetor;
    }

    @Column(name = "nome_setor", nullable = false, length = 150)
    public String getNomeSetor() {
        return this.nomeSetor;
    }

    public void setNomeSetor(String nomeSetor) {
        this.nomeSetor = nomeSetor;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "setor")
    public List<Caixa> getCaixas() {
        return this.caixas;
    }

    public void setCaixas(List<Caixa> caixas) {
        this.caixas = caixas;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "setor")
    public List<Usuario> getUsuarios() {
        return this.usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (this.idSetor != null ? this.idSetor.hashCode() : 0);
        hash = 37 * hash + (this.nomeSetor != null ? this.nomeSetor.hashCode() : 0);
        hash = 37 * hash + (this.caixas != null ? this.caixas.hashCode() : 0);
        hash = 37 * hash + (this.usuarios != null ? this.usuarios.hashCode() : 0);
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
        final Setor other = (Setor) obj;
        if (this.idSetor != other.idSetor && (this.idSetor == null || !this.idSetor.equals(other.idSetor))) {
            return false;
        }
        if ((this.nomeSetor == null) ? (other.nomeSetor != null) : !this.nomeSetor.equals(other.nomeSetor)) {
            return false;
        }
        if (this.caixas != other.caixas && (this.caixas == null || !this.caixas.equals(other.caixas))) {
            return false;
        }
        if (this.usuarios != other.usuarios && (this.usuarios == null || !this.usuarios.equals(other.usuarios))) {
            return false;
        }
        return true;
    }
}
