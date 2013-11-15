package Auditoria;

import java.util.Date;
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
@RevisionEntity(CustomListener.class)
@Table(name = "revinfo")
public class InformacaoRevisao extends DefaultRevisionEntity{
    
    private static final long serialVersionUID = 1L;
    
    private String username;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataAlteracao;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(Date dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }
    
    
}
