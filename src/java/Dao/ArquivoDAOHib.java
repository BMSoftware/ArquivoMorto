package Dao;

import Entidade.Arquivo;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Bruno
 */
public class ArquivoDAOHib implements ArquivoDAO {

    private Session session;

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public void salvar(Arquivo arquivo) {
        this.session.save(arquivo);
    }

    @Override
    public void atualizar(Arquivo arquivo) {
        this.session.update(arquivo);
    }

    @Override
    public void excluir(Arquivo arquivo) {
        this.session.delete(arquivo);
    }

    @Override
    public Arquivo getArquivo(Integer idArquivo) {
        return (Arquivo) this.session.get(Arquivo.class, idArquivo);
    }

    @Override
    public List<Arquivo> list() {
        return this.session.createCriteria(Arquivo.class).list();
    }
}
