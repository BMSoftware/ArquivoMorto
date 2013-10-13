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
}
