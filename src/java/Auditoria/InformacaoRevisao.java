package Auditoria;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;

/**
 *
 * @author Bruno
 */
@Entity
@Table(name = "REVISION_ENTITY")
@RevisionEntity(CustomListener.class)
public class InformacaoRevisao extends DefaultRevisionEntity {

    private static final long serialVersionUID = 1L;
   
    @Column(name = "usuario")
    private String nomeUsuario;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataAlteracao;

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public Date getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(Date dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }
}
