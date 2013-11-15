package Auditoria;

import java.util.Date;
import org.hibernate.envers.RevisionListener;

/**
 *
 * @author Bruno
 */
public class CustomListener implements RevisionListener {

    @Override
    public void newRevision(Object revisionEntity) {
        InformacaoRevisao rev = (InformacaoRevisao) revisionEntity;
        rev.setDataAlteracao(new Date());
        //rev.setUsername();
    }

}
