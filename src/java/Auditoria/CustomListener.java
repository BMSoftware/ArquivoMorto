package Auditoria;

import Beans.ContextoBean;
import Util.ContextoUtil;
import java.util.Date;
import org.hibernate.envers.RevisionListener;

/**
 *
 * @author Bruno
 */
public class CustomListener implements RevisionListener {

    @Override
    public void newRevision(Object revisionEntity) {
        InformacaoRevisao infoRev = (InformacaoRevisao) revisionEntity;
        infoRev.setDataAlteracao(new Date());
        ContextoBean contextoBean = ContextoUtil.getContextoBean();
        String nomeUsuario = contextoBean.getUsuarioLogado().getNomeUsuario();
        infoRev.setNomeUsuario(nomeUsuario);
    }

}
