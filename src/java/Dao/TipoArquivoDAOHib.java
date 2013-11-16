package Dao;

import Entidade.TipoArquivo;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Bruno
 */
public class TipoArquivoDAOHib implements TipoArquivoDAO {

    private Session session;

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public void salvar(TipoArquivo tipoArquivo) {
        this.session.save(tipoArquivo);
    }

    @Override
    public void atualizar(TipoArquivo tipoArquivo) {
        this.session.update(tipoArquivo);
    }

    @Override
    public void excluir(TipoArquivo tipoArquivo) {
        this.session.delete(tipoArquivo);
    }

    @Override
    public TipoArquivo getTipoArquivo(Integer idTipoArquivo) {
        return (TipoArquivo) this.session.get(TipoArquivo.class, idTipoArquivo);
    }

    @Override
    public List<TipoArquivo> list() {
        return this.session.createCriteria(TipoArquivo.class).list();
    }

}
