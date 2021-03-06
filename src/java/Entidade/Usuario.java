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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.envers.Audited;

/**
 * @author Bruno
 */
@Audited
@Entity
@Table(name = "usuario", catalog = "arquivomorto_db")
public class Usuario implements java.io.Serializable {

    private Integer idUsuario;
    private Setor setor;
    private String nomeUsuario;
    private String senhaUsuario;
    private boolean statusUsuario;
    private List<Permissao> permissaos = new ArrayList<Permissao>();

    public Usuario() {
    }

    public Usuario(Setor setor, String nomeUsuario, String senhaUsuario, boolean statusUsuario) {
        this.setor = setor;
        this.nomeUsuario = nomeUsuario;
        this.senhaUsuario = senhaUsuario;
        this.statusUsuario = statusUsuario;
    }

    public Usuario(Setor setor, String nomeUsuario, String senhaUsuario, boolean statusUsuario, List<Permissao> permissaos) {
        this.setor = setor;
        this.nomeUsuario = nomeUsuario;
        this.senhaUsuario = senhaUsuario;
        this.statusUsuario = statusUsuario;
        this.permissaos = permissaos;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_usuario", unique = true, nullable = false)
    public Integer getIdUsuario() {
        return this.idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_setor", nullable = false)
    public Setor getSetor() {
        return this.setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    @Column(name = "nome_usuario", nullable = false, length = 150, unique = true)
    public String getNomeUsuario() {
        return this.nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    @Column(name = "senha_usuario", nullable = false, length = 150)
    public String getSenhaUsuario() {
        return this.senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    @Column(name = "status_usuario", nullable = false)
    public boolean isStatusUsuario() {
        return this.statusUsuario;
    }

    public void setStatusUsuario(boolean statusUsuario) {
        this.statusUsuario = statusUsuario;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "usuario_permissao", catalog = "arquivomorto_db", joinColumns = {
        @JoinColumn(name = "id_usuario", nullable = false, updatable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "nome_permissao", nullable = false, updatable = false)})
    public List<Permissao> getPermissaos() {
        return this.permissaos;
    }

    public void setPermissaos(List<Permissao> permissaos) {
        this.permissaos = permissaos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (this.idUsuario != null ? this.idUsuario.hashCode() : 0);
        hash = 17 * hash + (this.setor != null ? this.setor.hashCode() : 0);
        hash = 17 * hash + (this.nomeUsuario != null ? this.nomeUsuario.hashCode() : 0);
        hash = 17 * hash + (this.senhaUsuario != null ? this.senhaUsuario.hashCode() : 0);
        hash = 17 * hash + (this.statusUsuario ? 1 : 0);
        hash = 17 * hash + (this.permissaos != null ? this.permissaos.hashCode() : 0);
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
        final Usuario other = (Usuario) obj;
        if (this.idUsuario != other.idUsuario && (this.idUsuario == null || !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        if (this.setor != other.setor && (this.setor == null || !this.setor.equals(other.setor))) {
            return false;
        }
        if ((this.nomeUsuario == null) ? (other.nomeUsuario != null) : !this.nomeUsuario.equals(other.nomeUsuario)) {
            return false;
        }
        if ((this.senhaUsuario == null) ? (other.senhaUsuario != null) : !this.senhaUsuario.equals(other.senhaUsuario)) {
            return false;
        }
        if (this.statusUsuario != other.statusUsuario) {
            return false;
        }
        if (this.permissaos != other.permissaos && (this.permissaos == null || !this.permissaos.equals(other.permissaos))) {
            return false;
        }
        return true;
    }
}
