package Entidade;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @autor Bruno
 */
@Entity
@Table(name = "permissao", catalog = "arquivomorto_db")
public class Permissao implements java.io.Serializable {

    private String nomePermissao;
    private List<Usuario> usuarios = new ArrayList<Usuario>();

    public Permissao() {
    }

    public Permissao(String nomePermissao) {
        this.nomePermissao = nomePermissao;
    }

    public Permissao(String nomePermissao, List<Usuario> usuarios) {
        this.nomePermissao = nomePermissao;
        this.usuarios = usuarios;
    }

    @Id
    @Column(name = "nome_permissao", unique = true, nullable = false, length = 150)
    public String getNomePermissao() {
        return this.nomePermissao;
    }

    public void setNomePermissao(String nomePermissao) {
        this.nomePermissao = nomePermissao;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "permissaos")
    public List<Usuario> getUsuarios() {
        return this.usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + (this.nomePermissao != null ? this.nomePermissao.hashCode() : 0);
        hash = 71 * hash + (this.usuarios != null ? this.usuarios.hashCode() : 0);
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
        final Permissao other = (Permissao) obj;
        if ((this.nomePermissao == null) ? (other.nomePermissao != null) : !this.nomePermissao.equals(other.nomePermissao)) {
            return false;
        }
        if (this.usuarios != other.usuarios && (this.usuarios == null || !this.usuarios.equals(other.usuarios))) {
            return false;
        }
        return true;
    }
}
